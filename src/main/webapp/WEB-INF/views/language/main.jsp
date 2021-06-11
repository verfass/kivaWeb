<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="/css/language/reset.css">
    <link type="text/css" rel="stylesheet" href="/css/language/style_main.css">
    <title>어학기 영상</title>
</head>
<body>
<div class="wrap">
    <div class="main-box">
        <ul>
            <li><a href="/language/parent/${MainMenus[0].menuId}/ba"><img src="/images/language/main/bubble_A.png"></a></li>
            <li><a href="/language/parent/${MainMenus[1].menuId}/bb"><img src="/images/language/main/bubble_B.png"></a></li>
            <li><a href="/language/parent/${MainMenus[2].menuId}/ka"><img src="/images/language/main/kivaworld_A.png"></a></li>
            <li><a href="/language/parent/${MainMenus[3].menuId}/kb"><img src="/images/language/main/kivaworld_B.png"></a></li>
            <li><a href="/language/parent/${MainMenus[4].menuId}/kc"><img src="/images/language/main/kivaworld_C.png"></a></li>
            <li><a href="/language/parent/${MainMenus[5].menuId}/ma"><img src="/images/language/main/metakids_A.png"></a></li>
            <li><a href="/language/parent/${MainMenus[6].menuId}/mb"><img src="/images/language/main/metakids_B.png"></a></li>
            <li><a href="/language/parent/${MainMenus[7].menuId}/mc"><img src="/images/language/main/metakids_C.png"></a></li>
        </ul>
    </div>
</div>
</body>
<script src="/js/common/jquery-3.5.1.min.js"></script>
</html>