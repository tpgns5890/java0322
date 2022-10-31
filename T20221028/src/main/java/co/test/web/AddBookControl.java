package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.common.Controller;
import co.test.common.HttpUtil;
import co.test.dao.BookDAO;
import co.test.service.BookService;
import co.test.vo.BookVO;

public class AddBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = new BookService();
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		int price = (Integer.parseInt(request.getParameter("price")));
		
		service.addBook(new BookVO(null, title, author, press, price));
		
		HttpUtil.forward(request, response, "WEB-INF/result/addOutput.jsp");
	}

}
