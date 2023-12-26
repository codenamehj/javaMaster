package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceimpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class GetBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 글 번호 조회
		String bno = req.getParameter("bno");

		BoardService svc = new BoardServiceMybatis();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));

		req.setAttribute("vo", vo);

		// 페이징 이동(forward)
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/board/getBoard.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}