$(function () {
  // 首页banner
  function carousel() {
    var $window = $(window), window_width = $window.width() - 340;
    $('#js_banner, #js_banner_img li').width(window_width);
    new $.Tab({
      target: $('#js_banner_img li'),
      effect: 'slide3d',
      animateTime: 1000,
      stay: 3500,
      autoPlay: true,
      merge: true,
      prevBtn: $('#js_banner_pre'),
      nextBtn: $('#js_banner_next')
    });
  }
  carousel();
  // 点击搜索
  $("#searchIpt").click(function () {
    $(".historyRecord").show();
    event.stopPropagation();
  });
  // 精选业务
  /*function carouselBusiness() {
    var len = $("#scrollPicsBusiness .num > li").length;
    var index = 0;  //图片序号
    var adTimer;
    $("#scrollPicsBusiness .num li").mouseover(function() {
      index = $("#scrollPicsBusiness .num li").index(this);  //获取鼠标悬浮 li 的index
      showImg(index);
    }).eq(0).mouseover();
    //滑入停止动画，滑出开始动画.
    $('#scrollPicsBusiness').hover(function() {
      clearInterval(adTimer);
    }, function() {
      adTimer = setInterval(function() {
        showImgBusiness(index)
        index++;
        if (index == len) {       //最后一张图片之后，转到第一张
          index = 0;
        }
      }, 3000);
    }).trigger("mouseleave");
  }
  carouselBusiness();
  function showImgBusiness(index) {
    var adWidth = $("#scrollPicsBusiness>ul>li:first").width();
    $("#scrollPicsBusiness .slider").stop(true, false).animate({
      "marginLeft": -adWidth * index + "px"    //改变 marginTop 属性的值达到轮播的效果
    }, 1000);
    $("#scrollPicsBusiness .num li").removeClass("on")
      .eq(index).addClass("on");
  }*/

  // 号码推荐
  $("ul.numClass li").on("click",function () {
    var index = $(this).index();
    $(this).siblings().find("p").hide().stop().parent().find("span").hide();
    $(this).find("p").show().stop().parent().find("span").show();
    $(this).parent().next().find(".numListUl").hide().eq(index).show();
    $(this).addClass("active").siblings().removeClass("active");
  });

  // 点击网上营业厅弹出弹框
  $("ul.headerNav li a.menu").click(function () {
    $(".shopFram").show();
    event.stopPropagation();
  });

  // 点击其他地方弹框隐藏
  $(document).click(function(){
    $(".shopFram").hide();
    $(".historyRecord").hide();
  });
});