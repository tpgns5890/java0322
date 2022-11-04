package co.edu.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.book.BookVO;

public class BookDAO extends DAO{
	public List<BookVO> bookList() {
		getConnect();
		String sql = "select * from tbl_book";
		List<BookVO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getString(1));
				vo.setBookName(rs.getString(2));
				vo.setAuthor(rs.getString(3));
				vo.setPress(rs.getString(4));
				vo.setPrice(rs.getInt(5));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return list;
	}

	public void deleteMember(String id) {
		
	}

	public void insertBook(BookVO vo) {
		getConnect();
		String sql = "insert into tbl_book (book_code, book_name, author, press, price) values( ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookCode());
			psmt.setString(2, vo.getBookName());
			psmt.setString(3, vo.getAuthor());
			psmt.setString(4, vo.getPress());
			psmt.setInt(5, vo.getPrice());
			psmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}

	public void deleteBook(String id) {
		getConnect();
		String sql = "delete from tbl_book where book_code =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
	}
	
}
