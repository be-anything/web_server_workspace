<%--
  Created by IntelliJ IDEA.
  User: user1
  Date: 2023-12-22
  Time: 오후 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ajax | xml</title>
    <style>
        table {
            border: 1px solid #000;
            border-collapse: collapse;
            margin: 10px 0;
        }
        th, td {
            border: 1px solid #000;
            padding: 5px;
        }
        table img {
            width: 200px;
        }
    </style>
</head>
<body>
    <h1>xml</h1>
    <button id="btn1">확인</button>
    <table id="books">
        <thead>
            <th>주제</th>
            <th>제목</th>
            <th>저장</th>
        </thead>
        <tbody>
        </tbody>
    </table>
    <button id="btn-celeb">Celeb 확인</button>
    <table id="celebs">
        <thead>
        <tr>
            <th>Id</th>
            <th>Profile</th>
            <th>Name</th>
            <th>Type</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
    <script>
        const contextPath = '${pageContext.request.contextPath}';
    </script>
    <script
            src="https://code.jquery.com/jquery-3.7.1.js"
            integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
            crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/js/xml.js"></script>
</body>
</html>