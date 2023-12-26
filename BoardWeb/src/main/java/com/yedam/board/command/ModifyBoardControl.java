package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceimpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class ModifyBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// parameter(bno, content),db update, 목록페이지
		String bno = req.getParameter("bno");
		String content = req.getParameter("content");
		
		BoardVO vo = new BoardVO();
		vo.setBoardNo(Integer.parseInt(bno));
		vo.setContent(content);
		
		// svc : modBoard()
		BoardService svc = new BoardServiceMybatis();

		try {
			if (svc.modBoard(vo)) {
				resp.sendRedirect("boardList.do");
			} else {
				resp.sendRedirect("modifyForm.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
