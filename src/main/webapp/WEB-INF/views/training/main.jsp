<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../layout/training_header.jsp" %>

<div id="wrap">
  <div class="main_wrap"><!-- //prefix : main_wrap : 메인 -->
    <div class="inner">
      <h1 class="logo"><img src="/outer/training/img/logo.png" alt="Kiva World" /></h1>
      <c:if test="${grade == 5}">
      <h2 class="level"><img src="/outer/training/img/level_a.png" alt="kiva english level A" /></h2>
      </c:if>
      <c:if test="${grade == 6}">
        <h2 class="level"><img src="/outer/training/img/level_b.png" alt="kiva english level B" /></h2>
      </c:if>
      <c:if test="${grade == 7}">
        <h2 class="level"><img src="/outer/training/img/level_c.png" alt="kiva english level C" /></h2>
      </c:if>

      <a href="/" class="btn_close"><img src="/outer/training/img/btn_close.png" alt="" /></a>

      <c:if test="${grade == 5}">
        <a href="https://youtube.com/playlist?list=PL759_XpTlDUET2g51sdHdAler-C28DRnQ" class="btn_youtube"><img src="/outer/training/img/btn_youtube.png" alt="" /></a>
      </c:if>
      <c:if test="${grade == 6}">
        <a href="https://youtube.com/playlist?list=PL759_XpTlDUHLJpC6yX3GSy5-uHysQRZM" class="btn_youtube"><img src="/outer/training/img/btn_youtube.png" alt="" /></a>
      </c:if>
      <c:if test="${grade == 7}">
        <a href="https://youtube.com/playlist?list=PL759_XpTlDUFeqQbrRbCxo8BjiOZbkWRt" class="btn_youtube"><img src="/outer/training/img/btn_youtube.png" alt="" /></a>
      </c:if>

      <ul class="book_list">
        <c:forEach var="SubMenu" items="${SubMenus}">
        <li><a href="/training/parent/${SubMenu.menuId}/${grade}"><img src="/outer/training/img/book${SubMenu.menuName}.png" alt="BOOK ${SubMenu.menuName}" /></a></li>
        </c:forEach>
      </ul>
      <div class="fish fish01"><img src="/outer/training/img/fish01.png" alt="" /></div>
      <div class="fish fish02"><img src="/outer/training/img/fish02.png" alt="" /></div>
      <div class="fish fish03"><img src="/outer/training/img/fish03.png" alt="" /></div>
    </div>
  </div>
</div>

<%@include file="../layout/training_footer.jsp" %>

<script type="text/javascript">
  $(document).ready(function(){
    TweenMax.to($(".fish.fish01"), 20, {left:"150%",ease:"none"});
    TweenMax.to($(".fish.fish02"), 10, {left:"150%",delay:5,ease:"none"});
    TweenMax.to($(".fish.fish03"), 25, {left:"150%",delay:8,ease:"none"});
  });
</script>