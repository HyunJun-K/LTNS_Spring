
function top_arrow_fadeout() {
	if ($(this).scrollTop() > 200) {
		$('#top_arrow').fadeIn();
	} else {
		$('#top_arrow').fadeOut();
	}
}

function gototop() {
		$( 'html, body' ).animate( { scrollTop : 0 }, 400 );
		return false;
}

function changeListSortValue(listSort){
	let sortval_str;
	let html_str;
	if(listSort=='휴게소'){
		sortval_str='ra';
		html_str=
		'<div class="custom-control custom-radio">'+
		'	<input type="radio" name="jb-radio" id="jb-radio-1" class="custom-control-input" name="orderBy" value="default">'+
		'	<label class="custom-control-label" for="jb-radio-1">경로 순서</label>'+
		'</div>'+
		'<div class="custom-control custom-radio">'+
		'	<input type="radio" name="jb-radio" id="jb-radio-2" class="custom-control-input" name="orderBy" value="BY_LIKE">'+
		'	<label class="custom-control-label" for="jb-radio-2">좋아요 순서</label>'+
		'</div>';
	}
	else if(listSort=='주유소'){
		sortval_str='gs';
		html_str=
		'<div class="custom-control custom-radio">'+
		'	<input type="radio" name="jb-radio" id="jb-radio-1" class="custom-control-input" name="orderBy" value="default">'+
		'	<label class="custom-control-label" for="jb-radio-1">경로 순서</label>'+
		'</div>'+
		'<div class="custom-control custom-radio">'+
		'	<input type="radio" name="jb-radio" id="jb-radio-2" class="custom-control-input" name="orderBy" value="BY_LIKE">'+
		'	<label class="custom-control-label" for="jb-radio-2">좋아요 순서</label>'+
		'</div>'+
		'<div class="custom-control custom-radio">'+
		'	<input type="radio" name="jb-radio" id="jb-radio-3" class="custom-control-input" name="orderBy" value="BY_DIESEL">'+
		'	<label class="custom-control-label" for="jb-radio-3">경유 가격 순서</label>'+
		'</div>'+
		'<div class="custom-control custom-radio">'+
		'	<input type="radio" name="jb-radio" id="jb-radio-4" class="custom-control-input" name="orderBy" value="BY_GASOLINE">'+
		'	<label class="custom-control-label" for="jb-radio-4">휘발유 가격 순서</label>'+
		'</div>'+
		'<div class="custom-control custom-radio">'+
		'	<input type="radio" name="jb-radio" id="jb-radio-5" class="custom-control-input" name="orderBy" value="BY_LPG">'+
		'	<label class="custom-control-label" for="jb-radio-5">LPG 가격 순서</label>'+
		'</div>';
	}
	else if(listSort=='음식메뉴'){
		sortval_str='fm';
		html_str=
		'<div class="custom-control custom-radio">'+
		'	<input type="radio" name="jb-radio" id="jb-radio-1" class="custom-control-input" name="orderBy" value="default">'+
		'	<label class="custom-control-label" for="jb-radio-1">경로 순서</label>'+
		'</div>'+
		'<div class="custom-control custom-radio">'+
		'	<input type="radio" name="jb-radio" id="jb-radio-2" class="custom-control-input" name="orderBy" value="BY_LIKE">'+
		'	<label class="custom-control-label" for="jb-radio-2">좋아요 순서</label>'+
		'</div>'+
		'<div class="custom-control custom-radio">'+
		'	<input type="radio" name="jb-radio" id="jb-radio-3" class="custom-control-input" name="orderBy" value="BY_PRICE">'+
		'	<label class="custom-control-label" for="jb-radio-3">가격 순서</label>'+
		'</div>';
	} 
	$("#listSortBtn").attr('value',sortval_str);
	$("#listSortBtn").html(listSort);
	$("#orderBy").html(html_str);
}

function changeRouteNameValue(routeName){
	
	$('#routeName').attr('value',routeName);

	$.ajax({
		url:'http://localhost:8089/rest_area/restarea/destination/'+routeName,
		type:'GET',
		cache:false,
		success:function(data,status){ 
			if(status=="success"){
				$('#destination').attr('value',null);
				var row=data.list;
				html_str="";
				for(i=0;i<row.length;i++){
					html_str+=' <li><a tabindex="-1" role="button" onclick="changeDestinationValue(\''+row[i].ra_destination+'\')">'+row[i].ra_destination+'</a></li>';
				}
				$("#destinationList").html(html_str);
			}
		}
	});//ajax 전체 노선 불러오기
	
	//리스트 깔기
	
}

function changeDestinationValue(destination){
	$('#destination').attr('value',destination);
}

//리스트 ajax 요청하여 띄우는 펑션
function printList(){
	
}

//휴게소 JSON 파싱

//주유소 JSON 파싱

//음식 메뉴 JSON 파싱
