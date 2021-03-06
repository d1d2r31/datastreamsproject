﻿1. Ajax로 간단한 게시판 구현
	- MVC 기반 ( view - > controller - > service - > dao - > daoimpl -> oracle db

	- maven을 이용해 라이브러리 다운
	
	- mabatis(디펜던시 추가 , mapper 파일을 이용해 쿼리 작성 
			<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
				<property name="dataSource" ref="dataSource" />
				<property name="typeAliasesPackage" value="com.datastreams.project.vo"/>                     //vo클래스를 사용하기위해 vo패키지 등록
				<property name="mapperLocations" value="classpath*:com/datastreams/project/mapper/*.xml" />  //mapper 설정파일 등록
			</bean>

	- <context:component-scan base-package="com.datastreams.project.controller" /> //스프링 파일 스캐닝을 위해 설정

	- 한글 인코딩 처리 //(web.xml 에 설정)

	- DI @Autowired //(어노테이션 기반)

	- @Controller , @Service , @Component , @Repository 

	- @RequestMapping(value="/boardList", method = RequestMethod.GET ) //(@RequestMapping 해당 주소 사용시 해당 컨트롤러로 오게 설정)

2. 트랜젝션 어노테이션 기반으로 구현
	- xmlns:tx="http://www.springframework.org/schema/tx" // 트랜젝션 namespace 등록

	- @Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})  //컨트롤러에 설정

	- <tx:annotation-driven transaction-manager="transactionManager"/>  //mabatis-context.xml 설정파일에 트렌젝션 설정 추가
	
	  <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
	    <property name="dataSource" ref="dataSource"/>
	  </bean>

3. AOP 구현 (xml 기반)
	- xmlns:aop="http://www.springframework.org/schema/aop" //aop 사용을 위한 namespace 등록

	- pom.xml 디펜던시 추가

	- <bean id="logAop" class="com.datastreams.project.aop.LogAop"/>  // AOP 기능을 구현할 클래스 bean 등록 

	  <aop:config>							  // jointpoint.proceed() 메소드를 이용 하여 프록시 구현
		<aop:aspect id="logger" ref="logAop"> 
			<aop:pointcut expression="execution(* com.datastreams.project.dao.BoardDAOImpl.*(..))" id="publicM"/> //인터페이스를 구현하고 있는 BoardDAOImpl 클래스 에 AOP구현
			<aop:around  pointcut-ref="publicM" method="loggerAop"/>
		</aop:aspect>
	  </aop:config>

	- 어노테이션 기반 구현 오류...
	          
4. filter를 이용한 security 구현 inmemory 방식 (xml 기반)
	- xmlns:sec="http://www.springframework.org/schema/security" //security namepace 등록

	- 3.2.5 RELEASE 버전 사용시 filterchain 빈이 등록이 안되 3.1.3 버전 사용

	- security-context.xml 
		<sec:http use-expressions="true">          
			<sec:intercept-url pattern="/**/**" access="hasAuthority('ROLE_ADMIN')" /> <!-- ROLE_ADMIN권한을 가진 자용자가 접근 -->
			<sec:intercept-url pattern="/manager/**" access="hasRole('ROLE_MANAGER')" /><!-- ROLE_MANAGER권한을 가진 자용자가 접근 -->
			<sec:intercept-url pattern="/member/**" access="isAuthenticated()" /> <!-- 인증된 사용자만 접근 가능 -->
			<sec:intercept-url pattern="/**" access="permitAll" /> <!-- 누구나 접근 가능 -->
			<sec:form-login default-target-url="/" /> <!-- 인증돈 사용자만 허용되는 경로에 접근할때 로그인 폼을 보여준다, 로그인 폼에서 아이디/암호를 전송하면 로그인 처리를 한다 -->
			<sec:logout logout-success-url="/"/> <!-- 로그아웃 처리 -->
		</sec:http>

		<sec:authentication-manager>
			<sec:authentication-provider>
				<sec:user-service>
					<sec:user name="user" password="1234" authorities="ROLE_USER" />   <!-- 이름,비밀번호, 사용자가 갖는 권한 목록 -->
					<sec:user name="manager" password="1234" authorities="ROLE_MANAGER" />
					<sec:user name="admin" password="1234" authorities="ROLE_ADMIN" />
				</sec:user-service>
			</sec:authentication-provider>
		</sec:authentication-manager>
	
	- web.xml
			<!-- security 필터 설정 -->
		   <filter>
			<filter-name>springSecurityFilterChain</filter-name>
			<filter-class>
				org.springframework.web.filter.DelegatingFilterProxy
			</filter-class>
		   </filter>  
		    <filter-mapping>
			<filter-name>springSecurityFilterChain</filter-name>
			<url-pattern>/*</url-pattern>
		    </filter-mapping>

5. Sring Websocket,SockJS 를 이용한 채팅창 구현
	- 서블릿3을 지원하는 컨테이너에서 사용가능
	
	- spring-websocket 디펜던시 추가

	-		<websocket:handlers>												//path 설정으로 핸들러에 설정된 빈을 사용하도록 설정파일에 추가
				<websocket:mapping handler="echoHandler" path="/chat.sockjs"/>
				<websocket:sockjs/>       //sockjs 를 사용하기 위해 추가.
			</websocket:handlers>
	
			<bean id="echoHandler" class="com.datastreams.project.websocket.EchoHandler" />    //핸들러 클래스 빈 생성
	
			<mvc:default-servlet-handler/>

	-      <websocket:handlers> 는 내부적으로 스프링 MVC의 SimpleUrlHandlerMapping을 포함해 몇개의 빈을 등록해준다. 이를 사용하려면 web.xml에 DispatcherServlet 설정을 추가해야된다.
	       <!-- Processes application requests -->
			<servlet>
				<servlet-name>appServlet</servlet-name>
				<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
				<init-param>
					<param-name>contextConfigLocation</param-name>
					<param-value>
						/WEB-INF/spring/appServlet/websocket-context.xml  <!-- websocket 설정파일 -->
						/WEB-INF/spring/appServlet/servlet-context.xml
					</param-value>
				</init-param>

				<load-on-startup>1</load-on-startup>
			</servlet>
				
			<servlet-mapping>
				<servlet-name>appServlet</servlet-name>
				<url-pattern>/</url-pattern>
			</servlet-mapping>