package todo.p20231128;

import java.util.Scanner;

public class BoardApp {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		
		BoardExe exe = new BoardExe();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.종료");
			System.out.print("선택: ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1:
				System.out.println("게시글 등록>>");
				System.out.print("게시글 번호: ");
				int num = Integer.parseInt(scn.nextLine());
				break;
			case 2:
				System.out.println("게시글 목록>>");
				break;
			case 3:
				System.out.println("게시글 상세조회>>");
				break;
			case 4:
				System.out.println("프로그램 종료>>");
				run = false;
			}
		}

	} //end of main

} //end of class