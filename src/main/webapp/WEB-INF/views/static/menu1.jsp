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
            <li class="mm-li">CEO 인사말<img src="/images/img4_11.png">
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
        <ul >
            <li><a href="/auth/menu/1" >CEO 인사말</a></li>
            <li><a href="/auth/menu/1-2">연혁</a></li>
        </ul>
        <img src="/images/call.png" class="call-img ">
    </div>

    <div class="right-box">
        <div id="ceo">
            <p>대한민국 유아교육시장을 새롭게 이끌어 갈 차세대 젊은 기업<br>
                ㈜메타에듀 홈페이지를 찾아주신 여러분 진심으로 환영합니다.
            </p>
            <p>
                ㈜메타에듀는 2016년부터 유아기에 가장 중요한 영어학습환경을 위해 직접 현장을 <br>
                찾아다니며 유아교육기관 교실마다 시스템 정착을 위한 매뉴얼 개발을 시작으로 <br>
                현재 40여개 이상의 지사를 보유하며 전국 네트워크 망을 조직하였습니다.
            </p>
            <p>
                ㈜메타에듀는 “교육적 본질에 중점을 둔 <span class="or-sp">핵심경영</span>, 사업파트너를 이해하고 고려한
                <span class="or-sp">상생경영</span>, <br>
                어떠한 상황에서도 원칙과 정도를 생각하는 <span class="or-sp">정도경영</span>“이라는
                경영이념을 실천해 오고 있습니다.
            </p>
            <p>
                이를 위해 시장의 변화를 미리 예견하여 MTS어학기 도입으로 시스템 정착에 최선을 다하고,<br>
                시스템의 안정화를 위해 매달 교육으로 유지, 관리에 주력을 하고 있습니다.<br>
                또한 학습자, 교육기관과의 소통으로 빠른 변화와 개선을 통해 현장교육의 감동을 더하고 있습니다.<br>
                앞으로 ㈜메타에듀는 EFL환경에 있는 세계 모든 어린이들을 위해 학습의 기술을 더한 MTS어학기 시스템으로 <br>
                한국을 넘어 세계의 유아교육시장까지 넓혀나가며 K-EDU 열풍의 주력이 되겠습니다.<br>
                감사합니다.

            </p>
            <p><span>㈜메타에듀 대표이사</span>  주재현 배상</p>
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