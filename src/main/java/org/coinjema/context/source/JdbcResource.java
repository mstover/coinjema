package org.coinjema.context.source;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

public class JdbcResource implements Resource {
	DataSource datasource;
	String table;
	String context;
	String name;
	String[] data;
	
	public JdbcResource(DataSource ds,String tablename,String contextName,String resourceName)
	{
		datasource = ds;
		table = tablename;
		context = contextName;
		name = resourceName;
	}

	public String getFormat() {
		getData();
		if(data == null || data[1] == null) return null;
		else return data[1];
	}

	public Collection<MetaType> getMetaTypes() {
		getData();
		Set<MetaType> types = new HashSet<MetaType>();
		if(data[2] != null)
		{
			for(String mt : data[2].split(","))
			{
				MetaType meta = MetaType.valueOf(mt);
				if(meta != null) types.add(meta);
			}
		}
		return types;
	}

	public String getName() {
		return name;
	}

	public Reader getReader() {
		getData();
		if(data != null) return new StringReader(data[0]);
		return null;
	}

	public InputStream getInputStream() {
		getData();
		try
		{
			if(data != null) return new ByteArrayInputStream(data[0].getBytes("utf-8"));
		} catch(Exception e)
		{
			throw new RuntimeException("System doesn't handle utf-8 character set",e);
		}
		return null;
	}

	private void getData() {
		if(data == null)
		{
			String query = prepareResourceQuery();
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			try {
				conn = datasource.getConnection();
				st = conn.createStatement();
				rs = st.executeQuery(query);
				if(rs.next())
				{
					data = new String[]{rs.getString(1),rs.getString(2),rs.getString(3)};
				}
			} catch (SQLException e) {
				throw new RuntimeException("Can't query database for contexts",e);
			} finally
			{
				JdbcContextSource.closeDbResources(conn, st, rs);
			}		
		}
	}
	
	private String prepareResourceQuery()
	{
		return "select data,resource_type,metatypes from " + table + " where name = '" + context + "'" + 
					" and resource = '"+name+"'";
	}

}
