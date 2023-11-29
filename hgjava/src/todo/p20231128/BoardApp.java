package todo.p20231128;

import java.util.Scanner;

import chapter6.User;
import chapter6.UserExe;

public class BoardApp {
	static BoardExe exe = new BoardExe();

	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		String id = null;

		UserExe uexe = new UserExe();

		while (true) {
			System.out.print("id 입력: ");
			id = scn.nextLine();
			System.out.print("pw 입력: ");
			String pw = scn.nextLine();

			User user = uexe.logIn(id, pw);
			if (user != null) {
				System.out.println(user.getUserName() + "님 환영합니다.");
				break;
			} else {
				System.out.println("로그인 실패");
			}
		}

		// 초기값 생성
		exe.initData();

		while (run) {
			System.out.println("1.등록 2.목록 3.상세조회 4.수정 5.삭제 6.종료");
			System.out.print("선택: ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.println("게시글 등록>>");
				System.out.print("게시글 제목: ");
				String title = scn.nextLine();
				System.out.print("게시글 내용: ");
				String content = scn.nextLine();
				System.out.print("게시글 작성 일자: ");
				String date = scn.nextLine();

				Board brd = new Board(exe.getSequence(), title, id, content, date);

				if (exe.addBulletin(brd)) {
					System.out.println("저장되었습니다");
				} else {
					System.out.println("저장 중 오류");
				}
				break;

			case 2:
				System.out.println("게시글 목록>>");
				Board[] boardAry = exe.boardList();
				showList(boardAry, 1);
				while (true) {
					int page = Integer.parseInt(scn.nextLine());
					if (page == 0) {
						break;
					}
					showList(boardAry, page);
				}
				break;

			case 3:
				System.out.println("게시글 상세조회>>");
				System.out.print("조회할 게시글 번호: ");
				int no = Integer.parseInt(scn.nextLine());
				Board bard = exe.getBoard(no);
				if (bard != null) {
					bard.showDetail();
				} else {
					System.out.println("존재하지 않는 정보");
				}
				break;

			case 4:
				System.out.println("내용 수정>>");
				System.out.print("수정할 게시글 번호: ");
				int bNo = Integer.parseInt(scn.nextLine());

				if (!exe.checkResponsibility(id, bNo)) {
					System.out.println("수정 권한이 없습니다");
					continue;
				}
				System.out.print("수정된 내용: ");
				String bContent = scn.nextLine();

				if (exe.modBoard(bNo, bContent)) {
					System.out.println("수정되었습니다");
				} else
					System.out.println("수정에 실패했습니다");
				break;

			case 5:
				System.out.println("게시글 삭제>>");
				System.out.print("삭제할 게시글 번호: ");
				int brdNo = Integer.parseInt(scn.nextLine());

				if (!exe.checkResponsibility(id, brdNo)) {
					System.out.println("삭제 권한이 없습니다");
					continue;
				}

				if (exe.remBoard(brdNo)) {
					System.out.println("삭제되었습니다");
				} else
					System.out.println("삭제할 게시글이 없습니다");
				break;

			case 6:
				System.out.println("프로그램 종료>>");
				run = false;
			}
		}
		System.out.println("end of prog.");

	} // end of main

	public static void showList(Board[] boardAry, int page) {
		// 페이징 처리
		Board[] pageAry = exe.pageList(boardAry, page);
		System.out.println("글번호  제목    작성자");
		System.out.println("--------------------");
		for (Board board : pageAry) {
			if (board != null) {
				board.showInfo();
			}
		}
		// 전체페이지 계산하고 출력
		int cnt = exe.getBoardCount();
		int totalPage = (int) Math.ceil(cnt / 5.0);

		for (int i = 1; i <= totalPage; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n페이지를 선택하세요. 종료: 0");
	}

} // end of class