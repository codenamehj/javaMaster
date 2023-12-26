<%@page import="com.yedam.student.vo.Student"%>
<%@page import="com.yedam.student.serviceimpl.StudentServiceImpl"%>
<%@page import="com.yedam.student.service.StudentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentInfo.jsp</title>
</head>
<body>
	<%
		String str = "Hello";
		//내장객체: reuest
		String sno = request.getParameter("sno");
		StudentService dao = new StudentServiceImpl();
		Student std = dao.getStudent(sno);
	%>
	
	<table border = '1'>
	<caption>학생정보</caption>
	<tr>
	<th>학생번호</th><td><%=std.getStudentNo() %></td>
	</tr>
	<tr>
	<th>학생이름</th><td><%=std.getStudentName() %></td>
	</tr>
	<tr>
	<th>영어점수</th><td><%=std.getEngScore() %></td>
	</tr>
	<tr>
	<th>수학점수</th><td><%=std.getMathScore() %></td>
	</tr>
	</table>
</body>
</html>