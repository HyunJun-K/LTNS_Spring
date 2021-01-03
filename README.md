# 휴게소 정보제공 커뮤니티 서비스 
---
## 김현준 
### 관리자 페이지 제작 
  - 사용 기술 : Ajax, MyBatis, Rest APi, SPA 
  - 개발 도구 : Fullcalendar.js , Jquery DetePicker, Jquery Modal, Jquery, Bootstrap4, MyBatis, chart.js,  kakao Map API, Ck Editer4, Gmail SMTP service 
                Eclips, Apache Tomcat v9.0, Spring, CSS, VSC, Spring security, Spring jdbc, lombock           
---
### 관리자 페이지 시연 화면 
- Main Dash Board ( 메인 통계 )
- Aajx 요청을 보낸 뒤에 RestPul APi, Mybatis를 이용하여 정보를 받은뒤 Retrun 된 Json list를 데이터 시각화를 하기 위해
- Chart.js를 통해 차트를 그려주거나, Bootstrap Card를 이용하여 정리
![메인](https://user-images.githubusercontent.com/54566087/103480590-86a3de80-4e18-11eb-99ce-e062ada4a3ea.gif)
---
- Date ( 일정 관리 )
- Fullcalendar.js를 이용하여 달력을 불러온 뒤에 DatePick ui와 sqlSession을 이용하여 
- 일정을 추가 삭제 수정을 할 수 있는 일정관리 기능을 완성
![일정](https://user-images.githubusercontent.com/54566087/103480632-b3f08c80-4e18-11eb-9753-b8e3565b3fe1.gif)
---
- Member ( 유저 관리 ) 
- data- 함수를 이용한 Modal 데이터 관리 SMTP를 이용한 메일 서비스
- Chart.js를 이용한 데이터 시각화, 페이지 네이션 및 유저 검색 기능 
![유저관리](https://user-images.githubusercontent.com/54566087/103480715-38430f80-4e19-11eb-85df-f437e0b1a26f.gif)
---
- Post ( 게시물 관리 ) 
- check-box를 이용한 여러 데이터 삭제 및 주간 통계 및 Chart.js를 이용한 데이터 시각화
- 페이지 네이션 및 게시물 검색 기능
![게시물관리](https://user-images.githubusercontent.com/54566087/103480763-8526e600-4e19-11eb-978d-87e24d4bf70b.gif)
--- 
- Notice ( 관리자 공지사항 ) 
- Jquery 모달을 이용한 안내문, JAVA File과 Buffer를 이용한 파일 데이터 저장 
- CK Editer를 이용한 에디터 사용 게시글 작성시 Ajax를 이용한 데이터 전달 
![관리자공지사항](https://user-images.githubusercontent.com/54566087/103480815-dd5de800-4e19-11eb-99e2-e698923eb6d5.gif)
--- 
- Info ( 휴게소 정보 ) 
- kakao Map APi를 이용한 지도 띄우기, Title을 기준으로 정보 나누기 ( SPA ) 
- 페이지 네이션 및 데이터 검색기능
![Info](https://user-images.githubusercontent.com/54566087/103480836-172eee80-4e1a-11eb-8f88-2d7ac49e7d13.gif)


