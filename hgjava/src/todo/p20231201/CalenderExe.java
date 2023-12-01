package todo.p20231201;

public class CalenderExe {
	public static void main(String[] args) {
		// 12월 달력 작성
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();

		for (int i = 1; i <= 36; i++) {
			if (i <= 5)
				System.out.printf("%4s", "");
			else
				System.out.printf("%4d", i - 5);
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n============end=============");

		for (String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		int blank;
		for (blank = 0; blank < 5; blank++) {
			System.out.printf("%4s", "");
		}

		for (int i = 1; i <= 31; i++) {
			System.out.printf("%4d", i);
			if ((i + blank) % 7 == 0) {
				System.out.println();
			}
		}

	}
}
