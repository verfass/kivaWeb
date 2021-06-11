/* 퍼블리싱 공통 JS */
function toggleClassFn(target,cls){
  var target = $(target);
  if(target.hasClass(cls)){
    target.removeClass(cls);
  }else{
    target.addClass(cls);
  }
}


function make_sound(mp3_url,loopcnt){
  if(!loopcnt) loopcnt = 1;
  var cnt = 0;
  var sound = new Audio(mp3_url);
  sound.loop = false;
  sound.volume = 1;
  sound.play();
  sound.addEventListener("ended",function(){
    console.log("make sound : "+mp3_url);
    cnt++;
    if(cnt == parseInt(loopcnt)) return;
    sound.currentTime="0";
    sound.play();
  })
}

var swpEdu01;

//배경 이미지 변경
function changeBg(bgsrc){
  if(bgsrc.substr(0,1)=="#"){
    $(".edu_templete").css("background",bgsrc);
  }else{
    $(".edu_templete").css("background-image","url(/outer/training/img/"+bgsrc+")");
  }
}

// 슬라이더 진행 ON/OFF
function swiperActiveFn(swp,type){
  var swiper = swp;
  switch(type){
    case "off":
      swiper.allowSlidePrev = false;
      swiper.allowSlideNext = false;
      swiper.allowTouchMove = false;
      break;
    case "on":
      swiper.allowSlidePrev = true;
      swiper.allowSlideNext = true;
      swiper.allowTouchMove = true;
      break;
    case "next":
      swiper.allowSlidePrev = false;
      swiper.allowSlideNext = true;
      swiper.allowTouchMove = false;
      $(swiper.$el).find(".btn_next").show();
      break;
    case "next_move":
      swiper.allowSlideNext = true;
      swiper.slideNext();
      break;
  }
}

// 페이지 진입 초기 세팅
function initFn(){
  swpEdu01 = new Swiper("#swp_perview01",{
    touchReleaseOnEdges : true,
    speed:600,
    navigation: {
      nextEl: "#swp_perview01 .btn_next",
      prevEl: "#swp_perview01 .btn_prev",
    }
  });
  swpEdu01.on("slideChangeTransitionStart",function(){
    videoStop()
    swiperActiveFn(swpEdu01,"off");
    var currentSlide = swpEdu01.$wrapperEl.find(".swiper-slide-active");
    if(currentSlide.data("bgsrc")){
      changeBg(currentSlide.data("bgsrc"));
    }
  });
  swpEdu01.on("slideChangeTransitionEnd",function(){
    var currentSlide = swpEdu01.$wrapperEl.find(".swiper-slide-active");
    currentSlide.addClass("animated");
    if(currentSlide.hasClass("stop_slide")){
      swiperActiveFn(swpEdu01,"off");
      $("#swp_perview01").find(".btn_prev").hide();
      $("#swp_perview01").find(".btn_next").hide();
    }else{
      if(swpEdu01.$wrapperEl.find(".swiper-slide-prev").hasClass("stop_slide")){
        swiperActiveFn(swpEdu01,"next");
        $("#swp_perview01").find(".btn_next").show();
      }else{
        swiperActiveFn(swpEdu01,"on");
        $("#swp_perview01").find(".btn_prev").show();
        $("#swp_perview01").find(".btn_next").show();
      }
    }
    if(currentSlide.data("bgm")){
      if(currentSlide.data("repeat")){
        make_sound(currentSlide.data("bgm"),currentSlide.data("repeat"));
      }else{
        make_sound(currentSlide.data("bgm"));
      }
    }
    if(currentSlide.find("img[data-anigif]").length > 0){
      currentSlide.find("img[data-anigif]").each(function(){
        var gif = $(this).data("anigif");
        $(this).attr("src",gif);
        if($(this).data("gifsound")){
          make_sound($(this).data("gifsound"));
        }
      })
    }
    if(currentSlide.data("youtubu-url")){
      videoPlay(currentSlide.data("video"), currentSlide.data("youtubu-url"));
    }
  });
}

//드래그 타입
function initDraggableItem(wrapper,total) {
  var dropTargets = wrapper.find(".box_answer");
  if(dropTargets.find(".answer").length > 0) dropTargets = wrapper.find(".box_answer .answer");
  var totalTarget = total;
  var totalHit = 0;
  Draggable.create(wrapper.find(".dragItem"), {
    bounds: wrapper,
    edgeResistance: .65,
    onPress: function () {
      this.startX = this.x;
      this.startY = this.y;
      this.offsetTop = this.startY - $(this.target).position().top;
      this.offsetLeft = this.startX - $(this.target).position().left;
      make_sound($(this.target).data("sound"));
    },
    onDragEnd: function () {
      var dragThing = this;
      var dragCode = $(this.target).data("code");

      $.each(dropTargets, function (idx, spot) {
        var spotCode = $(spot).data("code");
        var pos = $(spot).position();
        //var diffTop = dragThing.offsetTop + pos.top + dropTargets.height()/2;
        var diffTop = dragThing.offsetTop + pos.top + 50;
        var diffLeft = dragThing.offsetLeft + pos.left + dropTargets.width()/2 - 15;
        if(spotCode === dragCode && dragThing.hitTest(spot, "10%")){
          $(spot).find("img").each(function(){
            var url = $(this).attr("data-after-png");
            $(this).attr("src",url);
          });
          TweenMax.to(dragThing.target, 0.5, {scale:1.7, x:diffLeft, y:diffTop, onComplete:hideMatches, onCompleteParams:[dragThing,spot] });
        }else{
          make_sound("/outer/training/sound/error.mp3");
          $(dragThing.target).parent().addClass("wrong");
          setTimeout(function(){
            $(dragThing.target).parent().removeClass("wrong");
          },1000);
          TweenMax.to(dragThing.target, .5, {x:dragThing.startX, y:dragThing.startY});
        }
      });
    }
  });
  function hideMatches(dragItem, targetItem){
    totalHit++;
    TweenMax.to(dragItem.target, .5, {autoAlpha: 0, onComplete:checkTargetCount, onCompleteParams:[targetItem]});
  }
  function checkTargetCount(targetItem){
    if(totalHit == totalTarget){
      if($(targetItem).hasClass("next_move")){
        swiperActiveFn(swpEdu01,"next_move");
      }else{
        // $(targetItem).find("img").each(function(){
        //   var url = $(this).attr("src").split(".png")[0] + "02.png";
        //   $(this).attr("src",url);
        // });
        swiperActiveFn(swpEdu01,"next");
      }
    }
  }
}
function initDraggableItem02(wrapper,total) {
  var dropTargets = wrapper.find(".box_answer .answer");
  var totalTarget = total;
  var totalHit = 0;
  Draggable.create(wrapper.find(".dragItem"), {
    bounds: wrapper,
    edgeResistance: .65,
    onPress: function () {
      this.startX = this.x;
      this.startY = this.y;
      this.offsetTop = this.startY - $(this.target).position().top;
      this.offsetLeft = this.startX - $(this.target).position().left;
      var mp3_url = $(this.target).data("sound");
      make_sound(mp3_url);
    },
    onDragEnd: function () {
      var dragThing = this;
      var dragCode = $(this.target).data("code");

      $.each(dropTargets, function (idx, spot) {
        var spotCode = $(spot).data("code");
        var pos = $(spot).position();
        var diffTop = dragThing.offsetTop + pos.top;
        var diffLeft = dragThing.offsetLeft + pos.left;

        if($(spot).parents(".type_blank03").length > 0){
          diffTop = dragThing.offsetTop + pos.top + 13;
        }

        if(spotCode == dragCode){
          if(dragThing.hitTest(spot, "10%")){
            TweenMax.to(dragThing.target, 0.5, {x:diffLeft, y:diffTop, onComplete:hideMatches, onCompleteParams:[dragThing,spot] });
          }else{
            make_sound("/outer/training/sound/error.mp3");
            $(dragThing.target).parent().addClass("wrong");
            setTimeout(function(){
              $(dragThing.target).parent().removeClass("wrong");
            },1000);
            TweenMax.to(dragThing.target, .5, {x:dragThing.startX, y:dragThing.startY});
          }
        }
      });
    }
  });
  function hideMatches(dragItem, targetItem){
    totalHit++;
    if(totalHit == totalTarget){
      if($(targetItem).parents(".box_answer").data("repeat")){
        make_sound($(targetItem).parents(".box_answer").data("sound"),$(targetItem).parents(".box_answer").data("repeat"));
      }else{
        make_sound($(targetItem).parents(".box_answer").data("sound"));
      }
      swiperActiveFn(swpEdu01,"next");
    }
  }
}
function initDraggableItem03(wrapper,total) {
  var dropTargets = wrapper.find(".box_answer .answer");
  var totalTarget = total;
  var totalHit = 0;
  Draggable.create(wrapper.find(".dragItem"), {
    bounds: wrapper,
    edgeResistance: .65,
    onPress: function () {
      this.startX = this.x;
      this.startY = this.y;
      this.offsetTop = this.startY - $(this.target).position().top;
      this.offsetLeft = this.startX - $(this.target).position().left;
      var mp3_url = $(this.target).data("sound");
      make_sound(mp3_url);
    },
    onDragEnd: function () {
      var dragThing = this;
      var dragCode = $(this.target).data("code");

      $.each(dropTargets, function (idx, spot) {
        var spotCode = $(spot).data("code");
        var pos = $(spot).position();
        var diffTop = dragThing.offsetTop + pos.top;
        var diffLeft = dragThing.offsetLeft + pos.left;

        if(spotCode == dragCode && dragThing.hitTest(spot, "10%")){
          TweenMax.to(dragThing.target, 0.5, {x:diffLeft+25, y:diffTop, onComplete:hideMatches, onCompleteParams:[dragThing,spot] });
        }else{
          make_sound("/outer/training/sound/error.mp3");
          $(dragThing.target).parent().addClass("wrong");
          setTimeout(function(){
            $(dragThing.target).parent().removeClass("wrong");
          },1000);
          TweenMax.to(dragThing.target, .5, {x:dragThing.startX, y:dragThing.startY});
        }
      });
    }
  });
  function hideMatches(dragItem, targetItem){
    totalHit++;
    if(totalHit == totalTarget){
      if($(targetItem).parents(".box_answer").data("repeat")){
        make_sound($(targetItem).parents(".box_answer").data("sound"),$(targetItem).parents(".box_answer").data("repeat"));
      }else{
        make_sound($(targetItem).parents(".box_answer").data("sound"));
      }
      swiperActiveFn(swpEdu01,"next");
    }
  }
}
function initDraggableItem04(wrapper,total) {
  var dropTargets = wrapper.find(".box_answer .answer");
  var totalTarget = total;
  var totalHit = 0;
  Draggable.create(wrapper.find(".dragItem"), {
    bounds: wrapper,
    edgeResistance: .65,
    onPress: function () {
      this.startX = this.x;
      this.startY = this.y;
      this.offsetTop = this.startY - $(this.target).position().top;
      this.offsetLeft = this.startX - $(this.target).position().left;
      make_sound($(this.target).data("sound"));
    },
    onDragEnd: function () {
      var dragThing = this;
      var dragCode = $(this.target).data("code");

      $.each(dropTargets, function (idx, spot) {
        var spotCode = $(spot).data("code");
        var pos = $(spot).position();
        var diffTop = dragThing.offsetTop + pos.top + 13;
        var diffLeft = dragThing.offsetLeft + pos.left + $(spot).width()/2 - $(dragThing.target).width()/2 - 5;
        if(spotCode === dragCode && dragThing.hitTest(spot, "10%")){
          TweenMax.to(dragThing.target, 0.5, {x:diffLeft, y:diffTop, onComplete:hideMatches, onCompleteParams:[dragThing,spot] });
        }else{
          make_sound("/outer/training/sound/error.mp3");
          $(dragThing.target).parent().addClass("wrong");
          setTimeout(function(){
            $(dragThing.target).parent().removeClass("wrong");
          },1000);
          TweenMax.to(dragThing.target, .5, {x:dragThing.startX, y:dragThing.startY});
        }
      });
    }
  });
  function hideMatches(dragItem, targetItem){
    totalHit++;
    if(totalHit == totalTarget){
      if($(targetItem).parents(".box_answer").data("repeat")){
        make_sound($(targetItem).parents(".box_answer").data("sound"),$(targetItem).parents(".box_answer").data("repeat"));
      }else{
        make_sound($(targetItem).parents(".box_answer").data("sound"));
      }
      swiperActiveFn(swpEdu01,"next");
    }
  }
}

//셀렉트 타입
function initSelectItemTree(wrapper,total) {
  var totalTarget = total;
  var totalHit = 0;

  wrapper.find(".selectItem").on("click",function(){
    var code = $(this).data("code");

    if(code){
      $(this).parent().addClass("chk");
      TweenMax.to($(this).parent(), 0.3, {scale:1.2, onComplete:hideMatches});
    }else{
      make_sound("/outer/training/sound/error.mp3");
      TweenMax.to($(this).parent(), 0.1, {x:-1});
      TweenMax.to($(this).parent(), 0.1, {x:1,delay:0.1});
      TweenMax.to($(this).parent(), 0.1, {x:-1,delay:0.2});
      TweenMax.to($(this).parent(), 0.1, {x:1,delay:0.3});
      TweenMax.to($(this).parent(), 0.1, {x:0,delay:0.4});
    }
  });
  function hideMatches(){
    totalHit++;
    if(totalHit ==  totalTarget){
      wrapper.find(".box_answer img").each(function(){
        var url = $(this).attr("data-after-png");
        $(this).attr("src",url);
      });
      swiperActiveFn(swpEdu01,"next");
    }
  }
}
function initSelectItem(wrapper,total) {
  var totalTarget = total;
  var totalHit = 0;

  wrapper.find(".selectItem").on("click",function(){
    var code = $(this).data("code");

    if(code){
      //TweenMax.to($(this).parent(), 1, {autoAlpha:0, y:-200, sacle:1.1, ease:"back.in(1.5)", onComplete:hideMatches});
      var date = new Date();
      var bg = $(this).parent().css("background-image");
      bg = bg.split(".png")[0] + ".gif?"+date.getTime();
      $(this).parent().addClass("effect").css({
        "background-image":bg,
        "z-index":"-1"
      });
      make_sound($(this).data("sound"));
      make_sound("/outer/training/sound/effect_balloon.mp3");
      hideMatches();
    }else{
      make_sound("/outer/training/sound/error.mp3");
      TweenMax.to($(this).parent(), 0.1, {x:-1});
      TweenMax.to($(this).parent(), 0.1, {x:2,delay:0.1});
      TweenMax.to($(this).parent(), 0.1, {x:-2,delay:0.2});
      TweenMax.to($(this).parent(), 0.1, {x:1,delay:0.3});
      TweenMax.to($(this).parent(), 0.1, {x:0,delay:0.4});
    }
  });
  function hideMatches(){
    totalHit++;
    var card = wrapper.find(".balloon_card .card");

    if(totalHit ==  totalTarget){
      card.css("z-index","1");
      TweenMax.to(card, 0.5, {autoAlpha:1, scale:1, onComplete:function(){
          var mp3_url = card.data("sound");
          if(card.data("repeat")){
            make_sound(mp3_url,card.data("repeat"));
          }else{
            make_sound(mp3_url);
          }
          TweenMax.to(card, 0.3, {autoAlpha:0, scale:0.8, delay:3, onComplete:function(){
              card.css("z-index","-1");
              swiperActiveFn(swpEdu01,"next");
            }});
        }});
    }
  }
}
function videoPlay(num,url) {
  let vid = document.getElementById('video'+num);
  if(vid){
    vid.innerHTML = '<iframe width = "90%" height = "550" src = "' + url +'?autoplay=1&loop=1&rel=0&wmode=transparent" frameborder = "0" allowfullscreen wmode = "Opaque"></iframe >';
  }
}
function videoStop() {
  let vid1 = document.getElementById("video1");
  let vid2 = document.getElementById("video2");
  let vid3 = document.getElementById("video3");
  if(vid1){
    vid1.innerHTML = "";
  }
  if(vid2){
    vid2.innerHTML = "";
  }
  if(vid3){
    vid3.innerHTML = "";
  }
}
