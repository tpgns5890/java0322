package co.edu.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.BoardVO;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class SearchBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bno 파라메터.
		
		String bno = req.getParameter("bno");
		
		BoardService service = new BoardServiceImpl();
		BoardVO board = service.findBoard(Integer.parseInt(bno));
		
		req.setAttribute("board", board);
		
		HttpUtil.forward(req, resp, "bulletin/searchBulletin.tiles");
		

	}

}
