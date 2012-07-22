<%@ tag language="java" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset='utf-8'>
	<title>Spring @MVC 기본기 다지기</title>
	<meta name='viewport' content='width=device-width, initial-scale=1.0'>
	<meta name='description' content=''>
	<meta name='author' content=''>

	<!-- Le styles -->
	<link href='<spring:url value="/resources/css/bootstrap.css"/>' rel='stylesheet'>
	<style type='text/css'>
		body {
			padding-top: 60px;
			padding-bottom: 40px;
		}
        
        table.table thead th {
            text-align: center;
        }
        table.table .txt_c {
            text-align: center;
        }
	</style>
	<link href='<spring:url value="/resources/css/bootstrap-responsive.css"/>' rel='stylesheet'>

	<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
      <script src='<spring:url value="/resources/js/html5.js"/>'></script>
    <![endif]-->
</head>

<body>

	<div class='navbar navbar-fixed-top'>
		<div class='navbar-inner'>
			<div class='container'>
				<a class='btn btn-navbar' data-toggle='collapse' data-target='.nav-collapse'>
                    <span class='icon-bar'></span>
                    <span class='icon-bar'></span>
                    <span class='icon-bar'></span>
				</a>
                <a class='brand' href='<spring:url value="/notice/post"/>'>Spring @MVC Example</a>
                <div class="btn-group pull-right">
                    <c:if test="${empty sessionScope.SESSION_USER_KEY}">
                    <button class="btn" onclick="$('#loginModal').modal('show')"><i class="icon-user"></i> 로그인</button>
                    </c:if>
                    <c:if test="${not empty sessionScope.SESSION_USER_KEY}">
                    <a class="btn" href='/egovframe/logout'><i class="icon-user"></i> ${sessionScope.SESSION_USER_KEY.username} - 로그아웃</a>
                    </c:if>
                </div>
				<div class='nav-collapse'>
					<ul class='nav'>
						<li class='active'><a href='<spring:url value="/user-info"/>'>사용자 정보</a></li>
						<li class='active'><a href='<spring:url value="/notice/post"/>'>공지사항</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class='container'>

		<jsp:doBody/>	

		<hr>
		<footer style="text-align: center;">
			<p>표준프레임워크 오픈커뮤니티 23차 기술세미나</p>
		</footer>
	
    </div>
	<!-- /container -->
    
    <div id="loginModal" class="modal hide">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <h3>로그인</h3>
        </div>
        <div class="modal-body">
            <form id="loginForm" action="/egovframe/login" method="post" class="form-horizontal">
            <fieldset>
                <div class="control-group">
                    <label class="control-label">사용자 이름</label>
                    <div class="controls">
                        <input type="text" name="username"/>
                    </div>
                </div>
            </fieldset>
            </form>
        </div>
        <div class="modal-footer">
            <a href="#" class="btn" data-dismiss="modal">취소</a>
            <button class="btn btn-primary" onclick="$('#loginForm').submit();">로그인</a>
        </div>
    </div>    

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src='<spring:url value="/resources/js/jquery.js"/>'></script>
	<script src='<spring:url value="/resources/js/bootstrap-transition.js"/>'></script>
	<script src='<spring:url value="/resources/js/bootstrap-alert.js"/>'></script>
	<script src='<spring:url value="/resources/js/bootstrap-modal.js"/>'></script>
	<script src='<spring:url value="/resources/js/bootstrap-dropdown.js"/>'></script>
	<script src='<spring:url value="/resources/js/bootstrap-scrollspy.js"/>'></script>
	<script src='<spring:url value="/resources/js/bootstrap-tab.js"/>'></script>
	<script src='<spring:url value="/resources/js/bootstrap-tooltip.js"/>'></script>
	<script src='<spring:url value="/resources/js/bootstrap-popover.js"/>'></script>
	<script src='<spring:url value="/resources/js/bootstrap-button.js"/>'></script>
	<script src='<spring:url value="/resources/js/bootstrap-collapse.js"/>'></script>
	<script src='<spring:url value="/resources/js/bootstrap-carousel.js"/>'></script>
	<script src='<spring:url value="/resources/js/bootstrap-typeahead.js"/>'></script>
    <script type="text/javascript">
        $.form = function() {
            var createForm = function(method, url, params) {
                var form = $('<form name="jquery.form"/>')
                			.attr('method', method === 'get' ? 'get' : 'post')
                			.attr('action', url);
                form.append('<input type="hidden" name="_method" value="' + method + '" />');
                form.appendTo('body');
                
                if(params) {
                    for(var key in params)
                        form.append('<input type="hidden" name="' + key + '" value="' + params[key] + '" />');
                }
                
                return form;
            };
            return {
                get: function(url, params) {
                    createForm('get', url, params).submit();
                },
                post: function(url, params) {
                    createForm('post', url, params).submit();
                },
                put: function(url, params) {
                    createForm('put', url, params).submit();
                },
                delete: function(url, params) {
                    createForm('delete', url, params).submit();
                }
            };
        }();
        
        $('#loginModal').modal({ show: false });
        $('#loginModal').on('shown', function() {
			$('input[name=username]').focus();
        });
        
        $(document).ready(function() {
			if('${loginRequest}' === 'true') {
			    $('#loginModal').modal('show');
			}
		});
    </script>
</body>
</html>