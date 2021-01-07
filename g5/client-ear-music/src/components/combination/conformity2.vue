<template>
<section class="icon">
<el-row >
  <el-col :span="3"><div class="grid-content bg-purple">.</div></el-col>
  <el-col :span="18" ><div class="grid-content bg-purple">
      <el-page-header @back="goBack" content="遇见不同">
</el-page-header>
        <img src="../../img/mv1.jpg" alt="" height="220px" width="450px" style="padding-top:50px">
        <img src="../../img/mv1.jpg" alt="" height="220px" width="450px" style="padding-left:100px">
      <ss></ss>
      <img src="../../img/longimg3.jpg" alt="" width="100%" height="80px">
      </div></el-col>
  <el-col :span="3"><div class="grid-content bg-purple">.</div></el-col>
</el-row>
    </section>
</template>
<script>
import ss from '../ss'
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
        ss
              },
}
</script>
<style  scoped>

</style>