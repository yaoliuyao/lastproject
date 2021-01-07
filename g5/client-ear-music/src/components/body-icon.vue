<template>
  <section class="icon">
    
    <el-row style="padding-top: 15px">
      <el-col :span="4" style="margin-left: 90px"
        ><div class="grid-content bg-purple">
          <img src="../img/icon1.png" alt="" class="img1"  @click="$router.push('/con')"/>
          
          <p class="icon-text" @click="$router.push('/con')" ><i class="el-icon-s-promotion"></i>每日推荐</p>
        </div></el-col
      >
      <el-col :span="4"
        ><div class="grid-content bg-purple">
          <img src="../img/icon2.png" alt="" class="img1"  @click="$router.push('/icon2')"/>
          <p class="icon-text" @click="$router.push('/icon2')"><i class="el-icon-s-promotion" ></i>遇见不同</p>
        </div></el-col
      >
      <el-col :span="4"
        ><div class="grid-content bg-purple">
          <img src="../img/icon3.png" alt="" class="img1"  @click="$router.push('/icon3')"/>
          <p class="icon-text" @click="$router.push('/icon3')"><i class="el-icon-s-flag" ></i>独家放送</p>
        </div></el-col
      >
      <el-col :span="4"
        ><div class="grid-content bg-purple">
          <img src="../img/icon4.png" alt="" class="img1" @click="$router.push('/icon4')" />
          <p class="icon-text"><i class="el-icon-s-comment"></i>耳遇专栏</p>
        </div></el-col
      >
    </el-row>
  </section>
</template>
<script>
export default {
  data() {
    return {};
  },
  methods: {
    xx() {},
  },
};
</script>
<style scoped>
.img1 {
  height: 80px;
}
.img1:hover{
  cursor:pointer;
}
.icon-text {
  font-weight: bold;
}
</style>
