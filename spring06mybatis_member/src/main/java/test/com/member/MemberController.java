package test.com.member;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	public MemberController() {
		logger.info("MemberController()....");
	}

	/**
	 * Simply selects the member view to render by returning its name.
	 */
	@RequestMapping(value = "m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		logger.info("Welcome m_insert.do....");

		return "member/insert";
	}

	@RequestMapping(value = "m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		logger.info("Welcome m_selectAll.do....");

		logger.info("cpage : {}, pageBlock : {}", cpage, pageBlock);

//		List<MemberVO> vos = service.selectAll();
		List<MemberVO> vos = service.selectAll(cpage, pageBlock);
		for (MemberVO x : vos) {
			logger.info(x.toString());
		}
		logger.info("================");

		model.addAttribute("vos", vos);

		// member테이블에 들어있는 모든회원수는 몇명?
		int total_rows = service.getTotalRows();
		logger.info("total_rows:" + total_rows);

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

		return "member/selectAll";
	}

	@RequestMapping(value = "m_searchList.do", method = RequestMethod.GET)
	public String m_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		logger.info("Welcome m_searchList.do....");

		logger.info("cpage : {}, pageBlock : {}", cpage, pageBlock);
		logger.info("searchKey : {}, searchWord : {}", searchKey, searchWord);

		List<MemberVO> vos = service.searchList(searchKey, searchWord);
//		List<MemberVO> vos = service.searchList(searchKey, searchWord, cpage, pageBlock);
		for (MemberVO x : vos) {
			logger.info(x.toString());
		}
		System.out.println("================");

		model.addAttribute("vos", vos);

		// 키워드검색 모든회원수는 몇명?
		int total_rows = service.getSearchTotalRows(searchKey, searchWord);
		logger.info("total_rows:" + total_rows);

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

		return "member/selectAll";
	}

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("Welcome login.do....");

		return "member/login";
	}

	@RequestMapping(value = "m_insertOK.do", method = RequestMethod.POST)
//	public String m_insertOK(String id, String pw, String name, String tel) {
	public String m_insertOK(MemberVO vo) {
		logger.info("Welcome m_insertOK.do....");

		logger.info(vo.toString());

		int result = service.insert(vo);
		logger.info("result:" + result);
		System.out.println("================");

		if (result == 1) {
			return "redirect:m_selectAll.do";
		} else {
			return "redirect:m_insert.do";
		}
	}
	
	@RequestMapping(value = "m_updateOK.do", method = RequestMethod.POST)
//	public String m_updateOK(@RequestParam(defaultValue = "0")int num, String id, String pw, String name, String tel) {
	public String m_updateOK(MemberVO vo) {
		logger.info("Welcome m_updateOK.do....");
		
		logger.info(""+vo);
				
		int result = service.update(vo);
		logger.info("result:" + result);
		System.out.println("================");
		
		if (result == 1) {
			return "redirect:m_selectOne.do?num="+vo.getNum();
		} else {
			return "redirect:m_update.do?num="+vo.getNum();
		}
	}
	
	@RequestMapping(value = "m_deleteOK.do", method = RequestMethod.POST)
//	public String m_deleteOK(@RequestParam(defaultValue = "0")int num) {
	public String m_deleteOK(MemberVO vo) {
		logger.info("Welcome m_deleteOK.do....");
		
		logger.info(""+vo);
		
		int result = service.delete(vo);
		logger.info("result:" + result);
		System.out.println("================");
		
		if (result == 1) {
			return "redirect:m_selectAll.do";
		} else {
			return "redirect:m_delete.do?num="+vo.getNum();
		}
	}

	@RequestMapping(value = "m_selectOne.do", method = RequestMethod.GET)
//	public String m_selectOne(@RequestParam(defaultValue = "0") int num,Model model) {
	public String m_selectOne(MemberVO vo,Model model) {
		logger.info("Welcome m_selectOne.do....");

		logger.info("vo : {}",vo);
		
		MemberVO vo2 = service.selectOne(vo);
		logger.info("vo2:" + vo2);
		logger.info("================");
		
		model.addAttribute("vo2", vo2);

		return "member/selectOne";
	}
	
	@RequestMapping(value = "loginOK.do", method = RequestMethod.POST)
//	public String loginOK(String id,String pw) {
	public String loginOK(MemberVO vo) {
		logger.info("Welcome loginOK.do....");
		
		logger.info("vo : {}",vo);
		
		MemberVO vo2 = service.login(vo);
		logger.info("vo2:" + vo2);
		logger.info("================");
		
		if(vo2 == null) {
			return "redirect:login.do";
		}else {
			return "redirect:index.do";
		}
	}
	
	
	@RequestMapping(value = "m_update.do", method = RequestMethod.GET)
	public String m_update(MemberVO vo,	Model model) {
		logger.info("Welcome m_update.do....");
		
		logger.info("vo : {}",vo);
		
		MemberVO vo2 = service.selectOne(vo);
		logger.info("vo2:" + vo2);
		logger.info("================");
		
		model.addAttribute("vo2", vo2);
		
		return "member/update";
	}
	
	@RequestMapping(value = "m_delete.do", method = RequestMethod.GET)
	public String m_delete() {
		logger.info("Welcome m_delete.do....");
		
		return "member/delete";
	}

}// end class
