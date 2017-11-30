$(document).ready(function(){
	//input框样式的插件初始化
	  $('input').iCheck({
	    checkboxClass: 'icheckbox_square-blue',
	    radioClass: 'iradio_square-blue',
	    increaseArea: '20%' // optional
	  });
	  
	$("#payButton").click(function(){
		var typeID=$("input[name='iCheck']:checked").val();
		var payableMoney=$("#payableMoney").text();
		console.log(payableMoney);
		$.ajax({
			type:"post",
			url:"/binaryQRCode",
			async:true,
			data:{
				"url":"http://www.baidu.com"
			},
			success:function(data){
				$('#img').attr('src', 'data:image/jpg;base64,' + data);
			}
		});
	})
      
});