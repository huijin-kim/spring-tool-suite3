package test.com.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAOimpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	public BoardDAOimpl() {
		System.out.println("BoardDAOimpl()....");

	}

	@Override
	public int insert(BoardVO vo) {
		log.info("insert()....");
		log.info(vo.toString());

		int flag = sqlSession.insert("INSERT", vo);

		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int update(BoardVO vo) {
		log.info("update()....");
		log.info(vo.toString());

		int flag = sqlSession.update("UPDATE", vo);
		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public int delete(BoardVO vo) {
		log.info("delete()....");
		log.info(vo.toString());

		int flag = sqlSession.delete("DELETE", vo);
		log.info("flag : {}", flag);

		return flag;
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		log.info("selectOne()....");
		log.info(vo.toString());

		BoardVO vo2 = sqlSession.selectOne("SELECT_ONE", vo);

		return vo2;
	}

	@Override
	public List<BoardVO> selectAll() {
		log.info("selectAll()....");

		List<BoardVO> vos = sqlSession.selectList("SELECT_ALL");

		return vos;
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()....2");
		log.info(searchKey);
		log.info(searchWord);

		List<BoardVO> vos = null;

		if (searchKey.equals("title")) {
			vos = sqlSession.selectList("SEARCHLIST_TITLE", "%" + searchWord + "%");
		} else if (searchKey.equals("content")) {
			vos = sqlSession.selectList("SEARCHLIST_CONTENT", "%" + searchWord + "%");
		}

		return vos;
	}

	@Override
	public int getTotalRows() {

		int total_rows = sqlSession.selectOne("TOTAL_ROWS");

		return total_rows;
	}

	@Override
	public List<BoardVO> selectAll(int cpage, int pageBlock) {
		log.info("selectAll()....");
		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		int endRow = startRow + pageBlock - 1;
		log.info(startRow + "," + endRow);

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);

		List<BoardVO> vos = sqlSession.selectList("SELECT_ALL_PAGE_BLOCK", map);

		return vos;
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord, int cpage, int pageBlock) {
		log.info("searchList()....4");
		log.info(searchKey);
		log.info(searchWord);

		log.info("cpage:" + cpage);
		log.info("pageBlock:" + pageBlock);

		int startRow = (cpage - 1) * pageBlock + 1;
		int endRow = startRow + pageBlock - 1;
		log.info(startRow + "," + endRow);

		Map<String, String> map = new HashMap<String, String>();
		map.put("startRow", String.valueOf(startRow));
		map.put("endRow", String.valueOf(endRow));
		map.put("searchWord", "%" + searchWord + "%");

		List<BoardVO> vos = null;

		if (searchKey.equals("title")) {
			vos = sqlSession.selectList("SEARCHLIST_PAGE_BLOCK_TITLE", map);
		} else if (searchKey.equals("content")) {
			vos = sqlSession.selectList("SEARCHLIST_PAGE_BLOCK_CONTENT", map);
		}

		return vos;
	
	}

	@Override
	public int getSearchTotalRows(String searchKey, String searchWord) {
		log.info("getSearchTotalRows()....");
		log.info(searchKey);
		log.info(searchWord);

		int total_rows = 0;

		if (searchKey.equals("title")) {
			total_rows = sqlSession.selectOne("SEARCH_TOTAL_ROWS_TITLE", "%" + searchWord + "%");
		} else if (searchKey.equals("content")) {
			total_rows = sqlSession.selectOne("SEARCH_TOTAL_ROWS_CONTENT", "%" + searchWord + "%");
		}

		return total_rows;
	}

}
