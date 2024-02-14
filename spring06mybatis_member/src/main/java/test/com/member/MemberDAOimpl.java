package test.com.member;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOimpl implements MemberDAO {

	private static final Logger logger = LoggerFactory.getLogger(MemberDAOimpl.class);
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	public MemberDAOimpl() {
		logger.info("MemberDAOimpl()....");
	}

	@Override
	public int insert(MemberVO vo) {
		logger.info("insert()....");
		logger.info(vo.toString());

		int flag = sqlSession.insert("INSERT", vo);
		logger.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int update(MemberVO vo) {
		logger.info("update()....");
		logger.info(vo.toString());

		int flag = 0;
		
		
		
		return flag;
	}

	@Override
	public int delete(MemberVO vo) {
		logger.info("delete()....");
		logger.info(vo.toString());

		int flag = 0;

		
		

		return flag;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		logger.info("selectOne()....");
		logger.info(vo.toString());

		MemberVO vo2 = new MemberVO();
		
		
		
		return vo2;
	}

	@Override
	public List<MemberVO> selectAll() {
		logger.info("selectAll()....");
		List<MemberVO> vos = new ArrayList<MemberVO>();

		
		

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


		

		return vos;
	}

	@Override
	public int getTotalRows() {
		logger.info("getTotalRows()....");

		int total_rows = 0;
		
		

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


		

		return vos;
	}

	@Override
	public MemberVO login(MemberVO vo) {
		logger.info("login()....");
		logger.info(vo.toString());

		MemberVO vo2 = null;
		
		
		
		return vo2;
	}

}