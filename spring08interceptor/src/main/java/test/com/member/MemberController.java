package test.com.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	public MemberController() {
		log.info("MemberController()....");
	}

	/**
	 * Simply selects the member view to render by returning its name.
	 */
	@RequestMapping(value = "m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		log.info("Welcome m_insert.do....");

		return "member/insert";
	}

	@RequestMapping(value = "m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model) {
		log.info("Welcome m_selectAll.do....");

		log.info("cpage : {}, pageBlock : {}", cpage, pageBlock);

//		List<MemberVO> vos = service.selectAll();
		List<MemberVO> vos = service.selectAll(cpage, pageBlock);
		for (MemberVO x : vos) {
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

		return "member/selectAll";
	}

	@RequestMapping(value = "m_searchList.do", method = RequestMethod.GET)
	public String m_searchList(@RequestParam(defaultValue = "1") int cpage,
			@RequestParam(defaultValue = "5") int pageBlock, Model model, String searchKey, String searchWord) {
		log.info("Welcome m_searchList.do....");

		log.info("cpage : {}, pageBlock : {}", cpage, pageBlock);
		log.info("searchKey : {}, searchWord : {}", searchKey, searchWord);

		List<MemberVO> vos = service.searchList(searchKey, searchWord);
//		List<MemberVO> vos = service.searchList(searchKey, searchWord, cpage, pageBlock);
		for (MemberVO x : vos) {
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

		return "member/selectAll";
	}

	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		log.info("Welcome login.do....");

		return "member/login";
	}

	@RequestMapping(value = "m_insertOK.do", method = RequestMethod.POST)
//	public String m_insertOK(String id, String pw, String name, String tel) {
	public String m_insertOK(MemberVO vo) {
		log.info("Welcome m_insertOK.do....");

		log.info(vo.toString());

		int result = service.insert(vo);
		log.info("result:" + result);
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
		log.info("Welcome m_updateOK.do....");
		
		log.info(""+vo);
				
		int result = service.update(vo);
		log.info("result:" + result);
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
		log.info("Welcome m_deleteOK.do....");
		
		log.info(""+vo);
		
		int result = service.delete(vo);
		log.info("result:" + result);
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
		log.info("Welcome m_selectOne.do....");

		log.info("vo : {}",vo);
		
		MemberVO vo2 = service.selectOne(vo);
		log.info("vo2:" + vo2);
		log.info("================");
		
		model.addAttribute("vo2", vo2);

		return "member/selectOne";
	}
	
	@RequestMapping(value = "loginOK.do", method = RequestMethod.POST)
//	public String loginOK(String id,String pw) {
	public String loginOK(MemberVO vo) {
		log.info("Welcome loginOK.do....");
		
		log.info("vo : {}",vo);
		
		MemberVO vo2 = service.login(vo);
		log.info("vo2:" + vo2);
		log.info("================");
		
		if(vo2 == null) {
			return "redirect:login.do";
		}else {
			return "redirect:index.do";
		}
	}
	
	
	@RequestMapping(value = "m_update.do", method = RequestMethod.GET)
	public String m_update(MemberVO vo,	Model model) {
		log.info("Welcome m_update.do....");
		
		log.info("vo : {}",vo);
		
		MemberVO vo2 = service.selectOne(vo);
		log.info("vo2:" + vo2);
		log.info("================");
		
		model.addAttribute("vo2", vo2);
		
		return "member/update";
	}
	
	@RequestMapping(value = "m_delete.do", method = RequestMethod.GET)
	public String m_delete() {
		log.info("Welcome m_delete.do....");
		
		return "member/delete";
	}

}// end class
