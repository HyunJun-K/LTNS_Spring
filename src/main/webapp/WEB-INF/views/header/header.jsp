<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- css -->
<link href='${pageContext.request.contextPath }/resources/css/header.css' rel="stylesheet"/>

<header>
	<nav id="search" class="navbar navbar-default">
		<div class="container-fluid">
			<!-- 내용 -->
	   		<div id="usernav" class="right">
	   			<p class="undisplay">um_uid</p>
	   			<a id="header_um_username" class="undisplay" href="#">um_username</a>
	   			<a class="" href="#">로그인</a>
	   			<a class="undisplay" href="#">로그아웃</a>
	   			<a class="undisplay" href="#">관리</a>
	   		</div>
			
			<!-- 로고 -->
			<div id="headerlogo" class="navbar-header">
		      <a class="navbar-brand" href="/rest_area/rest_area/front">
		        <img alt="Brand" src="${pageContext.request.contextPath }/resources/img/logo.png">
		      </a>
	   		</div>
	   		
		</div>
	</nav>
</header>

<!-- js -->
<script src='${pageContext.request.contextPath }/resources/js/header.js'></script>

