$(function(){
		$("#tb_input").validate({
			
			rules:{
				"adress":{
					required:true,
				},
				"telphone":{
					required:true,
					number:true,
					maxlength:6,
					minlength:6
				},
				"postalcode" : {
					number:true,
					maxlength:6,
					minlength:6
				}
			},
			messages : {
				"adress":{
					required:"地址不能为空"
				},
				"telphone":{
					required:"手机号码不能为空",
					number:"输入手机号码格式不正确",
					maxlength:"仅11位数字",
					minlength:"仅11位数字",
				},
				"postalcode" : {
					number:"编码必须为数字",
					maxlength:"仅6位数字",
					minlength:"仅6位数字",
				}
			}
		});
		if(!$("#tb_input").valid()){
			return;
		}
})

