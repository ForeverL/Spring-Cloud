$(function(){
		//输入验证
		$("#amendPwForm").validate({
			rules:{
				"password":{
					required:true,
					maxlength:6,
					minlength:6
				},
				"checkPassword":{required:true,equalTo:"#newPw"},
			},
			messages : {
					"password" : {
							required : "密码不能为空",
							rangelength:"密码必须是6位数字"
						},
						"checkPassword":{required : "密码不能为空",equalTo:"两次输入密码不一致"},
			},
			debug:true,
			errorPlacement:function(error,element){
			  error.appendTo(element.parent());
			}
		});
		
		//提交按钮
			$(".amendPassword").click(function(){
				if(!$("#amendPwForm").valid()){//触发表单验证
					return;
					}else{
					var billId= $("#phone").text();
					var serverPwdOld= $("#originalPw").val();
					var serverPwdNew= $("#newPw").val();
					var data={
						"billId":billId,
						"serverPwdOld":serverPwdOld,
						"serverPwdNew":serverPwdNew
					}
					alert(serverPwdNew);
		              $.ajax({
		              	type:"put",
		              	contentType : "application/json",
		              	url:"/customer/updateServerPwd",
		              	data:JSON.stringify(data),
		              	async:true,
		              	success:function(data){
		              		console.log(data.message);
		              		alert(data.message);
		              		window.location.href="personal_info.html"
		              	}
		              });
		              
					}
			});
})