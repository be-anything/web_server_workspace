<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Time" %><%--
    JSP
    - Java + html
    - 모든 jsp는 Servlet으로 변환되어 서비스된다.
    - jsp의 모든 java코드는 서버단에서 먼저 처리된후 그 결과만 html 형식으로 클라이언트에 전달된다.

    jsp 구성요소
    1. java
        a. 지시어(설정) <%@ page %>, <%@ include %>, <% taglib %>
        b. 스크립팅 원소 <% %>, <%= %>, <%! %>
        c. taglib <% %>
    2. EL
    3. JSTL

    내장객체 (선언없이 사용할 수 있는 객체)
    1. context 객체 (서버운영에 필요한 정보를 가지고, 각기 다른 생명주기를 가진 객체)
        - pageContext : PageContext (JSP처리기간)
        - request : HttpServletRequest (사용자 요청정보를 가진 객체, 요청 ~ 응답)
        - session : HttpSession (사용자 첫접속 ~ 접속해제)
        - application : ServletContext (서버 시작 ~ 서버 종료)
    2. response : HttpServletResponse 응답관련 처리를 위한 객체
    3. out : PrintWriter 응답 출력스트림

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 자바영역
    // 한줄주석
    /*
        여러줄 주석
     */
    System.out.println("Basic.jsp");

    int sum = 0;
    for(int i = 1; i <= 100; i++) {
        sum += i;
    }
    System.out.println(sum);

    long millis = System.currentTimeMillis(); // java에서 밀리초 찾기
    System.out.println(millis);

    // context객체에 속성으로 대입 --> EL
    pageContext.setAttribute("sum", sum);
    pageContext.setAttribute("millis", millis);

%>
<html>
<head>
    <title>JSP | Basics</title>
</head>
<body>
    <h1>Basics</h1>

    <h2>1 ~ 100까지의 합</h2>
    <p id="sumFromServer"><%= sum %></p>
    <p id="sumFromServer">${sum}</p>
    <p id="sumFromClient"></p>

    <h2>현재 시간(밀리초)</h2>
    <p id="nowFromServer"><%= millis %></p>
    <p id="nowFromServer">${millis}</p>
    <p id="nowFromClient"></p>

    <%--  jsp주석 : servlet 변환과정에서 제거된다. --%>
    <!--  html 주석 : client까지 전달 -->

    <script>
        let sum = 0;
        for(let i = 1; i <= 100; i++){
            sum += i;
        }
        document.querySelector('#sumFromClient').innerHTML = sum;

        document.querySelector('#nowFromClient').innerHTML = Date.now();
    </script>

</body>
</html>
