package com.zwt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zwt.model.Student;
import com.zwt.model.StudentCL;


@WebServlet("/StuServlet")
public class StuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private static String input;
	private static int pagenow;
   
    public StuServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		StudentCL scl = new StudentCL();
		String type = request.getParameter("type");
		
		if(type != null) {
			
			String v_input = request.getParameter("input");
			if(v_input != null) {
				input = request.getParameter("input");
			}
			String v_pagenow = request.getParameter("pagenow");
			if(v_pagenow != null) {
				pagenow = Integer.parseInt(v_pagenow);
			}
			if(type.equals("stuSearch")) {
				//����ѧ��
				
				//�õ�pagecount
				int pagecount = scl.getPagecount(input,5);
				//�õ�ѧ������
				ArrayList<Student> al = scl.getStudent(input, 5, pagenow);
				
				//���ظ�stuSearch.jsp
				request.setAttribute("pagecount", pagecount+"");
				request.setAttribute("stuArray", al);
				request.setAttribute("pagenow", pagenow+"");
				
				request.getRequestDispatcher("stuSearch.jsp").forward(request, response);
				
			}else if(type.equals("toUPT")) {
				//��ת��ѧ���޸Ľ���:uptStu.jsp
				//����sno�����Ӧ��ѧ����Ϣ
				String sno = request.getParameter("sno");
				Student stu = scl.getStu(sno);
				request.setAttribute("student", stu);
				request.getRequestDispatcher("uptStu.jsp").forward(request, response);
			}else if(type.equals("delStu")) {
				//ɾ��ѧ����Ϣ
				String sno = request.getParameter("sno");
				
				if(scl.deleteStu(sno)) {
					//ɾ���ɹ�
					request.setAttribute("delete", "yes");
				}else {
					//ɾ��ʧ��
					request.setAttribute("delete", "no");
				}
				
				//�õ�pagecount
				int pagecount = scl.getPagecount(input, 5);
				//�õ�ѧ������
				ArrayList<Student> al = scl.getStudent(input, 5, pagenow);
				
				//���ظ�stuSearch.jsp
				request.setAttribute("pagecount", pagecount+"");
				request.setAttribute("stuArray", al);
				
				request.getRequestDispatcher("stuSearch.jsp").forward(request, response);
			}else if(type.equals("uptStu")) {
				//�޸�ѧ����Ϣ
				String sno = request.getParameter("sno");
				String sname = request.getParameter("sname");
				String ssex = request.getParameter("sex");
				int sage = Integer.parseInt(request.getParameter("age"));
				int sclass = Integer.parseInt(request.getParameter("sclass"));
				String sgrade = request.getParameter("grade");
				String sdept = request.getParameter("dept");
				if(scl.updateStu(sno,sname, ssex, sage, sclass, sgrade, sdept)) {
					//�޸ĳɹ�
					request.setAttribute("update", "yes");
				}else {
					//�޸�ʧ��
					request.setAttribute("update", "no");
				}
				
				//������������
				
				//�õ�pagecount
				int pagecount = scl.getPagecount(input, 5);
				//�õ�ѧ������
				ArrayList<Student> al = scl.getStudent(input, 5, pagenow);
				
				//���ظ�stuSearch.jsp
				request.setAttribute("pagecount", pagecount+"");
				request.setAttribute("stuArray", al);
				
				request.getRequestDispatcher("stuSearch.jsp").forward(request, response);
				
			}
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
