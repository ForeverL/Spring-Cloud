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
					var serverPwdOld= $("#originalPw").text();
					var serverPwdNew= $("#newPw").text();
					var data={
						"billId":billId,
						"serverPwdOld":serverPwdOld,
						"serverPwdNew":serverPwdNew
					}
		              $.ajax({
		              	type:"put",
		              	url:"",
		              	data:data.stringify(),
		              	async:true,
		              	success:function(data){
		              		console.log("data");
		              	}
		              });
		              
					}
			});
})