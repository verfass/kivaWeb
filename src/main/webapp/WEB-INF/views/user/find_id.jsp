<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>
<div class="login-pg">
    <form id="findIdForm" action="javascript:void(0)" onsubmit="findId()">
    <div class="inner-box">
        <p class="login-img"><img src="/images/id_03.png"></p>
        <input type="text" class="input1" id="userName" name="userName" minlength="2" maxlength="8"  placeholder="이름"  required>
        <input type="number" class="input1" id="cellPhone" name="cellPhone" maxlength="11" oninput="maxLengthPhCheck(this)" placeholder="연락처( - 없이 입력 )" required>
        <button type="submit" class="login-btn">아이디 찾기</button>
        <p class="fff ff2"><span style="display: none" id="findOk">회원가입시 입력하신 연락처로 아이디가 발송되었습니다.</span></p>
        <p class="or-btn-p"><a href="/auth/user/find_password" class="or-btn">비밀번호 찾기</a></p>
    </div>
    </form>
</div>
<%@include file="../layout/footer.jsp" %>
<script>
    function findId(){
        let data = $('#findIdForm').serializeObject();
        $.ajax({
            type: "POST",
            url: "/auth/user/find/Id",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            console.log(resp.data);
            alert(resp.data)
            if (resp.statusCode === 500) {
                document.getElementById('findOk').style.display = 'none'
            } else {
                document.getElementById('findOk').style.display = 'block'
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
</script>

</html>