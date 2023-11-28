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
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				run = false;
			}
		}

	} //end of main

} //end of class