package chapter05;

import java.util.Scanner;

public class StudentApp2 {
	static Scanner scn = new Scanner(System.in);
	static Student[] students = null;
	
	public static void addStudent() {
		System.out.println("�л����� �Է�>> ");
		for(int i = 0; i < students.length; i++) {
			Student student = new Student();
			System.out.print("�л� �̸� �Է�: ");
			student.name = scn.nextLine();
			System.out.print("�л� ���� �Է�: ");
			student.score = Integer.parseInt(scn.nextLine()); // "3" -> 3
			System.out.print("��/�� �Է�: ");
			student.gender = scn.nextLine();
			
			students[i] = student; 
		}
	} // end of addStudent()
	
	public static void searchStudent() {
		System.out.print("��ȸ�� �̸� �Է�>> ");
		String name = scn.nextLine();
		boolean exists = false;
		
		for(Student stdt : students) {
			if(name.equals(stdt.name)) {
				System.out.println("�̸��� " + stdt.name + ", ������ " + stdt.score);
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("ã�� �̸��� �����ϴ�.");
		}
	} // end of searchStudent()
	
	public static void analysis() {
		int sumMen = 0, countMen = 0;
		int sumWomen = 0, countWomen = 0;
		for(Student stn : students) {
			if(stn.gender.equals("��")) {
				sumMen += stn.score; 
				countMen++;
			}else if(stn.gender.equals("��")) {
				sumWomen += stn.score; 
				countWomen++;
			}
		}
		System.out.println("���л��� ���: " + ((double)sumMen / countMen));
		System.out.println("���л��� ���: " + ((double)sumWomen / countWomen));
	}
	
	public static void modify() {
		// �̸��Է� -> ��������
		System.out.print("��ȸ�� �̸� �Է�>> ");
		String name = scn.nextLine();
		boolean exists = false;
		
		for(int i = 0; i < students.length; i++) {
			// �����߰� => �������� �Է�
			if(students[i].name.equals(name)) {
				System.out.println("����� ����: ");
				int changedScore = Integer.parseInt(scn.nextLine());
				students[i].score = changedScore;
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("ã�� �̸��� �����ϴ�.");
		}
		
	} //end of modify

	public static void main(String[] args) {		
		boolean run = true;
		while (run) {
			int studentNum = 0;
			System.out.println("===============");
			System.out.println("1.�л���\n2.�����Է�\n3.������\n4.�м�(�ְ�����, ���)\n5.����\n6.����");
			System.out.print("����: ");
			int menu = scn.nextInt(); // 3 Enter
			System.out.println("===============");
			scn.nextLine();
			
			switch(menu) {
			case 1:
				System.out.print("�л��� �Է�>> ");
				studentNum = Integer.parseInt(scn.nextLine()); // "3" -> 3
				students = new Student[studentNum];
				break;
			case 2:
				addStudent();
				break;
				
			case 3:
				searchStudent();
				break;
			case 4: // �м� -���л� ���, ���л� ���
				analysis();
				break;
			case 5:
				modify();
				break;
			case 6:
				System.out.println("�����մϴ�");
				run = false;
				} //end of switch
			} //end of while
			

	} //end of main

} //end of class