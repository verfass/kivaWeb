<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>
<div class="login-pg">
    <div class="inner-box">
        <form id="loginForm" action="/auth/login.do" method="post">
            <p class="login-img"><img src="/images/logintxt_03.png"></p>
            <input type="text" class="input1" id="userId" name="userId" placeholder="아이디" required>
            <input type="password" class="input1" id="password" name="password" placeholder="비밀번호" required>
            <button type="submit" class="login-btn">로그인</button>
            <div class="idpw-box" style="text-align: center;color: #ffc62b">${param.failMsg}</div>

            <div class="idpw-box">
                <a href="/auth/user/find_id">아이디 찾기</a> / <a href="/auth/user/find_password">비밀번호 찾기</a>
            </div>
            <hr class="hr">
            <p class="fff">
                <span>아직 회원이 아니신가요?</span>
                <a href="/auth/user/join" class="join-a">회원가입</a>
            </p>
        </form>
    </div>
</div>
<%@include file="../layout/footer.jsp" %>
<script>
    //파라미터를 숨기는데 사용한다.
    history.replaceState({}, null, location.pathname);
</script>

</html>