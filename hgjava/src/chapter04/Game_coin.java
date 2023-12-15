package chapter04;

import java.util.Scanner;

public class Game_coin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("##��ȯ�� �ݾ� : ");
		int money = sc.nextInt();

		System.out.println("500�� ¥�� : " + money / 500 + "��");
		int leftMoney = money % 500;
		
		System.out.println("100�� ¥�� : " + leftMoney / 100 + "��");
		leftMoney %= 100;

		System.out.println("50�� ¥�� : " + leftMoney / 50 + "��");
		leftMoney %= 50;

		System.out.println("10�� ¥�� : " + leftMoney / 10 + "��");
		leftMoney %= 10;
		
		System.out.println("��ȯ �ݾ� : " + money);
		System.out.println("���� �ݾ� : " + leftMoney);
		
		sc.close();
	} //end main
} //end class