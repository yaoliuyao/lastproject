<template>
  <section class="ear-banner">
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item v-for="item in imagebox" :key="item.id">
         <img :src="item.idView" class="image">
      </el-carousel-item>
    </el-carousel>
  </section>
</template>
<script>
export default {
  components: {
  },
  data() {
    return {
       imagebox:[{id:0,idView:require('../img/banner1.jpg')},
        {id:1,idView:require('../img/banner2.jpg')},
        {id:2,idView:require('../img/banner3.jpg')}
        ],
    };
  },
mounted() {
   
          }
};
</script>
<style  scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.image{
  width:100%;
      height:inherit;
  
}
</style>
