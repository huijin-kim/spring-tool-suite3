//package test.com.member;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet implementation class MemberController
// */
//@WebServlet({ "/index.do", "/m_selectAll.do", "/m_insert.do", "/login.do",
//	"/m_selectOne.do", "/m_delete.do",
//		"/m_update.do", "/m_searchList.do", "/m_insertOK.do", "/loginOK.do", "/logout.do", "/m_deleteOK.do",
//		"/m_updateOK.do" })
//public class MemberController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private MemberDAO dao = new MemberDAOimpl();
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public MemberController() {
//		super();
//		System.out.println("MemberController()...");
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("doGet()...");
////		response.getWriter().append("Served at: ")
////		.append(request.getContextPath())
////		.append(request.getServletPath());
//
//		String sPath = request.getServletPath();
//		if (sPath.equals("/index.do")) {
//
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		} else if (sPath.equals("/m_selectAll.do")) {
//
//			int cpage = Integer.parseInt(request.getParameter("cpage") == null ? "1" : request.getParameter("cpage"));
//			int pageBlock = 5;
//
////		 	List<MemberVO> vos = dao.selectAll();
//			List<MemberVO> vos = dao.selectAll(cpage, pageBlock);
//			for (MemberVO x : vos) {
//				System.out.println(x);
//			}
//			System.out.println("================");
//
//			request.setAttribute("vos", vos);
//
//			// member테이블에 들어있는 모든회원수는 몇명?
//			int total_rows = dao.getTotalRows();
//			System.out.println("total_rows:" + total_rows);
//
//			int totalPageCount = 1;
//			if (total_rows / pageBlock == 0) {
//				totalPageCount = 1;
//			} else if (total_rows % pageBlock == 0) {
//				totalPageCount = total_rows / pageBlock;
//			} else {
//				totalPageCount = total_rows / pageBlock + 1;
//			}
//			// 페이지 링크 몇개?
//			request.setAttribute("totalPageCount", totalPageCount);
//
//			request.getRequestDispatcher("member/selectAll.jsp").forward(request, response);
//
//		} else if (sPath.equals("/m_insert.do")) {
//
//			request.getRequestDispatcher("member/insert.jsp").forward(request, response);
//		} else if (sPath.equals("/login.do")) {
//
//			request.getRequestDispatcher("member/login.jsp").forward(request, response);
//		} else if (sPath.equals("/m_selectOne.do")) {
//
//			System.out.println(request.getParameter("num"));
//
//			MemberVO vo = new MemberVO();
//			vo.setNum(Integer.parseInt(
//					request.getParameter("num") == null || request.getParameter("num").trim().length() == 0 ? "0"
//							: request.getParameter("num")));
//
//			MemberVO vo2 = dao.selectOne(vo);
//			System.out.println("vo2:" + vo2);
//			System.out.println("================");
//
//			request.setAttribute("vo2", vo2);
//
//			request.getRequestDispatcher("member/selectOne.jsp").forward(request, response);
//		} else if (sPath.equals("/m_delete.do")) {
//
//			request.getRequestDispatcher("member/delete.jsp").forward(request, response);
//		} else if (sPath.equals("/m_update.do")) {
//
//			System.out.println(request.getParameter("num"));
//
//			MemberVO vo = new MemberVO();
//			vo.setNum(Integer.parseInt(
//					request.getParameter("num") == null || request.getParameter("num").trim().length() == 0 ? "0"
//							: request.getParameter("num")));
//
//			MemberVO vo2 = dao.selectOne(vo);
//			System.out.println("vo2:" + vo2);
//			System.out.println("================");
//
//			request.setAttribute("vo2", vo2);
//			
//			request.getRequestDispatcher("member/update.jsp").forward(request, response);
//		} else if (sPath.equals("/m_searchList.do")) {
//
//			System.out.println(request.getParameter("searchKey"));
//			System.out.println(request.getParameter("searchWord"));
//
//			String searchKey = request.getParameter("searchKey");
//			String searchWord = request.getParameter("searchWord");
//
//			int cpage = Integer.parseInt(request.getParameter("cpage") == null ? "1" : request.getParameter("cpage"));
//			int pageBlock = 5;
//
////		 	List<MemberVO> vos = dao.searchList(searchKey, searchWord);
//			List<MemberVO> vos = dao.searchList(searchKey, searchWord, cpage, pageBlock);
//			for (MemberVO x : vos) {
//				System.out.println(x);
//			}
//			System.out.println("================");
//
//			request.setAttribute("vos", vos);
//
//			// 키워드검색 모든회원수는 몇명?
//			int total_rows = dao.getSearchTotalRows(searchKey, searchWord);
//			System.out.println("total_rows:" + total_rows);
//
//			int totalPageCount = 1;
//			if (total_rows / pageBlock == 0) {
//				totalPageCount = 1;
//			} else if (total_rows % pageBlock == 0) {
//				totalPageCount = total_rows / pageBlock;
//			} else {
//				totalPageCount = total_rows / pageBlock + 1;
//			}
//			// 페이지 링크 몇개?
//			request.setAttribute("totalPageCount", totalPageCount);
//
//			request.getRequestDispatcher("member/selectAll.jsp").forward(request, response);
//		} else if (sPath.equals("/m_insertOK.do")) {
//			// /insertOK.jsp?id=admin&pw=hi1111&name=kim&tel=010
//			System.out.println(request.getParameter("id"));
//			System.out.println(request.getParameter("pw"));
//			System.out.println(request.getParameter("name"));
//			System.out.println(request.getParameter("tel"));
//
//			MemberVO vo = new MemberVO();
//			vo.setId(request.getParameter("id"));// UK
//			vo.setPw(request.getParameter("pw"));
//			vo.setName(request.getParameter("name"));
//			vo.setTel(request.getParameter("tel"));
//
//			int result = dao.insert(vo);
//			System.out.println("result:" + result);
//			System.out.println("================");
//
//			if (result == 1) {
//				response.sendRedirect("m_selectAll.do");
//			} else {
//				response.sendRedirect("m_insert.do");
//			}
//		} else if (sPath.equals("/loginOK.do")) {
//			// /loginOK.jsp?id=admin&pw=hi1234
//			System.out.println(request.getParameter("id"));
//			System.out.println(request.getParameter("pw"));
//
//			MemberVO vo = new MemberVO();
//			vo.setId(request.getParameter("id"));
//			vo.setPw(request.getParameter("pw"));
//
//			// 아이디,비번을 검색해주는 로직을 구현하세요.
//			MemberVO vo2 = dao.login(vo);
//			System.out.println(vo2);
//			System.out.println("================");
//
//			if (vo2 == null) {
//				response.sendRedirect("login.do");
//			} else {
//				response.sendRedirect("index.do");
//
//				request.getSession().setAttribute("user_id", vo2.getId() + "[" + vo2.getName() + "]");
//				
//				
//			}
//		} else if (sPath.equals("/logout.do")) {
//			request.getSession().removeAttribute("user_id");
//			response.sendRedirect("index.jsp");
//		} else if (sPath.equals("/m_deleteOK.do")) {
//			// /deleteOK.jsp?num=1
//			System.out.println(request.getParameter("num"));
//
//			MemberVO vo = new MemberVO();
//			vo.setNum(Integer.parseInt(
//					request.getParameter("num") == null || request.getParameter("num").trim().length() == 0 ? "0"
//							: request.getParameter("num")));
//
//			int result = dao.delete(vo);
//			System.out.println("result:" + result);
//			System.out.println("=====================");
//
//			if (result == 1) {
//				response.sendRedirect("m_selectAll.do");
//			} else {
//				response.sendRedirect("m_delete.do?num=" + request.getParameter("num"));
//			}
//		} else if (sPath.equals("/m_updateOK.do")) {
//			// /updateOK.jsp?num=1&pw=hi1111&name=kim&tel=010
//			System.out.println(request.getParameter("num"));
//			System.out.println(request.getParameter("pw"));
//			System.out.println(request.getParameter("name"));
//			System.out.println(request.getParameter("tel"));
//
//			MemberVO vo = new MemberVO();
//			vo.setNum(Integer.parseInt(
//					request.getParameter("num") == null || request.getParameter("num").trim().length() == 0 ? "0"
//							: request.getParameter("num")));
//			vo.setPw(request.getParameter("pw"));
//			vo.setName(request.getParameter("name"));
//			vo.setTel(request.getParameter("tel"));
//
//			int result = dao.update(vo);
//			System.out.println("result:" + result);
//			System.out.println("================");
//
//			if (result == 1) {
//				response.sendRedirect("m_selectOne.do?num=" + request.getParameter("num"));
//			} else {
//				response.sendRedirect("m_update.do?num=" + request.getParameter("num"));
//			}
//		}
//
//	}// end doGet
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//	 *      response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("doPost()...");
//
//		request.setCharacterEncoding("UTF-8");// post요청시 한글처리
//
//		doGet(request, response);
//	}// end doPost
//
//}
