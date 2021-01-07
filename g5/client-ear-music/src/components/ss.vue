<template>
    <section class="ss">
          <!-- <el-row style="padding-left:20px;">
  <el-col :span="1"><div class="grid-content bg-purple">
    <el-checkbox v-model="checked" style="padding-top:20px;padding-left:20px;"></el-checkbox></div></el-col>
  <el-col :span="5"><div class="grid-content bg-purple" style="padding-left:20px;">
   <img src="../img/playicon1.png" alt="" width="25px" height="25px" style="padding-bottom:10px;"> <img src="../img/play1.jpg" alt="" width="70px;" height="50px" style="padding-left:10px;"></div></el-col>
  <el-col :span="15"><div class="grid-content bg-purple" >
    <audio ref='audio'  src="../mp3/不要说话 - 陈奕迅.mp3" controls  loop muted class="myaudio"></audio></div></el-col>
  <el-col :span="3"><div class="grid-content bg-purple">
    <img src="../img/music-icon.png" alt="" width="15px" height="15px;" class="music-icon">
    <img src="../img/music-icon2.png" alt="" width="15px" height="15px;" class="music-icon2">
   </div></el-col>
</el-row> -->
    <div class="music-ss">
     <el-table
    ref="multipleTable"
    :data="tableData"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column
      type="selection"
      width="55">
    </el-table-column>
    <el-table-column
      label="排序"
      width="50">
      <template slot-scope="scope">{{ scope.row.date }}</template>
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="350">
    </el-table-column>
    <el-table-column
      prop="names"
      label="歌手"
      width="200">
    </el-table-column>
    <el-table-column
      prop="address"
      label="时长"
      width="50">
    </el-table-column>
     <el-table-column
      prop="a"
      label=" "
      width="50">
    </el-table-column>
    
  </el-table>
    </div>
    
    </section>
</template>
<script>
  export default {
    data() {
      return {
        tableData: [{
          date: '1',
          name: '歌曲标题',
          address: '4:20',
          names:'华晨宇',
        }, {
          date: '2',
          name: '歌曲标题',
          address: '4:20',
          names:'华晨宇',
          
        }, {
          date: '3',
          name: '歌曲标题',
          address: '4:20',
          names:'华晨宇',
        }],
        multipleSelection: []
      }
    },

    methods: {
      
    }
  }
</script>
<style scoped>
    .myaudio {
      width: 100%;
  outline: none;
  background-color: #f1f3f4;
}
    .music-icon{
      padding-top:20px;
      margin-left: 10px;
    }
    .music-icon2{
       margin-left: 20px;
    }
    .music-ss{
    }
</style>