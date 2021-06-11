<%--
  Created by IntelliJ IDEA.
  User: kdh56
  Date: 2021-02-07
  Time: 오후 7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>테스트업로드</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="doTestUpload">
    <input type="file" name="file__board__1__common__attachment__1" />
    <input type="file" name="file__board__1__common__attachment__2" />
    <br />
    <input type="submit" value="전송" />
</form>
</body>
</html>
