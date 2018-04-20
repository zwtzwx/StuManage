package com.zwt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zwt.model.*;


@WebServlet("/ChoiceServlet")
public class ChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ChoiceServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		//���index.jsp��Ҫѡ��Ĳ���
		String choice = request.getParameter("choice");
		if(choice != null) {
			request.setAttribute("choice", choice);
			
		}
		//��þ���Ĳ�����addStu��uptStu��delStu��searchStu
		String type = request.getParameter("type");
		StudentCL scl = new StudentCL();
		if(type != null) {
			if(type.equals("addStu")) {
				//���ѧ����Ϣ
				String sno = request.getParameter("sno");
				String sname = request.getParameter("sname");
				int age = Integer.parseInt(request.getParameter("age"));
				String sex = request.getParameter("sex");
				int sclass = Integer.parseInt(request.getParameter("sclass"));
				String grade = request.getParameter("grade");
				String dept = request.getParameter("dept");
				
				Student stu = new Student();
				stu.setSno(sno);
				stu.setSname(sname);
				stu.setAge(age);
				stu.setSsex(sex);
				stu.setSclass(sclass);
				stu.setGrade(grade);
				stu.setDept(dept);
				
				if(scl.addStu(stu)) {
					//���ѧ���ɹ�
					request.setAttribute("addStu", "yes");
				}else {
					//���ʧ��
					request.setAttribute("addStu", "no");
				}
			}
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
