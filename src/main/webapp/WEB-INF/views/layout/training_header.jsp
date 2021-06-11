<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Referrer" content="origin">
    <meta name="description" content="kiva learning test">
    <meta http-equiv="Content-Script-Type" content="text/javascript">
    <meta http-equiv="Content-Style-Type" content="text/css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=1, minimum-scale=1, maximum-scale=1">
    <title>메타에듀</title>

    <link rel="stylesheet" href="http://www.internetenglish.co.kr/bookstudy/kivastudent/drag/css/style-p5.css">
    <link rel="stylesheet" href="http://www.internetenglish.co.kr/bookstudy/kivastudent/drag/css/divpopup.css">
    <link rel="stylesheet" href="/outer/training/css/swiper.min.css">
    <link rel="stylesheet" href="/outer/training/css/common.css">
</head>
<body>