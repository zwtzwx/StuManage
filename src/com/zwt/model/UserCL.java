
/*
 * ����һ�������û���¼��model
 * 
 */
package com.zwt.model;
import java.sql.*;

public class UserCL {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/*
	 * ����û����������Ƿ�ƥ��
	 */
	public boolean userCheck(String name,String passwd) {
		boolean b = false;
		try {
			//��������ݿ������
			conn = ConnDB.getConn();
			String sql = " select passwd from user where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(passwd)) {
					
					//�û���������ƥ��
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
	 * �ر���Դ
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
