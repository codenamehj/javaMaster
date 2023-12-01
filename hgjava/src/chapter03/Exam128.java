package chapter03;

import java.util.Scanner;

public class Exam128 {

	public static void main(String[] args) {
		// ����4
		int pencils = 534;
		int students = 30;
		
		int pencilsPerStudent = (int)(pencils / students);		
		int pencilsLeft =(pencils % students);
		
		System.out.printf("�л� �� ���� �� : %d, ���� ���� ��: %d \n", pencilsPerStudent, pencilsLeft);
		
		// ����5
//		int var1 = 5;
//		int var2 = 2;
//		double var3 = (double)var1 / var2;
//		int var4 = (int) (var3 * var2);
//		System.out.println(var4);
		
		// ����6
		int value = 365;
		System.out.println(value/100*100);
		
		// ����7
//		float var1 = 10f;
//		float var2 = var1 / 100;
//		if(var2 == 0.1f) {
//			System.out.println("10% �Դϴ�");
//		}else {
//			System.out.println("10%�� �ƴմϴ�");
//		}
		
		// ����8
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = (lengthTop + lengthBottom) * height / 2.0;
		System.out.println("��ٸ����� ���� = " + area);
		
		// ����9
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.print("ù ��° ��:");
//		double num1 = sc.nextDouble();
//		System.out.print("�� ��° ��:");
//		double num2 = sc.nextDouble();
//		double result1 = num1 / num2;
//		
//		System.out.println("-------------");
//		if(num2 == 0) {
//			System.out.println("���:���Ѵ�");
//		}else {
//			System.out.println("���:" + result1);	
//		}
//		
//		sc.close();
		
		// ����10
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("���� ����:" + var4);
		
		// ����11
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���̵�:");
		String name = sc.nextLine();
		
		if(name.equals("java")) {
			System.out.print("�н�����(����):");
			String strPw = sc.nextLine();
			int pw = Integer.parseInt(strPw);
			if(pw == 12345) {
				System.out.println("�α��� ����");
			}else {
				System.out.println("�α��� ����: �н����尡 Ʋ��");				
			}
		}else {
			System.out.println("�α��� ����: ���̵� �������� ����");							
		}
		
		sc.close();
		
		// ����12
		int x = 10;
		int y = 5;
		System.out.println((x>7) && (y<=5));
		System.out.println((x%3 == 2) || (y%2 != 1));
		
		
		

	} // end main
} //end class
