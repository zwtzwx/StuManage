/*
 * 获得与Mysql数据的连接的类
 */
package com.zwt.model;
import java.sql.*;

public class ConnDB {
	static  Connection conn;
	
	public static Connection getConn() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/student?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
