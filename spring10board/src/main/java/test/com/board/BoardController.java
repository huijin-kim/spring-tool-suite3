package test.com.board;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;

//	// HttpSession 은 내부 빈으로 등록되어있다. DI만 해서 사용가능
//	@Autowired
//	private HttpSession session;

//	@Autowired
//	private ServletContext sContext;
	
	public BoardController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "b_insert.do", method = RequestMethod.GET)
	public String b_insert() {
		log.info("b_insert.do......");
		
		return "board/insert";
	}
	

	@RequestMapping(value = "b_selectAll.do", method = RequestMethod.GET)
	public String b_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		log.info("Welcome b_selectAll.do....");

		log.info("cpage : {}, pageBlock : {}", cpage, pageBlock);

//		List<BoardVO> vos = service.selectAll();
		List<BoardVO> vos = service.selectAll(cpage, pageBlock);
		for (BoardVO x : vos) {
			log.info(x.toString());
		}
		log.info("================");

		model.addAttribute("vos", vos);

		// member테이블에 들어있는 모든회원수는 몇명?
		int total_rows = service.getTotalRows();
		log.info("total_rows:" + total_rows);

		int totalPageCount = 1;
		if (total_rows / pageBlock == 0) {
			totalPageCount = 1;
		} else if (total_rows % pageBlock == 0) {
			totalPageCount = total_rows / pageBlock;
		} else {
			totalPageCount = total_rows / pageBlock + 1;
		}
		// 페이지 링크 몇개?
		model.addAttribute("totalPageCount", totalPageCount);

		return "board/selectAll";
	}

	@RequestMapping(value = "b_searchList.do", method = RequestMethod.GET)
	public String b_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		log.info("Welcome b_searchList.do....");

		log.info("cpage : {}, pageBlock : {}", cpage, pageBlock);
		log.info("searchKey : {}, searchWord : {}", searchKey, searchWord);

//		List<BoardVO> vos = service.searchList(searchKey, searchWord);
		List<BoardVO> vos = service.searchList(searchKey, searchWord, cpage, pageBlock);
		for (BoardVO x : vos) {
			log.info(x.toString());
		}
		System.out.println("================");

		model.addAttribute("vos", vos);

		// 키워드검색 모든회원수는 몇명?
		int total_rows = service.getSearchTotalRows(searchKey, searchWord);
		log.info("total_rows:" + total_rows);

		int totalPageCount = 1;
		if (total_rows / pageBlock == 0) {
			totalPageCount = 1;
		} else if (total_rows % pageBlock == 0) {
			totalPageCount = total_rows / pageBlock;
		} else {
			totalPageCount = total_rows / pageBlock + 1;
		}
		// 페이지 링크 몇개?
		model.addAttribute("totalPageCount", totalPageCount);

		return "board/selectAll";
	}

//	@RequestMapping(value = "login.do", method = RequestMethod.GET)
//	public String login() {
//		log.info("Welcome login.do....");
//
//		return "board/login";
//	}

	@RequestMapping(value = "b_insertOK.do", method = RequestMethod.POST)
	public String b_insertOK(BoardVO vo) throws IllegalStateException, IOException {
		log.info("Welcome b_insertOK.do....");

		log.info(vo.toString());


		int result = service.insert(vo);
		log.info("result:" + result);
		System.out.println("================");

		if (result == 1) {
			return "redirect:b_selectAll.do";
		} else {
			return "redirect:b_insert.do";
		}
	}

	@RequestMapping(value = "b_updateOK.do", method = RequestMethod.POST)
	public String b_updateOK(BoardVO vo) throws IllegalStateException, IOException {
		log.info("Welcome b_updateOK.do....");

		log.info("" + vo);


		int result = service.update(vo);
		log.info("result:" + result);
		System.out.println("================");

		if (result == 1) {
			return "redirect:b_selectOne.do?num=" + vo.getNum();
		} else {
			return "redirect:b_update.do?num=" + vo.getNum();
		}
	}

	@RequestMapping(value = "b_deleteOK.do", method = RequestMethod.POST)
//	public String b_deleteOK(@RequestParam(defaultValue = "0")int num) {
	public String b_deleteOK(BoardVO vo) {
		log.info("Welcome b_deleteOK.do....");

		log.info("" + vo);

		int result = service.delete(vo);
		log.info("result:" + result);
		System.out.println("================");

		if (result == 1) {
			return "redirect:b_selectAll.do";
		} else {
			return "redirect:b_delete.do?num=" + vo.getNum();
		}
	}

	@RequestMapping(value = "b_selectOne.do", method = RequestMethod.GET)
//	public String b_selectOne(@RequestParam(defaultValue = "0") int num,Model model) {
	public String b_selectOne(BoardVO vo, Model model) {
		log.info("Welcome b_selectOne.do....");

		log.info("vo : {}", vo);

		BoardVO vo2 = service.selectOne(vo);
		log.info("vo2:" + vo2);
		log.info("================");

		model.addAttribute("vo2", vo2);

		return "board/selectOne";
	}


	@RequestMapping(value = "b_update.do", method = RequestMethod.GET)
	public String b_update(BoardVO vo, Model model) {
		log.info("Welcome b_update.do....");

		log.info("vo : {}", vo);

		BoardVO vo2 = service.selectOne(vo);
		log.info("vo2:" + vo2);
		log.info("================");

		model.addAttribute("vo2", vo2);

		return "board/update";
	}

	@RequestMapping(value = "b_delete.do", method = RequestMethod.GET)
	public String b_delete() {
		log.info("Welcome b_delete.do....");

		return "board/delete";
	}


}
