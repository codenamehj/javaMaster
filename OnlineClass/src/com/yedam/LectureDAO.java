package com.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LectureDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	Connection getConn() {
		String url = "jdbc:oracle:thin:@192.168.0.27:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "dev", "dev");
//			System.out.println("연결성공!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Driver 없음.");
		}
		return conn;
	}

	void disconn() {
		try {
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 강의추가
	boolean addLecture(Lecture lec) {
		getConn();
		String sql = "insert into lectures " + "values (?, ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, lec.getCode());
			psmt.setString(2, lec.getTitle());
			psmt.setString(3, lec.getTeacher());
			psmt.setString(4, lec.getStartDate());
			psmt.setInt(5, lec.getMaxNum());
			psmt.setInt(6, lec.getPrice());
			int r = psmt.executeUpdate();
			if (r == 1) {
				System.out.println("입력성공");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	// 전체강의목록(학생용)
	ArrayList<Lecture> getLectureList() {
		getConn();
		ArrayList<Lecture> lectures = new ArrayList<Lecture>();
		String sql = "select * from lectures order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Lecture lecture = new Lecture();
				lecture.setCode(rs.getString("lecture_code"));
				lecture.setTitle(rs.getString("lecture_title"));
				lecture.setTeacher(rs.getString("teacher_name"));
				lecture.setStartDate(rs.getString("lecture_start").substring(0, 10));
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

	// 수강중인 강의 목록(학생)
	ArrayList<Lecture> getStudentLectureList(String logId) {
		getConn();
		ArrayList<Lecture> lectures = new ArrayList<Lecture>();
		String sql = "SELECT l.lecture_code, l.lecture_title, l.teacher_name, l.lecture_start, l.student_num, l.lecture_price "
				+ "FROM lectures l,enrolment e " + "WHERE  e.user_id= ? " + "AND l.lecture_code = e.lecture_code";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, logId);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Lecture lecture = new Lecture();
				lecture.setCode(rs.getString("lecture_code"));
				lecture.setTitle(rs.getString("lecture_title"));
				lecture.setTeacher(rs.getString("teacher_name"));
				lecture.setStartDate(rs.getString("lecture_start").substring(0, 10));
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
	
	//폐강된 강의 체크
	Lecture checkRemovedLecture(Lecture lec) {
		getConn();
		String sql = "SELECT * "
				+ "FROM lectures "
				+ "where lecture_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, lec.getCode());
			
			rs = psmt.executeQuery();
			
			Lecture lect = new Lecture("","");
			lect.setCode(lec.getCode());
			lect.setTitle(lec.getTitle());
			
			if(rs.next()) {
				return lect;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
			
		}
		return null;
	}
	
	// 수강취소(학생)
	boolean delLecture(String code, String logId) {
		getConn();
		String sql = "DELETE FROM enrolment " + "WHERE lecture_code = ?" + "AND user_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			psmt.setString(2, logId);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	// 강의목록(선생님용)
	ArrayList<Lecture> getTeacherLectureList(String teacher) {
		getConn();
		ArrayList<Lecture> lectures = new ArrayList<Lecture>();
		String sql = "select * from lectures where  teacher_name= ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, teacher);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Lecture lecture = new Lecture();
				lecture.setCode(rs.getString("lecture_code"));
				lecture.setTitle(rs.getString("lecture_title"));
				lecture.setTeacher(rs.getString("teacher_name"));
				lecture.setStartDate(rs.getString("lecture_start").substring(0, 10));
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

	// 강의 취소(선생님)
	boolean delTeacherLecture(String code, String teacherName) {
		getConn();
		String sql = "DELETE FROM lectures " + "WHERE lecture_code = ?" + "AND teacher_name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			psmt.setString(2, teacherName);
			
			int r = psmt.executeUpdate();
			
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}
	
	//강의 취소할 데이터 저장용 메소드
	Lecture getRemoveLect(String code) { 
		getConn();
		String sql = "SELECT * "
				+ "FROM lectures "
				+ "where lecture_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			rs = psmt.executeQuery();
			
			Lecture lec = new Lecture("","");
			
			if(rs.next()) {
				lec.setCode(rs.getString("lecture_code"));
				lec.setTitle(rs.getString("lecture_title"));
				
				return lec;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return null;
	}

	int getLectureCount(String lecCode) {
		getConn();
		String sql = "select count(*) from enrolment where lecture_code=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, lecCode);
			rs = psmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return 0;
	}

	int getMaxNum(String lecCode) {
		getConn();
		String sql = "select student_num from lectures where lecture_code=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, lecCode);
			rs = psmt.executeQuery();

			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return 0;
	}

	String getStartDate(String code) {
		getConn();
		String sql = "select lecture_start " + "from lectures " + "where lecture_code = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, code);
			rs = psmt.executeQuery();

			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

	boolean checkDate(String idate) {
		// 2023-12-15
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(idate);
			Date today = new Date();
			return today.before(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

}
