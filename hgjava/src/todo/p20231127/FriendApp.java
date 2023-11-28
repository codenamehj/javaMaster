package todo.p20231127;

import java.util.Scanner;

public class FriendApp {
	static Scanner scn = new Scanner(System.in);
	static Friend[] friends= null;

	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.친구수 2.입력 3.목록 4.수정 5.종료");
			System.out.println("-----------------------------");
			System.out.print("선택: ");
			int select = Integer.parseInt(scn.nextLine());
			
			switch(select) {
			case 1: // 친구수 
				int friendNum = 0;
				System.out.print("친구 수>> ");
				friendNum = Integer.parseInt(scn.nextLine());
				friends = new Friend[friendNum];
				break;
			case 2: // 입력 - 이름, 연락처, 혈액형
				System.out.println("친구 정보 입력>>");
				for(int i = 0; i < friends.length; i++) {
					Friend friend = new Friend();
					System.out.print("친구 이름: ");
					friend.name = scn.nextLine();
					System.out.print("연락처: ");
					friend.contact = scn.nextLine();
					System.out.print("혈액형: ");
					friend.bloodType = scn.nextLine();
					
					friends[i] = friend;
				}
				break;
			case 3: // 목록
				System.out.println("목록 출력>>");
				for(Friend frd : friends) {
					System.out.println("이름: " + frd.name +"\n연락처: " + frd.contact + "\n혈액형: " + frd.bloodType);
				}
				break;
			case 4: // 수정				
				System.out.println("전화번호 수정>>");
				System.out.print("수정할 이름: ");
				String cName = scn.nextLine();
				boolean exists = false;
				
				for(int i = 0; i < friends.length; i++) {
					if(friends[i].name.equals(cName)) {
						System.out.print("변경된 전화번호: ");
						String cContact = scn.nextLine();
						friends[i].contact = cContact;
						exists = true;
						}
					}
				if(!exists) {
					System.out.println("찾는 이름이 없습니다.");
				}				
				break;
			case 5: //종료
				System.out.println("프로그램 종료");
				run = false;
			} //end of switch
			
		} //end of while
		
		System.out.println("end of prog.");

	} //end of main

} //end of class