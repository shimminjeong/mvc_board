<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>답글 작성</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 20px auto;
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
            display: inline-block;
            width: 100px;
            margin-bottom: 8px;
        }

        input[type="text"],
        textarea {
            width: 300px;
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
    </style>
</head>
<body>
<%
String id=request.getParameter("id");
%>
    <div class="container">
        <h1>답글 작성</h1>
        <form action="insertReply.do?id=<%=id%>" method="post">
            <label for="title">제목:</label>
            <input type="text" id="title" name="title"><br><br>
            
            <label for="name">작성자:</label>
            <input type="text" id="name" name="name"><br><br>
            
            <label for="content">내용:</label><br>
            <textarea id="content" name="content" rows="5" cols="50"></textarea><br><br>
            
            <input type="submit" value="작성">
        </form>
    </div>
</body>
</html>
