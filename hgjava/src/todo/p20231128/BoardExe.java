package todo.p20231128;

public class BoardExe {
	
	private Board[] boards;
	
	BoardExe() {
		boards = new Board[100];
	}
	
	// 등록 메소드 => 반환값: boolean
	boolean addBulletin(Board brd) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] == null) {
				boards[i] = brd;
				return true; // break; // 반복문 종료
			}
		}
		return false;
	}
	
	// 목록 메소드 => 반환값: 배열
	Board[] boardList() {
		return boards;
	}
	
	//단건조회 => 매개변수: 글번호, 반환값: Board
	Board getBoard(int boardNo) {
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNo() == boardNo) {
				return boards[i];
			}
		}
		return null;
	}
	
	// 신규번호: 현재 글번호 + 1
	int getSequence() {
		// 배열에서 글번호의 max 가져오기
		int max = 0;
		for(int i = 0; i < boards.length; i++) {
			if(boards[i] != null && boards[i].getBoardNo() >max) {
				max = boards[i].getBoardNo();
			}
		}				
		int seqNo = max + 1;
		return seqNo;
	}
	
}
