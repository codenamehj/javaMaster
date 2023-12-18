package com.yedam;

import java.util.ArrayList;
import java.util.Scanner;

public class OnlineApp {
	static Scanner scn = new Scanner(System.in);
	static MemberDAO mdao = new MemberDAO();
	static LectureDAO ldao = new LectureDAO();
	static EnrolmentDAO edao = new EnrolmentDAO();
	static String logId;

	public static Member login() {
		while (true) {
			System.out.print("아이디>>");
			String uId = scn.nextLine();
			System.out.print("비밀번호>>");
			String uPw = scn.nextLine();

			Member m = mdao.loginCheck(uId, uPw);

			if (m != null) {
				logId = uId;
				return m;
			} else {
				System.out.println("로그인 실패");
			}
		}
	}

	public static void studentFun() {
		boolean run = true;
		while (run) {
			System.out.println("1.강의목록 2.수강신청 3.수강중인강의목록 4.수강취소 5.종료");
			int stdtSel = Integer.parseInt(scn.nextLine());
			switch (stdtSel) {
			case 1: // 강의목록 보기
				System.out.println("=====강의목록=====");
				ArrayList<Lecture> lecAry = ldao.getLectureList();
				for (Lecture lect : lecAry) {
					if (lect != null) {
						lect.showInfo();
					}
				}
				break;
			case 2:
				System.out.println("=====수강신청=====");
				System.out.print("수강할 강의 코드>> ");
				String code = scn.nextLine();
				if(edao.getEnrolInsert(code, logId)) {
					System.out.println("수강신청 되었습니다");
				}else {
					System.out.println("수강신청 실패");
				}
				break;
			case 3:
				System.out.println("=====수강중인강의목록=====");
				
				break;
			case 4:
				break;
			case 5:
				System.out.println("종료합니다");
				run = false;
			}
		}
	} // end of if

	public static void teacherFunc() {
		boolean run = true;
		while (run) {
			System.out.println("1.강의추가 2.강의목록 3.강의취소 4.종료");
			int tchSel = Integer.parseInt(scn.nextLine());
			switch (tchSel) {
			case 1:
				System.out.println("=====강의추가=====");
				System.out.print("강의코드>> ");
				String code = scn.nextLine();
				System.out.print("강의제목>> ");
				String title = scn.nextLine();
				System.out.print("강사이름>> ");
				String teacher = scn.nextLine();
				System.out.print("강의시작일>> ");
				String date = scn.nextLine();
				System.out.print("최대수강인원>> ");
				int maxStd = Integer.parseInt(scn.nextLine());
				System.out.print("강의가격>> ");
				int price = Integer.parseInt(scn.nextLine());

				Lecture lec = new Lecture(code, title, teacher, date, maxStd, price);

				if (ldao.addLecture(lec)) {
					System.out.println("저장되었습니다.");
				} else {
					System.out.println("저장 중 오류");
				}
				break;
			case 2:
				System.out.println("=====나의 강의목록=====");
				System.out.print("이름>> ");
				teacher = scn.nextLine();
				ArrayList<Lecture> lecAry = ldao.getTeacherLectureList(teacher);
				for (Lecture lect : lecAry) {
					if (lect != null) {
						lect.showInfo();
					}
				}
				break;
			case 3:
				break;
			case 4:
				System.out.println("종료합니다");
				run = false;
			}
		}
	}

	public static void signout() {

		System.out.print("탈퇴할 id>> ");
		String delId = scn.nextLine();
		System.out.print("비밀번호 입력>> ");
		String delPwd = scn.nextLine();

	}

	public static void main(String[] args) {

		boolean run = true;
		String uId;
		boolean stdMode = false;

		while (run) {
			System.out.println("1.로그인 2.회원가입");
			int menu = Integer.parseInt(scn.nextLine());
			Member memb = null;
			switch (menu) {
			case 1: // 로그인
				memb = login();
				if (memb.getDiv().equals("student")) {
					studentFun();

				} else if (memb.getDiv().equals("teacher")) {
					teacherFunc();
				}
				break;

			case 2: // 회원가입
				System.out.print("이름>> ");
				String name = scn.nextLine();
				System.out.print("아이디>> ");
				String id = scn.nextLine();
				System.out.print("비밀번호>> ");
				String pwd = scn.nextLine();
				System.out.println("생년월일>> ex)20-01-01");
				String birth = scn.nextLine();
				System.out.print("이메일>> ");
				String email = scn.nextLine();
				System.out.print("student/teacher>> ");
				String div = scn.nextLine();

				Member mem = new Member(name, id, pwd, birth, email, div);

				if (mdao.getMemberInsert(mem)) {
					System.out.println("회원가입 완료");
				} else {
					System.out.println("회원가입 실패");
				}

			}

		} // end of while.

	} // end of main.
}