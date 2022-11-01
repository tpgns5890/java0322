package co.edu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.member.MemberVO;

public class MemberDAO extends DAO {

	//한건 삭제
	public boolean deleteMember(String id) {
		getConnect();
		String sql = "delete from members where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,id);
			int r = psmt.executeUpdate();
			if(r>0) 
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return false;
	}
	
	// 한건등록.
	public void insertMember(MemberVO vo) {
		getConnect();
		String sql = "insert into members (id, passwd, name, email, responsibility) values(?,?,?,?,'user')";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());

			psmt.executeUpdate();
			
			vo.setResposibility("user");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}

	}

	// 전체목록.
	public List<MemberVO> memberList() {
		getConnect();
		List<MemberVO> list = new ArrayList<>();
		String sql = "select * from members order by id";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setResposibility(rs.getString("responsibility"));

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
