package todo.p20231128;

public class BoardExe {
	
	private Board[] boards;
	
	BoardExe() {
		boards = new Board[100];
	}
	
	// 등록 메소드
	void addBulletin(Board blt) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] == null) {
				boards[i] = blt;
			}
		}
	}
	
	// 목록 메소드
		void showInfo() {
			for(int i = 0; i < boards.length; i++) {
				System.out.println(boards[i].boardNo + "\t" + boards[i].title + "\t" + boards[i].writer);			
			}
		}
}
