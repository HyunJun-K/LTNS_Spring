<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 삭제</title>

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>

<!--  date picker  -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link href='${pageContext.request.contextPath }/admin/CSS/schedule.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath }/admin/JS/schedule.js'></script>

</head>
<body>

<div class="group" id="popupGroup">
	
	<div class="group-head">
		<h1 class="zTree-h1"> 삭제 하실 일정의 제목을 입력하세요 </h1>
	</div> <!--  end head -->
	
	<div class ="group-body">
		<form id="deleteForm">
			 <div class="top">
				<input class="subject" id="subject" type="text" name="subject" placeholder="제목 입력해주세요">
			 </div>
		
		</form>
		
		<button class="ok-button" type="button" onclick="delete_ok();"> 확인 </button>
		
	</div> <!--  end body  -->

</div> <!-- end group  -->


</body>
</html>