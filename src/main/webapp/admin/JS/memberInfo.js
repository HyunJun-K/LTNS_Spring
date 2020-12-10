var pageNo = 1; 
var pagenationPage = 10;
var viewItem = undefined; 




//로딩된후 실행시킴 
$(document).ready(function(){
	
	pageLoad(pageNo)
})




function pageLoad(pageNo){
	var values = {pageNo : "1" , pagenationPage : "10"}
    $.ajax({
    	  data : JSON.stringify(values),
    	  url : "memberInfo",
          type : "POST",
          cache : false,
          contentType : 'application/json; charset=UTF-8',
          dataType : 'json',
      	  success : function(data, status){
            if(status == "success"){
            
                if(updateList(data)){
                    // 페이지 로딩 성공한 뒤에 
                    // 업데이트 된 list 에 view 동작 이벤트 
                    addViewEvent();
                }
            }
            
        }
    });
	
	
}



function updateList(JsonObj) {

    var result = ""; 

    if(JsonObj.status == "OK"){
        var count = JsonObj.count; 
        window.page = JsonObj.page;
        window.pageRows = JsonObj.pagerows;
    var i;
    var items  = JsonObj.data;
    for(i=0; i<count; i++){
        result += "<tr>\n";
        result += "<td><input type='checkbox' name='uid' value='" + items[i].UM_UID + "'></td>\n";
        result += "<td>" + items[i].UM_UID + "</td>\n";
        result += "<td><span class='subject' data-uid='" + items[i].uid + "'>" + items[i].UM_USERNAME + "</span></td>\n";
        result += "<td>" + items[i].NICKNAME + "</td>\n";
        result += "<td><span data-viewcnt='" + items[i].uid + "'>" + items[i].UM_REGDATE + "</span></td>\n";
        result += "<td>" + items[i].UM_ENABLED + "</td>\n"; // DTO 의 getRegDate() 를 수정했으면 원하는 문자열 형태로 받을수도 있다.
        result += "</tr>\n";
    }

    $("#list tbody").html(result); //업데이트 
    $("#pageinfo").text(JsonObj.page + "/" + JsonObj.totalpage + "페이지, " + JsonObj.totalcnt + " 개의 글");
   
   
    //pageRows 셋팅 
    var txt = "<select id='rows' onchange='changePageRows()'> \n ";
    txt += "<option " + ((window.pageRows == 10) ? "selected": " value ='10' ") + "> 10 </option> \n";
    txt += "<option " + ((window.pageRows == 20) ? "selected": " value ='20' ") + " > 20 </option> \n";
    txt += "<option " + ((window.pageRows == 30) ? "selected": "  value ='30'") + " > 30 </option> \n";
    txt += "<option " + ((window.pageRows == 40) ? "selected": "  value ='40'") + " > 40 </option> \n";
    txt += "<select> \n";
    $("#pageRows").html(txt);

    //페이징 정보 업데이트 
    var pagination = buildPagination(JsonObj.writepages, JsonObj.totalpage, JsonObj.page, JsonObj.pagerows);
    $("#pagination").html(pagination);

   
    return true;
   } else {
       alert("내용이 없습니다")
       return false;
   } 
}


