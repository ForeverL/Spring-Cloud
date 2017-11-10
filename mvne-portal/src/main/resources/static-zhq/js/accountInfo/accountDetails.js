$(function () {
  // 条形图
  // 基于准备好的dom，初始化echarts实例
  var barChart = echarts.init(document.getElementById('barChart'));

  //app.title = '坐标轴刻度与标签对齐';
  option = {
    color: ['#3398DB'],
    tooltip : {
      trigger: 'item',
      formatter: "{a} <br/>{b}:  {c} (元)",
    },
    grid: {
      left: '3%',
      right: '4%',
      bottom: '3%',
      containLabel: true
    },
    data :[{
      name:['2017-03', '2017-03', '2017-04', '2017-05', '2017-06']
    }],
    xAxis : [
      {
        type : 'category',
        data : ['2017-03', '2017-03', '2017-04', '2017-05', '2017-06'],
        axisTick: {
          alignWithLabel: true
        }
      }
    ],
    yAxis : [
      {
        type : 'value'
      }
    ],
    series : [
      {
        name:'近6个月消费趋势图（单位：元）',
        type:'bar',
        barWidth: '60%',
        data:[210, 200, 180, 204, 290],
        // 在柱状图上面放字
        itemStyle: {
          normal: {
            label: {
              show: true,
              position: 'top',
              textStyle: {
                color: '#615a5a'
              },
              formatter:function(params){
                if(params.value==0){
                  return '';
                }else {
                  return params.value;
                }
              }
            }
          }
        },
      }
    ]
  };
  // 使用刚指定的配置项和数据显示图表。
  barChart.setOption(option);


  // 饼图
  // 基于准备好的dom，初始化echarts实例
  var PIChart = echarts.init(document.getElementById('PIChart'));

  //app.title = '坐标轴刻度与标签对齐';
  option = {
    tooltip: {
      trigger: 'item',
      formatter: "{a} <br/>{b}: {c} ({d}%)",
    },
    legend: {
      orient: 'vertical',
      x: '400',
      y:'150',
      data:['套餐及固定费用','语言通话费用','短彩信费用','上网费']
    },
    series: [
      {
        name:'访问来源',
        type:'pie',
        radius: ['60%', '70%'],
        avoidLabelOverlap: false,
        center:[180,200],// 调饼图的位置
        label: {
          normal: {
            show: false,
            position: 'center',
          },
          emphasis: {
            show: true,
            textStyle: {
              fontSize: '24',
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
          {value:335, name:'套餐及固定费用'},
          {value:310, name:'语言通话费用'},
          {value:234, name:'短彩信费用'},
          {value:135, name:'上网费'},
        ]
      }
    ]
  };


  // 使用刚指定的配置项和数据显示图表。
  PIChart.setOption(option);
});