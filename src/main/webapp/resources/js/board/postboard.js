/* post list */
//ajax 요청
function postboard_ajax(){
	$.ajax({
		
	});
}

//post list 초기화 
function postboard_refresh(){
	postboard_ajax();
	
}


/* 회원 확인 */
function chk_usermember(){
	$()
}
/* post write */

//글작성 클릭 시
function open_post_new(){
    $('#btn_open_post_new').hide();
    $('#postwrite_new').show();
}

function post_new(){
	console.log("포스트 뉴 왔다");
	var PostVO={
		post_id:'',
		post_title:$('.write_post_title').val(),
		post_contents:$('.write_post_content').val(),
		um_uid:$('header #header_um_uid').html(),
		um_username:$('header #header_um_username').html(),
		post_regdate:'',
		ra_code:$('#restareaview p#ra_code').html(),
		post_reported:''
	};
	console.log(PostVO);
	//post 전송
	$.ajax({
		url:BASE_URL+'/board/post',
		headers: {
                'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
            },
		type:'PUT',
		dataType:'JSON',
		contentType:'application/json',
		data:JSON.stringify(PostVO),
		success:function(data){
			console.log("성공!");
		    $('#btn_open_post_new').show();
    		$('#postwrite_new').hide();
			postview_refresh();
			postboard_refresh();	
		}
	});
}

function postview_refresh(){
    $('.write_post_title').val('');
    $('.write_post_content').val('');
}

function post_cancle(){
    postview_refresh();
    $('#postwrite_new').hide();
	$('#btn_open_post_new').show();
}

function post_update(post_id){

}

//textarea 글씨 갯수 검사
function post_chkTextlimit(textarea,limitChar){
    let charlength=textarea.value.length;
    if(charlength>=limitChar){
        let str=textarea.value.substr(0,limitChar);
        textarea.value=str;
    }
    $('#post_textLength').html(charlength);
}

/*post view*/
function postView(post_id){
    //기존 body가 있다면 지운다.
    $('tr.postbody').remove();
    //post_id의 ajax를 요청한다.
    $.ajax({
        url:BASE_URL+"/board/post/view/"+post_id,
        type:'GET',
        cache:false,
        success:function(data,status){
            if(status=="success"){
                if(data.count==0){}
                else{
                    postBody(data);
                }
            }
        }
    });

    
}

function postBody(jsonObj){
    //해당 post_id의 head 바로 아래 body를 만들어 ajax로 받아 내용을 띄워준다.
    let str='<tr class="postbody">'+
    '<div class="post_content">'+
    jsonObj.obj.post_contents+
    '</div>'+
    '<button id="post_updatebtn" class="btn info">수정</button>'+
    '<button id="post_deletebtn" class="btn danger">삭제</button>'+
    '</tr>'

    $('tr.posthead_'+post_id).after(str);
}


function setPostboard(jsonObj){
    postboard_str='';
    for(i=0;i<jsonObj.length;i++){
        postboard_str+='<tr id="posthead">'+
        '<td class="ra_code undisplay">'+jsonObj[i].ra_code+'</td>'+
        '<td class="post_id undisplay">'+jsonObj[i].post_id+'</td>'+
        '<td class="post_title">'+jsonObj[i].post_title+'</td>'+
        '<td class="um_username">'+jsonObj[i].post_username+'</td>'+
        '<td class="post_like_cnt">'+jsonObj[i].post_like_cnt+'</td>'+
        '<td class="post_regdate">'+jsonObj[i].post_regdate+'</td>'+
        '<td class="post_reported">신고 버튼과 그 안의 이미지..</td>'+
    '</tr>';
    }

    $('#post_frmlist tbody').html(postboard_str);
    
}

/*페이지네이션*/
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
		str += "<li><a onclick='loadPage(" + 1 + ")' class='tooltip-top' title='처음'><i class='fas fa-angle-double-left'></i></a></li>\n";
	}
	
  	//■  < 표시 여부
    if (start_page > 1) 
    	str += "<li><a onclick='loadPage(" + (start_page - 1) + ")' class='tooltip-top' title='이전'><i class='fas fa-angle-left'></i></a></li>\n";
    
    //■  페이징 안의 '숫자' 표시	
	if (totalPage > 1) {
	    for (var k = start_page; k <= end_page; k++) {
	        if (curPage != k)
	            str += "<li><a onclick='loadPage(" + k + ")'>" + k + "</a></li>\n";
	        else
	            str += "<li><a class='active tooltip-top' title='현재페이지'>" + k + "</a></li>\n";
	    }
	}
	
	//■ > 표시
    if (totalPage > end_page){
    	str += "<li><a onclick='loadPage(" + (end_page + 1) + ")' class='tooltip-top' title='다음'><i class='fas fa-angle-right'></i></a></li>\n";
    }

	//■ >> 표시
    if (curPage < totalPage) {
        str += "<li><a onclick='loadPage(" + totalPage + ")' class='tooltip-top' title='맨끝'><i class='fas fa-angle-double-right'></i></a></li>\n";
    }

    return str;
} // end buildPagination
