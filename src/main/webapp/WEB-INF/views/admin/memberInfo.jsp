<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원 정보</title>
</head>

<!--  chart.js CDN -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>


<!-- jquery  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<!--  bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">

<link href='${pageContext.request.contextPath }/admin/CSS/memberInfo.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath }/admin/JS/memberInfo.js'></script>

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
						<li class="nav-item"><a class="nav-link "
							href="${pageContext.request.contextPath}/admin/dashboard">
								Dashboard </a></li>
						<li class="nav-item"><a class="nav-link "
							href="${pageContext.request.contextPath}/admin/schedule"> 일정
						</a></li>
						<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/admin/memberInfo"> <span
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

		<!-- section 1  -->
		<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

			<div id="list" >
				<div class="d01 text-right font-lg">
					<div id="pageinfo"></div>
					<div id="pageRows"></div>
				</div>
				<div class="clear"></div>

				<form id="frmList" name="frmList">
					<table>
						<thead>
							<th>UID</th>
							<th>UID</th>
							<th>아이디</th>
							<th>닉네임</th>
							<th>가입일</th>
							<th>신고횟수</th>
						</thead>
						<tbody>

						</tbody>
					</table>
				</form> 
			</div> <!-- end list table -->
	<%--페이징 --%>
		<br>
		
				<div class="d-flex justify-content-center">
					<form name="sechForm" id="sechForm">
					<select id="sele_option"class="mr-2">
						<option  value="id" selected> 아이디 </option>
						<option value="nickName"> 닉네임 </option>
						<option value="regdate"> 가입일 </option>
					</select>
					<input id="text_info" type="text" name="text_Info">
					<button type="button" class="ml-2" onclick="addSerch();"> 검색 </button>
				  </form>
				</div>
		
				<div class="d-flex justify-content-end">
					<ul class="pagination " id="pagination">
					</ul>
				</div>
				
		
			<div class="clear"></div>


		</main> <!-- article -->



	</div> <!-- end con -->
</body>