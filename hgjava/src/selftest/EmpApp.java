package selftest;

import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
	boolean run = true;
	
	Scanner scn = new Scanner(System.in);
	EmpDAO dao = new EmpDAO();
	
	while(run) {
		System.out.println("1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(조건:입사일자) 6.종료");
		int menu = Integer.parseInt(scn.nextLine());
		
		switch (menu) {
		case 1: //등록
			System.out.print("사번입력>> ");
			String number = scn.nextLine();
			System.out.print("이름입력>> ");
			String name = scn.nextLine();
			System.out.print("전화번호입력>> ");
			String phone = scn.nextLine();
			System.out.print("입사일입력>> ");
			String date = scn.nextLine();
			System.out.print("급여입력>> ");
			int salary = Integer.parseInt(scn.nextLine());
			
			Employee emp = new Employee(number, name, phone, date, salary);
			
			if(dao.addEmployee(emp)) {
				System.out.println("저장되었습니다");
			}else {
				System.out.println("저장 중 오류");
			}
			break;
			
		case 2: //목록
			
			break;
		case 3: //수정(급여)
			break;
		case 4: //삭제
			break;
		case 5: //조회
			break;
		case 6:
			System.out.println("프로그램 종료");
			run = false;
		}
	}
	System.out.println("end of prog.");
	}
}
