<template>
    <div>
        <h1>用户登录信息</h1>
        <el-card class="box-card">
            <el-table style="width: 100%" :data="userNews">
                <el-table-column prop="date" label="日期" width="180">
                </el-table-column>
                <el-table-column prop="ip" label="ip" width="180">
                </el-table-column>
                <!-- <el-table-column prop="address" label="栏目" width="180" sortable>
                </el-table-column> -->
                <el-table-column fixed="right" label="退出" width="100">
                    <template>
                        <el-button @click="dialogVisible = true" type="text" size="small">退出</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </el-card>
        <el-dialog title="提示" :visible.sync="dialogVisible" width="30%">
            <span>确定要退出吗</span>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="logout">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
export default { 
    data() {
        return {
            dialogVisible: false,
            userNew: {
                date: '',
                ip: ''
            },
            userNews: []
        }
    },
    created() {
        this.getUserNew()
    },
    methods: {
        async getUserNew() {
            this.userNews=[]
            //这个get会返回一个promise对象，为了简化promise操作，我们可以使用async await来优化这次异步操作
            const { data: res1 } = await this.$http.get("/date")
            const { data: res2 } = await this.$http.get("/ip")
            this.userNew.date =this.$moment(res1).format('YYYY-MM-DD')
            this.userNew.ip = res2
            this.userNews.push(this.userNew)
        },
        logout() {
            //先清空sessionStorage里面的token
            window.sessionStorage.clear()
            this.$router.push('/login')
            this.dialogVisible = false
        },
        changeCollapse() {
            this.isCollapse = !this.isCollapse
            this.isDisplay = !this.isDisplay
        },
    },
}
</script>

<style>

</style>
