package chapter05;

public class ArrayExe3 {

	public static void main(String[] args) {
		String[] nameAry = {"ȫ�浿", "Ȳ����", "������", "�̸���", "ȫ�浿"};
		
		String search = "ȫ�浿";
		int count = 0;
		
		// for �ݺ��� Ȱ��
		for(String name : nameAry) {
			if(name.equals(search)) count++;
		}
		
		System.out.println(search + "�� �� " + count + "�� �Դϴ�");
		
		// ���� ū �� ã��
		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScore = 0;
		for(int score : scores) {
			if(maxScore < score) maxScore = score;
		}
		System.out.println("���� ���� ������ " + maxScore + "�� �Դϴ�.");
		
	} //end main
} //end class