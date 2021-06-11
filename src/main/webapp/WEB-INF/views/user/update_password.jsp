<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>
<div class="login-pg">
    <div class="inner-box">
        <p class="login-img">비밀번호 변경</p>
        <form id="updateForm" action="javascript:void(0)" onsubmit="updateApi()">
            <input type="password" class="input1" name="password" placeholder="기존비밀번호">
            <input type="password" class="input1" name="changePassword" placeholder="새 비밀번호">
            <input type="password" class="input1" name="changePasswordRe" placeholder="새 비밀번호 확인">
            <button type="submit" class="login-btn" >변경하기</button>
        </form>
    </div>
</div>
<script>
let apiObj = {

    updateAjax(data) {
        $.ajax({
            type: "PUT",
            url: "/auth/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            console.log(resp);
            alert(resp.data);
            if (resp.statusCode === 200) {
                location.href = "/";
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
}
</script>
<%@include file="../layout/footer.jsp" %>
