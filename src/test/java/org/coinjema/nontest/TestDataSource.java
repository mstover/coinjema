package org.coinjema.nontest;

import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.coinjema.context.CjmDependency;
import org.coinjema.context.CjmObject;

@CjmObject
public class TestDataSource implements DataSource {
	DataSource source;

	public TestDataSource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() throws SQLException {
		return source.getConnection();
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public ConnectionBuilder createConnectionBuilder() throws SQLException {
		return DataSource.super.createConnectionBuilder();
	}

	@Override
	public ShardingKeyBuilder createShardingKeyBuilder() throws SQLException {
		return DataSource.super.createShardingKeyBuilder();
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
	
	@CjmDependency(alias="datasource")
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
