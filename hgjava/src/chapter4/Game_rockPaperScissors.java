package chapter4;

import java.util.Scanner;

public class Game_rockPaperScissors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.print("## 가위(0) 바위(1) 보(2) : ");
			int saram = sc.nextInt();
			if(saram >= 3 || saram < 0) break;
			int com = (int)(Math.random()*3);
			if(saram == com) {
				System.out.printf("사람 %d, 컴 %d 비겼음\n", saram, com);				
			}
			else if(saram == (com + 1) % 3) {
				System.out.printf("사람 %d, 컴 %d 사람 승리\n", saram, com);				
			}
			else {
				System.out.printf("사람 %d, 컴 %d 컴 승리\n", saram, com);				
			}
		}
		System.out.println("game over");
		
		sc.close();
		

	} //end main
} //end class