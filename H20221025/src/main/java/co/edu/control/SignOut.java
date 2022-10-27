package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.edu.common.Control;
import co.edu.common.HttpUtil;

public class SignOut implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그아웃
		HttpSession session = req.getSession();
		session.invalidate();//세션의 모든 속성 제거
		
		
		
		//로그인화면으로 이동.
		HttpUtil.forward(req, resp, "member/signInForm.tiles");
	}

}