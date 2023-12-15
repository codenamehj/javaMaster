package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
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
	
	void getMemberInsert(Member member) {
		getConn();
		String sql = "insert into users "
				+ "values (?, ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getName());
			psmt.setString(2, member.getUid());
			psmt.setString(3, member.getPwd());
			psmt.setString(4, member.getBirth());
			psmt.setString(5, member.getEamil());
			psmt.setString(6, member.getDiv());
			psmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	Member loginCheck(String id, String pwd) {
		getConn();
		String sql = "select * "
				+ "From users "
				+ "Where id = ? "
				+ "and password = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				Member member = new Member();
				member.setName(rs.getString("name"));
				member.setDiv(rs.getString("division"));
				
				return member;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}
}
