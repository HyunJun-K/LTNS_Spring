$(document).ready(function(){
	
	/* 페이지 로딩시, 노선 입력에 노선 값들을 집어 넣기 */
	$.ajax({
		url:"http://localhost:8089/rest_area/restarea/routeName",
		type:'GET',
		cache:false,
		success:function(data,status){
			if(status=="success"){
				var list=data.list;
				var htmlval="";
				for(i=0;i<list.length;i++){
					htmlval+='<li><a tabindex="-1" role="button" onclick="changeRouteNameValue(\''+list[i].ra_routeName+'\')">'+list[i].ra_routeName+'</a></li>';
				}
				$("#routeNameList").html(htmlval);
			}
		}
	});
	
	/* top_arrow 버튼 스크롤에 따른 fadeout 설정   
	경로 : others/fixedbtn/fixedbtn.js */
	$(window).scroll(top_arrow_fadeout);
	
})//end - $(document).ready
