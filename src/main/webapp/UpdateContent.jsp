<%@page import="com.simminjeong.dto.MBDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회 및 수정</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f5f5f5;
        padding: 20px;
    }

    .container {
        max-width: 600px;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 4px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    h1 {
        color: #333;
        margin-top: 0;
    }

    form {
        margin-top: 20px;
    }

    label {
        font-weight: bold;
        display: block;
        margin-bottom: 10px;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        border-radius: 4px;
        border: 1px solid #ccc;
    }

    input[type="submit"] {
        padding: 8px 16px;
        background-color: #4caf50;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    .links {
        margin-top: 20px;
    }

    .links a {
        margin-right: 10px;
        text-decoration: none;
        color: #333;
    }
</style>
</head>
<body>

<%
    MBDto dto=(MBDto) request.getAttribute("idContent");
%>

<div class="container">

    <h1>조회 및 수정</h1>

    <form action="update.do?id=<%=dto.getId()%>" method="post">
        <label for="name">작성자:</label>
        <input type="text" id="name" name="name" value="<%=dto.getName() %>" required>

        <label for="title">제목:</label>
        <input type="text" id="title" name="title" value="<%=dto.getTitle() %>" required>

        <label for="content">내용:</label>
        <input type="text" id="content" name="content" value="<%=dto.getContent() %>" required>

        <input type="hidden" name="id" value="<%=dto.getId() %>">

        <input type="submit" value="수정완료">
    </form>

    <div class="links">
        <a href="InsertReplyContent.jsp?id=<%=dto.getId()%>">답글</a>
        <a href="main.do">목록</a>
    </div>

</div>

</body>
</html>
