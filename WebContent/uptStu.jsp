<%@ page language="java" import="com.zwt.model.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//得到所要修改的学生信息
	Student stu = (Student)request.getAttribute("student");
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/addStu.css">
		<script>
			function checkStu() {
				var sno = ucform.sno.value;
				var sname = ucform.sname.value;
				var sclass = ucform.sclass.value;
				var sex = ucform.sex.value;
				var grade = ucform.grade.value;
				var dept = ucform.dept.value;
				var age = ucform.age.value;
				
				if(sno.length==0 ) {
					alert("学号不能为空");
				}
				if(sname.length==0) {
					alert("姓名不能为空");
				}
				if(sex.length==0) {
					alert("性别不能为空");
				}
				if(sclass.length==0) {
					alert("班级不能为空");
				}
				if(grade.length==0) {
					alert("年级不能为空");
				}
				if(dept.length==0) {
					alert("系别不能为空");
				}
				if(age.length==0) {
					alert("年龄不能为空");
				}
				if(age <= 0) {
					alert("年龄不合理");
					return false;
				}else {
					return true;
				}
			}
			
		</script>
		<style type="text/css">
			body {
				margin-top:50px;
				margin-left:300px;
				background:url("img/body_bg.gif");
				background-repeat:repeat;
			}
			
		</style>
	</head>
	<body>
		<div id="uc">
			<form action="StuServlet?type=uptStu" method="post" name="ucform">
				学号：<input type="text" class="ipt" value="<%=stu.getSno() %>" name="sno" readonly/><br /><br/>
				姓名：<input type="text" class="ipt" name="sname" value="<%=stu.getSname() %>" placeholder="请输入真实姓名" /><br/><br/>
				年龄：<input type="number" class="ipt" value="<%=stu.getAge() %>" name="age" /><br /><br/>
				性别：<input type="radio" name="sex" id="man" value="男">男
					  &nbsp;&nbsp;<input type="radio" name="sex" id="woman" value="女">女<br/><br/>
				班级：<input type="text" class="ipt" value="<%=stu.getSclass() %>" name="sclass"/><br /><br/>
				年级：<input type="text" class="ipt" value="<%=stu.getGrade() %>" name="grade"/><br /><br/>
				系别：<input type="text" class="ipt" value="<%=stu.getDept() %>" name="dept"/><br /><br/>
				<input type="submit" id="btn" value="修改" onclick="return checkStu()"/>
			</form>
		</div>
		
		<script >
		<%
		if(stu != null) {
			String ssex = stu.getSsex();
			
				if(ssex.equals("男")) {
		%>
					var man = document.getElementById("man");
					man.checked = true;
		<%
				}else {
		%>
					var woman = document.getElementById("woman");
					woman.checked = true;
		<%
				}
			}
		%>
		</script>
	</body>
</html>