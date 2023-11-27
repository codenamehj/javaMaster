package chapter5;

public class ArrayExe3 {

	public static void main(String[] args) {
		String[] nameAry = {"홍길동", "황진이", "성춘향", "이몽룡", "홍길동"};
		
		String search = "홍길동";
		int count = 0;
		
		// for 반복문 활용
		for(String name : nameAry) {
			if(name.equals(search)) count++;
		}
		
		System.out.println(search + "은 총 " + count + "명 입니다");
		
		// 가장 큰 값 찾기
		int[] scores = {88, 68, 72, 89, 92, 70};
		int maxScore = 0;
		for(int score : scores) {
			if(maxScore < score) maxScore = score;
		}
		System.out.println("가장 높은 점수는 " + maxScore + "점 입니다.");
		
	} //end main
} //end class