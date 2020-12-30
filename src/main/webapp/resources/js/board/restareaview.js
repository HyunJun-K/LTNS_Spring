/*fm 펼치기 버튼 토글*/
function fmbox_toggle(){
    if($('#fmbox>button').html()=='펼치기'){
        $('#inner_fmbox').css('max-height','');
		$('#fmbox>button').html('접기')
    }else{
		$('#inner_fmbox').css('max-height','300px');
		$('#fmbox>button').html('펼치기')
    }
}

/*closeModal 버튼 */
function closeModal(){
	$.when($('#fmbox>button').html('접기')).done(function(){fmbox_toggle();});
	
	$('#restareaview').hide();
}

/*팝업*/
function setPopup(ra_code){
	
    //ra_code로 리스트를 ajax로 받아, 파싱, 리스트로 모달로 띄워준다
    $.ajax({
        url:BASE_URL+"/board/"+ra_code,
        type:"GET",
        cache:false,
        success:function(data,status){
            if(status=="success"){
                setView(data);
            }
        }

    })

    
}

function setView(jsonObj){
    rabox_str='<h1>'+jsonObj.obj.raDTO.ra_name+'</h1>'+
    '<p>노선 : '+jsonObj.obj.raDTO.ra_routeName+
    ' <br>방향 : '+jsonObj.obj.raDTO.ra_destination+
    ' <br>위치(경도,위도) : '+jsonObj.obj.raDTO.ra_xValue+', '+jsonObj.obj.raDTO.ra_yValue+
    '</p>';
    
    gsbox_str='';
    row=jsonObj.obj.gsDTOs;
    for(i=0;i<row.length;i++){
        gsbox_str+='<h4>'+row[i].gs_name+'</h4>'+
    '    <p>휘발유 가격 : '+row[i].gs_gasoline+
    '       <br>경유 가격 : '+row[i].gs_diesel+
    '       <br>LPG 가격 : '+row[i].gs_lpg+
    '    </p>';
    }
    
    fmbox_str='';
    row=jsonObj.obj.fmDTOs;
    for(i=0;i<row.length;i++){
        fmbox_str+='<li>'+
    '    <p>'+row[i].fm_name+'</p>'+
    '    <p>소비자가 : '+row[i].fm_price+'원'+
    '    <br>재료 : '+row[i].fm_material+
    '    <br>'+row[i].fm_etc+'</p>'+
    '</li><br>';
    }
	$('#ra_code').html(jsonObj.obj.raDTO.ra_code);
    $('#rabox').html(rabox_str);
    $('#gsbox').html(gsbox_str);
    $('#fmbox ul').html(fmbox_str);

    setPostboard(jsonObj.obj.postDTOs);
	
	place={x:jsonObj.obj.raDTO.ra_xValue,y:jsonObj.obj.raDTO.ra_yValue,place_name:jsonObj.obj.raDTO.ra_name};
	
	$('#restareaview').show();
	kakaoMap(place.y,place.x);
	displayMarker(place);
	panTo(place);
}

/* 카카오 맵 */
var kakao_map=null;

//지도 생성
function kakaoMap(yValue,xValue){
	var container = document.getElementById('kakao_map');
	var options = {
		center: new kakao.maps.LatLng(yValue,xValue),
		level: 5
	};
	if(kakao_map==null){
		kakao_map=new kakao.maps.Map(container, options);
	}
}


// 지도에 마커를 표시하는 함수입니다
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시합니다
    var marker = new kakao.maps.Marker({
        map: kakao_map,
        position: new kakao.maps.LatLng(place.y, place.x)
    });

    // 마커에 클릭이벤트를 등록합니다
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(kakao_map, marker);
    });
}

function panTo(place) {
	kakao_map.setLevel(5);
    // 이동할 위도 경도 위치를 생성합니다  
    let moveLatLon = new kakao.maps.LatLng(place.y, place.x);
    
    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    kakao_map.panTo(moveLatLon);          
}       