$(function(){
	//input框样式的插件初始化
	  $('input').iCheck({
	    checkboxClass: 'icheckbox_square-blue',
	    radioClass: 'iradio_square-blue',
	    increaseArea: '20%' // optional
	  });
	//点击切换
	$("#serve").click(function(){
		$(this).find("span").addClass("active").parent().siblings().find("span").removeClass("active");
		$(".serveLogin").css("display","block");
		$(".dynamicLogin").css("display","none");
	});
	$("#dynamic").click(function(){
		$(this).find("span").addClass("active").parent().siblings().find("span").removeClass("active");
		$(".serveLogin").css("display","none");
		$(".dynamicLogin").css("display","block");
	})
		//输入验证
		$("#serveForm").validate({
			rules:{
				"password":{
					required:true,
					maxlength:6,
					minlength:6
				},
				"telphone":{
					required:true,
					phone:true,
					maxlength:11,
					minlength:11
				}
			},
			messages : {
					"password" : {
							required : "密码不能为空",
							rangelength:"密码必须是6位数字"
						},
					"telphone":{
							required:"电话号码不能为空",
							phone:"请输入正确的手机号码",
							maxlength:"仅11位数字",
							minlength:"仅11位数字",
						}
			},
			debug:true,
			errorPlacement:function(error,element){
			  error.appendTo(element.parent());
			}
		});
		//服务密码的提交按钮
		$("#serveLogin").click(function(){
			if(!$("#serveForm").valid()){//触发表单验证
			   return;
			}else{
				var billId=$("#serveTelphone").val();
				var servePwd=$("#servePwd").val();
				$.ajax({
					type:"post",
					contentType : "application/json",
					url:"/customer/loginVerify",
					async:true,
					data:JSON.stringify({
						"billId":billId,
						"svcPwd":servePwd
					}),
					success:function(data){
						if(data.message=="成功"){
							var prevLink = document.referrer;  
							if($.trim(prevLink)==''){  
							    location.href = '../homePage/index.html';  
							}else{  
//							    if(prevLink.indexOf('www.example.com')==-1){    //来自其它站点  
//							        location.href = '../homePage/index.html';  
//							    }  
							    location.href = prevLink;  
							}  
						//将号码数据存localStorage
					     if(!window.localStorage){
					            return false;
					        }else{
				            //主逻辑业务
				           var storage=window.localStorage;
				             //将数据存localS
				            storage.setItem("data",billId);
	     					   }
						}
					}
				});
			}
		})
 
})
//60秒倒计时
	 var clock = '';  
    var nums = 60;  
    var btn;  
    function getDynamicCode(thisButton) { //获取动态码  
        btn = thisButton;  
        btn.disabled = true; //将按钮置为不可点击  
        $("#getDynamic").css("background-color","#dddddd");
         $("#getDynamic").css("color","#ffffff");
        btn.value = '重新获取（'+nums+'）';  
        clock = setInterval(doLoop, 1000); //一秒执行一次  
    }  
    function doLoop(){  
        nums--;  
        if(nums > 0){  
            btn.value = '重新获取（'+nums+'）';  
        }else{  
            clearInterval(clock); //清除js定时器  
            btn.disabled = false;
            $("#getDynamic").css("color","#60a5f5");
            btn.value = '重新获取';  
            nums = 60; //重置时间  
        }  
    } 