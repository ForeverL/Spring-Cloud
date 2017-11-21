$(function () {
  window.onresize = function () {
    var win = $(window).width(),
      body = $('body');
    if(win < 1100){
      // body.addClass('min-width');
      console.log("124");
    }
  }
});