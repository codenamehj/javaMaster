package todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	// 속성
	int boardNo;
	String title;
	String writer;
	String content;
	String date;

	// 생성자
	public Board(int boardNo, String title, String writer, String content) {
		Date today = new Date(); // 시스템시간을 기준으로 샹성
		// Date -> String -> Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		this.boardNo = boardNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.date = sdf.format(today);
	}

	public Board(int boardNo, String title, String writer, String content, String date) {
		this.boardNo = boardNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.date = date;
	}

	// 목록 메소드
	void showInfo() {
		System.out.println(boardNo + " " + title + " " + writer + " " + date);
	}

	// 상세조회 메소드
	void showDetail() {
		System.out.println("번호: " + boardNo + "/ 제목: " + title);
		System.out.println("작성자: " + writer);
		System.out.println("내용: " + content);
		System.out.println("일시: " + date);
	}

	// setter & getters 메소드
	void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	void setTitle(String title) {
		this.title = title;
	}

	void setWriter(String writer) {
		this.writer = writer;
	}

	void setContent(String content) {
		this.content = content;
	}

	void setDate(String date) {
		this.date = date;
	}

	int getBoardNo() {
		return boardNo;
	}

	String getTitle() {
		return title;
	}

	String getWriter() {
		return writer;
	}

	String getContent() {
		return content;
	}

	String getDate() {
		return date;
	}

}