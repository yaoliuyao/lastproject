<template>
  <div class="wrap" ref="wrap">
    <div class="form-wrap">
      <el-form :model="login_form" status-icon :rules="rules" ref="forms">
        <el-form-item>
          <h2 style="color:dimgray">南方it校园墙</h2>
        </el-form-item>
        <el-form-item label="账户" prop="username">
          <el-input
            type="text"
            v-model="login_form.username"
            placeholder="请输入您注册时的账号"
            ref="input1"
            @keyup.native.enter="login('forms')"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            type="password"
            v-model="login_form.password"
            placeholder="请输入密码"
            show-password
            @keyup.native.enter="login('forms')"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <a href="#">管理员登录</a>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" plain @click="login('forms')">登录</el-button>
          <el-button type="info" plain @click="$router.push('/regedit')">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { base } from "../utils/baseStatic"; //导入图片基础路径
import loginApi from "../api/login";
export default {
  data() {
    const user = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("账号不能为空"));
      } else {
        //if(value)
        /* let cnPattern = /[\u4E00-\u9FA5]/;
        if (cnPattern.test(value)) {
          callback(new Error("账号不能为空"));
        } */
        loginApi.checkUser(value).then(res => {
          //console.log(res.data);
          if (res.data.flag) {
            callback();
          } else {
            callback(new Error("用户不存在"));
          }
        });
      }
    };
    return {
      base: base,
      login_form: {
        username: "",
        password: ""
      },
      /* 自定义验证规则 */
      rules: {
        username: [{ validator: user, trigger: "change" }]
      }
    };
  },
  methods: {
    login(form) {
      this.$refs[form].validate(va => {
        if (va) {
          loginApi.getuser(this.login_form).then(res => {
            const resp = res.data;
            // console.log(resp);
            if (resp.flag) {
              /* 将token保存至vuex管理 */
              this.$store.commit("user/setToken", resp.data.token);
              let userinfo = {
                user: this.login_form.username
              };
              this.$store.commit("user/setUserInfo", userinfo);
              this.$router.push("/");
            } else {
              this.$message({
                type: "error",
                message: resp.message
              });
            }
          });
        }
      });
    }
  },
  mounted() {
    this.$refs.input1.focus();
    this.$refs.wrap.style.backgroundImage = `url('${this.base}bg.jpg')`;
  }
};
</script>

<style scoped>
.wrap {
  background-size: 100%;
  background-repeat: no-repeat;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}
.form-wrap {
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4), 0 0 6px rgba(0, 0, 0, 0.2);
  width: 300px;
  padding: 20px;
  margin: 120px 800px;
}
</style>