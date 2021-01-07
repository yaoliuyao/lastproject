<template>
    <section class="recommend">
         <div class="recommend"><!--推荐left-->
            <div class="recommend-text">
               分类
            </div>
            <div class="recommend-img">
                <img src="../img/img1.jpg" alt="" class="img">
                <el-button style="width:120px;margin-top:10px;" @click="$router.push('/song1')">飙升榜</el-button>
                <!--  -->
            </div>
            <div class="recommend-img">
                <img src="../img/img1.jpg" alt="" class="img">
                <el-button style="width:120px;margin-top:10px;" @click="$router.push('/song2')">网络热曲</el-button>
            </div>
            <div class="recommend-img">
                <img src="../img/img1.jpg" alt="" class="img">
                 <el-button style="width:120px;margin-top:10px;">经典怀旧</el-button>
            </div>
          </div>
    </section>
</template>
<style  scoped>
.recommend{
    width: 200px;
    height: 400px;
     box-shadow: 0 7px 4px rgba(5, 33, 70, 0.12), 0 0 6px rgba(0, 0, 0, .04);
     float: left;
     border-right: solid rgb(84, 103, 122) 1px;

}
.recommend-img{
    margin-top: 30px;

}
.img{
    float:left;
    width:80px;
    height:60px;
}
</style>