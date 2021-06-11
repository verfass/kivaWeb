<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="/css/language/reset.css">
    <c:if test="${type == 'ba' or type == 'bb'}">
        <link type="text/css" rel="stylesheet" href="/css/language/style_bubble.css">
    </c:if>
    <c:if test="${type == 'ka' or type == 'kb' or type == 'kc'}">
        <link type="text/css" rel="stylesheet" href="/css/language/style_kiva.css">
    </c:if>
    <c:if test="${type == 'ma' or type == 'mb' or type == 'mc'}">
        <link type="text/css" rel="stylesheet" href="/css/language/style_meta.css">
    </c:if>
    <title>어학기 영상</title>
</head>
<body>
<div class="wrap">
    <c:if test="${type == 'ba' or type == 'bb'}">
        <div class="bg-img">
            <c:if test="${type == 'ba'}">
                <img src="/images/language/bubble/a/mbg.jpg">
            </c:if>
            <c:if test="${type == 'bb'}">
                <img src="/images/language/bubble/b/bg.png">
            </c:if>
        </div>
    </c:if>

    <c:if test="${type == 'ma' or type == 'mb' or type == 'mc'}">
        <div class="bg-img">
            <c:if test="${type == 'ma'}">
                <img src="/images/language/meta/a/bg_main.jpg">

            </c:if>
            <c:if test="${type == 'mb'}">
                <img src="/images/language/meta/b/bg_main.jpg">
            </c:if>
            <c:if test="${type == 'mc'}">
                <img src="/images/language/meta/c/bg_main.jpg">
            </c:if>
        </div>
    </c:if>

    <c:if test="${type == 'ba' or type == 'bb'}">
        <a class="close" href="/"><img src="/images/language/bubble/close.png"></a>
        <a class="home" href="/language"><img src="/images/language/bubble/home.png">
        </a>
        <!-- <a href="" class="youtube"><img src="/images/language/youtube.png"></a> -->
        <div class="bubble-box">
            <ul>
                <c:forEach var="SubMenu" items="${SubMenus}">
                    <li><a href="/language/parent/${SubMenu.parentId}/menu/${SubMenu.menuId}/${type}/${SubMenu.menuName}"><img src="/images/language/bubble/${SubMenu.menuName}.png"></a></li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <c:if test="${type == 'ka' or type == 'kb' or type == 'kc'}">

        <div class="kiva-bg-img">
            <c:if test="${type == 'ka'}">
                <img src="/images/language/kiva/a/kiva-aBG.png">
            </c:if>
            <c:if test="${type == 'kb'}">
                <img src="/images/language/kiva/b/kiva-bBG.png">
            </c:if>
            <c:if test="${type == 'kc'}">
                <img src="/images/language/kiva/c/kiva-cBG.png">
            </c:if>
        </div>

        <div class="balloon">
            <img src="/images/language/kiva/kiva-a_03.png" class="balloon-img">
        </div>
        <div class="cloud">
            <img src="/images/language/kiva/kiva-a_06.png">
        </div>
        <div class="cloud2">
            <img src="/images/language/kiva/kiva-a_12.png">
        </div>

        <a href="/" class="close"><img src="/images/language/kiva/close.png"></a>

        <div class="day-list">
            <ul>
                <c:forEach var="SubMenu" items="${SubMenus}">
                    <c:if test="${type == 'ka'}">
                        <li><a href="/language/parent/${SubMenu.parentId}/menu/${SubMenu.menuId}/${type}/${SubMenu.menuName}"><img src="/images/language/kiva/a/book${SubMenu.menuName}.png"></a></li>
                    </c:if>
                    <c:if test="${type == 'kb'}">
                        <li><a href="/language/parent/${SubMenu.parentId}/menu/${SubMenu.menuId}/${type}/${SubMenu.menuName}"><img src="/images/language/kiva/b/book${SubMenu.menuName}.png"></a></li>
                    </c:if>
                    <c:if test="${type == 'kc'}">
                        <li><a href="/language/parent/${SubMenu.parentId}/menu/${SubMenu.menuId}/${type}/${SubMenu.menuName}"><img src="/images/language/kiva/c/book${SubMenu.menuName}.png"></a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <c:if test="${ type == 'ma' or type == 'mb' or type == 'mc'}">
        <a href="/" class="close"><img src="/images/language/meta/close.png"></a>
        <div class="day-list">
            <ul>
                <c:forEach var="SubMenu" items="${SubMenus}" >
                    <c:if test="${type == 'ma'}">
                    <li><a href="/language/parent/${SubMenu.parentId}/menu/${SubMenu.menuId}/${type}/${SubMenu.menuName}"><img src="/images/language/meta/a/book${SubMenu.menuName}.png"></a></li>
                    </c:if>
                    <c:if test="${type == 'mb'}">
                        <li><a href="/language/parent/${SubMenu.parentId}/menu/${SubMenu.menuId}/${type}/${SubMenu.menuName}"><img src="/images/language/meta/b/book${SubMenu.menuName}.png"></a></li>
                    </c:if>
                    <c:if test="${type == 'mc'}">
                        <li><a href="/language/parent/${SubMenu.parentId}/menu/${SubMenu.menuId}/${type}/${SubMenu.menuName}"><img src="/images/language/meta/c/book${SubMenu.menuName}.png"></a></li>
                    </c:if>
                </c:forEach>
            </ul>
        </div>
    </c:if>

</div>
</body>
<script src="/js/common/jquery-3.5.1.min.js"></script>
</html>