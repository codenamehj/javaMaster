package com.yedam;

import java.util.Scanner;

public class OnlineApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		boolean run = true;
		
		while(run) {
			System.out.print("아이디>>");
			String uId = scn.nextLine();
			System.out.print("비밀번호>>");
			String uPw = scn.nextLine();
			Member m =dao.loginCheck(uId, uPw);
			if(m == null) {
				System.out.println("로그인 실패");
			}else {
				System.out.println("로그인 성공");
				System.out.println("이름은 "+ m.getName() +", 권한은 "+ m.getDiv());
			}
				
			if(m.getDiv().equals("student")) {
				System.out.println("1.강의목록 2.수강신청 3.수강중인강의목록 4.수강취소 5.종료");
				int stdtSel = Integer.parseInt(scn.nextLine());
				switch(stdtSel) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					System.out.println("종료합니다");
					run = false;
				}
				
			}else if(m.getDiv().equals("teacher")) {
				System.out.println("1.강의추가 2.강의목록 3.강의취소 4.종료");
				int tcrSel = Integer.parseInt(scn.nextLine());
				switch(tcrSel) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					System.out.println("종료합니다");
					run = false;
				}
			}
		}
	}

}
