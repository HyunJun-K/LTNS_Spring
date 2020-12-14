
var pageNo = 1; 
var pagenationPage = 5;
var viewItem = undefined; 




//로딩된후 실행시킴 
$(document).ready(function(){
	
	pageLoad(pageNo)
    topLists()
   
    $("#btnDel").click(function(){
        click_delete();
    })

    
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

// 페이지 리스트 AJAX 요청
function pageLoad(pageNo){
	
    $.ajax({
    	  url : "./postInfo/" + pageNo + "/" + pagenationPage,
          type : "GET",
          cache : false,
          contentType : 'application/json; charset=UTF-8',
          dataType : 'json',
      	  success : function(data, status){
            if(status == "success"){
            
                if(updateList(data)){
                    click_move()
                }
              
            }
            
        }
    });
	
	
}

// 차트 
function charts(JsonObj) {
	var count = JsonObj.count; 
	var ctx = document.getElementById('myChart');
	var item = JsonObj.list;
	var myChart = new Chart(ctx, {
		type: 'bar',
	    
		data: {
	        labels: 
	        	[item[0].post_title , item[1].post_title, item[2].post_title, item[3].post_title, item[4].post_title ],
	        	
	        datasets: [{
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
	            borderWidth: 1,
		    	
	        }]
	    },
	    options: {
	    	responsive: false,
	    	   legend: { display: false },
	    	title: {
	              display: true,
	              text: '가장많은 신고가 접수된 게시물'
	        },
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




// 요청받은 ajax를 읽어와서 표를 그려줌
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
        result += "<td><input type='checkbox' name='post_id' value='" + items[i].post_id + "'></td>\n";
        result += "<td>" + items[i].post_id + "</td>\n";
        result += "<td><span class='subject' data-post_id='" + items[i].post_id + "'>" + items[i].post_title + "</span></td>\n";
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


function click_move(){
    $("#list .subject").click(function(){
        alert("test");
    })
}


// 글삭제 
function click_delete() {
    var post_id = []; 

    //each 요소 검색
    $("#list tbody input[name=post_id]").each(function(){
             if($(this).is(":checked")){
                post_id.push(parseInt($(this).val())); // 만약에 uid가 클릭이되면 uid 배열에 푸쉬해줌 
             }
    });


    //유효성검사

    if(post_id.length == 0){
        alert("삭제 하실 글을 선택해주세요 ")
        return false;
    }else {
        if(!confirm(post_id.length + '글을 삭제하시겠습니까?')) return false;

        var data = $("#frmList").serialize();  // form 데이터를 String 형태로 정리를해줌 

            $.ajax({
                url :  "DELETEPOST",
                type : "POST",
                data : data,
                cache : false,
                success : function(data, status){
             
               if(status=="success"){
                if(data.status =="OK"){
                                alert("삭제 성공")
                                pageLoad(pageNo);
                            }else{
                                alert("데이터 삭제 실패" + data.status) 
                                return false;
                            }
                        }
                 }
            });
        }
    return true;

}









// 페이지 네이션 
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
	
    var tex = $("#sele_option").val();
    var text_info = $("#text_info").val();
	
	
	if(text_info == null || text_info ==""){
		alert("검색 내용이 비었습니다.");
		return false;
	}
	
	var data = { 
        target : tex ,
        content : text_info
    }
	$.ajax({
		data : JSON.stringify(data), 
		url : "SEACHPOSTINFO",
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
            result += "<td><input type='checkbox' name='post_id' value='" + items[i].post_id + "'></td>\n";
            result += "<td>" + items[i].post_id + "</td>\n";
            result += "<td><span class='subject' data-post_id='" + items[i].post_id + "'>" + items[i].post_title + "</span></td>\n";
            result += "<td>" + items[i].post_contents + "</td>\n";
            result += "<td><span data-viewcnt='" + items[i].post_id + "'>" + items[i].ra_code + "</span></td>\n";
            result += "<td>" + items[i].um_USERNAME + "</td>\n"; 
            result += "<td>" + items[i].post_reported + "</td>\n"; 
            
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
