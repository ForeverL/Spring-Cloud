$(function(){
	//input样式初始化			
			$('input').iCheck({
		    checkboxClass: 'icheckbox_square-blue',
		    radioClass: 'iradio_square-blue',
		    increaseArea: '20%' // optional
		  });
	//查询所有地址
	refer();
//输入验证
		$("#addressForm").validate({
			rules:{
				"province":{
					required:true
				},
				"city":{
					required:true
				},
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
				"province":{
					required:"请填写省份"
				},
				"city":{
					required:"请填写城市"
				},
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

//新增按钮点击事件
	$(".addMess").click(function(){
		$("#address1Div").css("display","block");
		$("#userName").text("张三");
	});
//保存按钮点击事件,提交新增数据
	$(".save1Address").click(function(){
		//调用获取新增数据的方法
		 var newData=getNewData();
		//新增ajax请求提交数据
		$.ajax({
			type:"post",
			url:"/customer/addReceiveAddress",
			contentType : "application/json",
			async:true,
			data:JSON.stringify(newData),
			success:function(data){
				if(data.message=="成功"){
//				alert("新增成功");
					//重新查询地址
					refer();
					$("#address1Div").css("display","none");
				}
			}
		});
	});
//保存按钮点击事件,提交修改数据
	$(".saveAddress").click(function(){
		//调用获取修改数据的方法
		 var data=getData();
		//修改ajax请求提交数据
		$.ajax({
			type:"post",
			url:"",
			async:true,
			data:JSON.stringify(data),
			success:function(data){
				if(data.message=="成功"){
//				alert("修改成功");
					//重新查询地址
					refer();
					$("#addressDiv").css("display","none");
				}
			}
		});
	});
//修改点击事件，将原先的数据展示在页面
	$("#amend").click(function(){
		$("#addressDiv").css("display","block");
		var model={
		  "code": "0000",
		  "message": "成功",
		  "returnMap": null,
		  "returnObject":
		  	{
		    "receiveAddrId": 2,
		    "custId": 1,
		    "receiveName": "张三",
		    "receiveTel": "18209202332",
		    "receiveAddr": "深圳福田",
		    "zipCode": "123",
		    "isDefault": "1",
		    "createDate": 1508688000000
		 }
	};
	var html = template("messForm", model);//定义一个html变量,data 数据放在模板中
      $("#addressDiv").html(html);;//把模板放在div
		
	});
	
})

//设为默认地址方法
function setDefault(obj){
	var recieveAddrId=$(obj).parent().parent().find("input").val();
		console.log(recieveAddrId);
		var billId=storage.getItem("data");
		var data={"recieveAddrId":recieveAddrId,"billId":billId};
		$.ajax({
			type:"put",
			url:"",
			async:true,
			data:JSON.stringify(data),
			success:function(data){
				if(data.message=="成功"){
//		        	alert("删除成功");	
		        	//重新查询地址
		        	 refer();
				}
			}
		});
}
//删除点击事件
function delet(obj){
		var recieveAddrId=$(obj).parent().parent().find("input").val();
		console.log(recieveAddrId);
		var data={"recieveAddrId":recieveAddrId};
		$.ajax({
			type:"put",
			url:"/customer/delReceiveAddr/"+recieveAddrId,
			contentType : "application/json",
			async:true,
			data:JSON.stringify(data),
			success:function(data){
				if(data.message=="成功"){
//		        	alert("删除成功");	
		        	//重新查询地址
		        	 refer();
				}
			}
		});
	
}
//查询地址方法
function refer(){
	var custId="ASD0010000000016";
	var model={
		  "code": "0000",
		  "message": "成功",
		  "returnMap": null,
		  "returnObject":[
		  	{
		    "receiveAddrId": 2,
		    "custId": 1,
		    "receiveName": "张三",
		    "receiveTel": "18209202332",
		    "receiveAddr": "深圳福田",
		    "zipCode": "123",
		    "isDefault": "1",
		    "createDate": 1508688000000
		 },
		 {
		    "receiveAddrId": 1,
		    "custId": 1,
		    "receiveName": "张三",
		    "receiveTel": "18209202332",
		    "receiveAddr": "深圳福田",
		    "zipCode": "123",
		    "isDefault": "0",
		    "createDate": 1508688000000
		  }
  ]
	};
	 var html = template("addressMess", model);//定义一个html变量,data 数据放在模板中
      $("#manageDiv").html(html);;//把模板放在div
	$.ajax({
		type:"get",
		url:"/customer/getReceiveAddr/"+custId,
		contentType : "application/json",
		async:true,
		//data:custId,
		success:function(data){
			 var html = template("addressMess", data);//定义一个html变量,data 数据放在模板中
             $("#manageDiv").html(html);;//把模板放在div
		}
	});
}

//获取修改之后数据的方法
function  getData(){
	var prov= $('#distpicker select').eq(0).find("option:selected").val();
		    city = $('#distpicker select').eq(1).find("option:selected").val();
		var address=$("#address").val();
		var receiveAddr=prov+city+address;
		var receiveTel=$("#telphone").val();
		var zipCode=$("#postalcode").val();
		var receiveAddrId=$("#receiveAddrId").val();
		var receiveName =$("#userName").text();
		//判断是否设为默认地址
		var isDefault;
		if($('#checkbox-id').is(':checked')){
			 isDefault=1;
		}else{
			 isDefault=0;
		}
		var data={
			"receiveAddrId":receiveAddrId,
			"custId":"1",
			"receiveName":receiveName,
			"receiveTel":receiveTel,
			"receiveAddr":receiveAddr,
			"zipCode":zipCode,
			"isDefault":isDefault
		};
//		console.log(data);
		return data;
}
//获取新增之后数据的方法
function  getNewData(){
	var prov= $('#distpicker select').eq(0).find("option:selected").val();
		    city = $('#distpicker select').eq(1).find("option:selected").val();
		var address=$("#address").val();
		var receiveAddr=prov+city+address;
		var receiveTel=$("#telphone").val();
		var zipCode=$("#postalcode").val();
		var receiveName =$("#userName").text();
		//判断是否设为默认地址
		var isDefault;
		if($('#checkbox-id').is(':checked')){
			 isDefault=1;
		}else{
			 isDefault=0;
		}
		var data={
			"custId":"1",
			"receiveName":receiveName,
			"receiveTel":receiveTel,
			"receiveAddr":receiveAddr,
			"zipCode":zipCode,
			"isDefault":isDefault
		};
//		console.log(data);
		return data;
}
