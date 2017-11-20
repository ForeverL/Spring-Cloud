$(function () {
  // 首页banner
  function carousel() {
    var $window = $(window), window_width = $window.width() - 840;
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
  $('#carousel ul').carouFredSel({
    prev: '#prev',
    next: '#next',
    pagination: "#pager",
    scroll: 1000
  });

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