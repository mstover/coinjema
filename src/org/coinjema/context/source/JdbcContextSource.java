package org.coinjema.context.source;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;

import javax.sql.DataSource;

/**
 * Retrieves configuration data from a database, given a DataSource from which to get 
 * Connection objects.  The name of the table to talk to can be given as well.
 * 
 *  The Database table's structure needs to be as follows:
 *  name (string): the name of the context represented by the row.  The first context path name is "root".
 *  data (long string): script file that represents the configuration data.
 *  resource (String): name of the resource (like filename).
 *  resource_type (String): type of resource (like file extension).
 *  metatypes (String, comma separated) : list of metatypes to apply to the resource.
 * @author mstover
 *
 */
public class JdbcContextSource implements ContextSource {
	DataSource db;
	String table = "coinjema_context";
	String name = "root",rawName = "root";
	
	String subContextQuery;

	public JdbcContextSource(DataSource db) {
		this.db = db;
	}
	
	public JdbcContextSource(DataSource db,String table) {
		this(db);
		this.table = table;
	}
	
	public JdbcContextSource(DataSource db,String table,String name)
	{
		this(db,table);
		this.name = name.indexOf("/") > -1 ? name.substring(name.lastIndexOf("/")+1) : name;
		this.rawName = name;
	}

	public Collection<ContextSource> getSubContexts() {
		if(subContextQuery == null) prepareSubContextQuery();
		Collection<ContextSource> children = new LinkedList<ContextSource>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(subContextQuery);
			while(rs.next())
			{
				String fullName = rs.getString(1);
				if(fullName.substring(rawName.length()+1).indexOf("/") == -1)
					children.add(new JdbcContextSource(db,table,fullName));
			}
		} catch (SQLException e) {
			throw new RuntimeException("Can't query database for contexts",e);
		} finally
		{
			closeDbResources(conn, st, rs);
		}		
		return children;
	}

	public String getName() {
		return name;
	}
	
	private void prepareSubContextQuery()
	{
		subContextQuery = "select name from " + table + " where name LIKE '" + rawName + "/%'";
	}

	public Resource getResource(String resourceName, String extension) {
		Resource res = new JdbcResource(db,table,rawName,resourceName);
		if(extension.equals(res.getFormat())) return res;
		else return null;
	}

	public Resource getResource(String resourceName) {
		Resource res = new JdbcResource(db,table,rawName,resourceName);
		if(res.getFormat() != null) return res;
		else return null;
	}

	static void closeDbResources(Connection conn, Statement st, ResultSet rs) {
		Collection<Exception> errors = null;
		try {
			if(rs != null) rs.close();
		} catch (Exception e) {
			if(errors == null) errors = new LinkedList<Exception>();
			errors.add(e);
		}
		try {
			if(st != null) st.close();
		} catch (Exception e) {
			if(errors == null) errors = new LinkedList<Exception>();
			errors.add(e);
		}
		try {
			if(conn != null) conn.close();
		} catch (Exception e) {
			if(errors == null) errors = new LinkedList<Exception>();
			errors.add(e);
		}
		if(errors != null) throw new RuntimeException("Couldn't close database resources",errors.iterator().next());
	}

}
