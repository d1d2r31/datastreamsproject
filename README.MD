(게시판 접속주소)
http://192.168.2.179:8080/     

security ( id : admin   , pw : 1234 )
	 ( id : manager , pw : 1234 )
	 ( id : user    , pw : 1234 )


- MVC 기반 ( view - > controller - > service - > dao - > daoimpl -> oracle 
- 비동기 방식 (AJAX) 로 구현
- 작성자와 접속한 정보와 맞지 않으면 해당글 수정,삭제 방지
- WebSocket 을 이용하여 채팅방 구현
- @Validate 를 이용한 유효성 검사 (server 단에서)
- 새로운 글 알림 구현
- maven을 이용해 라이브러리 다운
- gradle 프로젝트도 생성함
- 한글 인코딩 처리 //(web.xml 에 설정)
- mabatis (디펜던시 추가 , mapper 파일을 이용해 쿼리 작성) 를 사용하여 DB연결
- Json 형식으로 데이터를 view~server 주고받음 
- HttpSession 을 이용하여 로그인 상태 유지
- Spring Security 사용하여 보안 구현
- 예외발생시 DB 저장 방지를 위해 트랜젝션 구현
- AOP를 사용하여 공통기능(로깅) 구현 ( 프록시를 사용)
- JSTL 을 사용하여 소스 간결화
- 페이징 처리 
