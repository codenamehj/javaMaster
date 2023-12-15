package chapter04;

import java.util.Scanner;

public class Game_rockPaperScissors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.print("## ����(0) ����(1) ��(2) : ");
			int saram = sc.nextInt();
			if(saram >= 3 || saram < 0) break;
			int com = (int)(Math.random()*3);
			if(saram == com) {
				System.out.printf("��� %d, �� %d �����\n", saram, com);				
			}
			else if(saram == (com + 1) % 3) {
				System.out.printf("��� %d, �� %d ��� �¸�\n", saram, com);				
			}
			else {
				System.out.printf("��� %d, �� %d �� �¸�\n", saram, com);				
			}
		}
		System.out.println("game over");
		
		sc.close();
		

	} //end main
} //end class