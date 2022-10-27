package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;
import co.edu.dao.BoardDAO;

public class BoardServiceImpl implements BoardService{

	BoardDAO dao = new BoardDAO();
	
	@Override
	//게시글 작성
	public BoardVO insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	//게시글 리스트
	public List<BoardVO> getList(BoardVO vo) {
		return dao.boardList(vo);
	}

	@Override
	//게시글 상세조회
	public BoardVO findBoard(int id) {
		return dao.searchBoard(id);
	}

	@Override
	//게시글 수정
	public boolean updateBoard(BoardVO vo) {
		
		return false;
	}

	@Override
	//게시글 삭제
	public boolean deleteBoard(int boardNo) {
		
		return false;
	}

	@Override
	//게시글 페이징목록
	public List<BoardVO> pageList(int page) {
		return dao.pageList(page);
	}

	@Override
	//회원가입
	public List<MemberVO> signup(MemberVO vo) {
		return dao.signUp(vo);
	}

	@Override
	//회원목록
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	@Override
	public MemberVO loginCheck(String id, String pw) {
		return dao.loginCheck(id, pw);
	}
	
	

}