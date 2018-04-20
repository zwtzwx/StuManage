<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/addStu.css">
		<script>
			function checkStu() {
				var b = true;
				var sno = ucform.sno.value;
				var sname = ucform.sname.value;
				var sclass = ucform.sclass.value;
				var grade = ucform.grade.value;
				var dept = ucform.dept.value;
				var age = ucform.age.value;
				if(sno.length==0 ) {
					alert("学号不能为空");
					b = false;
				}
				if(sname.length==0) {
					alert("姓名不能为空");
					b = false;
				}
				if(sclass.length==0) {
					alert("班级不能为空");
					b = false;
				}
				if(grade.length==0) {
					alert("年级不能为空");
					b = false;
				}
				if(dept.length==0) {
					alert("系别不能为空");
				}
				if(age <= 0 ||age.length==0) {
					alert("年龄不合理");
					b = false;
				}
				return b;
			}
		</script>
	</head>
	<body>
		<div id="uc">
			<form action="ChoiceServlet?type=addStu&choice=addStu" method="post" name="ucform">
				学号：<input type="text" class="ipt" name="sno"/><br /><br/>
				姓名：<input type="text" class="ipt" name="sname"  placeholder="请输入真实姓名" /><br/><br/>
				年龄：<input type="number" class="ipt" name="age" /><br /><br/>
				性别：<input type="radio" name="sex" value="男" checked>男
					  &nbsp;&nbsp;<input type="radio"  name="sex" value="女">女<br/><br/>
				班级：<input type="text" class="ipt" name="sclass"/><br /><br/>
				年级：<input type="text" class="ipt" name="grade"/><br /><br/>
				系别：<input type="text" class="ipt" name="dept"/><br /><br/>
				<input type="submit" id="btn" value="提交" onclick="return checkStu();"/>
			</form>
		</div>
	</body>
</html>
