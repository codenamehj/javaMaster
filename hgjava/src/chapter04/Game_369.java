package chapter04;

public class Game_369 {

	public static void main(String[] args) {
		// 3, 6, 9 ����: 1 ~ 50
		
		// 3 6 9 ���� üũ ����
		int count = 0;
		
		// ���� 1~50 �ݺ���
		for(int i = 1; i <= 50; i++) {
			count = 0;
			// ���� �ڸ��� 3 6 9 ���� üũ
			if(i % 10 == 3||i % 10 == 6||i % 10 == 9) count ++;
			// ���� �ڸ��� 3 6 9 ���� üũ
			if(i/10==3||i/10==6||i/10==9) count++;	
			
			switch(count) {
			// ������ 0 -> ����
			case 0: System.out.print(i + "\t"); break;
			// ������ 1 -> ��
			case 1:	System.out.print("��\t"); break;
			// ������ 2 -> ����
			case 2: System.out.print("����\t"); break;
			}
			
			// 10���� �� �ٲ�
			if(i%10 == 0)
				System.out.println();
			
		}
	} //end main
} //end class