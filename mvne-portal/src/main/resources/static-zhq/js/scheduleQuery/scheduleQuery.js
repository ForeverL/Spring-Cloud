$(function () {
  $(".scheduleTab li").click(function () {
    var index = $(this).index();
    $(this).addClass("active").siblings().removeClass("active");
    $(this).parent().parent().find(".scheduleTabCon li").eq(index).show().siblings().hide();
    // 切换查询时，把所填信息都重置
    $("#IDNumber").val("");
    $("#phoneNumber").val("");
    $("#authNumber").val("");
    $("#orderNumber").val("");
  });
  // 校验身份证号码
  function isCardNo(card) {
    // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
    var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    if(reg.test(card) === false) {
      // 身份证号码错误
      return 0;
    }else {
      return 1;
    }
  }// 校验身份证号码
  function isPhoneNo(card) {
    var reg = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
    if(reg.test(card) === false) {
      // 手机号码错误
      return 0;
    }else {
      return 1;
    }
  }
  // 点击预留信息的查询
  $("#infoQueryBtn").click(function () {
    if(isCardNo($("#IDNumber").val()) == 0){
      $(".IDWarn").remove();
      $("#IDNumber").after("<span class='IDWarn'>请输入正确的身份证号</span>")
    }
    if(isPhoneNo($("#phoneNumber").val()) == 0){
      $(".phoneWarn").remove();
      $("#phoneNumber").after("<span class='phoneWarn'>请输入正确的手机号码</span>");
    }
    /*$.ajax({
     url:"",
     data:{},
     success:function (data) {
     console.log(data);
     }
     })*/
  });
  // 点击订单编号的查询
  $("#numberQueryBtn").click(function () {
    /*$.ajax({
     url:"",
     data:{},
     success:function (data) {
     console.log(data);
     }
     })*/
  })
});