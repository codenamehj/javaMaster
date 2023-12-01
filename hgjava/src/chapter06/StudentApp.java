package chapter06;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scn = new Scanner(System.in);
//		Student[] students = new Student[100];
//		students[0] = new Student("23-001", "홍길동", 77, 88);
//		students[1] = new Student("23-002", "김철수", 82, 85);

		StudentExe exe = new StudentExe();
		
		while(run) {
			System.out.println("1.등록 2.목록 3.단건조회 4.수정 5.삭제 6.종료");
			System.out.print("선택: ");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch(menu) {
			case 1:
					System.out.print("학생 번호: ");
					String no = scn.nextLine();
					System.out.print("학생 이름: ");
					String name = scn.nextLine();
					System.out.print("영어성적: ");
					int eng = Integer.parseInt(scn.nextLine());
					System.out.print("수학성적: ");
					int math = Integer.parseInt(scn.nextLine());
					
					Student std = new Student(no, name, eng, math);

					// students 배열 한건 저장
//					for(int i = 0; i < students.length; i++) {
//						if(students[i] == null) {
//							students[i] = std;
//							break;
//						}
//					}
					if(exe.addStudent(std)) {
						System.out.println("저장되었습니다.");
					}else {
						System.out.println("저장 중 오류");
					}
				break;
				
			case 2:
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null) {
//						students[i].showInfo();						
//					}
//				}
				for(Student stdnt : exe.getStudentList()) {
					if(stdnt != null){
						stdnt.showInfo();
					}
				} //Student[] 타입
				break;
				
			case 3:
				System.out.print("조회할 학생 번호: ");
				String searchNo = scn.nextLine();
				Student stnt = exe.getStudent(searchNo);
				if(stnt != null) {
					stnt.showInfo();
				}else {
					System.out.println("존재하지 않는 정보");
				}
//				boolean exists = false;
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].studentNo.equals(searchNo)) {
//						students[i].showInfo();
//						exists = true;
//					}
//				}
//				if(!exists) System.out.println("찾는 학생번호가 목록에 없습니다.");
				break;
				
			case 4:
				System.out.print("수정할 학생 번호 :");
				String sNo = scn.nextLine();
//				boolean exist = false;
//				
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].studentNo.equals(sNo)) {
//						System.out.print("수정된 영어 점수:");
//						int modEng = Integer.parseInt(scn.nextLine());
//						System.out.print("수정된 수학 점수:");
//						int modMath = Integer.parseInt(scn.nextLine());
//						
//						students[i].engScore = modEng;
//						students[i].mathScore = modMath;
//						
//						exist = true;
//					}
//				}
//				if(!exist) System.out.println("찾는 학생번호가 목록에 없습니다.");
				System.out.print("수정된 영어 점수:");
				int modEng = Integer.parseInt(scn.nextLine());
				System.out.print("수정된 수학 점수:");
				int modMath = Integer.parseInt(scn.nextLine());
				if(exe.modifyStudent(sNo, modEng, modMath)) {
					System.out.println("수정 완료");
				}else System.out.println("수정 실패");
				break;
				
			case 5:
				System.out.print("삭제할 학생 이름 :");
				String sName = scn.nextLine();
//				boolean exi = false;
//				
//				for(int i = 0; i < students.length; i++) {
//					if(students[i] != null && students[i].studentName.equals(sName)) {
//						students[i] = null;
//						exi = true;
//						System.out.println("삭제되었습니다");
//					}
//				}
//				if(!exi) System.out.println("삭제할 이름이 없습니다.");
				if(exe.removeStudent(sName)) {
					System.out.println("삭제 완료");
				}else System.out.println("삭제 실패");
				break;
				
			case 6:
				System.out.println("프로그램을 종료합니다.");
				run = false;
			} // end of switch
			
		} // end of while
		System.out.println("end of prog.");

	} //end of main
} // end of class