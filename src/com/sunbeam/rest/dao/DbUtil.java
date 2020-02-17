package com.sunbeam.rest.dao;

import java.io.InputStream;
import java.util.Properties;

public class DbUtil {
	public static final Properties props = new Properties();
	static {
		try(InputStream in = DbUtil.class.getResourceAsStream("/jdbc.properties")) {
			props.load(in);
			String driver = props.getProperty("db.mysql.driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String getDbUrl() {
		return props.getProperty("db.mysql.url");
	}
	public static String getDbUser() {
		return props.getProperty("db.mysql.user");
	}
	public static String getDbPassword() {
		return props.getProperty("db.mysql.password");
	}
}
