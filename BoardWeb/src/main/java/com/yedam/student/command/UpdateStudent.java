package com.yedam.student.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.mapper.StudentDAO;
import com.yedam.student.service.StudentService;
import com.yedam.student.serviceimpl.StudentServiceImpl;

@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateStudent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		StudentService dao = new StudentServiceImpl();
		String sno = request.getParameter("sno");
		int escore = Integer.parseInt(request.getParameter("escore"));
		int mscore = Integer.parseInt(request.getParameter("mscore"));
		boolean done = dao.modStudent(sno, escore, mscore);
		
		if (done) {
			out.println("<script>alert('OK'); location.href='studentListServ'; </script>");
		} else {
			out.println("<script>alert('FAIL'); location.href='index.html'; </script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
