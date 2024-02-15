package test.com.board;

import java.util.List;

public class Mission02Main {

	public static void main(String[] args) {
		System.out.println("Mission02...board...jdbc");

		// 앞서 진행한 프로젝트 java25jdbc를 참고하여
		// JAVA계정의 BOARD테이블과 연동하는 프로그램을 작성하세요.
		// 작성후 슬랙에 업로드 : 프로젝트를 압축해서 올리기

		// ojdbc6.jar파일을 오라클 홈경로에서 복사해올것.
		// build path >> Add to build path
		// 1.********************************
		// jdbc driver 연결
		// 생성자에서 Class.forName()메소드로 라이브러리탐색
		// **********************************
		BoardDAO dao = new BoardDAOimpl();
		System.out.println("================");

		// 4.********************************
		// BoardDAOimpl 에서 오라클데이터베이스의
		// JAVA사용자계정 안에 Board테이블에
		// 들어있는 모든내용 중
		// 메인에서 VO에 담아서 전달한 번호의 게시글정보만 받아서
		// 메인에서 출력하세요
		// **********************************
		// 4.selectOne
//		BoardVO vo = new BoardVO();
//		vo.setNum(21);
//
//		BoardVO vo2 = dao.selectOne(vo);
//		System.out.println("vo2:" + vo2);
//		System.out.println("================");

		// 5.********************************
		// MemberDAOimple 에서 오라클데이터베이스의
		// JAVA사용자계정 안에 MEMBER테이블에
		// 들어있는 모든내용 중
		// 메인에서 VO에 담아서 전달한 내용(번호,아이디,비번,이름,폰번)으로
		// 회원정보를 변경하고 성공하면 1을 반환하도록
		// 메인에서 출력하세요
		// **********************************
		// 5.update
//		vo = new BoardVO();
//		vo.setNum(8);
//		vo.setTitle("html5555");
//		vo.setContent("hello html...");
//		vo.setWriter("admin3");
//
//		int result = dao.update(vo);
//		System.out.println("result:" + result);
//		System.out.println("================");

		// 6.********************************
		// 새로운 회원의 정보를
		// 메인에서 VO에 담아서 전달한 내용(제목,내용,작성자)으로
		// 게시글정보를 추가하고 성공하면 1을 반환하도록
		// 메인에서 출력하세요
		// **********************************
//		 for (int i = 0; i < 10; i++) {
//			if(i>5) {
//				//6.insert
//				vo = new BoardVO();
//				vo.setTitle("java"+i);
//				vo.setContent("hello java..."+i);
//				vo.setWriter("admin");//UK
//
//				int result = dao.insert(vo);
//				System.out.println("result:" + result);
//				System.out.println("================");
//			}else {
//				//6.insert
//				vo = new BoardVO();
//				vo.setTitle("html6666"+i);
//				vo.setContent("hello html66..."+i);
//				vo.setWriter("tester8");//UK
//
//				int result = dao.insert(vo);
//				System.out.println("result:" + result);
//				System.out.println("================");
//			}
//		}//end for

		// 7.********************************
		// 메인에서 VO에 담아서 전달한 내용(번호)으로
		// 게시글정보를 삭제하고 성공하면 1을 반환하도록
		// 메인에서 출력하세요
		// **********************************
		// 7.delete
//		vo = new BoardVO();
//		vo.setNum(9);
//
//		int result = dao.delete(vo);
//		System.out.println("result:" + result);
//		System.out.println("================");
		//

		// 2.********************************
		// BoardDAOimpl 에서 오라클데이터베이스의
		// JAVA사용자계정 안에 Board테이블에
		// 들어있는 모든내용을 메인에서 출력하세요
		// **********************************
		// selectAll
//		List<BoardVO> vos = dao.selectAll();
//		for (BoardVO x : vos) {
//			System.out.println(x);
//		}
//		System.out.println("================");

		// 3.********************************
		// BoardDAOimpl 에서 오라클데이터베이스의
		// JAVA사용자계정 안에 Board테이블에
		// 들어있는 모든내용중
		// 3-1.검색키가 title 검색어가 ja인
		// 회원들만 메인에서 출력하세요
		// 3-2.그리고 검색키가 content이고 검색어가 he인
		// 게시글들만 메인에서 출력하세요
		// **********************************
		// 3.searchList
		// 3-1.
		System.out.println("===title=============");
		List<BoardVO> vos = dao.searchList("title", "ja");
		for (BoardVO x : vos) {
			System.out.println(x);
		}
		System.out.println("================");

//		System.out.println("===content=============");
//		vos = dao.searchList("content", "a4");
//		for (BoardVO x : vos) {
//			System.out.println(x);
//		}
//		System.out.println("================");

	}// end main

}// end class
