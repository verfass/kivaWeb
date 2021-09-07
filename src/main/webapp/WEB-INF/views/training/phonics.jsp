<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../layout/training_header.jsp" %>

<div id="wrap">
    <div class="content_wrap">
        <div class="inner">
            <div class="ui_box">
                <a href="javascript:history.back()" class="btn_home"><img src="/outer/training/img/btn_home.png" alt=""/></a>
            </div>
            <!-- content wrapper -->
            <div id="swp_perview01" class="edu_templete swiper-container" style="background-image:url(/outer/training/img/bg01.jpg);">
                <div class="swiper-wrapper">

                    <%-- 1. 인트로 --%>
                    <div class="swiper-slide" data-bgsrc="bg01.jpg">
                        <div class="inner">
                            <div class="img_box wide">
                                <img src="${Phonics.introImage}" alt="Aa"/>
                            </div>
                            <a href="javascript:;" class="btn_sound" onclick="make_sound('${Phonics.introSound}');">
                                <img src="/outer/training/img/speaker.png" alt=""/>
                            </a>
                        </div>
                    </div>

                    <%-- 2. 획수 - 1 --%>
                    <div class="swiper-slide">
                        <div class="inner">
                            <div class="img_box">
                                <img data-anigif="${Phonics.upperStrokeGif}" data-gifsound="${Phonics.upperStrokeNormalSound}" src="/images/noimage.png" alt="A"/>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="inner">
                            <div class="img_box">
                                <img data-anigif="${Phonics.lowerStrokeGif}" data-gifsound="${Phonics.lowerStrokeNormalSound}" src="/images/noimage.png" alt="a"/>
                            </div>
                        </div>
                    </div>
                    <%-- 2. 획수 - 2 --%>
                    <div class="swiper-slide" data-bgsrc="bg02.jpg">
                        <div class="inner">
                            <div class="img_box wide">
                                <img data-anigif="${Phonics.upperStrokeSlowGif}" data-gifsound="${Phonics.lowerStrokeSlowSound}" src="/images/noimage.png" alt="A"/>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="inner">
                            <div class="img_box">
                                <img data-anigif="${Phonics.upperStrokeNormalGif}" data-gifsound="${Phonics.upperStrokeNormalSound}" src="/images/noimage.png" alt="AA"/>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="inner">
                            <div class="img_box wide">
                                <img data-anigif="${Phonics.lowerStrokeSlowGif}" data-gifsound="${Phonics.lowerStrokeSlowSound}" src="/images/noimage.png" alt="a"/>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="inner">
                            <div class="img_box">
                                <img data-anigif="${Phonics.lowerStrokeNormalGif}" data-gifsound="${Phonics.lowerStrokeNormalSound}" src="/images/noimage.png" alt="aa"/>
                            </div>
                        </div>
                    </div>
                    <%--3. 악어 대문자--%>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg03.jpg" data-bgm="${Phonics.upperQuestionSound}">
                        <div class="inner">
                            <div class="quiz_wrap" data-game="drag">
                                <div class="box_answer next_move" data-code="1">
                                    <img data-after-png="${Phonics.upperSuccessPng}" src="${Phonics.upperQuestionPng}" alt="A"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_frog" id="shuffle-1">
                                        <div class="item"><a data-code="1" class="dragItem" data-sound="${Phonics.answerCode.upperSound}" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.upperSound}" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.upperSound}" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode3.upperSound}" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.upperSound}" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.upperSound}" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg03.jpg">
                        <div class="inner">
                            <div class="quiz_wrap" data-game="drag">
                                <div class="box_answer next_move" data-code="1" <%--data-sound="${Phonics.upperQuestionSound}"--%> >
                                    <img data-after-png="${Phonics.upperSuccessPng}" src="${Phonics.upperQuestionPng}" alt="A"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_frog" id="shuffle-2">
                                        <div class="item"><a data-code="1" class="dragItem" data-sound="${Phonics.answerCode.upperSound}" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.upperSound}" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.upperSound}" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode3.upperSound}" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.upperSound}" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.upperSound}" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg03.jpg">
                        <div class="inner">
                            <div class="quiz_wrap" data-game="drag">
                                <div class="box_answer" data-code="1" <%--data-sound="${Phonics.upperQuestionSound}"--%> >
                                    <img data-after-png="${Phonics.upperSuccessPng}" src="${Phonics.upperQuestionPng}" alt="A"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_frog" id="shuffle-3">
                                        <div class="item"><a data-code="1" class="dragItem" data-sound="${Phonics.answerCode.upperSound}" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.upperSound}" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.upperSound}" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode3.upperSound}" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.upperSound}" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.upperSound}" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--4. 악어 소문자--%>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg03.jpg" data-bgm="${Phonics.lowerQuestionSound}">
                        <div class="inner">
                            <div class="quiz_wrap" data-game="drag">
                                <div class="box_answer next_move" data-code="1" <%--data-sound="${Phonics.upperQuestionSound}"--%> >
                                    <img data-after-png="${Phonics.lowerSuccessPng}" src="${Phonics.lowerQuestionPng}" alt="a"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_frog" id="shuffle-4">
                                        <div class="item"><a data-code="1" class="dragItem" data-sound="${Phonics.answerCode.lowerSound}" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.lowerSound}" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.lowerSound}" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode3.lowerSound}" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.lowerSound}" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.lowerSound}" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg03.jpg">
                        <div class="inner">
                            <div class="quiz_wrap" data-game="drag">
                                <div class="box_answer next_move" data-code="1" <%--data-sound="${Phonics.upperQuestionSound}"--%> >
                                    <img data-after-png="${Phonics.lowerSuccessPng}" src="${Phonics.lowerQuestionPng}" alt="a"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_frog" id="shuffle-5">
                                        <div class="item"><a data-code="1" class="dragItem" data-sound="${Phonics.answerCode.lowerSound}" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.lowerSound}" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.lowerSound}" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode3.lowerSound}" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.lowerSound}" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.lowerSound}" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg03.jpg">
                        <div class="inner">
                            <div class="quiz_wrap" data-game="drag">
                                <div class="box_answer" data-code="1" <%--data-sound="../sound/alphabets/a.mp3"--%>>
                                    <img data-after-png="${Phonics.lowerSuccessPng}" src="${Phonics.lowerQuestionPng}" alt="a"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_frog" id="shuffle-6">
                                        <div class="item"><a data-code="1" class="dragItem" data-sound="${Phonics.answerCode.lowerSound}" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.lowerSound}" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.lowerSound}" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode3.lowerSound}" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.lowerSound}" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.lowerSound}" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%-- 5. 인트로 재탕 --%>
                    <div class="swiper-slide" data-bgsrc="bg01.jpg" data-bgm="${Phonics.introSound}">
                        <div class="inner">
                            <div class="img_box wide">
                                <img src="${Phonics.introImage}" alt="Aa"/>
                            </div>
                            <a href="javascript:;" class="btn_sound" onclick="make_sound('${Phonics.introSound}');">
                                <img src="/outer/training/img/speaker.png" alt=""/>
                            </a>
                        </div>
                    </div>

                    <!--6. 사과나무 문제-->
                    <div class="swiper-slide stop_slide" data-bgsrc="bg04.jpg" data-bgm="${Phonics.upperLowerQuestionSound}">
                        <div class="inner">
                            <div class="quiz_wrap type_tree" data-game="select_tree">
                                <div class="box_answer" data-code="1">
                                    <img data-after-png="${Phonics.upperSuccessPng}" src="${Phonics.upperQuestionPng}" alt="A"/>
                                    <img data-after-png="${Phonics.lowerSuccessPng}" src="${Phonics.lowerQuestionPng}" alt="a"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_tree" id="shuffle-7">
                                        <div class="item"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item"><a data-code="0" data-sound="${Phonics.errorCode1.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item"><a data-code="0" data-sound="${Phonics.errorCode1.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" data-sound="${Phonics.errorCode2.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                        <div class="item"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item"><a data-code="0" data-sound="${Phonics.errorCode2.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item"><a data-code="0" data-sound="${Phonics.errorCode3.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item"><a data-code="0" data-sound="${Phonics.errorCode3.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        <div class="item"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--7. 악어 재탕 대문자 <= 소문자 -->
                    <div class="swiper-slide stop_slide" data-bgsrc="bg03.jpg" data-bgm="${Phonics.upperEqualsLowerQuestionSound}">
                        <div class="inner">
                            <div class="quiz_wrap" data-game="drag">
                                <div class="box_answer next_move" data-code="1">
                                    <img data-after-png="${Phonics.upperSuccessPng}" src="${Phonics.upperQuestionPng}" alt="A"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_frog" id="shuffle-8">
                                        <div class="item"><a data-code="1" class="dragItem" data-sound="${Phonics.answerCode.lowerSound}" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.lowerSound}" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.lowerSound}" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode3.lowerSound}" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.lowerSound}" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.lowerSound}" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg03.jpg">
                        <div class="inner">
                            <div class="quiz_wrap" data-game="drag">
                                <div class="box_answer next_move" data-code="1">
                                    <img data-after-png="${Phonics.upperSuccessPng}" src="${Phonics.upperQuestionPng}" alt="A"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_frog" id="shuffle-9">
                                        <div class="item"><a data-code="1" class="dragItem" data-sound="${Phonics.answerCode.lowerSound}" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.lowerSound}" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.lowerSound}" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode3.lowerSound}" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.lowerSound}" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.lowerSound}" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg03.jpg">
                        <div class="inner">
                            <div class="quiz_wrap" data-game="drag">
                                <div class="box_answer" data-code="1">
                                    <img data-after-png="${Phonics.upperSuccessPng}" src="${Phonics.upperQuestionPng}" alt="A"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_frog" id="shuffle-10">
                                        <div class="item"><a data-code="1" class="dragItem" data-sound="${Phonics.answerCode.lowerSound}" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.lowerSound}" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.lowerSound}" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode3.lowerSound}" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.lowerSound}" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.lowerSound}" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!--8. 악어 재탕 소문자 <= 대문자 -->
                    <div class="swiper-slide stop_slide" data-bgsrc="bg03.jpg" data-bgm="${Phonics.lowerEqualsUpperQuestionSound}">
                        <div class="inner">
                            <div class="quiz_wrap" data-game="drag">
                                <div class="box_answer next_move" data-code="1">
                                    <img data-after-png="${Phonics.lowerSuccessPng}" src="${Phonics.lowerQuestionPng}" alt="a"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_frog" id="shuffle-11">
                                        <div class="item"><a data-code="1" class="dragItem" data-sound="${Phonics.answerCode.upperSound}" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.upperSound}" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.upperSound}" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode3.upperSound}" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.upperSound}" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.upperSound}" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg03.jpg">
                        <div class="inner">
                            <div class="quiz_wrap" data-game="drag">
                                <div class="box_answer next_move" data-code="1">
                                    <img data-after-png="${Phonics.lowerSuccessPng}" src="${Phonics.lowerQuestionPng}" alt="a"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_frog" id="shuffle-12">
                                        <div class="item"><a data-code="1" class="dragItem" data-sound="${Phonics.answerCode.upperSound}" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.upperSound}" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.upperSound}" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode3.upperSound}" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.upperSound}" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.upperSound}" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg03.jpg">
                        <div class="inner">
                            <div class="quiz_wrap" data-game="drag">
                                <div class="box_answer" data-code="1">
                                    <img data-after-png="${Phonics.lowerSuccessPng}" src="${Phonics.lowerQuestionPng}" alt="a"/>
                                </div>
                                <div class="box_exam">
                                    <div class="list_frog" id="shuffle-13">
                                        <div class="item"><a data-code="1" class="dragItem" data-sound="${Phonics.answerCode.upperSound}" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.upperSound}" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.upperSound}" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode3.upperSound}" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode1.upperSound}" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item"><a data-code="0" class="dragItem" data-sound="${Phonics.errorCode2.upperSound}" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--9. 날아다니는 풍선--%>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg05.jpg" data-bgm="${Phonics.findAlphabetQuestionSound1}">
                        <div class="inner">
                            <div class="quiz_wrap type_balloon" data-game="select">
                                <div class="box_exam">
                                    <div class="list_balloon" id="shuffle-14">
                                        <div class="item ball_green"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item ball_orange"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item ball_red"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item ball_pink"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item ball_navy"><a data-code="0" data-sound="${Phonics.errorCode3.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item ball_red"><a data-code="0" data-sound="${Phonics.errorCode1.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item ball_navy"><a data-code="0" data-sound="${Phonics.errorCode2.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item ball_blue"><a data-code="0" data-sound="${Phonics.errorCode1.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item ball_pink"><a data-code="0" data-sound="${Phonics.errorCode2.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                        <div class="item ball_green"><a data-code="0" data-sound="${Phonics.errorCode2.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item ball_green"><a data-code="0" data-sound="${Phonics.errorCode3.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item ball_orange"><a data-code="0" data-sound="${Phonics.errorCode3.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        <div class="item ball_orange"><a data-code="0" data-sound="${Phonics.errorCode3.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                    </div>
<%--                                    여기부터--%>
                                    <div class="balloon_card">
                                        <div class="card" data-sound="${Phonics.wordAnswerSound1}" data-repeat="2">
                                            <img src="${Phonics.wordAnswerImage1}" alt=""/>
                                            <p><strong>${Phonics.answerCode.lower}</strong>${Phonics.wordAnswerAfterText1}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg05.jpg">
                        <div class="inner">
                            <div class="quiz_wrap type_balloon" data-game="select">
                                <div class="box_exam">
                                    <div class="list_balloon" id="shuffle-15">
                                        <div class="item ball_green"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item ball_orange"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item ball_red"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item ball_pink"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item ball_navy"><a data-code="0" data-sound="${Phonics.errorCode3.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item ball_red"><a data-code="0" data-sound="${Phonics.errorCode1.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item ball_navy"><a data-code="0" data-sound="${Phonics.errorCode2.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item ball_blue"><a data-code="0" data-sound="${Phonics.errorCode1.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item ball_pink"><a data-code="0" data-sound="${Phonics.errorCode2.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                        <div class="item ball_green"><a data-code="0" data-sound="${Phonics.errorCode2.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item ball_green"><a data-code="0" data-sound="${Phonics.errorCode3.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item ball_orange"><a data-code="0" data-sound="${Phonics.errorCode3.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        <div class="item ball_orange"><a data-code="0" data-sound="${Phonics.errorCode3.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                    </div>
                                    <div class="balloon_card">
                                        <div class="card" data-sound="${Phonics.wordAnswerSound2}" data-repeat="2">
                                            <img src="${Phonics.wordAnswerImage2}" alt=""/>
                                            <p><strong>${Phonics.answerCode.lower}</strong>${Phonics.wordAnswerAfterText2}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg05.jpg">
                        <div class="inner">
                            <div class="quiz_wrap type_balloon" data-game="select">
                                <div class="box_exam">
                                    <div class="list_balloon" id="shuffle-16">
                                        <div class="item ball_green"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item ball_orange"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item ball_red"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item ball_pink"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item ball_navy"><a data-code="0" data-sound="${Phonics.errorCode1.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item ball_red"><a data-code="0" data-sound="${Phonics.errorCode1.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item ball_blue"><a data-code="0" data-sound="${Phonics.errorCode1.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item ball_pink"><a data-code="0" data-sound="${Phonics.errorCode2.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                        <div class="item ball_navy"><a data-code="0" data-sound="${Phonics.errorCode2.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item ball_green"><a data-code="0" data-sound="${Phonics.errorCode2.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item ball_green"><a data-code="0" data-sound="${Phonics.errorCode3.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item ball_orange"><a data-code="0" data-sound="${Phonics.errorCode3.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        <div class="item ball_orange"><a data-code="0" data-sound="${Phonics.errorCode3.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                    </div>
                                    <div class="balloon_card">
                                        <div class="card" data-sound="${Phonics.wordAnswerSound3}" data-repeat="2">
                                            <img src="${Phonics.wordAnswerImage3}" alt=""/>
                                            <p><strong>${Phonics.answerCode.lower}</strong>${Phonics.wordAnswerAfterText3}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg05.jpg">
                        <div class="inner">
                            <div class="quiz_wrap type_balloon" data-game="select">
                                <div class="box_exam">
                                    <div class="list_balloon" id="shuffle-17">
                                        <div class="item ball_orange"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item ball_green"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item ball_pink"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                        <div class="item ball_red"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                        <div class="item ball_navy"><a data-code="0" data-sound="${Phonics.errorCode1.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item ball_red"><a data-code="0" data-sound="${Phonics.errorCode1.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                        <div class="item ball_blue"><a data-code="0" data-sound="${Phonics.errorCode1.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                        <div class="item ball_pink"><a data-code="0" data-sound="${Phonics.errorCode2.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                        <div class="item ball_navy"><a data-code="0" data-sound="${Phonics.errorCode2.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item ball_green"><a data-code="0" data-sound="${Phonics.errorCode2.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        <div class="item ball_green"><a data-code="0" data-sound="${Phonics.errorCode3.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                        <div class="item ball_orange"><a data-code="0" data-sound="${Phonics.errorCode3.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        <div class="item ball_orange"><a data-code="0" data-sound="${Phonics.errorCode3.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                    </div>
                                    <div class="balloon_card">
                                        <div class="card" data-sound="${Phonics.wordAnswerSound4}" data-repeat="2">
                                            <img src="${Phonics.wordAnswerImage4}" alt=""/>
                                            <p><strong>${Phonics.answerCode.lower}</strong>${Phonics.wordAnswerAfterText4}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--10. 상자 풍선 / 캔디--%>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg06.jpg" data-bgm="${Phonics.findAlphabetQuestionSound2}">
                        <div class="inner">
                            <div class="quiz_wrap type_balloon02" data-game="select02">
                                <div class="box_exam">
                                    <div class="list_balloon">
                                        <div id="shuffle-18">
                                            <div class="item ball_orange"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                            <div class="item ball_green"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                            <div class="item ball_green"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                            <div class="item ball_red"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                            <div class="item ball_yellow"><a data-code="0" data-sound="${Phonics.errorCode2.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                            <div class="item ball_navy"><a data-code="0" data-sound="${Phonics.errorCode2.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                            <div class="item ball_blue"><a data-code="0" data-sound="${Phonics.errorCode3.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                            <div class="item ball_red"><a data-code="0" data-sound="${Phonics.errorCode3.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        </div>
                                        <img class="bg" src="/outer/training/img/balloon_box.png" alt=""/>
                                    </div>
                                    <div class="balloon_card">
                                        <div class="card" data-sound="${Phonics.wordAnswerSound1}" data-repeat="2">
                                            <img src="${Phonics.wordAnswerImage1}" alt=""/>
                                            <p><strong>${Phonics.answerCode.lower}</strong>${Phonics.wordAnswerAfterText1}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg07.jpg">
                        <div class="inner">
                            <div class="quiz_wrap type_candy" data-game="select02">
                                <div class="box_exam">
                                    <div class="list_balloon">
                                        <div id="shuffle-19">
                                            <div class="item candy_beige"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                            <div class="item candy_purple"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                            <div class="item candy_mint"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                            <div class="item candy_pink"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                            <div class="item candy_green"><a data-code="0" data-sound="${Phonics.errorCode2.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                            <div class="item candy_yellow"><a data-code="0" data-sound="${Phonics.errorCode2.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                            <div class="item candy_red"><a data-code="0" data-sound="${Phonics.errorCode3.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                            <div class="item candy_blue"><a data-code="0" data-sound="${Phonics.errorCode3.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        </div>
                                        <img class="bg" src="/outer/training/img/candy_box.png" alt=""/>
                                        <img class="bg02" src="/outer/training/img/candy_box02.png" alt=""/>
                                    </div>

                                    <div class="balloon_card">
                                        <div class="card" data-sound="${Phonics.wordAnswerSound2}" data-repeat="2">
                                            <img src="${Phonics.wordAnswerImage2}" alt=""/>
                                            <p><strong>${Phonics.answerCode.lower}</strong>${Phonics.wordAnswerAfterText2}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg06.jpg">
                        <div class="inner">
                            <div class="quiz_wrap type_balloon02" data-game="select02">
                                <div class="box_exam">
                                    <div class="list_balloon">
                                        <div id="shuffle-20">
                                            <div class="item ball_red"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                            <div class="item ball_navy"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                            <div class="item ball_purple"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                            <div class="item ball_yellow"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                            <div class="item ball_blue"><a data-code="0" data-sound="${Phonics.errorCode1.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                            <div class="item ball_orange"><a data-code="0" data-sound="${Phonics.errorCode1.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                            <div class="item ball_red"><a data-code="0" data-sound="${Phonics.errorCode3.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.upper}</a></div>
                                            <div class="item ball_green"><a data-code="0" data-sound="${Phonics.errorCode3.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode3.lower}</a></div>
                                        </div>
                                        <img class="bg" src="/outer/training/img/balloon_box.png" alt=""/>
                                    </div>
                                    <div class="balloon_card">
                                        <div class="card" data-sound="${Phonics.wordAnswerSound3}" data-repeat="2">
                                            <img src="${Phonics.wordAnswerImage3}" alt=""/>
                                            <p><strong>${Phonics.answerCode.lower}</strong>${Phonics.wordAnswerAfterText3}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg07.jpg">
                        <div class="inner">
                            <div class="quiz_wrap type_candy" data-game="select02">
                                <div class="box_exam">
                                    <div class="list_balloon">
                                        <div id="shuffle-21">
                                            <div class="item candy_purple"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                            <div class="item candy_beige"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                            <div class="item candy_yellow"><a data-code="1" data-sound="${Phonics.answerCode.upperSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.upper}</a></div>
                                            <div class="item candy_pink"><a data-code="1" data-sound="${Phonics.answerCode.lowerSound}" class="selectItem" href="javascript:;">${Phonics.answerCode.lower}</a></div>
                                            <div class="item candy_mint"><a data-code="0" data-sound="${Phonics.errorCode1.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.upper}</a></div>
                                            <div class="item candy_red"><a data-code="0" data-sound="${Phonics.errorCode1.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode1.lower}</a></div>
                                            <div class="item candy_blue"><a data-code="0" data-sound="${Phonics.errorCode2.upperSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.upper}</a></div>
                                            <div class="item candy_green"><a data-code="0" data-sound="${Phonics.errorCode2.lowerSound}" class="selectItem" href="javascript:;">${Phonics.errorCode2.lower}</a></div>
                                        </div>
                                        <img class="bg" src="/outer/training/img/candy_box.png" alt=""/>
                                        <img class="bg02" src="/outer/training/img/candy_box02.png" alt=""/>
                                    </div>
                                    <div class="balloon_card">
                                        <div class="card" data-sound="${Phonics.wordAnswerSound4}" data-repeat="2">
                                            <img src="${Phonics.wordAnswerImage4}" alt=""/>
                                            <p><strong>${Phonics.answerCode.lower}</strong>${Phonics.wordAnswerAfterText4}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--11-1. 문장 인트로--%>
                    <div class="swiper-slide" data-bgsrc="bg01.jpg" data-bgm="${Phonics.sentenceAnswerSound}">
                        <div class="inner">
                            <div class="img_box sentence_img"><img src="${Phonics.sentenceAnswerImage}" alt=""/></div>
                            <p class="txt_box02">${Phonics.sentenceAnswerText}</p>
                        </div>
                    </div>
                    <%--11-2. 문장 문제 시작--%>
                    <div class="swiper-slide stop_slide" data-bgsrc="bg08.jpg" data-bgm="/outer/training/sound/make the sentence with pictures.mp3">
                        <div class="inner">
                            <div class="quiz_wrap type_blank" data-game="drag02">
                                <div class="tbl_cell">
                                    <div class="box_answer" data-sound="${Phonics.sentenceAnswerSound}">
                                        <div class="answer" data-code="1" onclick="make_sound('${Phonics.sentenceAnswerSplitSoundEn1}');"><img class="num" src="/outer/training/img/number_circle01.png" alt="1"/></div>
                                        <div class="answer" data-code="2" onclick="make_sound('${Phonics.sentenceAnswerSplitSoundEn2}');"><img class="num" src="/outer/training/img/number_circle02.png" alt="2"/></div>
                                        <div class="answer" data-code="3" onclick="make_sound('${Phonics.sentenceAnswerSplitSoundEn3}');"><img class="num" src="/outer/training/img/number_circle03.png" alt="3"/></div>
                                    </div>
                                    <div class="box_exam">
                                        <div class="list_pic" id="shuffle-22">
                                            <div class="item"><a data-code="1" data-sound="${Phonics.sentenceAnswerSplitSoundKr1}" class="dragItem" href="javascript:;"><img src="${Phonics.sentenceQuestionImage1}" alt=""/></a></div>
                                            <div class="item"><a data-code="2" data-sound="${Phonics.sentenceAnswerSplitSoundKr2}" class="dragItem" href="javascript:;"><img src="${Phonics.sentenceQuestionImage2}" alt=""/></a></div>
                                            <div class="item"><a data-code="3" data-sound="${Phonics.sentenceAnswerSplitSoundKr3}" class="dragItem" href="javascript:;"><img src="${Phonics.sentenceQuestionImage3}" alt=""/></a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgm="/outer/training/sound/make the sentence with words.mp3">
                        <div class="inner">
                            <div class="quiz_wrap type_blank" data-game="drag02">
                                <div class="tbl_cell">
                                    <div class="box_answer" data-sound="${Phonics.sentenceAnswerSound}">
                                        <div class="answer" data-code="1" onclick="make_sound('${Phonics.sentenceAnswerSplitSoundEn1}');"><p>${Phonics.sentenceAnswerSplit1}</p></div>
                                        <div class="answer" data-code="2" onclick="make_sound('${Phonics.sentenceAnswerSplitSoundEn2}');"><p>${Phonics.sentenceAnswerSplit2}</p></div>
                                        <div class="answer" data-code="3" onclick="make_sound('${Phonics.sentenceAnswerSplitSoundEn3}');"><p>${Phonics.sentenceAnswerSplit3}</p></div>
                                    </div>
                                    <div class="box_exam">
                                        <div class="list_pic" id="shuffle-23">
                                            <div class="item"><a data-code="1" data-sound="${Phonics.sentenceAnswerSplitSoundKr1}" class="dragItem" href="javascript:;"><img src="${Phonics.sentenceQuestionImage1}" alt=""/></a></div>
                                            <div class="item"><a data-code="2" data-sound="${Phonics.sentenceAnswerSplitSoundKr2}" class="dragItem" href="javascript:;"><img src="${Phonics.sentenceQuestionImage2}" alt=""/></a></div>
                                            <div class="item"><a data-code="3" data-sound="${Phonics.sentenceAnswerSplitSoundKr3}" class="dragItem" href="javascript:;"><img src="${Phonics.sentenceQuestionImage3}" alt=""/></a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide" data-bgm="/outer/training/sound/make the sentence with pictures.mp3">
                        <div class="inner">
                            <div class="quiz_wrap type_blank" data-game="drag02">
                                <div class="tbl_cell">
                                    <div class="box_answer bg_white" data-sound="${Phonics.sentenceAnswerSound}">
                                        <div class="answer" data-code="1" onclick="make_sound('${Phonics.sentenceAnswerSplitSoundEn1}');"><img class="num" src="/outer/training/img/number_circle01.png" alt="1"/></div>
                                        <div class="answer" data-code="2" onclick="make_sound('${Phonics.sentenceAnswerSplitSoundEn2}');"><img class="num" src="/outer/training/img/number_circle02.png" alt="2"/></div>
                                        <div class="answer" data-code="3" onclick="make_sound('${Phonics.sentenceAnswerSplitSoundEn3}');"><img class="num" src="/outer/training/img/number_circle03.png" alt="3"/></div>
                                    </div>
                                    <div class="box_exam">
                                        <div class="list_pic txt" id="shuffle-24">
                                            <div class="item"><a data-code="1" data-sound="${Phonics.sentenceAnswerSplitSoundEn1}" class="dragItem" href="javascript:;"><span>${Phonics.sentenceAnswerSplit1}</span></a></div>
                                            <div class="item"><a data-code="2" data-sound="${Phonics.sentenceAnswerSplitSoundEn2}" class="dragItem" href="javascript:;"><span>${Phonics.sentenceAnswerSplit2}</span></a></div>
                                            <div class="item"><a data-code="3" data-sound="${Phonics.sentenceAnswerSplitSoundEn3}" class="dragItem" href="javascript:;"><span>${Phonics.sentenceAnswerSplit3}</span></a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide stop_slide">
                        <div class="inner">
                            <div class="quiz_wrap type_blank" data-game="drag02">
                                <div class="tbl_cell">
                                    <div class="box_answer bg_white" data-sound="${Phonics.sentenceAnswerSound}">
                                        <div class="answer" data-code="1" onclick="make_sound('${Phonics.sentenceAnswerSplitSoundKr1}');"><img src="${Phonics.sentenceQuestionImage1}" alt=""/></div>
                                        <div class="answer" data-code="2" onclick="make_sound('${Phonics.sentenceAnswerSplitSoundKr2}');"><img src="${Phonics.sentenceQuestionImage2}" alt=""/></div>
                                        <div class="answer" data-code="3" onclick="make_sound('${Phonics.sentenceAnswerSplitSoundKr3}');"><img src="${Phonics.sentenceQuestionImage3}" alt=""/></div>
                                    </div>
                                    <div class="box_exam">
                                        <div class="list_pic txt" id="shuffle-25">
                                            <div class="item"><a data-code="1" data-sound="${Phonics.sentenceAnswerSplitSoundEn1}" class="dragItem" href="javascript:;"><span>${Phonics.sentenceAnswerSplit1}</span></a></div>
                                            <div class="item"><a data-code="2" data-sound="${Phonics.sentenceAnswerSplitSoundEn2}" class="dragItem" href="javascript:;"><span>${Phonics.sentenceAnswerSplit2}</span></a></div>
                                            <div class="item"><a data-code="3" data-sound="${Phonics.sentenceAnswerSplitSoundEn3}" class="dragItem" href="javascript:;"><span>${Phonics.sentenceAnswerSplit3}</span></a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
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
        for (let i = 1; i <= 25; i++) {
            let target = document.getElementById("shuffle-"+i);
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