<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="./layout/header.jsp" %>

<div class="main-slide">
    <div class="bxslider3">
        <div class="hi"><img src="/images/main-sd1_02.jpg"></div>
        <div class="hi"><img src="/images/main-sd_02.jpg"></div>
        <div class="hi"><img src="/images/main-sd2_02.jpg"></div>
        <div class="hi"><img src="/images/main-sd3_02.jpg"></div>
        <div class="hi"><img src="/images/main-sd4_02.jpg"></div>
    </div>
    <div class="pager" id="bx-pager">
        <a data-slide-index="0" href=""><img src="/images/slider4_03.jpg"/></a>
        <a data-slide-index="1" href=""><img src="/images/slider_03.jpg"/></a>
        <a data-slide-index="2" href=""><img src="/images/slider_06.jpg"/></a>
        <a data-slide-index="3" href=""><img src="/images/slider_08.jpg"/></a>
        <a data-slide-index="4" href=""><img src="/images/ss_03.jpg"/></a>
    </div>
    <button type="button" class="pp-movi"
            data-toggle="modal"
            data-target="#moviModal"
            onclick="videoPlay()"><img src="/images/movi.png"></button>
</div>

<div class="ma-box1">
    <p class="sample">SAMPLE<span>영상체험</span></p>
    <p class="sub-p">Phonics, Conversation, Storysong으로 더욱 다양하게 버튼을 눌러서 직접 체험해보세요!!</p>
    <img src="/images/main_09.png" class="img1">
    <img src="/images/animation_300_kkxlxhx0.gif" class="img2">
    <img src="/images/sub-gg_03.jpg" class="img3">
    <img src="/images/sub-gg_06.jpg" class="img4">
    <span class="ff"></span>
    <ul>
        <li class="mov1"><a href="https://www.youtube.com/embed/20PZsmxTsL8"><img src="/images/main-box2_13.png"></a></li>
        <li class="mov2"><a href="https://www.youtube.com/embed/c45kzsQPmBQ"><img src="/images/main-box2_13.png"></a></li>
        <li class="mov3"><a href="https://www.youtube.com/embed/7rYSTZW6heY"><img src="/images/main-box2_13.png"></a></li>
    </ul>
</div>

<div class="ma-box2">
    <img src="/images/main-ss2_03.jpg" class="iii">
    <div class="ma-box2Inlist">
        <ul>
            <li><a href="https://www.youtube.com/playlist?list=PL759_XpTlDUGadFwSwXONcy--umKDutm8"  rel="grow" class="button grow"><img src="/images/main-youtube_09.png"></a></li>
            <li><a href="https://www.youtube.com/playlist?list=PL759_XpTlDUET2g51sdHdAler-C28DRnQ"  rel="grow" class="button grow"><img src="/images/main-youtube_11.png"></a></li><br>
            <li><a href="https://www.youtube.com/playlist?list=PL759_XpTlDUHLJpC6yX3GSy5-uHysQRZM"  rel="grow" class="button grow"><img src="/images/main-youtube_15.png"></a></li>
            <li><a href="https://www.youtube.com/playlist?list=PL759_XpTlDUFeqQbrRbCxo8BjiOZbkWRt"  rel="grow" class="button grow"><img src="/images/main-youtube_17.png"></a></li>
        </ul>
    </div>
</div>
<div class="modal fade moviModal"
        id="moviModal"
        tabindex="-1"
        role="dialog"
        aria-labelledby="basicModal"
        aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="videoStop()">
                <span aria-hidden="true">&times;</span>
            </button>
            <video id="video1" controls>
                <source src="/images/movi.mp4" type="video/mp4">
            </video>
        </div>
    </div>
</div>

<div class="modal fade popupModal"
     id="popupModal"
     tabindex="-1"
     role="dialog"
     aria-labelledby="basicModal"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="videoStop()">
                <span aria-hidden="true">&times;</span>
            </button>
            <img src="/images/popup/popup_20220504_200809_1.jpg" width="500" class="img1">
        </div>
    </div>
</div>

<%@include file="./layout/footer.jsp" %>
<script>
    $(document).ready(function(){
        $('.bxslider3').bxSlider( {
            mode: 'horizontal',// 가로 방향 수평 슬라이드
            auto: true,
            autoControls: false,//시작멈춤버튼
            stopAutoOnClick: false,
            pager: true,
            controls: false,
            slideWidth: 1920,
            pagerCustom : '#bx-pager' //썸네일
        });

        $('#popupModal').modal('show');

    });
    function videoPlay() {
        $("#video1").get(0).play();
    }

    function videoStop() {
        $("#video1").get(0).pause();
    }
</script>

</html>