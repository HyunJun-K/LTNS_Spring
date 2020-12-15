<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>

<!--  fontawesome -->
<script src="https://kit.fontawesome.com/5ccafa9b7a.js" crossorigin="anonymous"></script> 

<!--  chart.js CDN -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>


<!-- jquery  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<!--  bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">

<link href='${pageContext.request.contextPath }/admin/CSS/dashBoard.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath }/admin/JS/dashBoard.js'></script>

<body>
	<!-- dashboard nav -->
   <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 mt-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">LTNS DashBoard</a>
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          	<span>help</span>
          	<span class="font-white">date</span>
        </li>
      </ul>
    </nav> <!-- nav header 라인 -->

	<div class="container-fluid">
		<div class="row">
			<nav class="col-md-2 d-none d-md-block bg-light sidebar">
				<div class="sidebar-sticky">
					<ul class="nav flex-column">
						
						<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/admin/dashboard"> <span
								data-feather="shopping-cart"></span> <i class="fas fa-chart-line"></i>&nbsp;&nbsp; 메인
						</a></li>
						
						<li class="nav-item"><a class="nav-link " href="${pageContext.request.contextPath}/admin/schedule"> <span
								data-feather="shopping-cart"></span>  <i class="far fa-calendar-check"></i>&nbsp;&nbsp; 일정
						</a></li>
						
						<li class="nav-item"><a class="nav-link " href="${pageContext.request.contextPath}/admin/memberInfo"> <span
								data-feather="shopping-cart"></span> <i class="far fa-user-circle"></i> &nbsp;&nbsp;회원정보
						</a></li>
						<li class="nav-item"><a class="nav-link " href="${pageContext.request.contextPath}/admin/postInfo"> <span
								data-feather="users"></span> <i class="fas fa-edit"></i>&nbsp;&nbsp;게시글 정보
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="bar-chart-2"></span> Reports
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="layers"></span> Integrations
						</a></li>
					</ul>

				</div>
			</nav>
		</div><!-- sidebar 라인 -->

		<!-- section 1  -->
		<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
	<div class="row">
	  <div class="col-sm-3">
	    <div class="card text-center">
	      <div class="card-body">
	        <h5 class="card-title">오늘 가입한 유저수</h5>
	        <p id="numbers_today" class="card-title"> </p>
	        <span id="numbers_acount" class="card-body"></span>
	     	</div>
	    </div>
	  </div>
	  
	  
	  <div class="col-sm-3">
	    <div class="card text-center">
	      <div class="card-body">
	        <h5 class="card-title">오늘 작성된 게시글 수</h5>
	        <p id="today_post" class="card-title"> </p>
	        <span id="total_post" class="card-body"></span>
	      </div>
	    </div>
	  </div>
	  
	  <div class="col-sm-3">
	    <div class="card text-center">
	      <div class="card-body">
	        <h5 class="card-title">오늘 신고된 게시글 수</h5>
	         <p id="today_reports_post" class="card-title"> </p>
	         <span>신고된 게시물 갯수</span>
	      </div>
	    </div>
	  </div>
	  
	  <div class="col-sm-3">
	    <div class="card">
	      <div class="card-body">
	        <h5 class="card-title">Special title treatment</h5>
	        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
	        
	      </div>
	    </div>
	  </div>
	  
	</div> <!-- card row -->
		
		</main> <!-- article -->



	</div> <!-- end con -->
</body>
</html>