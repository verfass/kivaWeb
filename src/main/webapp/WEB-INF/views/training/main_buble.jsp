<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../layout/training_header.jsp" %>

<div id="wrap">
    <div class="edu4_wrap"><!-- //prefix : edu4_wrap : 버블버블키즈 메인 -->
        <div class="inner">
<!--            /images/language/bubble/b/bg.png-->
            <h1 class="logo"><img src="/outer/training/img/login_bubble.png" alt="버블버블키즈" /></h1>
            <a href="/menu/branch" class="btn_home"><img src="/outer/training/img/btn_home.png" alt="" /></a>
            <a href="/" class="btn_close"><img src="/outer/training/img/btn_close.png" alt="" /></a>
            <a href="https://youtube.com/playlist?list=PL759_XpTlDUGadFwSwXONcy--umKDutm8" class="btn_youtube"><img src="/outer/training/img/btn_youtube.png" alt="" /></a>

            <ul class="category_menu">
                <c:forEach var="SubMenu" items="${SubMenus}">
                <li><a href="/training/parent/${SubMenu.menuId}/${grade}"><img src="/outer/training/img/bubble_menu0${SubMenu.menuName}.png" alt="${SubMenu.menuName}" /></a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<%@include file="../layout/training_footer.jsp" %>