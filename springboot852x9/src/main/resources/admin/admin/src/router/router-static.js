import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import qicheguihai from '@/views/modules/qicheguihai/list'
    import zhifujilu from '@/views/modules/zhifujilu/list'
    import yonghutixing from '@/views/modules/yonghutixing/list'
    import zuyongfeiyong from '@/views/modules/zuyongfeiyong/list'
    import zulindingdan from '@/views/modules/zulindingdan/list'
    import discusscheliangxinxi from '@/views/modules/discusscheliangxinxi/list'
    import cheliangleixing from '@/views/modules/cheliangleixing/list'
    import zuhu from '@/views/modules/zuhu/list'
    import yonghu from '@/views/modules/yonghu/list'
    import messages from '@/views/modules/messages/list'
    import cheliangxinxi from '@/views/modules/cheliangxinxi/list'
    import config from '@/views/modules/config/list'
    import chongzhijilu from '@/views/modules/chongzhijilu/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/qicheguihai',
        name: '汽车归还',
        component: qicheguihai
      }
      ,{
	path: '/zhifujilu',
        name: '支付记录',
        component: zhifujilu
      }
      ,{
	path: '/yonghutixing',
        name: '用户提醒',
        component: yonghutixing
      }
      ,{
	path: '/zuyongfeiyong',
        name: '租用费用',
        component: zuyongfeiyong
      }
      ,{
	path: '/zulindingdan',
        name: '租赁订单',
        component: zulindingdan
      }
      ,{
	path: '/discusscheliangxinxi',
        name: '车辆信息评论',
        component: discusscheliangxinxi
      }
      ,{
	path: '/cheliangleixing',
        name: '车辆类型',
        component: cheliangleixing
      }
      ,{
	path: '/zuhu',
        name: '租户',
        component: zuhu
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/messages',
        name: '投诉反馈',
        component: messages
      }
      ,{
	path: '/cheliangxinxi',
        name: '车辆信息',
        component: cheliangxinxi
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/chongzhijilu',
        name: '充值记录',
        component: chongzhijilu
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '系统首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
