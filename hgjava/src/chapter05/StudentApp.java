package chapter05;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int studentNum = 0;
		int[] scores = null;
		String[] names = null;
		
		//1.�л��� 2.�����Է� 3.������ 4.�м�(�ְ�����, ���) 5.����
		boolean run = true;
		while (run) {
			System.out.println("===============");
			System.out.println("1.�л���\n2.�����Է�\n3.������\n4.�м�(�ְ�����, ���)\n5.����");
			System.out.print("����: ");
			int menu = scn.nextInt(); // 3 Enter
			System.out.println("===============");
			scn.nextLine();
			
			switch(menu) {
			case 1:
				System.out.print("�л��� �Է�>> ");
				studentNum = scn.nextInt();
				scores = new int[studentNum];
				names = new String[studentNum];
				break;
			case 2:
				System.out.println("���� �Է�>>");
				for(int i = 0; i < scores.length; i++) {
					System.out.print("names[" + i + "]>> ");
					names[i] = scn.nextLine();
					System.out.print("scores[" + i + "]>> ");
					scores[i] = scn.nextInt();
					scn.nextLine();
				}
				break;
			case 3:
				System.out.println("������>>");
				for(int i = 0; i < scores.length; i++) {
					System.out.println("�̸�: " + names[i] + " ����: " + scores[i]);
				}
				break;
			case 4:
				System.out.println("�м�>>");
				int maxScore = 0;
				String maxName = "";
				int sum = 0;
				double avg = 0; 
				
//				for(int score : scores) {
				for(int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if(maxScore < scores[i]) {
						maxScore = scores[i];
						maxName = names[i];
					}
				}
				avg = (double)sum / scores.length;
				System.out.println("�ְ� ����: " + maxName + "�� " + maxScore + "��");
				System.out.println("��� ����: " + avg);
				break;
			case 5:
				System.out.println("����>>");
				run = false;
				break;
			} //end of switch
			
		} //end of while
		System.out.println("end of program");
		
		

	} //end of main

} //end of class