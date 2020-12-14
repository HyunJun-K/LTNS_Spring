
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
            
                if(updateList(data)){}
                
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
    var items  = JsonObj.list;
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
		return false;
	}
	
	var data = {option : $("#sele_option").val() ,  text :  $("#text_info").val()}
	$.ajax({
		data : JSON.stringify(data), 
		url : "SEACH",
		type : "DELETE",
		dataType : "JSON",
		contentType:'application/json;',
		 success : function(data, status){
	            if(status == "success"){
	            
	                if(seachData(data)){}
	                
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
	    var items  = JsonObj.list;
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



function reportMan (){
	
}




function chart(){

	var ctx = document.getElementById('myChart').getContext('2d');
	var myChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
	        datasets: [{
	            label: '# of Votes',
	            data: [12, 19, 3, 5, 2, 3],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(75, 192, 192, 0.2)',
	                'rgba(153, 102, 255, 0.2)',
	                'rgba(255, 159, 64, 0.2)'
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(75, 192, 192, 1)',
	                'rgba(153, 102, 255, 1)',
	                'rgba(255, 159, 64, 1)'
	            ],
	            borderWidth: 1
	        }]
	    },
	    options: {
	    	responsive: false,
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero: true
	                }
	            }]
	        }
	    }
	});
	
}