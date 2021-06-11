<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
        <div class="bg-img _sub1">
            <img src="/images/language/bubble/a/sbg.jpg">
            <!-- <img src="/images/language/bubble/b/sbg.jpg"> -->
        </div>
        <p class="ab"><img src="/images/language/bubble/${type == 'ba' ? 'A':'B'}.png"></p>
        <h1 class="bubble-title"><img src="/images/language/bubble/title${bookNum}.png"></h1>
        <div class="bubble-subbox">
            <c:forEach var="CategoryMenu" items="${CategoryMenus}" varStatus="status">
                <c:if test="${status.index % 5 == 0}">
                    <ul>
                    <li><img src="/images/language/bubble/week${CategoryMenu.category.categoryId}.png"></li>
                </c:if>
                <li><a href="${CategoryMenu.fileUrl}"><img src="/images/language/bubble/${fn:toLowerCase(CategoryMenu.menuName)}.png"></a></li>
                <c:if test="${status.index % 5 == 4}">
                    </ul>
                </c:if>

            </c:forEach>
        </div>
    </c:if>


    <c:if test="${type == 'ka' or type == 'kb' or type == 'kc'}">
        <div class="kiva-bg-img">
            <c:if test="${type == 'ka'}">
                <img src="/images/language/kiva/a/bg_sub.jpg">
            </c:if>
            <c:if test="${type == 'kb'}">
                <img src="/images/language/kiva/b/bg_sub.jpg">
            </c:if>
            <c:if test="${type == 'kc'}">
                <img src="/images/language/kiva/c/bg_sub.jpg">
            </c:if>
        </div>
        <h1 class="book-h1"><img src="/images/language/kiva/title${bookNum}.png"></h1>
        <ul class="book-Nlist">
            <li>
                <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="20" end="23" varStatus="status">
                    <a href="${CategoryMenu.fileUrl}" class="chapter chapter1"><img src="/images/language/kiva/btn_${fn:toLowerCase(CategoryMenu.menuName)}.png"></a>
                </c:forEach>
            </li>
            <li>
                <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="24" end="27" varStatus="status">
                    <a href="${CategoryMenu.fileUrl}" class="chapter chapter2"><img src="/images/language/kiva/btn_${fn:toLowerCase(CategoryMenu.menuName)}.png"></a>
                </c:forEach>
            </li>
            <li>
                <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="28" end="31" varStatus="status">
                    <a href="${CategoryMenu.fileUrl}" class="chapter chapter3"><img src="/images/language/kiva/btn_${fn:toLowerCase(CategoryMenu.menuName)}.png"></a>
                </c:forEach>
            </li>
            <li>
                <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="32" end="35" varStatus="status">
                    <a href="${CategoryMenu.fileUrl}" class="chapter chapter4"><img src="/images/language/kiva/btn_${fn:toLowerCase(CategoryMenu.menuName)}.png"></a>
                </c:forEach>
            </li>
            <li>
                <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="36" end="39" varStatus="status">
                    <a href="${CategoryMenu.fileUrl}" class="chapter chapter5"><img src="/images/language/kiva/btn_${fn:toLowerCase(CategoryMenu.menuName)}.png"></a>
                </c:forEach>
            </li>
            <li>
                <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="40" end="43" varStatus="status">
                    <a href="${CategoryMenu.fileUrl}" class="chapter chapter6"><img src="/images/language/kiva/btn_${fn:toLowerCase(CategoryMenu.menuName)}.png"></a>
                </c:forEach>
            </li>
        </ul>
        <c:forEach var="CategoryMenu" items="${CategoryMenus}" end="19" varStatus="status">
            <c:if test="${status.index % 5 == 0}">
                <ul class="week week${CategoryMenu.category.categoryId}">
                <li>
                    <img src="/images/language/kiva/kiva-week_${CategoryMenu.category.categoryId}.png">
                </li>
            </c:if>
            <li><a href="${CategoryMenu.fileUrl}"><img src="/images/language/kiva/kiva-abookbtn_${fn:toLowerCase(CategoryMenu.menuName)}.png"></a></li>
            <c:if test="${status.index % 5 == 4}">
                </ul>
            </c:if>
        </c:forEach>
    </c:if>
    <c:if test="${type == 'ma' or type == 'mb' or type == 'mc'}">
        <div class="bg-img">
            <c:if test="${type == 'ma'}">
                <img src="/images/language/meta/a/bg_sub.jpg">
            </c:if>
            <c:if test="${type == 'mb'}">
                <img src="/images/language/meta/b/bg_sub.jpg">
            </c:if>
            <c:if test="${type == 'mc'}">
                <img src="/images/language/meta/c/bg_sub.jpg">
            </c:if>
        </div>
        <div class="meta-title">
            <c:if test="${type == 'ma'}">
                <img src="/images/language/meta/a/title_bg.png">
            </c:if>
            <c:if test="${type == 'mb'}">
                <img src="/images/language/meta/b/title_bg.png">
            </c:if>
            <c:if test="${type == 'mc'}">
                <img src="/images/language/meta/c/title_bg.png">
            </c:if>
            <h1 class="title1"><img src="/images/language/meta/title_${bookNum}.png"></h1>
        </div>

        <div class="mate-leftBox">
            <ul>
                <li class="ggg"><img src="/images/language/meta/learn1.png"></li>
                <li>
                    <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="20" end="23" varStatus="status">
                        <a href="${CategoryMenu.fileUrl}"><img src="/images/language/meta/btn${CategoryMenu.menuName.charAt(0)}.png"></a>
                    </c:forEach>
                </li>
                <li class="ggg"><img src="/images/language/meta/learn2.png"></li>
                <li>
                    <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="24" end="27" varStatus="status">
                        <a href="${CategoryMenu.fileUrl}"><img src="/images/language/meta/btn${CategoryMenu.menuName.charAt(0)}.png"></a>
                    </c:forEach>
                </li>
                <li class="ggg"><img src="/images/language/meta/learn3.png"></li>
                <li>
                    <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="28" end="31" varStatus="status">
                        <a href="${CategoryMenu.fileUrl}"><img src="/images/language/meta/btn${CategoryMenu.menuName.charAt(0)}.png"></a>
                    </c:forEach>
                </li>
                <li class="ggg"><img src="/images/language/meta/learn4.png"></li>
                <li>
                    <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="32" end="35" varStatus="status">
                        <a href="${CategoryMenu.fileUrl}"><img src="/images/language/meta/btn${CategoryMenu.menuName.charAt(0)}.png"></a>
                    </c:forEach>
                </li>
                <li class="ggg"><img src="/images/language/meta/learn5.png"></li>
                <li>
                    <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="36" end="39" varStatus="status">
                        <a href="${CategoryMenu.fileUrl}"><img src="/images/language/meta/btn${CategoryMenu.menuName.charAt(0)}.png"></a>
                    </c:forEach>
                </li>
            </ul>
        </div>

        <div class="meta-rightBox">
            <c:forEach var="CategoryMenu" items="${CategoryMenus}" end="4" varStatus="status">
                <c:if test="${status.index % 5 == 0}">
                    <ul>
                    <li><img src="/images/language/meta/week${CategoryMenu.category.categoryId}.png"></li>
                </c:if>
                <li><a href="${CategoryMenu.fileUrl}"><img src="/images/language/meta/${fn:toLowerCase(CategoryMenu.menuName)}_y.png"></a></li>
                <c:if test="${status.index % 5 == 4}">
                    </ul>
                </c:if>
            </c:forEach>
            <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="5" end="9" varStatus="status">
                <c:if test="${status.index % 5 == 0}">
                    <ul>
                    <li><img src="/images/language/meta/week${CategoryMenu.category.categoryId}.png"></li>
                </c:if>
                <li><a href="${CategoryMenu.fileUrl}"><img src="/images/language/meta/${fn:toLowerCase(CategoryMenu.menuName)}_g.png"></a></li>
                <c:if test="${status.index % 5 == 4}">
                    </ul>
                </c:if>
            </c:forEach>
            <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="10" end="14" varStatus="status">
                <c:if test="${status.index % 5 == 0}">
                    <ul>
                    <li><img src="/images/language/meta/week${CategoryMenu.category.categoryId}.png"></li>
                </c:if>
                <li><a href="${CategoryMenu.fileUrl}"><img src="/images/language/meta/${fn:toLowerCase(CategoryMenu.menuName)}_y.png"></a></li>
                <c:if test="${status.index % 5 == 4}">
                    </ul>
                </c:if>
            </c:forEach>
            <c:forEach var="CategoryMenu" items="${CategoryMenus}" begin="15" end="19" varStatus="status">
                <c:if test="${status.index % 5 == 0}">
                    <ul>
                    <li><img src="/images/language/meta/week${CategoryMenu.category.categoryId}.png"></li>
                </c:if>
                <li><a href="${CategoryMenu.fileUrl}"><img src="/images/language/meta/${fn:toLowerCase(CategoryMenu.menuName)}_g.png"></a></li>
                <c:if test="${status.index % 5 == 4}">
                    </ul>
                </c:if>
            </c:forEach>
        </div>
    </c:if>


</div>

</body>
<script src="/js/common/jquery-3.5.1.min.js"></script>
</html>