<template>
<section class="icon3">
<el-row >
  <el-col :span="3"><div class="grid-content bg-purple">.</div></el-col>
  <el-col :span="18" ><div class="grid-content bg-purple">
      <el-page-header @back="goBack" content="遇见不同">
</el-page-header>
<h1></h1>
        <songlist :bool="s" style="padding-top:30px"></songlist>
      <img src="../../img/longimg3.jpg" lt="" width="100%" height="80px" style="padding-top:50px">
        <!-- 第一行 -->
        <h3><i class="el-icon-d-arrow-right"></i>独家综艺</h3>
        <el-row style="padding-top:10px">
            <el-col :span="5" ><div class="grid-content bg-purple"> 
                <img src="../../img/zy1.jpg" alt="" width="220px" height="280px">
                </div></el-col>
                <el-col :span="5" class="zy"><div class="grid-content bg-purple">
                <img src="../../img/zy1.jpg" alt="" width="220px" height="280px">
                </div></el-col>
                <el-col :span="5" class="zy"><div class="grid-content bg-purple">
                <img src="../../img/zy1.jpg" alt="" width="220px" height="280px">
                </div></el-col>
                  <el-col :span="5" class="zy"><div class="grid-content bg-purple">
                <img src="../../img/zy1.jpg" alt="" width="220px" height="280px">
                </div></el-col>
            </el-row>
            <!--第二行-->
             <el-row style="padding-top:30px">
            <el-col :span="5" ><div class="grid-content bg-purple">
                <img src="../../img/zy1.jpg" alt="" width="220px" height="280px">
                </div></el-col>
                <el-col :span="5" class="zy"><div class="grid-content bg-purple">
                <img src="../../img/zy1.jpg" alt="" width="220px" height="280px">
                </div></el-col>
                <el-col :span="5" class="zy"><div class="grid-content bg-purple">
                <img src="../../img/zy1.jpg" alt="" width="220px" height="280px">
                </div></el-col>
                  <el-col :span="5" class="zy"><div class="grid-content bg-purple">
                <img src="../../img/zy1.jpg" alt="" width="220px" height="280px">
                </div></el-col>
            </el-row>
      </div></el-col>
  <el-col :span="3"><div class="grid-content bg-purple">.</div></el-col>
</el-row>
    </section>
</template>
<script>
// import longimg from '../img'
import songlist from '../songlist'
export default {
    
    data(){
        return{
        s:'false'
        }
    },
    methods:{
 goBack() {
     this.$router.go(-1);
 }
    },
      components: {
        songlist,
              },
}
</script>
<style  scoped>
    .zy{
        margin-left:53px;
    }
</style>