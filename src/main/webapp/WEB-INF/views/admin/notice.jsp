<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
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

<!--  chart.js CDN -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>


<!--  bootstrap -->
<link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">


<link href='${pageContext.request.contextPath }/admin/CSS/dashBoard.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath }/admin/JS/dashBoard.js'></script>

<body class="bg-light">


	<!-- dashboard nav -->
   <nav class="navbar navbar-dark  sticky-top bg-white flex-md-nowrap p-0 mt-0">
      <a class="navbar-brand bg-dark col-sm-3 col-md-2 mr-0" href="#">LTNS DashBoard</a> <!--  barnd 설정  -->
      
      <ul class="navbar-nav  d-flex flex-row-reverse  ">
      
        
          <li class="nav-item  mr-5">
          		<span class="font-weight-bold mt-2"  style="font-size: 14px;"> Hello Master </span> <br>
         		<span class="welcomes" style="font-size: 12px;"> HyunJun </span>
         		
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



		
		</main> <!-- article -->
	</div> <!-- end con -->

</body>
</html>