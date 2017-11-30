$(function () {
  window.onresize = function () {
    var win = $(window).width(),
      body = $('body');
    if(win < 1100){
      // body.addClass('min-width');
      // console.log("124");
    }
  }
  // 登陆状态
  /*if(storage){
    var str = "<ul class='countNav countNavHome'>"+
      "<li class='searchFrame countNavLi'>"+
      "<a class='searchInput' href='javascript:;'>"+
      "<i class='search'></i><input id='searchIpt' type='text' placeholder='实名'>"+
      "</a>"+
      "<ul class='historyRecord' style='display: none'>"+
      "<li>实名验证</li>"+
      "<li>身份证验证</li>"+
      "</ul>"+
      "</li>"+
      "<li class='accountFrame'>"+
      "<a class='logo' href='javascript:;'>登  录</a>"+
    "</li>"+
    "<li class='clearfix'></li>"+
      "</ul>"
    $(".loginRight").append(str);
  }else { // 非登陆状态
    var str = "<ul class='countNav'>"+
      "<li class='searchFrame'><a class='searchBtn' href='javascript:;'></a></li>"+
      "<li class='accountFrame'><a class='account' href='javascript:;'></a></li>"+
      "<li><a class='personText' href='../personalCenter/personal_info.html'>个人中心</a></li>"+
      "<li><a class='quit' href='javascript:;'>退出</a></li>"+
      "</ul>"
    $(".loginRight").append(str);
  }*/
});