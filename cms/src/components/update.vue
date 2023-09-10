<template>
  <div>
    <el-row>
      <el-card>
        <el-button type="primary" @click="shouye">更新首页</el-button><br>
        <span class="span">{{ timer1 }}</span>
      </el-card>
    </el-row>
    <el-row>
      <el-card>
        <el-button type="success" @click="wenzhang">更新文章</el-button><br>
        <span class="span">{{ timer2 }}</span>
      </el-card>
    </el-row>
    <el-row>
      <el-card>
        <el-button type="danger" @click="liebiao">更新列表页</el-button><br>
        <span class="span">{{ timer3 }}</span>
      </el-card>
    </el-row>
  </div>
</template>

<script>
//设置request拦截器,在发起请求的时,展示进度条
// this.$http.interceptors.request.use(config => {
//   // 展示进度条
//   NProgress.start()
// })

// // 设置response拦截器，在请求结束时,关闭进度条
// this.$http.interceptors.response.use(config => {
//   // 关闭进度条
//   NProgress.done()
// })

export default {
    data(){
        return {
            timer1:'',
            timer2:'',
            timer3:''
        }
    },
  methods: {
    async shouye() {
      const { data: sy } = await this.$http.get('/ProduceHtml/updateIndex')
      this.getNowTime('t1')
      // console.log(sy);
      if (sy) {
        this.$notify({
          title: '成功',
          message: '你已成功更新首页',
          type: 'success',
        })
      }else{
        this.$notify.error({
          title: '错误',
          message: '更新失败！！！'
        });
      }
    },
    async wenzhang() {
      const { data: sy } = await this.$http.get('/ProduceHtml/updateNotice')
      this.getNowTime('t2')
      if (sy) {
        this.$notify({
          title: '成功',
          message: '你已成功更新文章',
          type: 'success',
        })
      }else{
        this.$notify.error({
          title: '错误',
          message: '更新失败！！！'
        });
      }
    },
    async liebiao() {
      const { data: sy } = await this.$http.get('/ProduceHtml/updateNoticeList')
      this.getNowTime('t3')
      if (sy) {
        this.$notify({
          title: '成功',
          message: '你已成功更新列表',
          type: 'success',
        })
      }else{
        this.$notify.error({
          title: '错误',
          message: '更新失败！！！'
        });
      }
    },
    getNowTime(t) {
    var date = new Date();
    //年 getFullYear()：四位数字返回年份
    var year = date.getFullYear();  //getFullYear()代替getYear()
    //月 getMonth()：0 ~ 11
    var month = date.getMonth() + 1;
    //日 getDate()：(1 ~ 31)
    var day = date.getDate();
    //时 getHours()：(0 ~ 23)
    var hour = date.getHours();
    //分 getMinutes()： (0 ~ 59)
    var minute = date.getMinutes();
    //秒 getSeconds()：(0 ~ 59)
    var second = date.getSeconds();

    if(t=='t1') this.timer1 = '上次更新时间是：' + year + '-' + this.addZero(month) + '-' + this.addZero(day) + ' ' + this.addZero(hour) + ':' + this.addZero(minute) + ':' + this.addZero(second)
    else if(t=='t2') this.timer2 = '上次更新时间是：' + year + '-' + this.addZero(month) + '-' + this.addZero(day) + ' ' + this.addZero(hour) + ':' + this.addZero(minute) + ':' + this.addZero(second)
    else if(t=='t3') this.timer3 = '上次更新时间是：' + year + '-' + this.addZero(month) + '-' + this.addZero(day) + ' ' + this.addZero(hour) + ':' + this.addZero(minute) + ':' + this.addZero(second)
  },
    addZero(s) {
    return s < 10 ? ('0' + s) : s;
}
  },
}
</script>

<style scoped>
span{
  display: inline-block;
  margin-top: 10px;
  font-size: 10px;
}
</style>
