package com.yedam;

import java.util.ArrayList;
import java.util.Scanner;

public class OnlineApp {
	static Scanner scn = new Scanner(System.in);
	static MemberDAO mdao = new MemberDAO();
	static LectureDAO ldao = new LectureDAO();
	static EnrolmentDAO edao = new EnrolmentDAO();
	static String logId;
	static String teacherName;
	static boolean run = true;

	public static Member login() {
		while (true) {
			System.out.print("아이디>>");
			String uId = scn.nextLine();
			System.out.print("비밀번호>>");
			String uPw = scn.nextLine();

			Member m = mdao.loginCheck(uId, uPw);

			if (m != null) {
				logId = uId;
				teacherName = m.getName();
				return m;
			} else {
				System.out.println("로그인 실패");
			}
		}
	}

	public static void studentFun() {
		while (run) {
			System.out.println("1.강의목록 2.수강신청 3.수강중인강의목록 4.수강취소 5.회원탈퇴 6.종료");
			int stdtSel = Integer.parseInt(scn.nextLine());
			switch (stdtSel) {
			case 1: // 강의목록 보기
				System.out.println("==========================강의목록==========================");
				ArrayList<Lecture> lecAry = ldao.getLectureList();
				for (Lecture lect : lecAry) {
					if (lect != null) {
						System.out.println(lect.getCode() + "\t" + lect.getTitle() + "\t" + lect.getTeacher() + "\t"
								+ lect.getStartDate() + "\t" + ldao.getLectureCount(lect.getCode()) + "/"
								+ lect.getMaxNum() + "\t" + lect.getPrice() + "원");
					}
				}
				System.out.println("=========================================================");
				break;
			case 2:
				System.out.println("==========================수강신청==========================");
				System.out.print("수강할 강의 코드>> ");
				String code = scn.nextLine();

				if (edao.checkDuplicate(code, logId)) { // 중복된 강의 확인
					if (ldao.checkDate(ldao.getStartDate(code))) { // 수강시작일 확인
						if (ldao.getLectureCount(code) < ldao.getMaxNum(code)) { // 수강인원 확인
							if (edao.getEnrolInsert(code, logId)) {
								System.out.println("수강신청 되었습니다");
							}
						} else {
							System.out.println("수강신청 실패 : 수강인원이 모두 찼습니다.");
						}
					} else {
						System.out.println("수강신청 실패 : 강의가 이미 시작되었습니다.");
					}
				} else {
					System.out.println("수강신청 실패: 중복된 강의입니다.");
				}
				System.out.println("=========================================================");
				break;
			case 3:
				System.out.println("=======================수강중인강의목록=======================");
				ArrayList<Lecture> lecAray = ldao.getStudentLectureList(logId);
				for (Lecture lect : lecAray) {
					if (lect != null) {
						System.out.println(lect.getCode() + "\t" + lect.getTitle() + "\t" + lect.getTeacher() + "\t"
								+ lect.getStartDate() + "\t" + ldao.getLectureCount(lect.getCode()) + "/"
								+ lect.getMaxNum() + "\t" + lect.getPrice() + "원");
					}
				}
				System.out.println("=========================================================");
				break;
			case 4:
				System.out.println("==========================수강취소==========================");
				System.out.print("수강 취소할 강의코드>> ");
				String lcode = scn.nextLine();
				if (ldao.checkDate(ldao.getStartDate(lcode))) {
					if (ldao.delLecture(lcode, logId)) {
						System.out.println("수강취소 되었습니다.");
					} else {
						System.out.println("수강 중인 강의가 아닙니다.");
					}
				}else {
					System.out.println("이미 강의가 시작되어 취소할 수 없습니다.");
				}
				System.out.println("=========================================================");
				break;
			case 5:
				System.out.println("==========================회원탈퇴==========================");
				signout();
				System.out.println("=========================================================");
				break;
			case 6:
				System.out.println("종료합니다");
				run = false;
			}
		}
	} // end of if

	public static void teacherFunc() {
		while (run) {
			System.out.println("1.강의추가 2.강의목록 3.강의취소 4.회원탈퇴 5.종료");
			int tchSel = Integer.parseInt(scn.nextLine());
			switch (tchSel) {
			case 1:
				System.out.println("==========================강의추가==========================");
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
				System.out.println("=========================================================");
				break;
			case 2:
				System.out.println("==========================나의 강의목록==========================");
				ArrayList<Lecture> lecAry = ldao.getTeacherLectureList(teacherName);
				for (Lecture lect : lecAry) {
					if (lect != null) {
						System.out.println(lect.getCode() + "\t" + lect.getTitle() + "\t" + lect.getTeacher() + "\t"
								+ lect.getStartDate() + "\t" + ldao.getLectureCount(lect.getCode()) + "/"
								+ lect.getMaxNum() + "\t" + lect.getPrice() + "원");
					}
				}
				System.out.println("=========================================================");
				break;
			case 3:
				System.out.println("==========================강의취소==========================");

				System.out.println("=========================================================");
				break;
			case 4:
				System.out.println("==========================회원탈퇴==========================");
				signout();
				System.out.println("=========================================================");
				break;
			case 5:
				System.out.println("종료합니다");
				run = false;
			}
		}
	}

	public static void signout() {
		while (run) {
			System.out.print("비밀번호 입력>> ");
			String delPwd = scn.nextLine();
			if (mdao.delUser(logId, delPwd)) {
				System.out.println("회원탈퇴를 완료하였습니다.");
				run = false;
			} else {
				System.out.println("회원탈퇴 실패: 비밀번호가 맞지않습니다.");
			}
		}
	}

	public static void main(String[] args) {
		boolean run = true;

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

				String id = "";
				boolean runJoin = true;
				while (runJoin) {
					System.out.print("아이디>> ");
					id = scn.nextLine();
					if (mdao.checkUserId(id)) {
						System.out.println("이미 존재하는 id입니다. 다른 id를 입력해주세요.");
					} else {
						runJoin = false;
					}
				}
				System.out.print("비밀번호>> ");
				String pwd = scn.nextLine();
				System.out.println("생년월일>> ex)20-01-01");
				String birth = scn.nextLine();
				System.out.print("student/teacher>> ");
				String div = scn.nextLine();

				Member mem = new Member(name, id, pwd, birth, div);

				if (mdao.getMemberInsert(mem)) {
					System.out.println("회원가입 완료");
				} else {
					System.out.println("회원가입 실패");
				}

			}

		} // end of while.

	} // end of main.
}