package chapter5;

import java.util.Scanner;

public class StudentApp2 {
	static Scanner scn = new Scanner(System.in);
	static Student[] students = null;
	
	public static void addStudent() {
		System.out.println("학생정보 입력>> ");
		for(int i = 0; i < students.length; i++) {
			Student student = new Student();
			System.out.print("학생 이름 입력: ");
			student.name = scn.nextLine();
			System.out.print("학생 점수 입력: ");
			student.score = Integer.parseInt(scn.nextLine()); // "3" -> 3
			System.out.print("남/여 입력: ");
			student.gender = scn.nextLine();
			
			students[i] = student; 
		}
	} // end of addStudent()
	
	public static void searchStudent() {
		System.out.print("조회할 이름 입력>> ");
		String name = scn.nextLine();
		boolean exists = false;
		
		for(Student stdt : students) {
			if(name.equals(stdt.name)) {
				System.out.println("이름은 " + stdt.name + ", 점수는 " + stdt.score);
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("찾는 이름이 없습니다.");
		}
	} // end of searchStudent()
	
	public static void analysis() {
		int sumMen = 0, countMen = 0;
		int sumWomen = 0, countWomen = 0;
		for(Student stn : students) {
			if(stn.gender.equals("남")) {
				sumMen += stn.score; 
				countMen++;
			}else if(stn.gender.equals("여")) {
				sumWomen += stn.score; 
				countWomen++;
			}
		}
		System.out.println("남학생의 평균: " + ((double)sumMen / countMen));
		System.out.println("여학생의 평균: " + ((double)sumWomen / countWomen));
	}
	
	public static void modify() {
		// 이름입력 -> 변경점수
		System.out.print("조회할 이름 입력>> ");
		String name = scn.nextLine();
		boolean exists = false;
		
		for(int i = 0; i < students.length; i++) {
			// 조건추가 => 변경점수 입력
			if(students[i].name.equals(name)) {
				System.out.println("변경된 점수: ");
				int changedScore = Integer.parseInt(scn.nextLine());
				students[i].score = changedScore;
				exists = true;
			}
		}
		if(!exists) {
			System.out.println("찾는 이름이 없습니다.");
		}
		
	} //end of modify

	public static void main(String[] args) {		
		boolean run = true;
		while (run) {
			int studentNum = 0;
			System.out.println("===============");
			System.out.println("1.학생수\n2.점수입력\n3.목록출력\n4.분석(최고점수, 평균)\n5.수정\n6.종료");
			System.out.print("선택: ");
			int menu = scn.nextInt(); // 3 Enter
			System.out.println("===============");
			scn.nextLine();
			
			switch(menu) {
			case 1:
				System.out.print("학생수 입력>> ");
				studentNum = Integer.parseInt(scn.nextLine()); // "3" -> 3
				students = new Student[studentNum];
				break;
			case 2:
				addStudent();
				break;
				
			case 3:
				searchStudent();
				break;
			case 4: // 분석 -남학생 평균, 여학생 평균
				analysis();
				break;
			case 5:
				modify();
				break;
			case 6:
				System.out.println("종료합니다");
				run = false;
				} //end of switch
			} //end of while
			

	} //end of main

} //end of class