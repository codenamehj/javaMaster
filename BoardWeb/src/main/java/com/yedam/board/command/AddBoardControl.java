package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.board.service.BoardService;
import com.yedam.board.serviceimpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// parameter(title, content, writer),db insert, 목록페이지
		// get 요청일 때/ post 요청일 때
		if (req.getMethod().equals("GET")) {

			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriter(writer);

			// svc : addBoard()
			BoardService svc = new BoardServiceMybatis();

			try {
				if (svc.addBoard(vo)) {
					resp.sendRedirect("boardList.do");
				} else {
					resp.sendRedirect("boardForm.do");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else if(req.getMethod().equals("POST")) {
			// 파일업로드 포함
			String saveLoc = req.getServletContext().getRealPath("images");
			int maxSize = 1024 * 1024 * 5;
			MultipartRequest mr = null;
			
			// 1.request 2.saveLoc 3.maxSize 4.인코딩 5.리네임정책
			try {
				mr = new MultipartRequest(req, saveLoc, maxSize, "utf-8", new DefaultFileRenamePolicy());
				String title = mr.getParameter("title");
				String content = mr.getParameter("content");
				String writer = mr.getParameter("writer");
				String image = mr.getFilesystemName("image");
				
				BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setImage(image);
				
				// svc : addBoard()
				BoardService svc = new BoardServiceMybatis();

				try {
					if (svc.addBoard(vo)) {
						resp.sendRedirect("boardList.do");
					} else {
						resp.sendRedirect("boardForm.do");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}// end of execute

}
