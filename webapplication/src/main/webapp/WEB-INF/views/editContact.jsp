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
	<h1>연락처 수정</h1>
    <c:if test="${not empty contact}">
        <form action="${pageContext.request.contextPath}/phonebook/update" method="post">
            <input type="hidden" name="id" value="${contact.id}"/>
            <label for="name">이름:</label>
            <input type="text" id="name" name="name" value="${contact.name}" required /><br/>
            <label for="hp">전화번호:</label>
            <input type="text" id="hp" name="hp" value="${contact.hp}" required /><br/>
            <label for="memo">메모:</label>
            <textarea id="memo" name="memo">${contact.memo}</textarea><br/>
            <input type="submit" value="수정" />
        </form>
        <a href="${pageContext.request.contextPath}/phonebook/view/${contact.id}">취소</a>
    </c:if>
    <c:if test="${empty contact}">
        <p>연락처가 존재하지 않습니다.</p>
        <a href="${pageContext.request.contextPath}/phonebook/list">목록으로 돌아가기</a>
    </c:if>
</body>
</html>