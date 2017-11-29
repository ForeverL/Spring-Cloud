$(function(){
	//选择密保验证方式进行身份验证
	var billId=storage.getItem("data");
	var idCardNum =$("#idCardNum").val();
	$("#billId").text(billId);
	$("#comfirmIdCard").click({
		var data={
			"billId":billId,
			"comfirmIdCard":comfirmIdCard
		};
		$.ajax({
			type:"put",
			url:"",
			async:true,
			data:JSON.stringify(data),
			success:function(data){
				if(data.message=="成功"){
//	          alert("验证通过");
				}
			}
		});
	})
})
