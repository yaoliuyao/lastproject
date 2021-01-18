<template>
    <section class="song">
        <div style="padding-top:20px;box-shadow: 0 7px 4px rgba(5, 33, 70, 0.12), 0 0 6px rgba(0, 0, 0, .04);">
            <h2 style="padding-left:30px;" v-show="bool!='false'">热门歌单</h2>
        <el-row >
  <el-col :span="10" class="songmax"><div class="grid-content bg-purple">
      <img src="../img/songlist1.jpg" alt="" width="100%" height="200px" @click="$router.push('/songsheet')"></div></el-col>
  <el-col :span="4" class="songmax2"><div class="grid-content bg-purple"> <img src="../img/songlist1.jpg" alt="" width="100%" height="100%"><span>把千疮百孔的那个自我收拢起来，淡定地露出招牌式的酒窝，说：大家好，我是林俊杰。</span></div></el-col>
  <el-col :span="4" class="songmax2"><div class="grid-content bg-purple"> <img src="../img/songlist1.jpg" alt="" width="100%" height="100%"></div></el-col>
  <el-col :span="4" class="songmax2"><div class="grid-content bg-purple"> <img src="../img/songlist1.jpg" alt="" width="100%" height="100%"></div></el-col>
</el-row>
<el-row v-show="bool!='false'">
    
    <el-col :span="10" class="songmax3"><div class="grid-content bg-purple" style="margin-left:20px;">
        <el-col :span="10" class="songmax3"><div class="grid-content bg-purple">
    <img src="../img/songlist1.jpg" alt="" width="100%" height="100%"><span>把千疮百孔的那个自我收拢起来</span></div></el-col>
    <el-col :span="10" class="songmax3"><div class="grid-content bg-purple">
    <img src="../img/songlist1.jpg" alt="" width="100%" height="100%"></div></el-col>
    </div></el-col>
    <el-col :span="4" class="songmax3"><div class="grid-content bg-purple">
    <img src="../img/songlist1.jpg" alt="" width="100%" height="100%"></div></el-col>
    <el-col :span="4" class="songmax3"><div class="grid-content bg-purple">
    <img src="../img/songlist1.jpg" alt="" width="100%" height="100%"></div></el-col>
    <el-col :span="4" class="songmax3"><div class="grid-content bg-purple">
    <img src="../img/songlist1.jpg" alt="" width="100%" height="100%"></div></el-col>
    
</el-row>
</div>
    </section>
</template>
<script>
export default {
     props: ["bool"],
    data(){
        return{
        }
    },
}
</script>
<style scoped>
    .songmax{
        margin-left: 20px;
    }
    .songmax2{
        margin-left: 10px;
        padding-top: 10px;
    }
    .songmax3{
        margin-left: 14px;
    }
</style>