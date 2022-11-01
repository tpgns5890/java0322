package co.edu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.member.MemberVO;
import co.edu.service.MemberDAO;

@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		
//		 [{"id": "user1", "name": "홍길동", "email": "email@email.com", "responsibility":
//		 "user"},{},{},{}...]
//		 3건. 1,2,3
//		String json = "[";
//		for (int i = 0; i < list.size(); i++) {
//			json += "{\"id\": \"" + list.get(i).getId() //
//					+ "\", \"name\": \"" + list.get(i).getName() //
//					+ "\", \"email\": \"" + list.get(i).getEmail() //
//					+ "\", \"responsibility\": \"" + list.get(i).getResposibility() + "\"}";
//			if (i < list.size() - 1) {
//				json += ",";
//			}
//		}
//		json += "]";
		
		Gson gson = new GsonBuilder().create();
		
		response.getWriter().print(gson.toJson(list));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		String job = request.getParameter("job");
		
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO(); 
		
		String id = request.getParameter("id");
		//job => 등록, 삭제 구분.
		if(job.equals("delete")) {
			if(dao.deleteMember(id)) {
				response.getWriter().print("success");
			}else {
				response.getWriter().print("fail");
			}
			
		}else if(job.equals("insert")) {
			String pw = request.getParameter("passwd");
			String em = request.getParameter("email");
			String nm = request.getParameter("name");
			
			
			vo.setId(id);
			vo.setPw(pw);
			vo.setEmail(em);
			vo.setName(nm);
			
			
			dao.insertMember(vo);
			
			Gson gson = new GsonBuilder().create(); //gson 인스턴스 호출.
//			gson.toJson(vo); //{"id":"user1","passwd":...??}
			response.getWriter().print(gson.toJson(vo));
		}
		
	}
}
