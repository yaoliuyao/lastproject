<template>
  <div class="wrap" ref="wrap">
    <div class="form-wrap">
      <el-form
        :model="regedit_form"
        status-icon
        label-position="left"
        label-width="68px"
        :rules="rules"
        ref="forms"
      >
        <el-form-item>
          <h2 style="color:dimgray">用户注册</h2>
        </el-form-item>
        <el-form-item label="账户" prop="username">
          <el-input type="text" v-model="regedit_form.username" ref="input1" placeholder="请输入账号"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="regedit_form.password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="repassword">
          <el-input type="password" v-model="regedit_form.repassword" placeholder="再次确认密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" plain @click="regedit('forms')">确认注册</el-button>
          <el-button type="success" plain @click="$router.push('/login')">去登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import { base } from "../utils/baseStatic"; //导入图片基础路径
import loginApi from "../api/login";
import regeditApi from "../api/regedit";
export default {
  data() {
    const user = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("账号不能为空"));
      } else {
        let uPattern = /^[a-zA-Z0-9]{4,10}$/;
        if (!uPattern.test(value)) {
          callback(new Error("账号必须为4~10位的数字或字母"));
        } else {
          loginApi.checkUser(value).then(res => {
            //console.log(res.data);
            if (res.data.flag) {
              callback(new Error("账号已被注册"));
            } else {
              callback();
            }
          });
        }
      }
    };
    const password = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("密码不能为空"));
      } else {
        if (this.checkStrong(value) < 3) {
          callback(new Error("密码必须大于6位且必须包含数字，大、小写字母、特殊字符中三种"));
        } else {
          callback();
        }
      }
    };
    const repassword = (rule, value, callback) => {
      if (!value) {
        return callback(new Error("密码不能为空"));
      } else {
        if (value != this.regedit_form.password) {
          callback(new Error("两次密码不一致"));
        } else {
          callback();
        }
      }
    };
    return {
      base: base,
      regedit_form: {
        username: "",
        password: "",
        repassword: ""
      },
      /* 自定义验证规则 */
      rules: {
        username: [{ validator: user, trigger: "change" }],
        password: [{ validator: password, trigger: "change" }],
        repassword: [{ validator: repassword, trigger: "change" }]
      }
    };
  },
  methods: {
    checkStrong(sValue) {
      var modes = 0;
      //正则表达式验证符合要求的
      if (sValue.length < 6) return modes;
      if (/\d/.test(sValue)) modes++; //数字
      if (/[a-z]/.test(sValue)) modes++; //小写
      if (/[A-Z]/.test(sValue)) modes++; //大写
      if (/\W/.test(sValue)) modes++; //特殊字符

      //逻辑处理
      switch (modes) {
        case 1:
          modes = 1;
          break;
        case 2:
          modes = 2;
          break;
        case 3:
        case 4:
           modes = sValue.length < 12 ? 3 : 4;break;
      }
      return modes;
    },
    regedit(form) {
      this.$refs[form].validate(va => {
        if (va) {
          regeditApi.saveUser(this.regedit_form).then(res => {
            const resp = res.data;
            // console.log(resp);
            if (resp.flag) {
              this.$message({
                type: "success",
                message: resp.message
              });
              this.$router.push("/login");
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
  margin: 150px 800px;
}
</style>