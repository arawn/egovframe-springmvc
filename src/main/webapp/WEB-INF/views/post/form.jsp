<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="mvc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<mvc:layout>
    <div class="page-header">
        <c:if test="${empty postNo}">
        <h1 style="padding-left: 20px;">새로운 글 작성하기</h1>
        <c:set var="method" value="post"/>
        </c:if>
        <c:if test="${not empty postNo}">
        <h1 style="padding-left: 20px;">${postNo}번 글 수정하기</h1>
        <c:set var="method" value="put"/>
        </c:if>
    </div>
    <spring:url value="/${board.name}/post" var="action"/>
    <form:form id="form" cssClass="form-horizontal" action="/egovframe/notice/post" method="${method}" modelAttribute="post">
    <form:hidden path="no"/>
    <fieldset>
        <div class="control-group">
            <form:label path="title" cssClass="control-label">제목</form:label>
            <div class="controls">
                <form:input path="title" cssClass="input-xlarge"/>
                <form:errors path="title"><p class="help-block"></p></form:errors>
            </div>
        </div>
        <div class="control-group">
            <form:label path="content" cssClass="control-label">내용</form:label>
            <div class="controls">
                <form:textarea path="content" rows="2" cssClass="input-xlarge"/>
                <form:errors path="content"><p class="help-block"></p></form:errors>
            </div>
        </div>
        <div class="control-group">
            <form:label path="writer" cssClass="control-label">작성자</form:label>
            <div class="controls">
                <form:input path="writer" cssClass="input-xlarge"/>
                <form:errors path="writer"><p class="help-block"></p></form:errors>
            </div>
        </div>
        <div class="form-actions">
            <button class='btn btn-primary'>저장하기</button>
            <a href='javascript:history.go(-1);' class='btn'>뒤로가기</a>           
        </div>
    </fieldset>
    </form:form>
</mvc:layout>