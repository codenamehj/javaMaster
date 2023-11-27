package chapter4;

import java.util.Scanner;

public class Game_numGuess {

	public static void main(String[] args) {
		int com = (int)(Math.random() * 100) + 1;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("숫자 입력 : ");
			int num =sc.nextInt();
			
			if(num == com) break;
			else if(num > com) 
				System.out.println("down하세요");
			else System.out.println("up하세요");
		}
		System.out.println("축하합니다!!");
		
		sc.close();

	} //end main
} //end class