<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>
<img src="/images/img4_02.jpg" class="sub-bg">

<div class="sub-head">
    <div class="wid1480">
        <ul class="sub-ul">
            <li class="home"><a href="/"><img src="/images/img4_05.png"></a></li>
            <li class="pp-li pp-li2">공지사항</li>
        </ul>
    </div>
</div>

<div class="wid1480 contentBox">
    <div class="left-menu">
        <p class="left-title">공지사항</p>
        <img src="/images/call.png" class="call-img">
    </div>
    <div class="right-box">
        <form action="/auth/boardGroup/notice" method="GET">
        <h4 class="sub-h4">공지사항
            <div class="search-box">
                <input type="text" class="search" name="searchText" value="${param.searchText}" placeholder="검색어를 입력해주세요.">
                <button type="submit" class="btn-000">검색</button>
            </div>
        </h4>
        </form>
        <table class="table1 noti-tb">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>날짜</th>
            </tr>
            <c:forEach var="board" items="${boardList.content}">
            <tr onclick="location.href='/auth/boardGroup/notice/${board.boardId}' ">
                <td>${board.boardId}</td>
                <td>${board.boardTitle}</td>
                <td>관리자</td>
                <fmt:parseDate value="${ board.regDate }" pattern="yyyy-mm-dd'T'HH:mm" var="parsedDateTime" type="both"/>
                <td> <fmt:formatDate value="${ parsedDateTime }" pattern="yyyy-MM-dd"/>  </td>
            </tr>
            </c:forEach>

        </table>
        <!-- 페이징 영역 시작 -->
        <div class="text-xs-center mt-5">
            <ul class="pagination justify-content-center">
                <!-- 이전 -->
                <c:choose>
                    <c:when test="${pageInfo.first}"></c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="?searchText=${param.searchText}&page=0">처음</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="?searchText=${param.searchText}&page=${pageInfo.pageNumber-1}">&larr;</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <!-- 페이지 그룹 -->
                <c:forEach begin="${pageInfo.startBlockPage}" end="${pageInfo.endBlockPage}" var="i">
                    <c:choose>
                        <c:when test="${pageInfo.pageNumber+1 == i}">
                            <li class="page-item disabled">
                                <a class="page-link" href="?searchText=${param.searchText}&page=${i-1}">
                                        ${i}
                                </a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a class="page-link" href="?searchText=${param.searchText}&page=${i-1}">
                                        ${i}
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <!-- 다음 -->
                <c:choose>
                    <c:when test="${pageInfo.last}"></c:when>
                    <c:otherwise>
                        <li class="page-item ">
                            <a class="page-link" href="?searchText=${param.searchText}&page=${pageInfo.pageNumber+1}">
                                &rarr;
                            </a>
                        </li>
                        <li class="page-item ">
                            <a class="page-link" href="?searchText=${param.searchText}&page=${pageInfo.totalPages-1}">
                                마지막
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <!-- 페이징 영역 끝 -->
    </div>
</div>
<%@include file="../layout/footer.jsp" %>
</html>