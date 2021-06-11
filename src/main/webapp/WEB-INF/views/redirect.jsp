<%--
  Created by IntelliJ IDEA.
  User: kdh56
  Date: 2021-02-23
  Time: 오후 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>



<script>
    var historyBack = '${historyBack}' == 'true';
    var alertMsg = "${alertMsg}".trim();
    if (alertMsg) {
        alert(alertMsg);
    }
    // 이전 페이지 히스토리가 필요한 경우 사용
    if (historyBack) {
        history.back();
    }
    // redirect 처리
    var locationReplaceUrl = '${locationReplace}'.trim();
    if (locationReplaceUrl) {
        location.replace(locationReplaceUrl);
    }
</script>
</body>
</html>
