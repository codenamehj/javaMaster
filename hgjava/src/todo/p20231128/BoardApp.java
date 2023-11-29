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
				System.out.print("게시글 제목: ");
				String title = scn.nextLine();
				System.out.print("작성자 이름: ");
				String writer = scn.nextLine();
				System.out.print("게시글 내용: ");
				String content = scn.nextLine();
				System.out.print("게시글 작성 일자: ");
				String date = scn.nextLine();
				
				Board brd = new Board(exe.getSequence(), title, writer, content, date);
				
				if(exe.addBulletin(brd)) {
					System.out.println("저장되었습니다");
				}else {
					System.out.println("저장 중 오류");
				}
				break;
				
			case 2:
				System.out.println("게시글 목록>>");
				Board[] boardAry = exe.boardList();
				System.out.println("글번호 제목 작성자");
				System.out.println("--------------------");
				for(Board board : boardAry) {
					if(board != null) {
						board.showInfo();
					}
				}
				System.out.println("--------------------");
				break;
				
			case 3:
				System.out.println("게시글 상세조회>>");
				System.out.print("조회할 게시글 번호: ");
				int no = Integer.parseInt(scn.nextLine());
				Board bard = exe.getBoard(no);
				if(bard != null) {
					bard.showDetail();
				}else {
					System.out.println("존재하지 않는 정보");
				}
				break;
				
			case 4:
				System.out.println("프로그램 종료>>");
				run = false;
			}
		}
		System.out.println("end of prog.");

	} //end of main

} //end of class