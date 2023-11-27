package chapter4;

import java.util.Scanner;

public class Game_leapYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("##년도 입력 : ");
		int year = sc.nextInt();
		
		if(year % 4 == 0 && year % 100 != 0)
			System.out.println(year + "년은 윤년입니다.");
		else if (year % 400 == 0)
			System.out.println(year + "년은 윤년입니다.");
		else
			System.out.println(year + "년은 평년입니다.");
			
		sc.close();
	} //end main
} //end class