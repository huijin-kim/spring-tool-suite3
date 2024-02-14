package test.com.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import test.com.member.db.DBinfo;

@Repository
public class MemberDAOimpl implements MemberDAO {

	private static final Logger logger = LoggerFactory.getLogger(MemberDAOimpl.class);
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public MemberDAOimpl() {
		logger.info("MemberDAOimpl()....");

		try {
			Class.forName(DBinfo.DRIVER_NAME);
			logger.info("driver successed...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int insert(MemberVO vo) {
		logger.info("insert()....");
		logger.info(vo.toString());

		int flag = 0;
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			logger.info("conn successed...");

			// 2.SQL(질의문) 세팅
			// select * from member
			pstmt = conn.prepareStatement(MemberSQL.INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			logger.info(pstmt.toString());

			// 3.결과반환 정수 >> flag
			flag = pstmt.executeUpdate(); //DML: insert,update,delete
			logger.info("flag:"+flag);
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
	public int update(MemberVO vo) {
		logger.info("update()....");
		logger.info(vo.toString());

		int flag = 0;
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			logger.info("conn successed...");
//			conn.setAutoCommit(false);
			// 2.SQL(질의문) 세팅
			// select * from member
			pstmt = conn.prepareStatement(MemberSQL.UPDATE);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getTel());
			pstmt.setInt(4, vo.getNum());
			logger.info(pstmt.toString());

			// 3.결과반환 정수 >> flag
			flag = pstmt.executeUpdate(); //DML: insert,update,delete
			logger.info("flag:"+flag);
//			logger.info(10/0);
//			conn.commit();
		} catch (SQLException e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
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
	public int delete(MemberVO vo) {
		logger.info("delete()....");
		logger.info(vo.toString());

		int flag = 0;

		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			logger.info("conn successed...");

			// 2.SQL(질의문) 세팅
			// select * from member
			pstmt = conn.prepareStatement(MemberSQL.DELETE);
			pstmt.setInt(1, vo.getNum());
			logger.info(pstmt.toString());

			// 3.결과반환 정수 >> flag
			flag = pstmt.executeUpdate(); //DML: insert,update,delete
			logger.info("flag:"+flag);
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
	public MemberVO selectOne(MemberVO vo) {
		logger.info("selectOne()....");
		logger.info(vo.toString());

		// select * from member where num=6

		MemberVO vo2 = new MemberVO();
		
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			logger.info("conn successed...");

			// 2.SQL(질의문) 세팅
			// select * from member
			pstmt = conn.prepareStatement(MemberSQL.SELECT_ONE);
			pstmt.setInt(1, vo.getNum());
			logger.info(pstmt.toString());

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			logger.info(rs.toString());
			while (rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
				vo2.setPw(rs.getString("pw"));
				vo2.setName(rs.getString("name"));
				vo2.setTel(rs.getString("tel"));
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
	public List<MemberVO> selectAll() {
		logger.info("selectAll()....");
		List<MemberVO> vos = new ArrayList<MemberVO>();

		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			logger.info("conn successed...");

			// 2.SQL(질의문) 세팅
			// select * from member
			pstmt = conn.prepareStatement(MemberSQL.SELECT_ALL);
			logger.info(pstmt.toString());

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			logger.info(rs.toString());
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vos.add(vo);
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
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		logger.info("searchList()....");
		logger.info(searchKey);
		logger.info(searchWord);
		
		String sql = "";
		if (searchKey.equals("id")) {
			sql = MemberSQL.SEARCHLIST_ID;
		} else if (searchKey.equals("name")) {
			sql = MemberSQL.SEARCHLIST_NAME;
		}

		List<MemberVO> vos = new ArrayList<MemberVO>();


		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			logger.info("conn successed...");

			// 2.SQL(질의문) 세팅
			// select * from member
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchWord + "%");
			logger.info(pstmt.toString());

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			logger.info(rs.toString());
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vos.add(vo);
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
		logger.info("getTotalRows()....");

		int total_rows = 0;
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			logger.info("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(MemberSQL.TOTAL_ROWS);
			logger.info(pstmt.toString());

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			logger.info(rs.toString());
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
	public List<MemberVO> selectAll(int cpage, int pageBlock) {
		logger.info("selectAll()....");
		logger.info("cpage:"+cpage);
		logger.info("pageBlock:"+pageBlock);
		
		int startRow = (cpage-1)*pageBlock + 1;
		int endRow = startRow + pageBlock -1;
		logger.info(startRow+","+ endRow);
		
		List<MemberVO> vos = new ArrayList<MemberVO>();
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			logger.info("conn successed...");

			// 2.SQL(질의문) 세팅
			// select * from member
			pstmt = conn.prepareStatement(MemberSQL.SELECT_ALL_PAGE_BLOCK);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			logger.info(pstmt.toString());

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			logger.info(rs.toString());
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vos.add(vo);
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
		logger.info("getSearchTotalRows()....");
		logger.info(searchKey);
		logger.info(searchWord);
		
		String sql = "";
		if (searchKey.equals("id")) {
			sql = MemberSQL.SEARCH_TOTAL_ROWS_ID;
		} else if (searchKey.equals("name")) {
			sql = MemberSQL.SEARCH_TOTAL_ROWS_NAME;
		}
		
		int total_rows = 0;
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			logger.info("conn successed...");

			// 2.SQL(질의문) 세팅
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchWord + "%");
			logger.info(pstmt.toString());

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			logger.info(rs.toString());
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
	public List<MemberVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		logger.info("searchList()....");
		logger.info(searchKey);
		logger.info(searchWord);
		
		logger.info("cpage:"+cpage);
		logger.info("pageBlock:"+pageBlock);
		
		int startRow = (cpage-1)*pageBlock + 1;
		int endRow = startRow + pageBlock -1;
		logger.info(startRow+","+ endRow);
		
		String sql = "";
		if (searchKey.equals("id")) {
			sql = MemberSQL.SEARCHLIST_PAGE_BLOCK_ID;
		} else if (searchKey.equals("name")) {
			sql = MemberSQL.SEARCHLIST_PAGE_BLOCK_NAME;
		}

		List<MemberVO> vos = new ArrayList<MemberVO>();


		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			logger.info("conn successed...");

			// 2.SQL(질의문) 세팅
			// select * from member
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchWord + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			logger.info(pstmt.toString());

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			logger.info(rs.toString());
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPw(rs.getString("pw"));
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vos.add(vo);
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
	public MemberVO login(MemberVO vo) {
		logger.info("login()....");
		logger.info(vo.toString());

		// select * from member where id='admin' and pw='hi1234'

		MemberVO vo2 = null;
		
		
		try {
			// 1.커넥션(계정접속)
			conn = DriverManager.getConnection(DBinfo.URL, DBinfo.USER_NAME, DBinfo.PASSWORD);
			logger.info("conn successed...");

			// 2.SQL(질의문) 세팅
			// select * from member
			pstmt = conn.prepareStatement(MemberSQL.LOGIN);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			logger.info(pstmt.toString());

			// 3.결과반환 rs >> vos
			rs = pstmt.executeQuery();
			logger.info(rs.toString());
			while (rs.next()) {
				vo2 = new MemberVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
//				vo2.setPw(rs.getString("pw"));
				vo2.setName(rs.getString("name"));
				vo2.setTel(rs.getString("tel"));
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

}
