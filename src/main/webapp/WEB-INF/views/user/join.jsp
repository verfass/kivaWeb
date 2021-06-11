<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>
<div class="login-pg">
    <div class="inner-box join-box ">
        <p class="login-img"><img src="/images/img3_03.png"></p>
        <form id="saveForm" action="javascript:void(0)" onsubmit="saveApi()">
            <table class="join-tb">
                <tr>
                    <th>아이디</th>
                    <td>
                        <input type="text" class="input1 input310" id="userId" name="userId" minlength="3" maxlength="20" required>
                        <button type="button" class="bu-btn" onclick="findId()">중복확인</button>
                        <p class="red-p none" id="duplicateMsg">* 중복된 아이디 입니다.</p>
                    </td>
                </tr>
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" class="input1" id="password" name="password" minlength="8" maxlength="20" required></td>
                </tr>
                <tr>
                    <th>비밀번호 확인</th>
                    <td><input type="password" class="input1" id="passwordRe" name="passwordRe" minlength="8" maxlength="20" required></td>
                </tr>
                <tr>
                    <th>기관검색</th>
                    <td>
                        <input type="text" class="input1 input310 shc-input" id="kindergartenName" placeholder="기관명을 입력해 주세요">
                        <button type="button" class="bu-btn" id="find-btn" onclick="kindergartenByNames()">기관검색
                        </button>
                    </td>
                    <button class="none" type="button"  id="showModal-btn"  data-toggle="modal" data-target="#basicModal" ></button>
                </tr>
                <tr>
                    <th>원명</th>
                    <td><input type="text" class="input1" id="kindergartenNameText" value="" readonly required></td>
                </tr>
                <tr>
                    <th>반</th>
                    <td>
                        <select class="sel1" id="classId" name="classId">
                            <option value="0">반을 선택해 주세요</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>원아 이름</th>
                    <td><input type="text" class="input1" id="userName" name="userName" minlength="2" maxlength="8" required></td>
                </tr>
                <tr>
                    <th rowspan="2">전화번호</th>
                    <td>
                        <input type="number" class="input1 input310" id="cellPhone" name="cellPhone" maxlength="11" oninput="maxLengthPhCheck(this)" placeholder="-없이 입력" required>
                        <button type="button" class="bu-btn" id="sendSmsBtn" onclick="authSmsSend(this)">인증하기</button>
                        <p class="red-p none" id="timerTag">* 제한시간 <span id="timer">1:20</span></p>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="number" class="input1 input310" id="authKey" name="authKey" placeholder="인증번호입력" readonly required>
    <%--                    <span class="yell-sp">인증완료</span>--%>
                        <button type="button" class="yell-sp" id="authCheckBtn" onclick="authKeyCheck(this)" disabled>인증체크</button>
                    </td>
                </tr>
            </table>
            <hr class="hr">
            <button type="button" class="jo-btn1" onclick="location.href='/'">취소</button>
            <button type="submit" class="jo-btn2">회원가입</button>
        </form>
    </div>
</div>
<%@include file="join_modal.jsp" %>
<%@include file="../layout/footer.jsp" %>
<script src="/js/view/user.js"></script>
<script>
    $('#userId').keydown(function(){
        $('#duplicateMsg').addClass('none')
    });

    function findAction(){
        const findBtn = document.getElementById('find-btn'); // header 객체에 onclick 이벤트 속성을 연결
        findBtn.click();
    }

    function showModal(){
        const showModalBtn = document.getElementById('showModal-btn'); // header 객체에 onclick 이벤트 속성을 연결
        showModalBtn.click();
    }

    function authSmsBtnDisabled(btnEl){
        // 문자전송 버튼 제한
        btnEl.disabled = true;
        btnEl.className = 'yell-sp';
        // 타이머 화면 none 해제
        let timerTag = document.getElementById('timerTag');
        timerTag.classList.remove('none')
        // 인증 버튼 활성화
        let authCheckBtn = document.getElementById('authCheckBtn');
        authCheckBtn.disabled = false;
        authCheckBtn.readOnly = false;
        authCheckBtn.className = 'bu-btn';
        //인증 입력 값 활성화
        let authKey = document.getElementById('authKey');
        authKey.readOnly = false;

        //전화번호 입력 제한
        let cellPhone = document.getElementById('cellPhone');
        cellPhone.readOnly = true;

        //인증 화면 none 해제
        // let authInputView = document.getElementById('authInputView');
        // authInputView.className = '';
    }

    function authSmsBtnRollback(btnEl){
        // 문자전송 버튼 제한 해제
        btnEl.disabled = false;
        btnEl.className = 'bu-btn';
        // 타이머 화면 none
        let timerTag = document.getElementById('timerTag');
        timerTag.classList.add('none')
        // 인증 버튼 비활성화
        let authCheckBtn = document.getElementById('authCheckBtn');
        authCheckBtn.disabled = true;
        authCheckBtn.className = 'yell-sp';
        //전화번호 입력 제한 해제
        let cellPhone = document.getElementById('cellPhone');
        cellPhone.readOnly = false;
        //인증 입력 값 readOnly
        let authKey = document.getElementById('authKey');
        authKey.readOnly = true;

        // let authInputView = document.getElementById('authInputView');
        // authInputView.className = 'none';

    }

    function authKeyTrue(btnEl){
        // 인증 버튼 비활성화
        btnEl.disabled = true;
        btnEl.className = 'yell-sp';
        // 인증 성공시 이미지 활성화 && input키값 readonly 변경
        let authKey = document.getElementById('authKey');
        authKey.classList.add('ck-input');
        authKey.readOnly = true;
        // 성공시 타이머도 안보이게
        let timerTag = document.getElementById('timerTag');
        timerTag.classList.add('none')
    }
    // 타이머 작동
    function timerStart(btnEl){
        var AuthTimer = new $ComTimer()
        AuthTimer.comSecond = 80;
        AuthTimer.fnCallback = function () { // 타이머 종료후 실행할 로직을 추가하면된다.
            let authKey = document.getElementById('authKey');
            if(!authKey.classList.contains('ck-input')){ // 인증이 안된 상태에는 롤백
                authSmsBtnRollback(btnEl);
            }
        }
        AuthTimer.timer = setInterval(function () {
            AuthTimer.fnTimer()
        }, 1000);
        AuthTimer.domId = document.getElementById("timer");
    }
    // 모든 키입력을 받을 때 이벤트 추가
    document.addEventListener('keydown', async e => {
        // 엔터키 이벤트 추가하는 곳
        if (e.code === 'Enter' || e.code === 'NumpadEnter') {
            let targetEl = e.target
            // 1. 아이디 엔터이벤트
            let userIdEl = document.getElementById('userId');
            if(targetEl === userIdEl) findId();
            let kindergartenNameEl = document.getElementById('kindergartenName');
            if(targetEl === kindergartenNameEl) findAction();

            e.preventDefault(); // 엔터키 고유이벤트 삭제 및 모든 이벤트 삭제
            e.stopPropagation(); // 다른 function 이벤트는 작동하기 위해 설정
        }
    }, true);


</script>

</html>