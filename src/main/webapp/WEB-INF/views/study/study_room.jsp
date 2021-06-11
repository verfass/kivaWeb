<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/reset_study.css">
    <link rel="stylesheet" type="text/css" href="/css/style_study.css">

    <title>메타에듀</title>
</head>
<body>
<c:choose>
    <c:when test="${parentId == 3 || parentId == 6}">
<div class="or-bg">
    </c:when>
    <c:when test="${parentId == 5 || parentId == 8}">
<div class="b-bg">
    </c:when>
    <c:otherwise>
<div class="gr-bg">
    </c:otherwise>
</c:choose>
    <div class="wrapper">
        <h1>
            <c:choose>
                <c:when test="${parentId == 1}">
                    <span>3세</span>
                </c:when>
                <c:when test="${parentId == 2}">
                    <span>4세</span>
                </c:when>
                <c:when test="${parentId == 3 || parentId == 6}">
                    <span>5세</span>
                </c:when>
                <c:when test="${parentId == 4 || parentId == 7}">
                    <span>6세</span>
                </c:when>
                <c:when test="${parentId == 5 || parentId == 8}">
                    <span>7세</span>
                </c:when>
            </c:choose>
            <div class="close-box">
                <a href="/study">닫기<img src="/images/study/close_03.png"></a>
            </div>
        </h1>

        <div class="top-box">
            <ul>
                <li>학습순서</li>
                <li><img src="/images/study/img_10.png"></li>
                <li><img src="/images/study/img_12.png"></li>
                <li><img src="/images/study/img_14.png"></li>
                <li><img src="/images/study/img_16.png"></li>
            </ul>
            <select class="sel1" onchange="monthChange(this)">
                <c:forEach begin="1" end="12" varStatus="status">
                    <option value="${status.index}" ${status.index == selectMonth ? 'selected':''}>${status.index}</option>
                </c:forEach>
            </select>
        </div>
        <c:choose>
            <c:when test="${parentId == 1 || parentId == 2}"> <%-- 3 ~ 4 세--%>
                <div class="in-fffbox">
                    <div>
                        <p class="b-txt">멀티교재 리스트</p>
                        <div class="box">
                            <p class="box-title">Story</p>
                            <ul class="ul2 ">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 1}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div>
                        <p class="b-txt">스피킹</p>
                        <div class="box box50 box box-marR">
                            <p class="box-title">Bubble Talk</p>
                            <ul class="ul2">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 2}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>

                        <div class="box50 box">
                            <p class="box-title">단어 스피킹</p>
                            <ul class="ul2">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 3}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div>
                        <p class="b-txt">Phonics</p>
                        <div class="box box50 box box-marR">
                            <p class="box-title">Phonics Weekly</p>
                            <ul class="ul2">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 4}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>

                        <div class="box50 box">
                            <p class="box-title">Phonics Speaking</p>
                            <ul class="ul2">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 5}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>


                    <div>
                        <div class="box">
                            <p class="box-title">디지털 교재</p>
                            <ul class="ul2">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 6}">
                                        <li>
                                            <a href="javascript:fileDown( '${studyRoom.linkAndFileText}','${studyRoom.linkAndFileUrl}') ">
                                                <img src="/images/study/file_1.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div>
                        <p class="b-txt">Youtube</p>
                        <div class="box">
                            <ul class="ul2">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 7}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/youtubu_1.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:when test="${parentId == 3 || parentId == 4 || parentId == 5 || parentId == 6 || parentId == 7 || parentId == 8}">  <%-- 5 ~ 7 세--%>


                <div class="in-fffbox">
                    <div>
                        <p class="b-txt">Sing & Song</p>
                        <div class="box50 box box-marR">
                            <p class="box-title">Kiva Song</p>
                            <ul>
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 8}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/song_week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>

                        <div class="box50 box">
                            <p class="box-title">Singing Room</p>
                            <ul>
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 9}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/song_week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div>
                        <p class="b-txt">Conversation</p>
                        <div class="box">
                            <p class="box-title">Conversation</p>
                            <ul class="ul2">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 10}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div>
                        <div class="box">
                            <p class="box-title">동시통역</p>
                            <ul class="ul3 ul3-mr">
                                <li>
                                    <span class="gray-sp">한 <img src="/images/study/img_53.png"> 영</span>
                                </li>
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 11}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>

                            </ul>

                            <ul class="ul3">
                                <li>
                                    <span class="gray-sp">영 <img src="/images/study/img_53.png"> 한</span>
                                </li>
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 12}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div>
                        <p class="b-txt">Phonics</p>
                        <div class="box">
                            <p class="box-title">Phonics</p>
                            <ul class="ul2">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 13}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div>
                        <div class="box">
                            <p class="box-title">스피드 스피킹</p>
                            <ul class="ul2">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 14}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div>
                        <div class="box">
                            <p class="box-title">파닉스 누적읽기</p>
                            <ul class="ul2">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 15}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/week_${studyRoom.week}.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div>
                        <div class="box">
                            <p class="box-title">디지털 교재</p>
                            <ul class="ul2">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 6}">
                                        <li>
                                            <a href="javascript:fileDown( '${studyRoom.linkAndFileText}','${studyRoom.linkAndFileUrl}') ">
                                                <img src="/images/study/file_1.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div>
                        <p class="b-txt">Youtube</p>
                        <div class="box">
                            <ul class="ul2">
                                <c:forEach var="studyRoom" items="${studyRooms}">
                                    <c:if test="${studyRoom.studyType == 7}">
                                        <li>
                                            <a href="${studyRoom.linkAndFileUrl}">
                                                <img src="/images/study/youtubu_1.png">
                                                <p>${studyRoom.linkAndFileText}</p>
                                            </a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </c:when>
        </c:choose>

    </div>
</div>
</body>
<script>
    function monthChange(el) {
        console.log(el.value)

        location.href = "/study/menu/${parentId}?month=" + el.value

    }

    function fileDown(originalName, filePath) {
        let link = encodeURI('/download/outer?orginlFilenm=' + originalName + '&streFlpth=' + filePath);
        location.href = link;
    }
</script>

<%@include file="../layout/study_room_footer.jsp" %>