<template>
    <section class="daohang">
        <div class="all">
        <el-row>
  <el-col :span="4"><div class="grid-content bg-purple">
      <div><img src="../img/2.jpg" alt="" style="width:100%;height:80px"></div>
       
      </div></el-col>
  <el-col :span="3"><div class="grid-content bg-purple-light" >
       <div class="zz"><span style="display: block;padding-top:20px;font-size:20px;">首页</span></div>
        </div></el-col>
        <el-col :span="3"><div class="grid-content bg-purple-light,a">
        <div class="zz">我的音乐</div>
        </div></el-col>
        <el-col :span="3"><div class="grid-content bg-purple-light">
            <div class="zz">歌手</div>
        </div></el-col>
        <el-col :span="3"><div class="grid-content bg-purple-light">
            <div class="zz">关于我们</div>
        </div></el-col>
  <el-col :span="8"><div class="grid-content bg-purple-light">
            <input type="text" name="" id="">
            <button>按钮</button>
            <el-button round @click="xz = true">登录</el-button>
            <el-button round @click="goBack">注册</el-button>
        </div></el-col>
    </el-row>
         <el-dialog :visible.sync="xz">
            <h1>发表</h1>
        <el-row>
            <el-col :span="7"><div class="grid-content bg-purple-light" style="height:40px;text-align:center;line-height:40px;padding-left:140px">
                <span style="font-size:16px;">账号:</span>
                </div></el-col>
                 <el-col :span="10"><div class="grid-content bg-purple">
                     <el-input v-model="input" placeholder="请输入内容" style="padding-left:10px;width:250px;"  >
                         
                     </el-input>
                     <span>{{input}}</span>
                     </div></el-col>
</el-row>
 <el-row style="padding-top:25px;">
            <el-col :span="7"><div class="grid-content bg-purple-light" style="height:40px;text-align:center;line-height:40px;padding-left:140px">
                <span style="font-size:16px;">密码:</span>
                </div></el-col>
                 <el-col :span="10"><div class="grid-content bg-purple">
                    
                     <el-input  v-model="input" placeholder="请输入内容" style="padding-left:10px;width:250px;"></el-input>
                     <span>{{input}}</span>
                     </div></el-col>
</el-row>
            <div class="butt">
                <el-button type="primary" icon="el-icon-edit" style="margin-right:40px;">确认</el-button>
                <el-button type="primary" icon="el-icon-edit">取消</el-button>
            </div>
 </el-dialog>
</div>
<hr>
    </section>
</template>
<script>
    export default{
        data:function(){
            return{
                xz:false,
                input:'',
            }
        },
        methods:{
            goBack() {
//     this.$router.push({
    
//     path: "/EnergyFactory"要跳转的页面的路由

//   });
this.$router.replace('/login') //跳转页面的路由
},
        }
    }
</script>
<style  scoped>
  .xxx{
      background: darkslategrey;
      /* display: block;
      width: 100%;
      height:100%; */
  }
  .zz{
      height: 80px;
      text-align: center;

  }
  .zz:hover{
      background: firebrick;
     
  }
  .butt{
      padding-top:30px;
  }

  
  
  
</style>