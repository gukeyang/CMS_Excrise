<template>
  <div>
    <el-card>
      <el-row :gutter="20">
        <el-col :span="7">
          <el-input placeholder="请输入id查询数据" v-model="Id">
            <el-button slot="append" icon="el-icon-search" @click="queryPart"></el-button>
          </el-input>
        </el-col>
        <el-col :span="6">
          <el-button type="primary" icon="el-icon-plus" @click="dialogVisible1 = true">添加</el-button>
        </el-col>
      </el-row>
      <el-table :data="partM" style="width: 100% height:auto" stripe>
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column fixed prop="id" label="id" width="150">
        </el-table-column>
        <el-table-column fixed prop="title" label="title" width="150">
        </el-table-column>
        <el-table-column fixed prop="picture" label="picture" width="150">
        </el-table-column>
        <el-table-column fixed prop="part" label="part" width="150">
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="180">
          <template slot-scope="scope">
            <el-tooltip content="编辑" placement="left">
              <el-button type="primary" icon="el-icon-edit" circle @click="updatePartM(scope.row)"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button type="danger" icon="el-icon-delete" circle @click="deletePartM(scope.row)"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
      <!-- 添加对话框 -->
      <el-dialog title="请输入内容" :visible.sync="dialogVisible1" width="50%">
        <el-form label-width="100px" :model="addPartM">
          <el-form-item label="part">
            <el-input v-model="addPartM.part" type="text" placeholder="请输入part" />
          </el-form-item>
          <el-form-item label="picture">
            <el-input v-model="addPartM.picture" type="text" placeholder="请输入picture" />
          </el-form-item>
          <el-form-item label="title">
            <el-input v-model="addPartM.title" type="text" placeholder="请输入title" />
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible1 = false">取 消</el-button>
          <el-button type="primary" @click="addPart">提 交</el-button>
        </span>
      </el-dialog>
      <!-- 修改对话框 -->
      <el-dialog title="请输入要修改的内容" :visible.sync="dialogVisible2" width="50%">
        <el-form label-width="100px" :model="editPartM">
          <el-form-item label="id">
            <el-input v-model="editPartM.id" type="text" placeholder="请输入id" />
          </el-form-item>
          <el-form-item label="part">
            <el-input v-model="editPartM.part" type="text" placeholder="请输入part" />
          </el-form-item>
          <el-form-item label="picture">
            <el-input v-model="editPartM.picture" type="text" placeholder="请输入picture" />
          </el-form-item>
          <el-form-item label="title">
            <el-input v-model="editPartM.title" type="text" placeholder="请输入title" />
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible2 = false">取 消</el-button>
          <el-button type="primary" @click="sumPartM">提 交</el-button>
        </span>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogVisible1: false,
      dialogVisible2: false,
      // part 属性表
      partM: [],
      // 要查询的 Id
      Id: '',
      // 要删除的Id
      id:'',
      // 要添加的 属性
      addPartM: {
        part: '',
        picture: '',
        title: ''
      },
      // 要修改的属性
      editPartM: {
        id: '',
        part: '',
        picture: '',
        title: ''
      }
    }
  },
  methods: {
    // 搜索
    async queryPart() {
      const { data: res1 } = await this.$http.get(`/partm/searchPartM?id=${this.Id}`)
      this.partM.push(res1.data.data)
    },
    // 添加
    async addPart() {
      const { data: res } = await this.$http.post(`/partm/savePartM?part=${this.addPartM.part}&picture=${this.addPartM.picture}&title=${this.addPartM.title}`)
      if (!res.code) {
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
      this.dialogVisible1 = false
    },
    // 修改呈现在表单中
    updatePartM(row){
      this.editPartM.id=row.id
      this.editPartM.part=row.part
      this.editPartM.picture=row.picture
      this.editPartM.title=row.title
      this.dialogVisible2=true
    },
    // 提交表单数据
    async sumPartM(){
      const{data:res2}=await this.$http.put(`/partm/updatePartM?id=${this.editPartM.id}&part=${this.editPartM.part}&picture=${this.editPartM.picture}&title=${this.editPartM.title}`)
      if (!res2.code) {
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
      this.dialogVisible2 = false
    },
    // 删除某一行
    deletePartM(row){
      const{data:res}=this.$http.get(`/partm/deletePartM?id=${row.id}`)
      if (!res.code) {
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
    }
  }
}
</script>

<style></style>