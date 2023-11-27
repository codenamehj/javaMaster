package chapter4;

public class Game_99dan {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			for(int j = 2; j < 10; j++) {
				if(i == 0)
					System.out.printf("  %d´Ü\t", j);
				else {
					int mul = j * i;
					if(mul < 10)
						System.out.printf("%dX%d= %d\t", j, i, mul);
					else
						System.out.printf("%dX%d=%d\t", j, i, mul);					
				}
			}
			System.out.println();
		}
	} //end main
} //end class