<template>
      <div class="heads">
        <div class="po" style="margin-top: 20px;"><h4><strong>全国各省高校数量</strong></h4></div>
        <div class="po" id="myChart" :style="{width: '1000px', height: '500px'}"></div>

        <v-chart class="chart" :option="option" />
      </div>
  </template>
  
  <script>
  
import * as echarts from 'echarts';

  export default {
    name: 'myAnalysis',

    data () {
  return {
   msg: 'Welcome to Your Vue.js App',
   option:{},
  }
 },
 mounted(){
  this.drawLine();
 },
 methods: {
  drawLine(){
    // 基于准备好的dom，初始化echarts实例
    let myChart = this.$echarts.init(document.getElementById('myChart'))
    // 绘制图表
    myChart.setOption({
      title: { text: '' },
      tooltip: {},
      xAxis: {
        data: ["南海诸岛","北京","天津","上海","重庆","河北","河南","云南","辽宁","黑龙江","湖南","安徽","山东","新疆","江苏","浙江","江西","湖北","广西","甘肃","山西","内蒙古","陕西","吉林","福建","贵州","广东","青海","西藏","四川","宁夏","海南","台湾","香港","澳门"],
        axisLabel:{  
                    interval:0,//横轴信息全部显示  
                    rotate:-40,//-30度角倾斜显示  
          }  
      },
      yAxis: {},
      series: [{
        name: '高校数量',
        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
          { offset: 0, color: '#FFD2D2' },
          { offset: 0.5, color: '#FF9797' },
          { offset: 1, color: '#FF0000' }
        ]),
        type: 'bar',
        data: [0, 92, 56, 64, 70, 124, 156, 82, 114, 78, 130, 121, 153, 55, 168, 109, 106, 130, 85, 49, 82, 54, 97, 66, 89, 75, 160, 12, 7, 134, 20, 21, 171, 18, 11],
        itemStyle: {
        normal: {
            label: {
              show: true, //开启显示
              position: 'top', //在上方显示
              textStyle: {
                //数值样式
                color: 'black',
                fontSize: 12,
              },
            },
          },
      },
      }]
    });
  }
 }
}
</script>
<style scoped>
.po {
  text-align: center;
  margin:auto;
}
.heads{
  background-color: rgb(245, 245, 245) !important;
}
</style>
  