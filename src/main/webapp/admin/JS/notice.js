const pageno = 1; 
const pagenationPage = 10; 

$(document).ready(function(){
    pageLoad(pageno)
    $(".viewList").hide();
	
})


  
function pageLoad(pageno){
        $.ajax({
            url : "./notice/" + pageno + "/" + pagenationPage,
            Type : "GET",
           /* headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },

            */
            dataType : "JSON",
            contentType:'application/json;',
            success : function(data, status){
                if(data.status=="OK"){
                    viewData(data);
                }
            }
        });
}// end pageLoad


function viewData(JsonObj){
        var result = "";
        var datas = JsonObj.list;
        var count = JsonObj.count;
        var i = 0 ;
        for (i; i<count; i++){
            result += "<tr> \n";
            result += "<th  >" + datas[i].notice_id; + "</th> \n";
            result += "<th  id='btns' data-age='"+datas[i].notice_id+"' class='titles_notice'>" + datas[i].notice_subject; + "</th> \n"; 
            result += "<th >" + datas[i].notice_regdate; + "</th> \n";
            result += "<th >" + datas[i].notice_writer; + "</th> \n";
            result += "</tr> \n";
        }

        $("#list tbody").html(result);
         //페이징 정보 업데이트 
        var pagination = pageinateions(JsonObj.writePages, JsonObj.totalPage, JsonObj.pageNo, JsonObj.pagenationPage);
        $("#pagination").html(pagination);
        
        
        $("#list #btns").on("click",function(){
        	var data = $(this).attr('data-age');
        	view(data)
    	})
    	
    	
    	
        
}//end view Data


function pageinateions(writepages, totalPage, curPage, pageRows){
  
        
        var str ="";
        var start_page = ((parseInt( curPage -1 ) / writepages ) ) * writepages + 1;
        var end_page = start_page + writepages -1;

        if(end_page >= totalPage){
            end_page = totalPage;
        }

        if(curPage > 1){
            str += "<li><a onclick='pageLoad(" + 1 + ")' class='tooltip-top' title='처음'><i class='fas fa-angle-double-left'></i></a></li>\n";
        }
        
        if (start_page > 1) 
            str += "<li><a onclick='pageLoad(" + (start_page - 1) + ")' class='tooltip-top' title='이전'><i class='fas fa-angle-left'></i></a></li>\n";
        
        if (totalPage > 1) {
            for (var k = start_page; k <= end_page; k++) {
                if (curPage != k)
                    str += "<li><a onclick='pageLoad(" + k + ")'>" + k + "</a></li>\n";
                else
                    str += "<li><a class='active tooltip-top' title='현재페이지'>" + k + "</a></li>\n";
            }
        }
        
        if (totalPage > end_page){
            str += "<li><a onclick='pageLoad(" + (end_page + 1) + ")' class='tooltip-top' title='다음'><i class='fas fa-angle-right'></i></a></li>\n";
        }
     
        if (curPage < totalPage) {
            str += "<li><a onclick='pageLoad(" + totalPage + ")' class='tooltip-top' title='맨끝'><i class='fas fa-angle-double-right'></i></a></li>\n";
        }
     
        return str;


}// end pageNation



function view(id){
	$("#list").hide();
	$(".viewList").show();
	$.ajax({
		url : "./notice/" + id,
		data : "GET",
		 dataType : "JSON",
         contentType:'application/json;',
         success : function(data, status){
             if(data.status=="OK"){
            	 
            		$(".viewTitle").text(data.list[0].notice_subject);
            		$(".viewNo").text(data.list[0].notice_id);
            		$("#viewDate").text(data.list[0].notice_regdate);
            		$("#viewId").text(data.list[0].notice_writer + "관리자 님");
            		$(".viewContent").text(data.list[0].notice_content);
             }
         }
     });
		
	
	 
	 
}

