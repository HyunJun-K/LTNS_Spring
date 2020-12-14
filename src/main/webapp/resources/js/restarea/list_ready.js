$(document).ready(function(){
	
	/* 페이지 로딩시, 노선 입력에 노선 값들을 집어 넣기 */
	$.ajax({
		url:"../restarea/routeName",
		type:'GET',
		cache:false,
		success:function(data,status){
			if(status=="success"){
				var list=data.list;
				var htmlval="";
				for(i=0;i<list.length;i++){
					htmlval+='<li><a class="dropdownRouteNameList" tabindex="-1" role="button" onclick="changeRouteNameValue(\''+list[i].ra_routeName+'\')">'+list[i].ra_routeName+'</a></li>';
				}
				$("#routeNameList").html(htmlval);
			}
		}
	});
	
	/* top_arrow 버튼 스크롤에 따른 fadeout 설정   
	경로 : others/fixedbtn/fixedbtn.js */
	
	$(window).scroll(function(){
		console.log("a");
		console.log("b");
		console.log("$(window).scrollTop() : "+$(window).scrollTop()+", $(document).height() : "+$(document).height()+"$(window).height() : "+$(window).height());
		if($(window).scrollTop()+1 >= $(document).height() - $(window).height()){
			console.log("c");
			console.log("d");
			scrollInfinteList();
		}		
		console.log("e");
		top_arrow_fadeout();
	});
	
})//end - $(document).ready
