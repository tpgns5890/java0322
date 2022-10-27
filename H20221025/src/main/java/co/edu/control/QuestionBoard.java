package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.edu.board.BoardVO;
import co.edu.common.Control;
import co.edu.common.HttpUtil;
import co.edu.service.BoardService;
import co.edu.service.BoardServiceImpl;

public class QuestionBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String saveDir = req.getServletContext().getRealPath("upload");
		System.out.println(saveDir);
		String encod = "UTF-8";
		int maxSize = 5 * 1024 * 1024;
		
		MultipartRequest mr =  new MultipartRequest(
				req, // 요청정보
				saveDir, // 저장위치
				maxSize, // 파일크기
				encod, // 인코딩
				new DefaultFileRenamePolicy() //같은이름 파일 재지정.(덮어쓰기x)
				);
		
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		String writer = mr.getParameter("writer");
		String image = mr.getFilesystemName("image");
		
		//디비입력
		BoardService service = new BoardServiceImpl();
		service.insertBoard(new BoardVO(0, title, content, writer, null, 0, image));
		
		
		HttpUtil.forward(req, resp, "question/questionOut.tiles");
	}

}