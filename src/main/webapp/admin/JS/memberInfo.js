
var pageNo = 1; 
var pagenationPage = 5;
var viewItem = undefined; 




//로딩된후 실행시킴 
$(document).ready(function(){
	
	pageLoad(pageNo);
	TopComent();
	TopPostUser();
})

function click_move(){
    $("#list #names").click(function(){
        alert("test");
    })
}



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
        result += "<td><span id='names' class='subject' data-uid='" + items[i].um_UID + "'>" + items[i].um_USERNAME + "</span></td>\n";
        result += "<td>" + items[i].um_NICKNAME + "</td>\n";
        result += "<td><span data-viewcnt='" + items[i].um_UID + "'>" + items[i].user_regdate + "</span></td>\n";
        result += "</tr>\n";
    }

    $("#list tbody").html(result); //업데이트 
    $("#pageinfo").html( " 총 "+"<span class='text-warning' >" + JsonObj.totalCnt + "</span>" + " 명의 회원"  );

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
	
	var data = 
	{
	 option : taget ,
     text :  text_info}
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
			result += "<td><span data-viewcnt='" + items[i].um_UID + "'>" + items[i].UM_REGDATE + "</span></td>\n";
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



// 댓글을 많이단 순위 차트 
function TopComent(){
	$.ajax({
		url : "TopComent",
		type : "POST",
		cache : false,
		success : function(data,status){
			if(data.status =="OK")
			{
			
					ComentCharts(data)
			}
		}
	});
}



function ComentCharts(JsonObj){
	var items = JsonObj.list;
	var ctx = document.getElementById("userCharts");
	var myChart = new Chart(ctx, {
		type: 'horizontalBar',
		data: {
			labels: [
				items[0].um_USERNAME,
				items[1].um_USERNAME,
				items[2].um_USERNAME,
				items[3].um_USERNAME,
				items[4].um_USERNAME,


			],
			datasets: [{
				data: [

					items[0].cnt,
					items[1].cnt,
					items[2].cnt,
					items[3].cnt,
					items[4].cnt,


				],
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
			legend: { display: false },
			responsive: false,
			title: {
				display: true,
				text: '댓글을 가장 많이 생성한 유저'
			  },
			  scales: {
				xAxes: [{
				   ticks: {
					   beginAtZero: false,
					   stepSize: 1,
					   maxTicksLimit: 3
					   
				   }
				}]
			 }, 
		}
	});
}






// 가장 많은글을 쓴 유저 


function TopPostUser(){
	$.ajax({
		url : "TopPostUser",
		type : "GET",
		success : function(data,status){
			if(data.status == "OK"){
				donutChart(data)
			}

		}
	});
}


function donutChart(JsonObj){
	var items = JsonObj.list;
	var ctx = document.getElementById('userCharts2');
	var userCharts2 = new Chart(ctx, {
	    type: 'doughnut',
	    data: {
	        labels: [

				items[0].um_USERNAME,
				items[1].um_USERNAME,
				items[2].um_USERNAME,
				items[3].um_USERNAME,
				items[4].um_USERNAME,


			],
	        datasets: [{
	            label: '# of Votes',
	            data: [
					items[0].cnt,
					items[1].cnt,
					items[2].cnt,
					items[3].cnt,
					items[4].cnt,
				],
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
			title: {
				display: true,
				text: '글을 가장 많이 쓴 유저'
			  },
		},
	
	});
}