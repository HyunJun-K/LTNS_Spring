
var pageNo = 1; 
var pagenationPage = 5;
var viewItem = undefined; 




//로딩된후 실행시킴 
$(document).ready(function(){
	
	pageLoad(pageNo)
	
})




function pageLoad(pageNo){
	
    $.ajax({
    	  url : "./memberInfo/" + pageNo + "/" + pagenationPage,
          type : "GET",
          cache : false,
          contentType : 'application/json; charset=UTF-8',
          dataType : 'json',
      	  success : function(data, status){
            if(status == "success"){
            
                if(updateList(data)){
                    // 페이지 로딩 성공한 뒤에 
                    // 업데이트 된 list 에 view 동작 이벤트 
                   
                }
            }
            
        }
    });
	
	
}



function updateList(JsonObj) {

    var result = ""; 

    if(JsonObj.status == "OK"){
        var count = JsonObj.count; 
        window.page = JsonObj.pageNo;
        window.pageRows = JsonObj.pagenationPage;
    var i;
    var items  = JsonObj.data;
    for(i=0; i<count; i++){
        result += "<tr>\n";
        result += "<td><input type='checkbox' name='uid' value='" + items[i].um_UID + "'></td>\n";
        result += "<td>" + items[i].um_UID + "</td>\n";
        result += "<td><span class='subject' data-uid='" + items[i].um_UID + "'>" + items[i].um_USERNAME + "</span></td>\n";
        result += "<td>" + items[i].um_NICKNAME + "</td>\n";
        result += "<td><span data-viewcnt='" + items[i].um_UID + "'>" + items[i].um_REGDATE + "</span></td>\n";
        result += "<td>" + items[i].um_ENABLED + "</td>\n"; // DTO 의 getRegDate() 를 수정했으면 원하는 문자열 형태로 받을수도 있다.
        result += "</tr>\n";
    }

    $("#list tbody").html(result); //업데이트 
    $("#pageinfo").html(JsonObj.pageNo + " / " + JsonObj.totalPage + "페이지  " +  "<span class='text-warning' >" + JsonObj.totalCnt + "</span>" + " 명의 회원"  );

    //페이징 정보 업데이트 
    var pagination = buildPagination(JsonObj.writePages, JsonObj.totalPage, JsonObj.pageNo, JsonObj.pagenationPage);
    $("#pagination").html(pagination);

   
    return true;
   } else {
       alert("내용이 없습니다")
       return false;
   } 
}


function buildPagination(writePages, totalPage, curPage, pageRows){
    var str = "";   // 최종적으로 페이징에 나타날 HTML 문자열 <li> 태그로 구성
    
    // 페이징에 보여질 숫자들 (시작숫자 start_page ~ 끝숫자 end_page)
    var start_page = ( (parseInt( (curPage - 1 ) / writePages ) ) * writePages ) + 1;
    var end_page = start_page + writePages - 1;
 
    if (end_page >= totalPage){
        end_page = totalPage;
    }
    
  //■ << 표시 여부
    if(curPage > 1){
        str += "<li><a onclick='pageLoad(" + 1 + ")' class='tooltip-top' title='처음'><i class='fas fa-angle-double-left'></i></a></li>\n";
    }
    
    //■  < 표시 여부
    if (start_page > 1) 
        str += "<li><a onclick='pageLoad(" + (start_page - 1) + ")' class='tooltip-top' title='이전'><i class='fas fa-angle-left'></i></a></li>\n";
    
    //■  페이징 안의 '숫자' 표시 
    if (totalPage > 1) {
        for (var k = start_page; k <= end_page; k++) {
            if (curPage != k)
                str += "<li><a onclick='pageLoad(" + k + ")'>" + k + "</a></li>\n";
            else
                str += "<li><a class='active tooltip-top' title='현재페이지'>" + k + "</a></li>\n";
        }
    }
    
    //■ > 표시
    if (totalPage > end_page){
        str += "<li><a onclick='pageLoad(" + (end_page + 1) + ")' class='tooltip-top' title='다음'><i class='fas fa-angle-right'></i></a></li>\n";
    }
 
    //■ >> 표시
    if (curPage < totalPage) {
        str += "<li><a onclick='pageLoad(" + totalPage + ")' class='tooltip-top' title='맨끝'><i class='fas fa-angle-double-right'></i></a></li>\n";
    }
 
    return str;
} // end buildPagination


function addSerch(){
	
	
	
	var taget = $("#sele_option").val();
	var text_info = $("#text_info").val();
	
	
	if(text_info == null || text_info ==""){
		alert("검색 내용이 비었습니다.");
		
	}
	
	var data = {option : $("#sele_option").val() ,  text :  $("#text_info").val()}
	$.ajax({
		data : JSON.stringify(data), 
		url : ".",
		type : "DELETE",
		dataType : "JSON",
		contentType:'application/json;',
		 success : function(data, status){
	            if(status == "success"){
	            
	                if(seachData(data)){
	                    // 페이지 로딩 성공한 뒤에 
	                    // 업데이트 된 list 에 view 동작 이벤트 
	         }
	       }
	    }
	});
	
}


function seachData(JsonObj){
	
	  var result = ""; 

	    if(JsonObj.status == "OK"){
	        var count = JsonObj.count; 
	        window.page = JsonObj.pageNo;
	        window.pageRows = JsonObj.pagenationPage;
	    var i;
	    var items  = JsonObj.data;
	    for(i=0; i<count; i++){
	        result += "<tr>\n";
	        result += "<td><input type='checkbox' name='uid' value='" + items[i].um_UID + "'></td>\n";
	        result += "<td>" + items[i].um_UID + "</td>\n";
	        result += "<td><span class='subject' data-uid='" + items[i].um_UID + "'>" + items[i].um_USERNAME + "</span></td>\n";
	        result += "<td>" + items[i].um_NICKNAME + "</td>\n";
	        result += "<td><span data-viewcnt='" + items[i].um_UID + "'>" + items[i].um_REGDATE + "</span></td>\n";
	        result += "<td>" + items[i].um_ENABLED + "</td>\n"; // DTO 의 getRegDate() 를 수정했으면 원하는 문자열 형태로 받을수도 있다.
	        result += "</tr>\n";
	    }

	    $("#list tbody").html(result); //업데이트 
	    $("#pageinfo").html(JsonObj.pageNo + " / " + JsonObj.totalPage + "페이지  " +  "<span class='text-warning' >" + JsonObj.totalCnt + "</span>" + " 명의 회원"  );

	    //페이징 정보 업데이트 
	    var pagination = buildPagination(JsonObj.writePages, JsonObj.totalPage, JsonObj.pageNo, JsonObj.pagenationPage);
	    $("#pagination").html(pagination);

	   
	    return true;
	   } else {
	       alert("내용이 없습니다")
	       return false;
	   } 
	
}
