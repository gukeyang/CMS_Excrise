<template>
    <div class="login" id="login-app">
        <div class="login-box">
            <img src="../images/login/logoin.png" alt="" />
            <div class="login-form">
                <el-form ref="loginFormRef" :model="loginForm" :rules="loginRules">
                    <div class="login-form-title">
                        <img src="../images/login/logogo.png" style="width: 139px; height: 42px" alt="" />
                    </div>
                    <el-form-item prop="admin">
                        <el-input v-model="loginForm.admin" type="text" auto-complete="off" placeholder="账号" maxlength="20"
                            @keyup.enter.native="keyupClick" />
                    </el-form-item>
                    <el-form-item prop="password">
                        <el-input v-model="loginForm.password" type="password" placeholder="密码" maxlength="20" ref="mima"
                            show-password @keyup.enter.native="onClickButtonSubmit" />
                    </el-form-item>
                    <el-form-item style="width: 100%">
                        <el-button :loading="loading" class="login-btn" size="medium" type="primary" style="width: 100%"
                            @click="login">
                            <span v-if="!loading">登录</span>
                            <span v-else>登录中...</span>
                        </el-button>
                    </el-form-item>
                    <el-form-item style="width: 100%">
                        <el-button class="login-btn" size="medium" type="primary" style="width: 100%"
                            @click="dialogVisible = true">
                            <span>注册</span>
                        </el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
        <!-- 注册账号 -->
        <el-dialog title="注册信息" :visible.sync="dialogVisible" width="30%" @close="addDialogClosed">
            <el-form ref="loginFormRef" :model="reloginForm" :rules="loginRules" status-icon>
                <el-form-item prop="admin" label="请输入用户名/账号">
                    <el-input v-model="reloginForm.admin" type="text" auto-complete="off" maxlength="20"
                        @keyup.enter.native="rekeyupClick" />
                </el-form-item>
                <el-form-item prop="password" label="请输入密码">
                    <el-input v-model="reloginForm.password" type="text" maxlength="20" ref="mima"
                        @keyup.enter.native="reWritePassword" />
                </el-form-item>
                <el-form-item prop="repassword" label="请再次输入密码">
                    <el-input v-model="reloginForm.repassword" type="text" maxlength="20" ref="remima"
                        @keyup.enter.native="reonClickButtonSubmit" />
                </el-form-item>
            </el-form>
            <span class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="check">提 交</el-button>
            </span>
            <el-divider><i class="el-icon-s-promotion"></i> 使用邮箱登录</el-divider>
            <el-button type="info" icon="el-icon-message" circle @click="dialogVisible1=true"></el-button>
        </el-dialog>
        <!-- 邮箱号登录 对话框 -->
        <el-dialog title="注册信息" :visible.sync="dialogVisible1" width="60%" @close="addEmailClosed">
            <el-form ref="emailFormRef" :model="emailLogin" status-icon>
                <el-form-item label="请输入邮箱号">
                    <el-input v-model="emailLogin.email" type="email" auto-complete="off" maxlength="20" />
                </el-form-item>
                <el-form-item label="请输入验证码">
                    <el-input v-model="emailLogin.code" type="text" maxlength="20" />
                </el-form-item>
                <el-button type="info" plain @click="sendEmail">发送验证码</el-button>
            </el-form>
            <span>
                <el-button @click="dialogVisible1 = false">取 消</el-button>
                <el-button type="primary" @click="emailSumbit">登 录</el-button>
                <el-button type="primary" @click="dialogVisible2=true" style="float: right">注 册</el-button>
            </span>
        </el-dialog>
        <!-- 注册邮箱号 -->
        <el-dialog title="注册信息" :visible.sync="dialogVisible2" width="60%" @close="addRegeditClosed">
            <el-form ref="regeditFormRef" :model="regeditEmail" status-icon>
                <el-form-item label="请输入Email">
                    <el-input v-model="regeditEmail.code" type="email" auto-complete="off" maxlength="20" />
                </el-form-item>
                <el-form-item label="请设置密码">
                    <el-input v-model="regeditEmail.email" type="text" maxlength="20" ref="mima" />
                </el-form-item>
                <el-form-item label="请输入验证码">
                    <el-input v-model="regeditEmail.userPassword" type="text" maxlength="20" ref="remima" />
                </el-form-item>
                <el-button type="info" plain @click="sendRegeditEmail">发送验证码</el-button>
            </el-form>
            <span class="dialog-footer">
                <el-button @click="dialogVisible2 = false">取 消</el-button>
                <el-button type="primary" @click="emailRegedit">提 交</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script>
export default {
    name: 'login',
    data() {
        return {
            dialogVisible: false,
            dialogVisible1: false,
            dialogVisible2: false,
            //这是登录表单的数据绑定对象
            loginForm: {
                admin: '',
                password: '',
            },
            reloginForm: {
                admin: '',
                password: '',
                repassword: ''
            },
            // 邮箱号登录
            emailLogin: {
                email: '',
                code: ''
            },
            // 邮箱号注册
            regeditEmail: {
                code: '',
                email: '',
                userPassword: ''
            },
            loading: false,
            //这是表单的验证规则对象
            loginRules: {
                //验证用户名是否合法
                admin: [
                    //trigger: 'blur'鼠标失去焦点,发生验证行为
                    {
                        required: true,
                        message: '请输入用户名称',
                        trigger: 'blur',
                    },
                    {
                        min: 3,
                        max: 10,
                        message: '长度在 3 到 10 个字符',
                        trigger: 'blur',
                    },
                ],
                //验证密码是否合法
                password: [
                    {
                        required: true,
                        message: '请输入用户密码',
                        trigger: 'blur',
                    },
                    {
                        min: 5,
                        max: 15,
                        message: '长度在 5 到 15 个字符',
                        trigger: 'blur',
                    },
                ],
                repassword: [
                    {
                        required: true,
                        message: '请再次输入用户密码',
                        trigger: 'blur',
                    },
                    {
                        min: 5,
                        max: 15,
                        message: '长度在 5 到 15 个字符',
                        trigger: 'blur',
                    },
                ],
            },
        }
    },
    methods: {
        keyupClick() {
            this.$refs.mima.focus()
        },
        onClickButtonSubmit() {
            this.login()
        },
        addDialogClosed() {
            this.$refs.loginFormRef.resetFields()
        },
        rekeyupClick() {
            this.$refs.mima.focus()
        },
        reWritePassword() {
            this.$refs.remima.focus()
        },
        reonClickButtonSubmit() {
            this.check()
        },
        addEmailClosed() {
            this.$refs.emailFormRef.resetFields()
        },
        addRegeditClosed() {
            this.$refs.regeditFormRef.resetFields()
        },
        // 登录
        login() {
            this.$refs.loginFormRef.validate(async (valid) => {
                this.loading = !this.loading
                if (!valid) return
                const { data: res } = await this.$http.post(
                    `/user/login?admin=${this.loginForm.admin}&password=${this.loginForm.password}`
                )
                console.log(res)
                this.loading = !this.loading
                if (res.data.statusCodeValue !== 200) {
                    return this.$message.error({
                        message: '登录失败',
                        duration: 1000,
                        center: false,
                        showClose: true,
                        offset: 20,
                    })
                }
                this.$message({
                    message: '登录成功',
                    type: 'success',
                    duration: 1000,
                })
                //将登录成功后的token，保存到客户端的sessionStorage中
                //因为token只应在当前网页生效，所以应保存在sessionStorage中
                window.sessionStorage.setItem('token', res.data.body.jwttoken)
                //通过编程式导航，跳转到后台主页
                this.$router.push('/main')
            })
        },
        // 注册校验
        check() {
            if (this.reloginForm.password !== this.reloginForm.repassword) {
                return this.$message.error({
                    message: '两次输入密码不同，请重新输入',
                    duration: 1500,
                    center: false,
                    showClose: true,
                    offset: 20,
                })
            } else {
                this.$refs.loginFormRef.validate(async (valid) => {
                    if (!valid) return
                    const { data: res } = await this.$http.post(
                        `/register?admin=${this.reloginForm.admin}&password=${this.reloginForm.password}`
                    )
                    console.log(res)
                    if (res.data !== 1) {
                        return this.$message.error({
                            message: '注册失败，请重新注册',
                            duration: 1000,
                            center: false,
                            showClose: true,
                            offset: 20,
                        })
                    }
                    this.$message({
                        message: '注册成功，请登录',
                        type: 'success',
                        duration: 1000,
                    })
                    this.dialogVisible = false
                })
            }
        },
        //邮箱登录
        async emailSumbit() {
            // this.$refs.emailFormRef.validate(async (valid) => {
            //     this.loading = !this.loading
            const { data: res1 } = await this.$http.post(
                `/loginByCode?email=${this.emailLogin.email}&code=${this.emailLogin.code}`
            )
            console.log(res1)
            this.loading = !this.loading
            if (res1.flag !== true) {
                return this.$message.error({
                    message: '登录失败',
                    duration: 1000,
                    center: false,
                    showClose: true,
                    offset: 20,
                })
            }
            this.$message({
                message: '登录成功',
                type: 'success',
                duration: 1000,
            })
            //将登录成功后的token，保存到客户端的sessionStorage中
            //因为token只应在当前网页生效，所以应保存在sessionStorage中
            window.sessionStorage.setItem('token', res1.data)
            //通过编程式导航，跳转到后台主页
            this.$router.push('/main')
            // })
            this.dialogVisible1=false
        },
        sendEmail() {
            this.$http.post(
                `/sendEmail?email=${this.emailLogin.email}`
            )
            return this.$notify.success({
                title: '成功',
                message: '发送成功！'
            })
        },
        sendRegeditEmail() {
            this.$http.post(
                `/sendEmail?email=${this.regeditEmail.email}`
            )
            return this.$notify.success({
                title: '成功',
                message: '发送成功！'
            })
        },
        async emailRegedit(){
            // this.$refs.emailFormRef.validate(async (valid) => {
            //     this.loading = !this.loading
            const { data: res2 } = await this.$http.post(
                `/registerByEmail?email=${this.regeditEmail.email}&code=${this.regeditEmail.code}&userPassword=${this.regeditEmail.userPassword}`
            )
            if(res2.flag!='true'){
                return this.$notify.error({
                    title: '错误',
                    message: '注册失败！'
                })
            }
            this.$notify({
                title: '成功',
                message: '注册成功,请登录！',
                type: 'success'
            })
            this.dialogVisible2=false
        }
    },
}
</script>
<style scoped>
.login {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    background-color: #333;
}

.login-box {
    width: 1000px;
    height: 474.38px;
    border-radius: 8px;
    display: flex;
}

.login-box img {
    width: 60%;
    height: auto;
}

.title {
    margin: 0px auto 30px auto;
    text-align: center;
    color: #707070;
}

.login-form {
    background: #ffffff;
    width: 40%;
    border-radius: 0px 8px 8px 0px;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: #337ab7;
}

.login-form .el-form {
    width: 214px;
    height: 307px;
}

.login-form .el-form-item {
    margin-bottom: 30px;
}

.login-form .el-form-item.is-error .el-input__inner {
    border: 0 !important;
    border-bottom: 1px solid #fd7065 !important;
    background: #fff !important;
}

.login-form .input-icon {
    height: 32px;
    width: 18px;
    margin-left: -2px;
}

.login-form .el-input__inner {
    border: 0;
    border-bottom: 1px solid #e9e9e8;
    border-radius: 0;
    font-size: 14px;
    font-weight: 400;
    color: #333333;
    height: 32px;
    line-height: 32px;
}

.login-form .el-input__prefix {
    left: 0;
}

.login-form .el-input--prefix .el-input__inner {
    padding-left: 26px;
}

.login-form .el-input__inner::placeholder {
    color: #aeb5c4;
}

.login-form .el-form-item--medium .el-form-item__content {
    line-height: 32px;
}

.login-form .el-input--medium .el-input__icon {
    line-height: 32px;
}

.login-btn {
    border-radius: 17px;
    padding: 11px 20px !important;
    margin-top: 10px;
    font-weight: 500;
    font-size: 14px;
    border: 0;
    background-color: #ffc200;
}

/* .login-btn:hover,
.login-btn:focus {
  background: #FFC200;
  color: #ffffff;
} */
.login-form-title {
    height: 36px;
    display: flex;
    justify-content: center;
    align-items: center;
    margin-bottom: 40px;
}

.login-form-title .title-label {
    font-weight: 500;
    font-size: 20px;
    color: #333333;
    margin-left: 10px;
}
</style>
