<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
    
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ltns.rest_area.domain.admin.*" %>

<%
	List<ScheduleDTO> list = (ArrayList<ScheduleDTO>) request.getAttribute("showSchedule");
%>
    
<html>
<head>
<meta charset='utf-8' />
<title>일정</title>

<!-- google font -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">


<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>


<!--  date picker  -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!--  bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">

<!-- 풀캘린더 패키지  -->
<link href='${pageContext.request.contextPath }/pakege/core/main.css' rel='stylesheet' />
<link href='${pageContext.request.contextPath }/pakege/daygrid/main.css' rel='stylesheet' />
<link href='${pageContext.request.contextPath }/pakege/timegrid/main.css' rel='stylesheet' />
<link href='${pageContext.request.contextPath }/pakege/list/main.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath }/pakege/core/main.js'></script>
<script src='${pageContext.request.contextPath }/pakege/interaction/main.js'></script>
<script src='${pageContext.request.contextPath }/pakege/daygrid/main.js'></script>
<script src='${pageContext.request.contextPath }/pakege/timegrid/main.js'></script>
<script src='${pageContext.request.contextPath }/pakege/list/main.js'></script>

<!-- css & js -->
<link href='${pageContext.request.contextPath }/admin/CSS/schedule.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath }/admin/JS/schedule.js'></script>
   
<script>

  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid',  'list' ],
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
      },
      navLinks: true, // can click day/week names to navigate views
      businessHours: true, // display business hours
      editable: true,
      locale: "ko",
      events: [
    	  
<%
	  	for(int i =0; i< list.size(); i++ ){
    	  		ScheduleDTO dto = (ScheduleDTO)list.get(i);
    	  	
    	  
    	  
%>
    	      {
    		  title : '<%=dto.getSubject() %>',
        	  start :  '<%=dto.getStartDate() %>',
        	  end :   '<%=dto.getEndDate() %>'
    		  },
    	  
    	  
<%
    }
%>
    	  
      
      ]
    });

    calendar.render();
 });

  
  
  
  
  
  
</script>
<style>
.fc-center, table,
.fc-content{
	font-family: 'Do Hyeon', sans-serif;
}

</style>
</head>
<body>


	<!-- dashboard nav -->
   <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 mt-0">
      <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">LTNS DashBoard</a>
      <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
          	<span>help</span>
          	<span calss="font-white">date</span>
        </li>
      </ul>
    </nav>

 <div class="container-fluid">
      <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
          <div class="sidebar-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <a class="nav-link " href="${pageContext.request.contextPath}/admin/dashboard">
                  Dashboard 
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link active" href="${pageContext.request.contextPath}/admin/schedule">
                  	일정  
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/memberInfo">
                  <span data-feather="shopping-cart"></span>
                  	회원정보
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/postInfo">
                  <span data-feather="users"></span>
                   	게시글 정보
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="bar-chart-2"></span>
                  Reports
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  <span data-feather="layers"></span>
                  Integrations
                </a>
              </li>
            </ul>

          </div>
        </nav>
     </div>
</div>







	<!-- 캘린더  -->

  <div class="mt-4" id='calendar' style="position : relative;"> 
	  <div>
	  	<button class="add-button" type="button" onclick="click_add();">  추가 </button>
	  	<button class="delete-button" type="button" onclick="click_delete();"> 삭제 </button>
	 	<button class="update-button" type="button" onclick="click_update();"> 수정</button>
	  </div>
  </div>

</body>
</html>
