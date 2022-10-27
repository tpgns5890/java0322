package co.edu.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.board.BoardVO;
import co.edu.board.PageVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.dao.BoardDAO;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class BulletinControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		
		String page = req.getParameter("page");
		page = page == null ? "1" : page; 
		int pg = Integer.parseInt(page); //입력페이지.
		int totalPage = dao.totalCnt(); //전체페이지.
		
		PageVO paging = new PageVO(totalPage,pg); //전체페이지, 입력페이지.
		
		BoardService service = new BoardServiceImpl();
		List<BoardVO> list = service.pageList(pg); // service.getList(new BoardVO(0, "", "", "", "", 0, ""));
		
		for(BoardVO vo : list) {
			System.out.println(vo.getBoardNo());
		}
		
		//값 넘기기 => 속성값 세팅 .
		req.setAttribute("bList", list);  //리스트
		req.setAttribute("page", paging); //페이지
		
		//경로지정.
		HttpUtil.forward(req, resp, "bulletin/bulletin.tiles");
		
	}

}