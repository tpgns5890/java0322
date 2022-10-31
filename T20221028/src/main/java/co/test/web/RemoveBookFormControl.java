package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.common.Controller;
import co.test.common.HttpUtil;
import co.test.service.BookService;
import co.test.vo.BookVO;

public class RemoveBookFormControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("bookCode");
		String job = request.getParameter("job");
		request.setAttribute("bookCode", code);
		
		BookService service = new BookService();
		BookVO book = service.findBook(code);
		request.setAttribute("bookInfo", book);
		
		HttpUtil.forward(request, response, "WEB-INF/view/remove.jsp");
	}

}
