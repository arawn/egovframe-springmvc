<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="mvc" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<mvc:layout>
    <div class="page-header">
        <h1>${postNo}번 - ${post.title}</h1>
    </div>
    
    <div class="row">
        <div class="span2">내용</div>
        <div class="span8">${post.content}</div>
        <div class="span2">&nbsp;</div>
    </div>
    <div class="row" style="margin-top: 10px; margin-bottom: 20px;">
        <div class="span2">작성자</div>
        <div class="span8">${post.writer}</div>
        <div class="span2">&nbsp;</div>
    </div>
	
	<a href='javascript:history.go(-1);' class='btn'>뒤로가기</a>
	<a href='<spring:url value="/${board.name}/post/edit/${postNo}"/>' class='btn btn-info'>수정하기</a>			
	<a href='javascript:$.form.delete("<spring:url value="/${board.name}/post"/>", {postNo:${postNo}})' class='btn btn-danger'>삭제하기</a>
    
</mvc:layout>