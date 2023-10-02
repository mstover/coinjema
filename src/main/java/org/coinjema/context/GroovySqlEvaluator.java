package org.coinjema.context;
import static org.coinjema.logging.CoinjemaLogger.log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.coinjema.context.source.Resource;

public class GroovySqlEvaluator extends GroovyScriptEvaluator {

	public GroovySqlEvaluator() {
		// TODO Auto-generated constructor stub
	}

	final public Object evaluate(final Resource source, final Map params) {
		String sql = (String)super.evaluate(source,params);
		log.info("Sql = " + sql + " from " + source.getName());
		if(sql != null)
		{
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			try {
				conn = getDataSource().getConnection();
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				return getResult(rs);
			} catch(Exception e)
			{
				e.printStackTrace();
				log.warning("Failed to execute query (" + sql + ")");				
			}finally {
				releaseResources(conn,st,rs);
			}			
		}
		return null;
	}
	
	private Object getResult(ResultSet rs) throws SQLException
	{
		ResultSetMetaData rsm = rs.getMetaData();
		int cols = rsm.getColumnCount();
		if(cols == 1)
		{
			List<Object> vals = new ArrayList<Object>();
			int rows = 0;
			while(rs.next())
			{
				vals.add(rs.getObject(1));
				rows++;
			}
			if(rows == 1)
				return vals.get(0);
			else return vals;
		}
		else
		{
			List<Map<String,Object>> rowData = new ArrayList<Map<String,Object>>();
			Map<String,Object> dataSet = new HashMap<String,Object>();
			int rows = 0;
			while(rs.next())
			{
				for(int i = 1;i <= cols;i++)
				{
					dataSet.put(rsm.getColumnName(i), rs.getObject(i));
				}
				rowData.add(dataSet);
				rows++;				
			}
			if(rows == 1)
				return rowData.get(0);
			else return rowData;
		}
	}
	
	private void releaseResources(Connection conn,Statement st,ResultSet rs)
	{
		try {
			if(rs != null) rs.close();
		} catch(Exception e)
		{
			log.warning("Failed to close result set");
		}
		try {
			if(st != null) st.close();
		} catch(Exception e)
		{
			log.warning("Failed to close statement");
		}
		try {
			if(conn != null) conn.close();
		} catch(Exception e)
		{
			log.warning("Failed to close connection");
		}
	}
	
	@CjmDynamic(alias="coinjema.dataSource",type="dataSource")
	private DataSource getDataSource()
	{
		return null;
	}

}
