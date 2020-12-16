
$(document).ready(function() {
    total_Acount();
    today_acount();
    today_post();
 
})



//일일 토탈 ajax 
function total_Acount(){

    $.ajax({
        url : "total_Acount",
        type : "POST",
        cashe : false,
        success : function(data,status){
            if(data.status == "OK"){
                totaldata(data)
            }
        }
    });

    function totaldata(JsonObj){
        var count = JsonObj.count;
        $("#numbers_acount").text("총 회원수 " + count  + " 명");

    }
}

function today_acount(){
    $.ajax({
        url : "today_acount",
        type : "POST",
        cashe : false,
        success : function(data,status){
            if(data.status == "OK"){
                today_acounts(data)
            }
        }
    });

    function today_acounts(JsonObj){
        var count = JsonObj.count;
        $("#numbers_today").text(count  + " 명");
    }
}


function today_post(){
    $.ajax({
        url : "today_post",
        type : "POST",
        cashe : false,
        success : function(data, status){
            if(data.status == "OK"){
                if(data.count == 0){
                    $("#today_post").text(0 + " 개");
                }else{
                    $("#today_post").text(data.count + " 개");
                }
            }
        }

    });

    
    function  total_post(){
        $.ajax({
            url : "total_post",
            type : "POST",
            cashe : false,
            success : function(data,status){
                if(data.status=="OK"){
                    $("#total_post").text("총 게시글 수 " + data.count);
                }
            }
        })
    }

    function today_report(){
        $.ajax({
            url : "today_report",
            type : "POST",
            cashe : false,
            success : function(data,status){
                if(data.status=="OK"){
                    $("#today_reports_post").html("<span id='reports_span' onclick='POPUP_REPORT();'>"  + data.count + " 개 </span>");
                    
                    if(data.count >= 50){
                        $("#icons_report").html("<i class='far fa-smile'></i>");
                    }else if(data.count <= 50  || data.count >= 100){
                        $("#icons_report").html("<i class='far fa-surprise'></i>");
                    }else if(data.count <= 100 ){
                        $("#icons_report").html("<i class='far fa-angry'></i>");
                    }
                
                
                }
            }

        })
    }


    function today_coment(){
        //오늘달린 댓글 개수 요청
        $.ajax({
            url : "today_coment",
            type : "POST",
            cashe : false,
            success : function(data,status){
                if(data.status=="OK"){
                    $("#today_coment").html("<span>" + data.count +" 개 </span>");
                    $("#total_coment").html("<span>" + data.totalCounts +" 개 </span>");
                }
            }
        });
    }

    
    //호출
    today_coment();
    today_report();
    total_post();
}


//신고 게시물 팝업 
function POPUP_REPORT(){
    var url = "repostPopup";
    var name = "repostPopup";
    var option = "width = 800, height = 600 left = 200, top=150,location=no";
    window.open(url,name,option)
}
