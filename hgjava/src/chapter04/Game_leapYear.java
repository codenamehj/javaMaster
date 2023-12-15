package chapter04;

import java.util.Scanner;

public class Game_leapYear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("##�⵵ �Է� : ");
		int year = sc.nextInt();
		
		if(year % 4 == 0 && year % 100 != 0)
			System.out.println(year + "���� �����Դϴ�.");
		else if (year % 400 == 0)
			System.out.println(year + "���� �����Դϴ�.");
		else
			System.out.println(year + "���� ����Դϴ�.");
			
		sc.close();
	} //end main
} //end class