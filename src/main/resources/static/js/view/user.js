let apiObj = {

    //저장
    saveAjax(data) {
        console.log(data)
        $.ajax({
            type: "POST",
            url: "/auth/user/join",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            console.log(resp);
            alert(resp.data);
            if (resp.statusCode === 200) {
                alert("가입이 완료되었습니다.\n" +
                    "원으로 승인 요청 해주세요");
                location.href = "/";
            }
        }).fail(function (error) {
            alert("입력에러")
            // alert(JSON.stringify(error));
        })
    },
    //삭제 ㅎㅎ 22
    deleteAjax(id) {

    },
    updateAjax(data) {
        $.ajax({
            type: "PUT",
            url: "/api/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            console.log(resp);
            alert("회원정보수정이 완료되었습니다.");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
}

function findId() {
    $('#duplicateMsg').removeClass('none')
    let id = $("#userId").val();
    console.log(id);
    $.ajax({
        type: "GET",
        url: "/auth/user/id",
        data: {
            "UserId": id
        },
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(function (resp) {
        console.log(resp);
        if (resp.statusCode === 500) {
            $('#duplicateMsg').text(`* ${resp.data}`)
        } else {
            $('#duplicateMsg').text("사용가능한 아이디 입니다.")
        }
    }).fail(function (error) {
        alert(JSON.stringify(error));
    })
}

function authSmsSend(btnEl) {
    // 1. 버튼 disabled
    authSmsBtnDisabled(btnEl);

    let data = {
        "cellPhone": $("#cellPhone").val()
    }
    console.log(data);
    $.ajax({
        type: "POST",
        url: "/auth/smsSend",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(function (resp) {
        console.log(resp);
        if(resp.statusCode === 200){ // 성공
            // 2. 타이머 시작
            timerStart(btnEl);
        } else { //실패
            authSmsBtnRollback(btnEl);
        }
        alert(resp.data)

    }).fail(function (error) {
        alert(JSON.stringify(error));
        authSmsBtnRollback(btnEl);
    })
}
function authKeyCheck(btnEl){
    let data = {
        "authKey": $("#authKey").val()
    }
    $.ajax({
        type: "POST",
        url: "/auth/authKeyCk",
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(function (resp) {
        alert(resp.data);
        if (resp.statusCode === 200) {
            authKeyTrue(btnEl)
        } else {

        }

    }).fail(function (error) {
        alert("값을 정확하게 입력해주세요");
    })
}

function kindergartenByNames() {
    let kindergartenName = document.getElementById('kindergartenName').value;
    document.getElementById('kindgartenList').innerHTML = '';
    $.ajax({
        type: "GET",
        url: `/auth/kindergarten/${kindergartenName}`,
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(function (resp) {
        console.log(resp);
        let html = ``;
        if (resp.data.length === 0) {
            html += "<li style='text-align: center'>검색하신 기관은 존재하지 않습니다.</li>"
        } else {
            for (let item in resp.data) {
                html += `<li>
                        <div class="checks">
                            <input type="radio" id="ex_r${resp.data[item].kindergartenId}" name="kindergartenId" value="${resp.data[item].kindergartenId}">
                            <label for="ex_r${resp.data[item].kindergartenId}">
                                <span class="ex-bu">${resp.data[item].address1.substring(0,2)}</span>
                                <span id="selectName${resp.data[item].kindergartenId}">${resp.data[item].kindergartenName}</span>
                            </label>
                        </div>
                    </li>
                    `
            }
        }
        document.getElementById('kindgartenList').innerHTML = html;

        showModal();
    }).fail(function (error) {
        alert("기관명을 입력해주세요");
    })
}


function findByClassRooms(kindergartenId) {
    document.getElementById('classId').innerHTML = '';

    $.ajax({
        type: "GET",
        url: `/auth/classRoom/${kindergartenId}`,
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(function(resp){
        console.log(resp)

        let html = ``;
        if (resp.data.length === 0) {
            html += "<option value='0'>반이 등록되지 않았습니다.</option>"
        } else {
            for (let item in resp.data) {
                html += `<option value="${resp.data[item].classId}">${resp.data[item].className} (${resp.data[item].grade}세)</option>`
            }
        }
        document.getElementById('classId').innerHTML = html;
    }).fail(function (error) {
        alert("요청 실패");
    })
}