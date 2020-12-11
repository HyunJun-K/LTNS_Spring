
var pageNo = 1; 
var pagenationPage = 5;
var viewItem = undefined; 




//로딩된후 실행시킴 
$(document).ready(function(){
	
	pageLoad(pageNo)
	topLists()
	
})


function topLists(){
	$.ajax({
		url : "Toplist",
		type : "POST",
		success : function(data, status){
			if(status == "success"){
				charts(data)
			}
		}
	})
	
}

function pageLoad(pageNo){
	
    $.ajax({
    	  url : "./postInfo/" + pageNo + "/" + pagenationPage,
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


function charts(JsonObj) {
	var count = JsonObj.count; 
	var ctx = document.getElementById('myChart');
	var item = JsonObj.data;
	var myChart = new Chart(ctx, {
		type: 'bar',
	    
		data: {
	        labels: 
	        	[item[0].post_title , item[1].post_title, item[2].post_title, item[3].post_title, item[4].post_title ],
	        	
	        datasets: [{
	            label: '# of Votes',
	            data: [item[0].post_reported , item[1].post_reported, item[2].post_reported, item[3].post_reported, item[4].post_reported],
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
        result += "<td><input type='checkbox' name='uid' value='" + items[i].post_id + "'></td>\n";
        result += "<td>" + items[i].post_id + "</td>\n";
        result += "<td><span class='subject' data-uid='" + items[i].post_id + "'>" + items[i].post_title + "</span></td>\n";
        result += "<td>" + items[i].post_contents + "</td>\n";
        result += "<td><span data-viewcnt='" + items[i].post_id + "'>" + items[i].ra_code + "</span></td>\n";
        result += "<td>" + items[i].um_USERNAME + "</td>\n"; 
        result += "<td>" + items[i].post_reported + "</td>\n"; 
        
        result += "</tr>\n";
    }

    $("#list tbody").html(result); //업데이트 
    $("#pageinfo").html( "<span class='text-warning' >" + JsonObj.totalCnt + "</span>" + " 개의 게시글"  );

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
