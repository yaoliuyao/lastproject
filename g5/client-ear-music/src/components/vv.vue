<template>
   <div id="vv">
        <el-tab-pane label="新歌首发" name="first">
  <el-row style="padding-left:20px;">
  <el-col :span="1"><div class="grid-content bg-purple">
    <el-checkbox v-model="checked" style="padding-top:20px;padding-left:20px;"></el-checkbox></div></el-col>
  <el-col :span="5"><div class="grid-content bg-purple" style="padding-left:20px;">
   <img src="../img/playicon1.png" alt="" width="25px" height="25px" style="padding-bottom:10px;"> <img src="../img/play1.jpg" alt="" width="70px;" height="50px" style="padding-left:10px;"></div></el-col>
  <el-col :span="15"><div class="grid-content bg-purple" >
    <audio ref='audio'  src="../mp3/不要说话 - 陈奕迅.mp3" controls autoplay loop class="myaudio"></audio></div></el-col>
  <el-col :span="3"><div class="grid-content bg-purple">
    <img src="../img/music-icon.png" alt="" width="15px" height="15px;" class="music-icon">
    <img src="../img/music-icon2.png" alt="" width="15px" height="15px;" class="music-icon2">
   </div></el-col>
</el-row>
</el-tab-pane>

  </div>
</template>
<style  scoped>
    .music-icon{
    padding-top:20px;
    margin-left: 10px;
    }
    .music-icon2{
       margin-left: 20px;
    }
    .myaudio {
    width: 100%;
    outline: none;
    background-color: #f1f3f4;
}
</style>