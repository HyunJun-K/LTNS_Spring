

//date pick  ( jquery ui ) 


function click_delete() {
		var url = "deletePopup";
		var name = "deletePopup";
		var option = "width = 600, height = 200 left = 100, top=50,location=no";
		window.open(url,name,option)
}; 


function click_add() {
	var url = "schedulePopup";
	var name = "schedulePopup";
	var option = "width = 600, height = 600 left = 100, top=50,location=no";
	window.open(url,name,option)
}; 


function click_update() {
	var url = "updatePopup";
	var name = "updatePopup";
	var option = "width = 600, height = 720 left = 100, top=50,location=no";
	window.open(url,name,option)
}; 



$(function () {
	
	$.datepicker.setDefaults({
		dateFormat : 'yy-mm-dd',	//날짜 포맷
		showOtherMonths : true,		// 다른달 보여주기
		showMonthAfterYear : true,	// 년도가 월보다 먼저 표시
		changeYear : true, 	// 콤보박스로 년월일 선택
		changeMonth : true, 
		yearSuffix: "년", 
		monthNamesShort : ['1','2','3','4','5','6','7','8','9','10','11','12'],
		monthNames : ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		dateNamesMin : ['일','월','화','수','목','금','토'],
		dayNames : ['일요일','월요일','화요일','수요일','목요일','금요일','토요일']
	
	});  // 데이터피커 default 옵션 변경 
	
	
	$("#startDate").datepicker(); //시작일
	$("#endDate").datepicker(); // 끝일 
	
	$("#startDate").datepicker('setDate', 'today'); //시작일
	$("#endDate").datepicker('setDate', 'today'); 
	
	
	
})



//add schedule
$.fn.serializeObject = function(){
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
    	var name = $.trim(this.name),
    		value = $.trim(this.value);
    	
        if (o[name]) {
            if (!o[name].push) {
                o[name] = [o[name]];
            }
            o[name].push(value || '');
        } else {
            o[name] = value || '';
        }
    });
    return o;
};

function click_ok(){
	
	var scheduleData = JSON.stringify($('form#scheduleData').serializeObject());
	$.ajax({
		data : scheduleData,
		url : "schedule",
		type : "POST",
		dataType : "JSON",
		contentType:'application/json;',
		success : function(data) {
			
		}
	});
	alert("일정이 추가되었습니다.")
	opener.parent.location.reload();
	location.reload();
	window.close();
};


function delete_ok(){
	var scheduleData = JSON.stringify($('form#deleteForm').serializeObject());
	$.ajax({
		data : scheduleData,
		url : "schedule",
		type : "DELETE",
		dataType : "JSON",
		contentType:'application/json;',
		success : function(data) {
			
		}
	});
	alert("일정이 삭제되었습니다..")
	opener.parent.location.reload();
	location.reload();
	window.close();
};





function update_ok(){
	var scheduleData = JSON.stringify($('form#updateForm').serializeObject());
	$.ajax({
		data : scheduleData,
		url : "schedule",
		type : "PUT",
		dataType : "JSON",
		contentType:'application/json;',
		success : function(data) {
			
		}
	});
	alert("일정이 수정되었습니다..")
	opener.parent.location.reload();
	location.reload();
	window.close();
};



  

  
  
 
 
 




