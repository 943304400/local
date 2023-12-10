<template>
	<div class="addEdit-block" :style='{"minHeight":"100vh","padding":"30px","background":"url(http://codegen.caihongy.cn/20230401/bd196cf1072f48afae5676066a72e297.jpg) fixed no-repeat center top / 100% 100%"}' style="width: 100%;">
		<el-form
			:style='{"padding":"20px","boxShadow":"0 0px 0px #ddd","borderRadius":"0px","background":"none"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="汽车编号" prop="qichebianhao">
					<el-input v-model="ruleForm.qichebianhao" placeholder="汽车编号" clearable  :readonly="ro.qichebianhao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="汽车编号" prop="qichebianhao">
					<el-input v-model="ruleForm.qichebianhao" placeholder="汽车编号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="汽车名称" prop="qichemingcheng">
					<el-input v-model="ruleForm.qichemingcheng" placeholder="汽车名称" clearable  :readonly="ro.qichemingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="汽车名称" prop="qichemingcheng">
					<el-input v-model="ruleForm.qichemingcheng" placeholder="汽车名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="车辆类型" prop="cheliangleixing">
					<el-select :disabled="ro.cheliangleixing" v-model="ruleForm.cheliangleixing" placeholder="请选择车辆类型" >
						<el-option
							v-for="(item,index) in cheliangleixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="车辆类型" prop="cheliangleixing">
					<el-input v-model="ruleForm.cheliangleixing"
						placeholder="车辆类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="汽车牌号" prop="qichepaihao">
					<el-input v-model="ruleForm.qichepaihao" placeholder="汽车牌号" clearable  :readonly="ro.qichepaihao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="汽车牌号" prop="qichepaihao">
					<el-input v-model="ruleForm.qichepaihao" placeholder="汽车牌号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.qichetupian" label="汽车图片" prop="qichetupian">
					<file-upload
						tip="点击上传汽车图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.qichetupian?ruleForm.qichetupian:''"
						@change="qichetupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.qichetupian" label="汽车图片" prop="qichetupian">
					<img v-if="ruleForm.qichetupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.qichetupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.qichetupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="租户账号" prop="zuhuzhanghao">
					<el-input v-model="ruleForm.zuhuzhanghao" placeholder="租户账号" clearable  :readonly="ro.zuhuzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="租户账号" prop="zuhuzhanghao">
					<el-input v-model="ruleForm.zuhuzhanghao" placeholder="租户账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="手机号码" prop="shoujihaoma">
					<el-input v-model="ruleForm.shoujihaoma" placeholder="手机号码" clearable  :readonly="ro.shoujihaoma"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="手机号码" prop="shoujihaoma">
					<el-input v-model="ruleForm.shoujihaoma" placeholder="手机号码" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="日租价格" prop="rizujiage">
					<el-input v-model="ruleForm.rizujiage" placeholder="日租价格" clearable  :readonly="ro.rizujiage"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="日租价格" prop="rizujiage">
					<el-input v-model="ruleForm.rizujiage" placeholder="日租价格" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="出租状态" prop="chuzuzhuangtai">
					<el-select :disabled="ro.chuzuzhuangtai" v-model="ruleForm.chuzuzhuangtai" placeholder="请选择出租状态" >
						<el-option
							v-for="(item,index) in chuzuzhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="出租状态" prop="chuzuzhuangtai">
					<el-input v-model="ruleForm.chuzuzhuangtai"
						placeholder="出租状态" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info'&& !ro.zuchehetong" label="租车合同" prop="zuchehetong">
					<file-upload
						tip="点击上传租车合同"
						action="file/upload"
						:limit="1"
						:multiple="true"
						:fileUrls="ruleForm.zuchehetong?ruleForm.zuchehetong:''"
						@change="zuchehetongUploadChange"
					></file-upload>
				</el-form-item>  
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.zuchehetong" label="租车合同" prop="zuchehetong">
					<el-button :style='{"border":"0px solid #47afce","cursor":"pointer","padding":"0 35px","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#9fc4ee","width":"auto","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="text" size="small" @click="download($base.url+ruleForm.zuchehetong)">下载</el-button>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="!ruleForm.zuchehetong" label="租车合同" prop="zuchehetong">
					<el-button :style='{"border":"0px solid #47afce","cursor":"pointer","padding":"0 35px","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#9fc4ee","width":"auto","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="text" size="small">无</el-button>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="type!='info'"  label="汽车介绍" prop="qichejieshao">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.qichejieshao" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.qichejieshao" label="汽车介绍" prop="qichejieshao">
                    <span :style='{"fontSize":"16px","lineHeight":"40px","color":"#666","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.qichejieshao"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#9fc4ee","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"0px solid #1b5a90","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#ccc","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"0px solid #1b5a90","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#fff","borderRadius":"4px","background":"#ccc","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				qichebianhao : false,
				qichemingcheng : false,
				cheliangleixing : false,
				qichepaihao : false,
				qichetupian : false,
				zuhuzhanghao : false,
				shoujihaoma : false,
				rizujiage : false,
				chuzuzhuangtai : false,
				qichejieshao : false,
				zuchehetong : false,
				clicktime : false,
			},
			
			
			ruleForm: {
				qichebianhao: '',
				qichemingcheng: '',
				cheliangleixing: '',
				qichepaihao: '',
				qichetupian: '',
				zuhuzhanghao: '',
				shoujihaoma: '',
				rizujiage: '',
				chuzuzhuangtai: '待出租',
				qichejieshao: '',
				zuchehetong: '',
				clicktime: '',
			},
		
			cheliangleixingOptions: [],
			chuzuzhuangtaiOptions: [],
			
			rules: {
				qichebianhao: [
				],
				qichemingcheng: [
					{ required: true, message: '汽车名称不能为空', trigger: 'blur' },
				],
				cheliangleixing: [
					{ required: true, message: '车辆类型不能为空', trigger: 'blur' },
				],
				qichepaihao: [
				],
				qichetupian: [
				],
				zuhuzhanghao: [
				],
				shoujihaoma: [
					{ validator: validateMobile, trigger: 'blur' },
				],
				rizujiage: [
					{ required: true, message: '日租价格不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				chuzuzhuangtai: [
					{ required: true, message: '出租状态不能为空', trigger: 'blur' },
				],
				qichejieshao: [
				],
				zuchehetong: [
				],
				clicktime: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='qichebianhao'){
							this.ruleForm.qichebianhao = obj[o];
							this.ro.qichebianhao = true;
							continue;
						}
						if(o=='qichemingcheng'){
							this.ruleForm.qichemingcheng = obj[o];
							this.ro.qichemingcheng = true;
							continue;
						}
						if(o=='cheliangleixing'){
							this.ruleForm.cheliangleixing = obj[o];
							this.ro.cheliangleixing = true;
							continue;
						}
						if(o=='qichepaihao'){
							this.ruleForm.qichepaihao = obj[o];
							this.ro.qichepaihao = true;
							continue;
						}
						if(o=='qichetupian'){
							this.ruleForm.qichetupian = obj[o];
							this.ro.qichetupian = true;
							continue;
						}
						if(o=='zuhuzhanghao'){
							this.ruleForm.zuhuzhanghao = obj[o];
							this.ro.zuhuzhanghao = true;
							continue;
						}
						if(o=='shoujihaoma'){
							this.ruleForm.shoujihaoma = obj[o];
							this.ro.shoujihaoma = true;
							continue;
						}
						if(o=='rizujiage'){
							this.ruleForm.rizujiage = obj[o];
							this.ro.rizujiage = true;
							continue;
						}
						if(o=='chuzuzhuangtai'){
							this.ruleForm.chuzuzhuangtai = obj[o];
							this.ro.chuzuzhuangtai = true;
							continue;
						}
						if(o=='qichejieshao'){
							this.ruleForm.qichejieshao = obj[o];
							this.ro.qichejieshao = true;
							continue;
						}
						if(o=='zuchehetong'){
							this.ruleForm.zuchehetong = obj[o];
							this.ro.zuchehetong = true;
							continue;
						}
						if(o=='clicktime'){
							this.ruleForm.clicktime = obj[o];
							this.ro.clicktime = true;
							continue;
						}
				}
				









				this.ruleForm.chuzuzhuangtai='待出租'



			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.zuhuzhanghao!=''&&json.zuhuzhanghao) || json.zuhuzhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.zuhuzhanghao = json.zuhuzhanghao
						this.ro.zuhuzhanghao = true;
					}
					if(((json.shoujihaoma!=''&&json.shoujihaoma) || json.shoujihaoma==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.shoujihaoma = json.shoujihaoma
						this.ro.shoujihaoma = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/cheliangleixing/cheliangleixing`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.cheliangleixingOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
            this.chuzuzhuangtaiOptions = "已出租,待出租,维修中".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `cheliangxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.qichejieshao = this.ruleForm.qichejieshao.replace(reg,'../../../springboot852x9/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {










	if(this.ruleForm.qichetupian!=null) {
		this.ruleForm.qichetupian = this.ruleForm.qichetupian.replace(new RegExp(this.$base.url,"g"),"");
	}












	if(this.ruleForm.zuchehetong!=null) {
		this.ruleForm.zuchehetong = this.ruleForm.zuchehetong.replace(new RegExp(this.$base.url,"g"),"");
	}



var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "cheliangxinxi/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `cheliangxinxi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.cheliangxinxiCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `cheliangxinxi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.cheliangxinxiCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.cheliangxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    qichetupianUploadChange(fileUrls) {
	    this.ruleForm.qichetupian = fileUrls;
    },
    zuchehetongUploadChange(fileUrls) {
	    this.ruleForm.zuchehetong = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 180px;
	  	  font-size: 16px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #d3e5f3;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #666;
	  	  width: auto;
	  	  font-size: 16px;
	  	  min-width: 400px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #d3e5f3;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #666;
	  	  width: auto;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #d3e5f3;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #666;
	  	  width: auto;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px solid #d3e5f3;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  color: #d3e5f3;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #d3e5f3;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  color: #d3e5f3;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #d3e5f3;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  color: #d3e5f3;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 80px;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #d3e5f3;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #666;
	  	  width: 400px;
	  	  font-size: 16px;
	  	  min-height: 120px;
	  	  height: auto;
	  	}
</style>
