var qObj = {  
  elmt:'select',  
  tip:'请选择',  
  tVal:'',  
  cur:[],  
  arr:{  
    1:'您母亲的姓名是？',  
    2:'您父亲的姓名是？',  
    3:'您配偶的姓名是？',  
    4:'您配偶的生日是？',  
    5:'您的出生地是？',  
    6:'您的小学校名是？',
    7:'您的学号（工号）是？',
    8:'您最熟悉的童年好友的名字是？',
    9:'对您影响最大的人的名字是？'
  }  
}  
  
$(function(){  
  //获取所有的select选框  
  var elements = $(qObj.elmt);  
  
  //这一步只是初始化操作，将所有问题写入select选框  
  elements.each(function(i){  
    var html = '<option value="'+ qObj.tVal +'">'+ qObj.tip +'</option>';  
    for(var q in qObj.arr){  
      html += '<option value="'+ q +'">' + qObj.arr[q] + '</option>';  
    }  
    $(this).html(html);  
  });  
    
  //select选框添加监听事件  
  elements.change(function(){  
    var cValue = {},                   //用于记录当前被选中的问题  
      elmts = elements,  
      cIndex = elmts.index($(this)); //当前select选框索引值  
  
    //遍历所有select选框，记录当前每个选框的选择  
    elmts.each(function(i){  
      qObj.cur[i] = $(this).val();  
    });  
  
    //记录当前已被选中的问题，实现互斥锁  
    for(var i in qObj.cur){  
      cValue[qObj.cur[i]] = 1;  
    }  
  
    //遍历所有select选框，重置所有问题  
    elmts.each(function(i){  
      //跳过当前的select选框，因为该内容无需校正  
      if (cIndex == i) return;  
      var html = '<option value="'+ qObj.tVal +'">'+ qObj.tip +'</option>';  
      for(var q in qObj.arr){  
        //如果是互斥内容，且不属于这个选框则跳过（重点）  
        if (cValue[q] && q != qObj.cur[i]) continue;  
        html += '<option value="'+ q +'"' + (q == qObj.cur[i]?' selected="selected"': '') + '>' + qObj.arr[q] + '</option>';  
      }  
      $(this).html(html);  
    });  
  });  
  
  
  //保存按钮提交到后台新的密保
  $("#savePwProtect").click(function(){
		  var firstQuestion=$("#firstQuestion").find("option:selected").text();
		  var firstAnswer=$("#firstAnswer").val();
		  var secondQuestion=$("#secondQuestion").find("option:selected").text();
		  var secondAnswer=$("#secondAnswer").val();
	  	var thirdQuestion=$("#thirdQuestion").find("option:selected").text();
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
	  	//提交新密码
	/*  	$.ajax({
	  		type:"put",
	  		url:"",     //修改密保信息路径
	  		async:true,
	  		data:data.stringify(),
	  		success:function(data){
	  			if(data.message=="成功"){
//	  				alert("修改成功");
	  			}
	  		}
	  	});*/
  })

})  