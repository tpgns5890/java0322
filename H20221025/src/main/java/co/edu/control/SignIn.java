package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.board.MemberVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class SignIn implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//아이디,패스워드 => 검증 맞으면 session객체에 id값을 저장.
		//세션에 값이 있으면 아이디, 없으면 손님 출력하게..
		
		String id = req.getParameter("id");
		String pw =req.getParameter("pw");
		
		BoardService service = new BoardServiceImpl();
		MemberVO result = service.loginCheck(id,pw);
		
		if(result != null) {
			req.setAttribute("logInfo", result);
			
			HttpSession session = req.getSession();
			session.setAttribute("id", result.getId());
			session.setAttribute("pw", result.getPw());
			
			
			// 로그인 성공했습니다. signIn.jsp(로그인성공페이지)
			HttpUtil.forward(req, resp, "member/signIn.tiles");
			
		}else {
			// 로그인 성공했습니다. signIn.jsp(로그인페이지)
			HttpUtil.forward(req, resp, "member/signInForm.tiles");
		}
		
		
		
		


	}

}