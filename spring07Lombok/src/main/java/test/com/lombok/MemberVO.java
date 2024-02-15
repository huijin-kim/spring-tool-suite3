package test.com.lombok;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
@AllArgsConstructor
public class MemberVO implements Serializable {

	private int num;
	private String id;
	private String pw;
	private String name;
	private String tel;

}
