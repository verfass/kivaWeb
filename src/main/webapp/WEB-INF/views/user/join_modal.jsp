<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal fade"
        id="basicModal"
        tabindex="-1"
        role="dialog"
        aria-labelledby="basicModal"
        aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">해당 유치원을 선택해주세요.</h4>
                <button type="button" id="close-btn" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body" style="overflow-y: auto;overflow-x: hidden; max-height: 400px; ">
                <ul class="mo-list1" id="kindgartenList"></ul>
            </div>
            <div class="modal-footer">
                <button type="button" onclick="kindergartenSelect()" class="ck-ok" data-dismiss="modal">선택완료</button>
            </div>
        </div>
    </div>
</div>
<script>
    function kindergartenSelect(){
        let kindergartenId = 0;
        let check_count = document.getElementsByName("kindergartenId").length;
        for (var i=0; i<check_count; i++) {
            if (document.getElementsByName("kindergartenId")[i].checked == true) {
                kindergartenId = document.getElementsByName("kindergartenId")[i].value;
            }
        }
        let selectName = document.getElementById('selectName'+kindergartenId).innerText;
        document.getElementById('kindergartenNameText').value = selectName;

        if(kindergartenId !== 0){
            findByClassRooms(kindergartenId);
        }

    }

</script>