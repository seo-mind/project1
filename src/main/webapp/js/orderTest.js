

let json_list ;
$.post('/checkTodayOrder.do', function(data){
	json_list = JSON.parse(data);
	let _html = '';	
	let add_button = '';
		add_button+=' 					    <span class="visually-hidden">Toggle Dropdown</span>';
		add_button+=' 					  </button>';
		add_button+=' 					  <ul class="dropdown-menu">';
		add_button+=' 					    <li><a class="dropdown-item" href="#">확인</a></li>';
		add_button+=' 					    <li><a class="dropdown-item" href="#">미확인</a></li>';
		add_button+=' 					    <li><a class="dropdown-item" href="#">주문취소</a></li>';
		add_button+=' 					  </ul>';
		add_button+=' 					</div>';
	
	for( let i =0 ; i < json_list.length ; i ++ ) {	 
		let add_html =''; 
		let add_button_html = ''
		if ( json_list[i].checkMoney == 'N'  ) {
			add_html = ' class="bg-danger bg-gradient bg-opacity-10">';
			add_button_html = '<div class="btn-group"><button type="button" class="btn btn-sm btn-danger">미확인</button>';
			add_button_html+='<button type="button" class="btn btn-danger dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">';
		}else{
			add_html = '>';
			add_button_html = '<div class="btn-group"><button type="button" class="btn btn-sm btn-success">&nbsp;&nbsp;확인&nbsp;</button>';
			add_button_html+='<button type="button" class="btn btn-success dropdown-toggle dropdown-toggle-split" data-bs-toggle="dropdown" aria-expanded="false">';
		}
		
		
		_html += '<tr' + add_html;
		if ( json_list[i].idx == '0'){
			_html += '<td id="idx"> </td>';
		} else{
			_html += '<td id="idx">' + json_list[i].idx +'</td>';
		}
		
		_html += '<td id="menu_nm">'+ json_list[i].menuNm +'</td>';
		_html += '<td id="name">'+ json_list[i].name +'</td>';
		_html += '<td>'+ json_list[i].price +'</td>';
		
		if ( json_list[i].idx == '0'){
			if( json_list[i].menuNm != '총 금액'){
				_html += '<td> </td>';
			}else{
				_html += '<td class="lastCol">'+json_list[i].checkMoney+' + 3,000 </td>';
			}
		} else{
			_html += '<td>' +add_button_html + add_button +'</td>';
		}
		
		_html += '</tr>'
	} 
	
	$('#inhtml').html(_html);
	
	
	let total_price = Number($('.lastCol').html().replace(',', '')) ;
	let total_people =Number($('.lastCol').closest('tr').find('#name').html() );
	let delivery_tip = 3000 ;
	
	delivery_tip = 3000/total_people ;
	$('#delivery_tip').html(100+Math.ceil(delivery_tip));
});

$(document).on('click', '.dropdown-item', function(e){
	e.preventDefault();
	let idx = $(this).closest('tr').find('#idx').html();
	let check_money = $(this).html()=='확인' ?  'Y' : 'N' ;
	
	
	let send_obj = new Object();
	send_obj.idx = idx;
	send_obj.checkMoney = check_money;
	console.log(send_obj);
	
	
	if($(this).html() == '주문취소'){
		if(confirm('주문을 취소하시겠습니까?')){
			$.post('/delOrder.do',send_obj, function(data){
				location.href='/todayOrder.do';
			});
		}
	}else{
		$.post('/completeDeposit.do',send_obj, function(data){
			alert(data);
			location.href='/todayOrder.do';
		});
	}
	
	
});

$('#btn_img').click(()=>{
	
	$('#btn_img').attr('src', '/images/menu/closed.png');
	
});