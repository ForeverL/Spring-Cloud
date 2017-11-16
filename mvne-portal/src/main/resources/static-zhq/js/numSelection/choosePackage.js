$(function(){
  /*点击切换tab*/
  $("li.tariffIntro").click(function () {
    $("ul.useRuleCon").css("display","none");
    $("ul.tariffIntroCon").css("display","block");
    $("li.tariffIntro").removeClass("tariffIntroright");
    $("li.useRule").removeClass("useRuleright");
  });
  $("li.useRule").click(function () {
    $("ul.useRuleCon").css("display","block");
    $("ul.tariffIntroCon").css("display","none");
    $("li.tariffIntro").addClass("tariffIntroright");
    $("li.useRule").addClass("useRuleright");
  });

  // 轮播图
  function carousel() {
    var len = $(".num > li").length;
    var index = 0;  //图片序号
    var adTimer;
    $(".num li").mouseover(function() {
      index = $(".num li").index(this);  //获取鼠标悬浮 li 的index
      showImg(index);
    }).eq(0).mouseover();
    //滑入停止动画，滑出开始动画.
    $('#scrollPics').hover(function() {
      clearInterval(adTimer);
    }, function() {
      adTimer = setInterval(function() {
        showImg(index)
        index++;
        if (index == len) {       //最后一张图片之后，转到第一张
          index = 0;
        }
      }, 3000);
    }).trigger("mouseleave");
  }
  carousel();
  function showImg(index) {
    var adWidth = $("#scrollPics>ul>li:first").width();
    $(".slider").stop(true, false).animate({
      "marginLeft": -adWidth * index + "px"    //改变 marginTop 属性的值达到轮播的效果
    }, 1000);
    $(".num li").removeClass("on")
      .eq(index).addClass("on");
  }
});