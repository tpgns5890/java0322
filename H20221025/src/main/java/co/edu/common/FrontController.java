package co.edu.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.control.BulletinControl;
import co.edu.control.MainControl;
import co.edu.control.WriteBoard;
import co.edu.control.WriteForm;

public class FrontController extends HttpServlet{
	
	HashMap<String, Control> controlList;
	String charset = null;
	
	//init()
//	@Override
//	public void init() throws ServletException {
//		ServletContext sc = this.getServletContext();
//		sc.getInitParameter("charset");
//	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset");
		controlList = new HashMap<String, Control>();
		
		controlList.put("/main.do", new MainControl());
		controlList.put("/bulletin.do", new BulletinControl());
		
		controlList.put("/searchBoard.do", new SearchBoard());
		controlList.put("/writeBoardForm.do", new WriteForm());
		controlList.put("/writeBoard.do", new WriteBoard());
		
		//ggldlw
		controlList.put("/signUpFrom.do", new SignUpForm());
		controlList.put("/signUp.do", new SignUp());
		controlList.put("/memberList.do", new MemberList());
		
		controlList.put("/signInForm", new SignInForm());
		controlList.put("signIn", new SignIn());
		
	}
	
	
	//service()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(charset);//한글처리
		resp.setCharacterEncoding(charset);
		String uri = req.getRequestURI(); // http://localhost:8081/H20221025/main.do
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		
		System.out.println(path);
		Control subControl = controlList.get(path);
		subControl.exec(req, resp); // main.do => control실행.
	}
}
