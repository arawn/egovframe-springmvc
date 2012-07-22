<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="mvc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<mvc:layout>
    <div class="page-header">
	   <h1>사용자 정보 보기</h1>
    </div>
    <p>Username : ${user.username}</p>
</mvc:layout>