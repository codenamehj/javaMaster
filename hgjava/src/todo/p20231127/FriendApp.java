package todo.p20231127;

import java.util.Scanner;

public class FriendApp {
	static Scanner scn = new Scanner(System.in);
	static Friend[] friends= null;

	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.친구수 2.친구정보입력 3.목록출력 4.연락처수정 5.종료");
			System.out.println("-----------------------------");
			System.out.print("선택: ");
			int select = Integer.parseInt(scn.nextLine());
			
			switch(select) {
			case 1: // ģ���� 
				int friendNum = 0;
				System.out.print("친구 수>> ");
				friendNum = Integer.parseInt(scn.nextLine());
				friends = new Friend[friendNum];
				break;
			case 2: // �Է� - �̸�, ����ó, ������
				System.out.println("친구 정보 입력>>");
				for(int i = 0; i < friends.length; i++) {
					Friend friend = new Friend();
					System.out.print("이름: ");
					friend.name = scn.nextLine();
					System.out.print("연락처: ");
					friend.contact = scn.nextLine();
					System.out.print("혈액형: ");
					friend.bloodType = scn.nextLine();
					
					friends[i] = friend;
				}
				break;
			case 3: // ���
				System.out.println("목록 출력>>");
				for(Friend frd : friends) {
					System.out.println("이름: " + frd.name +"\t연락처: " + frd.contact + "\t혈액형: " + frd.bloodType);
				}
				break;
			case 4: // ����				
				System.out.println("연락처 수정>>");
				System.out.print("수정할 이름: ");
				String cName = scn.nextLine();
				boolean exists = false;
				
				for(int i = 0; i < friends.length; i++) {
					if(friends[i].name.equals(cName)) {
						System.out.print("변경된 연락처: ");
						String cContact = scn.nextLine();
						friends[i].contact = cContact;
						exists = true;
						}
					}
				if(!exists) {
					System.out.println("찾는 이름이 없습니다.");
				}				
				break;
			case 5: //����
				System.out.println("프로그램 종료");
				run = false;
			} //end of switch
			
		} //end of while
		
		System.out.println("end of prog.");

	} //end of main

} //end of class