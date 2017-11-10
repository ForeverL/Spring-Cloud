$(function () {
  //分页
  $("#page").paging({
    // 当前第几页
    pageNo:1,
    // 总共几页
    totalPage: 1,
    // 多少条数据
    totalSize: 300,
    // 回调
    callback: function(num) {
      console.log(num);
    }
  });
  //日期选择器
  laydate.render({
    elem: '#rechargeStartDate', //指定元素
    showBottom: false,
    theme:"#4ca5fc"
  });
  //日期选择器
  laydate.render({
    elem: '#rechargeStopDate', //指定元素
    showBottom: false,
    theme:"#4ca5fc"
  });
});