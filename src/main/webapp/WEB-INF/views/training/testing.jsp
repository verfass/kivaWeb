<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../layout/training_header.jsp" %>

<div id="wrap">
    <div class="test_wrap"><!-- //prefix : test_wrap : 시험 -->
        <div class="inner">
            <div class="top_box">
                <a href="/menu/branch" class="btn_home"><img src="/outer/training/img/btn_home.png"></a>
                <dl>
                    <dt>errors:</dt>
                    <dd><strong>0</strong></dd>
                </dl>
                <p class="cnt">(<span class="current_p">1</span>/${Testings.size()})</p>
            </div>
            <!-- 문제지 -->
            <div id="swp_test" class="test_templete swiper-container">
                <div class="swiper-wrapper">
                    <c:forEach var="testing" items="${Testings}" varStatus="status">
                        <c:choose>
                            <c:when test="${testing.testingType == 1}">
                                <div class="swiper-slide" data-bgm="${testing.questionImageSound1}">
                                    <p class="question_tit">${testing.title}</p>

                                    <div class="box01">
                                        <c:if test="${testing.questionImage1 != null}">
                                            <img src="${testing.questionImage1}" onclick="make_sound('${testing.questionImageSound1}');" alt="" style="cursor: pointer"/>
                                        </c:if>
                                        <c:if test="${testing.questionImage2 != null}">
                                            <img src="${testing.questionImage2}" onclick="make_sound('${testing.questionImageSound2}');" alt="" style="cursor: pointer"/>
                                        </c:if>
                                    </div>
                                    <div class="answer_list answer" id="shuffle-${status.count}">
                                        <a href="javascript:;" data-code="1" data-point="${testing.point}">${testing.answerTextAndImageUrl}</a>
                                        <a href="javascript:;" data-code="0" data-point="${testing.point}">${testing.errorTextAndImageUrl1}</a>
                                        <a href="javascript:;" data-code="0" data-point="${testing.point}">${testing.errorTextAndImageUrl2}</a>
                                        <a href="javascript:;" data-code="0" data-point="${testing.point}">${testing.errorTextAndImageUrl3}</a>
                                    </div>
                                </div>
                            </c:when>
                            <c:when test="${testing.testingType == 2}">
                                <div class="swiper-slide" data-bgm="${testing.questionSound}">
                                    <p class="question_tit">${testing.title}</p>

                                    <div class="box01 text" >
                                        <P onclick="make_sound('${testing.questionSound}');" style="cursor: pointer">${testing.questionText}</p>
                                    </div>
                                    <div class="answer_list" id="shuffle-${status.count}">
                                        <a href="javascript:;" data-code="1" data-point="${testing.point}"><img src="${testing.answerTextAndImageUrl}" alt=""/></a>
                                        <a href="javascript:;" data-code="0" data-point="${testing.point}"><img src="${testing.errorTextAndImageUrl1}" alt=""/></a>
                                        <a href="javascript:;" data-code="0" data-point="${testing.point}"><img src="${testing.errorTextAndImageUrl2}" alt=""/></a>
                                        <a href="javascript:;" data-code="0" data-point="${testing.point}"><img src="${testing.errorTextAndImageUrl3}" alt=""/></a>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="swiper-slide" data-bgm="${testing.questionImageSound1}">
                                    <p class="question_tit">${testing.title}</p>

                                    <div class="box01">
                                        <img src="${testing.questionImage1}" onclick="make_sound('${testing.questionImageSound1}');" alt="" style="cursor: pointer;max-height: 351px; width: 100%;"/>
                                    </div>
                                    <div class="answer_list answer" id="shuffle-${status.count}">
                                        <a href="javascript:;" data-code="1" data-point="${testing.point}">${testing.answerTextAndImageUrl}</a>
                                        <a href="javascript:;" data-code="0" data-point="${testing.point}">${testing.errorTextAndImageUrl1}</a>
                                        <a href="javascript:;" data-code="0" data-point="${testing.point}">${testing.errorTextAndImageUrl2}</a>
                                        <a href="javascript:;" data-code="0" data-point="${testing.point}">${testing.errorTextAndImageUrl3}</a>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </div>
            </div>
            <!-- //문제지 -->
        </div>
    </div>
</div>

<%@include file="../layout/training_footer.jsp" %>
<script>
    // document ready
    window.onload = function () {
        // 페이지 완전 로딩후 실행
        for (let i = 1; i <= ${Testings.size()}; i++) {
            let target = document.getElementById("shuffle-" + i);
            shuffleHtml(target.children);
        }
    }
    const shuffleHtml = array => {
        for (let i = 0; i < array.length; i++) {
            let j = Math.floor(Math.random() * (i + 1));
            const x = array[i].innerHTML;
            array[i].innerHTML = array[j].innerHTML;
            array[j].innerHTML = x;

            const y = array[i].getAttribute("data-code");
            array[i].setAttribute("data-code", array[j].getAttribute("data-code"));
            array[j].setAttribute("data-code", y);
        }
        return array;
    };

    //사용자함수 - 스와이퍼 다음으로 넘기기
    function slideToNext(swp) {
        var swiper = swp;
        if (swiper.isEnd) {
            // alert("테스트 결과 페이지로 이동 or 결과노출");
            post_to_url("/training/test/${testingMenuId}/result", {
                paramData: JSON.stringify(jsonArray),
                pointSum: pointSum,
            });
        } else {
            swiper.slideNext();
        }
    }

    //객체 - 전체 스와이퍼
    var swpTest = new Swiper("#swp_test", {
        allowTouchMove: false,
        speed: 800
    });
    swpTest.on("slideChangeTransitionEnd", function () {
        $(".cnt .current_p").html(swpTest.realIndex + 1);
        var currentSlide = swpTest.$wrapperEl.find(".swiper-slide-active");
        currentSlide.addClass("animated");

        if (currentSlide.data("bgm")) {
            console.log(currentSlide.data("bgm"));
            if (currentSlide.data("repeat")) {
                make_sound(currentSlide.data("bgm"), currentSlide.data("repeat"));
            } else {
                make_sound(currentSlide.data("bgm"));
            }
        }
    });

    //이벤트 - 정답선택
    //20210216 추가 수정 - s
    var pointSum = 0;
    var jsonArray = new Array();

    var errorCnt = 0;
    $(document).on("click", ".test_wrap .test_templete .answer_list > a", function () {
        let code = $(this).data("code");
        let point = $(this).data("point");
        let resultJson = new Object();
        switch (code) {
            case 1:
                pointSum += point;
                // document.getElementById('pointSum').innerHTML = pointSum

                resultJson.point = Number(point);
                resultJson.answerType = "1";
                jsonArray.push(resultJson);

                $(this).addClass("active");
                break;
            case 0:
                errorCnt++;
                $(".test_wrap .inner .top_box dl dd strong").html(errorCnt);

                resultJson.point = Number(point);
                resultJson.answerType = "0";
                jsonArray.push(resultJson);
                break;
        }
        slideToNext(swpTest);
    });

    function post_to_url(path, params) {
        var method = "post"; // 전송 방식 기본값을 POST로


        var form = document.createElement("form");
        form.setAttribute("method", method);
        form.setAttribute("action", path);

        //히든으로 값을 주입시킨다.
        for (var key in params) {
            var hiddenField = document.createElement("input");
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", key);
            hiddenField.setAttribute("value", params[key]);

            form.appendChild(hiddenField);
        }

        document.body.appendChild(form);
        form.submit();
    }

</script>
