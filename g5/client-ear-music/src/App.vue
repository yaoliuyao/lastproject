<template>
  <div id="app">
    <ear-nav></ear-nav>
    <!--导航栏-->
    <router-view name="my"> </router-view> 
     <router-view name="musician"> </router-view> 
     <router-view name="songsheet"> </router-view> 
    <!--max轮播图-->
    <div class="banner" 
   v-show="$route.name!=='my'
    && $route.name!=='musician'
    && $route.name!=='sheet'">
      <ear-banner></ear-banner>
    </div>
    <router-view></router-view >
    <router-view name="icon2"> </router-view> 
    <router-view name="icon3"></router-view>
    <el-row 
    v-show="$route.name!=='music-conformity'
    && $route.name!=='music-conformity2'
    && $route.name!=='music-conformity3'
    && $route.name!=='music-conformity4'
    && $route.name!=='my'
    && $route.name!=='musician'
    && $route.name!=='sheet'
    ">
      <el-col :span="3"><div class="grid-content bg-purple">x</div></el-col>
      <el-col :span="18"
        ><div class="grid-content bg-purple">
          <div class="body-centen">
            <!-- 居中内容部分 -->
            <div style="height: 150px">
             <!-- 渲染到指定位置 -->
             
              <div class="body-text" >
                <span>懂你所想</span>
              </div>
              <!-- 懂你所想 -->
              <div>
                <!-- icon -->
                <icon></icon>
              </div>
            </div>

           <!-- 推荐left -->
            <recommend></recommend>
            <!-- 音乐频道right -->
            <music-right></music-right>
            <!-- 热门歌单 -->
            <song></song>
            <!-- 长图片 -->
             <!-- <div style="padding-top: 50px">
              <img src="./img/longimg.jpg" alt="" width="100%" height="150px" />
            </div>  -->
        <long-img :imgsrc="sr"></long-img>

            <!-- MV精选 -->
            <mv ></mv>
            <!-- :imgsrc1="imgsrc1" :imgsrc2="imgsrc2" -->
          </div></div
      ></el-col>
      <el-col :span="3"><div class="grid-content bg-purple">x</div></el-col>
    </el-row>
   <!-- 播放音乐 -->
    <play></play>

   <!-- 尾部 -->
    <tail></tail>
    
  
  </div>
</template>
<script>
import nav from "./components/nav";
import banner from "./components/banner";
import icon from "./components/body-icon";
import recommend from "./components/recommend";
import music from "./components/music_right";
import song from "./components/songlist";
import mv from "./components/video";
import tail from "./components/tail";
import play from "./components/playmusic";
import longimg from "./components/img";
// import con from "./components/combination/conformity";
export default {
  name: "app",
  data: function () {
    return {
      //长图地址
      sr:require('./img/longimg.jpg')
    };
  },
   methods: {
   
   },

  components: {
    "ear-nav": nav,
    "ear-banner": banner,
    icon,
    recommend,
    "music-right": music,
    song,
    mv,
    tail,
    play,
    "long-img": longimg,
    // con,
  },
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  background: #ffffff;
  position: absolute;
}
.banner {
  /* margin-top: 60px; */
  padding-top: 70px;
}
.body-centen {
  width: 100%;
  height: 100%;
  border: solid rebeccapurple 2px;
}
.body-text {
  height: 100%;
  width: 200px;
  border: solid red 1px;
  float: left;
}
</style>
