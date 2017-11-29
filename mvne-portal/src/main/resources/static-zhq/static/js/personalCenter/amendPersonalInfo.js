  	$(function(){
  		//初始化input插件
		$('input').iCheck({
		    checkboxClass: 'icheckbox_square-blue',
		    radioClass: 'iradio_square-blue',
		    increaseArea: '20%' // optional
		  });
		  //初始化日期插件
		  laydate.render({
				  elem: '#date',//指定元素
				  type:'date',
				  format: 'yyyy年MM月dd日'
				});
		//输入验证
		$("#amendInfoForm").validate({
			rules:{
				"province":{
					required:true
				},
				"city":{
					required:true
				},
				"birthdayTime":{
					required:true
				},
				"email":{
					required:true,
					email:true
				},
				"nickName":{
					required:true,
					Nickname:true,
					maxlength:8
				}
			},
			messages : {
				"province":{
					required:"地区省份不能为空"
				},
				"city":{
					required:"地方城市不能为空"
				},
				"birthdayTime":{
					required:"生日不能为空"
				},
				"email" : {
						required : "邮箱不能为空",
						email:"请输入正确的邮箱"
					},
				   "nickName":{
					required:"请填写您的昵称",
					Nickname:"请输入由中文/英文/数字组成，不超过8个字符",
					maxlength:"仅8位字符",
				}
			},
			debug:true,
			errorPlacement:function(error,element){
			  error.appendTo(element.parent());
			}
		});
		//提交信息
		$("#saveButton").click(function(){
		 if(!$("#amendInfoForm").valid()){//触发表单验证
			return;
			}else{
				var data={
					"idCardNO":"522722199209282311",
					"custName":"莫庭修改",
					"address":"深圳市福田新洲",
					"email":"18309203453@163.com"
				}
				var billId = localStorage.numChoise;
				$.ajax({
					type:"put",
					url:"/customer/chgCmCust/"+billId,
					contentType:"application/json",
					data:JSON.stringify(
						data
					),
					async:true,
					success:function(data){
						if(data.Message=="成功"){
							alert("修改成功");
							
						}
					}
				});
			}
		})
  	})
