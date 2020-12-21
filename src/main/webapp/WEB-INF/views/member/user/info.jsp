<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/CSS/user/info.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/CSS/user/logout.css" />
<title>회원 정보 수정</title>
</head>
<body>
	<div class="container">
		<form id="modiyfyForm"
			action="${pageContext.request.contextPath }/member/user/modify">
			<table class="table table-hover table-bordered">
				<thead>
					<th colspan="3" class="text-center">나의 정보</th>
				</thead>
				<tbody>
					<tr>
						<th>아이디 (이메일)</th>
						<td colspan="2">${userObj.um_username }</td>
						<input type="hidden" id="um_username" name="um_username"
							value="${userObj.um_username }" />
					</tr>
					<tr>
						<th>비밀번호 변경</th>
						<td colspan="2"><input type="password" class="form-control"
							id="um_password" name="um_password" /></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td colspan="2"><input class="form-control" type="password"
							id="passwordCheck" name="passwordCheck" /></td>
					</tr>
					<tr>
						<td colspan="3" id="password" class="error text-center hide"></td>
					</tr>
					<tr>
						<th>닉네임</th>
						<td><input class="form-control" id="um_nickname"
							name="um_nickname" value="${userObj.um_nickname }" disabled /></td>
						<td class="text-center"><button id="nickBtn"
								type="button" class="btn btn-primary">변경</button></td>
					</tr>
					<tr>
						<td colspan="3" id="nickname" class="error text-center hide"></td>
					</tr>
					<tr>
						<th>가입일</th>
						<td colspan="2">${userObj.um_regdate }</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" id="message" name="message" /> <input
				type="hidden" id="token" name="${_csrf.parameterName }"
				value="${_csrf.token }" />
		</form>
		<button id="changeBtn" class="btn btn-primary form-control">회원
			정보 변경</button>
		<button id="deleteBtn" class="btn btn-danger form-control mt-2">회원
			탈퇴</button>
	</div>
	<div id="logout"></div>
	<script type="module"
		src="${pageContext.request.contextPath }/resources/JS/user/info.js"></script>
	<script type="module"
		src="${pageContext.request.contextPath }/resources/JS/user/logout.js"></script>
</body>
</html>
