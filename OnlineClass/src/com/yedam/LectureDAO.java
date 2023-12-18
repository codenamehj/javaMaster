package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LectureDAO {
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
			System.out.println("Driver 없음.");
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
	
	//강의추가
	boolean addLecture(Lecture lec) {
		getConn();
		String sql = "insert into lectures "
					+ "values (?, ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, lec.getCode());
			psmt.setString(2, lec.getTitle());
			psmt.setString(3, lec.getTeacher());
			psmt.setString(4, lec.getStartDate());
			psmt.setInt(5, lec.getMaxNum());
			psmt.setInt(6, lec.getPrice());
			int r = psmt.executeUpdate();	
			if(r == 1) {
				System.out.println("입력성공");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return false;
	}
	
	//강의목록(학생용)
	ArrayList<Lecture> getLectureList(){
		getConn();
		ArrayList<Lecture> lectures = new ArrayList<Lecture>();
		String sql = "select * from lectures order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Lecture lecture = new Lecture();
				lecture.setCode(rs.getString("lecture_code"));
				lecture.setTitle(rs.getString("lecture_title"));
				lecture.setTeacher(rs.getString("teacher_name"));
				lecture.setStartDate(rs.getString("lecture_start"));
				lecture.setMaxNum(rs.getInt("student_num"));
				lecture.setPrice(rs.getInt("lecture_price"));
				
				lectures.add(lecture);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return lectures;
	}
	
	//강의목록(선생님용)
	ArrayList<Lecture> getTeacherLectureList(String teacher){
		getConn();
		ArrayList<Lecture> lectures = new ArrayList<Lecture>();
		String sql = "select * from lectures where teacher_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, teacher);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Lecture lecture = new Lecture();
				lecture.setCode(rs.getString("lecture_code"));
				lecture.setTitle(rs.getString("lecture_title"));
				lecture.setTeacher(rs.getString("teacher_name"));
				lecture.setStartDate(rs.getString("lecture_start"));
				lecture.setMaxNum(rs.getInt("student_num"));
				lecture.setPrice(rs.getInt("lecture_price"));
				
				lectures.add(lecture);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return lectures;
	}
	
	
}
