<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>
<img src="/images/img4_02.jpg" class="sub-bg">
<div class="sub-head">
    <div class="wid1480">
        <ul class="sub-ul">
            <li class="home"><a href="/"><img src="/images/img4_05.png"></a></li>
            <li class="pp-li pp-li2">게시판 <img src="/images/img4_08.png">
                <ul class="none">
                    <li><a href=""></a></li>
                </ul>
            </li>

        </ul>
    </div>

</div>

<div class="wid1480 contentBox">
    <div class="left-menu">
        <p class="left-title">게시판</p>
        <img src="/images/call.png" class="call-img">
    </div>

    <div class="right-box">
        <h4 class="sub-h4">${board.boardGroup.groupName}</h4>

        <div class="title-box">
            <p class="title">${board.boardTitle}</p>
            <p class="title-sub">메타에듀 관리자
                <fmt:parseDate value="${ board.modDate }" pattern="yyyy-mm-dd'T'HH:mm" var="parsedDateTime" type="both"/>
                <span class="date"><fmt:formatDate value="${ parsedDateTime }" pattern="yyyy-MM-dd"/></span>
            </p>
        </div>
        <div class="con-box">
            <c:forEach var="file" items="${board.boardFiles}">
                <p><img src="/images/down_03.png">
                    <a class="down-btn" href="javascript:fileDown( '${file.originalName}','${file.filePath}')">${file.originalName}</a>
                </p>
            </c:forEach>
            <div class="txt-box">
                ${board.boardContent}
            </div>
        </div>
        <div class="me5sub-btn">
            <a href="/boardGroup/${board.boardGroup.groupId}">목록</a>
        </div>
    </div>
</div>
<script>
    function fileDown(originalName, filePath){
        let link = encodeURI('/download/outer?orginlFilenm='+originalName+'&streFlpth='+filePath);
        location.href = link;
    }
</script>
<%@include file="../layout/footer.jsp" %>
</html>