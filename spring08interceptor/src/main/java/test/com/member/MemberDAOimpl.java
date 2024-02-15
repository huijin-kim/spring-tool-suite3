package test.com.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOimpl implements MemberDAO {

	
	@Autowired
	private SqlSession sqlSession;
	
	
	public MemberDAOimpl() {
		log.info("MemberDAOimpl()....");
	}

	@Override
	public int insert(MemberVO vo) {
		log.info("insert()....");
		log.info(vo.toString());

		int flag = sqlSession.insert("INSERT",vo);
		
		log.info("flag : {}",flag);
		
		return flag;
	}

	@Override
	public int update(MemberVO vo) {
		log.info("update()....");
		log.info(vo.toString());

		int flag = sqlSession.update("UPDATE",vo);
		log.info("flag : {}",flag);
		
		return flag;
	}

	@Override
	public int delete(MemberVO vo) {
		log.info("delete()....");
		log.info(vo.toString());

		int flag = sqlSession.delete("DELETE",vo);
		log.info("flag : {}",flag);

		return flag;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		log.info("selectOne()....");
		log.info(vo.toString());

		MemberVO vo2 = sqlSession.selectOne("SELECT_ONE",vo);
		
		return vo2;
	}

	@Override
	public List<MemberVO> selectAll() {
		log.info("selectAll()....");
		
		List<MemberVO> vos = sqlSession.selectList("SELECT_ALL");

		return vos;
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()....2");
		log.info(searchKey);
		log.info(searchWord);
		
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
		log.info("getTotalRows()....");

		int total_rows = 0;
		
		

		return total_rows;
	}

	@Override
	public List<MemberVO> selectAll(int cpage, int pageBlock) {
		log.info("selectAll()....");
		log.info("cpage:"+cpage);
		log.info("pageBlock:"+pageBlock);
		
		int startRow = (cpage-1)*pageBlock + 1;
		int endRow = startRow + pageBlock -1;
		log.info(startRow+","+ endRow);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		
		List<MemberVO> vos = sqlSession.selectList("SELECT_ALL_PAGE_BLOCK",map);
		
		

		return vos;
	}

	@Override
	public int getSearchTotalRows(String searchKey, String searchWord) {
		log.info("getSearchTotalRows()....");
		log.info(searchKey);
		log.info(searchWord);
		
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
		log.info("searchList()....4");
		log.info(searchKey);
		log.info(searchWord);
		
		log.info("cpage:"+cpage);
		log.info("pageBlock:"+pageBlock);
		
		int startRow = (cpage-1)*pageBlock + 1;
		int endRow = startRow + pageBlock -1;
		log.info(startRow+","+ endRow);
		
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
		log.info("login()....");
		log.info(vo.toString());

		MemberVO vo2 = null;
		
		
		
		return vo2;
	}

}
