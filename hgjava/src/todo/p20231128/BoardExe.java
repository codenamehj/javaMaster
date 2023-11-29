package todo.p20231128;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardExe {

	private Board[] boards;
	public Board[] pageAry;

	BoardExe() {
		boards = new Board[100];
	}

	// 초기값 생성
	void initData() {
		boards[0] = new Board(1, "첫번째 글", "user01", "오늘은 숙제로 자바게시판을 만들어봅시다");
		boards[1] = new Board(2, "두번째 글", "user02", "오늘은 숙제로 자바게시판을 만들어봅시다");
		// boards[2] <-- 5번글등록
		boards[3] = new Board(4, "네번째 글", "user04", "오늘은 숙제로 자바게시판을 만들어봅시다", "2023-11-28");
		boards[2] = new Board(3, "세번째 글", "user03", "오늘은 숙제로 자바게시판을 만들어봅시다");

		boards[4] = new Board(5, "다섯번째 글", "user05", "오늘은 숙제로 자바게시판을 만들어봅시다");
		boards[5] = new Board(6, "여섯번째 글", "user06", "오늘은 숙제로 자바게시판을 만들어봅시다");
		boards[6] = new Board(7, "일곱번째 글", "user07", "오늘은 숙제로 자바게시판을 만들어봅시다");
		boards[7] = new Board(8, "여덟번째 글", "user08", "오늘은 숙제로 자바게시판을 만들어봅시다");
	}

	// 등록 메소드 => 반환값: boolean
	boolean addBulletin(Board brd) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = brd;
				return true; // break; // 반복문 종료
			}
		}
		return false;
	}

	// 목록 메소드 => 반환값: 배열
	Board[] boardList() {
		// boards => 새로운 배열에 정렬된 값으로 반환
		Board temp = null;
		for (int j = 0; j < boards.length - 1; j++) {
			for (int i = 0; i < boards.length - 1; i++) {
				if (boards[i] != null && boards[i + 1] != null) {
					if (boards[i].getBoardNo() > boards[i + 1].getBoardNo()) {
						temp = boards[i];
						boards[i] = boards[i + 1];
						boards[i + 1] = temp;
					}
				}
			}
		}
		return boards;
	} // end of boardList()

	// 배열, 페이지 => 페이지의 5건을 반환
	Board[] pageList(Board[] ary, int page) {
	Board[] resultAry = new Board[5];

		int start = (page - 1) * 5;
		int end = page * 5;
		int j = 0;
		for (int i = 0; i < ary.length; i++) {
			if (i >= start && i < end) {
				resultAry[j++] = ary[i];
			}
		}
		return resultAry;
	}

	// 단건조회 => 매개변수: 글번호, 반환값: Board
	Board getBoard(int boardNo) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == boardNo) {
				return boards[i];
			}
		}
		return null;
	}

	// 신규번호: 현재 글번호 + 1
	int getSequence() {
		// 배열에서 글번호의 max 가져오기
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() > max) {
				max = boards[i].getBoardNo();
			}
		}
		int seqNo = max + 1;
		return seqNo;
	}

	// 수정 => 매개값(글번호, 내용) => boolean
	boolean modBoard(int no, String content) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == no) {
				boards[i].setContent(content);
				boards[i].setDate(sdf.format(today));
				return true;
			}
		}
		return false;
	}

	// 삭제 => 매개값(글번호) => boolean
	boolean remBoard(int no) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == no) {
				boards[i] = null;
				return true;
			}
		}
		return false;
	}

	// 사용자가 해당글 번호의 수정, 삭제권한 체크 => boolean
	boolean checkResponsibility(String id, int no) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == no && boards[i].getWriter().equals(id)) {
				return true;
			}
		}
		return false;
	}

	// 게시글이 담고있는 배열에서 값이 있는 건수를 반환
	int getBoardCount() {
		int realCnt = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				realCnt++;
			}
		}
		return realCnt;
	}

}