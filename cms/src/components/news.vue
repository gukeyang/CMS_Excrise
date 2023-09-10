<template>
  <div v-loading="false">
    <el-card class="box-card">
      <el-row :gutter="20">
        <el-col :span="7">
          <el-input placeholder="请输入id查询数据" v-model="Id" @input="searchNews">
            
          </el-input>
        </el-col>
        <el-col :span="6">
          <el-button type="primary" icon="el-icon-plus" @click="dialogVisible1 = true">添加</el-button>
        </el-col>
      </el-row>
      <el-table style="width: 100%" :data="querySearch">
        <el-table-column prop="id" align="center" label="ID" width="180" sortable>
        </el-table-column>
        <el-table-column prop="noticeTime" align="center" label="发布日期" width="180" sortable>
        </el-table-column>
        <el-table-column prop="noticeTitle" align="center" label="标题" width="180">
        </el-table-column>
        <el-table-column prop="firstTarget" align="center" label="栏目" width="180">
        </el-table-column>
        <el-table-column prop="htmlUrl" align="center" label="url" width="180">
        </el-table-column>
        <el-table-column prop="noticeContent" align="center" stripe show-overflow-tooltip label="内容" width="180">
        </el-table-column>
        <el-table-column fixed="right" label="操作" align="center" width="160">
          <template slot-scope="scope">
            <el-tooltip content="查看" placement="top">
            <el-button type="success" @click="look(scope.row)" icon="el-icon-view" circle size="small"></el-button>
          </el-tooltip>
            <el-tooltip content="编辑" placement="top">
            <el-button type="primary" @click="editForm(scope.row)" icon="el-icon-edit" circle size="small"></el-button>
          </el-tooltip>
            <el-tooltip content="删除" placement="top">
            <el-button type="danger" @click="deleteForm(scope.row)" icon="el-icon-delete" circle size="small"></el-button>
          </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
    </el-card>
    <!-- 添加 notice 对话框 -->
    <el-dialog title="添加中心要闻/公告通知" :visible.sync="dialogVisible1" width="50%" @close="addDialogClosed1">
      <!-- :model="ruleForm" :rules="rules" ref="ruleForm"绑定用户数据 -->
      <el-form label-width="100px" :rules="rules" ref="addElForm" status-icon :model="queryInfo">
        <el-form-item label="栏目" prop="firstTarget">
          <el-input v-model="queryInfo.firstTarget" type="text" placeholder="请输入栏目" />
        </el-form-item>
        <el-form-item label="内容" prop="noticeContent">
          <el-input v-model="queryInfo.noticeContent" type="text" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="标题" prop="noticeTitle">
          <el-input v-model="queryInfo.noticeTitle" type="text" placeholder="请输入标题" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible1 = false">取 消</el-button>
        <el-button type="primary" @click="addNews">确 定</el-button>
      </span>
    </el-dialog>
    <!-- 查看内容对话框 -->
    <el-dialog title="内容" :visible.sync="dialogVisible2">
      <span class="span">{{ content }}</span>
    </el-dialog>
    <!-- 编辑 notice 对话框 -->
    <el-dialog title="修改中心要闻/公告通知" :visible.sync="dialogVisible3" width="50%" @close="addDialogClosed2">
      <!-- :model="ruleForm" :rules="rules" ref="ruleForm"绑定用户数据 -->
      <el-form label-width="100px" ref="editNotice" status-icon :model="editNotice">
        <el-form-item label="栏目" prop="firstTarget">
          <el-input v-model="editNotice.firstTarget" type="text" placeholder="请输入栏目" />
        </el-form-item>
        <el-form-item label="内容" prop="noticeContent">
          <el-input v-model="editNotice.noticeContent" type="text" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="标题" prop="noticeTitle">
          <el-input v-model="editNotice.noticeTitle" type="text" placeholder="请输入标题" />
        </el-form-item>
        <el-form-item label="文章审核状态" prop="status">
          <el-input v-model="editNotice.status" type="text" placeholder="请输入文章审核状态" />
        </el-form-item>
        <el-form-item label="所要修改的id" prop="id">
          <el-input v-model="editNotice.id" type="text" placeholder="请输入所要修改的id" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible3 = false">取 消</el-button>
        <el-button type="primary" @click="editNews">确 定</el-button>
      </span>
    </el-dialog>
    <!-- 确认是否删除对话框 -->
    <el-dialog title="提示" :visible.sync="dialogVisible4" width="30%">
            <span>确定要删除吗</span>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible4 = false">取 消</el-button>
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
  </div>
</template>

<script>
var del;
import axios from 'axios'
export default {
  data() {
    return {
      total:0,
      disabled:false,
      content:'',
      query:{
        num:5,
        pages:1,
      },
      //控制添加内容对话框的显示与隐藏
      dialogVisible1: false,
      dialogVisible2: false,
      dialogVisible3: false,
      dialogVisible4: false,
      //loading加载
      loading: true,
      // 搜索id
      Id: '',
      //获取列表参数对象
      form: {
        firstTarget: '',
        noticeContent: '',
        noticeTitle: '',
        noticeTime: '',
        id: ''
      },
      //添加列表的参数对象
      queryInfo: {
        firstTarget: '',
        noticeContent: '',
        noticeTitle: '',
        noticeTime: '',
        id: ''
      },
      //搜索表单数组
      querySearch: [],
      //修改 notice 数组
      editNotice: {
        firstTarget: '',
        noticeContent: '',
        noticeTitle: '',
        status: '',
        id: '',
        htmlUrl:''
      },
      //添加表单的验证规则对象
      rules: {
        firstTarget: [{
          required: true,
          message: "请输入栏目",
          trigger: 'blur',
        }, { min: 4, message: "请输入不低于4位字符", trigger: "blur", }],
        noticeContent: [{
          required: true,
          message: "请输入内容",
          trigger: "blur",
        }, { min: 4, message: "请输入不低于4位字符", trigger: "blur", }],
        noticeTitle: [{
          required: true,
          message: "请输入标题名称",
          trigger: "blur",
        }, { min: 4, message: "请输入不低于4位字符", trigger: "blur", }]
      }
    }
  },
  created() {
    this.getsAll()
    this.Allnows();
    // this.reload();
  },
  methods: {
    async getsAll(){
      const { data: res } = await this.$http.get('/article/findALLNotice')
      this.total=res.length
    },
    handleSizeChange(val) {
        // console.log(`每页 ${val} 条`);
        this.query.num=val;
        this.Allnows();
      },
      handleCurrentChange(val) {
        // console.log(`当前页: ${val}`);
        this.query.pages=val;
        this.Allnows();
      },
    // async gets() {
    //   const data = await this.$http.get('/administrator/addNotice', this.queryInfo)
    //   console.log(data);
    // },
    //点击按钮，添加新闻
    addNews() {
      this.$refs.addElForm.validate(async valid => {
        // console.log(valid);
        if (!valid) return
        // const { data: res } = await this.$http.post(`/administrator/addNotice?
        // firstTarget=${this.queryInfo.firstTarget}&noticeContent=${this.queryInfo.noticeContent}
        // &noticeTitle=${this.queryInfo.noticeTitle}`)
        // const { data: res } = await this.$http.post("/administrator/addNotice", this.queryInfo)
        // const { data: res } = await this.$http.post(`/administrator/addNotice?
        // firstTarget=${this.queryInfo.firstTarget}&noticeContent=${this.queryInfo.noticeContent}
        // &noticeTitle=${this.queryInfo.noticeTitle}`)
        axios.post("/article/addNotice",{
          firstTarget:this.queryInfo.firstTarget,
          noticeContent:this.queryInfo.noticeContent,
          noticeTitle:this.queryInfo.noticeTitle
        }).then(res=>{
          console.log(res.data);
          if (res.data.code != 1) {
          return this.$message.error('添加新闻失败！')
          }
        })
        // console.log(this.queryInfo);
        // if (res.code != 1) {
        //   return this.$message.error('添加新闻失败！')
        // }
        this.$message.success('添加新闻成功！')
        //隐藏添加新闻的对话框
        this.dialogVisible1 = false
      })
    },
    //关闭表单，表单重置
    addDialogClosed1() {
      this.$nextTick(() => {
        this.$refs.addElForm.resetFields()
      })
    },
    addDialogClosed2() {
      this.$nextTick(() => {
        this.$refs.editNotice.resetFields()
      })
    },
    forceUpdate() {
      this.$forceUpdate()
    },
    onload() {
      this.loading = false
    },
    // 搜索news
    async searchNews() {
      if(this.Id=='') {
        this.disabled=false
        this.Allnows()
        return
      }
      this.form=[];
      const { data: res } = await this.$http.get('/article/findNoticeById/' + this.Id)
      this.form=res;
      // this.querySearch = push(res.data);
      // console.log(this.form);
      this.querySearch=[]
      this.disabled=true
      this.querySearch.push(this.form)
      // this.Allnows()
     },
      Allnows(){
      axios.get("/article/findNoticeByPages",{
        params:{
          num:this.query.num,
          pages:this.query.pages
        }
      }).then(res=>{
        // this.query.total=res.data.data.data.length
        // console.log(this.query.total);
        this.querySearch=res.data.data.data;
        // this.reload();
      })

    }
    ,
    look(row) {
      // var span = document.getElementsByClassName('span')
      // span.innerHTML = row.noticeContent
      // console.log(span.innerText);
      // console.log(span);
      this.content=row.noticeContent
      this.dialogVisible2 = true
    },
    editForm(row){
      this.editNotice.firstTarget=row.firstTarget
      this.editNotice.htmlUrl=row.htmlUrl
      this.editNotice.id=row.id
      this.editNotice.noticeContent=row.noticeContent
      this.editNotice.noticeTitle=row.noticeTitle
      this.editNotice.status=row.status
      this.dialogVisible3=true;
    },
    async editNews() {
      
      const { data: res } = await this.$http.put(`/article/updateNotice?firstTarget=${this.editNotice.firstTarget}&id=${this.editNotice.id}&noticeContent=${this.editNotice.noticeContent}&noticeTitle=${this.editNotice.noticeTitle}&status=${this.editNotice.status}`)
      // const { data: res } = await this.$http.put('/article/updateNotice',this.editNotice)
      if (res.code != 1) {
        return this.$message.error('修改新闻失败！')
      }
      this.$message.success('修改新闻成功！')
      //隐藏添加用户的对话框
      this.dialogVisible3 = false
    },
    // 删除表格
    deleteForm(row){
      this.dialogVisible4=true;
      del=row;
    },
    async isDelete(){
      const{data:res}=await this.$http.delete(`/article/deleteNotice/${del.id}`)
      this.dialogVisible4=false;
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
      this.Allnows();
    }
  }
}
</script>

<style scoped>

</style>