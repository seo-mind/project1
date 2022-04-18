package egovframework.seobomin.menu.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.rte.fdl.property.EgovPropertyService;



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
@Controller
public class sBoardController {

	/** EgovSampleService */
	@Resource(name = "sampleService")
	private EgovSampleService sampleService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	@RequestMapping("/menu.do")
	public String viewMenu() {
		return "menuOrder/menu/sMenuList";
	}

	@RequestMapping("/todayOrder.do")
	public String todayOrder() {
		return "menuOrder/menu/checkTodayOrder";
	}
	
}
