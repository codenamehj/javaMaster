package chapter4;

import java.util.Scanner;

public class Game_coin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("##교환할 금액 : ");
		int money = sc.nextInt();

		System.out.println("500원 짜리 : " + money / 500 + "개");
		int leftMoney = money % 500;
		
		System.out.println("100원 짜리 : " + leftMoney / 100 + "개");
		leftMoney %= 100;

		System.out.println("50원 짜리 : " + leftMoney / 50 + "개");
		leftMoney %= 50;

		System.out.println("10원 짜리 : " + leftMoney / 10 + "개");
		leftMoney %= 10;
		
		System.out.println("교환 금액 : " + money);
		System.out.println("남은 금액 : " + leftMoney);
		
		sc.close();
	} //end main
} //end class