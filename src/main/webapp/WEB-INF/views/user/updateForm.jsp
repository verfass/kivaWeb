<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>
<div class="container">
    <form id="updateForm" action="javascript:void(0)" onsubmit="updateApi()">
        <input type="hidden" class="id" name="id" value="${principal.user.id}">
        <div class="form-group">
            <label for="username">username</label>
            <input type="text"  class="form-control" id="username" name="username" value="${principal.user.username}" placeholder="Enter username" readonly>
        </div>
        <c:if test="${empty principal.user.provider}">
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password"  placeholder="Enter password" required>
        </div>
        </c:if>
        <div class="form-group">
            <label for="email">Email address:</label>
            <input type="email" class="form-control" id="email" name="email" value="${principal.user.email}" placeholder="Enter email" readonly>
        </div>

        <button type="submit" class="btn btn-primary" id="btn-save">회원정보 수정</button>
    </form>
</div>
<script src="/static/js/view/user.js/user.js"></script>

<%@include file="../layout/footer.jsp"%>