/////////////////////////////////////////////////////////////////// 카운트다운 예제 시작(1분30초)  //////////////////////////////
// 1. 아래와 같이 인증 할때 호출해주면 된다.
// var AuthTimer = new $ComTimer()
// AuthTimer.comSecond = 60;
// AuthTimer.fnCallback = function(){alert("다시인증을 시도해주세요.")}
// AuthTimer.timer =  setInterval(function(){AuthTimer.fnTimer()},1000);
// AuthTimer.domId = document.getElementById("timer");
function $ComTimer(){
    //prototype extend
    $('#sendSmsBtn').prop('disabled', true);  // 버튼 막기
}
$ComTimer.prototype = {
    comSecond : ""
    , fnCallback : function(){}
    , timer : ""
    , domId : ""
    , fnTimer : function(){
        var m = Math.floor(this.comSecond / 60) + "분 " + (this.comSecond % 60) + "초";	// 남은 시간 계산
        this.comSecond--;					// 1초씩 감소
        // console.log(m);
        this.domId.innerText = m;
        if (this.comSecond < 0) {			// 시간이 종료 되었으면..
            clearInterval(this.timer);		// 타이머 해제
            this.fnCallback()
            // alert("인증시간이 초과하였습니다. 다시 인증해주시기 바랍니다.")
            // $('#sendSmsBtn').prop('disabled', false); // 버튼 풀기
        }
    }
    ,fnStop : function(){
        clearInterval(this.timer);
    }
}

// function timerStart(btnEl){
//     var AuthTimer = new $ComTimer()
//     AuthTimer.comSecond = 80;
//     AuthTimer.fnCallback = function () { // 타이머 종료후 실행할 로직을 추가하면된다.
//         let authKey = document.getElementById('authKey');
//         if(authKey.classList.contains('ck-input')){
//             authSmsBtnRollback(btnEl);
//         }
//     }
//     AuthTimer.timer = setInterval(function () {
//         AuthTimer.fnTimer()
//     }, 1000);
//     AuthTimer.domId = document.getElementById("timer");
// }

/////////////////////////////////////////////////////////////////// 카운트다운 예제 끝 ///////////////////////////


// form 테그 직렬화
jQuery.fn.serializeObject = function() {
    var obj = null;
    if (this[0].tagName && this[0].tagName.toUpperCase() == "FORM") {
        var arr = this.serializeArray();
        if (arr) {
            obj = {};
            jQuery.each(arr, function() {
                obj[this.name] = this.value;
            });
        }//if ( arr ) {
    }
    try {
    } catch (e) {
        alert(e.message);
    } finally {
    }

    return obj;
};
///// form 테그 직렬화 끝

function maxLengthPhCheck(object) {
    if(!object.value){
        object.value = "";
        object.placeholder = '-없이 입력'
        return false;
    }
    if (object.value.length > object.maxLength) {
        object.value = object.value.slice(0, object.maxLength);
    }
}

function post_to_url(path, params) {
    var method = "post"; // 전송 방식 기본값을 POST로


    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);

    //히든으로 값을 주입시킨다.
    for (var key in params) {
        var hiddenField = document.createElement("input");
        hiddenField.setAttribute("type", "hidden");
        hiddenField.setAttribute("name", key);
        hiddenField.setAttribute("value", params[key]);

        form.appendChild(hiddenField);
    }

    document.body.appendChild(form);
    form.submit();
}