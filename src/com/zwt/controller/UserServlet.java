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
		
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		
		//获取要操作的类型
		String type = request.getParameter("type");
		if(type.equals("login")) {
			//用户登录
			//获取从Login.jsp传递过来的账号、密码和验证码
			String userName = request.getParameter("userName");
			String passwd = request.getParameter("passwd");
			String code = request.getParameter("code");
			UserCL  uc = new UserCL();
			if(uc.userCheck(userName, passwd)) {
				//用户名和密码正确，然后检查验证码是否正确
				//获取Seesion中存的图片中的验证码
				String picCode = (String)request.getSession().getAttribute("piccode");
				if(code.equals(picCode)) {
					//输入的验证码和图片中的验证码相等
					HttpSession hs = request.getSession();
					hs.setAttribute("user", userName);
					//request.getRequestDispatcher("index.jsp").forward(request, response);
					response.sendRedirect("index.jsp");
				}else {
					//验证码错误，返回登录界面
					request.getRequestDispatcher("Login.jsp?login=code").forward(request, response);
					
				}				
			}else {
				request.getRequestDispatcher("Login.jsp?login=yp").forward(request, response);
			}
		
		}else if(type.equals("relif")) {
			//注销用户
			HttpSession hs = request.getSession();
			//移除session
			hs.removeAttribute("user");
			//回到登陆界面
			response.sendRedirect("Login.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
