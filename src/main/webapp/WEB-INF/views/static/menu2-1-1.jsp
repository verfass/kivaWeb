<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>
<img src="/images/sub-bg2_02.jpg" class="sub-bg">

<div class="sub-head">
    <div class="wid1480">
        <ul class="sub-ul">
            <li class="home"><a href="/"><img src="/images/img4_05.png"></a></li>
            <li class="pp-li">프로그램 <img src="/images/img4_08.png">
                <ul class="none">
                    <li><a href=""></a></li>
                </ul>
            </li>
            <li class="pp-li">키바월드 <img src="/images/img4_08.png">
                <ul class="none">
                    <li><a href=""></a></li>
                </ul>
            </li>
            <li class="mm-li">교재구성<img src="/images/img4_11.png">
                <ul class="none">
                    <li><a href="/auth/menu/2-1">키바월드 소개</a></li>
                    <li><a href="/auth/menu/2-1-1">키바월드 교재구성</a></li>
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

        <div id="me2-box2">
            <p class="sub-title">교재구성</p>

            <ul class="tabs">
                <li class="tab-link current" data-tab="tab-1"></li>
                <li class="tab-link" data-tab="tab-2"></li>
                <li class="tab-link" data-tab="tab-3"></li>
            </ul>

            <div id="tab-1" class="tab-content current">
                <img src="/images/program_kiva_book1.png">
            </div>
            <div id="tab-2" class="tab-content">
                <img src="/images/program_kiva_book2.png">
            </div>
            <div id="tab-3" class="tab-content">
                <img src="/images/program_kiva_book3.png">
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

        $('ul.tabs li').click(function() {
            var tab_id = $(this).attr('data-tab');

            $('ul.tabs li').removeClass('current');
            $('.tab-content').removeClass('current');

            $(this).addClass('current');
            $("#" + tab_id).addClass('current');
        });
    });
</script>
</html>