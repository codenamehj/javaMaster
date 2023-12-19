package com.yedam;

public class MainExe {
	public static void main(String[] args) {
		LectureDAO ldao = new LectureDAO();
		System.out.println(ldao.checkDate(ldao.getStartDate("k001")));
		

	}
}
