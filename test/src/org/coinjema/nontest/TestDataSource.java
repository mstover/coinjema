package org.coinjema.nontest;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.coinjema.context.CoinjemaDependency;
import org.coinjema.context.CoinjemaObject;

@CoinjemaObject
public class TestDataSource implements DataSource {
	DataSource source;

	public TestDataSource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() throws SQLException {
		return source.getConnection();
	}

	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@CoinjemaDependency(alias="datasource")
	public void setDataSource(DataSource ds)
	{
		source = ds;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return source.isWrapperFor(iface);
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		return source.unwrap(iface);
	}

}
