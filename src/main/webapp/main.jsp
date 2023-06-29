<%@page import="com.simminjeong.dto.MBDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>

<form action="delete.do" method="post">
	<table>
	    <tr>
	    	<th></th>
	        <th>번호</th>
	        <th>이름</th>
	        <th>제목</th>
	        <th>날짜</th>
	        <th>조회수</th>
	    </tr>
	    <c:forEach var="result" items="${boardlist}">
	        <tr>
	        	<td><input type="checkbox" name="selectedIds" value="${result.id}" /></td>
	        	<td><c:out value="${result.id}" /></td>
	            <td><c:out value="${result.name}" /></td>
	            <td><a href="submain.do?id=${result.id}">${result.title}</a></td>
	            <td><c:out value="${result.write_date}"/></td>
	            <td><c:out value="${result.hit}" /></td>
	    </tr>
	    </c:forEach>
	</table>

	<button type="submit">삭제</button>
	<a href="InsertContent.jsp">글쓰기</a>
</form>
</body>
</html>
