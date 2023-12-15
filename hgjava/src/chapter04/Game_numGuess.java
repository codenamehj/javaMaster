package chapter04;

import java.util.Scanner;

public class Game_numGuess {

	public static void main(String[] args) {
		int com = (int)(Math.random() * 100) + 1;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("���� �Է� : ");
			int num =sc.nextInt();
			
			if(num == com) break;
			else if(num > com) 
				System.out.println("down�ϼ���");
			else System.out.println("up�ϼ���");
		}
		System.out.println("�����մϴ�!!");
		
		sc.close();
		
		//�𸣰ڴ�

	} //end main
} //end class