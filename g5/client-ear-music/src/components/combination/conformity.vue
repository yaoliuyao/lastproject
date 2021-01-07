<template>
<section class="icon">
<el-row >
  <el-col :span="3"><div class="grid-content bg-purple">x</div></el-col>
  <el-col :span="18"><div class="grid-content bg-purple">
      <el-page-header @back="goBack" content="每日推荐">
</el-page-header>
      <long-img :imgsrc="sr"></long-img>
      <ss></ss>
      </div></el-col>
  <el-col :span="3"><div class="grid-content bg-purple">x</div></el-col>
</el-row>
    </section>
</template>
<script>
// import longimg from './img'
import longimg from '../img'
import ss from '../ss'
export default {
    data(){
        return{
            sr:require('../../img/longimg.jpg')
            
        }
    },
    methods:{
 goBack() {
     this.$router.go(-1);
 }
    },
      components: {
        //   longnimg
        "long-img":longimg,
        ss
              },
}
</script>
<style  scoped>

</style>