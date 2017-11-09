$(function(){
		//从localStorage取数据
		var json;
	     if(!window.localStorage){
//	            alert("浏览器不支持localstorage");
	            return false;
	        }else{
	            //主逻辑业务
	           var storage=window.localStorage;
	             //将JSON字符串转换成为JSON对象输出
	             json=storage.getItem("data");
	            var jsonObj=JSON.parse(json);
//	            jsonObj.serialize();
	            console.log(jsonObj);
	        //模板绑数据 
   	
	      var html = template("test", jsonObj);//定义一个html变量,data 数据放在模板中
	
           $("#comentList").html(html);;//把模板放在div
	        } 
	        //提交订单
	       /* var flag=true;
	        if(flag){
	        	flag=false;
	        }*/
	        $("#orderSubmit").click(function(){
             /* ajaxhttp.method(url+phonenumber,json,"post", function(data){
              	console.log(data);
                 	if(data) {
                 		
                 		
                 	}
                 	
                 });*/
                 window.location.href="online_pay.html";
	        });
	        
})
