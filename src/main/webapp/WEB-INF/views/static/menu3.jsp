<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>
<img src="/images/sub-bg3_02.jpg"  class="sub-bg">

<div class="sub-head">
    <div class="wid1480">
        <ul class="sub-ul">
            <li class="home"><a href="index.html"><img src="/images/img4_05.png"></a></li>
            <li class="pp-li pp-li2">MTS-어학기
                <ul class="none">
                    <li><a href=""></a></li>
                </ul>
            </li>
        </ul>
    </div>

</div>

<div class="wid1480 contentBox">
    <div class="left-menu">
        <p class="left-title">MTS-어학기</p>
        <img src="/images/call.png" class="call-img">
    </div>

    <div class="right-box">
        <div class="mts">
            <p class="com_txt2"><span class="point">MTS 어학기는,</span><br>
                EFL환경하에 외국어를 배우는 세계 모든 어린이들을 위해 개발된, ‘메타언어인지학습법‘을 기반으로 한  국내 최초 어학기입니다.</p>
            <img src="/images/mts_img.jpg" alt="매일 교실에서 원어민을 만날 수 있는 어학시설 환경 프로그램">
            <p class="com_txt3">‘메타언어인지학습법‘이란?</p>
            <p class="com_txt2">학습자가 언어를 배울 때, 보고, 듣고, 따라 말하며 자신이 알고 모르는 부분을 스스로 인지하며, 학습자 스스로의 자주적인 반복을 통하여,<br> 기억할 수 있는 언어의 양이
                늘어난 결과를 확인할 수 있는 학습법입니다.<br>
                메타인지를 통하여 언어를 효과적으로 습득하기 위해서는, 언어습득을 위한 환경이 가장 중요합니다.<br><br>

                MTS어학기는 키바월드를 학습하는 유아 교육 기관 각 교실에 설치되며, <br>
                담임선생님들의 가이드를 바탕으로 원어민선생님의 환경에서 보고, 듣고, 따라 말하는 모국어 습득환경이 만들어 집니다.<br>
                유아기 언어 학습에 있어서 가장 중요한 반복과 노출!키바 MTS어학기는 외국어를 언어로 학습할 수 있는 최상의 환경입니다.<br><br>

                2020년 키바월드영어가 태국으로 수출되어, 태국 내 사립유치원과 국제학교 킨더과정에서 활용되고 있습니다.<br>
                영어권에서 만든 영어프로그램이 아닌, 한국에서 만든 영어프로그램을 사용하여 영어를 가르치고 있다는 것은 정말 자랑스러운 일입니다. <br><br>

                교실영어의 진정한 리더, (주)메타에듀 의 MTS어학기로 우리 아이들의 글로벌한 미래가 열립니다.</p>
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