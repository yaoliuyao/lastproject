<template>
    <div>
        <div class="menu">
            <el-menu router :default-active="activeIndex" class="el-menu-demo" mode="horizontal">
                <el-menu-item  class="logo"><img src="../assets/logo.png" width="80"></el-menu-item>
                <el-menu-item index="/index">首页</el-menu-item>
                <el-menu-item index="/classify">分类</el-menu-item>
                <el-menu-item index="3">消息中心</el-menu-item>
                <el-menu-item index="4">订单管理</el-menu-item>
            </el-menu>
            <el-menu router :default-active="activeIndex" class="el-menu-demo right-menu" mode="horizontal">
                <el-menu-item>
                    <el-input v-model="query"></el-input>
                </el-menu-item>
                <el-menu-item index="/login">登录</el-menu-item>
            </el-menu>
        </div>


        <el-container>
            <el-main>
                <router-view>
                </router-view>
            </el-main>
            <el-footer>
                <div class="footer">
                    <h5>万国书店</h5>
                    <p>版权所有 163 班 第六小组</p>
                </div>
            </el-footer>
        </el-container>

    </div>
</template>

<script>

    export default {
        data() {
            return {
                query: '',
                activeIndex: '/index',
            }
        },
        methods: {
            xxx() {
                this.activeIndex = '/index'
            }
        }
    }
</script>


<style scoped>
    .logo {
        margin-left: 50px;

    }

    .menu {
        width: 100%;
        /*border-bottom: solid 1px #e6e6e6;*/
        display: flex;
        justify-content: space-around;
    }

    .menu .right-menu {
        display: flex;
        justify-content: flex-end;
    }

    ul {
        width: 100%;
    }

    /*底部样式*/
    .footer {
        background-color: #999999;
    }

    .footer h5 {
        color: white;
        text-align: center;
    }

    .footer p {
        text-align: center;
    }

    /** {*/
    /*    margin: 0px;*/
    /*    padding: 0px;*/
    /*}*/
</style>