package co.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.book.BookVO;
import co.edu.common.BookDAO;

@WebServlet("/BookAddServlet")
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		BookVO vo = new BookVO();
		BookDAO dao = new BookDAO(); 
		response.setContentType("text/json;charset=utf-8");
		String code = request.getParameter("bookCode");
		String name = request.getParameter("bookName");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		int price = Integer.parseInt(request.getParameter("price"));
		
		
		
		vo.setBookCode(code);
		vo.setBookName(name);
		vo.setAuthor(author);
		vo.setPress(press);
		vo.setPrice(price);
		
		
		dao.insertBook(vo);
		
		Gson gson = new GsonBuilder().create(); //gson 인스턴스 호출.
//		gson.toJson(vo); //{"id":"user1","passwd":...??}
		response.getWriter().print(gson.toJson(vo));
	}

}
