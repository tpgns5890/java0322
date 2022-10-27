package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;
import co.edu.common.DAO;
import javassist.compiler.ast.Member;

public class BoardDAO extends DAO {
	// 입력,조회,수정,삭제...

	// 입력
	public BoardVO insertBoard(BoardVO vo) {
		// 입력처리중 에러가 발생하면.. null;
		conn = getConnect();
		String sql1 = "select board_seq.nextval from dual";
		String sql2 = "insert into tbl_board (board_no, title, content, writer,image) " + "VALUES(?, ?, ?, ?,?)";
		try {
			psmt = conn.prepareStatement(sql1);
			rs = psmt.executeQuery();
			int nextSeq = 0;
			if (rs.next()) {
				nextSeq = rs.getInt(1);
			}
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, nextSeq);
			psmt.setString(2, vo.getTitle());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getWriter());
			psmt.setString(5, vo.getImage());
			int r = psmt.executeUpdate();
			if (r > 0) {
				vo.setBoardNo(nextSeq);
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null; // 실패할 경우 null을 반환
	}

	// 한건조회
	public BoardVO searchBoard(int boardNo) {
		conn = getConnect();
		String sql = "select * from tbl_board where board_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));
				return board;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 게시글 검색
	public List<BoardVO> boardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList<>();
		conn = getConnect();
		String sql = "select* from tbl_board " //
				+ "where 1 = 1 " //
				+ "and title like '%'||?||'%' " //
				+ "and content like '%'||?||'%' " //
				+ "and writer like '%'||?||'%' "; //
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());

			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));
				list.add(board);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return null;
	}

	// 수정
	public boolean updateBoard(BoardVO vo) {
		// 처리건수가 0이면 false;
		conn = getConnect();
		String sql = "update tbl_board " + "set content = ? " + "where board_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContent());
			psmt.setInt(2, vo.getBoardNo());
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false;
	}

	// 삭제
	public boolean deleteBoard(int boardNo) {
		// 처리건수가 0이면 false;
		conn = getConnect();
		String sql = "delete from tbl_board where board_no = ? ";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 페이지, 전체건수/ 10개씩, 검색결과 전체건수/10개씩
	public int totalCnt() {
		conn = getConnect();
		String sql = "select count(1) from tbl_board ";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				int cnt = rs.getInt(1);
				return cnt;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return 0;
	}

	public List<BoardVO> pageList(int page) {
		List<BoardVO> list = new ArrayList<>();
		conn = getConnect();
		String sql = "select b.* from " + "    (select ROWNUM rn, a.* " + "    from (select * from tbl_board "
				+ "        order by board_no desc) a " + "    where ROWNUM <= ?) b " + " where b.rn >= ? ";
		int from = (page - 1) * 10 + 1; // 1, 11
		int to = (page * 10); // 10, 20
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, to);
			psmt.setInt(2, from);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				board.setWriteDate(rs.getString("write_date"));
				board.setClickCnt(rs.getInt("click_cnt"));
				board.setImage(rs.getString("image"));
				list.add(board);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	// 회원가입
	public List<MemberVO> signUp(MemberVO vo) {
		List<MemberVO> list = new ArrayList<>();
		getConnect();
		String sql = "insert into members(id,passwd,name,email,resposibility) " + "values(?,?,?,?,'user')";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());

			int r = psmt.executeUpdate();
			if (r > 0) {
				System.out.println("회원가입 완료");
				String id = vo.getId();
				String pw = vo.getPw();
				String name = vo.getName();
				String email = vo.getEmail();
				list.add(new MemberVO(id, pw, name, email, vo.getResposibility()));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 로그인
	public MemberVO loginCheck(String id, String pw) {
		MemberVO vo = null;
		getConnect();
		String sql = "select *  "
				+ "from members "
				+ "where id = ? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(rs.getString("id"),rs.getString("passwd"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	
	//회원목록 출력 for member/memberList.jsp에서 jstl 이용
	public List<MemberVO> memberList(){
		List<MemberVO>list = new ArrayList<>();
		getConnect();
		String sql = "select * from members";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("passwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				list.add(vo);		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
}