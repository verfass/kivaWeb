<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>
<div class="container">
    <form id="saveForm" action="javascript:void(0)" onsubmit="saveApi()">
        <input type="hidden" name="roleType" value="KID">
        <div class="form-group">
            <label for="userId">유저ID</label>
            <input type="text"  class="form-control" id="userId" name="userId" placeholder="Enter username" required>
            <input type="number" id="CellPhone"  name="cellPhone"  maxlength="11" oninput="maxLengthPhCheck(this)" placeholder="' - ' 빼고 숫자만 입력해 주세요." />
        </div>
        <button type="button" onclick="findId()" >중복확인</button>
        <button type="button" id="sendSmsBtn" onclick="authSmsSend()" >인증</button>
        <div class="form-group">
            <label for="password">패스워드:</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password" required>
        </div>
        <div class="form-group">
            <label for="userName">이름:</label>
            <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter password" required>
        </div>
        <button type="submit" class="btn btn-primary" id="btn-save">회원가입완료</button>
    </form>

    <div>
        <span>타이머</span><span id="timer"></span>
    </div>
</div>



<%@include file="../layout/footer.jsp"%>