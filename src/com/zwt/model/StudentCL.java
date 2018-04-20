package com.zwt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * ����һ��model���û���ѧ������ش���
 * ������ӡ�ɾ�����޸�
 * �Լ���ѯѧ�����ɼ�
 */
public class StudentCL {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private int pagecount;  //��ҳ��
	
	/*
	 * �����ҳ��
	 */
	public int getPagecount(String input,int pagesize) {
		int rowcount =  0;
		try {
			conn = ConnDB.getConn();
			//��ò�ѯ����
			String sql1 = "select count(*) from stu where sno like ? or sname like ? or sdept like ?";
			ps = conn.prepareStatement(sql1);
			ps.setString(1, "%"+input+"%");
			ps.setString(2, "%"+input+"%");
			ps.setString(3, "%"+input+"%");
			rs = ps.executeQuery();
			if(rs.next()) {
				rowcount = rs.getInt(1);
			}
			//����rowcount�õ�pagecount
			if(rowcount%pagesize == 0) {
				pagecount = rowcount/pagesize;
			}else {
				pagecount = rowcount/pagesize+1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			this.close();
		}
		
		
		return pagecount;
	}
	
	/*
	 * ���ѧ��
	 */
	public boolean addStu(Student stu) {
		boolean b = false;
		try {
			//�õ�����
			conn = ConnDB.getConn();
			String sql = "insert into stu values(?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getSno());
			ps.setString(2, stu.getSname());
			ps.setString(3, stu.getSsex());
			ps.setInt(4, stu.getAge());
			ps.setInt(5, stu.getSclass());
			ps.setString(6, stu.getGrade());
			ps.setString(7, stu.getDept());
			
			int num = ps.executeUpdate();
			
			if(num == 1) {
				//���
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			this.close();
		}
		return b;
	}
	
	
	/*
	 * ����ѧ����Ϣ
	 */
	public boolean updateStu(String sno,String sname,String ssex,int sage,int sclass,String sgrade,String sdept) {
		boolean b = false;
		try {
			//�õ�����
			conn = ConnDB.getConn();
			String sql = "update stu set sname=?,ssex=?,sage=?,sclass=?,sgrade=?,sdept=? where sno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sname);
			ps.setString(2, ssex);
			ps.setInt(3, sage);
			ps.setInt(4, sclass);
			ps.setString(5, sgrade);
			ps.setString(6, sdept);
			ps.setString(7, sno);
			int num = -1;
			num = ps.executeUpdate();
			if(num != -1) {
				//���³ɹ�
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			this.close();
		}
		return b;
	}
	
	/*
	 * ɾ��ѧ����Ϣ
	 */
	public boolean deleteStu(String sno) {
		boolean b = false;
		try {
			conn = ConnDB.getConn();
			String sql = "delete from stu where sno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			int num = ps.executeUpdate();
			if(num == 1) {
				//ɾ���ɹ�
				b = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return b;
	}
	
	
	/*
	 * ����sno���ѧ����Ϣ
	 */
	public Student getStu(String sno) {
		Student stu = new Student();
		try {
			
			conn = ConnDB.getConn();
			String sql = "select * from stu where sno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			rs = ps.executeQuery();
			if(rs.next()) {
				stu.setSno(sno);
				stu.setSname(rs.getString(2));
				stu.setSsex(rs.getString(3));
				stu.setAge(rs.getInt(4));
				stu.setSclass(rs.getInt(5));
				stu.setGrade(rs.getString(6));
				stu.setDept(rs.getString(7));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.close();
		}
		return stu;
	}
	
	public ArrayList<Student> getStudent(String input,int pagesize,int pagenow) {
		ArrayList<Student> al = new ArrayList<Student>();
		
		try {
			
			conn = ConnDB.getConn();
			String sql = "select * from stu where sno like ? or sname like ? or sdept like ? "
					+ "order by sno limit ?,?";
			ps = conn.prepareStatement(sql);
			ps .setString(1, "%"+input+"%");
			ps.setString(2, "%"+input+"%");
			ps.setString(3, "%"+input+"%");
			ps.setInt(4, (pagenow-1)*pagesize);
			ps.setInt(5, pagesize);
			
			//�õ������
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Student stu = new Student();
				stu.setSno(rs.getString(1));
				stu.setSname(rs.getString(2));
				stu.setSsex(rs.getString(3));
				stu.setAge(rs.getInt(4));
				stu.setSclass(rs.getInt(5));
				stu.setGrade(rs.getString(6));
				stu.setDept(rs.getString(7));
				
				al.add(stu);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			this.close();
		}
		return al;
	}
	
	/*
	 * �ر������Դ
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
