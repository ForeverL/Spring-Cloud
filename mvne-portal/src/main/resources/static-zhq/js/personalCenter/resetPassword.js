$(function(){
	//输入验证
		$("#resetPasswordForm").validate({
			rules:{
				"password":{
					required:true,
					maxlength:6,
					minlength:6
				},
				"checkPassword":{required:true,equalTo:"#newPw"},
				"telphone":{
					required:true,
					phone:true,
					maxlength:11,
					minlength:11
				},
				"idCard":{
					required:true,
					IDcard:true,
					maxlength:11,
					minlength:11
				}
			},
			messages : {
					"password" : {
							required : "密码不能为空",
							rangelength:"密码必须是6位数字"
						},
						"checkPassword":{required : "密码不能为空",equalTo:"两次输入密码不一致"},
				   "telphone":{
					required:"请填写联系电话",
					phone:"请输入正确的手机号码",
					maxlength:"仅11位数字",
					minlength:"仅11位数字",
				},
					"idCard":{
						required:"请填写身份证号码",
						IDcard:"请输入正确的身份证号码",
						maxlength:"仅18位身份证号码",
						minlength:"仅18位身份证号码",
					}
			},
			debug:true,
			errorPlacement:function(error,element){
			  error.appendTo(element.parent());
			}
		});
		    //获取短信验证码
           var validCode=true;
            $(".checkButton").click (function  () {
                 var time=60;
                var $code=$(this);
                if (validCode) {
                     validCode=false;
                     var t=setInterval(function  () {
                         time--;
                         $code.html(time+"秒");
                        if (time==0) {
                            clearInterval(t);
                        $code.html("重新获取");
                             validCode=true;
                         }
                     },1000)
                 }
             });
})
