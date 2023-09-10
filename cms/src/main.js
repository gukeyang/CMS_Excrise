//引入vue
import Vue from 'vue'
//引入App
import App from './App'
// 引入进度条 引入NProgress
// import NProgress from 'nprogress'
// // 引入nprogress样式文件
// import'nprogress/nprogress.css'
//引入VueRouter
import VueRouter from 'vue-router'
//引入路由器
import Router from './router/home'
//引入ElementUI组件库
import ElementUI from 'element-ui';
//引入ElementUI全部样式
import 'element-ui/lib/theme-chalk/index.css';
//引入全局样式表
import './assets/common.css'
//发起请求要引入axios包
import axios from 'axios'
//引入moment
import moment from 'moment'

//去除RFC2822/ISO date formats的警告
moment.suppressDeprecationWarnings = true;


//发送请求前，先对请求做一个预处理,为了让有权限的api正常调用
//设置拦截器,request就是请求拦截器,config请求对象
axios.interceptors.request.use(config=>{
  //#region 
  // console.log(config);
  // config.headers.Authorization=window.sessionStorage.getItem('token')
  // console.log(window.sessionStorage.getItem('token'));
  //#endregion
  
  config.headers.token="Bearer "+window.sessionStorage.getItem('token')
  // NProgress.start()
  //在最后必须return config
  return config
})

//配置请求的根路径
// axios.defaults.baseURL='/cms'

// axios.defaults.baseURL= "http://121.4.47.113:8081"
axios.defaults.baseURL= "http://localhost:8081"
//在vue原型对象上挂载axios，让vue的每一个组件都能通过this直接访问到$http，从而发起Ajax请求
Vue.prototype.$http=axios
//在vue实例上挂载moment方法
Vue.prototype.$moment = moment

//关闭vue的生产提示
Vue.config.productionTip = false


//应用插件
Vue.use(VueRouter)
//应用ElementUI
Vue.use(ElementUI)
//应用moment
Vue.use(moment)
//应用NProgress
// Vue.use(NProgress)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router: Router,
  render: h => h(App)
})
// axios.interceptors.response.use(config => {
//   // 关闭进度条
//   NProgress.done()
// })