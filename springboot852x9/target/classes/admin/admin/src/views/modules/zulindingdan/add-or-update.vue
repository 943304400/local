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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="出租单号" prop="chuzudanhao">
					<el-input v-model="ruleForm.chuzudanhao" placeholder="出租单号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.chuzudanhao" label="出租单号" prop="chuzudanhao">
					<el-input v-model="ruleForm.chuzudanhao" placeholder="出租单号" readonly></el-input>
				</el-form-item>
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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="汽车类型" prop="qicheleixing">
					<el-input v-model="ruleForm.qicheleixing" placeholder="汽车类型" clearable  :readonly="ro.qicheleixing"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="汽车类型" prop="qicheleixing">
					<el-input v-model="ruleForm.qicheleixing" placeholder="汽车类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="汽车牌号" prop="qichepaihao">
					<el-input v-model="ruleForm.qichepaihao" placeholder="汽车牌号" clearable  :readonly="ro.qichepaihao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="汽车牌号" prop="qichepaihao">
					<el-input v-model="ruleForm.qichepaihao" placeholder="汽车牌号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="租户账号" prop="zuhuzhanghao">
					<el-input v-model="ruleForm.zuhuzhanghao" placeholder="租户账号" clearable  :readonly="ro.zuhuzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="租户账号" prop="zuhuzhanghao">
					<el-input v-model="ruleForm.zuhuzhanghao" placeholder="租户账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="联系电话" prop="shoujihaoma">
					<el-input v-model="ruleForm.shoujihaoma" placeholder="联系电话" clearable  :readonly="ro.shoujihaoma"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="联系电话" prop="shoujihaoma">
					<el-input v-model="ruleForm.shoujihaoma" placeholder="联系电话" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="日租价格" prop="rizujiage">
					<el-input v-model="ruleForm.rizujiage" placeholder="日租价格" clearable  :readonly="ro.rizujiage"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="日租价格" prop="rizujiage">
					<el-input v-model="ruleForm.rizujiage" placeholder="日租价格" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info'&& !ro.hetongwenjian" label="合同文件" prop="hetongwenjian">
					<file-upload
						tip="点击上传合同文件"
						action="file/upload"
						:limit="1"
						:multiple="true"
						:fileUrls="ruleForm.hetongwenjian?ruleForm.hetongwenjian:''"
						@change="hetongwenjianUploadChange"
					></file-upload>
				</el-form-item>  
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.hetongwenjian" label="合同文件" prop="hetongwenjian">
					<el-button :style='{"border":"0px solid #47afce","cursor":"pointer","padding":"0 35px","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#9fc4ee","width":"auto","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="text" size="small" @click="download($base.url+ruleForm.hetongwenjian)">下载</el-button>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="!ruleForm.hetongwenjian" label="合同文件" prop="hetongwenjian">
					<el-button :style='{"border":"0px solid #47afce","cursor":"pointer","padding":"0 35px","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"4px","background":"#9fc4ee","width":"auto","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="text" size="small">无</el-button>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="租赁时间" prop="zulinshijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.zulinshijian" 
						type="datetime"
						:readonly="ro.zulinshijian"
						placeholder="租赁时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.zulinshijian" label="租赁时间" prop="zulinshijian">
					<el-input v-model="ruleForm.zulinshijian" placeholder="租赁时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="还车时间" prop="haicheshijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.haicheshijian" 
						type="datetime"
						:readonly="ro.haicheshijian"
						placeholder="还车时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.haicheshijian" label="还车时间" prop="haicheshijian">
					<el-input v-model="ruleForm.haicheshijian" placeholder="还车时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="汽车状态" prop="qichezhuangtai">
					<el-select :disabled="ro.qichezhuangtai" v-model="ruleForm.qichezhuangtai" placeholder="请选择汽车状态" >
						<el-option
							v-for="(item,index) in qichezhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="汽车状态" prop="qichezhuangtai">
					<el-input v-model="ruleForm.qichezhuangtai"
						placeholder="汽车状态" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="账号" prop="zhanghao">
					<el-input v-model="ruleForm.zhanghao" placeholder="账号" clearable  :readonly="ro.zhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="账号" prop="zhanghao">
					<el-input v-model="ruleForm.zhanghao" placeholder="账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming" placeholder="姓名" clearable  :readonly="ro.xingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming" placeholder="姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" clearable  :readonly="ro.shouji"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="手机" prop="shouji">
					<el-input v-model="ruleForm.shouji" placeholder="手机" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="身份证" prop="shenfenzheng">
					<el-input v-model="ruleForm.shenfenzheng" placeholder="身份证" clearable  :readonly="ro.shenfenzheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="身份证" prop="shenfenzheng">
					<el-input v-model="ruleForm.shenfenzheng" placeholder="身份证" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="登记时间" prop="dengjishijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.dengjishijian" 
						type="datetime"
						:readonly="ro.dengjishijian"
						placeholder="登记时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.dengjishijian" label="登记时间" prop="dengjishijian">
					<el-input v-model="ruleForm.dengjishijian" placeholder="登记时间" readonly></el-input>
				</el-form-item>
			</template>
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
				chuzudanhao : false,
				qichebianhao : false,
				qichemingcheng : false,
				qicheleixing : false,
				qichepaihao : false,
				zuhuzhanghao : false,
				shoujihaoma : false,
				rizujiage : false,
				hetongwenjian : false,
				zulinshijian : false,
				haicheshijian : false,
				qichezhuangtai : false,
				zhanghao : false,
				xingming : false,
				shouji : false,
				shenfenzheng : false,
				dengjishijian : false,
			},
			
			
			ruleForm: {
				chuzudanhao: this.getUUID(),
				qichebianhao: '',
				qichemingcheng: '',
				qicheleixing: '',
				qichepaihao: '',
				zuhuzhanghao: '',
				shoujihaoma: '',
				rizujiage: '',
				hetongwenjian: '',
				zulinshijian: '',
				haicheshijian: '',
				qichezhuangtai: '未归还',
				zhanghao: '',
				xingming: '',
				shouji: '',
				shenfenzheng: '',
				dengjishijian: '',
			},
		
			qichezhuangtaiOptions: [],
			
			rules: {
				chuzudanhao: [
				],
				qichebianhao: [
				],
				qichemingcheng: [
				],
				qicheleixing: [
				],
				qichepaihao: [
				],
				zuhuzhanghao: [
				],
				shoujihaoma: [
					{ validator: validateMobile, trigger: 'blur' },
				],
				rizujiage: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				hetongwenjian: [
				],
				zulinshijian: [
					{ required: true, message: '租赁时间不能为空', trigger: 'blur' },
				],
				haicheshijian: [
					{ required: true, message: '还车时间不能为空', trigger: 'blur' },
				],
				qichezhuangtai: [
				],
				zhanghao: [
				],
				xingming: [
				],
				shouji: [
					{ validator: validateMobile, trigger: 'blur' },
				],
				shenfenzheng: [
					{ validator: validateIdCard, trigger: 'blur' },
				],
				dengjishijian: [
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
		this.ruleForm.dengjishijian = this.getCurDateTime()
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
						if(o=='chuzudanhao'){
							this.ruleForm.chuzudanhao = obj[o];
							this.ro.chuzudanhao = true;
							continue;
						}
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
						if(o=='qicheleixing'){
							this.ruleForm.qicheleixing = obj[o];
							this.ro.qicheleixing = true;
							continue;
						}
						if(o=='qichepaihao'){
							this.ruleForm.qichepaihao = obj[o];
							this.ro.qichepaihao = true;
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
						if(o=='hetongwenjian'){
							this.ruleForm.hetongwenjian = obj[o];
							this.ro.hetongwenjian = true;
							continue;
						}
						if(o=='zulinshijian'){
							this.ruleForm.zulinshijian = obj[o];
							this.ro.zulinshijian = true;
							continue;
						}
						if(o=='haicheshijian'){
							this.ruleForm.haicheshijian = obj[o];
							this.ro.haicheshijian = true;
							continue;
						}
						if(o=='qichezhuangtai'){
							this.ruleForm.qichezhuangtai = obj[o];
							this.ro.qichezhuangtai = true;
							continue;
						}
						if(o=='zhanghao'){
							this.ruleForm.zhanghao = obj[o];
							this.ro.zhanghao = true;
							continue;
						}
						if(o=='xingming'){
							this.ruleForm.xingming = obj[o];
							this.ro.xingming = true;
							continue;
						}
						if(o=='shouji'){
							this.ruleForm.shouji = obj[o];
							this.ro.shouji = true;
							continue;
						}
						if(o=='shenfenzheng'){
							this.ruleForm.shenfenzheng = obj[o];
							this.ro.shenfenzheng = true;
							continue;
						}
						if(o=='dengjishijian'){
							this.ruleForm.dengjishijian = obj[o];
							this.ro.dengjishijian = true;
							continue;
						}
				}
				












				this.ruleForm.qichezhuangtai='未归还'





			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.zhanghao!=''&&json.zhanghao) || json.zhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.zhanghao = json.zhanghao
						this.ro.zhanghao = true;
					}
					if(((json.xingming!=''&&json.xingming) || json.xingming==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.xingming = json.xingming
						this.ro.xingming = true;
					}
					if(((json.shouji!=''&&json.shouji) || json.shouji==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.shouji = json.shouji
						this.ro.shouji = true;
					}
					if(((json.shenfenzheng!=''&&json.shenfenzheng) || json.shenfenzheng==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.shenfenzheng = json.shenfenzheng
						this.ro.shenfenzheng = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.qichezhuangtaiOptions = "已归还,未归还".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `zulindingdan/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {


















	if(this.ruleForm.hetongwenjian!=null) {
		this.ruleForm.hetongwenjian = this.ruleForm.hetongwenjian.replace(new RegExp(this.$base.url,"g"),"");
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
				url: "zulindingdan/page", 
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
					   url: `zulindingdan/${!this.ruleForm.id ? "save" : "update"}`,
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
						 this.parent.zulindingdanCrossAddOrUpdateFlag = false;
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
			   url: `zulindingdan/${!this.ruleForm.id ? "save" : "update"}`,
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
				 this.parent.zulindingdanCrossAddOrUpdateFlag = false;
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
      this.parent.zulindingdanCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    hetongwenjianUploadChange(fileUrls) {
	    this.ruleForm.hetongwenjian = fileUrls;
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
