$(function () {
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
  // 确认信息弹框
  $(".closeBtn").on("click",function () {
    $(".confirmFram").css("display","none");
  });
  // 点击确定退订
  $("#unsubBtn").on("click",function () {
    $(".successFram").css("display","block");
  })
});