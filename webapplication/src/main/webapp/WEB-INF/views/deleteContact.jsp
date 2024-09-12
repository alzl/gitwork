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
	<h1>연락처 삭제</h1>
    <c:if test="${not empty contact}">
        <p>정말로 연락처를 삭제하시겠습니까?</p>
        <p><strong>이름:</strong> <c:out value="${contact.name}"/></p>
        <p><strong>전화번호:</strong> <c:out value="${contact.hp}"/></p>
        <p><strong>메모:</strong> <c:out value="${contact.memo}"/></p>
        <form action="${pageContext.request.contextPath}/phonebook/delete" method="post">
            <input type="hidden" name="id" value="${contact.id}"/>
            <input type="submit" value="삭제" />
        </form>
        <a href="${pageContext.request.contextPath}/phonebook/view/${contact.id}">취소</a>
    </c:if>
    <c:if test="${empty contact}">
        <p>연락처가 존재하지 않습니다.</p>
        <a href="${pageContext.request.contextPath}/phonebook/list">목록으로 돌아가기</a>
    </c:if>
</body>
</html>