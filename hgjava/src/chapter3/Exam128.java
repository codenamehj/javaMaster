package chapter3;

import java.util.Scanner;

public class Exam128 {

	public static void main(String[] args) {
		// 문제4
		int pencils = 534;
		int students = 30;
		
		int pencilsPerStudent = (int)(pencils / students);		
		int pencilsLeft =(pencils % students);
		
		System.out.printf("학생 당 연필 수 : %d, 남은 연필 수: %d \n", pencilsPerStudent, pencilsLeft);
		
		// 문제5
//		int var1 = 5;
//		int var2 = 2;
//		double var3 = (double)var1 / var2;
//		int var4 = (int) (var3 * var2);
//		System.out.println(var4);
		
		// 문제6
		int value = 365;
		System.out.println(value/100*100);
		
		// 문제7
//		float var1 = 10f;
//		float var2 = var1 / 100;
//		if(var2 == 0.1f) {
//			System.out.println("10% 입니다");
//		}else {
//			System.out.println("10%가 아닙니다");
//		}
		
		// 문제8
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop + lengthBottom) * height / 2.0;
		System.out.println("사다리꼴의 넓이 = " + area);
		
		// 문제9
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("첫 번째 수:");
//		double num1 = sc.nextDouble();
//		System.out.print("두 번째 수:");
//		double num2 = sc.nextDouble();
//		double result1 = num1 / num2;
//		
//		System.out.println("-------------");
//		if(num2 == 0) {
//			System.out.println("결과:무한대");
//		}else {
//			System.out.println("결과:" + result1);	
//		}
//		
//		sc.close();
		
		// 문제10
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("원의 넓이:" + var4);
		
		// 문제11
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디:");
		String name = sc.nextLine();
		
		if(name.equals("java")) {
			System.out.print("패스워드(숫자):");
			String strPw = sc.nextLine();
			int pw = Integer.parseInt(strPw);
			if(pw == 12345) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패: 패스워드가 틀림");				
			}
		}else {
			System.out.println("로그인 실패: 아이디가 존재하지 않음");							
		}
		
		sc.close();
		
		// 문제12
		int x = 10;
		int y = 5;
		System.out.println((x>7) && (y<=5));
		System.out.println((x%3 == 2) || (y%2 != 1));
		
		
		

	} // end main
} //end class
