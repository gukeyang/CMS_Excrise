<template>
    <el-container class="home-container">
        <!-- 侧边栏区域 -->
        <el-aside :width="isCollapse ? '64px' : '200px'">
            <div class="logo">
                <img src="../images/login/logogo.png" @click="welcome" alt="" v-if="isDisplay" style="width: 117px; height: 32px" />
            </div>
            <div class="toggle-button" @click="changeCollapse">|||</div>
            <el-menu background-color="#337AB7" text-color="#fff" active-text-color="#ffd04b" :collapse="isCollapse"
                :collapse-transition="false" :router="true" :unique-opened="true" ref="menu">
                <!-- 一级菜单 -->
                <el-submenu :index="item.id + ''" v-for="item in menulist" :key="item.id">
                    <!-- 一级菜单 -->
                    <template slot="title">
                        <!-- 图标 -->
                        <i class="el-icon-location"></i>
                        <!-- 文本 动态绑定名称-->
                        <span>{{ item.name }}</span>
                    </template>
                    <!-- 二级菜单 -->
                    <el-menu-item :index="subItem.id + ''" v-for="subItem in item.children" :key="subItem.id"
                        :route="subItem.path">
                        <i class="el-icon-menu"></i>
                        <span slot="title">{{ subItem.name }}</span>
                    </el-menu-item>
                </el-submenu>
            </el-menu>
        </el-aside>
        <!-- 页面主体区域 -->
        <el-container>
            <!-- 头部区域 -->
            <el-header>
                <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
                    <span>确定要退出吗</span>
                    <span slot="footer" class="dialog-footer">
                        <el-button @click="dialogVisible = false">取 消</el-button>
                        <el-button type="primary" @click="logout">确 定</el-button>
                    </span>
                </el-dialog>
                <div class="title"><h1>河南科技学院畜牧兽医后台管理系统</h1></div>
                <div class="logoout">
                    <img src="../images/icons/btn_close@2x.png" alt="" title="退出登录" @click="dialogVisible = true" />
                </div>
            </el-header>
            <el-main>
                <!-- 显示各个模块内容，声明式导航 -->
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
export default {
    data() {
        return {
            dialogVisible: false,
            // 左侧菜单数据
            menulist: [
                {
                    id: '1',
                    name: '内容管理',
                    icon: 'icon-xinwengonggao',
                    children: [
                        {
                            id: '11',
                            name: '文章管理',
                            path: '/news',
                        },
                        // {
                        //     id: '12',
                        //     name: 'a',
                        //     path: '/add',
                        // },
                    ],
                },
                // {
                //     id: '2',
                //     name: '区块管理',
                //     icon: 'icon-zhongxingaishu',
                //     children: [
                //         {
                //             id: '21',
                //             name: '区块管理',
                //             path: '/part',
                //         },
                //     ],
                // },
                {
                    id: '2',
                    name: '文件管理',
                    icon: 'icon-xunifangzhen',
                    children: [
                        {
                            id: '21',
                            name: '文件处理',
                            path: '/minio',
                        },
                        {
                            id: '22',
                            name: '图片处理',
                            path: '/picture',
                        },
                    ],
                },
                // {
                //     id: '3',
                //     name: '特色平台库',
                //     icon: 'icon-yuanchenghudong',
                //     children: [
                //         {
                //             id: '31',
                //             name: '特色平台库',
                //             path: '/characteristic',
                //         },
                //     ],
                // },
                {
                    id: '3',
                    name: '栏目管理',
                    icon: 'icon-shipinjiaoxue',
                    children: [
                        {
                            id: '41',
                            name: '一级栏目',
                            path: '/first',
                        },
                        {
                            id: '42',
                            name: '二级栏目',
                            path: '/second',
                        },
                    ],
                },
                // {
                //     id: '4',
                //     name: '用户信息',
                //     icon: 'icon-zaixiankaoshi',
                //     children: [
                //         {
                //             id: '51',
                //             name: '获取当前用户信息',
                //             path: '/request',
                //         },
                        
                //     ],
                // },
                {
                    id: '4',
                    name: '页面展示管理',
                    icon: 'icon-zaixiankaoshi',
                    children: [
                        {
                            id: '61',
                            name: '页面更新管理',
                            path: '/update',
                        },
                        
                    ],
                },
                {
                    id: '5',
                    name: '测试',
                    icon: 'icon-yuanchenghudong',
                    children: [
                        {
                            id: '71',
                            name: '测试下载',
                            path: '/lianxi',
                        },
                    ],
                },
            ],
            //是否折叠
            isCollapse: false,
            isDisplay: true,
        }
    },
    //生命周期函数
    // created() {
    //     this.getMenuList()
    // },

    methods: {
        welcome(){
            // 编程式导航
            this.$router.push('/welcome')
        },
        logout() {
            //先清空sessionStorage里面的token
            window.sessionStorage.clear()
            this.$router.push('/login')
            this.dialogVisible = false
        },
        //获取所有的菜单,因为get请求返回是一个promise，所以为了简化promise操作，使用async
        // async getMenuList() {
        //     const { data: res } = await this.$http.get('v2/api-docs')
        //     console.log(res);
        // 如果失败，就返回错误信息
        // if (res.code != 200) return this.$message.error(res.data.msg)
        // 未与服务器连接，先注掉
        //     this.menulist=res.tags
        // },
        changeCollapse() {
            this.isCollapse = !this.isCollapse
            this.isDisplay = !this.isDisplay
        },
    },
}
</script>

<style lang="less" scoped>
.el-aside {
    background-color: #337ab7;

    .el-menu {
        border-right: none;
    }
}

.home-container {
    height: 100%;
}

.logo {
    text-align: center;
    background-color: #337ab7;
    padding: 46px 40px 67px 36px;
}

.el-header {
    background: #fff;
    box-shadow: 0 1px 4px rgb(0 21 41 / 8%);
}

.el-container .el-header .title{
    float: left;
}
.el-container .el-header .logoout {
    float: right;
    margin-right: 34px;
    height: 100%;
    line-height: 64px;
    color: #333333;
    font-size: 14px;

    img {
        cursor: pointer;
        margin-top: 20px;
        margin-left: 10px;
        width: 25px;
        height: 25px;
    }
}

.toggle-button {
    font-size: 10px;
    line-height: 24px;
    color: #fff;
    text-align: center;
    letter-spacing: 0.2rem;
    cursor: pointer;
    background-color: skyblue;
}
</style>
