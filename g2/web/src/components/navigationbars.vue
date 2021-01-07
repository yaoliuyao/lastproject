<template>
    <div id="zhongjian">

        <div id="zuo">
            <el-row class="tac">
                <el-col :span="4">
                    <el-menu
                            default-active="2"
                            class="el-menu-vertical-demo"
                            @open="handleOpen"
                            @close="handleClose">
                        <el-menu-item index="2">
                            <i class="el-icon-menu"></i>
                            <span slot="title">四川省</span>
                        </el-menu-item>
                        <el-menu-item index="3">
                            <i class="el-icon-document"></i>
                            <span slot="title">广东省</span>
                        </el-menu-item>
                        <el-menu-item index="4">
                            <i class="el-icon-setting"></i>
                            <span slot="title">湖南省</span>
                        </el-menu-item>
                        <el-menu-item index="2">
                            <i class="el-icon-menu"></i>
                            <span slot="title">广西省</span>
                        </el-menu-item>
                        <el-menu-item index="3">
                            <i class="el-icon-document"></i>
                            <span slot="title">辽宁省</span>
                        </el-menu-item>
                        <el-menu-item index="4">
                            <i class="el-icon-setting"></i>
                            <span slot="title">湖北省</span>
                        </el-menu-item>
                        <el-menu-item index="2">
                            <i class="el-icon-menu"></i>
                            <span slot="title">啦啦省</span>
                        </el-menu-item>
                        <el-menu-item index="3">
                            <i class="el-icon-document"></i>
                            <span slot="title">八个省</span>
                        </el-menu-item>
                        <el-menu-item index="4">
                            <i class="el-icon-setting"></i>
                            <span slot="title">中国</span>
                        </el-menu-item>
                    </el-menu>
                </el-col>

            </el-row>

        </div>
        <div id="lunbo">
            <el-carousel :interval="2000" type="card" height="300px">
                <el-carousel-item v-for="item in 6" :key="item">
                    <h3 class="medium">{{ item }}</h3>
                </el-carousel-item>
            </el-carousel>
        </div>


    </div>



</template>

<script>
    export default {
        name: "navigationbars"
    }
</script>
<script>
    export default {
        methods: {
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    }
</script>
<style scoped>
    body{
        margin: 0;
        padding: 0;
    }
  .block{
      padding-top: 10px;
      border: solid 1px red;

  }
  .el-carousel__item h3 {
      color: #475669;
      font-size: 14px;
      opacity: 0.75;
      line-height: 150px;
      margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
      background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
      background-color: #d3dce6;
  }

#zhongjian{
    width: 100%;
    border: solid 1px yellow;
}
    #zuo{
        float: left;
        display: flex;
    }
    #lunbo{
        display: -moz-flex;
    }
</style>