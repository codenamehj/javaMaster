package com.yedam.student.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.mapper.StudentDAO;
import com.yedam.student.service.StudentService;
import com.yedam.student.serviceimpl.StudentServiceImpl;
import com.yedam.student.vo.Student;

@WebServlet("/getStudentServlet")
public class GetStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url?sno=23-010?sname=홍길동
		resp.setContentType("text/html;charset=utf-8");
		String sno = req.getParameter("sno");

		StudentService dao = new StudentServiceImpl();
		Student std = dao.getStudent(sno);

		String str = "<table border = '1'>";
		str += "<caption>학생정보</caption>";
		str += "<tr><th>학번</th><td>" + std.getStudentNo() + "</td></tr>";
		str += "<tr><th>학생이름</th><td>" + std.getStudentName() + "</td></tr>";
		str += "<tr><th>영어점수</th><td>" + std.getEngScore() + "</td></tr>";
		str += "<tr><th>수학점수</th><td>" + std.getMathScore() + "</td></tr>";
		str += "</table>";
		str += "<br><a href='modifyStudent?sno=" + std.getStudentNo() + "'>수정화면</a>";
		str += "<br><a href='studentListServ'>목록</a>";

		// 사용자 페이지로 출력
		resp.getWriter().print(str);
	}
}
