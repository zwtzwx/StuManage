<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	//获取session中保存的登陆用户的用户名
	String userName = (String)request.getSession().getAttribute("user");
	if(userName == null) {
		//session中不存在该用户，是不合法的登陆,强制跳转到登录界面
		response.sendRedirect("Login.jsp");
	}
	
	//获得ChoiceServlet中转发过来的选择页面的type
	String choice = (String)request.getAttribute("choice");
	
	String addStu = (String)request.getAttribute("addStu");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>主页</title>
		<link rel="stylesheet" href="css/index.css">
		
		<script src="js/jquery.js"></script>
		<script>
			$(document).ready(function() {
				$(".level1 > a").next().hide();
				return false;
			})
			<%
				if(addStu != null && addStu.equals("yes")) {
			%>
				alert("添加成功!");
			<%
				}else if(addStu!=null && addStu.equals("no")) {
			%>
				alert("添加失败!");
			<%
				}
			%>
		</script>
	</head>
	<body>
		<div id="header">
			<img src="img/banner_2.jpg" alt="banner">
		</div>
		<div id="menu">
			<ul>
				<li>当前用户：<%=userName %></li>
				<li><a href="UserServlet?type=relif">注销</a></li>
			</ul>
		</div>
		<div id="left">
			<ul >
				<li class="level1" >
					<a href="#" class="bold">&diams;&nbsp;信息查询</a>
					<ul >
						<li ><a href="stuSearch.jsp" class="nob">&nbsp;&nbsp; 查找学生</a></li>
					</ul>
				</li>
				<li class="level1">
					<a href="#" class="bold">&diams;&nbsp;信息管理</a>
					<ul >
						<li ><a href="ChoiceServlet?choice=addStu" class="nob">&nbsp;&nbsp; 添加学生</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div id="right">
			<div id="in">
			<%
				if(choice!=null && choice.equals("addStu")) {
			%>
				<!-- 将scoSearch.jsp(成绩查询)的页面包含进来 -->
				<jsp:include page="addStu.jsp"></jsp:include>
			<%
				}
			%>
				
				
			</div>
		</div>
		
		<script>
			$(".level1 > a").click(function(){
				var $n = $(this).next();
				if($n.is(':visible')) {
					$n.hide();
				}else {
					$n.show();
				}
			})
		</script>
	</body>
</html>
