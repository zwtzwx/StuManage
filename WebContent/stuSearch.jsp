<%@ page language="java" import="com.zwt.model.*,java.util.ArrayList" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String v_pagenow =(String) request.getAttribute("pagenow");
	int pagenow = 1;
	if(v_pagenow != null) {
		pagenow = Integer.parseInt(v_pagenow);
	}
	
	//得到pagecount
	int pagecount = 1;
	String v_pagecount = (String)request.getAttribute("pagecount");
	if(v_pagecount != null) {
		pagecount = Integer.parseInt(v_pagecount);
	}
	//得到ArrayList
	ArrayList<Student> al = (ArrayList<Student>)request.getAttribute("stuArray");
	
	//得到删除信息
	String del = (String)request.getAttribute("delete");
	
	//得到修改信息
	String upt = (String)request.getAttribute("update");
%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>学生信息</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/stu.css">
		<script>
			function del() {
				confirm("是否删除？");
			}
			function upt() {
				confirm("是否修改？");
			}
			function checkSearch() {
				var ipt = document.getElementById("ipt").value;
				if(ipt.length==0) {
					alert("请输入学号/姓名/系别");
					return false;
				}else {
					return true;
				}
			}
			function fenye(pagenow) {
				
				window.open("StuServlet?type=stuSearch&pagenow="+pagenow,"_self");
			}
			
		<%
			if(upt != null && upt.equals("yes")) {
		%>
			alert("修改成功!");
		<%
		}else if(upt != null && upt.equals("no")){
		%>
			alert("修改失败!");
		<%
		}
		%>
		
		<%
			if(del != null && del.equals("yes")) {
		%>
			alert("删除成功!");
		<%
		}else if(del != null && del.equals("no")){
		%>
			alert("删除失败!");
		<%
		}
		%>
		</script>
	</head>
	<body>
		<div id="serach">
			<form action="StuServlet?type=stuSearch&pagenow=1" method="post">
				<input type="text" name="input" id="ipt" class="ipt" placeholder="请输入学号/姓名/系别">&nbsp;&nbsp;
				<button type="submit" class="btn btn-info" onclick="return checkSearch()">查找</button><br/><br/>
			</form>
			
			<a href="index.jsp">返回主页</a>
		</div>
		<div class="tab">
			<table  class="table" cellspacing="0px">
				<tr>
					<th>学号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>班级</th>
					<th>年级</th>
					<th>系别</th>
					<th></th>
					<th></th>
				</tr>
				<%
					if(al != null) {
						for(int i=0; i<al.size(); i++) {
							Student stu = al.get(i);
							
				%>
							<tr>
							<td><%=stu.getSno() %></td>
							<td><%=stu.getSname() %></td>
							<td><%=stu.getSsex() %></td>
							<td><%=stu.getAge() %></td>
							
							<td><%=stu.getSclass() %></td>
							<td><%=stu.getGrade() %></td>
							<td><%=stu.getDept() %></td>
							<td>
								<a href="StuServlet?type=toUPT&sno=<%=stu.getSno() %>" onclick="upt();">修改</a>
							</td>
							<td>
								<a href="StuServlet?type=delStu&sno=<%=stu.getSno() %>" onclick="del();">删除</a>
							</td>
							</tr>	
					<%
						}
					
					%>
					
				
				<%
				}
				%>
				
			</table>
			
			<!-- 显示分页信息 -->
			<%
				if(pagecount != 1 && pagecount!=0) {
			%>
					<div class="btn-group cen">
						<button class="btn btn-primary" onclick="fenye(1)" >第一页</button>
					
			<%
					if(pagenow != 1) {
			%>
						<button class="btn btn-primary" onclick="fenye(<%=pagenow-1 %>)">上一页</button>
			<%
					}
					if(pagenow != pagecount) {
			%>
						<button class="btn btn-primary" onclick="fenye(<%=pagenow+1 %>)">下一页</button>
			<%
					}
			%>
						
						<button class="btn btn-primary" onclick="fenye(<%=pagecount %>)">最后一页</button>
					</div>
			<%
			
				}
			%>
			
			
			
		</div>
	</body>
</html>