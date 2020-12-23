<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<script src="${pageContext.request.contextPath }/resources/js/board/postboard.js"></script>

<div id="postboard">
    <div class="d01">
        <div class="rigtht">
            <button type="button" id="btnWrite" class="btn success">글작성</button>
        </div>
    </div>
    <div class="clear"></div>
    <form id="frmlist" name="frmlist">
        <table>
            <thead>
                <th class="ra_code undisplay">ra_code</th>
                <th class="post_id undisplay">post_id</th>
                <th class="post_title">제목</th>
                <th class="um_username">작성자</th>
                <th class="post_like_cnt">추천</th>
                <th class="post_regdate">작성일</th>
                <th class="post_reported">신고</th>
            </thead>
            <tbody>
                <tr id="posthead_'${post_id}'">
                    <th class="ra_code undisplay">${ra_code}</th>
                    <th class="post_id undisplay">${post_id}</th>
                    <th class="post_title">제목</th>
                    <th class="um_username">작성자</th>
                    <th class="post_like_cnt">좋아요 수</th>
                    <th class="post_regdate">작성일</th>
                    <th class="post_reported">신고 버튼과 그 안의 이미지..</th>
                </tr>
                <!--posthead 클릭시 js로 postbody를 집어넣어주기 내용 확장-->
                <tr class="postbody">
                    <div class="post_content">
                        ${post_content}
                    </div>
                    <button id="post_updatebtn" class="btn info">수정</button>
                    <button id="post_deletebtn" class="btn danger">삭제</button>
                </tr>

            </tbody>
        </table>
    </form>
    <div class="d01">
        <div class="rigtht">
            <button type="button" id="btnWrite" class="btn success">글작성</button>
        </div>
    </div>
    <div class="clear"></div>
    <div class="center">
        <ul class="pagination" id="pagination">
        </ul>
    </div>

</div>

