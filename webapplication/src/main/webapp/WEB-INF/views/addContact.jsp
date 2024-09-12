<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연락처 추가</title>
</head>
<body>
<h1>연락처 추가</h1>
    <form action="${pageContext.request.contextPath}/phonebook/add" method="post">
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required /><br/>
        <label for="hp">전화번호:</label>
        <input type="text" id="hp" name="hp" required /><br/>
        <label for="memo">메모:</label>
        <textarea id="memo" name="memo"></textarea><br/>
        <input type="submit" value="추가" />
    </form>
    <a href="${pageContext.request.contextPath}/phonebook/list">목록으로 돌아가기</a>
</body>
</html>