<template>
    <div>
        <el-menu class="el-menu-demo" mode="horizontal">
            <el-menu-item @click="$router.push('/')">首页</el-menu-item>
            <el-menu-item @click="$router.push('/classification/1')">分类</el-menu-item>
            <el-menu-item>排行</el-menu-item>
            <el-menu-item>企业服务</el-menu-item>
            <el-menu-item>征文大赛</el-menu-item>
            <el-menu-item>下载</el-menu-item>
            <div>
                <div class="main2">
                    <el-input v-model="input" placeholder="请输入内容"></el-input>
                    <el-button type="primary" @click="search(input)">搜索</el-button>
                    <div class="login">
                        <el-button type="primary">登录</el-button>
                    </div>
                </div>
            </div>
        </el-menu>
        <div v-for="c in commoditie" :key="c">
            <p>图书名称：{{c.bookName}}</p>
            <p>作者：{{c.author}}</p>
            <p>封面图：</p><img :src="'/api/' + c.cover"  @click="$router.push('/shop/' + c.productNo)">
            <p>图书简介：{{c.content}}</p>
        </div>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: 'search',
        data(){
            return{
                name: "search",
                input: "",
                commoditie:[],
            }
        },
        created() {
                axios.get("/api/SelectByBookNameBookProductServlet",{
                    params:{
                        bookName: this.$route.params.params,
                          author: this.$route.params.params
                    }
                }).then(e =>{
                    this.commoditie = e.data;
                });
        },
        methods:{
            search(){
                axios.get("/api/SelectByBookNameBookProductServlet",{
                    params:{
                        bookName: this.input,
                          author: this.input
                    }
                }).then(e =>{
                    this.commoditie = e.data;
                });
            }
        }
    }
</script>

<style scoped>

</style>