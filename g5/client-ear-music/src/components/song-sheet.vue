<template>
    <section class="songsheet">
        <div class="songlist">
          
        <div>
            <el-row >
            <el-col :span="3"><div class="grid-content bg-purple" >.</div></el-col>
           <el-col :span="18"><div class="grid-content bg-purple" >
            <el-page-header @back="goBack" content="热门歌单">
            </el-page-header>
            <div>
                <el-row >
  <el-col :span="8" class="img"><div class="grid-content bg-purple" >x</div></el-col>
  <el-col :span="16" class="imgtext"><div class="grid-content bg-purple">x
      </div></el-col>
</el-row>
        <div class="text">
            <span class="textsong"><i class="el-icon-d-arrow-right
"></i>全部歌曲</span>
        </div>

            </div>
               </div></el-col>
           <el-col :span="3"><div class="grid-content bg-purple" >.</div></el-col>
</el-row>
        </div>
        </div>
    </section>
</template>
<style  scoped>
    .songlist{
        margin-top: 100px;
    }
    .img{
        margin-top: 50px;
        margin-left: 30px;
        height: 250px;
        width: 25%;
        background: darkgoldenrod;
    }
    .imgtext{
        margin-top: 50px;
        margin-left: 30px;
        height: 250px;
        background: darkcyan;
    }
    .textsong{
        font-size: 20px;
        font-weight: bold;
    }
    .text{
        padding-top: 40px;
    }
    
</style>
<script>
export default {
     
    data(){
        return{
            OK:true,
          music1: [
        {
          date: "01",
          name: "我们很好",
          address: "5:15",
          names: "林俊杰",
        },
        {
          date: "02",
          name: "安河桥",
          address: "5:12",
          names: "宋冬野",
        },
      ],

        }
    },
    methods:{
        goBack() {
     this.$router.go(-1);
 },
 components:{
 }
    }
}
</script>