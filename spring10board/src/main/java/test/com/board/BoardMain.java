package test.com.board;

import java.util.List;

public class BoardMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Board....");
		
		BoardDAO dao = new BoardDAOimpl();
		
		//1.insert
		BoardVO vo = new BoardVO();
		vo.setNum(11);
		vo.setTitle("java");
		vo.setContent("hello");
		vo.setWriter("admin3");
		vo.setWdate("2024-01-09");
		
		int result = dao.insert(vo);
		System.out.println("result:"+result);
		System.out.println("===========");
		
		//2.update
		vo = new BoardVO();
		vo.setNum(11);
		vo.setTitle("java");
		vo.setContent("hello");
		vo.setWriter("admin");
		vo.setWdate("2024-01-09");
		
		result = dao.update(vo);
		System.out.println("result:"+result);
		System.out.println("===========");
		
		
		//3.delete
		vo = new BoardVO();
		vo.setNum(11);
		vo.setTitle("java");
		vo.setContent("hello");
		vo.setWriter("admin");
		vo.setWdate("2024-01-09");
		
		result = dao.delete(vo);
		System.out.println("result:"+result);
		System.out.println("===========");
		
		
		//4.selectOne
		vo = new BoardVO();
		vo.setNum(11);
		vo.setTitle("java");
		vo.setContent("hello");
		vo.setWriter("admin");
		vo.setWdate("2024-01-09");
		
		BoardVO vo2 = dao.selectOne(vo);
		System.out.println("vo2:"+vo2);
		System.out.println("===========");
		
		//5.selectAll
		List<BoardVO> vos = dao.selectAll();
		System.out.println("vos.size():"+vos.size());
		for (BoardVO x : vos) {
			System.out.println(x);
		}
		System.out.println("===========");
		
		
		//6.searchList
		vos = dao.searchList("title","ja");
		System.out.println("vos.size():"+vos.size());
		for (BoardVO x : vos) {
			System.out.println(x);
		}
		System.out.println("===========");
		
		
		
		
		
		
		
		
		
		
		
		
	}//end main

}//end class
