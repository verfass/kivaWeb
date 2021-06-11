<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../layout/study_room_header.jsp" %>
<body class="study_romm">
    <div class="room_body">
        <div class="top">
            <h1><a href="/"><img src="/images/logo-fff.png"></a></h1>
            <div>
                <p>${principal.user.userName} 선생님</p>
                <button type="button" onclick="location.href='/logout'"><img src="/images/logout.png">로그아웃</button>
            </div>
        </div>
        <ul class="btn_zon">
            <li class="grow-rotate"><a href="/study/menu/1"><img src="/images/btn1-1.png" alt="버블버블A"></a></li>
            <li class="grow-rotate"><a href="/study/menu/2"><img src="/images/btn1-2.png" alt="버블버블B"></a></li>
            <li class="grow-rotate"><a href="/study/menu/3"><img src="/images/btn2-1.png" alt="키바월드A"></a></li>
            <li class="grow-rotate"><a href="/study/menu/4"><img src="/images/btn2-2.png" alt="키바월드B"></a></li>
            <li class="grow-rotate"><a href="/study/menu/5"><img src="/images/btn2-3.png" alt="키바월드C"></a></li>
            <li class="grow-rotate"><a href="/study/menu/6"><img src="/images/btn3-1.png" alt="메타키즈A"></a></li>
            <li class="grow-rotate"><a href="/study/menu/7"><img src="/images/btn3-2.png" alt="메타키즈B"></a></li>
            <li class="grow-rotate"><a href="/study/menu/8"><img src="/images/btn3-3.png" alt="메타키즈C"></a></li>
        </ul>
    </div>
</body>
<%@include file="../layout/study_room_footer.jsp" %>