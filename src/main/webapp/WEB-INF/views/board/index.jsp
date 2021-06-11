<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>
<div class="container">
    <c:forEach var="board" items="${boardList.content}">
        <div class="card m-2">
            <div class="card-body">

                    ${ board.modDate }
                <h4 class="card-title"> <c:out value='${board.title}'/></h4>
                <a href="/board/${board.id}" class="btn btn-primary">상세 보기</a>
            </div>
        </div>
    </c:forEach>
    <ul class="pagination justify-content-center">
        <li class="page-item ${boardList.first ? 'disabled':''}"><a class="page-link" href="?page=${boardList.number-1}">Previous</a></li>
        <li class="page-item ${boardList.last ? 'disabled':''}"><a class="page-link" href="?page=${boardList.number+1}">Next</a></li>
    </ul>
</div>
<%@include file="../layout/footer.jsp" %>