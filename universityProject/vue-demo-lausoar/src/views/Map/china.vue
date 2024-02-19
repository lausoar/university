<script>
const chinaJson = require('../../utils/china.json');
export default {
  render: function(createElement) {
    return createElement("div", {
      attrs: {
        id: "main",
      },
      style: {
        height: "700px",
        width:'1000px',
        margin: 'auto'
      },
    });
  },
  data() {
    return {
      dataList: [
        { name: "南海诸岛",   },
        { ename: "beijing", name: "北京",  },
        { ename: "tianjin", name: "天津",   },
        { ename: "shanghai", name: "上海",   },
        { ename: "chongqing", name: "重庆",   },
        { ename: "hebei", name: "河北",   },
        { ename: "henan", name: "河南",  },
        { ename: "yunnan", name: "云南",   },
        { ename: "liaoning", name: "辽宁" ,  },
        { ename: "heilongjiang", name: "黑龙江",   },
        { ename: "hunan", name: "湖南",  },
        { ename: "anhui", name: "安徽",   },
        { ename: "shandong", name: "山东",   },
        { ename: "xinjiang", name: "新疆" ,  },
        { ename: "jiangsu", name: "江苏",   },
        { ename: "zhejiang", name: "浙江" ,  },
        { ename: "jiangxi", name: "江西",   },
        { ename: "hubei", name: "湖北",   },
        { ename: "guangxi", name: "广西",  },
        { ename: "gansu", name: "甘肃",  },
        { ename: "shanxi", name: "山西",   },
        { ename: "neimenggu", name: "内蒙古" ,  },
        { ename: "shanxi1", name: "陕西" ,  },
        { ename: "jilin", name: "吉林" ,  },
        { ename: "fujian", name: "福建" ,  },
        { ename: "guizhou", name: "贵州" ,  },
        { ename: "guangdong", name: "广东",   },
        { ename: "qinghai", name: "青海",   },
        { ename: "xizang", name: "西藏",   },
        { ename: "sichuan", name: "四川",   },
        { ename: "ningxia", name: "宁夏" ,  },
        { ename: "hainan", name: "海南" ,  },
        { name: "台湾",  },
        { ename: "xianggang", name: "香港" ,  },
        { ename: "aomen", name: "澳门",   },
      ],
    };
  },
  methods: {
    initEchart() {
      let dataList = this.dataList;
      // for(let i = 0; i < dataList.length; i++){
      //   dataList[i].value = Math.ceil(Math.random() * 1000 - 1);
      // }
      for(let i = 0; i < dataList.length; i++){
        var dataLists = ["高校数量", 92, 56, 64, 70, 124, 156, 82, 114, 78, 130, 121, 153, 55, 168, 109, 106, 130, 85, 49, 82, 54, 97, 66, 89, 75, 160, 12, 7, 134, 20, 21, 171, 18, 11]
        dataList[i].value = dataLists[i]
      }
        const _this = this;
      var myChart = this.$echarts.init(document.getElementById("main"));
      this.$echarts.registerMap('china', chinaJson)
      var option = {
        tooltip: {
          //数据格式化
          formatter: function(params, callback) {
            return (
              params.seriesName + "<br />" + params.name + "：" + params.value
            );
          },
        },
        visualMap: {
          min: 0,
          max: 200,
          left: "left",
          top: "bottom",
          text: ["高", "低"], //取值范围的文字
          inRange: {
            color: ["#e0ffff", "blue"], //取值范围的颜色
          },
          show: true, //图注
        },
        geo: {
          map: 'china', //引入地图数据
          roam: false, //不开启缩放和平移
          zoom: 1.2, //视角缩放比例
          label: {
            normal: {
              show: true,
              fontSize: "10",
              color: "rgba(0,0,0,0.7)",
            },
          },
          itemStyle: {
            normal: {
              borderColor: "rgba(0, 0, 0, 0.2)",
            },
            emphasis: { //高亮的显示设置
              areaColor: "skyblue", //鼠标选择区域颜色
              shadowOffsetX: 0,
              shadowOffsetY: 0,
              shadowBlur: 20,
              borderWidth: 0,
              shadowColor: "rgba(0, 0, 0, 0.5)",
            },
          },
        },
        // 鼠标悬浮提示框
        series: [
          {
            name: "高校数量",
            type: "map",
            geoIndex: 0,
            data: this.dataList,
          },
        ],
      };
      myChart.setOption(option);
      myChart.on("click", function(params) {
        if(!params.data.ename){
          alert('暂无' + params.name + '地图数据');
          return;
        }
        _this.$router.push({
          path: "/province",
          query: { provinceName: params.data.ename, province: params.name },
        });
      });
    },
  },
  mounted() {
    this.initEchart();
  },
};
</script>
