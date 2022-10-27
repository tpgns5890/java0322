package co.edu.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String resposibility;

	
	public MemberVO() {}
	public MemberVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public MemberVO(String id, String pw, String name, String email, String resposibility) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.resposibility = resposibility;
	}

}