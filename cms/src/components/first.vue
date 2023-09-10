<template>
    <div>
        <el-card>
        <el-row>
            <el-button type="primary" icon="el-icon-plus" @click="dialogVisible2 = true">添加</el-button>
            <el-tooltip content="勾选多个可进行批量删除" placement="top">
                <el-button type="danger" icon="el-icon-delete" style="float:right" @click="multipleDelete">批量删除</el-button>
            </el-tooltip>
        </el-row>
        <el-table :data="allFirst" style="width: 100% height:auto" stripe @selection-change="multipleSelection">
            <el-table-column type="selection" width="55"> </el-table-column>
            <el-table-column fixed prop="firstId" label="ID" width="150">
            </el-table-column>
            <el-table-column fixed prop="firstTargetName" label="名字" width="150">
            </el-table-column>
            <el-table-column fixed="right" label="操作" width="120">
                <template slot-scope="scope">
                    <el-tooltip content="编辑" placement="left">
                        <el-button type="primary" icon="el-icon-edit" circle @click="editfirst(scope.row)"></el-button>
                    </el-tooltip>
                    <el-tooltip content="删除" placement="top">
                        <el-button type="danger" icon="el-icon-delete" circle @click="deletefirst(scope.row)"></el-button>
                    </el-tooltip>
                </template>
            </el-table-column>
        </el-table>
        <!-- 页 码 -->
        <!-- <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="page.currentPage"
            :page-sizes="[1, 2, 5, 10]" :page-size="page.pageSize" layout="total, sizes, prev, pager, next, jumper"
            :total="allFirst.length">
        </el-pagination> -->
        <!-- 对话框 -->
        <!-- 修改对话框 -->
        <el-dialog title="请修改" :visible.sync="dialogVisible1" width="50%">
            <el-form label-width="100px" :model="editFirst">
                <el-form-item label="ID">
                    <el-input v-model="editFirst.id" type="text" placeholder="请输入栏目" />
                </el-form-item>
                <el-form-item label="name">
                    <el-input v-model="editFirst.name" type="text" placeholder="请输入内容" />
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible1 = false">取 消</el-button>
                <el-button type="primary" @click="sumbit">提 交</el-button>
            </span>
        </el-dialog>
        <!-- 添加对话框 -->
        <el-dialog title="请修改" :visible.sync="dialogVisible2" width="50%">
            <el-input v-model="firstTargetName" type="text" placeholder="请输入第一目录名字" />
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible1 = false">取 消</el-button>
                <el-button type="primary" @click="add">提 交</el-button>
            </span>
        </el-dialog>
        <el-pagination
      :disabled="disabled"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="page.currentPage"
      :page-sizes="[5, 10, 15, 20]"
      :page-size="page.pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      >
    </el-pagination>
    </el-card>
</div>
</template>

<script>
export default {
    data() {
        return {
            disabled:false,
            //页数详细
            page: {
                // 当前页数
                currentPage: 1,
                // 当前每页显示的条数 
                pageSize: 2,
                total:''
            },
            total: 0,
            // 修改对话框
            dialogVisible1: false,
            dialogVisible2: false,
            // 所有一级目录
            allFirst: [],
            //要修改的一级目录
            editFirst: {
                id: '',
                name: ''
            },
            //添加第一目录所需参值
            firstTargetName: '',
            // 要批量删除的数组
            array:[],
        }
    },
    created() {
        this.getAllFirst()
    },
    methods: {
        handleSizeChange(val) {
        // console.log(`每页 ${val} 条`);
        this.query.pageSize=val;
        this.Allnows();
      },
      handleCurrentChange(val) {
        // console.log(`当前页: ${val}`);
        this.query.currentPage=val;
        this.Allnows();
      },
        async getAllFirst() {
            const { data: res } = await this.$http.get('/first/getAllFist')
            this.allFirst = res.data
            this.page.total=res.data.length
        },
        Allnows(){
      axios.get("/first/getPageProfessional",{
        params:{
          currentPage:this.query.currentPage,
          pageSize:this.query.pageSize
        }
      }).then(res=>{
        // this.query.total=res.data.data.data.length
        // console.log(this.query.total);
        this.querySearch=res.data.data.data;
        // this.reload();
      })

    },
        editfirst(row) {
            this.editFirst.id = row.firstId
            this.editFirst.name = row.firstTargetName
            this.dialogVisible1 = true
        },
        async sumbit() {
            const { data: res } = await this.$http.put(`/first/updateProfessional?firstId=${this.editFirst.id}&firstTargetName=${this.editFirst.name}`)
            this.getAllFirst()
            if (!res.flag) {
                return this.$notify.error({
                    title: '错误',
                    message: '修改失败！'
                })
            }
            this.$notify({
                title: '成功',
                message: '修改成功！',
                type: 'success'
            })
            this.dialogVisible1 = false
        },
        async deletefirst(row) {
            const confirmResult = await this.$confirm('此操作将永久删除该特色文件, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).catch(err => err)
            // 如果用户确认删除，则返回值为字符串 confirm
            // 如果用户取消了删除，则返回值为字符串 cancel
            if (confirmResult != 'confirm') {
                return this.$notify.info({
                    title: '消息',
                    message: '已取消删除！'
                })
            }
            const { data: res } = await this.$http.delete(`/first/deleteProfessional?firstId=${row.firstId}`)
            this.getAllFirst()
            if (!res.flag) {
                return this.$notify.error({
                    title: '错误',
                    message: '删除失败！'
                })
            }
            this.$notify({
                title: '成功',
                message: '删除成功！',
                type: 'success'
            })
        },
        async add() {
            const { data: res } = await this.$http.post(`/first/saveFirst?firstTargetName=${this.firstTargetName}`)
            this.getAllFirst()
            if (!res.flag) {
                return this.$notify.error({
                    title: '错误',
                    message: '添加失败！'
                })
            }
            this.$notify({
                title: '成功',
                message: '添加成功！',
                type: 'success'
            })
            this.dialogVisible2 = false
        },
        //监听 pagesize 改变的事件
        async handleSizeChange(newSize){
            // console.log(newSize);
            this.page.pageSize=newSize
            const { data: res } = await this.$http.get(`/first/getPageProfessional?currentPage=${this.page.currentPage}&pageSize=${this.page.pageSize}`)
            this.allFirst = res.data.records
        },
        //监听 页码值 改变的事件
        async handleCurrentChange(newPage){
            // console.log(newPage)
            this.page.currentPage=newPage
            // this.getAllFirst()
            const { data: res } = await this.$http.get(`/first/getPageProfessional?currentPage=${this.page.currentPage}&pageSize=${this.page.pageSize}`)
            this.allFirst = res.data.records
        },
        // 要批量删除的数组
        multipleSelection(val) {
            // 提取数组中的id
            this.array = val.map(item => item.firstId).toString();
            // 将字符串改成一个对象
            this.array = this.array.split(',')
        },
        async multipleDelete() {
            const confirmResult = await this.$confirm('此操作将批量删除添加库, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).catch(err => err)
            // 如果用户确认删除，则返回值为字符串 confirm
            // 如果用户取消了删除，则返回值为字符串 cancel
            if (confirmResult != 'confirm') {
                return this.$notify.info({
                    title: '消息',
                    message: '已取消删除！'
                })
            }
            const { data: res } = await this.$http.delete(`/first/deleteMoreProfession?id=${this.array}`)
            if (!res.data) {
                return this.$notify.error({
                    title: '错误',
                    message: '添加失败！'
                })
            }
            this.$notify({
                title: '成功',
                message: '添加成功！',
                type: 'success'
            })
            this.reload()
        }
    }
}
</script>

<style></style>