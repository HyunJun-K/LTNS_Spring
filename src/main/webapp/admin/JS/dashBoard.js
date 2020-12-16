
$(document).ready(function() {
    total_Acount();
    today_acount();
    today_post();
    Best()
 
})


//신고 게시물 팝업 
function POPUP_REPORT(){
    var url = "repostPopup";
    var name = "repostPopup";
    var option = "width = 800, height = 600 left = 200, top=150,location=no";
    window.open(url,name,option)
}



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
        $("#numbers_today").html( "<span class='text-info'>" + count + "</span>");
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
                    $("#today_post").html( "<span class='text-success'>" + data.count + "</span>");
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
                    
                    if(data.count <= 50){
                        $("#icons_report").html("<i class='far fa-smile text-success'></i>");
                    }else if(data.count <= 50  || data.count >= 100){
                        $("#icons_report").html("<i class='far fa-surprise text-warning'></i>");
                    }else if(data.count <= 100 ){
                        $("#icons_report").html("<i class='far fa-angry text-danger'></i>");
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
                    $("#today_coment").html("<span class='text-warning'>" + data.count +"  </span>");
                    $("#total_coment").html("<span> 총 댓글 수 " + data.totalCounts + "</span>");
                }
            }
        });
    }

    
    //호출
    today_coment();
    today_report();
    total_post();
}

function Best(){
    bestArea()
    bestFood()
    bestGas()
    totalLike()
    function bestArea(){
        $.ajax({
            url : "bestArea",
            type : "POST",
            cashe : false,
            success : function(data, status){
                if(data.status=="OK"){
                    var items = data.list;
                    $("#Best1").html( "<i class='far fa-hand-peace'></i> " +items[0].ra_name + "</span>");
                    $("#Best2").html( items[1].ra_name);
                    $("#Best3").html( items[2].ra_name);    
                    $("#recomend_area").html(" Best : " +  "<span class='text-info'>"+items[0].best_RA + "<span>" );
                }
            }

        });
    }

    function bestFood(){
        $.ajax({
            url : "bestFood",
            type : "POST",
            cashe : false,
            success : function(data, status){
                if(data.status=="OK"){
                    var items = data.list;
                
                    $("#Food_name").html( "<i class='far fa-hand-peace'></i> " +items[0].ra_name + "</span>");
                    $("#Food_price").html( " 가격: " +  items[0].fm_PRICE);
                    $("#Food_raea").html( items[0].fm_name);   
                    $("#recomend_food").html(" Best : " +  "<span class='text-success'>"+items[0].best_RA + "<span>" ); 
                    
                }
            }

        });
    }

    function bestGas(){
        $.ajax({
            url : "bestGas",
            type : "POST",
            cashe : false,
            success : function(data, status){
                if(data.status=="OK"){
                    var items = data.list;
                
                    $("#gas_name").html( "<i class='far fa-hand-peace'></i> " +items[0].gs_name + "</span>");
                    $("#gas_price").html( " 디젤 : " +  items[0].gs_DIESEL + "   휘발류 :" + items[0].gs_GASOLINE);
                    $("#gas_price_lpg").html(" LPG :" + items[0].gs_LPG )
                    $("#recomend_gas").html(" Best : " +  "<span class='text-danger'>"+items[0].best_RA + "<span>" ); 
                }
            }

        });
    }



    function totalLike(){
        $.ajax({
            url : "totalLike",
            type : "POST",
            cashe : false,
            success : function(data, status){
                if(data.status=="OK"){
                    var items = data.list;
                    var totaldata = items[0].ralike  + items[0].fmlike + items[0].gslike;
                   
                    $("#total_recomend").html( "<span class='text-warning'>"  + totaldata + "</span>") ;
                    $("#total_area").html( "휴게소  : " +  items[0].ralike );
                    $("#total_food").html(" 음식 :" + items[0].fmlike )
                    $("#total_gas").html(" 주유소 : "   +items[0].gslike  ); 
                }
            }

        });
    }

}