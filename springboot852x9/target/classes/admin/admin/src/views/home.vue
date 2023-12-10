<template>
<div class="content" :style='{"minHeight":"100vh","padding":"30px","background":"url(http://codegen.caihongy.cn/20230401/bd196cf1072f48afae5676066a72e297.jpg) fixed no-repeat center top / 100% 100%"}'>
	<div class="text" :style='{"margin":"30px auto","fontSize":"32px","color":"#333","textAlign":"center","fontWeight":"bold"}'>欢迎使用 {{this.$project.projectName}}</div>
    <div class="cardView">
        <div class="cards" :style='{"margin":"50px 0","alignItems":"center","justifyContent":"center","display":"flex"}'>
			<div :style='{"border":"1px solid #e2ecf4","boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"8px","background":"#fff","display":"flex"}' v-if="isAuth('cheliangxinxi','首页总数')">
				<div :style='{"borderColor":"#e2ecf4","borderRadius":"8px 0 0 8px","background":"url(http://codegen.caihongy.cn/20230224/7b9ac76e6ed4427d925b003bcf9bf4c5.png) no-repeat center center / 60% auto","borderWidth":"0 1px 0 0","width":"100px","borderStyle":"solid","height":"100px"}'></div>
				<div :style='{"alignItems":"center","borderRadius":"0 8px 8px 0","flexDirection":"column","background":"#fff","display":"flex","width":"180px","justifyContent":"center"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"30px","color":"#555","fontWeight":"bold","height":"24px"}'>{{cheliangxinxiCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>车辆信息总数</div>
				</div>
			</div>
			<div :style='{"border":"1px solid #e2ecf4","boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"8px","background":"#fff","display":"flex"}' v-if="isAuth('zulindingdan','首页总数')">
				<div :style='{"borderColor":"#e2ecf4","borderRadius":"8px 0 0 8px","background":"url(http://codegen.caihongy.cn/20230224/7b9ac76e6ed4427d925b003bcf9bf4c5.png) no-repeat center center / 60% auto","borderWidth":"0 1px 0 0","width":"100px","borderStyle":"solid","height":"100px"}'></div>
				<div :style='{"alignItems":"center","borderRadius":"0 8px 8px 0","flexDirection":"column","background":"#fff","display":"flex","width":"180px","justifyContent":"center"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"30px","color":"#555","fontWeight":"bold","height":"24px"}'>{{zulindingdanCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>租赁订单总数</div>
				</div>
			</div>
			<div :style='{"border":"1px solid #e2ecf4","boxShadow":"0 0px 0px rgba(0,0,0,.3)","margin":"0 10px","borderRadius":"8px","background":"#fff","display":"flex"}' v-if="isAuth('zuyongfeiyong','首页总数')">
				<div :style='{"borderColor":"#e2ecf4","borderRadius":"8px 0 0 8px","background":"url(http://codegen.caihongy.cn/20230224/7b9ac76e6ed4427d925b003bcf9bf4c5.png) no-repeat center center / 60% auto","borderWidth":"0 1px 0 0","width":"100px","borderStyle":"solid","height":"100px"}'></div>
				<div :style='{"alignItems":"center","borderRadius":"0 8px 8px 0","flexDirection":"column","background":"#fff","display":"flex","width":"180px","justifyContent":"center"}'>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"30px","color":"#555","fontWeight":"bold","height":"24px"}'>{{zuyongfeiyongCount}}</div>
					<div :style='{"margin":"5px 0","lineHeight":"24px","fontSize":"16px","color":"#666","height":"24px"}'>租用费用总数</div>
				</div>
			</div>
        </div>
        <div style="display: flex;align-items: center;width: 100%;margin-bottom: 10px;">
            <el-card style="width: 25%;margin: 0 10px;" v-if="isAuth('cheliangxinxi','首页统计')">
                <div id="cheliangxinxiChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 25%;margin: 0 10px;" v-if="isAuth('zulindingdan','首页统计')">
                <div id="zulindingdanChart1" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 25%;margin: 0 10px;" v-if="isAuth('zulindingdan','首页统计')">
                <div id="zulindingdanChart2" style="width:100%;height:400px;"></div>
            </el-card>
            <el-card style="width: 25%;margin: 0 10px;" v-if="isAuth('zuyongfeiyong','首页统计')">
                <div id="zuyongfeiyongChart1" style="width:100%;height:400px;"></div>
            </el-card>
        </div>
    </div>
</div>
</template>
<script>
//4
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
            cheliangxinxiCount: 0,
            zulindingdanCount: 0,
            zuyongfeiyongCount: 0,
		};
	},
  mounted(){
    this.init();
    this.getcheliangxinxiCount();
    this.cheliangxinxiChat1();
    this.getzulindingdanCount();
    this.zulindingdanChat1();
    this.zulindingdanChat2();
    this.getzuyongfeiyongCount();
    this.zuyongfeiyongChat1();
  },
  methods:{
    init(){
        if(this.$storage.get('Token')){
        this.$http({
            url: `${this.$storage.get('sessionTable')}/session`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code != 0) {
            router.push({ name: 'login' })
            }
        });
        }else{
            router.push({ name: 'login' })
        }
    },
    getcheliangxinxiCount() {
        this.$http({
            url: `cheliangxinxi/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.cheliangxinxiCount = data.data
            }
        })
    },

    cheliangxinxiChat1() {
      this.$nextTick(()=>{

        var cheliangxinxiChart1 = echarts.init(document.getElementById("cheliangxinxiChart1"),'macarons');
        this.$http({
            url: "cheliangxinxi/group/chuzuzhuangtai",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].chuzuzhuangtai);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].chuzuzhuangtai
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '租赁车辆情况',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:70
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                cheliangxinxiChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    cheliangxinxiChart1.resize();
                };
            }
        });
      })
    },






    getzulindingdanCount() {
        this.$http({
            url: `zulindingdan/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.zulindingdanCount = data.data
            }
        })
    },

    zulindingdanChat1() {
      this.$nextTick(()=>{

        var zulindingdanChart1 = echarts.init(document.getElementById("zulindingdanChart1"),'macarons');
        this.$http({
            url: "zulindingdan/group/qichepaihao",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].qichepaihao);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].qichepaihao
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '车辆租赁次数',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:70
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                zulindingdanChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    zulindingdanChart1.resize();
                };
            }
        });
      })
    },

    zulindingdanChat2() {
      this.$nextTick(()=>{

        var zulindingdanChart2 = echarts.init(document.getElementById("zulindingdanChart2"),'macarons');
        this.$http({
            url: "zulindingdan/group/qichezhuangtai",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].qichezhuangtai);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].qichezhuangtai
                    })
                }
                var option = {};
                option = {
                        title: {
                            text: '车辆归还情况',
                            left: 'center'
                        },
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                data: pArray,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                };
                // 使用刚指定的配置项和数据显示图表。
                zulindingdanChart2.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    zulindingdanChart2.resize();
                };
            }
        });
      })
    },





    getzuyongfeiyongCount() {
        this.$http({
            url: `zuyongfeiyong/count`,
            method: "get"
        }).then(({
            data
        }) => {
            if (data && data.code == 0) {
                this.zuyongfeiyongCount = data.data
            }
        })
    },

    zuyongfeiyongChat1() {
      this.$nextTick(()=>{

        var zuyongfeiyongChart1 = echarts.init(document.getElementById("zuyongfeiyongChart1"),'macarons');
        this.$http({
            url: `zuyongfeiyong/value/tijiaoshijian/qianbaojine/日`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].tijiaoshijian);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].tijiaoshijian
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '日收入',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:70
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                zuyongfeiyongChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    zuyongfeiyongChart1.resize();
                };
            }
        });
      })
    },






  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
</style>
