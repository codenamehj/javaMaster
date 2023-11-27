package chapter5;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int studentNum = 0;
		int[] scores = null;
		String[] names = null;
		
		//1.학생수 2.점수입력 3.목록출력 4.분석(최고점수, 평균) 5.종료
		boolean run = true;
		while (run) {
			System.out.println("===============");
			System.out.println("1.학생수\n2.점수입력\n3.목록출력\n4.분석(최고점수, 평균)\n5.종료");
			System.out.print("선택: ");
			int menu = scn.nextInt(); // 3 Enter
			System.out.println("===============");
			scn.nextLine();
			
			switch(menu) {
			case 1:
				System.out.print("학생수 입력>> ");
				studentNum = scn.nextInt();
				scores = new int[studentNum];
				names = new String[studentNum];
				break;
			case 2:
				System.out.println("점수 입력>>");
				for(int i = 0; i < scores.length; i++) {
					System.out.print("names[" + i + "]>> ");
					names[i] = scn.nextLine();
					System.out.print("scores[" + i + "]>> ");
					scores[i] = scn.nextInt();
					scn.nextLine();
				}
				break;
			case 3:
				System.out.println("목록출력>>");
				for(int i = 0; i < scores.length; i++) {
					System.out.println("이름: " + names[i] + " 점수: " + scores[i]);
				}
				break;
			case 4:
				System.out.println("분석>>");
				int maxScore = 0;
				String maxName = "";
				int sum = 0;
				double avg = 0; 
				
//				for(int score : scores) {
				for(int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if(maxScore < scores[i]) {
						maxScore = scores[i];
						maxName = names[i];
					}
				}
				avg = (double)sum / scores.length;
				System.out.println("최고 점수: " + maxName + "의 " + maxScore + "점");
				System.out.println("평균 점수: " + avg);
				break;
			case 5:
				System.out.println("종료>>");
				run = false;
				break;
			} //end of switch
			
		} //end of while
		System.out.println("end of program");
		
		

	} //end of main

} //end of class