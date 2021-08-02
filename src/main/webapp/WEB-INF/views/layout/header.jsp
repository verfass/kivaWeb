<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <link href="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.15/jquery.bxslider.min.css" rel="stylesheet"/>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta.2/css/bootstrap.css'>
    <link rel="stylesheet" type="text/css" href="/css/animate.css">
    <link rel="stylesheet" type="text/css" href="/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>메타에듀</title>
</head>

<body>
<div class="wrap">
    <header>
        <a href="/" class="logo"><img src="/images/logo.png"></a>
        <nav class='header-nav'>
            <ul class="ul1">
                <li class="${ptName == 'menu1'? 'active' : ''}">
                    <a href='/auth/menu/1'>
                        메타에듀소개
                    </a>
                </li>
                <li class="${ptName == 'menu2-1' or ptName == 'menu2-2' ? 'active' : ''}">
                    <a href='/auth/menu/2-1'>
                        프로그램
                    </a>
                </li>
                <li class="${ptName == 'menu3' ? 'active' : ''}">
                    <a href='/auth/menu/3'>
                        MTS-어학기
                    </a>
                </li>
                <li class="${ptName == 'notice' ? 'active' : ''}">
                    <a href='/auth/boardGroup/notice'>
                        공지사항
                    </a>
                </li>
                <li>
                    <a href='http://down.metaedu-app.co.kr/' style="color: #1b75bb">
                        앱다운로드
                    </a>
                </li>
                <sec:authorize access="isAuthenticated()">
                    <li class="${ptName == 'board' ? 'active' : ''}">
                        <a href='/boardGroup/2'>
                            게시판
                        </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGER','ROLE_TEACHER','ROLE_KINDERGARTEN')">
                    <li class="${ptName == 'studyRoom'? 'active' : ''}">
                        <a href='/study' class="or-a">
                            학습관
                        </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="${ptName == 'branch'? 'active' : ''}">
                        <a href='/menu/branch' class="or-a"> ${principal.user.role.roleType.viewName}용 </a>
                    </li>
                </sec:authorize>
            </ul>
        </nav>
        <div class="login-box">
            <sec:authorize access="isAnonymous()">
                <div class="">
                    <a href="/auth/user/login" class="login">로그인</a>
                    <a href="/auth/user/join" class="join">회원가입</a>
                </div>
            </sec:authorize>
            <diV class="loi-aft">
                <sec:authorize access="isAuthenticated()">
                    <p>
                        <span>${principal.user.userName}</span>(${principal.user.role.roleType.viewName}) 님
                        환영합니다.
                        <img src="/images/login_06.png">
                    </p>
                    <div class="sub-box none">
                        <ul>
                            <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGER','ROLE_KINDERGARTEN')">
                                <li><a href="https://admin.metaedu.kr/">관리자</a></li>
                            </sec:authorize>
                            <li><a href="/user/updatePassForm">비밀번호 변경</a></li>
                            <li><a href="/logout">로그아웃</a></li>
                        </ul>
                    </div>
                </sec:authorize>
            </diV>
        </div>
        <p class="call-txt"><img src="/images/call-hed_03.png">1577-3047</p>
    </header>
    <div class="modil-menu">
        <a href="/" class="mo-logo"><img src="/images/logo.png"></a>
        <div id="nav-icon3">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>

        <nav class="nav-right" id="cbp-spmenu-s2">
            <sec:authorize access="isAuthenticated()">
                <div>
                    <p class="login-name "><span>${principal.user.userName}</span>(${principal.user.role.roleType.viewName}) 님 환영합니다.</p>
                </div>
            </sec:authorize>
            <div>
                <sec:authorize access="isAnonymous()">
                    <a href="/auth/user/login" class="login">로그인</a>
                    <a href="/auth/user/join" class="join">회원가입</a>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <a href="/logout" class="login">로그아웃</a>
                </sec:authorize>
            </div>
            <ul class="mo">
                <li>
                    <a href='/auth/menu/1'>
                        메타에듀소개
                    </a>
                </li>
                <li>
                    <a href='/auth/menu/2-1'>
                        프로그램
                    </a>
                </li>
                <li>
                    <a href='/auth/menu/3'>
                        MTS-어학기
                    </a>
                </li>
                <li>
                    <a href='/auth/boardGroup/notice'>
                        공지사항
                    </a>
                </li>
                <li>
                    <a href='http://down.metaedu-app.co.kr/' style="color: #4CAF50">
                        앱다운로드
                    </a>
                </li>
                <sec:authorize access="isAuthenticated()">
                    <li class="">
                        <a href='/boardGroup/2'>
                            게시판
                        </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGER','ROLE_TEACHER','ROLE_KINDERGARTEN')">
                    <li class="">
                        <a href='/study' class="or-a">
                            학습관
                        </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="">
                        <a href='/menu/branch' class="or-a">
                                ${principal.user.role.roleType.viewName}용
                        </a>
                    </li>
                </sec:authorize>
            </ul>
        </nav>
    </div>
<%--</div>--%>