package egovframework.seobomin.menu.service;

import java.io.Serializable;
import java.util.List;


/**
 * 
  * @FileName : MenuVO.java
  * @Project : seoBoMin
  * @Date : 2021. 12. 9 
  * @작성자 : seobomin
  * @변경이력 : 
  * @프로그램 설명 :
  *
 */
public class sMenuVO implements Serializable {

	
	private static final long serialVersionUID = -5044295019855540022L;

	/** 아이디 */
	private String mattermostId;

	/** 이름 */
	private String name;
	
	/** 메뉴명 */
	private String menuNm;
	
	/** 가격 */
	private int price;
	
	private String registIp;
	
	private String checkMoney;
	
	private String pw;
	
	private int idx;
	
	private List<sMenuVO> menuList;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMattermostId() {
		return mattermostId;
	}

	public void setMattermostId(String mattermostId) {
		this.mattermostId = mattermostId;
	}

	public String getMenuNm() {
		return menuNm;
	}

	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<sMenuVO> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<sMenuVO> menuList) {
		this.menuList = menuList;
	}

	public String getRegistIp() {
		return registIp;
	}

	public void setRegistIp(String registIp) {
		this.registIp = registIp;
	}

	public String getCheckMoney() {
		return checkMoney;
	}

	public void setCheckMoney(String checkMoney) {
		this.checkMoney = checkMoney;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}


}
