package chapter4;

import java.util.Scanner;

public class Game_CelsiusFahrenheit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double degF = 0;
		double degC = 0;
		boolean run = true;
		
		while (run) {
			System.out.println("---------------");
			System.out.println("1. 화씨 => 섭씨");
			System.out.println("2. 섭씨 => 화씨");
			System.out.println("3. 종료");
			System.out.println("---------------");
			
			System.out.print("▶ 번호 선택 : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1 : 
				System.out.print("▶ 화씨 온도 입력 : ");
				degF =sc.nextDouble();
				double tFc = 5.0 / 9 * (degF - 32);
				System.out.println("섭씨온도 = " + tFc);
				break;
			case 2 :
				System.out.print("▶ 섭씨 온도 입력 : ");
				degC =sc.nextDouble();
				double tCf = 9.0 / 5 * degC + 32;
				System.out.println("화씨온도 = " + tCf);				
				break;
			case 3 :
				System.out.println("program end");
				run = false;
				break;
			default :
				System.out.println("보기에 없는 선택입니다. 다시 선택해주세요");
			}
		}
		
		sc.close();
	} //end main
} //end class