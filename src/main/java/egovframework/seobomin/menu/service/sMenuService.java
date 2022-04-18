package egovframework.seobomin.menu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


/**
 * 
  * @FileName : sMenuService.java
  * @Project : seoBoMin
  * @Date : 2021. 12. 9 
  * @작성자 : seobomin
  * @변경이력 : 
  * @프로그램 설명 :
  *
 */
public interface sMenuService {
	List<?> checkMemberList() throws Exception;

	int insOrder(String param, HttpServletRequest req) throws Exception;;

	List<?> checkTodayOrder() throws Exception;

	int completeDeposit(sMenuVO menuvo) throws Exception;

	int delOrder(sMenuVO menuvo) throws Exception;

	int insOrderNm(sMenuVO menuvo) throws Exception;


} 
