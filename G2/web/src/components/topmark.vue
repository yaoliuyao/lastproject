<template>
        <div id="logo">
            <el-row>
                <el-col :span="2">
                    <img src="../logtupian/lvyou0.png">
                </el-col>
                <el-col :span="19">
                    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
                        <el-menu-item index="1">首页</el-menu-item>
                        <el-menu-item index="2" >专栏</el-menu-item>
                        <el-menu-item index="4" >专栏</el-menu-item>

                        <el-col :span="7">
                            <el-input class="el-input1"></el-input>

                        </el-col>
                        <el-col :span="2" class="ioc">
                            <el-button icon="el-icon-search">老实搜索</el-button>
                        </el-col>

                    </el-menu>

                </el-col>

                    <el-col :span="3">
                        <el-menu :default-active="activeIndex"  class="rd" mode="horizontal" @select="handleSelect">
                            <el-menu-item index="1">注册</el-menu-item>
                            <el-menu-item index="2" >登录</el-menu-item>
                        </el-menu>
                    </el-col>



            </el-row>
        </div>
    </template>


<script>
    export default {
        data() {
            return {
                activeIndex2: '1',
                fits: ['fill', ],
            }
        },

        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);

            },

        }
    }
</script>
<style>
    body{
        margin: 0;
        padding: 0;
    }
    #logo {
        width: -moz-fit-content;
        border: solid 1px red;

    }
    #logo img{
        display: flex;

        width: 100px;
        height: 50px;
    }
    .el-menu-demo{
        display: flex;
    }
    .rd{
        text-align: right;
    }
    .el-input1{
        padding-top: 10px;
    }
    .ioc{
        padding-top: 10px;
    }


</style>