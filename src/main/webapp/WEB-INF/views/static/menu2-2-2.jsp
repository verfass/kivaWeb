<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>
<img src="/images/sub-bg2_02.jpg">
<div class="sub-head">
    <div class="wid1480">
        <ul class="sub-ul">
            <li class="home"><a href="index.html"><img src="/images/img4_05.png"></a></li>
            <li class="pp-li">프로그램 <img src="/images/img4_08.png">
                <ul class="none">
                    <li><a href=""></a></li>
                </ul>
            </li>
            <li class="pp-li">버블버블키즈<img src="/images/img4_08.png">
                <ul class="none">
                    <li><a href=""></a></li>
                </ul>
            </li>
            <li class="mm-li">버블B 교재소개<img src="/images/img4_11.png">
                <ul class="none">
                    <li><a href="/auth/menu/2-2">컨텐츠 소개</a></li>
                    <li><a href="/auth/menu/2-2-1">버블A 교재소개</a></li>
                    <li><a href="/auth/menu/2-2-2">버블B 교재소개</a></li>
                </ul>
            </li>
        </ul>
    </div>

</div>

<div class="wid1480 contentBox">
    <div class="left-menu">
        <p class="left-title">프로그램</p>
        <ul>
            <li><img src="/images/sum-menulogo_05.png"></li>
            <li><a href="/auth/menu/2-1">키바월드 소개</a></li>
            <li><a href="/auth/menu/2-1-1" >교재구성</a></li>
            <hr>
            <li><img src="/images/sum-menulogo_09.png"></li>
            <li><a href="/auth/menu/2-2" >컨텐츠 소개</a></li>
            <li><a href="/auth/menu/2-2-1" >버블A 교재소개</a></li>
            <li><a href="/auth/menu/2-2-2">버블B 교재소개</a></li>
        </ul>
        <img src="/images/call.png" class="call-img">
    </div>

    <div class="right-box">
        <div id="me2-box3">
            <div id="me2-box4">
                <p class="sub-title">버블B교재</p>
                <img src="/images/program_bubble_img7.png" class="ii">

            </div>
        </div>
    </div>
</div>
<%@include file="../layout/footer.jsp" %>
<script>
    jQuery(document).ready(function($) {

        $(".scroll").click(function(event){
            event.preventDefault();
            $('html,body').animate({scrollTop:$(this.hash).offset().top}, 500);
        });

        $(".mm-li").click(function() {
            $(this).children("ul").slideToggle("");
        });
    });
</script>
</html>