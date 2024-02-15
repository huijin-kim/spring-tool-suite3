package test.com.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BoardDAOimpl implements BoardDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BoardDAOimpl() {
		System.out.println("BoardDAOimpl()....");

		try {
			Class.forName(DBinfo.DRIVER_NAME);
			System.out.println("driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(BoardVO vo) {
		System.out.println("insert()....");
		System.out.println(vo);
		int flag = 0;

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(BoardSQL.INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			System.out.println(pstmt);

			// 3.결과반환 정수 >> flag
			flag = pstmt.executeUpdate(); // DML: insert,update,delete
			System.out.println("flag:" + flag);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return flag;
	}

	@Override
	public int update(BoardVO vo) {
		System.out.println("update()....");
		System.out.println(vo);

		int flag = 0;

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(BoardSQL.UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getNum());
			System.out.println(pstmt);

			// 3.결과반환 정수 >> flag
			flag = pstmt.executeUpdate(); // DML: insert,update,delete
			System.out.println("flag:" + flag);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return flag;

	}

	@Override
	public int delete(BoardVO vo) {
		System.out.println("delete()....");
		System.out.println(vo);
		int flag = 0;

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(BoardSQL.DELETE);
			pstmt.setInt(1, vo.getNum());
			System.out.println(pstmt);

			// 3.결과반환 정수 >> flag
			flag = pstmt.executeUpdate(); // DML: insert,update,delete
			System.out.println("flag:" + flag);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return flag;
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		System.out.println("selectOne()....");
		System.out.println(vo);

		BoardVO vo2 = new BoardVO();

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(BoardSQL.SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("title"));
				vo2.setContent(rs.getString("content"));
				vo2.setWriter(rs.getString("writer"));
				vo2.setWdate(rs.getString("wdate"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vo2;
	}

	@Override
	public List<BoardVO> selectAll() {
		System.out.println("selectAll()...");
		List<BoardVO> vos = new ArrayList<BoardVO>();

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(BoardSQL.SELECT_ALL);
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				BoardVO vo2 = new BoardVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("title"));
				vo2.setContent(rs.getString("content"));
				vo2.setWriter(rs.getString("writer"));
				vo2.setWdate(rs.getString("wdate"));
				vos.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vos;
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord) {
		System.out.println("searchList()...");
		System.out.println(searchKey);
		System.out.println(searchWord);

		String sql = "";
		if (searchKey.equals("title")) {
			sql = BoardSQL.SEARCHLIST_TITLE;
		} else if (searchKey.equals("content")) {
			sql = BoardSQL.SEARCHLIST_CONTENT;
		}

		List<BoardVO> vos = new ArrayList<BoardVO>();
		String search_list = sql;
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(search_list);
			pstmt.setString(1, "%" + searchWord + "%");
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				BoardVO vo2 = new BoardVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("title"));
				vo2.setContent(rs.getString("content"));
				vo2.setWriter(rs.getString("writer"));
				vo2.setWdate(rs.getString("wdate"));
				vos.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vos;
	}

	@Override
	public int getTotalRows() {
		System.out.println("getTotalRows()....");

		int total_rows = 0;

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(BoardSQL.TOTAL_ROWS);
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				total_rows = rs.getInt("total_rows");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return total_rows;
	}

	@Override
	public List<BoardVO> selectAll(int cpage, int pageBlock) {
		System.out.println("selectAll()....");
		System.out.println("cpage:" + cpage);
		System.out.println("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		int endRow = startRow + pageBlock - 1;
		System.out.println(startRow + "," + endRow);

		List<BoardVO> vos = new ArrayList<BoardVO>();

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(BoardSQL.SELECT_ALL_PAGE_BLOCK);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				BoardVO vo2 = new BoardVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("title"));
				vo2.setContent(rs.getString("content"));
				vo2.setWriter(rs.getString("writer"));
				vo2.setWdate(rs.getString("wdate"));
				vos.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vos;
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		System.out.println("searchList()....");
		System.out.println(searchKey);
		System.out.println(searchWord);
		
		System.out.println("cpage:" + cpage);
		System.out.println("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		int endRow = startRow + pageBlock - 1;
		System.out.println(startRow + "," + endRow);
		
		String sql = "";
		if (searchKey.equals("title")) {
			sql = BoardSQL.SEARCHLIST_PAGE_BLOCK_TITLE;
		} else if (searchKey.equals("content")) {
			sql = BoardSQL.SEARCHLIST_PAGE_BLOCK_CONTENT;
		}

		
		List<BoardVO> vos = new ArrayList<BoardVO>();

		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				BoardVO vo2 = new BoardVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("title"));
				vo2.setContent(rs.getString("content"));
				vo2.setWriter(rs.getString("writer"));
				vo2.setWdate(rs.getString("wdate"));
				vos.add(vo2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return vos;
	}

	@Override
	public int getSearchTotalRows(String searchKey, String searchWord) {
		System.out.println("getSearchTotalRows()....");
		System.out.println(searchKey);
		System.out.println(searchWord);
		
		String sql = "";
		if (searchKey.equals("title")) {
			sql = BoardSQL.SEARCH_TOTAL_ROWS_TITLE;
		} else if (searchKey.equals("content")) {
			sql = BoardSQL.SEARCH_TOTAL_ROWS_CONTENT;
		}
		
		int total_rows = 0;
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			System.out.println("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchWord + "%");
			System.out.println(pstmt);

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				total_rows = rs.getInt("total_rows");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} // end finally

		return total_rows;
	}

}
