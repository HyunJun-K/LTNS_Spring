
$(document).ready(function() {

})




function total_Acount(){

    $.ajax({
        url : "total_Acount",
        type : "POST",
        success : function(data,status){
            if(data.status == "OK"){
                totaldata(data);
            }
        }
    });


    function totaldata(JsonObj){
        $("#numbers_acount").text("hhhh");

    }

    

}
