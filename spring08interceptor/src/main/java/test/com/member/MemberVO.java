package test.com.member;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class MemberVO implements Serializable {

	private int num;
	private String id;
	private String pw;
	private String name;
	private String tel;


}
