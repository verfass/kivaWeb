<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>
<img src="/images/sub-bg_02.jpg" class="sub-bg">

<div class="sub-head">
    <div class="wid1480">
        <ul class="sub-ul">
            <li class="home"><a href="index.html"><img src="/images/img4_05.png"></a></li>
            <li class="pp-li">메타에듀소개 <img src="/images/img4_08.png">
                <ul class="none">
                    <li><a href=""></a></li>
                </ul>
            </li>
            <li class="mm-li">연혁<img src="/images/img4_11.png">
                <ul class="none">
                    <li><a href="/auth/menu/1">CEO 인사말</a></li>
                    <li><a href="/auth/menu/1-2">연혁</a></li>
                </ul>
            </li>
        </ul>
    </div>

</div>

<div class="wid1480 contentBox">
    <div class="left-menu">
        <p class="left-title">메타에듀 소개</p>
        <ul>
            <li><a href="/auth/menu/1">CEO 인사말</a></li>
            <li><a href="/auth/menu/1-2">연혁</a></li>
        </ul>
        <img src="/images/call.png" class="call-img">
    </div>

    <div class="right-box">

        <div id="history">
            <p>회사연역</p>
            <p>(주)메타에듀는 이 나라의 보다 많은 젊은이들이 넓은 세계에서 더 많은 정보를 획득하고 영어 학습 통로를 쉽게 다원화 알 수 있도록 2014년 부터 <br>지금까지
                계속 노력하고 있습니다.</p>
            <img src="/images/company_img2.jpg">
        </div>
    </div>
</div>

<%@include file="../layout/footer.jsp" %>
<script>
    jQuery(document).ready(function ($) {

        $(".scroll").click(function (event) {
            event.preventDefault();
            $('html,body').animate({scrollTop: $(this.hash).offset().top}, 500);
        });

        $(".mm-li").click(function () {
            $(this).children("ul").slideToggle("");
        });
    });
</script>
</html>