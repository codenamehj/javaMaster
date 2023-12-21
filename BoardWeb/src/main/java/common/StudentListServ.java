package common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentListServ") // url
public class StudentListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentListServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 목록페이지.
		StudentDAO dao = new StudentDAO();
		List<Student> list = dao.getStudentList();

		// out.print("<table border='1'>");
		String str = "<table border='1'>";
		str += "<thead><tr><th>학생번호</th><th>학생이름</th><th>영어점수</th><th>수학점수</th></tr></thead>";
		str += "<tbody>";
		for (Student std : list) {
			str += "<tr><td><a href='student/studentInfo.jsp?sno=" + std.getStudentNo() + "'>" + std.getStudentNo()
					+ "</a></td>" + "<td>" + std.getStudentName() + "</td>" + "<td>" + std.getEngScore() + "</td>"
					+ "<td>" + std.getMathScore() + "</td></tr>";
		}
		str += "</tbody></table>";
		// 링크만들기
		str += "<a href='student/inform.html'>등록화면</a>";

		out.print(str);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
