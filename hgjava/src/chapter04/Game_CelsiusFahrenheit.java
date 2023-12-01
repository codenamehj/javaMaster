package chapter04;

import java.util.Scanner;

public class Game_CelsiusFahrenheit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double degF = 0;
		double degC = 0;
		boolean run = true;
		
		while (run) {
			System.out.println("---------------");
			System.out.println("1. ȭ�� => ����");
			System.out.println("2. ���� => ȭ��");
			System.out.println("3. ����");
			System.out.println("---------------");
			
			System.out.print("�� ��ȣ ���� : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1 : 
				System.out.print("�� ȭ�� �µ� �Է� : ");
				degF =sc.nextDouble();
				double tFc = 5.0 / 9 * (degF - 32);
				System.out.println("�����µ� = " + tFc);
				break;
			case 2 :
				System.out.print("�� ���� �µ� �Է� : ");
				degC =sc.nextDouble();
				double tCf = 9.0 / 5 * degC + 32;
				System.out.println("ȭ���µ� = " + tCf);				
				break;
			case 3 :
				System.out.println("program end");
				run = false;
				break;
			default :
				System.out.println("���⿡ ���� �����Դϴ�. �ٽ� �������ּ���");
			}
		}
		
		sc.close();
	} //end main
} //end class