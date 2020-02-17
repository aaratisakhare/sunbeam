package com.sunbeam.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao implements AutoCloseable {
	protected Connection con;
	public void open() throws Exception {
		con = DriverManager.getConnection(
				DbUtil.getDbUrl(), 
				DbUtil.getDbUser(), 
				DbUtil.getDbPassword());
	}
	@Override
	public void close() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
	}
}
