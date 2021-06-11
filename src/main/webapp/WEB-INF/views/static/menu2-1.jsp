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
            <li class="mm-li">키바월드 소개<img src="/images/img4_11.png">
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
        <div id="me2-box1">
            <p class="sub-title">키바월드 소개</p>
            <div>
                <p class="gy-p">
                    키바월드는 유아들을 위한 어학시설 프로그램입니다.<br>
                    <span class="or-sp">키바월드는 아이들과 함께 다양한 노래, 챈트, 음율활동과 신체활동을 통한 놀이영어로 <br>
                      자연스럽게 모국어 습득방식으로 익혀나가는 프로그램입니다.</span><br>
                    각 교실마다 키바월드 어학기를 설치하여 아이들과 늘 소통하고 있는 담임선생님들의 <br>
                    도움으로 키바월드 어학기를 통해 매일 원어민 선생님의 수업의 환경을 열어주고 있습니다.<br>
                    영어를 보고, 듣고, 따라 말하며 영어를 언어로 체화할 수 있도록 도와줄 수 있습니다.<br>
                    언어의 발달 과정에서 유아기에 가장 중요한 환경은 노출량을 늘이는 것입니다.<br>
                    노출을 통한 반복은 짧은 시간안에 많은 단어와 문장을 습득할 수 있으며, 언어를 <br>
                    스펀지처럼 흡수하고 입력을 돕고, 자신의 언어로 발화가능하게 합니다.
                </p>
            </div>
            <div><img src="/images/program_kiva_img1.png"></div>

            <p class="bold-p">EFL환경하의 어린이들에게는 어학을 위한 완벽한 어학시스템이 필요합니다.</p>
            <ul class="me2-ul">
                <li><img src="/images/program_kiva_img2.png">
                    <p class="gy-p">1. 교실에서 즐겁게 친구들과 어학기로 보고, 듣고, 말하는 환경</p>
                </li>
                <li><img src="/images/program_kiva_img3.png">
                    <p class="gy-p">2. 전문 강사들을 통한 확장수업</p>
                </li>
                <li><img src="/images/program_kiva_img4.png">
                    <p class="gy-p">3.언제 어디서든 YouTube강사와 자유롭게 수업하는 환경</p>
                </li>
                <li><img src="/images/program_kiva_img5.png">
                    <p class="gy-p">4. 배움의 즐거움과 자신감을 길러주는 가정연계 앱</p>
                </li>
            </ul>
        </div>


    </div>
</div>
<%@include file="../layout/footer.jsp" %>
<script>
    jQuery(document).ready(function($) {

        $(".mm-li").click(function() {
            $(this).children("ul").slideToggle("");
        });

    });
</script>
</html>