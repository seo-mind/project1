package egovframework.seobomin.menu.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.google.gson.Gson;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.seobomin.menu.service.sMenuService;
import egovframework.seobomin.menu.service.sMenuVO;

/**
 * 
  * @FileName : sBoardController.java
  * @Project : seoBoMin
  * @Date : 2021. 12. 8 
  * @작성자 : seobomin
  * @변경이력 : 
  * @프로그램 설명 :
  *
 */
@RestController
public class sBoardRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(sBoardRestController.class);
	
	/** EgovSampleService */
	@Resource(name = "menuService")
	private sMenuService menuService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	@RequestMapping("/menuOrder.do")
	public String viewMenu() {
		
		return "menuOrder/order/sOrderList";
	}

	@PostMapping(value= "/checkName.do", produces="text/plain;charset=UTF-8")
	public String checkName() throws Exception {
		List<?> list = menuService.checkMemberList();
		String json = new Gson().toJson(list); 	// list to json
		return json;
	}
	
	@PostMapping(value= "/sendOrder.do", produces="text/plain;charset=UTF-8")
	public String sendOrder(String param, HttpServletRequest  req) throws Exception {
		
		int result = menuService.insOrder(param, req);
		if ( result > 0) {
			return "주문 완료";
		}
		
		return "주문 실패";
	}
	
	@PostMapping(value= "/checkTodayOrder.do", produces="text/plain;charset=UTF-8")
	public String checkTodayOrder() throws Exception {
		
		List<?> list = menuService.checkTodayOrder();
		
		String json = new Gson().toJson(list); 	// list to json
		return json;
	}
	
	@PostMapping(value= "/completeDeposit.do", produces="text/plain;charset=UTF-8")
	public String completeDeposit(sMenuVO menuvo) throws Exception {
		
		int result = menuService.completeDeposit(menuvo);
		
		if ( result > 0) {
			return "완료";
		}
		
		return "실패";
	}
	

	@PostMapping(value= "/delOrder.do", produces="text/plain;charset=UTF-8")
	public String delOrder(sMenuVO menuvo) throws Exception {
		
		int result = menuService.delOrder(menuvo);
		
		if ( result > 0) {
			return "완료";
		}
		
		return "실패";
	}
	

	@PostMapping(value= "/insOrderNm.do", produces="text/plain;charset=UTF-8")
	public String insOrderNm(sMenuVO menuvo) throws Exception {
		
		int result = menuService.insOrderNm(menuvo);
		
		if ( result > 0) {
			return "완료";
		}
		
		return "실패";
	}
	
}
