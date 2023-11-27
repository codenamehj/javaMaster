package chapter4;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		
		// 문제2
		int sum3 = 0;
		for(int i = 3; i < 100; i += 3) sum3 += i;
		System.out.println("1~100까지의 정수 중 3의 배수의 합: " + sum3);
		
		// 문제3
		int diceNum1 = (int)(Math.random() * 6) + 1;
		int diceNum2 = (int)(Math.random() * 6) + 1;
		int sumDice = diceNum1 + diceNum2;
		
		while(sumDice != 5) {
			System.out.println("(" + diceNum1 + "," + diceNum2 + ")");
			diceNum1 = (int)(Math.random() * 6) + 1;
			diceNum2 = (int)(Math.random() * 6) + 1;
			sumDice = diceNum1 + diceNum2;
		}
		System.out.println("(" + diceNum1 + "," + diceNum2 + ")");
		
		// 문제4
		System.out.print("방정식의 해: ");
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				if(4*x + 5*y == 60)  System.out.printf("(%d,%d)", x, y);
			System.out.print("(" + x + "," + y +")");
			}
		}
		System.out.print("\n");
		
		// 문제5
		String stars = "";		
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				stars += "*";				
			}
			stars += "\n";
		}		
		System.out.println(stars);
		
		// 문제6
		String rvStars = "";		
		for(int i = 1; i < 5; i++) {
			for(int b = 1; b <= 4-i; b++){
				rvStars += " ";	
			}
			for(int s=1; s <= i ;s++) {
				rvStars += "*";
			}
			rvStars += "\n";
		}		
		System.out.println(rvStars);
		
		// 문제7
		boolean run = true;
		int balance = 0; // 잔고
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("\n");
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택> ");
			int selNum = sc.nextInt();
			switch(selNum) {
			case 1 : 
				System.out.print("예금액> ");
				int deposit = sc.nextInt();
				balance += deposit;
				break;
			case 2 :
				System.out.print("출금액> ");
				int withdrawal = sc.nextInt();
				if(withdrawal > balance) System.out.println("잔고가 부족합니다");
				else balance -= withdrawal;
				break;
			case 3 :
				System.out.println("잔고> " + balance);
				break;
				
			case 4 : run = false;				
			}			
		}
		System.out.println("프로그램 종료");
		
		sc.close();
		
	} //end main
} //end class