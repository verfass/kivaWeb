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
            <li class="mm-li">컨텐츠 소개<img src="/images/img4_11.png">
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
            <p class="sub-title">버블버블 소개</p>
            <div class="me-2subimg1">
                <p class="gy-p bb-txt">
                    <span class="or-sp">모든 아이는 ‘언어의 천재’</span><br>
                    인간의 언어 발달이 가장 활발한 시기 중 하나인 만 1세~2세의 아이들 <br>
                    하루에 10개 내외의 새로운 말을 배우게 됩니다.<br>
                    언어 습득을 위한 결정적 시기(Critical Period)에 모든 아이들은 <br>영어를
                    모국어처럼 습득할 수 있습니다!
                </p>
            </div>
            <div class="me-2subimg1"><img src="/images/program_bubble_img1.jpg"></div>
            <img src="/images/program_bubble_img2.png" class="mar-100">
            <img src="/images/program_bubble_img3.png">

        </div>
        <div id="me2-box4">
            <img src="/images/program_bubble_img5.png" >
            <img src="/images/program_bubble_img6.png">
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