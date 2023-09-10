<template>
    <div>
        <el-card>
            <el-row>
                <el-button type="primary" icon="el-icon-plus" @click="dialogVisible1 = true">添加</el-button>
                <el-tooltip content="勾选多个可进行批量删除" placement="top">
                    <el-button type="danger" icon="el-icon-delete" style="float:right"
                        @click="multipleDelete">批量删除</el-button>
                </el-tooltip>
            </el-row>
            <el-tabs :tab-position="tabPosition">
                <el-tab-pane label="1">
                    <el-table :data="firstTargets1" style="width: 100%" @selection-change="multipleSelection">
                        <el-table-column type="selection" width="55">
                        </el-table-column>
                        <el-table-column prop="id" label="ID" width="55" sortable>
                        </el-table-column>
                        <el-table-column prop="chTitle" label="标题" width="220">
                        </el-table-column>
                        <el-table-column prop="chContent" label="内容">
                        </el-table-column>
                        <el-table-column label="操作" width="150">
                            <template slot-scope="scope">
                                <el-tooltip content="编辑" placement="left">
                                    <el-button type="primary" icon="el-icon-edit" circle
                                        @click="editForm(scope.row)"></el-button>
                                </el-tooltip>
                                <el-tooltip content="删除" placement="right">
                                    <el-button type="danger" icon="el-icon-delete" circle
                                        @click="remove(scope.row.id)"></el-button>
                                </el-tooltip>
                            </template>
                        </el-table-column>
                    </el-table>
                    <!-- <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
                        :current-page="page.pagenum" :page-sizes="[1, 2, 5, 10]" :page-size="page.pagesize"
                        layout="total, sizes, prev, pager, next, jumper" :total="firstTargets1.length">
                    </el-pagination> -->
                </el-tab-pane>
                <el-tab-pane label="2">
                    <el-table :data="firstTargets2" style="width: 100%" @selection-change="multipleSelection">
                        <el-table-column type="selection" width="55">
                        </el-table-column>
                        <el-table-column prop="chTitle" label="标题" width="220">
                        </el-table-column>
                        <el-table-column prop="chContent" label="内容">
                        </el-table-column>
                        <el-table-column label="操作" width="150">
                            <template slot-scope="scope">
                                <el-tooltip content="编辑" placement="left">
                                    <el-button type="primary" icon="el-icon-edit" circle
                                        @click="editForm(scope.row)"></el-button>
                                </el-tooltip>
                                <el-tooltip content="删除" placement="right">
                                    <el-button type="danger" icon="el-icon-delete" circle
                                        @click="remove(scope.row.id)"></el-button>
                                </el-tooltip>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-tab-pane>
                <el-tab-pane label="3">
                    <el-table :data="firstTargets3" style="width: 100%" @selection-change="multipleSelection">
                        <el-table-column type="selection" width="55">
                        </el-table-column>
                        <el-table-column prop="chTitle" label="标题" width="220">
                        </el-table-column>
                        <el-table-column prop="chContent" label="内容">
                        </el-table-column>
                        <el-table-column label="操作" width="150">
                            <template slot-scope="scope">
                                <el-tooltip content="编辑" placement="left">
                                    <el-button type="primary" icon="el-icon-edit" circle
                                        @click="editForm(scope.row)"></el-button>
                                </el-tooltip>
                                <el-tooltip content="删除" placement="right">
                                    <el-button type="danger" icon="el-icon-delete" circle
                                        @click="remove(scope.row.id)"></el-button>
                                </el-tooltip>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-tab-pane>
                <el-tab-pane label="4">
                    <el-table :data="firstTargets4" style="width: 100%" @selection-change="multipleSelection">
                        <el-table-column type="selection" width="55">
                        </el-table-column>
                        <el-table-column prop="chTitle" label="标题" width="220">
                        </el-table-column>
                        <el-table-column prop="chContent" label="内容">
                        </el-table-column>
                        <el-table-column label="操作" width="150">
                            <template slot-scope="scope">
                                <el-tooltip content="编辑" placement="left">
                                    <el-button type="primary" icon="el-icon-edit" circle
                                        @click="editForm(scope.row)"></el-button>
                                </el-tooltip>
                                <el-tooltip content="删除" placement="right">
                                    <el-button type="danger" icon="el-icon-delete" circle
                                        @click="remove(scope.row.id)"></el-button>
                                </el-tooltip>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-tab-pane>
            </el-tabs>
            <el-dialog title="添加平台特色库" :visible.sync="dialogVisible1" width="50%" @close="addDialogClosed">
                <!-- :model="ruleForm" :rules="rules" ref="ruleForm"绑定用户数据 -->
                <el-form label-width="100px" ref="addChar" status-icon :model="addChar">
                    <el-form-item label="标题">
                        <el-input v-model="addChar.chContent" type="text" placeholder="请输入标题" />
                    </el-form-item>
                    <el-form-item label="内容">
                        <el-input v-model="addChar.chTitle" type="text" placeholder="请输入内容" />
                    </el-form-item>
                    <el-form-item label="一级目录">
                        <el-input v-model="addChar.firstTarget" type="text" placeholder="请输入一级目录名称" />
                    </el-form-item>
                    <el-form-item label="二级目录">
                        <el-input v-model="addChar.secondTarget" type="text" placeholder="请输入二级目录名称" />
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible1 = false">取 消</el-button>
                    <el-button type="primary" @click="addChara">确 定</el-button>
                </span>
            </el-dialog>
            <el-dialog title="修改平台特色库" :visible.sync="dialogVisible2" width="50%" @close="editDialogClosed">
                <!-- :model="ruleForm" :rules="rules" ref="ruleForm"绑定用户数据 -->
                <el-form label-width="100px" ref="editChar" status-icon :model="addChar">
                    <el-form-item label="标题">
                        <el-input v-model="addChar.chContent" type="text" placeholder="请输入标题" />
                    </el-form-item>
                    <el-form-item label="内容">
                        <el-input v-model="addChar.chTitle" type="text" placeholder="请输入内容" />
                    </el-form-item>
                    <el-form-item label="一级目录">
                        <el-input v-model="addChar.firstTarget" type="text" placeholder="请输入一级目录名称" />
                    </el-form-item>
                    <el-form-item label="id">
                        <el-input v-model="addChar.id" type="text" placeholder="请输入id" />
                    </el-form-item>
                    <el-form-item label="二级目录">
                        <el-input v-model="addChar.secondTarget" type="text" placeholder="请输入二级目录名称" />
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible2 = false">取 消</el-button>
                    <el-button type="primary" @click="edit">确 定</el-button>
                </span>
            </el-dialog>
            <el-dialog title="删除平台特色库" :visible.sync="dialogVisible3" width="50%" @close="deleteDialogClosed">
                <el-form label-width="100px" ref="deleteChar" status-icon :model="addChar">
                    <el-form-item label="id">
                        <el-input v-model="addChar.id" type="text" placeholder="请输入id" />
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible3 = false">取 消</el-button>
                    <el-button type="primary" @click="remove">确 定</el-button>
                </span>
            </el-dialog>
        </el-card>
    </div>
</template>

<script>
export default {
    //在需要当前页面刷新的页面中注入App.vue组件提供（provide）的 reload 依赖，然后直接用this.reload来调用就行
    inject: ['reload'],
    data() {
        return {
            //页数详细
            // page: {
            //     pagenum: 1,
            //     pagesize: 2
            // },
            // total: 0,
            dialogVisible1: false,
            dialogVisible2: false,
            dialogVisible3: false,
            tabPosition: 'left',
            addChar: {
                chContent: '',
                chTitle: '',
                firstTarget: '',
                id: '',
                secondTarget: ''
            },
            firstTargets: [],
            firstTargets1: [],
            firstTargets2: [],
            firstTargets3: [],
            firstTargets4: [],
            // 批量删除所需要的数组
            array: [],
        }
    },
    created() {
        this.show()
    },
    methods: {
        async show() {
            //这个get会返回一个promise对象，为了简化promise操作，我们可以使用async await来优化这次异步操作
            const { data: res } = await this.$http.get("/administrator/show")
            this.firstTargets = res.data
            for (var i = 0; i < this.firstTargets.length; i++) {
                if (this.firstTargets[i].firstTarget == 1) {
                    this.firstTargets1.push(this.firstTargets[i])
                } else if (this.firstTargets[i].firstTarget == 2) {
                    this.firstTargets2.push(this.firstTargets[i])
                } else if (this.firstTargets[i].firstTarget == 3) {
                    this.firstTargets3.push(this.firstTargets[i])
                } else if (this.firstTargets[i].firstTarget == 4) {
                    this.firstTargets4.push(this.firstTargets[i])
                }
            }
        },
        addChara() {
            this.$refs.addChar.validate(async valid => {
                // console.log(valid);
                if (!valid) return
                // const { data: res } = await this.$http.post(`/administrator/addNotice?
                // firstTarget=${this.queryInfo.firstTarget}&noticeContent=${this.queryInfo.noticeContent}
                // &noticeTitle=${this.queryInfo.noticeTitle}`)
                const { data: res } = await this.$http.post(`/add?chContent=${this.addChar.chContent}
                &chTitle=${this.addChar.chTitle}&firstTarget=${this.addChar.firstTarget}
                &secondTarget=${this.addChar.secondTarget}`)
                console.log(res);
                if (!res.flag) {
                    return this.$message.error('添加特色失败！')
                }
                this.$message.success('添加特色成功！')
                //隐藏添加用户的对话框
                this.dialogVisible1 = false
                // this.show()  有bug，会重复出现之前出现过的
                this.reload()
            })
        },
        // 编辑表单自动填充
        editForm(row){
            this.addChar.chContent=row.chContent
            this.addChar.chTitle=row.chTitle
            this.addChar.firstTarget=row.firstTarget
            this.addChar.id=row.id
            this.addChar.secondTarget=row.secondTarget
            this.dialogVisible2=true
        },
        edit() {
            this.$refs.editChar.validate(async valid => {
                // console.log(valid);
                if (!valid) return
                // const { data: res } = await this.$http.post(`/administrator/addNotice?
                // firstTarget=${this.queryInfo.firstTarget}&noticeContent=${this.queryInfo.noticeContent}
                // &noticeTitle=${this.queryInfo.noticeTitle}`)
                const { data: res } = await this.$http.put(`/administrator/put?chContent=${this.addChar.chContent}
                &chTitle=${this.addChar.chTitle}&firstTarget=${this.addChar.firstTarget}&id=${this.addChar.id}
                &secondTarget=${this.addChar.secondTarget}`)
                console.log(res);
                if (!res.flag) {
                    return this.$message.error('修改特色失败！')
                }
                this.$message.success('修改特色成功！')
                //隐藏添加用户的对话框
                this.dialogVisible2 = false
                // this.show()  有bug，会重复出现之前出现过的
                this.reload()
            })
        },
        async remove(id) {
            const confirmResult = await this.$confirm('此操作将永久删除该特色文件, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).catch(err => err)
            // 如果用户确认删除，则返回值为字符串 confirm
            // 如果用户取消了删除，则返回值为字符串 cancel
            if (confirmResult != 'confirm') {
                return this.$message.info('已取消删除')
            }
            // this.$refs.deleteChar.validate(async valid => {
            //     if (!valid) return
            // validate 表单校验
            const { data: res } = await this.$http.delete(`/delete?id=${id}`)
            console.log(res);
            if (!res.flag) {
                return this.$message.error('删除特色失败！')
            }
            this.$message.success('删除特色成功！')
            //隐藏添加用户的对话框
            this.dialogVisible3 = false
            // this.show()  有bug，会重复出现之前出现过的
            this.reload()
            // })
        },
        addDialogClosed() {
            this.$refs.addChar.resetFields()
        },
        editDialogClosed() {
            this.$refs.editChar.resetFields()
        },
        deleteDialogClosed() {
            this.$refs.deleteChar.resetFields()
        },
        // handleSizeChange(val) {
        //     // console.log(`每页 ${val} 条`);
        //     this.page.pagesize = val
        //     this.reload()
        // },
        // handleCurrentChange(val) {
        //     // console.log(`当前页: ${val}`);
        //     this.page.pagenum = val
        //     this.reload()
        // },
        multipleSelection(val) {
            // 提取数组中的id
            this.array = val.map(item => item.id).toString();
            // 将字符串改成一个对象
            this.array = this.array.split(',')
        },
        async multipleDelete() {
            const confirmResult = await this.$confirm('此操作将批量删除特色文件, 是否继续?', '提示', {
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
            const { data: res } = await this.$http.delete(`/administrator/deleteBatchIds?id=${this.array}`)
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

<style>
.el-row {
    margin: 20px 50px;
}
</style>