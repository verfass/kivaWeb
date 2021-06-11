<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메타에듀</title>

    <link rel="stylesheet" type="text/css" href="/css/animate_testing.css">
    <link rel="stylesheet" type="text/css" href="/css/reset_testing.css">
    <link rel="stylesheet" type="text/css" href="/css/style_testing.css">
    <style>
        body {
            background: #ffdb3d;
        }
    </style>

</head>
<body>

<div class="wrapper">

    <div class="result-box1">
        <button type="button" class="blue" onclick="location.href='/training/test/${testingMenuId}'">다시 도전하기</button>
        <button type="button" class="green" onclick="pointSave()">테스트 저장하기</button>
        <button type="button" class="orange" onclick="location.href='/menu/branch'">홈으로</button>
        <p style="margin-top: 40px;"><span>${pointSum}</span>점</p>
    </div>

    <div class="box result-box2">
        <ul>
            <c:forEach begin="0" end="2" varStatus="status">
                <c:choose>
                    <c:when test="${status.count <= preTestingResults.size()}">
                        <c:set var="point">${ preTestingResults.get(status.index).resultPoint}점</c:set>
                        <li>
                            <p>${status.count}차 테스트</p>
                            <p id="point_${status.count}" class="b-25">${point}</p>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li>
                            <p>${status.count}차 테스트</p>
                            <p id="point_${status.count}" class="b-25">-</p>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

<%--            <li>--%>
<%--                <p>1차 테스트</p>--%>
<%--                <p class="b-25">${preTestingResults.get(0).resultPoint == null ? "-": preTestingResults.get(0).resultPoint+"점"}</p>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <p>2차 테스트</p>--%>
<%--                <p class="b-25">${preTestingResults.get(1).resultPoint == null ? "-": preTestingResults.get(1).resultPoint+"점"}</p>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <p>1차 테스트</p>--%>
<%--                <p class="b-25">${preTestingResults.get(2).resultPoint == null ? "-": (preTestingResults.get(2).resultPoint)+"점"}</p>--%>
<%--            </li>--%>
        </ul>
    </div>

    <div class="box mt-30">
        <table class="table re-table">
            <c:forEach var="testingResult" items="${testingResults}" varStatus="status">
                <c:if test="${status.index % 5 == 0}">
                <tr>
                </c:if>
                    <c:choose>
                        <c:when test="${testingResult.answerType == 1}">
                            <td>
                                <p><span class="sky-cc">문제${status.count}</span></p>
                                <p>O / 배점:${testingResult.point}</p>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td>
                                <p><span class="sky-cc red-cc">문제${status.count}</span></p>
                                <p>X / 배점:${testingResult.point}</p>
                            </td>
                        </c:otherwise>
                    </c:choose>
                <c:if test="${status.index % 5 == 4 || testingResults.size() == status.index}">
                </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>

</div>

</body>
<script src="/js/common/jquery-3.5.1.min.js"></script>
<script>
    function pointSave(){
        let data = {
            'resultPoint' : ${pointSum},
            'menuId' : ${testingMenuId}
        }
        console.log(data)
        $.ajax({
            type: "POST",
            url: "/training/testingResult",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            if (resp.statusCode === 200) {
                alert("점수저장이 완료되었습니다.");
                document.getElementById('point_'+resp.data).innerText = ${pointSum};
            } else {
                alert(resp.data);
            }
        }).fail(function (error) {
            alert("입력에러")
            // alert(JSON.stringify(error));
        })
    }
</script>

</html>

