//package test.com.board;
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
//import test.com.comments.CommentsDAO;
//import test.com.comments.CommentsDAOimpl;
//import test.com.comments.CommentsVO;
//
///**
// * Servlet implementation class BoardController
// */
//@WebServlet({ "/index.do", "/b_insert.do", "/b_insertOK.do", 
//	"/b_update.do","/b_updateOK.do", "/b_searchList.do",
//	"/b_selectAll.do","/b_selectOne.do","/b_delete.do" ,"/b_deleteOK.do" })
//public class BoardController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	private BoardDAO dao = new BoardDAOimpl();
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public BoardController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doGet().....");
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//		String sPath = request.getServletPath();
//		
//		if(sPath.equals("/index.do")) {
//			
//			//로그인테스트용 세션
//			request.getSession().setAttribute("user_id", "admin");
////			request.getSession().setAttribute("user_id", "tester8");
//			
//			
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		}else if(sPath.equals("/b_insert.do")) {
//			request.getRequestDispatcher("board/insert.jsp").forward(request, response);
//		}else if(sPath.equals("/b_insertOK.do")) {
//			
//			System.out.println(request.getParameter("title"));
//			System.out.println(request.getParameter("content"));
//			System.out.println(request.getParameter("writer"));
//			
//			BoardVO vo = new BoardVO();
//			vo.setTitle(request.getParameter("title"));
//			vo.setContent(request.getParameter("content"));
//			vo.setWriter(request.getParameter("writer"));//UK
//
//			int result = dao.insert(vo);
//			System.out.println("result:" + result);
//			System.out.println("================");
//			
//			if(result == 1) {
//				response.sendRedirect("b_selectAll.do");
//			}else {
//				response.sendRedirect("b_insert.do");
//			}
//			
//		}else if(sPath.equals("/b_selectAll.do")) {
//			
//			
//			int cpage = Integer.parseInt(request.getParameter("cpage") == null ? "1" : request.getParameter("cpage"));
//			int pageBlock = 5;
//			
////			List<BoardVO> vos = dao.selectAll();
//			List<BoardVO> vos = dao.selectAll(cpage, pageBlock);
//			for (BoardVO x : vos) {
//				System.out.println(x);
//			}
//			System.out.println("================");
//			
//			request.setAttribute("vos", vos);
//			
//			
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
//			request.getRequestDispatcher("board/selectAll.jsp").forward(request, response);
//		}else if(sPath.equals("/b_selectOne.do")) {
//			
//			System.out.println(request.getParameter("num"));
//			
//			String bnum = request.getParameter("num")==null?"0":request.getParameter("num");
//			
//			BoardVO vo = new BoardVO();
//			vo.setNum(Integer.parseInt(bnum));
//
//			BoardVO vo2 = dao.selectOne(vo);
//			System.out.println("vo2:" + vo2);
//			System.out.println("================");
//			
//			request.setAttribute("vo2", vo2);
//			
//			
//			CommentsDAO dao = new CommentsDAOimpl();
//			System.out.println("============");
//			
//			CommentsVO cvo = new CommentsVO();
//			cvo.setBnum(Integer.parseInt(bnum));
//			
//			List<CommentsVO> cvos = dao.selectAll(cvo);
//			for (CommentsVO x : cvos) {
//				System.out.println(x);
//			}
//			System.out.println("============");
//			
//			request.setAttribute("cvos", cvos);
//			
//			request.getRequestDispatcher("board/selectOne.jsp").forward(request, response);
//		}else if(sPath.equals("/b_update.do")) {
//			
//			System.out.println(request.getParameter("num"));
//			
//			String num = request.getParameter("num")==null?"0":request.getParameter("num");
//			
//			BoardVO vo = new BoardVO();
//			vo.setNum(Integer.parseInt(num));
//
//			BoardVO vo2 = dao.selectOne(vo);
//			System.out.println("vo2:" + vo2);
//			System.out.println("================");
//			
//			request.setAttribute("vo2", vo2);
//			
//			request.getRequestDispatcher("board/update.jsp").forward(request, response);
//		}else if(sPath.equals("/b_updateOK.do")) {
//			
//			
//			System.out.println(request.getParameter("num"));
//			System.out.println(request.getParameter("title"));
//			System.out.println(request.getParameter("content"));
//			System.out.println(request.getParameter("writer"));
//			
//			String num = request.getParameter("num")==null?"0":request.getParameter("num");
//			
//			BoardVO vo = new BoardVO();
//			vo.setNum(Integer.parseInt(num));
//			vo.setTitle(request.getParameter("title"));
//			vo.setContent(request.getParameter("content"));
//			vo.setWriter(request.getParameter("writer"));//UK
//			
//			int result = dao.update(vo);
//			System.out.println("result:" + result);
//			System.out.println("================");
//			
//			if(result == 1) {
//				response.sendRedirect("b_selectOne.do?num="+num);
//			}else {
//				response.sendRedirect("b_update.do?num="+num);
//			}
//			
//		}else if(sPath.equals("/b_delete.do")) {
//			
//			request.getRequestDispatcher("board/delete.jsp").forward(request, response);
//		}else if(sPath.equals("/b_deleteOK.do")) {
//			System.out.println(request.getParameter("num"));
//			
//			String num = request.getParameter("num")==null?"0":request.getParameter("num");
//			
//			BoardVO vo = new BoardVO();
//			vo.setNum(Integer.parseInt(num));
//			
//			int result = dao.delete(vo);
//			System.out.println("result:" + result);
//			System.out.println("================");
//			
//			if(result == 1) {
//				response.sendRedirect("b_selectAll.do");
//			}else {
//				response.sendRedirect("b_delete.do?num="+num);
//			}
//			
//		}else if(sPath.equals("/b_searchList.do")) {
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
////			List<BoardVO> vos = dao.selectAll(cpage, pageBlock);
//			List<BoardVO> vos = dao.searchList(searchKey, searchWord, cpage, pageBlock);
//			for (BoardVO x : vos) {
//				System.out.println(x);
//			}
//			System.out.println("================");
//			
//			request.setAttribute("vos", vos);
//			
//			
////			int total_rows = dao.getTotalRows();
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
//			request.getRequestDispatcher("board/searchList.jsp").forward(request, response);
//		}
//		
//	}//end doGet()...
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("doPost().....");
//		
//		request.setCharacterEncoding("UTF-8");// post요청시 한글처리
//		
//		doGet(request, response);
//	}//end doPost()...
//
//}
