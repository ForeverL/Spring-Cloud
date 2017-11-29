$(function () {
  var numChoose = localStorage.numChoise ;
  console.log(numChoose);
  $(".chioseNumber").text(localStorage.numChoise);
  // 一进来页面，获取后台数据渲染页面
  /*$.ajax({
   url:"",
   data:{},
   success:function (data) {
   console.log(data);
   }
   });*/
  // 点击上一步，返回到上一个页面
  $(".laststep").click(function () {
    window.location.href = "choose_number_new.html";
  });
  // 点击下一步，确认信息之后就要跳转到下一个页面
  $(".nextstep").click(function () {
    $.ajax({
      contentType:"application/json",
      url:"/LockAffirm?bill_id="+numChoose,
      type:"POST",
      //或者data:JSON.stringify(number),
      data:JSON.stringify({
        "bill_id" : numChoose
      }),
      success:function (data) {
        console.log(data);
        window.location.href="name_certification.html"
      }
    });
  });
});