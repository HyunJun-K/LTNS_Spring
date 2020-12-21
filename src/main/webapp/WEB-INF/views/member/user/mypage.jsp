<%@page import="com.ltns.rest_area.domain.user.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/CSS/user/mypage.css" />
    <title>MyPage</title>
  </head>
   <div class="container">
      <div class="box">
        <ul class="list-group">
          <li class="list-group-item active text-center" aria-current="true">
            ★ 휴게소
          </li>
          <div id="likeRest">
          </div>
        </ul>
        <ul class="list-group">
          <li class="list-group-item active text-center" aria-current="true">
            ★ 음식
          </li>
         <div id="likeFood">
          </div>
        </ul>
        <ul class="list-group">
          <li class="list-group-item active text-center" aria-current="true">
            ★ 주유소
          </li>
           <div id="likeGas">
          </div>
        </ul>
      </div>
      <div class="box mt-5">
        <ul class="list-group">
          <li class="list-group-item active text-center" aria-current="true">
            ★ 게시글
          </li>
           <div id="likePost">
          </div>
        </ul>
        <ul class="list-group">
          <li class="list-group-item active text-center" aria-current="true">
            내가 쓴 글
          </li>
          <div id="posts">
          </div>
        </ul>
        <ul class="list-group">
          <li class="list-group-item active text-center" aria-current="true">
            내가 쓴 덧글
          </li>
           <div id="comments">
          </div>
        </ul>
      </div>
    </div>
    <form class="hidden hide" id="mypageForm">
    <input type="hidden" id="um_uid" name="um_uid" value='<%=((UserDTO) request.getSession().getAttribute("userObj")).getUm_uid() %>'/>
      <input type="hidden" id="message" name="message" value="findByUid" />
      <input
        type="hidden"
        name="${_csrf.parameterName}"
        value="${_csrf.token}"
      />
    </form>
    <script src="<%=request.getContextPath() %>/resources/JS/user/mypage.js"></script>
  </body>
</html>
