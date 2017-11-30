$(function () {
  // 首页banner轮播图
  function carousel() {
    var unslider04 = $('#carouselBanner').unslider({
        dots: true
      }),
      data04 = unslider04.data('unslider');
    $('.unslider-arrow04').click(function() {
      var fn = this.className.split(' ')[1];
      data04[fn]();
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
  
  
  
  // 点击图片上传按钮
  $("#updownBtn").click(function () {
    // 第一次上传图片
    function firstImg() {
      $.ajax({
        url:"",
        data:{},
        success:function (data) {
          console.log(data);
        }
      });
    }
  });
});