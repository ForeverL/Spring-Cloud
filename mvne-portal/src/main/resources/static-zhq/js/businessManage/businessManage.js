$(function () {
  // 选择城市
  $("dl.cityDl dd").click(function () {
    $(this).siblings().find("a").removeClass("cityActive");
    $(this).find("a").addClass("cityActive");
  });
  // 选择品牌
  $("dl.brandDl dd").click(function () {
    $(this).siblings().find("a").removeClass("brandActive");
    $(this).find("a").addClass("brandActive");
  });
  // 选择类型
  $("dl.typeDl dd").click(function () {
    $(this).siblings().find("a").removeClass("typeActive");
    $(this).find("a").addClass("typeActive");
  });
  //分页
  $("#page").paging({
    // 当前第几页
    pageNo:1,
    // 总共几页
    totalPage: 9,
    // 多少条数据
    totalSize: 300,
    // 回调
    callback: function(num) {
      console.log(num);
    }
  })
});