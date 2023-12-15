package chapter05;

public class ArrayExe2 {

	public static void main(String[] args) {
		// ������ ���� �� �ִ� �迭�� ����(ũ��� 10���� ������ ����)
		// intAry => 10 ~ 100 ����
		// ���
		
		int[] intAry = new int[10];
		for(int i = 0; i < intAry.length; i++) {
				intAry[i] = (i + 1) * 10;
		}
		// ���. ����for��.
		int sum = 0; //50���� ū ���� ����.
		double avg = 0;
		int count = 0;
		for(int num : intAry) {
			System.out.println(num);
			if(num > 50) {
				sum += num;
				count++;
			}
		}
		avg = sum / count;
		System.out.println("50���� ū ���� �հ�: " + sum);
		System.out.println("50���� ū ���� ���: " + avg);
		
		
	}

}
