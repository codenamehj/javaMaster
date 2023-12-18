package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnrolmentDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url,"dev","dev");
			System.out.println("연결성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	void disconn(){
		try {
			if(conn != null)
				conn.close();
			if(rs != null)
				rs.close();
			if(psmt != null)
				psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	boolean getEnrolInsert(String code, String logId) {
		getConn();
		String sql = "insert into enrolment(lecture_code, user_id) "
				+ "values (?, ?) ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			psmt.setString(2, logId);
			
			int r = psmt.executeUpdate();
			if(r == 1) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return false;
	}
	
	ArrayList<Lecture> getEnrolmentList(String logId) {
		getConn();
		ArrayList<Lecture> enrolAry = new ArrayList<Lecture>();
		String sql = "select l.lecture_code, l.lecture_title, l.teacher_name, l.student_num, l.lecture_start, l.lecture_price\r\n"
				+ "from lectures l, enrolment e\r\n"
				+ "where l.lecture_code = e.lecture_code and e.user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, logId);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Lecture lec = new Lecture();
				lec.setCode(rs.getString("lecture_code"));
				lec.setTitle(rs.getString("lecture_title"));
				lec.setTeacher(rs.getString("teacher_name"));
				lec.setMaxNum(rs.getInt("student_num"));
				lec.setStartDate(rs.getString("lecture_start"));
				lec.setPrice(rs.getInt("lecture_price"));
				
				enrolAry.add(lec);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enrolAry;
	}
}
