package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.common.Controller;
import co.test.common.HttpUtil;
import co.test.service.BookService;
import co.test.vo.BookVO;

public class ModifyBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("bookCode");
		String title = request.getParameter("bookTitle");
		String author = request.getParameter("bookAuthor");
		String press = request.getParameter("bookPress");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		
			
		BookVO vo = new BookVO(code, title, author, press, price);
				
		//DB입력처리
		BookService service = new BookService();
		service.modifyBook(vo);
		
		HttpUtil.forward(request, response, "WEB-INF/result/modifyOutput.jsp");
	}

}
