<template>
<section class="icon">
<el-row >
  <el-col :span="3"><div class="grid-content bg-purple">.</div></el-col>
  <el-col :span="18" ><div class="grid-content bg-purple">
      <el-page-header @back="goBack" content="耳遇专栏">
</el-page-header>
<h1>音乐人的专属对话</h1>
<el-divider><i class="el-icon-headset"></i></el-divider>
<h3><i class="el-icon-d-arrow-right"></i>最新资讯</h3>
<!--最新资讯-->
    <el-row style="margin-top:20px;">
         <el-col :span="10" style="margin-left:30px;"><div class="grid-content bg-purple" >
             <img src="../../img/zf.jpg" alt="" >
             </div></el-col>
         <el-col :span="5" style="margin:30px;"><div class="grid-content bg-purple" >
                <img src="../../img/zf2.jpg" alt="" width="100%" >
                <p>与陈奕迅的独特对话:我们终身都在寻觅爱</p>
             </div></el-col>
         <el-col :span="5" style="margin:30px;"><div class="grid-content bg-purple">
             <img src="../../img/zf2.jpg" alt="" width="100%" >
             <p>与陈奕迅的独特对话:我们终身都在寻觅爱xxxxxxxxxxxxxxxx</p>
             </div></el-col>
    </el-row>
    <h3><i class="el-icon-d-arrow-right"></i>热门推荐</h3>
    <!--热门推荐-->
    <el-row style="margin-top:40px;">
        <el-col :span="7" style="margin-left:30px;"><div class="grid-content bg-purple" >
            <img src="../../img/zf2.jpg" alt="" width="100%" height="170px"></div></el-col>
              <el-col :span="7" style="margin-left:30px;"><div class="grid-content bg-purple" >
            <img src="../../img/zf2.jpg" alt="" width="100%" height="170px"></div></el-col>
              <el-col :span="7" style="margin-left:30px;"><div class="grid-content bg-purple" >
            <img src="../../img/zf2.jpg" alt="" width="100%" height="170px"></div></el-col>
    </el-row>
       <el-row style="margin-top:40px;">
        <el-col :span="7" style="margin-left:30px;"><div class="grid-content bg-purple">
            <img src="../../img/zf2.jpg" alt="" width="100%" height="170px"></div></el-col>
              <el-col :span="7" style="margin-left:30px;"><div class="grid-content bg-purple" >
            <img src="../../img/zf2.jpg" alt="" width="100%" height="170px"></div></el-col>
              <el-col :span="7" style="margin-left:30px;"><div class="grid-content bg-purple" >
            <img src="../../img/zf2.jpg" alt="" width="100%" height="170px"></div></el-col>
    </el-row>
    <el-row style="margin-top:40px;">
        <el-col :span="7" style="margin-left:30px;"><div class="grid-content bg-purple">
            <img src="../../img/zf2.jpg" alt="" width="100%" height="170px"></div></el-col>
              <el-col :span="7" style="margin-left:30px;"><div class="grid-content bg-purple" >
            <img src="../../img/zf2.jpg" alt="" width="100%" height="170px"></div></el-col>
              <el-col :span="7" style="margin-left:30px;"><div class="grid-content bg-purple" >
            <img src="../../img/zf2.jpg" alt="" width="100%" height="170px"></div></el-col>
    </el-row>
     
      </div></el-col>
  <el-col :span="3"><div class="grid-content bg-purple">.</div></el-col>
</el-row>
    </section>
</template>
<script>
export default {
    data(){
        return{
            
        }
    },
    methods:{
 goBack() {
     this.$router.go(-1);
 }
    },
      components: {
              },
}
</script>
<style  scoped>
    .c{
        
    }
</style>