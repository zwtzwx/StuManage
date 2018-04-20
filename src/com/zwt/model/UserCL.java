
/*
 * 这是一个处理用户登录的model
 * 
 */
package com.zwt.model;
import java.sql.*;

public class UserCL {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/*
	 * 检查用户名和密码是否匹配
	 */
	public boolean userCheck(String name,String passwd) {
		boolean b = false;
		try {
			//获得与数据库的连接
			conn = ConnDB.getConn();
			String sql = " select passwd from user where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(passwd)) {
					
					//用户名和密码匹配
					b = true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		
		return b;
		
	}
	
	
	/*
	 * 关闭资源
	 */
	public void close() {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(ps != null) {
				ps.close();
				ps = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
