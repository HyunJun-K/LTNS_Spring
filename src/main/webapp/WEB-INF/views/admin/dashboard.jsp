<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>

<!-- jquery  -->

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>

<!--  chart.js CDN -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

<!--  bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">

<!--  font awsome -->
<script src="https://kit.fontawesome.com/bb29575d31.js"></script>

<link href='${pageContext.request.contextPath }/admin/CSS/admin.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath }/admin/JS/admin.js'></script>

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
						<li class="nav-item"><a class="nav-link active"
							href="${pageContext.request.contextPath}/admin/dashboard">
								Dashboard </a></li>
						<li class="nav-item"><a class="nav-link "
							href="${pageContext.request.contextPath}/admin/schedule"> 일정
						</a></li>
						<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/memberInfo"> <span
								data-feather="shopping-cart"></span> 회원정보
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="users"></span> Customers
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



		<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

		<canvas id="myChart" width="200" height="200"></canvas>

		</main>




	</div> <!-- end con -->
	
	
	



</body>
</html>