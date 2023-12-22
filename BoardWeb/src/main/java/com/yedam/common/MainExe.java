package com.yedam.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.board.mapper.BoardMapper;
import com.yedam.board.vo.BoardVO;

public class MainExe {
	public static void main(String[] args) {
		
		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession(true);
		
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		
		BoardVO vo = new BoardVO();
		vo.setTitle("aaaa");
		vo.setWriter("bbb");
		vo.setContent("ccccccccc");
		
		//게시판 글 등록
//		if(mapper.insertBoard(vo) == 1){
//			System.out.println("등록 완료");
//		}else {
//			System.out.println("등록 실패");
//		}
		
		//게시판 내용 업데이트\
//		vo.setBoardNo();
//		vo.setContent("");
//		if(mapper.updateBoard(vo) == 1) {
//			System.out.println("수정 완료");
//		}else {
//			System.out.println("수정 실패");
//		}
		
		//게시판 글 삭제
//		if(mapper.deleteBoard()==1) {
//			System.out.println("삭제 완료");
//		}else {
//			System.out.println("삭제 실패");
//		}

		
		//조회수 증가
//		System.out.println(mapper.selectOne(vo.getBoardNo()));
//		
//		if(mapper.updateCnt(4)==1) {
//			System.out.println("조회수 증가 성공");
//		}else {
//			System.out.println("조회수 증가 실패");
//		}
	}

}
