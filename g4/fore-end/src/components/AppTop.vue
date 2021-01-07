<template>
  <el-menu
    :default-active="$route.path"
    class="el-menu-demo"
    mode="horizontal"
    active-text-color="red"
    router
  >
    <el-menu-item index="/test">
      <el-image :src="baseTitle+titleUrl" style="width:200px;line-height:30px"></el-image>
    </el-menu-item>
    <el-menu-item style="margin-left:160px">
      <el-form :model="search_forms">
        <el-input
          placeholder="请输入关键字"
          v-model="search_forms.str"
          clearable
          size="small"
          @keyup.native.enter="search"
        ></el-input>
        <input type="text" style="display:none" />
      </el-form>
    </el-menu-item>
    <el-menu-item index="/home" class="fo" style="margin-left:40px">首页</el-menu-item>
    <el-menu-item index="/talk" class="fo">日常话题</el-menu-item>
    <el-submenu index="/more1">
      <template slot="title">
        <span class="fo">服务分类</span>
      </template>
      <el-menu-item index="/contribute">学生投稿</el-menu-item>
      <el-menu-item index="/lost">失物招领</el-menu-item>
    </el-submenu>

    <el-menu-item index="/new" class="fo">我要发布</el-menu-item>

    <el-menu-item style="float:right" index="/test1">
      <el-dropdown @command="handleCommand">
        <el-avatar v-if="avatar" :size="50" :src="base+avatar" class="el-dropdown-link"></el-avatar>
        <el-avatar
          v-else
          :size="50"
          src="https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png"
          class="el-dropdown-link"
        ></el-avatar>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="sysmsg">系统消息</el-dropdown-item>
          <el-dropdown-item command="personal">个人资料</el-dropdown-item>
          <el-dropdown-item command="exit">退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </el-menu-item>
  </el-menu>
</template>

<script>
import { base } from "../utils/baseStatic"; //导入图片基础路径
import { baseAvatar } from "../utils/baseStatic"; //导入图片基础路径
import getDataApi from "../api/getItem";
import * as local from "../utils/local";
export default {
  data() {
    return {
      baseTitle: base,
      base: baseAvatar,
      avatar: null,
      search_forms: {
        str: ""
      },
      titleUrl: "title.png"
    };
  },
  created() {
    this.getUserInfo();
  },

  methods: {
    getUserInfo() {
      getDataApi.getUserName(local.getUser().user).then(res => {
        //console.log(res.data.data[0].avatar)
        this.avatar = res.data.data[0].avatar;
      });
    },
    handleCommand(command) {
      switch (command) {
        case "personal":
          //this.$message("个人资料");
          this.$router.push("/personal");
          break;
        case "exit":
          // this.$message('退出')
          local.removeToken();
          this.$router.push("/login");
          break;
        case "sysmsg":
          this.$router.push("/sysmsg");
          break;
        default:
          break;
      }
    },
    search() {
      if (this.search_forms.str != "") {
        //如果不在搜索页，就让他跳转至搜索页
        if (this.$route.path != "/searchresult") {
          this.$router.push("/searchresult");
        }
        //将搜索关键字保存至vuex管理
        this.$store.commit("searchdata/setQuery", this.search_forms.str);
        this.search_forms.str = "";
      }
    }
  }
};
</script>

<style scoped>
.el-menu {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  height: 100px;
  background-color: white;
  box-sizing: border-box;
  padding: 20px;
}
.fo {
  font-size: 17.5px;
}
.el-menu--horizontal > .el-menu-item {
  border-bottom-style: none;
}
</style>