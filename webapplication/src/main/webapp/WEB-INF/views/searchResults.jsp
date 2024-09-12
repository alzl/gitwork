<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 결과 출력</title>
</head>
<body>
	<h1>검색 결과</h1>
    <c:if test="${empty contacts}">
        <p>검색 결과가 없습니다.</p>
    </c:if>
    <c:if test="${not empty contacts}">
        <table border="1">
            <thead>
                <tr>
                    <th>아이디</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>메모</th>
                    <th>작업</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contact" items="${contacts}">
                    <tr>
                        <td><c:out value="${contact.id}"/></td>
                        <td><c:out value="${contact.name}"/></td>
                        <td><c:out value="${contact.hp}"/></td>
                        <td><c:out value="${contact.memo}"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/phonebook/view/${contact.id}">보기</a>
                            <a href="${pageContext.request.contextPath}/phonebook/edit/${contact.id}">수정</a>
                            <a href="${pageContext.request.contextPath}/phonebook/delete/${contact.id}">삭제</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <a href="${pageContext.request.contextPath}/phonebook/add">새 연락처 추가</a>
    <a href="${pageContext.request.contextPath}/phonebook/list">전체 목록 보기</a>
</body>
</html>