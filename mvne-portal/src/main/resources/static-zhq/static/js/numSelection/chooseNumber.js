// 选号码页面
$(function () {

  // 刚进来页面号码列表刷新
  $.ajax({
    url : "/getPhoneNum",
    contentType : "application/json",
    type : "POST",
    data : JSON.stringify({
      //cardType:$(this).text(),
      "provCode":"200",
      "cityCode":"755",
      "pageNum":1,
      "pageSize":8,
      "mno_id":"CMCC",
      "mvno_id":"ZXST01"
    }),
    success:function(data){
      console.log(data.numbers);
      console.log(data);
      renderNumer(data.numbers);
      // 储存总页数
      localStorage.total = data.totalPage;

      // 储存当前页数
      localStorage.currentPage = data.currentPage;

      console.log("总"+localStorage.total);
      console.log("当前"+localStorage.currentPage);
    }
  });

// 渲染号码列表
  function renderNumer(number){
    $(".numberListUl").empty();
    // 循环号码列表
    for(var i = 0;i < 15;i++){
      if(number[i] != undefined){
        var str = "<li><span class='numChoise'>"+ number[i]+"</span></li> ";
        $(".numberListUl").append(str);
      }
    };
  }
// 点击已选卡类
  function selectedCard() {
    $(".menu .carAss li a").click(function() {
      $(".menu .carAss li a").removeClass();
      $(this).addClass("carActive");
      // 选定一个卡类之后的ajax局部刷新页面
      $.ajax({
        url : "/getPhoneNum",
        contentType : "application/json",
        type : "POST",
        data : JSON.stringify({
          //cardType:$(this).text(),
          "billId_class":"",
          "provCode":"200",
          "cityCode":"755",
          "pageNum":1,
          "pageSize":8,
          "mno_id":"CMCC",
          "mvno_id":"ZXST01"
        }),
        success : function(data) {
          // 储存总页数
          localStorage.total = data.total;
          // 储存当前页数
          localStorage.CurrentPage = data.CurrentPage;


          renderNumer(data.numbers);
        }
      });
    });
  }
  selectedCard();
// 点击套餐类型
  function packageAct() {
    $(".menu .setMeal li a").click(function() {
      $(".menu .setMeal li a").removeClass();
      $(this).addClass("packageActive");
      // 选定一个套餐类型之后的ajax局部刷新页面
      $.ajax({
        url : "/getPhoneNum",
        contentType : "application/json",
        type : "POST",
        data : JSON.stringify({
          //pkgType : $(this).text(),
            "provCode":"200",
            "cityCode":"755",
            "pageNum":1,
            "pageSize":8,
            "mno_id":"CMCC",
            "mvno_id":"ZXST01"
        }),
        success : function(data) {
          console.log(data);
          // 储存总页数
          localStorage.total = data.total;

          // 储存当前页数
          localStorage.CurrentPage = data.CurrentPage;
          

          renderNumer(data.numbers);
        }
      });
    });
  }
  packageAct();
// 点击号码类型
  function numberType() {
    $(".menu .numberAss li a").click(function() {
      $(".menu .numberAss li a").removeClass();
      $(this).addClass("numberType");
      // 选定一个号码类型之后的ajax局部刷新页面
      $.ajax({
        url : "/getPhoneNum",
        contentType : "application/json",
        type : "POST",
        data : JSON.stringify({
          //"numRegex" : $(this).text(),
          "provCode":"200",
          "cityCode":"755",
          "pageNum":1,
          "pageSize":8,
          "mno_id":"CMCC",
          "mvno_id":"ZXST01"
        }),
        success : function(data) {
          console.log(data);
          // 储存总页数
          localStorage.total = data.total;
          // 储存当前页数
          localStorage.CurrentPage = data.CurrentPage;


          renderNumer(data.numbers);
        }
      });
    });
  };
  numberType();
// 把列表中的电话号码放在页面中间
  function numberCenter() {
    var li = $(".numberList ul li");
    for (var i = 0; i < li.length; i++) {
      if (i % 5 == 4) {
        $(".numberList ul li").eq(i).css("marginRight", "0");
      }
    }
  }
  numberCenter();
// 点击选中号码列表
  function activeCenter() {
    //$(".numberList li").click(function () {
    $(".numberList").on("click","li",function(){
      $(".numberList li").css("border","1px solid #e6e6e6");
      $(".numberList li").find("span").css("color","#888");
      $(".numberList li").find("span.numMoney").css("color","#198bd4");
      $(".numberList li").removeAttr("name");
      $(this).css("border","1px solid #4ca5fc");
      $(this).find("span.numChoise").css("color","#4ca5fc");
      $(this).find("span.numMoney").css("color","#f8a53b");
      $(this).find("span.includeMoney").css("color","#4ca5fc");
      $(this).attr("name","1");
    });
  }
  activeCenter();
// 输入2-4位数字搜索对应的号码
  $(".numSearchBtn").click(
    function() {
      // 在输入的值不属于2-4位的时候，提示用户
      if ($(".numberKey").val().length < 1
        || $(".numberKey").val().length > 4) {
        console.log("请输入正确的数字");
        $(".numSearch")
          .append(
            "<span class='tips'>" + "请输入1-4位数字"
            + "</span>");
      } else { // 输入了正确的值，发送请求后台数据
        // 提示清除
        $("span.tips").remove();

        var rgx = $(".numberKey").val();
        console.log(rgx);
        console.log("搜索中");
        $.ajax({
          url : "/getPhoneNum",
          contentType : "application/json",
          type : "POST",
          data : JSON.stringify({
            "billId_class" : $(".numberKey").val(),
            "provCode":"200",
            "cityCode":"755",
            "pageNum":1,
            "pageSize":8,
            "mno_id":"CMCC",
            "mvno_id":"ZXST01"
          }),
          success : function(data) {

            console.log(data);
            renderNumer(data.numbers)
          }
        });
      }
    });
// 定义当前页数
//var pageNum = 1;
// 点击换一组
  $(".update").click(function() {
    
	localStorage.currentPage ++;
    console.log("换一组");

    //console.log(pageNum);
    console.log("总"+localStorage.total);
    console.log("当前"+localStorage.currentPage);
    // 当点击的页数小于总页数时跳转
    if(localStorage.currentPage < localStorage.total || localStorage.currentPage == localStorage.total ){
      console.log("跳转到下一页");
      $.ajax({
        url : "/getPhoneNum",
        contentType : "application/json",
        type : "POST",
        data : JSON.stringify({
          //cardType:$(this).text(),
          "billId_class":"",
          "provCode":"200",
          "cityCode":"755",
          "pageNum":localStorage.currentPage,
          "pageSize":8,
          "mno_id":"CMCC",
          "mvno_id":"ZXST01"
        }),
        success:function(data){
          console.log(data);
          renderNumer(data.numbers)
        }
      });
    }else {
      // 当当前页数大于总页数的时候，重置当前页数，并且跳转到第一页
      localStorage.currentPage = 1;
      //console.log(pageNum);
      console.log("跳转到第一页");
      $.ajax({
        url : "/getPhoneNum",
        contentType : "application/json",
        type : "POST",
        data : JSON.stringify({
          //cardType:$(this).text(),
          "billId_class":"",
          "provCode":"200",
          "cityCode":"755",
          "pageNum":localStorage.currentPage,
          "pageSize":8,
          "mno_id":"CMCC",
          "mvno_id":"ZXST01"
        }),
        success:function(data){
          console.log(data);
          renderNumer(data.numbers)
        }
      });
    }
  });
// 点击下一步
  $("#nextStepBtn").click(
    function() {
      var activeLi = $(".numberList ul li");
      // 假设没有选中一个特定的号码
      var flag = false;
      // 存储第几个被选中
      var index;
      for (var i = 0; i < activeLi.length; i++) {
        if (activeLi.eq(i).attr("name")) {
          flag = true;
          index = i;
          // 储存被选的手机号码和资费到本地
          localStorage.numChoise = activeLi.eq(i).find(
            "span.numChoise").text();
          localStorage.numMoney = activeLi.eq(i).find(
            "span.numMoney").text();
          var numChoise = activeLi.eq(i).find(
            "span.numChoise").text();
          var numMoney = activeLi.eq(i).find("span.numMoney")
            .text();
          var number = {
            "phoneNum" : numChoise,
            "numMoney" : numMoney
          };
          /* console.log(activeLi.eq(i).find("span.numChoise")
           .text());
           console.log(activeLi.eq(i).find("span.numMoney")
           .text());
           console.log("有name这个属性"); */

        }
      }
      // 有选择一个特定的号码，进行下一步
      if (flag) {
        console.log("可以进行下一步");
        window.location.href = "number_confirm_new.html";

      } else {
        // 提示用户选择一个特定的号码
        console.log("请选择一个号码");
      }
    });
});
