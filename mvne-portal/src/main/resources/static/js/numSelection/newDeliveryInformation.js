$(function(){
	//输入验证
		$("#tb_input").validate({
			rules:{
				"address":{
					required:true,
					maxlength:50,
				},
				"telphone":{
					required:true,
					phone:true,
					maxlength:11,
					minlength:11
				},
				"postalcode" : {
					number:true,
					maxlength:6,
					minlength:6
				}
			},
			messages : {
				"address":{
					required:"请填写详细收货地址",
					maxlength:"只能填写50个字",
				},
				"telphone":{
					required:"请填写联系电话",
					phone:"请输入正确的手机号码",
					maxlength:"仅11位数字",
					minlength:"仅11位数字",
				},
				"postalcode" : {
					maxlength:"请输入正确的邮编号码",
					minlength:"请输入正确的邮编号码",
				}
			},
			debug:true,
			errorPlacement:function(error,element){
			  error.appendTo(element.parent());
			}
		});

		//提交按钮
		$("#conformInfo").click(function(){
		if(!$("#tb_input").valid()){//触发表单验证
			return;
			}else{
		var prov= $('#distpicker select').eq(0).find("option:selected").attr('data-code'),
		      city = $('#distpicker select').eq(1).find("option:selected").attr('data-code');
		var address=$("#address").val();
		var telphone=$("#telphone").val();
		var postalcode=$("#postalcode").val();
		console.log(address);
		//数据存localStorage
	     if(!window.localStorage){
//	            alert("浏览器不支持localstorage");
	            return false;
	        }else{
	            //主逻辑业务
	           var storage=window.localStorage;
	           var data={
				"provCd": prov,
				"cityCd" : city,
				"phoneNum" : 13212122323,
				"receiverName":"张三",
				"receiverPhone":telphone,
				"receiverAddress":address,
				"postalcode":postalcode,
				"confirmId" : 000001                      
				};
			  //将JSON转换成为JSON字符串
	             var d=JSON.stringify(data);
	             //将数据存localS
	            storage.setItem("data",d);
	             //将JSON字符串转换成为JSON对象localStorage
	           
	        }
           window.location.href="order_confirm.html"
			}
		})

})		
		


