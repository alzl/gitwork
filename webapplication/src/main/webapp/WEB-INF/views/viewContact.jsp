<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 보기</title>
</head>
<body>
	<h1>연락처 상세보기</h1>
    <c:if test="${not empty contact}">
        <p><strong>이름:</strong> <c:out value="${contact.name}"/></p>
        <p><strong>전화번호:</strong> <c:out value="${contact.hp}"/></p>
        <p><strong>메모:</strong> <c:out value="${contact.memo}"/></p>
        <a href="${pageContext.request.contextPath}/phonebook/edit/${contact.id}">수정</a>
        <a href="${pageContext.request.contextPath}/phonebook/delete/${contact.id}">삭제</a>
        <a href="${pageContext.request.contextPath}/phonebook/list">목록으로 돌아가기</a>
    </c:if>
    <c:if test="${empty contact}">
        <p>연락처가 존재하지 않습니다.</p>
        <a href="${pageContext.request.contextPath}/phonebook/list">목록으로 돌아가기</a>
    </c:if>
</body>	
</html>