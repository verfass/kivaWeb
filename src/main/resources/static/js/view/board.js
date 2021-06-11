let apiObj = {
    //글쓰기 작성
    saveAjax(data) {
        console.log(data)
        // ajax 호출시 dufault가 비동기 호출이다.
        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
        }).done(function (resp) {
            console.log(resp);
            if (resp.statusCode === 500) {
                alert("글쓰기를 실패하였습니다.");
            } else {
                alert("글쓰기가 완료되었습니다.");
                location.href = "/board/index";
            }
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
    //삭제
    deleteAjax(id) {
        console.log(id)
        $.ajax({
            type: "DELETE",
            url: "/api/board/" + id,
        }).done(function (resp) {
            console.log(resp);
            alert("삭제가 완료되었습니다.");
            location.href = "/";
        }).fail(function (error) {
            console.log(JSON.stringify(error));
        })
    },
    updateAjax(data) {
        console.log(data);
        $.ajax({
            type: "PUT",
            url: "/api/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            console.log(resp);
            alert("수정이 완료되었습니다.");
            location.href = "/board";
        }).fail(function (error) {
            console.log(JSON.stringify(error));
        })
    },

    replySaveAjax(data) {
        console.log(data);
        $.ajax({
            type: "POST",
            url: `/api/board/${data.boardId}/reply`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (resp) {
            alert("댓글작성이 완료되었습니다.");
            console.log(resp);
            location.href = `/board/${data.boardId}`;

        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
    replyDeleteAjax(data) {
        console.log(data);
        $.ajax({
            type: "DELETE",
            url: `/api/board/${data.boardId}/reply/${data.replyId}`,
            data: JSON.stringify(data),
        }).done(function (resp) {
            alert("댓글삭제가 완료되었습니다.");
            console.log(resp);
            location.href = `/board/${data.boardId}`;

        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    }
}


// 종속 관계에 있는 api 호출
function replySaveApi(){
    let data = $('#replySaveForm').serializeObject();
    apiObj.replySaveAjax(data);
}

function replyDeleteApi(boardId, replyId){
    let data = {
        boardId : boardId,
        replyId : replyId
    };
    apiObj.replyDeleteAjax(data);
}