<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
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
						
						<li class="nav-item "><a class="nav-link bg-info text-white" href="${pageContext.request.contextPath}/admin/dashboard"> <span
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
						<li class="nav-item"><a class="nav-link text-white" href="#"> <span
								data-feather="bar-chart-2"></span> 공지사항
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="layers"></span> Integrations
						</a></li>
					</ul>

				</div>
			</nav>
		</div><!-- sidebar 라인 -->

	
		
		
 <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4 ">
	<div id="ex1" class="modal">

				<form>
					<div class="form-group mt-2">
						<label for="exampleInputEmail1">Email</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							aria-describedby="emailHelp" placeholder="Enter email"> <small
							id="emailHelp" class="form-text text-muted">
							메일을 보낼때에는 신중하게 보냅시다.</small>
					</div>
					
					<div class="form-group mt-2">
						<label for="mailTitle">Title</label>
						 <input type="text" class="form-control" id="mailTitle"
							placeholder="Enter title"> 
					</div>
					
					
					<div class="form-group">
						<label for="exampleFormControlTextarea1">Example textarea</label>
						<textarea class="form-control" id="emailText"
							rows="5"></textarea>
					</div>


					<div class="text-right">
						<button type="button" onclick="message_hello();">안부 인사 </button>
						<button type="button" onclick="message_report();">신고 안내</button>
							
						
						<button type="submit" class="btn btn-primary">Submit</button>
						<button class="btn btn-primary"  onclick="close_modal();" >close</button>
					</div>
				</form>



	</div> <!--  end modal -->
	 
 
 
 
 
 
	<!-- 일일 정산   -->
	<div id="rowsdata" class="row">
	
	  <div class="col-sm-3">
	    <div class="card text-center">
	      <div class="card-body border border-info">
	        <h3 class="text-info"> 오늘 가입한 유저 </h3>
	        <p id="numbers_today" class="card-title"> </p>
	        <span id="numbers_acount" class="card-body"></span>
	     	</div>
	    </div>
	  </div>
	  
	  
	  <div class="col-sm-3">
	    <div class="card text-center">
	      <div class="card-body border border-success">
	        <h3 class="text-success">오늘 작성된 게시글 </h3>
	        <p id="today_post" class="card-title"> </p>
	        <span id="total_post" class="card-body"></span>
	      </div>
	    </div>
	  </div>
	  
	  <div class="col-sm-3">
	    <div class="card text-center">
	      <div class="card-body border border-danger">
	        <h3 class="text-danger">오늘 신고된 게시글 </h3>
	          <p id="icons_report" class="card-title"></p>
	         <span id="today_reports_post" class="card-body"> </span>
	      </div>
	    </div>
	  </div>
	  
	  <div class="col-sm-3">
	    <div class="card text-center">
	      <div class="card-body border border-warning">
	        <h3 class="text-warning" >오늘 작성된  댓글 </h3>
	       <p id="today_coment" class="card-title"> </p>
	        <span id="total_coment" class="card-body "></span>
	      </div>
	    </div>
	  </div>
	</div> <!-- end card row section 1 -->
	<hr>
	
	<!-- section2 -->
	<div id="rowsdata" class="row">
	  <div class="col-sm-3">
	    <div class="card text-center ">
	      <div class="card-body border border-info">
	        <h3 class="text-info">   BEST 휴게소 </h3>
	        <p id="Best1" class="card-title2"> </p>
	        <span id="Best2" class="card-body text-center"> </span> <br>
	     	<span id="Best3" class="card-body text-center">  </span> <br>
	        <span id="recomend_area" class="card-body text-center">  </span>
	     
	     	</div>
	    </div>
	  </div>
	  
	  
	  <div class="col-sm-3">
	    <div class="card text-center">
	      <div class="card-body border border-success">
	        <h3 class="text-success">  BEST 메뉴 </h3>
	     <p id="Food_name" class="card-title2"> </p>
	        <span id="Food_price" class="card-body text-center"> </span> <br>
	     	<span id="Food_raea" class="card-body text-center">  </span> <br>
	        <span id="recomend_food" class="card-body text-center">  </span>
	    
	      </div>
	    </div>
	  </div>
	  
	  <div class="col-sm-3">
	    <div class="card text-center">
	      <div class="card-body border border-danger">
	        <h3 class="text-danger">  BEST 주유소</h3>
	     	 <p id="gas_name" class="card-title2"> </p>
	        <span id="gas_price" class="card-body text-center"> </span> <br>
	        <span id="gas_price_lpg" class="card-body text-center"> </span> <br> 
	         <span id="recomend_gas" class="card-body text-center">  </span>
	     </div>
	    </div>
	  </div>
	  
	  <div class="col-sm-3 ">
	    <div class="card text-center">
	      <div class="card-body border border-warning">
	        <h3 class="text-warning">전체 추천 개수</h3>
	        <p id="total_recomend" class="card-title"> </p>
	        <span id="total_area" class="card-body"></span> <br>
	        <span id="total_food" class="card-body"></span> <br>
	        <span id="total_gas" class="card-body"></span>
	      </div>
	    </div>
	  </div>
	</div> <!-- end card row section 2 -->
	<div class="clear"></div>
	<hr>
		
		
		
		<div class= "d-inline-block justify-content-start mr-4 ml-2" >
		<canvas id="myChart" width="550" height="300" ></canvas>
		</div>
		
		
		<div class= "d-inline-block justify-content-start mr-4 ml-2" >
		<canvas id="memberListAdd" width="550" height="300" ></canvas>
		</div>
		



		
		</main> <!-- article -->
	</div> <!-- end con -->

</body>
</html>