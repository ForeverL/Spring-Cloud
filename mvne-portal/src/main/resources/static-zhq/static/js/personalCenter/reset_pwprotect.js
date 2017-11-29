 $(function(){
 	//选择密保验证方式进行身份验证
	    		//进入密保页，获取用户的三个密保问题
	    		$.ajax({
	    			type:"get",
	    			url:"",
//	    			data:billId,   //传入手机号码到后台
	    			async:true,
	    			success:function(data){
	    				if(data.message=="成功"){
	    					$("#firstQuestion").text(data.returnObject.firstQuestion);
	    					$("#secondQuestion").text(data.returnObject.secondQuestion);
	    					$("#thirdQuestion").text(data.returnObject.thirdQuestion);
	    				}
	    			}
	    		});
	    		//点击下一步，提交到后台验证
	    		var firstQuestion=$("#firstQuestion").text();
	    		var firstAnswer=$("#firstAnswer").val();
	    		var secondQuestion=$("#secondQuestion").text();
	    		var secondAnswer=$("#secondAnswer").val();
	    		var thirdQuestion=$("#thirdQuestion").text();
	    		var thirdAnswer=$("#thirdAnswer").val();
	    		var data={
	    			"billId":"18209202332",
					"firstQuestion":firstQuestion,
					"firstAnswer":firstAnswer,
					"secondQuestion":secondQuestion,
					"secondAnswer":secondAnswer,
					"thirdQuestion":thirdQuestion,
					"thirdAnswer":thirdAnswer
	    		};
	    				
	    		$("#modification").click(function(){
	    	/*		$.ajax({
	    				type:"post",
	    				url:"",
	    				async:true,
	    				data:data.stringify(),
	    				success:function(data){
	    				  if(data.message=="成功"){
//	    				  	alert("验证通过");
	    				  }
	    				}
	    			});*/
	    		})
	    	
 })
 	