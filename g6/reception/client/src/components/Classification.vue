<template>
    <div>

        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect1">
            <el-menu-item index="1" @click="$router.push('/')">首页</el-menu-item>
            <el-menu-item index="2">分类</el-menu-item>
            <el-menu-item index="3">排行</el-menu-item>
            <el-menu-item index="4">企业服务</el-menu-item>
            <el-menu-item index="5">征文大赛</el-menu-item>
            <el-menu-item index="6">下载</el-menu-item>
            <div>
                <div class="main2">
                    <el-input v-model="input" placeholder="请输入内容"></el-input>
                    <el-button type="primary" @click="$router.push('/search/' + input)">搜索</el-button>
                    <div class="login">
                        <el-button type="primary">登录</el-button>
                    </div>
                </div>
            </div>
        </el-menu>
        <div class="classification">
            <ul>频道
                <li v-for="c in classification" :key="c.classificationNo" @click="bt(c.classificationNo)">{{c.name}}</li>
            </ul>
            <ul>类型
                <li v-for="b in booktype" :key="b.booktypeNo" @click="selectbyname(b.name)">{{b.name}}</li>
            </ul>
        </div>

        <div  v-for="b in book" :key="b.bookNo" class="books" id="nav">
            <h1>图书名称：{{b.bookName}}</h1>
            <h1>作者：{{b.author}}</h1>
            <p><img :src="'/api/' + b.cover" class="cimgs" @click="$router.push('/shop/' + b.productNo)"></p>
            <p>图书简介：{{b.content}}</p>


        </div>
    </div>
</template>

<script>
    import axios from "axios";
    export default {
        name: "classification",
        data(){
            return{
                activeIndex: "",
                input: "",
                booktype: [],
                book:[],
                classification: [],
                handleSelect1: ""
            }
        },
        created() {
            axios.get("/api/SelectAllClassificationServlet").then(e =>{
                this.classification = e.data;
            });
            axios.get("/api/SelectByClassificationNoTypeServlet?classificationNo=" + this.$route.params.params).then(e =>{
                this.booktype = e.data;
            });
            if (!this.$route.params.params2){
                axios.get("/api/SelectByClassificationNoServlet?classificationNo=" + this.$route.params.params).then(e =>{
                    this.book = e.data;
                });
            }
            if (this.$route.params.params2){
                axios.get("/api/SelectByNameServlet?name=" + this.$route.params.params2).then(e =>{
                    this.book = e.data;
                });
            }

        },
        methods:{
            bt(classificationNo){
                axios.get("/api/SelectByClassificationNoTypeServlet?classificationNo=" + classificationNo).then(e =>{
                    this.booktype = e.data;
                });
                axios.get("/api/SelectByClassificationNoServlet?classificationNo=" + classificationNo).then(e =>{
                    this.book = e.data;
                });
            },
            selectbyname(name){
                    axios.get("/api/SelectByNameServlet?name=" + name).then(e =>{
                        this.book = e.data;
                    });
            },
        },
    }
</script>

<style scoped>
    .classification li{
        padding-left: 50px;
        padding-right: 10px;
        display:inline;
    }
</style>