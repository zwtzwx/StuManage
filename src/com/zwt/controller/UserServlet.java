package com.zwt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zwt.model.*;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		
		//��ȡҪ����������
		String type = request.getParameter("type");
		if(type.equals("login")) {
			//�û���¼
			//��ȡ��Login.jsp���ݹ������˺š��������֤��
			String userName = request.getParameter("userName");
			String passwd = request.getParameter("passwd");
			String code = request.getParameter("code");
			UserCL  uc = new UserCL();
			if(uc.userCheck(userName, passwd)) {
				//�û�����������ȷ��Ȼ������֤���Ƿ���ȷ
				//��ȡSeesion�д��ͼƬ�е���֤��
				String picCode = (String)request.getSession().getAttribute("piccode");
				if(code.equals(picCode)) {
					//�������֤���ͼƬ�е���֤�����
					HttpSession hs = request.getSession();
					hs.setAttribute("user", userName);
					//request.getRequestDispatcher("index.jsp").forward(request, response);
					response.sendRedirect("index.jsp");
				}else {
					//��֤����󣬷��ص�¼����
					request.getRequestDispatcher("Login.jsp?login=code").forward(request, response);
					
				}				
			}else {
				request.getRequestDispatcher("Login.jsp?login=yp").forward(request, response);
			}
		
		}else if(type.equals("relif")) {
			//ע���û�
			HttpSession hs = request.getSession();
			//�Ƴ�session
			hs.removeAttribute("user");
			//�ص���½����
			response.sendRedirect("Login.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
