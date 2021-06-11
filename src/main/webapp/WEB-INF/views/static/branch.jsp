<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>

<div class="bu-bg">
    <ul class="btn_zon">
        <%--지사용, 관리자--%>
        <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')">
        <li class="grow-rotate"><a href="https://admin.metaedu.kr/"><img src="/images/branch01.png" alt="원관리"></a></li>
        <li class="grow-rotate"><a href="https://admin.metaedu.kr/"><img src="/images/branch02.png" alt="강사관리"></a></li>
        <li class="grow-rotate"><a href="/language"><img src="/images/branch03.png" alt="어학기영상"></a></li>
        <li class="grow-rotate"><a href="/boardGroup/2"><img src="/images/branch04.png" alt="게시판"></a></li>
        </sec:authorize>

        <%-- 강사용, 기관용--%>
        <sec:authorize access="hasAnyRole('ROLE_TEACHER','ROLE_KINDERGARTEN')">
        <li class="grow-rotate"><a href="/language"><img src="/images/teacher01.png" alt="어학기영상"></a></li>
        <li class="grow-rotate"><a href="/study"><img src="/images/teacher02.png" alt="학습관"></a></li>
        <li class="grow-rotate"><a href="/boardGroup/2"><img src="/images/teacher03.png" alt="게시판"></a></li>
        </sec:authorize>
    </ul>
</div>

<%@include file="../layout/footer.jsp" %>
</html>