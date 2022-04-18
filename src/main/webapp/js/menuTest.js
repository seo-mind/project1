

let json_list ;
const name_list = new Array();


$('.btn-order').click(function(e){
	e.preventDefault();
	
	if(confirm('주문하러 바로 가기')){
		location.href='#myOrderList';
	}
	
	let _html = '<div class="col mb-5">' + $(this).closest('.col').html() +  '</div>';
	_html = _html.replace('선택', '빼기');
	_html = _html.replace('btn-order' , 'btn-delete');
	$('.myOrderList').append(_html); 
});

$(document).on('click', '.btn-delete', function(e){
	e.preventDefault();
	let _idx =  $(this).closest('.col').index();
	$('.myOrderList').find('.col').eq(_idx).remove();
	
});

let price = '';
let num_price = 0;
$('.btn-orderMyList').click(function(e){
	e.preventDefault();
	$.post('/checkName.do', function(data){
		json_list = JSON.parse(data);
			
		for( let i =0 ; i < json_list.length ; i ++ ) {
			let obj = new Object();
			obj = json_list[i].name;
			name_list.push(obj);
		} 
	});
	
	price = $('.myOrderList').find('#price').html();
	num_price = 0;
	for( let i =0 ; i < $('.myOrderList').find('#price').length ; i ++ ) {
		num_price += Number($('.myOrderList').find('#price').eq(i).html().replace(',', '') );
		
	}
	console.log(num_price);
	
	$('.price').val(num_price.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ","));
	$('#menuModal').modal("show");
	
});

$('.order_nm').autocomplete({
	source: name_list
	, select : function( event, ui){
		for( let i =0 ; i < json_list.length ; i ++ ) {
			if( ui.item.value  == json_list[i].name ){
				$('.mattermost_id').val(json_list[i].mattermostId);
			}		
			
		}
	}, focus :function(){
		return false; 
	}
	
	
}).blur(function(){
	if( $('.mattermost_id').val() == ''){
		for( let i =0 ; i < json_list.length ; i ++ ) {
			if( $('.order_nm').val()  == json_list[i].name ){
				$('.mattermost_id').val(json_list[i].mattermostId);
			}		
		} 
	}
});


$('#menuModal').on('shown.bs.modal', function() { $('.order_nm').autocomplete('option', 'appendTo', '#menuModal') })


$('.btn-send').click(function(e){
	let mattermostId = $('.mattermost_id').val();
	if( mattermostId == '' ){
		alert('mattermost 아이디를 확인해주세요');
		return ; 
	}
	
	let order_nm =  $('.order_nm').val();
	let send_list = new Array();
	
	for( let i =0 ; i < $('.myOrderList').find('#price').length ; i++ ){
		let send_obj = new Object();
		send_obj.mattermostId = mattermostId;
		send_obj.name = order_nm;
		send_obj.menuNm = $('.myOrderList').find('#menu_nm').eq(i).html();
		send_obj.price = Number($('.myOrderList').find('#price').eq(i).html().replace(',', '') );
		
		send_list.push(send_obj);
	}
	
	let last_obj = {
		"menuList" : send_list
	};
	$.post('/sendOrder.do',{"param": JSON.stringify(last_obj)},  function(data){
		alert(data);
		$('.mattermost_id').val('');
		$('.order_nm').val('');
		$('#menuModal').modal('toggle');
		if(confirm('주문 확인하러 가시겠습니까?')){
			location.href='/todayOrder.do';
		}
	}); 
});
