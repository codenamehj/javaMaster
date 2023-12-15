package chapter04;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		
		// ����2
		int sum3 = 0;
		for(int i = 3; i < 100; i += 3) sum3 += i;
		System.out.println("1~100������ ���� �� 3�� ����� ��: " + sum3);
		
		// ����3
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
		
		// ����4
		System.out.print("�������� ��: ");
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				if(4*x + 5*y == 60)  System.out.printf("(%d,%d)", x, y);
			System.out.print("(" + x + "," + y +")");
			}
		}
		System.out.print("\n");
		
		// ����5
		String stars = "";		
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				stars += "*";				
			}
			stars += "\n";
		}		
		System.out.println(stars);
		
		// ����6
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
		
		// ����7
		boolean run = true;
		int balance = 0; // �ܰ�
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("\n");
			System.out.println("-----------------------------");
			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
			System.out.println("-----------------------------");
			System.out.print("����> ");
			int selNum = sc.nextInt();
			switch(selNum) {
			case 1 : 
				System.out.print("���ݾ�> ");
				int deposit = sc.nextInt();
				balance += deposit;
				break;
			case 2 :
				System.out.print("��ݾ�> ");
				int withdrawal = sc.nextInt();
				if(withdrawal > balance) System.out.println("�ܰ� �����մϴ�");
				else balance -= withdrawal;
				break;
			case 3 :
				System.out.println("�ܰ�> " + balance);
				break;
				
			case 4 : run = false;				
			}			
		}
		System.out.println("���α׷� ����");
		
		sc.close();
		
	} //end main
} //end class