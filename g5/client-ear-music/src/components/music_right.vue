<template>
  <section class="music-right">
    <div class="music-all">
      <div class="music-text">
        <router-view name="from" :tableData="music2" :ok=OK></router-view >
        <router-view name="from2" :tableData="music1" :ok=OK></router-view >
        <!--飙升榜-渲染位置-->
        <el-tabs v-model="activeName" type="card" @tab-click="handleClick" v-show="$route.name!='music-song1'&&$route.name!='music-song2'">
          <!--  -->
          <!-- &&$route.name!='music-song2' -->
          <el-tab-pane label="首页" name="second">
            <div class="music-slideshow">
              <!--轮播图-->
              <el-carousel :interval="5000" arrow="never" height="220px">
                <el-carousel-item v-for="item in imagebox" :key="item.id">
                  <img :src="item.idView" class="image">
                </el-carousel-item>
              </el-carousel>
            </div>
            <div class="hotsong">
              <!--热歌right-->
              x
            </div>
            <div class="singer">
              <!--歌手-->

              <div class="singerlist">
                <img src="../img/singer1.jpg" alt="" class="img" />
              </div>
              <div class="singerlist">
                <img src="../img/singer2.jpg" alt="" class="img" />
              </div>
              <div class="singerlist">
                <img src="../img/singer2.jpg" alt="" class="img" />
              </div>
              <div class="singerlist">
                <img src="../img/singer2.jpg" alt="" class="img" />
              </div>
              <el-link
                href="/xx"
                target="_blank"
                style="padding-top: 80px; margin-left: 40px"
                >更多歌手</el-link
              >
            </div>
          </el-tab-pane>
          <el-tab-pane label="新歌首发" name="first">
            <!--分类-->
            <div>
              <!--语种-->
              <el-dropdown style="margin-left: 60px">
                <span class="el-dropdown-link">
                  语种<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item>国语</el-dropdown-item>
                  <el-dropdown-item>韩语</el-dropdown-item>
                  <el-dropdown-item>英语</el-dropdown-item>
                  <el-dropdown-item>粤语</el-dropdown-item>
                  <el-dropdown-item>日语</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
              <!--主题-->
              <el-dropdown style="margin-left: 40px">
                <span class="el-dropdown-link">
                  主题<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item>中国风</el-dropdown-item>
                  <el-dropdown-item>经典</el-dropdown-item>
                  <el-dropdown-item>影视</el-dropdown-item>
                  <el-dropdown-item>童谣</el-dropdown-item>
                  <el-dropdown-item>KTV热歌</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
              <!--心情-->
              <el-dropdown style="margin-left: 40px">
                <span class="el-dropdown-link">
                  心情<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item>伤感</el-dropdown-item>
                  <el-dropdown-item>安静</el-dropdown-item>
                  <el-dropdown-item>励志</el-dropdown-item>
                  <el-dropdown-item>治愈</el-dropdown-item>
                  <el-dropdown-item>甜蜜</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>

              <!--分派-->
              <el-dropdown style="margin-left: 40px">
                <span class="el-dropdown-link">
                  分派<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item>民谣</el-dropdown-item>
                  <el-dropdown-item>摇滚</el-dropdown-item>
                  <el-dropdown-item>轻音乐</el-dropdown-item>
                  <el-dropdown-item>嘻哈</el-dropdown-item>
                  <el-dropdown-item>古典</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div>
            <!--歌曲列表-->
            <!--  -->
            <ss2 :tableData="music1" ></ss2>
          </el-tab-pane>
          <el-tab-pane label="电台" name="third">
            <el-row :gutter="70">
              <el-col :span="7" style="margin-left: 60px"
                ><div class="grid-content bg-purple">
                  <img
                    src="../img/some.jpg"
                    alt=""
                    width="100%"
                    height="140px;"
                  />
                  <p>请你再听听这个城市</p>
                </div></el-col
              >
              <el-col :span="7"
                ><div class="grid-content bg-purple">
                  <img
                    src="../img/some.jpg"
                    alt=""
                    width="100%"
                    height="140px;"
                  />
                  <p>我们很好</p>
                </div></el-col
              >
              <el-col :span="7"
                ><div class="grid-content bg-purple">
                  <img
                    src="../img/some.jpg"
                    alt=""
                    width="100%"
                    height="140px;"
                  /></div
              ></el-col>
            </el-row>
            <el-row :gutter="70">
              <el-col :span="7" style="margin-left: 60px"
                ><div class="grid-content bg-purple">
                  <img
                    src="../img/some.jpg"
                    alt=""
                    width="100%"
                    height="140px;"
                  /></div
              ></el-col>
              <el-col :span="7"
                ><div class="grid-content bg-purple">
                  <img
                    src="../img/some.jpg"
                    alt=""
                    width="100%"
                    height="140px;"
                  /></div
              ></el-col>
              <el-col :span="7"
                ><div class="grid-content bg-purple">
                  <img
                    src="../img/some.jpg"
                    alt=""
                    width="100%"
                    height="140px;"
                  /></div
              ></el-col>
            </el-row>
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
  </section>
</template>
<script>
import ss2 from "./ss2";
export default {
  data() {
    return {
      activeName: "second",
      OK:true,
      imagebox:[{id:0,idView:require('../img/music_right5.jpg')},
        {id:1,idView:require('../img/music_right2.jpg')},
        {id:2,idView:require('../img/music_right3.jpg')},
        {id:3,idView:require('../img/music_right4.png')}
        ],
      //新歌首发music
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
      //飙升榜music
      music2:[
         {
          date: "01",
          name: "斑马",
          address: "5:15",
          names: "宋冬野",
        },
         {
          date: "02",
          name: "六层楼",
          address: "5:15",
          names: "宋冬野",
        },
      ],
      //网络热歌
       music3:[
         {
          date: "01",
          name: "郭源潮",
          address: "7:15",
          names: "宋冬野",
        },
         {
          date: "02",
          name: "可惜没如果",
          address: "5:15",
          names: "林俊杰",
        },
      ],
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
  },
  components: {
    ss2,
  },
};
</script>
<style scoped>
.image{
    width:100%;
      height:inherit;
}
.music-all {
  width: 750px;
  height: 400px;
  box-shadow: 0 7px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
  margin-left: 230px;
  border: solid slateblue 1px;
  border-bottom: none;

}
.music-text {
  width: 100%;
  height: 40px;
  border: solid slateblue 1px;
}
.music-icon {
  padding-top: 20px;
  margin-left: 10px;
}
.music-icon2 {
  margin-left: 20px;
}
.music-slideshow {
  width: 520px;
  height: 220px;
  border: solid darkviolet 1px;
  margin-left: 30px;
  float: left;
}
.myaudio {
  width: 100%;
  outline: none;
  background-color: #f1f3f4;
}
.hotsong {
  width: 189px;
  height: 220px;
  border: solid darkblue 1px;
  margin-left: 560px;
}
.singer {
  width: 700px;
  height: 100px;

  margin-left: 30px;
  margin-top: 5px;
}
.singerlist {
  width: 120px;
  height: 100%;
  float: left;
  margin-left: 30px;
}
.img {
  width: 100%;
  height: 100%;
  border-radius: 20px;
}

/*轮播图 */
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>