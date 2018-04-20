<%@ page language="java" import="com.zwt.model.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<%
	String login = request.getParameter("login");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>用户登录</title>
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<script>
			function checkUser() {
				var userName = document.getElementById("name").value;
				var passwd = document.getElementById("passwd").value;
				var code = document.getElementById("code").value;
				if(userName.length==0) {
					alert("账号不能为空");
					return false;
				}else if(passwd.length==0){
					alert("密码不能为空");
					return false;
				}else if(code.length==0) {
					alert("验证码不能为空");
					return false;
				}
				return true;
			}
			<%
				if(login!=null && login.equals("yp")) {
			%>
				alert("账号或密码错误");
			<%
				}else if(login!=null && login.equals("code")) {
			%>
				alert("验证码错误");
			<%
				}
			%>
			
			
		</script>
	</head>
	<body>
		<div id="main">
			<h1>学生管理系统</h1>
		<form action="UserServlet?type=login" method="post"><!--描述：服务器，脚本所在文件，处理表单数据文件名-->
		<label>账号：&nbsp;&nbsp;</label><input class="a" id="name" type="text" name="userName"  />
		<label>密码：&nbsp;&nbsp;</label><input class="a" id="passwd" type="password" name="passwd" />
		<label>验证码：</label><input class="b" id="code" type="text" name="code"/>&nbsp;&nbsp;
		<img alt="验证码" id="im" src="ImageSerlet">&nbsp;&nbsp;
		<a href="javascript:reloadCode()">看不清</a>
		<input type="submit" id="login" class="btn btn-primary" value="登录" onclick="return checkUser()">
		</form>
		</div>
		
		<script>
		function reloadCode() {
			var time = new Date().getTime();
			document.getElementById("im").src="ImageSerlet?d="+time;
		}
		</script>
	</body>
</html>