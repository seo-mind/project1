<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>퓨전人밥</title>
    <!-- CSS only -->
	<link href="//cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.css" rel="stylesheet" crossorigin="anonymous">
    <link href="/css/menu/styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.0/themes/base/jquery-ui.css">
    
    
</head>
<body style="text-align:center; margin:0 auto; display:inline; padding-top:100px;">
	<!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="#!">퓨전人밥</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                    <li class="nav-item"><a class="nav-link" aria-current="page" href="/menu.do">주문메뉴</a></li>
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="/todayOrder.do">주문확인</a></li>
                </ul>
                </form>
            </div>
        </div>
    </nav>
	<!-- Header-->
    <header class="bg-dark py-5">
        <div class="container px-4 px-lg-5 my-5">
            <div class="text-center text-white">
            	<!-- <img src="/images/menu/closed.png" style="width:200px;position: absolute;left: 55%;cursor: pointer;" id="btn_img" /> -->
                <h1 class="display-4 fw-bolder" id="menu_nm">Bob in Fusion</h1>
                <p class="lead fw-normal text-white-50 mb-0">With Hansot</p>
                
            </div>
        </div>
    </header>
    <!-- Section-->
    <section class="py-5">
    <h1 class="display-6">이민지 - 신한은행 110-278-870418</h1>
    <!-- <h1 class="display-6">유준혁 - 토스 1000-0854-5889</h2> -->
    <!-- <h1 class="display-6">박경현 - 우리은행 1002-961-770239</h2> -->
    <!-- <h1 class="display-6">이민지 - 신한은행 110-278-870418</h1> -->
  	<!-- <h1 class="display-6">서보민 - 토스뱅크 1000-1669-0691 </h1> -->
    <!--  -->
    <h1 class="display-6">오늘  주문팁 100원 + 배달팁은 총 <span id="delivery_tip" style="color:#1b00ff;">0</span>원 입니다</h1>
    <!--  <h1 class="display-6"><input type="text" style="width:950px;text-align:center;font-size:30px;" placeholder="오늘 주문자는 이곳에 작성 후 enter를 입력해주세요"/></h1> -->
    <!-- <p class="lead">
	   배달팁은 카카오톡으로 안내드리겠습니다.
	</p> -->
	<p class="lead">
	   수작업으로 주문을 넣다 보니 개별적인 토핑추가는 양해 부탁드립니다.
	</p>
        <div class="container px-4 px-lg-5 mt-5">
        
        
			<table class="table">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">메뉴명</th>
						<th scope="col">주문한 사람</th>
						<th scope="col">가격</th>
						<th scope="col">입금 여부</th>
					</tr>
				</thead>
				<tbody id="inhtml">
				</tbody>
			</table>
			<p class="lead">
			   한솥도시락-"율하점"
			</p>
		</div> <!-- end container -->
    </section>
   
	<!-- Footer-->
	<footer class="py-5 bg-dark">
	    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Bob in Fusion 2021</p></div>
	</footer>
	<!-- Bootstrap core JS-->
	
	<!-- Core JS-->
	<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>    
	<script src="//cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="//code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	
	
	<!-- <script src="/js/order.1.0.min.js"></script> -->
	<script src="/js/orderTest.js"></script>
	<script type="text/javaScript" language="javascript" defer="defer">
		
    </script>
</body>
</html>
