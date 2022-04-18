package egovframework.seobomin.menu;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import egovframework.seobomin.menu.service.sMenuVO;
import egovframework.seobomin.menu.service.impl.sMenuMapper;

@Component
public class FusionScheduler{

	// TODO mybatis 사용
	@Resource(name="sMenuMapper")
	private sMenuMapper menuDAO;


	@Scheduled(cron="0 0 13 * * * ")
	public void remindDeposit() {
		System.out.println("=======================================스케쥴 시작 ==================================");
		
		List<sMenuVO> list;
		try {
			list = menuDAO.remindDeposit();
		
			if(list.size() > 0) { MatterMostBot bot = new MatterMostBot();
				String message = null;
				
				for(int i =0 ; i < list.size() ; i++ ) {
				
					sMenuVO vo = (sMenuVO) list.get(i); 
					message = "잊으신거 없으신가요?";
					bot.sendMessage(vo.getMattermostId() ,message); 
				} 
			}
			System.out.println("=======================================스케쥴 종료 ==================================");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}