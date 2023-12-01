package chapter01;

import java.io.IOException;
import java.util.Scanner;

public class Hello {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello java");

		int x = 5;
		int y = x + 10;
		System.out.println(y);
		
		double z = 3.5;
		System.out.println(z);
		System.out.println("y = " + y);
		
		// ������ �� ��ȯ
		x = 3;
		y = 10;
		
		// �� ��ȯ
		int temp;
		temp = x;
		x = y;
		y = temp;
		
		//���
		System.out.println("x = " + x + ", y = " + y);
		
		// �⺻ Ÿ��
		// ũ����� : byte<short<char(����ǥ��X)<int<long 
		char charData = 'A';
		int intData = charData;
		
		System.out.println("char : " + charData + ", int : " + intData);
		
		char c1 = 'a';
		int c2 = c1 + 2; // �ڵ� Ÿ�� ��ȯ
		char c3 = (char)c2; //���� Ÿ�� ��ȯ
		System.out.printf("c2�� ���� %d, c3�� ���� %s \n", c2, c3);
		
		x = 5;
		y = 2;
		double result = (double)x / y;
		System.out.println(result);
		
		double v1 = 3.5;
		double v2 = 2.7;
		int result2 = (int)(v1 + v2);
		System.out.println(result2);
		
		long var1 = 2L;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		int result3 = (int)(var1 + var2 + var3) + (int)Double.parseDouble(var4);
		System.out.println(result3);
		
		// ǥ���Է� : Ű���� => System.in.read()
		// �� ���ڸ� �о����
//		int keyCode;
//		while(true) {
//			keyCode = System.in.read();
//			System.out.println("keyCode : " + keyCode);
//			if(keyCode == 113) {
//				break;
//			}
//		}
//		System.out.println("����");
		
		
		// ���ڿ� �Է� -> Scanner Ŭ���� -> ��ü�� �����ؼ� ���
		String scinput;
		Scanner sc = new Scanner(System.in); // ��Ʈ�� + shift + o(�ҹ���o)
		while(true) {
			System.out.print("�̸� �Է� : ");
			scinput = sc.nextLine();
			if(scinput.equals("q")) {
				break;
			}
			System.out.println("�� �̸��� " + scinput);
		}
		System.out.println("����");

		System.out.print("�� �Է� : ");
		scinput = sc.nextLine();
		System.out.println(Integer.parseInt(scinput) + 10);
		sc.close();
	} // end main

} // end class
