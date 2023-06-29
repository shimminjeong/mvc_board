<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시물 작성</title>
</head>
<body>
    <h1>게시물 작성</h1>
    <form action="insert.do" method="post">
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" required><br><br>
        
        <label for="name">작성자:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="content">내용:</label><br>
        <textarea id="content" name="content" rows="5" cols="50" required></textarea><br><br>
        
        <input type="submit" value="작성">
    </form>
</body>
</html>
