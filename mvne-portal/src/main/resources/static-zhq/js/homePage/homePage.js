$(function () {
  // 首页banner
  function carousel() {
    var len = $("#scrollPics .num > li").length;
    var index = 0;  //图片序号
    var adTimer;
    $("#scrollPics .num li").mouseover(function() {
      index = $("#scrollPics .num li").index(this);  //获取鼠标悬浮 li 的index
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
    $("#scrollPics .slider").stop(true, false).animate({
      "marginLeft": -adWidth * index + "px"    //改变 marginTop 属性的值达到轮播的效果
    }, 1000);
    $("#scrollPics .num li").removeClass("on")
      .eq(index).addClass("on");
  }
  // 精选业务
  function carouselBusiness() {
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
  }

  // 号码推荐
  $("ul.numClass li").on("click",function () {
    var index = $(this).index();
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
  });
});