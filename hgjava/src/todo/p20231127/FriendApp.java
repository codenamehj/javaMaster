package todo.p20231127;

import java.util.Scanner;

public class FriendApp {
	static Scanner scn = new Scanner(System.in);
	static Friend[] friends= null;

	public static void main(String[] args) {
		boolean run = true;
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.ģ���� 2.�Է� 3.��� 4.���� 5.����");
			System.out.println("-----------------------------");
			System.out.print("����: ");
			int select = Integer.parseInt(scn.nextLine());
			
			switch(select) {
			case 1: // ģ���� 
				int friendNum = 0;
				System.out.print("ģ�� ��>> ");
				friendNum = Integer.parseInt(scn.nextLine());
				friends = new Friend[friendNum];
				break;
			case 2: // �Է� - �̸�, ����ó, ������
				System.out.println("ģ�� ���� �Է�>>");
				for(int i = 0; i < friends.length; i++) {
					Friend friend = new Friend();
					System.out.print("ģ�� �̸�: ");
					friend.name = scn.nextLine();
					System.out.print("����ó: ");
					friend.contact = scn.nextLine();
					System.out.print("������: ");
					friend.bloodType = scn.nextLine();
					
					friends[i] = friend;
				}
				break;
			case 3: // ���
				System.out.println("��� ���>>");
				for(Friend frd : friends) {
					System.out.println("�̸�: " + frd.name +"\n����ó: " + frd.contact + "\n������: " + frd.bloodType);
				}
				break;
			case 4: // ����				
				System.out.println("��ȭ��ȣ ����>>");
				System.out.print("������ �̸�: ");
				String cName = scn.nextLine();
				boolean exists = false;
				
				for(int i = 0; i < friends.length; i++) {
					if(friends[i].name.equals(cName)) {
						System.out.print("����� ��ȭ��ȣ: ");
						String cContact = scn.nextLine();
						friends[i].contact = cContact;
						exists = true;
						}
					}
				if(!exists) {
					System.out.println("ã�� �̸��� �����ϴ�.");
				}				
				break;
			case 5: //����
				System.out.println("���α׷� ����");
				run = false;
			} //end of switch
			
		} //end of while
		
		System.out.println("end of prog.");

	} //end of main

} //end of class