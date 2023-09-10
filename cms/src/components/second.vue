<template>
  <div>
    <el-card>
      <el-row>
        <el-button type="primary" icon="el-icon-plus" @click="dialogVisible2 = true">添加</el-button>
        <el-tooltip content="勾选多个可进行批量删除" placement="top">
          <el-button type="danger" icon="el-icon-delete" style="float:right" @click="multipleDelete">批量删除</el-button>
        </el-tooltip>
      </el-row>
      <el-input placeholder="请输入二级目录所在一级目录下的id查询数据" v-model="firstId" width="40%">
        <el-button slot="append" icon="el-icon-search" @click="getAllSecond"></el-button>
      </el-input>
      <el-table :data="allSecond" style="width: 100% height:auto" stripe @selection-change="multipleSelection">
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column fixed prop="secondId" label="secondID" width="150">
        </el-table-column>
        <el-table-column fixed prop="secondTargetName" label="名字" width="150">
        </el-table-column>
        <el-table-column fixed prop="firstId" label="firstID" width="150">
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="180">
          <template slot-scope="scope">
            <el-tooltip content="编辑" placement="left">
              <el-button type="primary" icon="el-icon-edit" circle @click="edit(scope.row)"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button type="danger" icon="el-icon-delete" circle @click="deleteSecond(scope.row)"></el-button>
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
        <el-form label-width="100px" :model="editSecond">
          <el-form-item label="firstID">
            <el-input v-model="editSecond.firstId" type="text" placeholder="请输入firstID" />
          </el-form-item>
          <el-form-item label="secondID">
            <el-input v-model="editSecond.secondId" type="text" placeholder="secondID" />
          </el-form-item>
          <el-form-item label="secondTargetName">
            <el-input v-model="editSecond.secondTargetName" type="text" placeholder="请输入secondTargetName" />
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible1 = false">取 消</el-button>
          <el-button type="primary" @click="sumbit">提 交</el-button>
        </span>
      </el-dialog>
      <!-- 添加对话框 -->
      <el-dialog title="请添加" :visible.sync="dialogVisible2" width="50%">
        <el-form label-width="100px" :model="addSecond">
          <el-form-item label="firstID">
            <el-input v-model="addSecond.firstId" type="text" placeholder="请输入firstID" />
          </el-form-item>
          <el-form-item label="secondTargetName">
            <el-input v-model="addSecond.secondTargetName" type="text" placeholder="请输入secondTargetName" />
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible1 = false">取 消</el-button>
          <el-button type="primary" @click="add">提 交</el-button>
        </span>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      //页数详细
      // page: {
      //   // 当前页数
      //   currentPage: 1,
      //   // 当前每页显示的条数 
      //   pageSize: 2
      // },
      // total: 0,
      // 修改对话框
      dialogVisible1: false,
      dialogVisible2: false,
      // 搜索到的所有二级目录
      allSecond: [],
      //要修改的二级目录
      editSecond: {
        firstId: '',
        secondId: '',
        secondTargetName: ''
      },
      //添加第二目录所需参值
      addSecond: {
        firstId: '',
        secondTargetName: ''
      },
      // 要查询的一级id
      firstId: ''
    }
  },
  created() {

  },
  methods: {
    async getAllSecond() {
      const { data: res } = await this.$http.get(`/second/getAllSecond?firstId=${this.firstId}`)
      console.log(res);
      this.allSecond = res.data
    },
    edit(row) {
      this.editSecond.firstId = row.firstId
      this.editSecond.secondId = row.secondId
      this.editSecond.secondTargetName = row.secondTargetName
      this.dialogVisible1 = true
    },
    async sumbit() {
      const { data: res } = await this.$http.put(`/second/updateProfessionalCourse?firstId=${this.editSecond.firstId}&secondId=${this.editSecond.secondId}&secondTargetName=${this.editSecond.secondTargetName}`)
      this.getAllSecond()
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
    async deleteSecond(row) {
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
      const { data: res } = await this.$http.delete(`/second/deleteSecond?secondId=${row.secondId}`)
      this.getAllSecond()
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
      const { data: res } = await this.$http.post(`/second/saveSecond?firstId=${this.addSecond.firstId}&secondTargetName=${this.addSecond.secondTargetName}`)
      this.getAllSecond()
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
    async handleSizeChange(newSize) {
      // console.log(newSize);
      this.page.pageSize = newSize
      const { data: res } = await this.$http.get(`/second/getPageProfessional?currentPage=${this.page.currentPage}&pageSize=${this.page.pageSize}`)
      this.allSecond = res.data.records
    },
    //监听 页码值 改变的事件
    async handleCurrentChange(newPage) {
      // console.log(newPage)
      this.page.currentPage = newPage
      // this.getAllFirst()
      const { data: res } = await this.$http.get(`/second/getPageProfessional?currentPage=${this.page.currentPage}&pageSize=${this.page.pageSize}`)
      this.allSecond = res.data.records
    },
    multipleSelection(val) {
      // 提取数组中的id
      this.array = val.map(item => item.secondId).toString();
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
      const { data: res } = await this.$http.delete(`/second/deleteMoreCourse?id=${this.array}`)
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