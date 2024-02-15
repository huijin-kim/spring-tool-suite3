package test.com.board;

import java.io.Serializable;

import lombok.Data;

@Data
public class BoardVO implements Serializable{

	private int num;
	private String title;
	private String content;
	private String writer;
	private String wdate;

}
