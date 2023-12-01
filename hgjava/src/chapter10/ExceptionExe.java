package chapter10;

public class ExceptionExe {
	public static void main(String[] args) {
		
		// 일반예외 : 예외를 처리
		try {
			Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("end of prog");
	}
}