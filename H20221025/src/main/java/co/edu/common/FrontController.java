package co.edu.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.control.BulletinControl;
import co.edu.control.MainControl;
import co.edu.control.MemberList;
import co.edu.control.QuestionForm;
import co.edu.control.QuestionBoard;
import co.edu.control.SearchBoard;
import co.edu.control.SignUp;
import co.edu.control.SignUpForm;
import co.edu.control.SignInForm;
import co.edu.control.SignOut;
import co.edu.control.WriteBoard;
import co.edu.control.WriteForm;
import co.edu.control.SignIn;

public class FrontController extends HttpServlet{
	
	HashMap<String, Control> controlList;
	String charset;
	
	// init()
	
//	@Override
//	public void init() throws ServletException {
//		
//		ServletContext sc = this.getServletContext();
//		sc.getInitParameter("charset");
//		
//	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		charset = config.getInitParameter("charset"); //utf-8
		controlList = new HashMap<String, Control>();
		
		//메뉴버튼 : menu.jsp에서 호출.
		
		//게시판
		controlList.put("/main.do", new MainControl());
		controlList.put("/bulletin.do", new BulletinControl());
		controlList.put("/searchBoard.do", new SearchBoard());
		controlList.put("/writeBoardForm.do", new WriteForm());
		controlList.put("/writeBoard.do", new WriteBoard());
		
		//문의글
		controlList.put("/questionForm.do", new QuestionForm());
		controlList.put("/questionBoard.do", new QuestionBoard());
		
		//회원가입(id,pw,name,email)
		controlList.put("/signupFrom.do", new SignUpForm()); //회원가입 화면
		controlList.put("/signUp.do", new SignUp()); //회원가입처리. => 회원가입되었습니다.
		controlList.put("/memberList.do", new MemberList()); 
		
		//로그인,로그아웃
		controlList.put("/signInForm.do", new SignInForm()); //로그인화면
		controlList.put("/signIn.do", new SignIn()); //로그인
		controlList.put("/signOut.do", new SignOut()); //로그아웃
		
		
		
	}
	
	// service()
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글처리..
		req.setCharacterEncoding(charset); 
		resp.setCharacterEncoding(charset);
		
		String uri = req.getRequestURI(); // http://localhost:8081/H20221025/main.do
		String context = req.getContextPath(); // /H20221025
		String path = uri.substring(context.length());
		
		//실행위치 파악!!
		System.out.println(path); 
		
		Control subControl = controlList.get(path); 
		subControl.exec(req, resp); // /main.do => control 실행
		
	}
	
}