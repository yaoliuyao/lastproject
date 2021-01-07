<template>
  <section class="ear-nav">
    <!-- <el-row style="background:red;">
  <el-col :span="4" style="background:blue;"><div class="grid-content bg-purple" >
      <img src="../img/757997_multimedia_512x512(2).png" class="nav" alt="" >
    </div></el-col>
  <el-col :span="4"><div class="grid-content bg-purple">
    <div>发现</div>
    </div></el-col>
  <el-col :span="4"><div class="grid-content bg-purple">
     <div>发现</div>
    </div></el-col>
  <el-col :span="4"><div class="grid-content bg-purple">
     <div>发现</div>
    </div></el-col>
    <el-col :span="4"><div class="grid-content bg-purple">
    <div class="nav-text">发现</div>
    </div></el-col>
  <el-col :span="4" style="background:blue;"><div class="grid-content bg-purple">
    </div></el-col>
</el-row> -->
<div class="zc">
 <el-row style="height:55px;">
  <el-col :span="4"><div class="grid-content bg-purple">
      <div ><img src="../img/757997_multimedia_512x512(2).png" alt="" style="width:200px;height:55px;padding-left:60px;" @click="$router.push('/')" ></div>
      </div></el-col>
  <el-col :span="2"><div class="grid-content bg-purple-light" >
       <div class="zz"><span style="">发现</span></div>
        </div></el-col>
        <el-col :span="2"><div class="grid-content bg-purple-light">
        <div  ><router-link  tag="a" target="_blank" to="/music2" class="zz">我的音乐</router-link></div>
        </div></el-col>
        <el-col :span="2"><div class="grid-content bg-purple-light">
            <div><router-link  tag="a" target="_blank" to="/music3" class="zz">音乐人</router-link></div>
        </div></el-col>
        <el-col :span="2"><div class="grid-content bg-purple-light">
            <div class="zz">客户端下载</div>
        </div></el-col>
          <el-col :span="2"><div class="grid-content bg-purple-light">
            <div class="zz">关于我们</div>
        </div></el-col>
        <el-col :span="6" :offset="2"><div class="grid-content bg-purple-light">
          <el-input
            placeholder="请输入内容"
            v-model="input"
            clearable class="nav-input">
          </el-input>
          <el-button icon="el-icon-search" circle style="margin-left:20px;" ></el-button>
        </div></el-col>
        <el-col :span="2"><div class="grid-content bg-purple-light" style="">
          <div class="nav-login">
           <el-link style="font-size:17px;"  @click="dialogFormVisible = true">登录</el-link>
            <el-divider direction="vertical"></el-divider>
           <el-link style="font-size:17px;"  @click="dialogFormVisible = true">注册</el-link>
           </div>
        </div></el-col>
 </el-row>
<hr>
</div>
 <el-dialog  :visible.sync="dialogFormVisible" >
  <!-- <div style="border">
    <span class="textlogin">登录</span><img src="../img/login2.png" alt="" width="50px" height="50px" >
    </div> -->
      <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="用户登录" name='second'>
      <el-row style="padding-top:20px;">
     <el-col :span="6" ><div class="grid-content bg-purple-light" style="padding-left:90px;padding-top:10px;">
        <span style="font-size:15px;"><i class="el-icon-user-solid"></i>用户名:</span>
        </div></el-col>
        <el-col :span="11" style="margin-left:10px;"><div class="grid-content bg-purple-light" >
          <el-input v-model="in1" placeholder="请输入账号">{{in1}}</el-input>
        </div></el-col>
        <el-col :span="6"><div class="grid-content bg-purple-light">

        </div></el-col>
   </el-row>
 <el-row style="padding-top:30px;">
   <el-col :span="6" ><div class="grid-content bg-purple-light" style="padding-left:105px;padding-top:10px;">
        <span style="font-size:15px;"><i class="el-icon-lock"></i>密码:</span>
        </div></el-col>
        <el-col :span="11" style="margin-left:10px;"><div class="grid-content bg-purple-light" >
         <el-input placeholder="请输入密码" v-model="in2" show-password>{{in2}}</el-input>
        </div></el-col>
        <el-col :span="6"><div class="grid-content bg-purple-light">
        </div></el-col>
 </el-row>
 <el-button type="primary" plain class="but">立即登录</el-button>
 <el-link type="primary" style="margin-left:120px;">没有账号？立即注册</el-link>
    </el-tab-pane>
      <!--切换注册-->
       <el-tab-pane label="用户注册" name='first'>
         <el-row style="padding-top:20px;">
     <el-col :span="6" ><div class="grid-content bg-purple-light" style="padding-left:90px;padding-top:10px;">
        <span style="font-size:15px;"><i class="el-icon-user-solid"></i>昵称:</span>
        </div></el-col>
        <el-col :span="11" style="margin-left:10px;"><div class="grid-content bg-purple-light" >
          <el-input v-model="in3" placeholder="输入您的昵称">{{in3}}</el-input>
        </div></el-col>
        <el-col :span="6"><div class="grid-content bg-purple-light">
        </div></el-col>
   </el-row>
 <el-row style="padding-top:30px;">
   <el-col :span="6" ><div class="grid-content bg-purple-light" style="padding-left:105px;padding-top:10px;">
        <span style="font-size:15px;"><i class="el-icon-lock"></i>密码:</span>
        </div></el-col>
        <el-col :span="11" style="margin-left:10px;"><div class="grid-content bg-purple-light" >
         <el-input placeholder="输入您想要的密码" v-model="in4" show-password>{{in4}}</el-input>
        </div></el-col>
        <el-col :span="6"><div class="grid-content bg-purple-light">
        </div></el-col>
 </el-row>
 <el-row style="padding-top:30px;">
   <el-col :span="6" ><div class="grid-content bg-purple-light" style="padding-left:80px;padding-top:10px;">
        <span style="font-size:15px;"><i class="el-icon-paperclip"></i>重复密码:</span>
        </div></el-col>
        <el-col :span="11" style="margin-left:10px;"><div class="grid-content bg-purple-light" >
         <el-input placeholder="请再次输入您的密码" v-model="in5" show-password>{{in5}}</el-input>
        </div></el-col>
        <el-col :span="6"><div class="grid-content bg-purple-light">
        </div></el-col>
 </el-row>
 <el-button type="primary" plain class="but" @click="log()">立即注册</el-button>
       </el-tab-pane>
      
   
  </el-tabs>
 </el-dialog>

  </section>
</template>
<script>
export default {
  data(){
    return{
      in1:'',
      in2:'',
      in3:'',
      in4:'',
      in5:'',
      dialogFormVisible:false,
      activeName: 'second',
      
    }
  },
    methods: {
      
    },
}
</script>
<style  scoped>
  /* .nav{
    height: 55px;
    width: 100%;
  } */
   .zz{
      height:40px;
      text-align: center;
      display: block;
      padding-top:20px;
      font-size:15px;
      font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
      font-weight: bold;
      color: #000000;
      text-decoration:none;
      
  }
  .zc{
     left: 0;  position: fixed;  top: 0;  width: 100%;  z-index: 1000; 
     background: #F2F6FC;

  }
  .zz:hover{
      background:#D9ECFF;
      font-size: 17px;
      cursor:pointer;
  }
  .textlogin{
    font-size: 22px;
    font-weight: bold;
    /* margin-left: 280px; */
    margin-left: 45%;
    line-height: 0px;
  }
  .but{
    margin-left: 42%;
    margin-top: 40px;
  }
  .nav-input{
    width: 200px;
    padding-top: 10px;
}
.nav-login{
  padding-top:20px;
}
</style>