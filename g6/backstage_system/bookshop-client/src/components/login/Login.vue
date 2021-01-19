<template>
    <div class="login-container">
        <div>
            <div class="logo">
                <img src="../../assets/logo.png"/>

            </div>
            <h1>欢迎来到万国书店</h1>
            <div class="form">
                <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules">
                    <el-form-item prop="user">
                        <el-input v-model="loginForm.user" prefix-icon="el-icon-user"
                                  placeholder='请输入登录帐号'></el-input>
                    </el-form-item>
                    <el-form-item prop="password">
                        <el-input type='password' v-model="loginForm.password" prefix-icon="el-icon-lock
" placeholder="请输入密码"></el-input>
                    </el-form-item>
                    <div class="btn">
                        <el-button type="primary" @click="onSubmit">登录</el-button>
                    </div>
                </el-form>

            </div>
            <div class="register">
                <a href="#">注册</a>
            </div>
        </div>

    </div>

</template>

<script>

    export default {
        data: function () {

            return {
                //登录表单的数据绑定对象
                loginForm: {
                    user: 'admin',
                    password: '123'
                },
                //这是表单的验证规则对象
                loginFormRules: {
                    //验证是否合法，required 是否必填， message 错误信息， trigger:'blur' 失去焦点时触发
                    // 注意 字段名必须跟表单绑定的对象名一致
                    user: [{
                        required: true,
                        message: '请输入你的登录帐号',
                        trigger: 'blur'
                    }],
                    password: [{
                        required: true,
                        message: '请输入登录密码',
                        irigger: 'blur'
                    }]
                }
            }
        },
        methods: {
            onSubmit() {
                //表单预验证 valid 是一个布尔值
                this.$refs.loginFormRef.validate(valid => {
                    if (!valid) {
                        return
                    }
                    //预验证通过后执行
                    this.$axios({
                        method: 'post',
                        url: "/api/admin/login",
                        params: {
                            user: this.loginForm.user,
                            password: this.loginForm.password
                        }
                    }).then(resp => {
                        console.log(resp)
                        if (resp.data.code == 200) {
                            this.$message.success("登录成功")
                            //登录成功后，登录对象 保存到客户端的 sessionStorage 中
                            window.sessionStorage.setItem("user", JSON.stringify(resp.data.data))
                            // console.log(JSON.parse(window.sessionStorage.getItem("user")))
                            // 通过编程式导航跳转后台主页，路由地址是 /home
                            //声明式：<router-link :to="...">
                            //编程式： router.push(...)
                            this.$router.push("/home")
                        } else {
                            this.$message.error(resp.data.data)
                            return
                        }

                    }).catch(resp => {

                        this.$message.error("登录失败，请重试！")
                        console.log(resp)
                    })
                })

            }

        }
    }
</script>

<style scoped="scoped">
    .login-container {
        background-color: white;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;

    }

    .logo {
        padding-left: 50px;
    }

    h1 {
        color: #99CCFF;
    }

    .form {
        width: 300px;
        background-color: white;
    }

    .btn {
        display: flex;
        justify-content: center;
    }

    button {
        width: 100%;
    }

    .register {
        display: flex;
        justify-content: center;
        margin-top: 10px;
    }

    .register a {
        text-decoration: none;
        color: #999;
    }
</style>
