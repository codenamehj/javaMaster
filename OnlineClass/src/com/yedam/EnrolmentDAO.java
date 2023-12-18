package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	Enrolment getEnrolmentList(String logId) {
		getConn();
		String sql = "select * "
					+ "from enrolment "
					+ "where user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, logId);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				Enrolment enrolment = new Enrolment();
				return enrolment;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
