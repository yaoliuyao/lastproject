<template>
    <section >
        <div style="position:relative;">
             <div class="headimg">
               <h2 style="">发现音乐</h2>
               
            <img src="../img/mymusic1.jpg" alt="" 
            width="180px" 
            height="150px" 
            style="border-radius:70%; opacity:0.7;"><br>
            <el-button style="margin-top:20px;opacity:0.7;"  @click="login = true">立即登录，发现精彩</el-button>
            </div>
            <img src="../img/backimg2.jpeg" alt="" width="1340px" >
        </div>
         <el-dialog  :visible.sync="login" >
          <div>
            <el-row :gutter="20">
  <el-col :span="11"><div class="grid-content bg-purple">
    <div   class="scan1"  >
            <img src="../img/my1.jpg" alt="" width="80%" height="70%" style="margin-left:20px;">
            <img src="../img/my2.jpg" alt="" width="15%" height="15%" class="icon">
            <img src="../img/my3.png" alt="" width="15%" height="15%" class="icon">
            <img src="../img/my4.jpg" alt="" width="15%" height="15%" class="icon">
            </div></div></el-col>
            <el-col :span="13"><div class="grid-content bg-purple">
    <div class="scan2">
            <img src="../img/mylogin.jpg" alt="" class="loginimg"  width="40%" height="30%">
            <form action="" class="forminp">
            <el-input v-model="input" placeholder="请输入账号" class="inp">{{input}}</el-input>
            <el-input placeholder="请输入密码" v-model="input2" show-password class="inp">{{input2}}</el-input>
             <el-button type="primary" plain class="but">登录</el-button>
            </form>
            </div></div></el-col>
            </el-row>
          </div>
         </el-dialog>
    </section>
</template>
<script>
  export default {
    data() {
      return {
        login:false,
        input:'',
        input2:'',  
      }
    }
  }
</script>
<style  scoped>
.headimg{
    position:absolute;
    top:27%;
    left:45%;
    text-align: center;
}
.scan2{
  width: 320px;
  height: 400px;
  
}
.scan1{
width:300px;
height:390px;
padding-top:10px;
border-right: darkblue 1px solid;
}
.icon{
  padding-left: 40px;
}
.loginimg{
  margin-top:10%;
  margin-left: 35%;
  
}
.forminp{
  padding-left: 50px;
  padding-top:20px;
}
.inp{
  width: 250px;
  padding-top:10px;
}
.but{
  margin-top:20px;
  margin-left: 50px;
  width: 140px;
}
</style>