package test.com.member;

import java.util.List;

public class Mission01Main {

	public static void main(String[] args) {
		System.out.println("jdbc....");
		// ojdbc6.jar파일을 오라클 홈경로에서 복사해올것.
		// build path >> Add to build path
		// 1.********************************
		// jdbc driver 연결
		// 생성자에서 Class.forName()메소드로 라이브러리탐색
		// **********************************
		MemberDAO dao = new MemberDAOimpl();
		System.out.println("================");

		// 2.********************************
		// MemberDAOimple 에서 오라클데이터베이스의
		// JAVA사용자계정 안에 MEMBER테이블에
		// 들어있는 모든내용을 메인에서 출력하세요
		// **********************************
		// selectAll
//		List<MemberVO> vos = dao.selectAll();
//		for (MemberVO x : vos) {
//			System.out.println(x);
//		}
//		System.out.println("================");

		// 3.********************************
		// MemberDAOimple 에서 오라클데이터베이스의
		// JAVA사용자계정 안에 MEMBER테이블에
		// 들어있는 모든내용중
		// 3-1.검색키가 아이디이고 검색어가 admin인
		// 회원들만 메인에서 출력하세요
		// 3-2.그리고 검색키가 이름이고 검색어가 lee인
		// 회원들만 메인에서 출력하세요
		// **********************************
		// 3.searchList
		// 3-1.
//		System.out.println("===id=============");
//		vos = dao.searchList("id", "te");
//		for (MemberVO x : vos) {
//			System.out.println(x);
//		}

//		// 3-2.
//		System.out.println("===name=============");
//		vos = dao.searchList("name", "le");
//		for (MemberVO x : vos) {
//			System.out.println(x);
//		}
//		System.out.println("================");

		// 4.********************************
		// MemberDAOimple  에서 오라클데이터베이스의
		// JAVA사용자계정 안에 MEMBER테이블에
		// 들어있는 모든내용 중
		// 메인에서 VO에 담아서 전달한 번호의 회원정보만 받아서
		// 메인에서 출력하세요
		// **********************************
//		// 4.selectOne
//		MemberVO vo = new MemberVO();
//		vo.setNum(5);
//
//		MemberVO vo2 = dao.selectOne(vo);
//		System.out.println("vo2:" + vo2);
//		System.out.println("================");

		// 5.********************************
		// MemberDAOimple   에서 오라클데이터베이스의
		// JAVA사용자계정 안에 MEMBER테이블에
		// 들어있는 모든내용 중
		// 메인에서 VO에 담아서 전달한 내용(번호,아이디,비번,이름,폰번)으로
		// 회원정보를 변경하고 성공하면 1을 반환하도록
		// 메인에서 출력하세요
		// **********************************
		// 5.update
//		vo = new MemberVO();
//		vo.setNum(16);
//		vo.setPw("hi8888");
//		vo.setName("kim888");
//		vo.setTel("0888");
//
//		int result = dao.update(vo);
//		System.out.println("result:" + result);
//		System.out.println("================");
//
		// 6.********************************
		// MemberDAOimple 에서 오라클데이터베이스의
		// JAVA사용자계정 안에 MEMBER테이블에
		// 새로운 회원의 정보를
		// 메인에서 VO에 담아서 전달한 내용(번호,아이디,비번,이름,폰번)으로
		// 회원정보를 추가하고 성공하면 1을 반환하도록
		// 메인에서 출력하세요
		// **********************************
//		for (int i = 5; i < 10; i++) {
//			// 6.insert
//			vo = new MemberVO();
//			vo.setId("tester"+i);//UK
//			vo.setPw("hi1111"+i);
//			vo.setName("kim"+i);
//			vo.setTel("064"+i);
//
//			int result = dao.insert(vo);
//			System.out.println("result:" + result);
//			System.out.println("================");
//		}
//
		// 7.********************************
		// MemberDAOimple 에서 오라클데이터베이스의
		// JAVA사용자계정 안에 MEMBER테이블에
		// 메인에서 VO에 담아서 전달한 내용(번호)으로
		// 회원정보를 삭제하고 성공하면 1을 반환하도록
		// 메인에서 출력하세요
		// **********************************
		// 7.delete
//		vo = new MemberVO();
//		vo.setNum(19);
//
//		int result = dao.delete(vo);
//		System.out.println("result:" + result);
//		System.out.println("================");
//
//		// 잘 수정,입력,삭제되었는지 selectAll로 확인...
//		vos = dao.selectAll();
//		for (MemberVO x : vos) {
//			System.out.println(x);
//		}
//		System.out.println("================");

	}// end main

}// end class
