<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<script src="${pageContext.request.contextPath }/resources/js/board/restareaview.js"></script>

<div id="restareaview" class="modal">
    <div class="modal-content animate">
        <div id="rabox">

        </div>
        <div id="gsbox">

        </div>
        <div id="fmbox">

        </div>
        <jsp:include page="./postboard.jsp"/>
    </div>
</div>
