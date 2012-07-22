<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring @MVC</title>
</head>
<body>

    <c:if test="${not empty name}">
        <h1>Hello ${name}!</h1>
    </c:if>

    <c:if test="${empty name}">
        <form>
            이름: <input type='text' name='name' />
            <button type='submit'>전송</button>
        </form>
    </c:if>

</body>
</html>