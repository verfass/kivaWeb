<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp" %>

<div class="downloadContentBox">

    <div class="container" style="padding-top: 500px;">

        <div class="row downloadContentBoxBtn">
            <div class="col-3">
                <a href="http://down.metaedu-app.co.kr/키바월드.apk" download>
                    <img src="../images/download/download_btn_kiva.png" width="250">
                </a>
            </div>
            <div class="col-3">
                <a href="http://down.metaedu-app.co.kr/Masha and the Bear.apk" download>
                    <img src="../images/download/download_btn_masha.png" width="250">
                </a>
            </div>
            <div class="col-3">
                <a href="http://down.metaedu-app.co.kr/메타키즈.apk" download>
                    <img src="../images/download/download_btn_meta.png" width="250">
                </a>
            </div>
            <div class="col-3">
                <img src="../images/download/download_btn_we.png" width="250">
            </div>
        </div>

    </div>

</div>





<%@include file="../layout/footer.jsp" %>
<script>
    jQuery(document).ready(function($) {

        $(".scroll").click(function(event){
            event.preventDefault();
            $('html,body').animate({scrollTop:$(this.hash).offset().top}, 500);
        });

        $(".mm-li").click(function() {
            $(this).children("ul").slideToggle("");
        });
    });
</script>
</html>
