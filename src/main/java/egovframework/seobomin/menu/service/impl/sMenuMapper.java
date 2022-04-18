
package egovframework.seobomin.menu.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.seobomin.menu.service.sMenuVO;

@Mapper("sMenuMapper")
public interface sMenuMapper {

	
	List<?> checkMemberList() throws Exception;

	int insOrder(sMenuVO menuvo) throws Exception;

	List<?> checkTodayOrder() throws Exception;

	int completeDeposit(sMenuVO menuvo) throws Exception;

	List<sMenuVO> remindDeposit() throws Exception;

	int delOrder(sMenuVO menuvo) throws Exception;

}
