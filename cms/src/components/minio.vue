<template>
  <div>
    <el-row :gutter="20">
      <el-col :span="2">
        <el-button type="primary" @click="dialogVisible3 = true"
          >上传<i class="el-icon-upload el-icon--right"></i
        ></el-button>
      </el-col>
      <el-col :span="6">
        <el-input v-model="input"  placeholder="请输入搜索关键字" @change="search">
          <el-button slot="append" icon="el-icon-search" @click="search"></el-button>
        </el-input>
      </el-col>
    </el-row>
    <el-tooltip content="勾选多个可进行批量删除" placement="top">
      <el-button
        type="danger"
        icon="el-icon-delete"
        style="float: right"
        @click="multipleDelete(array)"
        >批量删除</el-button
      >
    </el-tooltip>
    <el-table
      :data="dataMinios"
      style="width: 100% height:auto"
      stripe
      @selection-change="multipleSelection"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column fixed prop="id" label="ID" width="150">
      </el-table-column>
      <el-table-column fixed prop="objectName" label="名字" width="150">
      </el-table-column>
      <el-table-column fixed prop="size" label="大小" width="150">
      </el-table-column>
      <el-table-column fixed prop="hpart" label="区块" width="150">
      </el-table-column>
      <el-table-column fixed prop="htitle" label="标题" width="150">
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-tooltip content="查看" placement="top">
            <el-button
              @click="check(scope.row.htitle)"
              type="primary"
              circle
              size="small"
              icon="el-icon-view"
            >
            </el-button>
          </el-tooltip>
          <el-tooltip content="删除" placement="top">
            <el-button
              @click="del(scope.row.htitle)"
              type="danger"
              size="small"
              circle
              icon="el-icon-delete"
            >
            </el-button>
          </el-tooltip>
          <el-tooltip content="下载" placement="top">
            <el-button
              @click="download(scope.row.htitle, scope.row.objectName)"
              type="warning"
              circle
              size="small"
              icon="el-icon-download"
            >
            </el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>
    <!-- <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="dialogImageUrl" alt="" />
    </el-dialog> -->
    <el-pagination
      :disabled="disabled"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :page-sizes="[5, 10, 15, 20]"
      :page-size="100"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
    >
    </el-pagination>
    <el-dialog title="图片" :visible.sync="dialogVisible2">
      <span class="span"><img :src="content"/></span>
    </el-dialog>
    <el-dialog title="上传文件" :visible.sync="dialogVisible3">
      <el-form
        :model="upload"
        label-width="100px"
        class="demo-ruleForm"
        ref="upLoadForm"
      >
        <el-form-item label="区块" prop="hpart">
          <el-input type="text" v-model="upload.hpart" ref="hpart"></el-input>
        </el-form-item>
        <el-form-item label="标题" prop="htitle">
          <el-input type="text" v-model="upload.htitle" ref="htitle"></el-input>
        </el-form-item>
        <el-form-item label="文件" prop="file">
          <input class="aaa" type="file" ref="file" />
        </el-form-item>
        <el-form-item>
          <el-button @click="sumbit">提交</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!-- 确认是否删除对话框 -->
    <el-dialog title="提示" :visible.sync="dialogVisible4" width="30%">
            <span>确定要删除吗</span>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible4 = false">取 消</el-button>
                <el-button type="primary" @click="deleteminio()">确 定</el-button>
            </span>
        </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 总total
      total: 0,
      input:null,
      query: {
        pageSize: 5,
        currentPage: 1,
      },
      deleteTitle:'',
      disabled: false,
      currentPage: 1,
      content: '',
      // 输入bucketName 对话框
      dialogImageUrl: '',
      dialogVisible: false,
      dialogVisible2: false,
      dialogVisible3: false,
      dialogVisible4:false,
      dataMinios: [],
      filename: '',
      // 要进行批量删除的文件
      array: [],
      fileList: [],
      upload: {
        hpart: '',
        htitle: '',
        file: null,
      },
    }
  },
  created() {
    this.showMinio()
    this.getPage()
  },
  methods: {
    handleSizeChange(val) {
      // console.log(`每页 ${val} 条`);
      this.query.pageSize = val
      this.getPage()
    },
    handleCurrentChange(val) {
      // console.log(`当前页: ${val}`);
      this.query.currentPage = val
      this.getPage()
    },
    del(title) {
      this.dialogVisible4=true,
      this.deleteTitle=title
    },
    // 根据标题删除
    async deleteminio(){
      const {data:res}=await this.$http.get(`/deleteObjectsById?htitle=${this.deleteTitle}`)
      this.dialogVisible4=false
    },
    async search(){
      const {data:res}=await this.$http.get(`/searchByLike?htitle=${this.input}`)
      this.total=res.data.length
      this.dataMinios=res.data
      this.disabled=true
    },
    async sumbit() {
      // 利用 FormData() 上传文件
      let upLoadForm = new FormData()
      upLoadForm.append('hpart', this.$refs.hpart.value)
      upLoadForm.append('htitle', this.$refs.htitle.value)
      upLoadForm.append('file', this.$refs.file.files[0])
      this.$http
        .post('/minioUpload', upLoadForm, {
          headers: { 'Content-Type': 'multipart/form-data' },
        })
        .then(() => {this.$message.success(`文件上传成功！`),this.showMinio()})
        .catch((error) => console.error(error))
      this.dialogVisible3 = false
      this.$refs['upLoadForm'].resetFields()
    },
    async getPage() {
      const { data: res } = await this.$http.get(
        `/getPageObj?currentPage=${this.query.currentPage}&pageSize=${this.query.pageSize}`
      )
      this.dataMinios = res.data.records
    },
    async showMinio() {
      const { data: res } = await this.$http.get(`/listBucket`)
      // console.log(res)
      this.total = res.length
      console.log(this.total);
    },
    async check(title) {
      console.log(title)
      // 错误写法，没有 responseType
      // const { data: res } = await this.$http.get(`/listFile?htitle=${title}`)
      // let url = window.URL.createObjectURL(new Blob(res.data))
      // this.content = url
      // console.log(url);
      await this.$http
        .request({
          url: `/listFile?htitle=${title}`, //这里是你的请求url
          responseType: 'blob', //这里最重要,不要去掉
          method: 'get', //请求方式,看后台的需求,可能是get,post等方式
        })
        .then((res) => {
          let blob = new Blob([res.data])
          let url = window.URL.createObjectURL(blob)
          this.content = url
          console.log(this.content);
      })
      this.dialogVisible2 = true
    },
    //下载文件
    async download(title, name) {
      // const { data: res } = await this.$http.get(`/minioDownload?htitle=${title}`)
      // console.log(res)
      await this.$http
        .request({
          url: `/minioDownload?htitle=${title}`, //这里是你的请求url
          responseType: 'blob', //这里最重要,不要去掉
          method: 'get', //请求方式,看后台的需求,可能是get,post等方式
        })
        .then((res) => {
          var elink = document.createElement('a')
          elink.download = name
          elink.style.display = 'none'
          var blob = new Blob([res.data], {
            Disposition: 'attachment',
            type: 'application/x-msdownload',
          })
          elink.href = URL.createObjectURL(blob)
          document.body.appendChild(elink)
          elink.click()
          document.body.removeChild(elink)
          this.$message.success(`文件下载成功！`)
        })
        .catch((err) => {
          console.log(err)
        })
    },
    multipleSelection(val) {
      // 提取数组中的id
      this.array = val.map((item) => item.htitle).toString()
      // 将字符串改成一个对象
      this.array = this.array.split(',')
      // console.log(this.array);
      // 将数组转换为 URL 字符串,使用 join 方法将这些字符串用 '&' 符号连接起来，形成完整的 URL 查询字符串
      this.array = this.array.map(value => `objects=${value}`).join('&');
    },
    async multipleDelete(array) {
      const confirmResult = await this.$confirm(
        '此操作将批量删除文件, 是否继续?',
        '提示',
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        }
      ).catch((err) => err)
      // 如果用户确认删除，则返回值为字符串 confirm
      // 如果用户取消了删除，则返回值为字符串 cancel
      if (confirmResult != 'confirm') {
        return this.$notify.info({
          title: '消息',
          message: '已取消删除！',
        })
      }
      const { data: res } = await this.$http.delete(`/deleteBatchBucket?${this.array}`)
      console.log(res);
      // .request({
      //   url:'/deleteBatchBucket?objects',
      //   method: 'delete',
      //   params:{
      //     array
      //   }
      // }).then(res=>console.log(res))
      // console.log(res);
      // 没有返回数据
      // if (!res.data) {
      //   return this.$notify.error({
      //     title: '错误',
      //     message: '添加失败！'
      //   })
      // }
      // this.$notify({
      //   title: '成功',
      //   message: '添加成功！',
      //   type: 'success',
      // })
      this.showMinio()
    },
  },
}
</script>

<style scoped>
.span img{
    width: 100%;
}
</style>
