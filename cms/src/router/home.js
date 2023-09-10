//该文件专门用来创作整个应用的路由器
import VueRouter from 'vue-router'
//引入组件
import Login from '../components/login'
import Main from '../components/main'
import News from '../components/news'
import Welcome from '../components/welcome'
import Part from '../components/part'
import Minio from '../components/minio'
import Characteristic from '../components/characteristic'
import First from '../components/first'
import Second from '../components/second'
import Request from '../components/request'
import Update from '../components/update'
import Picture from '../components/picture'
import Lianxi from '../components/lianxi'


//创建并暴露一个路由器
const router= new VueRouter({
    mode:'hash',
    base: '/cp',
    routes: [
        {
            path:'/',
            redirect:'/login'
        },
        {
            path: '/login',
            component: Login,
        },
        {
            path:'/main',
            component:Main,
            redirect:'/welcome',
            children:[
                {
                    path:'/welcome',
                    component:Welcome,
                },
                {
                    path:'/news',
                    component:News,
                },
                {
                    path:'/part',
                    component:Part,
                },
                {
                    path:'/minio',
                    component:Minio,
                },
                {
                    path:'/picture',
                    component:Picture,
                },
                {
                    path:'/characteristic',
                    component:Characteristic,
                },
                {
                    path:'/first',
                    component:First,
                },
                {
                    path:'/second',
                    component:Second,
                },
                {
                    path:'/request',
                    component:Request,
                },
                {
                    path:'/update',
                    component:Update,
                },
                {
                    path:'/lianxi',
                    component:Lianxi,
                },
            ]
        },
    ]
})

//挂载路由导航守卫beforeEach控制访问权限，防止用户在没有登录的情况下，直接通过url访问有权限的页面，也就是在没有登陆情况下，需要重新导航到登陆页面
router.beforeEach((to,from,next)=>{
    //to将要访问的路径
    //from代表从哪个路径跳转而来
    //next表示一个函数，表示放行
    //  next() 放行  next('/login') 强制跳转
    if(to.path==='/login') return next()
    //获取token
    const tokenStr=window.sessionStorage.getItem('token')
    if(!tokenStr) return next('/login')
    next()
})
export default router
