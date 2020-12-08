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

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>


<!--  date picker  -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>



<link href='${pageContext.request.contextPath }/pakege/core/main.css' rel='stylesheet' />
<link href='${pageContext.request.contextPath }/pakege/daygrid/main.css' rel='stylesheet' />
<link href='${pageContext.request.contextPath }/pakege/timegrid/main.css' rel='stylesheet' />
<link href='${pageContext.request.contextPath }/pakege/list/main.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath }/pakege/core/main.js'></script>
<script src='${pageContext.request.contextPath }/pakege/interaction/main.js'></script>
<script src='${pageContext.request.contextPath }/pakege/daygrid/main.js'></script>
<script src='${pageContext.request.contextPath }/pakege/timegrid/main.js'></script>
<script src='${pageContext.request.contextPath }/pakege/list/main.js'></script>
 <link href='${pageContext.request.contextPath }/admin/CSS/schedule.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath }/admin/JS/schedule.js'></script>
   
<script>

  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list' ],
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
    	  
      
      {
    	  title : 'default',
    	  start : "2020-12-08",
    	  end :   "2020-12-08"
      }
      
      
      
      ]
    });

    calendar.render();
 });

  
  
  
  
  
  
</script>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 900px;
    margin: 0 auto;
  }
  
  .add-button{
  	position : absolute;
  	top: 0px;
  	left : 160px;
  	background : #2C3E50;
  	border : 0;
  	color : white;
  	height : 35px;
  	border-radius: 3px;
  	width : 100px;
  	
  } 

</style>
</head>
<body>

  <div id='calendar' style="position : relative;"> 
	  <div>
	  	<button class="add-button" type="button" onclick="click_add();"> 일정 추가 </button>
	  </div>
  </div>

</body>
</html>
