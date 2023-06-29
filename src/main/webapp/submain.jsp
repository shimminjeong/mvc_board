<%@page import="com.simminjeong.dto.MBDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
MBDto dto=(MBDto) request.getAttribute("idcontent");
%>
<body>
		회원정보 수정<br /> 
		아이디 : <%=dto.getId() %><br /> 
		조회수 :<%=dto.getHit() %><br /> 
		작성자 :<%=dto.getName() %><br /> 
		제목 :<%=dto.getTitle() %><br /> 
		내용 :<%=dto.getContent() %><br />

		<a href="UpdateContent.jsp">수정</a>
		<a href="InsertContent.jsp?id=${idcontent.id}">답글</a>
		<a href="main.do">목록</a>
	</form>
</body>
</html>