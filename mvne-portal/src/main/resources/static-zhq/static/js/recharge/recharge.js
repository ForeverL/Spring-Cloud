$(function(){
	$(".money ul li").click(function(){
		$(this).find("a").addClass("on").parent("li").siblings().find("a").removeClass("on");
	})
})