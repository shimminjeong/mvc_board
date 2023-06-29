<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
		String id = request.getParameter("id");
		String hit = request.getParameter("hit");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
%>


<form action="update.do" method="post">
    회원정보 수정<br/>
    아이디 : <c:out value=<%= id %> /> <br/>
    조회수 : <c:out value=<%= hit %> /><br/>
    작성자 : <input type="text" name="name" value=<%= name %> /> <br/>
    제목 : <input type="text" name="title" value=<%= title %> /> <br/> 
    내용 : <input type="text" name="content" value=<%= content %> /> <br/> 
    <input type="hidden" name="id" value="${idcontent.id}" />
    <input type="submit" value="수정완료">
</form>


</body>
</html>