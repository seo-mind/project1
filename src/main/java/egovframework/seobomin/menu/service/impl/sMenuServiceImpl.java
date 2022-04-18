package egovframework.seobomin.menu.service.impl;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.seobomin.menu.MatterMostBot;
import egovframework.seobomin.menu.service.sMenuService;
import egovframework.seobomin.menu.service.sMenuVO;

/**
 * 
  * @FileName : sMenuServiceImpl.java
  * @Project : seoBoMin
  * @Date : 2021. 12. 9 
  * @작성자 : seobomin
  * @변경이력 : 
  * @프로그램 설명 :
  *
 */
@Service("menuService")
public class sMenuServiceImpl extends EgovAbstractServiceImpl implements sMenuService {

	private static final Logger LOGGER = LoggerFactory.getLogger(sMenuServiceImpl.class);

	
	// TODO mybatis 사용
	@Resource(name="sMenuMapper")
	private sMenuMapper menuDAO;


	@Override
	public List<?> checkMemberList() throws Exception {
		return menuDAO.checkMemberList();
	}
	
	@Override
	public int insOrder(String param,  HttpServletRequest req)  throws Exception{
		param = param.replaceAll("&quot;", "\"");
		sMenuVO menuvo = new Gson().fromJson(param, sMenuVO.class);
		menuvo.setRegistIp( req.getRemoteAddr());
		
		int result = menuDAO.insOrder(menuvo);
		
		
		if(result > 0) {
			MatterMostBot bot = new MatterMostBot();
			DecimalFormat format = new DecimalFormat("###,###");
			
	        String message = null;
	        
			
			for(int i =0 ; i < menuvo.getMenuList().size() ; i++  ) {
				
				sMenuVO vo = menuvo.getMenuList().get(i);
				message = "주문하신 메뉴는 " + vo.getMenuNm() + " 가격은  " + format.format( vo.getPrice()) + " 원 입니다. 배달팁이 포함 될 수 있습니다  주문확인 메뉴에서 확인 (。_。)   ";
				bot.sendMessage(vo.getMattermostId() ,message);
			}
		}
		return result;
	}
	
	@Override
	public List<?> checkTodayOrder() throws Exception {
		return menuDAO.checkTodayOrder();
	}
	
	
	@Override
	public int completeDeposit(sMenuVO menuvo) throws Exception {
		return menuDAO.completeDeposit(menuvo);
	}
	
	
	@Override
	public int delOrder(sMenuVO menuvo) throws Exception {
		
		return menuDAO.delOrder(menuvo);
	}
	
	
	@Override
	public int insOrderNm(sMenuVO menuvo) throws Exception {
		return 0;
	}
}
