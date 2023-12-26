package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceimpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class RemoveBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// parameter(bno),db delete, 목록페이지
		String bno = req.getParameter("bno");

		// svc : remBoard()
		BoardService svc = new BoardServiceMybatis();

		try {
			if (svc.remBoard(Integer.parseInt(bno))) {
				resp.sendRedirect("boardList.do");
			} else {
				resp.sendRedirect("removeForm.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}