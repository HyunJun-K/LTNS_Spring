<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--  csrf token 읽기 -->
<meta name="csrf-token" content="${_csrf.token}">
<title>관리자페이지</title>
</head>


<!-- jquery  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>



<!-- jQuery Modal -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />


<!-- google font -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">

<!--  fontawesome -->
<script src="https://kit.fontawesome.com/5ccafa9b7a.js" crossorigin="anonymous"></script> 



<!--  bootstrap -->
<link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<link href='${pageContext.request.contextPath }/admin/CSS/notice.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath }/admin/JS/notice.js'></script>
<body class="bg-light">


	<!-- dashboard nav -->
   <nav class="navbar navbar-dark  sticky-top bg-white flex-md-nowrap p-0 mt-0">
      <a class="navbar-brand bg-dark col-sm-3 col-md-2 mr-0" href="#">LTNS DashBoard</a> <!--  barnd 설정  -->
      
      <ul class="navbar-nav  d-flex flex-row-reverse  ">
      
        
          <li class="nav-item  mr-5">
          		<span class="font-weight-bold mt-2"  style="font-size: 14px;"> Hello Master </span> <br>
         		<span class="welcomes" style="font-size: 12px;"> ${id} </span>
         		
          </li>
          <li class="nav-item mr-3">
	          <div>
	          <img src="${pageContext.request.contextPath }/admin/img/1.PNG">
	          </div>
  	      </li>
			<li class="nav-item   mr-4 text-center">
			<a type ="button" class="nav-link text-dark" href="#"><i class="fas fa-bell"></i></a>
			</li>

			<li class="nav-item  mr-4 text-center">
			<a class="nav-link text-dark"  href="#ex1" rel="modal:open"><i class="fas fa-bell"></i></a>
			</li>
		</ul>
     
	 
    </nav> <!-- nav header 라인 -->

	<div class="container-fluid">
		<div class="row">
			<nav class="col-md-2 d-none d-md-block bg-dark sidebar">
				<div class="sidebar-sticky">
					<ul class="nav flex-column">
						
						<li class="nav-item "><a class="nav-link  text-white" href="${pageContext.request.contextPath}/admin/dashboard"> <span
								data-feather="shopping-cart"></span> <i class="fas fa-chart-line"></i>&nbsp;&nbsp; 메인
						</a></li>
						
						<li class="nav-item "><a class="nav-link text-white " href="${pageContext.request.contextPath}/admin/schedule"> <span
								data-feather="shopping-cart"></span>  <i class="far fa-calendar-check"></i>&nbsp;&nbsp; 일정
						</a></li>
						
						<li class="nav-item "><a class="nav-link text-white " href="${pageContext.request.contextPath}/admin/memberInfo"> <span
								data-feather="shopping-cart"></span> <i class="far fa-user-circle"></i> &nbsp;&nbsp;회원정보
						</a></li>
						<li class="nav-item "><a class="nav-link text-white " href="${pageContext.request.contextPath}/admin/postInfo"> <span
								data-feather="users"></span> <i class="fas fa-edit"></i>&nbsp;&nbsp;게시글 정보
						</a></li>
						<li class="nav-item"><a class="nav-link  bg-info text-white" href="${pageContext.request.contextPath}/admin/notice"> <span
								data-feather="bar-chart-2"></span> <i class="far fa-clipboard"></i>&nbsp;&nbsp; 공지사항
						</a></li>
					</ul>

				</div>
			</nav>
		</div><!-- sidebar 라인 -->
	
		 <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4 ">
			
			<div id="list" >
				<div class="d01 text-right font-lg">
					<div id="pageinfo"></div>
					<div id="pageRows"></div>
				</div>
				<div class="clear"></div>

				<form id="frmList" name="frmList">
					<table class="table table-hover text-center">
						<thead class="thead-success">
							<th>번호</th>
							<th>제목</th>
							<th>작성일</th>
							<th>작성자</th>
						</thead>
						<tbody>

						</tbody>
					</table>
				</form> 
				<div class="d-flex justify-content-end">
					<ul class="pagination " id="pagination">
					</ul>
				</div>
			</div> <!-- end list table -->
			
				
			<div class="clear"></div>
			
			
			
			<div class="viewList">
				<h1 class="viewTitle"> 공지사항입니다</h1>
				<hr>	
				<div>	
				<span class="viewNo">18</span>  <span class="text-right float-right" id="viewDate"></span> 
				<span id="viewId" class="float-right ml-4 mr-2"></span> 
				</div>
				<hr>
				<div class="viewContent">
				</div>
				<hr>
				
				<div class="text-right">
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/admin/notice'"> 취소 </button>
				<button > 수정 </button>
				</div>
			</div> <!-- viewList -->
			
<!-- 
			<form>
				<div class="input-group mb-3">
					<input type="text" class="form-control"
						placeholder="관리자 공지사항 제목 입니다.">
					<div class="input-group-append"></div>
				</div>

				<div class="form-group">
					<label for="exampleFormControlTextarea1"> 내용</label>
					<textarea class="form-control" id="textarea" name="content"
						rows="10"></textarea>
				</div>
			</form>
 -->
		</main> <!-- article -->
	</div> <!-- end con -->
</body>
</html>