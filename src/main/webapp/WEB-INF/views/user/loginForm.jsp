<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>
<c:set value="ea19b90e1568b2d72f36c1ce4d1cd964" var="REST_API_KEY"></c:set>
<c:set value="http://localhost:8085/auth/kakao/callback" var="REDIRECT_URI"></c:set>
<div class="container">
    <%--스프링 시큐리티가 가로채준다.--%>
    <form id="loginForm" action="/auth/login.do" method="post">
        <div class="form-group">
            <label for="userId">username</label>
            <input type="text" class="form-control" id="userId" name="userId" placeholder="Enter username">
        </div>

        <div class="form-group">
            <label for="Password">Password:</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
        </div>

        <div class="form-group form-check">
            <label class="form-check-label">
                <input type="checkbox" class="form-check-input" name="remember"> Remember me
            </label>
        </div>

        <button type="submit" class="btn btn-primary">로그인</button>
    </form>
</div>
<%@include file="../layout/footer.jsp"%>