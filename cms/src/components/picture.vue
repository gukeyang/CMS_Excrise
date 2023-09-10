<template>
    <div>
      <el-button type="primary" @click="dialogVisible4 = true"
          >上传<i class="el-icon-upload el-icon--right"></i
      ></el-button>
      <el-row>
        
        <el-tooltip content="勾选多个可进行批量删除" placement="top">
          <el-button
            type="danger"
            icon="el-icon-delete"
            style="float: right"
            @click="multipleDelete"
            >批量删除</el-button
          >
        </el-tooltip>
      </el-row>
      <el-table
        :data="dataPictures"
        style="width: 100% height:auto"
        stripe
        @selection-change="multipleSelection"
      >
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column fixed prop="id" label="ID" width="150">
        </el-table-column>
        <el-table-column fixed prop="imgTime" label="时间" width="150">
        </el-table-column>
        <el-table-column fixed prop="imgName" label="名字" width="150">
        </el-table-column>
        <el-table-column fixed prop="imgPath" label="地址" width="150">
        </el-table-column>
        <el-table-column fixed prop="type" label="类型" width="150">
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="180">
          <template slot-scope="scope">
            <el-tooltip content="查看" placement="top">
            <el-button
              @click="check(scope.row.imgPath)"
              type="primary"
              size="small"
              circle
              icon="el-icon-view"
            >
            </el-button>
          </el-tooltip>
          <el-tooltip content="修改" placement="top">
            <el-button
              @click="edit(scope.row)"
              type="success"
              size="small"
              circle
              icon="el-icon-edit"
            >
            </el-button>
          </el-tooltip>
          <el-tooltip content="删除" placement="top">
            <el-button
              @click="deletePicture(scope.row.id)"
              type="danger"
              size="small"
              circle
              icon="el-icon-delete"
            >
            </el-button>
          </el-tooltip>
          <el-tooltip content="下载" placement="top">
            <el-button
              @click="download(scope.row.objectName)"
              type="warning"
              size="small"
              circle
              icon="el-icon-download"
            >
              
            </el-button>
          </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
      <!-- 对 话 框 模 块 -->
      <!-- 图片框 -->
      <el-dialog title="图片" :visible.sync="dialogVisible2">
        <span class="span"><img :src="content"/></span>
      </el-dialog>
      <el-dialog title="提示" :visible.sync="dialogVisible3" width="30%">
            <span>确定要删除吗</span>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible3 = false">取 消</el-button>
                <el-button type="primary" @click="isDelete()">确 定</el-button>
            </span>
      </el-dialog>
      <el-pagination
      :disabled="disabled"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="query.pages"
      :page-sizes="[5, 10, 15, 20]"
      :page-size="100"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      >
      </el-pagination>
      <!-- 上传图片模块 -->
      <el-dialog title="上传文件" :visible.sync="dialogVisible4">
      <el-form
        :model="uploadPicture"
        label-width="100px"
        class="demo-ruleForm"
        ref="upLoadFormPicture"
      >
        <el-form-item label="名字" prop="pictureName">
          <el-input type="text" v-model="uploadPicture.pictureName"></el-input>
        </el-form-item>
        <el-form-item label="类型" prop="type">
          <el-input type="text" v-model="uploadPicture.type" placeholder="只能输入数字"></el-input>
        </el-form-item>
        <el-form-item label="文件" prop="file">
          <input class="aaa" type="file" ref="file" />
        </el-form-item>
        <el-form-item>
          <el-button @click="sumbitPicture">提交</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!-- 修改图片名字 -->
    <el-dialog title="修改图片名字" :visible.sync="dialogVisible5">
      <el-form
        :model="editPicture"
        label-width="100px"
        class="demo-ruleForm"
        ref="upLoadFormPicture"
      >
        <el-form-item label="id">
          <el-input type="text" v-model="editPicture.id" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="名字">
          <el-input type="text" v-model="editPicture.imgName"></el-input>
        </el-form-item>
        <el-form-item label="路径">
          <el-input type="text" v-model="editPicture.imgPath" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="类型">
          <el-input type="text" v-model="editPicture.type" :disabled="true"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="sumbitEditPicture">提交</el-button>
          <el-button @click="dialogVisible5=false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    </div>
  </template>
  
  <script>
  var delPicture;
  export default {
    data() {
      return {
        total:0,
        query:{
          pageSize:5,
          currentPage:1,
        },
        disabled:false,
        currentPage:1,
        content:'',
        dialogVisible2:false,
        dialogVisible3:false,
        dialogVisible4:false,
        dialogVisible5:false,
        bucketName: '',
        dataPictures: [],
        filename: '',
        // 要进行批量删除的文件
        array: [],
        fileList: [],
        uploadPicture: {
          pictureName: '',
          type: null,
          file: null,
        },
        editPicture:{
          id:null,
          imgName:null,
          imgPath:null,
          type:null
        }
      }
    },
    created(){
      this.showPicture()
      this.getPage();
    },
    methods: {
        handleSizeChange(val) {
        // console.log(`每页 ${val} 条`);
        this.query.pageSize=val;
        this.getPage();
      },
      handleCurrentChange(val) {
        // console.log(`当前页: ${val}`);
        this.query.currentPage=val;
        this.getPage();
      },
      async sumbitPicture(){
        let upLoadFormPicture = new FormData()
        upLoadFormPicture.append('file', this.$refs.file.files[0])
        this.$http
          .post(`/picture/pictureUpload?type=${this.uploadPicture.type}&pictureName=${this.uploadPicture.pictureName}`, upLoadFormPicture, {
            headers: { 'Content-Type': 'multipart/form-data' },
          })
          .then(() => {this.$message.success(`文件上传成功！`),this.showPicture()})
          .catch((error) => console.error(error))
        this.dialogVisible4 = false
        this.$refs['upLoadFormPicture'].resetFields()
      },
      async getPage(){
        const { data: res } = await this.$http.get(
          `/picture/getPageAllPicture?currentPage=${this.query.currentPage}&pageSize=${this.query.pageSize}`
        )
        this.dataPictures = res.data.records
        console.log('dsds',res.data.records);
      },
      async showPicture() {
        const { data: res } = await this.$http.get(
          `/picture/getPictureInformation`
        )
        this.total=res.length
        
      },
      async check(path) {
        // console.log(name)
        this.content=path
        console.log(path);
        this.dialogVisible2=true;
      },
      edit(row){
        this.editPicture.id=row.id
        this.editPicture.imgName=row.imgName
        this.editPicture.imgPath=row.imgPath
        this.editPicture.type=row.type
        this.dialogVisible5=true
      },
      async sumbitEditPicture(){
        const{data:res}=await this.$http.post(`/picture/replace?id=${this.editPicture.id}&imgName=${this.editPicture.imgName}&imgPath=${this.editPicture.imgPath}&type=${this.editPicture.type}`)
        console.log(res);
      },
      //下载文件
      download(path) {
        const { data: res } = this.$http.get(`/minioDownload?path=${path}`)
        console.log(res)
      },
      multipleSelection(val) {
        // 提取数组中的id
        this.array = val.map((item) => item.object_name).toString()
        // 将字符串改成一个对象
        this.array = this.array.split(',')
        // console.log(this.array);
      },
        //   删除图片
        deletePicture(row){
        this.dialogVisible3=true;
        delPicture=row;
        },
        async isDelete(){
            const{data:res}=await this.$http.delete(`/picture/deleteById?id=${delPicture}`)
            this.dialogVisible3=false;
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
            this.showPicture();
        },
        async multipleDelete() {
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
            const { data: res } = await this.$http.delete(
                `/deleteBatchBucket?id=${this.array}`
            )
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
            this.reload()
        },
    },
  }
  </script>
  
<style scoped>
.span img{
    width: 100%;
}
</style>
  