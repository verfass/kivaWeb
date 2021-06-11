<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../layout/training_header.jsp" %>

<div id="wrap">
    <div class="content_wrap">
        <div class="inner">
            <div class="ui_box">
                <a href="javascript:history.back();" class="btn_home"><img src="/outer/training/img/btn_home.png"></a>
            </div>
            <!-- content wrapper -->
            <div id="swp_perview01" class="edu_templete swiper-container" style="background:#fe5b86;">
                <div class="swiper-wrapper">
                    <div class="swiper-slide full" data-bgsrc="#fe5b86" data-bgm="/outer/training/sound/whats your name.mp3">
                        <div class="inner">
                            <div class="img_box"><img src="${DailyTalk.dailyTalkImage1}" alt=""/></div>
                            <a href="javascript:;" class="btn_sound" onclick="make_sound('${DailyTalk.dailyTalkSound1}');"><img src="/outer/training/img/speaker_white.png" alt=""/></a>
                        </div>
                    </div>

                    <div class="swiper-slide full" data-bgsrc="#fff" data-bgm="/outer/training/sound/Lets sing.mp3" data-video="1" data-youtubu-url="${DailyTalk.songUrl}">
                        <div class="inner">
                            <div class="img_box">
                                <div id="video1">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide full" data-bgsrc="#fff" data-bgm="/outer/training/sound/Lets chant.mp3" data-video="2" data-youtubu-url="${DailyTalk.chantUrl}">
                        <div class="inner">
                            <div class="img_box">
                                <div id="video2">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide full" data-bgsrc="#fff" data-video="3" data-youtubu-url="${DailyTalk.ebookUrl}">
                        <div class="inner">
                            <div class="img_box">
                                <div id="video3">

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="swiper-slide" data-bgsrc="bg09.jpg" data-bgm="${DailyTalk.cardSound1}" data-repeat="2">
                        <div class="inner">
                            <div class="img_box word_card">
                                <a href="javascript:;" onclick="make_sound('${DailyTalk.cardSound1}')"><img src="${DailyTalk.cardImage1}" alt=""/></a>
                            </div>
                            <p class="txt_box02">${DailyTalk.cardText1} </p>
                        </div>
                    </div>
                    <div class="swiper-slide" data-bgm="${DailyTalk.cardSound2}" data-repeat="2">
                        <div class="inner">
                            <div class="img_box word_card">
                                <a href="javascript:;" onclick="make_sound('${DailyTalk.cardSound2}');"><img src="${DailyTalk.cardImage2}" alt=""/></a>
                            </div>
                            <p class="txt_box02">${DailyTalk.cardText2}</p>
                        </div>
                    </div>
                    <div class="swiper-slide" data-bgm="${DailyTalk.cardSound3}" data-repeat="2">
                        <div class="inner">
                            <div class="img_box word_card">
                                <a href="javascript:;" onclick="make_sound('${DailyTalk.cardSound3}');"><img src="${DailyTalk.cardImage3}" alt=""/></a>
                            </div>
                            <p class="txt_box02">${DailyTalk.cardText3}</p>
                        </div>
                    </div>
                    <div class="swiper-slide" data-bgm="${DailyTalk.cardSound4}" data-repeat="2">
                        <div class="inner">
                            <div class="img_box word_card">
                                <a href="javascript:;" onclick="make_sound('${DailyTalk.cardSound4}');"><img src="${DailyTalk.cardImage4}" alt=""/></a>
                            </div>
                            <p class="txt_box02">${DailyTalk.cardText4}</p>
                        </div>
                    </div>

                    <div class="swiper-slide stop_slide" data-bgm="/outer/training/sound/Listen n choos the correct picture.mp3" data-bgsrc="bg10.jpg">
                        <div class="inner">
                            <div class="quiz_wrap type_blank02" data-game="drag03">
                                <div class="tbl_cell">
                                    <div class="box_answer" data-sound="${DailyTalk.type1AnswerSound}">
                                        <div class="answer" data-code="1"></div>
                                        <div class="q_box">
                                            <p class="txt_box">${DailyTalk.type1QuestionText}</p>
                                        </div>
                                    </div>
                                    <div class="box_exam">
                                        <div class="list_pic number" id="shuffle-1">
                                            <div class="item">
                                                <a data-code="1" data-sound="${DailyTalk.type1AnswerSound}" class="dragItem" href="javascript:;"><img src="${DailyTalk.type1AnswerImage}" alt=""/></a>
                                            </div>
                                            <div class="item">
                                                <a data-code="0" data-sound="${DailyTalk.type1ErrorSound1}" class="dragItem" href="javascript:;"><img src="${DailyTalk.type1ErrorImage1}" alt=""/></a>
                                            </div>
                                            <div class="item">
                                                <a data-code="0" data-sound="${DailyTalk.type1ErrorSound2}" class="dragItem" href="javascript:;"><img src="${DailyTalk.type1ErrorImage2}" alt=""/></a>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgm="/outer/training/sound/Listen n choos the correct word.mp3">
                        <div class="inner">
                            <div class="quiz_wrap type_blank03" data-game="drag04">
                                <div class="tbl_cell">
                                    <div class="box_answer" data-sound="${DailyTalk.type2AnswerSound}">
                                        <div class="img_box" onclick="make_sound('${DailyTalk.type2AnswerSound}');"><img src="${DailyTalk.type2AnswerImage}" alt=""/></div>
                                        <ul class="sentence">
                                            <li class="${DailyTalk.type2QuestionNumber == 1 ? 'answer':''}" data-code="${DailyTalk.type2QuestionNumber == 1 ? '1':''}">
                                                ${DailyTalk.type2QuestionNumber == 1 ? '':DailyTalk.type2AnswerTextSplit1}
                                            </li>
                                            <li class="${DailyTalk.type2QuestionNumber == 2 ? 'answer':''}" data-code="${DailyTalk.type2QuestionNumber == 2 ? '1':''}">
                                                ${DailyTalk.type2QuestionNumber == 2 ? '':DailyTalk.type2AnswerTextSplit2}
                                            </li>
                                            <li class="${DailyTalk.type2QuestionNumber == 3 ? 'answer':''}" data-code="${DailyTalk.type2QuestionNumber == 3 ? '1':''}">
                                                ${DailyTalk.type2QuestionNumber == 3 ? '':DailyTalk.type2AnswerTextSplit3}
                                            </li>
                                            <li class="${DailyTalk.type2QuestionNumber == 4 ? 'answer':''}" data-code="${DailyTalk.type2QuestionNumber == 4 ? '1':''}">
                                                ${DailyTalk.type2QuestionNumber == 4 ? '':DailyTalk.type2AnswerTextSplit4}
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="box_exam">
                                        <div class="list_txt" id="shuffle-2">
                                            <div class="item">
                                                <c:if test='${DailyTalk.type2QuestionNumber == 1}'>
                                                    <a data-code="1" data-sound="${DailyTalk.type2AnswerSoundSplit1}" class="dragItem" href="javascript:;">${DailyTalk.type2AnswerTextSplit1}</a>
                                                </c:if>
                                                <c:if test='${DailyTalk.type2QuestionNumber == 2}'>
                                                    <a data-code="1" data-sound="${DailyTalk.type2AnswerSoundSplit2}" class="dragItem" href="javascript:;">${DailyTalk.type2AnswerTextSplit2}</a>
                                                </c:if>
                                                <c:if test='${DailyTalk.type2QuestionNumber == 3}'>
                                                    <a data-code="1" data-sound="${DailyTalk.type2AnswerSoundSplit3}" class="dragItem" href="javascript:;">${DailyTalk.type2AnswerTextSplit3}</a>
                                                </c:if>
                                                <c:if test='${DailyTalk.type2QuestionNumber == 4}'>
                                                    <a data-code="1" data-sound="${DailyTalk.type2AnswerSoundSplit4}" class="dragItem" href="javascript:;">${DailyTalk.type2AnswerTextSplit4}</a>
                                                </c:if>
                                            </div>
                                            <div class="item">
                                                <a data-code="0" data-sound="${DailyTalk.type2ErrorSoundSplit1}" class="dragItem" href="javascript:;">${DailyTalk.type2ErrorTextSplit1}</a>
                                            </div>
                                            <div class="item">
                                                <a data-code="0" data-sound="${DailyTalk.type2ErrorSoundSplit2}" class="dragItem" href="javascript:;">${DailyTalk.type2ErrorTextSplit2}</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgm="/outer/training/sound/Listen n make the correct sentence.mp3">
                        <div class="inner">
                            <div class="quiz_wrap type_blank03" data-game="drag02">
                                <div class="tbl_cell">
                                    <div class="box_answer" data-sound="${DailyTalk.type2AnswerSound}">
                                        <div class="img_box" onclick="make_sound('${DailyTalk.type2AnswerSound}');"><img src="${DailyTalk.type2AnswerImage}" alt=""/></div>
                                        <ul class="sentence">
                                            <li class="answer" data-code="1"></li>
                                            <li class="answer" data-code="2"></li>
                                            <li class="answer" data-code="3"></li>
                                            <li class="answer" data-code="4"></li>
                                        </ul>
                                    </div>
                                    <div class="box_exam">
                                        <div class="list_txt" id="shuffle-3">
                                            <div class="item">
                                                <a data-code="1" data-sound="${DailyTalk.type2AnswerSoundSplit1}" class="dragItem" href="javascript:;">${DailyTalk.type2AnswerTextSplit1}</a>
                                            </div>
                                            <div class="item">
                                                <a data-code="2" data-sound="${DailyTalk.type2AnswerSoundSplit2}" class="dragItem" href="javascript:;">${DailyTalk.type2AnswerTextSplit2}</a>
                                            </div>
                                            <div class="item">
                                                <a data-code="3" data-sound="${DailyTalk.type2AnswerSoundSplit3}" class="dragItem" href="javascript:;">${DailyTalk.type2AnswerTextSplit3}</a>
                                            </div>
                                            <div class="item">
                                                <a data-code="4" data-sound="${DailyTalk.type2AnswerSoundSplit4}" class="dragItem" href="javascript:;">${DailyTalk.type2AnswerTextSplit4}</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide full" data-bgsrc="#fe5b86" data-bgm="${DailyTalk.goodJobSound}">
                        <div class="inner">
                            <div class="img_box"><img src="${DailyTalk.goodJobImage}" alt=""/></div>
                            <a href="javascript:;" class="btn_sound" onclick="make_sound('${DailyTalk.goodJobSound}');"></a>
                        </div>
                    </div>
                </div>

                <div class="btn_prev"></div>
                <div class="btn_next"></div>
            </div>
            <!-- //content wrapper -->
        </div>
    </div>
</div>

<%@include file="../layout/training_footer.jsp" %>
<script>
    function initSelectItem02(wrapper, total) {
        var totalTarget = total;
        var totalHit = 0;

        wrapper.find(".selectItem").on("click", function () {
            var code = $(this).data("code");

            if (code) {
                if ($(this).parents(".type_balloon02").length > 0) {
                    var date = new Date();
                    var bg = $(this).parent().css("background-image");
                    bg = bg.split(".png")[0] + ".gif?" + date.getTime();
                    $(this).parent().addClass("effect").css({
                        "background-image": bg,
                        "z-index": "-1"
                    });
                    make_sound($(this).data("sound"));
                    make_sound("/outer/training/sound/effect_balloon.mp3");
                    TweenMax.to($(this).parent(), 0.1, {x: Math.random() * 10 - 5, y: 10});
                    TweenMax.to($(this).parent(), 0.6, {x: 0, y: 0, delay: 0.1, onComplete: hideMatches});
                } else {
                    make_sound($(this).data("sound"));
                    TweenMax.to($(this).parent(), 0.1, {y: 5});
                    TweenMax.to($(this).parent(), 0.6, {autoAlpha: 0, scale: 1.1, x: Math.random() * 100 - 50, y: -100, delay: 0.1, onComplete: hideMatches});
                }
            } else {
                make_sound("/outer/training/sound/error.mp3");
                TweenMax.to($(this).parent(), 0.1, {x: Math.random() * 5, y: 10});
                TweenMax.to($(this).parent(), 0.8, {x: 0, y: 0, delay: 0.1});
            }
        });

        function hideMatches() {
            totalHit++;
            if (totalHit == totalTarget) {
                var card = wrapper.find(".balloon_card .card");
                var mp3_url = card.data("sound");
                card.addClass("active");

                if (card.data("repeat")) {
                    make_sound(mp3_url, card.data("repeat"));
                } else {
                    make_sound(mp3_url);
                }
                swiperActiveFn(swpEdu01, "next");
            }
        }
    }




    // document ready
    window.onload = function () {
        // 페이지 완전 로딩후 실행
        for (let i = 1; i <= 3; i++) {
            let target = document.getElementById("shuffle-" + i);
            shuffleHtml(target.children);
        }

        initFn();
        $(".quiz_wrap").each(function () {
            var total = $(this).find(".box_exam *[data-code=1]").length;
            switch ($(this).data("game")) {
                case "drag":
                    initDraggableItem($(this), total);
                    break;
                case "drag02":
                    total = $(this).find(".answer").length;
                    initDraggableItem02($(this), total);
                    break;
                case "drag03":
                    total = $(this).find(".answer").length;
                    initDraggableItem03($(this), total);
                    break;
                case "drag04":
                    total = $(this).find(".answer").length;
                    initDraggableItem04($(this), total);
                    break;
                case "select_tree":
                    initSelectItemTree($(this), total);
                    break;
                case "select":
                    initSelectItem($(this), total);
                    break;
                case "select02":
                    initSelectItem02($(this), total);
                    break;
            }
        });
    }
    const shuffleHtml = array => {
        for (let i = 0; i < array.length; i++) {
            let j = Math.floor(Math.random() * (i + 1));
            const x = array[i].innerHTML;
            array[i].innerHTML = array[j].innerHTML;
            array[j].innerHTML = x;
        }
        return array;
    };


</script>