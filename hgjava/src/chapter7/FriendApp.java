package chapter7;

import java.util.Scanner;

public class FriendApp {
	static Scanner scn = new Scanner(System.in);
//	static Friend[] storage = new Friend[10];
	static FriendExe exe = new FriendExe();

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.목록 3.조회 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 등록
				addFriend();
				break;
			case 2: // 목록
				exe.friendList();
				break;
			case 3: // 조회
				getFriend();
				break;
			default: // 종료
				System.out.println("종료합니다.");
				run = false;
			}
		}

	} // end of main

	private static void addFriend() {
		System.out.println("1.친구 2.학교 3.회사");
		int subMenu = Integer.parseInt(scn.nextLine());

		Friend friend = null;

		System.out.print("이름: ");
		String name = scn.nextLine();
		System.out.print("연락처: ");
		String phone = scn.nextLine();

		if (subMenu == 1) { // 이름, 연락처
			friend = new Friend(name, phone); // Friend 인스턴스
		} else if (subMenu == 2) { // 이름, 연락처, 학교, 전공
			System.out.print("학교: ");
			String univ = scn.nextLine();
			System.out.print("전공: ");
			String major = scn.nextLine();

			friend = new UnivFriend(name, phone, univ, major); // UnivFriend 인스턴스
		} else if (subMenu == 3) { // 이름, 연락처, 회사, 부서
			System.out.print("회사: ");
			String company = scn.nextLine();
			System.out.print("부서: ");
			String dept = scn.nextLine();

			friend = new CompFriend(name, phone, company, dept); // CompFriend 인스턴스
		}
		// 배열에 추가
//		for (int i = 0; i < storage.length; i++) {
//			if (storage[i] == null) {
//				storage[i] = friend;
//				break;
//			}
//		}
//		System.out.println("저장되었습니다.");

		if (exe.addFriend(friend)) {
			System.out.println("저장되었습니다.");
		} else {
			System.out.println("저장 실패");
		}
	} // 등록

	private static void getFriend() {
		// 이름조회, 연락처조회
		System.out.println("1.이름 2.연락처");
		int subMenu = Integer.parseInt(scn.nextLine());
		String searchCond = "";

		if (subMenu == 1) {
			System.out.print("찾으려는 이름: ");
			searchCond = scn.nextLine();
//			for (Friend fnd : exe.storage) {
//				if (fnd != null && fnd.getName().equals(searchCond)) {
//					System.out.println(fnd.showInfo());
//				}
//			}
			Friend[] resltAry = exe.searchFriend(searchCond);
			for (int i = 0; i < resltAry.length; i++) {
				if (resltAry[i] != null) {
					System.out.println(resltAry[i].showInfo());
				}
			}

		} else if (subMenu == 2) {
			searchCond = scn.nextLine();
//			for (Friend fnd : exe.storage) {
//				if (fnd != null && fnd.getPhone().equals(searchCond)) {
//					System.out.println(fnd.showInfo());
//				}
//			}
			System.out.println(exe.searchPhone(searchCond).showInfo());
		} else {
			System.out.println("1 또는 2를 선택하세요.");
		}
	} // 조회

	void backup() {
		Friend parent = new Friend();
		parent.setName("홍길동");
		parent.setPhone("010-1111");
		System.out.println(parent.toString());

		UnivFriend child = new UnivFriend();
		child.setName("김철수");
		child.setPhone("010-2222");
		child.setUniv("서울대학교");
		child.setMajor("컴퓨터공학과");
		System.out.println(child.showInfo());

		Friend[] friends = new Friend[10];
		friends[0] = parent;
		friends[1] = child;
	}

}
