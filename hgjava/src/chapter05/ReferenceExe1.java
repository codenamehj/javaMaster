package chapter05;

//�������� ������ ������ ����
class Friend{
	String name; //�ʵ�
	int age; //�ʵ�
	double height; // �ʵ�
	
}
public class ReferenceExe1 {

	public static void main(String[] args) {
		
		// ��������: �������� ��°� (X) -> �������� �ּ�
		Friend myFriend = new Friend(); // new => ��ü ����
		myFriend.name = "��ö��";
		myFriend.age = 20;
		myFriend.height = 178.3;
		
//		Friend ourFriend = myFriend;
		
//		myFriend.name = "ȫ�浿";
//		
//		System.out.println(ourFriend.name);
//		System.out.println(ourFriend.age);
//		System.out.println(ourFriend.height);
		
		Friend yourFriend = new Friend(); // new => ��ü ����
		yourFriend.name = "��ö��";
		yourFriend.age = 20;
		yourFriend.height = 178.3;
		
		System.out.println(myFriend == yourFriend); // �ּҰ� ��: false
		
		yourFriend = null;
		System.out.println(myFriend.name);
		try {
		System.out.println(yourFriend.name);
		}catch(Exception e) {
			System.out.println("null���� �����մϴ�.");
		}
		
		// �⺻ Ÿ��
		int a = 10;
		int b = a;
		
		a = 20;
		
		// ����Ÿ��: �ּҰ��� ������ ����.
		String name = "�ſ��";  // new String("�ſ��"); // 23dbdae34334
		String hobby = "����";
		
		String name1 = "�ſ��"; // new String("�ſ��");
		System.out.println("name : " + name);
		System.out.println("name1 : "+ name1);
		
		System.out.println(name == name1); // == -> equals()�޼ҵ� Ȱ��
		

	}

}