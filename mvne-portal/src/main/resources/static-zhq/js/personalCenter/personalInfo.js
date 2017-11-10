$(function(){
	//根据当前时间切换问候语
var now = new Date();
 var hour = now.getHours();
// console.log(hour);
 if (hour >= 6 && hour < 12){
 	$(".showTime").text("早上好！");
// 	console.log("早上好！");
    }
else if (hour >= 12 && hour < 14){
	$(".showTime").text("中午好！");
   }
else if (hour >= 14 && hour < 18){
	$(".showTime").text("下午好！");
    }
else {
	$(".showTime").text("晚上好！");
    }
})
//      echarts的使用
//流量
      var myChart = echarts.init(document.getElementById('flux'));
      var  	option = {
			    tooltip: {
			        trigger: 'item',
			        formatter: "{a} <br/>{b}: {c} ({d}%)"
			    },
			    legend: {
			        orient: 'horizontal',
			        x: 'center',
			        data:['已用流量','剩余流量']
			    },
			    graphic:{
			    elements:[
			    {	type:'text',
				    	left:'center',
				    	top:'40%',
				    	z:2,
				    	zlever:2,
				    	style:{
				    		text:'可用/M',
				    		fill:'#666',
				    		font: '16px "STHeiti", sans-serif'
				    	}
				    	},
			    {
			    		type:'text',
				    	left:'center',
				    	top:'47%',
				    	z:2,
				    	zlever:2,
				    	style:{
				    		text:'500',
				    		fill:'#666',
				    		font: '32px "STHeiti", sans-serif'
				    	}
			    },
			        {
			    		type:'text',
				    	left:'center',
				    	top:'62%',
				    	z:2,
				    	zlever:2,
				    	style:{
				    		text:'总量1G',
				    		fill:'#666',
				    		font: '16px "STHeiti", sans-serif'
				    	}
			    },
			    ],
			    },
			    series: [
			        {
			            name:'流量',
			            type:'pie',
			            radius: ['73%', '80%'],
			            avoidLabelOverlap: false,
			            clockwise:false,
			            startAngle:0,
			            color:['#ecedee','#53b9da'],
			            label: {
			                normal: {
			                    show: false,
			                    position: 'left'
			                },
			                emphasis: {
			                    show: false,
			                    textStyle: {
			                        fontSize: '26',
			                        fontWeight: 'bold'
			                    }
			                }
			            },
			            labelLine: {
			                normal: {
			                    show: false
			                }
			            },
			            data:[
			                {value:500, name:'已用流量'},
			                {value:500, name:'剩余流量'}
			               
			            ]
			        }
			    ]
			};
      // 使用刚指定的配置项和数据显示图表。
     myChart.setOption(option);
//语音
  var myChart = echarts.init(document.getElementById('voice'));
  var  	option = {
		    tooltip: {
		        trigger: 'item',
	        formatter: "{a} <br/>{b}: {c} ({d}%)"
	    },
	    legend: {
	        orient: 'horizontal',
	        x: 'center',
	        data:['已用语音','剩余语音']
	    },
	    graphic:{
	    elements:[
	    {	type:'text',
		    	left:'center',
		    	top:'40%',
		    	z:2,
		    	zlever:2,
		    	style:{
		    		text:'可用/分钟',
		    		fill:'#666',
		    		font: '16px "STHeiti", sans-serif'
		    	}
		    	},
	    {
	    		type:'text',
		    	left:'center',
		    	top:'47%',
		    	z:2,
		    	zlever:2,
		    	style:{
		    		text:'100',
		    		fill:'#666',
		    		font: '32px "STHeiti", sans-serif'
		    	}
	    },
	        {
	    		type:'text',
		    	left:'center',
		    	top:'62%',
		    	z:2,
		    	zlever:2,
		    	style:{
		    		text:'总量200分钟',
		    		fill:'#666',
		    		font: '16px "STHeiti", sans-serif'
		    	}
	    },
	    ],
	    },
	    series: [
	        {
	            name:'语音',
	            type:'pie',
	            radius: ['73%', '80%'],
	            avoidLabelOverlap: false,
	            clockwise:false,
	            startAngle:0,
	            color:['#ecedee','#53b9da'],
	            label: {
	                normal: {
	                    show: false,
	                    position: 'left'
	                },
	                emphasis: {
	                  show: false,
	                    textStyle: {
	                        fontSize: '26',
	                        fontWeight: 'bold'
	                    }
	                }
	            },
	            labelLine: {
	                normal: {
	                    show: false
	                }
	            },
	            data:[
	                {value:500, name:'已用语音'},
	                {value:500, name:'剩余语音'}
		               
		            ]
		        }
		    ]
		};
  // 使用刚指定的配置项和数据显示图表。
 myChart.setOption(option);
    //wlan
  var myChart = echarts.init(document.getElementById('wlan'));
  var  	option = {
		    tooltip: {
		        trigger: 'item',
	        formatter: "{a} <br/>{b}: {c} ({d}%)"
	    },
	    /*legend: {
	        orient: 'horizontal',
	        x: 'center',
	        data:['已用wlan','剩余wlan']
	    },*/
	    graphic:{
	    elements:[
	    {	type:'text',
		    	left:'center',
		    	top:'40%',
		    	z:2,
		    	zlever:2,
		    	style:{
		    		text:'',
		    		fill:'#666',
		    		font: '16px "STHeiti", sans-serif'
		    	}
		    	},
	    {
	    		type:'text',
		    	left:'center',
		    	top:'47%',
		    	z:2,
		    	zlever:2,
		    	style:{
		    		text:'暂未开通',
		    		fill:'#666',
		    		font: '32px "STHeiti", sans-serif'
		    	}
	    },
	        {
	    		type:'text',
		    	left:'center',
		    	top:'62%',
		    	z:2,
		    	zlever:2,
		    	style:{
		    		text:'',
		    		fill:'#666',
		    		font: '16px "STHeiti", sans-serif'
		    	}
	    },
	    ],
	    },
	    series: [
	        {
	            name:'wlan',
	            type:'pie',
	            radius: ['73%', '80%'],
	            avoidLabelOverlap: false,
	            clockwise:false,
	            startAngle:0,
	            color:['#ecedee','#53b9da'],
	            label: {
	                normal: {
	                    show: false,
	                    position: 'left'
	                },
	                emphasis: {
	                    show: false,
	                    textStyle: {
	                        fontSize: '26',
	                        fontWeight: 'bold'
	                    }
	                }
	            },
	            labelLine: {
	                normal: {
	                    show: false
	                }
	            },
	            data:[
	                {value:100, name:'暂未开通wlan'},
	                {value:0, name:'剩余wlan'}
		               
		            ]
		        }
		    ]
		};
  // 使用刚指定的配置项和数据显示图表。
             myChart.setOption(option);
  //彩信
  var myChart = echarts.init(document.getElementById('MMS'));
  var  	option = {
		    tooltip: {
		        trigger: 'item',
	        formatter: "{a} <br/>{b}: {c} ({d}%)"
	    },
	    legend: {
	        orient: 'horizontal',
	        x: 'center',
	        data:['已用彩信','剩余彩信']
	    },
	    graphic:{
	    elements:[
	    {	type:'text',
		    	left:'center',
		    	top:'40%',
		    	z:2,
		    	zlever:2,
		    	style:{
		    		text:'可用/条',
		    		fill:'#666',
		    		font: '16px "STHeiti", sans-serif'
		    	}
		    	},
	    {
	    		type:'text',
		    	left:'center',
		    	top:'47%',
		    	z:2,
		    	zlever:2,
		    	style:{
		    		text:'10',
		    		fill:'#666',
		    		font: '32px "STHeiti", sans-serif'
		    	}
	    },
	        {
	    		type:'text',
		    	left:'center',
		    	top:'62%',
		    	z:2,
		    	zlever:2,
		    	style:{
		    		text:'总量20条',
		    		fill:'#666',
		    		font: '16px "STHeiti", sans-serif'
		    	}
	    },
	    ],
	    },
	    series: [
	        {
	            name:'彩信',
	            type:'pie',
	            radius: ['73%', '80%'],
	            avoidLabelOverlap: false,
	            clockwise:false,
	            startAngle:0,
	            color:['#ecedee','#53b9da'],
	            label: {
	                normal: {
	                    show: false,
	                    position: 'left'
	                },
	                emphasis: {
	                    show: false,
	                    textStyle: {
	                        fontSize: '26',
	                        fontWeight: 'bold'
	                    }
	                }
	            },
	            labelLine: {
	                normal: {
	                    show: false
	                }
	            },
	            data:[
	                {value:500, name:'已用彩信'},
	                {value:500, name:'剩余彩信'}
		               
		            ]
		        }
		    ]
		};
  // 使用刚指定的配置项和数据显示图表。
             myChart.setOption(option);
  //短信
  var myChart = echarts.init(document.getElementById('message'));
  var  	option = {
		    tooltip: {
		        trigger: 'item',
	        formatter: "{a} <br/>{b}: {c} ({d}%)"
	    },
	    legend: {
	        orient: 'horizontal',
	        x: 'center',
	        data:['已用短信','剩余短信']
	    },
	    graphic:{
	    elements:[
	    {	type:'text',
		    	left:'center',
		    	top:'40%',
		    	z:2,
		    	zlever:2,
		    	style:{
		    		text:'可用/条',
		    		fill:'#666',
		    		font: '16px "STHeiti", sans-serif'
		    	}
		    	},
	    {
	    		type:'text',
		    	left:'center',
		    	top:'47%',
		    	z:2,
		    	zlever:2,
		    	style:{
		    		text:'50',
		    		fill:'#666',
		    		font: '32px "STHeiti", sans-serif'
		    	}
	    },
	        {
	    		type:'text',
		    	left:'center',
		    	top:'62%',
		    	z:2,
		    	zlever:2,
		    	style:{
		    		text:'总量100条',
		    		fill:'#666',
		    		font: '16px "STHeiti", sans-serif'
		    	}
	    },
	    ],
	    },
	    series: [
	        {
	            name:'短信',
	            type:'pie',
	            radius: ['73%', '80%'],
	            avoidLabelOverlap: false,
	            clockwise:false,
	            startAngle:0,
	            color:['#ecedee','#53b9da'],
	            label: {
	                normal: {
	                    show: false,
	                    position: 'left'
	                },
	                emphasis: {
	                    show: false,
	                    textStyle: {
	                        fontSize: '20',
	                        fontWeight: 'bold'
	                    }
	                }
	            },
	            labelLine: {
	                normal: {
	                    show: false
	                }
	            },
	            data:[
	                {value:500, name:'已用短信'},
	                {value:500, name:'剩余短信'}
		               
		            ]
		        }
		    ]
		};
  // 使用刚指定的配置项和数据显示图表。
 myChart.setOption(option);
