<%@page import="com.ltns.rest_area.domain.user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/CSS/user/list.css" />
<title>내가 작성한 글</title>
</head>
<body class="container">
	<div class="table">
		<form id="listForm">
			<input type="hidden" id="uid" name="um_uid"
				value="<%=((UserDTO) request.getSession().getAttribute("userObj")).getUm_uid()%>" />
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th class="text-center table__no">번호</th>
						<th class="text-center table__title">제목</th>
						<th class="text-center table__user">글쓴이</th>
						<th class="text-center table__date">작성일</th>
					</tr>
				</thead>
				<tbody id="jsonList">
				</tbody>
			</table>
			<input type="hidden" id="message" name="message" value="gs_like" />
			<input type="hidden" id="token" name="${_csrf.parameterName }"
				value="${_csrf.token }" />
		</form>
		<button id="removeBtn" class="btn btn-success float-right">삭제</button>
	</div>
	<div class="center">
		<ul class="pagination" id="pagination">
		</ul>
	</div>
	<script src="<%=request.getContextPath()%>/resources/JS/user/posts.js"></script>
</body>
</html>