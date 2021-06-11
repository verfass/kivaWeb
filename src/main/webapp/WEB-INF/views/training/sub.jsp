<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../layout/training_header.jsp" %>
<div id="wrap">
    <div class="main_wrap"><!-- //prefix : main_wrap : 메인 -->
        <div class="inner">
            <a href="/menu/branch" class="btn_home"><img src="/outer/training/img/btn_home.png" alt=""/></a>
            <a href="/" class="btn_close"><img src="/outer/training/img/btn_close.png" alt=""/></a>

            <div class="menu_board">
                <div class="menu">
                    <c:forEach var="SubMenu" items="${SubMenus}">
                        <c:choose>
                            <c:when test="${SubMenu.menuName == 'TEST'}">
                                <button type="button" onclick="location.href = '/training/test/${SubMenu.menuId}'">${SubMenu.menuName}</button>
                            </c:when>
                            <c:otherwise>
                                <button type="button" onclick="openCategory('${SubMenu.menuName.charAt(0)}', ${SubMenu.menuId})">${SubMenu.menuName}</button>
                            </c:otherwise>

                        </c:choose>
                    </c:forEach>
                </div>
                <img class="bg" src="/outer/training/img/main_menu.png" alt=""/>
            </div>

            <div class="category_wrap">
                <a href="javascript:;" class="close_category" onclick="closeCategory();">X</a>
                <p id="week_num" class="week_num"></p>
                <ul>
                    <li>
                        <a href="javascript:;" id="videoUrl"><img src="/outer/training/img/main_category01.png" alt="Kiva Play"/></a>
                        <strong id="kivaCount">0</strong>
                    </li>
                    <li>
                        <a href="javascript:;" id="phonicsUrl"><img src="/outer/training/img/main_category02.png" alt="Phonics"/></a>
                        <strong id="phonicsCount">0</strong>
                    </li>
                    <li>
                        <a href="javascript:;" id="dailyTalkUrl"><img src="/outer/training/img/main_category03.png" alt="Daily Talk"/></a>
                        <strong id="dailyTalkCount">0</strong>
                    </li>
                </ul>
                <img class="bg" src="/outer/training/img/main_category.png" alt=""/>
            </div>

            <div class="fish fish01"><img src="/outer/training/img/fish01.png" alt=""/></div>
            <div class="fish fish02"><img src="/outer/training/img/fish02.png" alt=""/></div>
            <div class="fish fish03"><img src="/outer/training/img/fish03.png" alt=""/></div>
        </div>
    </div>
</div>

<%@include file="../layout/training_footer.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        TweenMax.to($(".fish.fish01"), 20, {left: "150%", ease: "none"});
        TweenMax.to($(".fish.fish02"), 10, {left: "150%", delay: 5, ease: "none"});
        TweenMax.to($(".fish.fish03"), 25, {left: "150%", delay: 8, ease: "none"});
    });

    function openCategory(weekNum,  menuId) {
        $("html, body").css("overflow", "hidden");
        $(".category_wrap").addClass("active");
        var dim = '<div class="dimmed"></div>';
        if ($(".dimmed").length > 0) $(".dimmed").remove();
        $("body").append(dim);

        document.getElementById("week_num").innerText = weekNum;
        // if (videoUrl) {
        //     document.getElementById('videoUrl').setAttribute('href', videoUrl);
        // }

        $.ajax({
            type: "GET",
            url: `/training/parent/`+menuId,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            console.log(resp)
            if (resp.statusCode === 200) {
                if(resp.data.kivaPlayUrl) {
                    document.getElementById('videoUrl').setAttribute('href', "javascript:counting('" + resp.data.kivaPlayUrl + "','" + resp.data.kivaPlayMenuId + "')");
                }else{
                    document.getElementById('videoUrl').setAttribute('href', "javascript:alert('키바플레이 자료가 등록되지 않았습니다.')");
                }
                if(resp.data.phonicsId) {
                    document.getElementById('phonicsUrl').setAttribute('href', "javascript:counting('/training/phonics/"+resp.data.phonicsId+"','"+resp.data.phonicsMenuId+"')");
                } else {
                    document.getElementById('phonicsUrl').setAttribute('href', "javascript:alert('파닉스 자료가 등록되지 않았습니다.')");
                }
                if(resp.data.dailyTalkId) {
                    document.getElementById('dailyTalkUrl').setAttribute('href', "javascript:counting('/training/dailyTalk/"+resp.data.dailyTalkId+"','"+resp.data.dailyTalkMenuId+"')");
                } else {
                    document.getElementById('dailyTalkUrl').setAttribute('href', "javascript:alert('데일리톡 자료가 등록되지 않았습니다.')");
                }
                document.getElementById("kivaCount").innerText = resp.data.kivaPlayCount;
                document.getElementById("phonicsCount").innerText = resp.data.phonicsCount;
                document.getElementById("dailyTalkCount").innerText = resp.data.dailyTalkCount;
            } else {
                alert("요청 실패");
            }
        }).fail(function (error) {
            alert("요청 실패");
        })

    }
    function counting(url, menuId) {

        $.ajax({
            type: "POST",
            url: `/training/counting/`+menuId,
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function(resp){
            console.log(resp)
            if(resp.statusCode === 200) { // 성공
                location.href = url;
            }else{
                alert("카운트 에러")
            }
        }).fail(function (error) {
            alert("요청 실패");
        })
    }

    function closeCategory() {
        $(".dimmed").remove();
        $("html, body").css("overflow", "");
        $(".category_wrap").removeClass("active");
    }

</script>