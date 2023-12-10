<template>
	<div class="main-content" :style='{"minHeight":"100vh","padding":"30px","background":"url(http://codegen.caihongy.cn/20230401/bd196cf1072f48afae5676066a72e297.jpg) fixed no-repeat center top / 100% 100%"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"margin":"0 0 0px"}' :inline="true" :model="searchForm">
				<el-row :style='{"padding":"0px","margin":"0 auto 20px","borderRadius":"3px","textAlign":"center","background":"none","display":"block"}' >
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"50px","fontSize":"16px","fontWeight":"500","height":"50px"}' class="item-label">出租单号</label>
						<el-input v-model="searchForm.chuzudanhao" placeholder="出租单号" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"50px","fontSize":"16px","fontWeight":"500","height":"50px"}' class="item-label">汽车编号</label>
						<el-input v-model="searchForm.qichebianhao" placeholder="汽车编号" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"50px","fontSize":"16px","fontWeight":"500","height":"50px"}' class="item-label">汽车名称</label>
						<el-input v-model="searchForm.qichemingcheng" placeholder="汽车名称" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"50px","fontSize":"16px","fontWeight":"500","height":"50px"}' class="item-label">姓名</label>
						<el-input v-model="searchForm.xingming" placeholder="姓名" clearable></el-input>
					</div>
					<el-button :style='{"border":"0px solid #f2cd41","cursor":"pointer","padding":"0 34px","outline":"none","margin":"0 0px 0 10px","color":"#fff","borderRadius":"8px","background":"#9fc4ee","width":"auto","fontSize":"16px","minWidth":"100px","height":"40px"}' type="success" @click="search()">查询</el-button>
				</el-row>

				<el-row :style='{"padding":"16px 12px 10px","margin":"0 0 0px","borderColor":"#e2f0e2","flexWrap":"wrap","background":"none","borderWidth":"0px","display":"flex","width":"auto","borderStyle":"solid","zIndex":"999"}'>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 16px","margin":"0 10px 6px 0","borderColor":"#ccdeee","color":"#333","outline":"none","borderRadius":"4px","background":"linear-gradient(90deg, rgba(240,248,255,1) 0%, rgba(255,255,255,1) 50%, rgba(240,248,255,1) 100%)","borderWidth":"1px","width":"auto","fontSize":"16px","borderStyle":"solid","height":"36px"}' v-if="isAuth('zulindingdan','新增')" type="success" @click="addOrUpdateHandler()">新增</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 16px","margin":"0 10px 6px 0","borderColor":"#ccdeee","color":"#333","outline":"none","borderRadius":"4px","background":"linear-gradient(90deg, rgba(240,248,255,1) 0%, rgba(255,255,255,1) 50%, rgba(240,248,255,1) 100%)","borderWidth":"1px","width":"auto","fontSize":"16px","borderStyle":"solid","height":"36px"}' v-if="isAuth('zulindingdan','删除')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">删除</el-button>




					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 16px","margin":"0 10px 6px 0","borderColor":"#ccdeee","color":"#333","outline":"none","borderRadius":"4px","background":"linear-gradient(90deg, rgba(240,248,255,1) 0%, rgba(255,255,255,1) 50%, rgba(240,248,255,1) 100%)","borderWidth":"1px","width":"auto","fontSize":"16px","borderStyle":"solid","height":"36px"}' v-if="isAuth('zulindingdan','车辆租赁次数')" type="warning" @click="chartDialog1()">车辆租赁次数</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 16px","margin":"0 10px 6px 0","borderColor":"#ccdeee","color":"#333","outline":"none","borderRadius":"4px","background":"linear-gradient(90deg, rgba(240,248,255,1) 0%, rgba(255,255,255,1) 50%, rgba(240,248,255,1) 100%)","borderWidth":"1px","width":"auto","fontSize":"16px","borderStyle":"solid","height":"36px"}' v-if="isAuth('zulindingdan','车辆归还情况')" type="warning" @click="chartDialog2()">车辆归还情况</el-button>
				</el-row>
			</el-form>
			
			<!-- <div> -->
				<el-table class="tables"
					:stripe='true'
					:style='{"padding":"0","borderColor":"#e2ecf4","margin":"0 0 20px","borderRadius":"0px","borderWidth":"1px 1px 0 1px","background":"rgba(255,255,255,1)","width":"calc(100% - 0px)","borderStyle":"solid"}' 
					v-if="isAuth('zulindingdan','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'  
						prop="chuzudanhao"
					label="出租单号">
						<template slot-scope="scope">
							{{scope.row.chuzudanhao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="qichebianhao"
					label="汽车编号">
						<template slot-scope="scope">
							{{scope.row.qichebianhao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="qichemingcheng"
					label="汽车名称">
						<template slot-scope="scope">
							{{scope.row.qichemingcheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="qicheleixing"
					label="汽车类型">
						<template slot-scope="scope">
							{{scope.row.qicheleixing}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="qichepaihao"
					label="汽车牌号">
						<template slot-scope="scope">
							{{scope.row.qichepaihao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="zuhuzhanghao"
					label="租户账号">
						<template slot-scope="scope">
							{{scope.row.zuhuzhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="shoujihaoma"
					label="联系电话">
						<template slot-scope="scope">
							{{scope.row.shoujihaoma}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="rizujiage"
					label="日租价格">
						<template slot-scope="scope">
							{{scope.row.rizujiage}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="hetongwenjian" label="合同文件">
						<template slot-scope="scope">
							<el-button v-if="scope.row.hetongwenjian" type="text" size="small" @click="download($base.url+scope.row.hetongwenjian)">下载</el-button>
                            <span v-else >无</span>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="zulinshijian"
					label="租赁时间">
						<template slot-scope="scope">
							{{scope.row.zulinshijian}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="haicheshijian"
					label="还车时间">
						<template slot-scope="scope">
							{{scope.row.haicheshijian}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="qichezhuangtai"
					label="汽车状态">
						<template slot-scope="scope">
							{{scope.row.qichezhuangtai}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="zhanghao"
					label="账号">
						<template slot-scope="scope">
							{{scope.row.zhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="xingming"
					label="姓名">
						<template slot-scope="scope">
							{{scope.row.xingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="shouji"
					label="手机">
						<template slot-scope="scope">
							{{scope.row.shouji}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="shenfenzheng"
					label="身份证">
						<template slot-scope="scope">
							{{scope.row.shenfenzheng}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="dengjishijian"
					label="登记时间">
						<template slot-scope="scope">
							{{scope.row.dengjishijian}}
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button :style='{"border":"0px solid #1e98f5","cursor":"pointer","padding":"0 10px 0 24px","margin":"0 5px 6px","outline":"none","color":"#1e98f5","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230329/38553f099fa74a2d86e2206c373a9539.png) no-repeat left center / 20px","width":"auto","fontSize":"15px","height":"32px"}' v-if=" isAuth('zulindingdan','查看')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
							<el-button :style='{"border":"0px solid #1e98f5","cursor":"pointer","padding":"0 10px 0 24px","margin":"0 5px 6px","outline":"none","color":"#1e98f5","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230329/38553f099fa74a2d86e2206c373a9539.png) no-repeat left center / 20px","width":"auto","fontSize":"15px","height":"32px"}' v-if="isAuth('zulindingdan','汽车归还')" type="success" size="mini" @click="qicheguihaiCrossAddOrUpdateHandler(scope.row,'cross','','qichezhuangtai','已归还','已归还,未归还'.split(',')[0])">汽车归还</el-button>
							<el-button :style='{"border":"0px solid #1e98f5","cursor":"pointer","padding":"0 10px 0 24px","margin":"0 5px 6px","outline":"none","color":"#1e98f5","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230329/38553f099fa74a2d86e2206c373a9539.png) no-repeat left center / 20px","width":"auto","fontSize":"15px","height":"32px"}' v-if="isAuth('zulindingdan','提醒用户')" type="success" size="mini" @click="yonghutixingCrossAddOrUpdateHandler(scope.row,'cross','','','')">提醒用户</el-button>
							<el-button :style='{"border":"0px solid #06d5dd","cursor":"pointer","padding":"0 10px 0 24px","margin":"0 5px 6px","outline":"none","color":"#15a4aa","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230329/99f867042acb4c4aae637c8bfcf6714a.png) no-repeat left center","width":"auto","fontSize":"15px","height":"32px"}' v-if=" isAuth('zulindingdan','修改')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>





							<el-button :style='{"border":"0px solid #c00","cursor":"pointer","padding":"0 10px 0 24px","margin":"0 5px 6px","outline":"none","color":"#c00","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230329/c5ea125f385740a3a3b9aed07f5dfe2c.png) no-repeat left 6px / 20px","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('zulindingdan','删除') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination
					@size-change="sizeChangeHandle"
					@current-change="currentChangeHandle"
					:current-page="pageIndex"
					background
					:page-sizes="[10, 20, 30, 50]"
					:page-size="pageSize"
					:layout="layouts.join()"
					:total="totalPage"
					prev-text="<"
					next-text=">"
					:hide-on-single-page="true"
					:style='{"width":"calc(100% - 370px)","padding":"0","margin":"0 170px 0px 200px","whiteSpace":"nowrap","color":"#333","fontWeight":"500"}'
				></el-pagination>
			<!-- </div> -->
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

		<qicheguihai-cross-add-or-update v-if="qicheguihaiCrossAddOrUpdateFlag" :parent="this" ref="qicheguihaiCrossaddOrUpdate"></qicheguihai-cross-add-or-update>
		<yonghutixing-cross-add-or-update v-if="yonghutixingCrossAddOrUpdateFlag" :parent="this" ref="yonghutixingCrossaddOrUpdate"></yonghutixing-cross-add-or-update>




		<el-dialog
		  :visible.sync="chartVisiable1"
		  width="800">
			<div id="qichepaihaoChart1" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog1">返回</el-button>
		  </span>
		</el-dialog>
		<el-dialog
		  :visible.sync="chartVisiable2"
		  width="800">
			<div id="qichezhuangtaiChart2" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog2">返回</el-button>
		  </span>
		</el-dialog>
	</div>
</template>

<script>
//竖
//车辆租赁次数
//[]
import * as echarts from 'echarts'
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
import qicheguihaiCrossAddOrUpdate from "../qicheguihai/add-or-update";
import yonghutixingCrossAddOrUpdate from "../yonghutixing/add-or-update";
export default {
  data() {
    return {
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      chartVisiable1: false,
      chartVisiable2: false,
      chartVisiable3: false,
      chartVisiable4: false,
      chartVisiable5: false,
      addOrUpdateFlag:false,
      qicheguihaiCrossAddOrUpdateFlag: false,
      yonghutixingCrossAddOrUpdateFlag: false,
      layouts: ["total","prev","pager","next","sizes","jumper"],

    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
    qicheguihaiCrossAddOrUpdate,
    yonghutixingCrossAddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentPageStyleChange()
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      // if(this.contents.pageTotal) arr.push('total')
      // if(this.contents.pageSizes) arr.push('sizes')
      // if(this.contents.pagePrevNext){
      //   arr.push('prev')
      //   if(this.contents.pagePager) arr.push('pager')
      //   arr.push('next')
      // }
      // if(this.contents.pageJumper) arr.push('jumper')
      // this.layouts = arr.join()
      // this.contents.pageEachNum = 10
    },

    qicheguihaiCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.qicheguihaiCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','zulindingdan');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.qicheguihaiCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.qicheguihaiCrossaddOrUpdate.init(row.id,type);
      });
    },
    yonghutixingCrossAddOrUpdateHandler(row,type,crossOptAudit,statusColumnName,tips,statusColumnValue){
      this.showFlag = false;
      this.addOrUpdateFlag = false;
      this.yonghutixingCrossAddOrUpdateFlag = true;
      this.$storage.set('crossObj',row);
      this.$storage.set('crossTable','zulindingdan');
      this.$storage.set('statusColumnName',statusColumnName);
      this.$storage.set('statusColumnValue',statusColumnValue);
      this.$storage.set('tips',tips);
	if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
		var obj = this.$storage.getObj('crossObj');
		for (var o in obj){
		  if(o==statusColumnName && obj[o]==statusColumnValue){
		    this.$message({
		      message: tips,
		      type: "success",
		      duration: 1500,
		      onClose: () => {
			this.getDataList();
		      }
		    });
		      this.showFlag = true;
		      this.yonghutixingCrossAddOrUpdateFlag = false;
			return;
		  }
		}
	}
      this.$nextTick(() => {
      this.$refs.yonghutixingCrossaddOrUpdate.init(row.id,type);
      });
    },


//统计接口
    chartDialog1() {
      this.chartVisiable1 = !this.chartVisiable1;
      this.$nextTick(()=>{

        var qichepaihaoChart1 = echarts.init(document.getElementById("qichepaihaoChart1"),'macarons');
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
                qichepaihaoChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    qichepaihaoChart1.resize();
                };
            }
        });
      })
    },

//统计接口
    chartDialog2() {
      this.chartVisiable2 = !this.chartVisiable2;
      this.$nextTick(()=>{

        var qichezhuangtaiChart2 = echarts.init(document.getElementById("qichezhuangtaiChart2"),'macarons');
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
                        legend: {
                          orient: 'vertical',
                          left: 'left'
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
                qichezhuangtaiChart2.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    qichezhuangtaiChart2.resize();
                };
            }
        });
      })
    },




    init () {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.chuzudanhao!='' && this.searchForm.chuzudanhao!=undefined){
            params['chuzudanhao'] = '%' + this.searchForm.chuzudanhao + '%'
          }
           if(this.searchForm.qichebianhao!='' && this.searchForm.qichebianhao!=undefined){
            params['qichebianhao'] = '%' + this.searchForm.qichebianhao + '%'
          }
           if(this.searchForm.qichemingcheng!='' && this.searchForm.qichemingcheng!=undefined){
            params['qichemingcheng'] = '%' + this.searchForm.qichemingcheng + '%'
          }
           if(this.searchForm.xingming!='' && this.searchForm.xingming!=undefined){
            params['xingming'] = '%' + this.searchForm.xingming + '%'
          }
      this.$http({
        url: "zulindingdan/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "zulindingdan/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 1px solid #e3f2f9;
				border-radius: 8px;
				padding: 0 12px;
				box-shadow: 0 0px 0px #ccc;
				outline: none;
				color: #666;
				width: 170px;
				font-size: 16px;
				height: 40px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 1px solid #e3f2f9;
				border-radius: 8px;
				padding: 0 10px;
				box-shadow: 0 0px 0px #ccc;
				outline: none;
				color: #666;
				width: 170px;
				font-size: 16px;
				line-height: 30px;
				height: 40px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 1px solid #e3f2f9;
				border-radius: 8px;
				padding: 0 10px 0 30px;
				box-shadow: 0 0px 0px #ccc;
				outline: none;
				color: #666;
				width: 170px;
				font-size: 16px;
				height: 40px;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #999;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: linear-gradient(180deg, rgba(229,241,255,1) 0%, rgba(216,232,251,1) 100%);
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 10px;
				color: #000;
				background: none;
				border-color: #e2f0e2;
				border-width: 0 0px 0px 0;
				border-style: solid;
				text-align: center;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: none;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 2px 10px;
				color: #666;
				background: linear-gradient(180deg, rgba(240,248,255,.6) 0%, rgba(255,255,255,.6) 50%, rgba(240,248,255,.6) 100%);
				border-color: #e6eff6;
				border-width: 0 0px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
		.el-table /deep/ .el-table__body-wrapper tbody tr.el-table__row--striped td {
		background: rgba(246,254,246,.0);
	}
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 2px 10px;
				color: #333;
				background: #fff;
				border-color: #e2ecf4;
				border-width: 0 0px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 2px 10px;
				color: #666;
				background: linear-gradient(180deg, rgba(240,248,255,.6) 0%, rgba(255,255,255,.6) 50%, rgba(240,248,255,.6) 100%);
				border-color: #e6eff6;
				border-width: 0 0px 1px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #666;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 30px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 30px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 30px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 30px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #666;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				border-radius: 30px;
				background: #f4f4f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				border-radius: 30px;
				background: #9fc4ee;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				border-radius: 30px;
				background: #9fc4ee;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #606266;
				display: inline-block;
				font-size: 16px;
				line-height: 28px;
				border-radius: 30px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #606266;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 16px;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 3px;
				color: #606266;
				display: inline-block;
				font-size: 16px;
				line-height: 28px;
				border-radius: 30px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
</style>
