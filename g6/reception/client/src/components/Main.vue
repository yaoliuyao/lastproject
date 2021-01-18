<template>
    <div>

        <div>
            <el-menu class="el-menu-demo" mode="horizontal">
                <el-menu-item>首页</el-menu-item>
                <el-menu-item @click="$router.push('/classification/1')">分类</el-menu-item>
                <el-menu-item>排行</el-menu-item>
                <el-menu-item>企业服务</el-menu-item>
                <el-menu-item>征文大赛</el-menu-item>
                <el-menu-item>下载</el-menu-item>
                <div>
                    <div class="main2">
                        <el-input v-model="input" placeholder="作者/书名"></el-input>
                        <el-button type="primary"  @click="$router.push('/search/' + input)">搜索</el-button>
                        <div class="login">
                            <div class="phone" v-if="this.user">
                                <span @click="$router.push('/user/' + user.phone)">{{user.phone}}</span>
                            </div>

                            <div>
                                <el-button type="text" @click="login = true" id="login">登录</el-button>

                                <el-dialog title="登录" :visible.sync="login">

                                    <el-form :model="form">
                                        <el-form-item label="手机号" :label-width="formLabelWidth">
                                            <el-input v-model="form.phone" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="密码" :label-width="formLabelWidth">
                                            <el-input v-model="form.userpass" autocomplete="off"></el-input>
                                        </el-form-item>
                                    </el-form>

                                    <el-dialog
                                            width="35%"
                                            title="忘记密码"
                                            :visible.sync="forgetpassword"
                                            append-to-body>
                                        <el-form :model="form2">
                                            <el-form-item label="手机号" :label-width="formLabelWidth">
                                                <el-input v-model="form2.phone" autocomplete="off"></el-input>
                                            </el-form-item>
                                            <el-form-item label="旧密码" :label-width="formLabelWidth">
                                                <el-input v-model="form2.userpass" autocomplete="off"></el-input>
                                            </el-form-item>
                                            <el-form-item label="新密码" :label-width="formLabelWidth">
                                                <el-input v-model="form2.newpassone" autocomplete="off"></el-input>
                                            </el-form-item>
                                            <el-form-item label="确认新密码" :label-width="formLabelWidth">
                                                <el-input v-model="form2.newpasstwo" autocomplete="off"></el-input>
                                            </el-form-item>
                                        </el-form>
                                        <div slot="footer" class="dialog-footer">
                                            <el-button @click="forgetpassword = false">取 消</el-button>
                                            <el-button type="primary" @click="forgetpassword2(forgetpassword = false)">确 定</el-button>
                                        </div>
                                    </el-dialog>

                                    <el-dialog
                                            width="35%"
                                            title="注册"
                                            :visible.sync="registeraccount"
                                            append-to-body>
                                        <el-form :model="form3">
                                            <el-form-item label="用户名" :label-width="formLabelWidth">
                                                <el-input v-model="form3.username" autocomplete="off"></el-input>
                                            </el-form-item>
                                            <el-form-item label="手机号" :label-width="formLabelWidth">
                                                <el-input v-model="form3.phone" autocomplete="off"></el-input>
                                            </el-form-item>
                                            <el-form-item label="密码" :label-width="formLabelWidth">
                                                <el-input v-model="form3.userpass" autocomplete="off"></el-input>
                                            </el-form-item>
                                        </el-form>
                                        <div slot="footer" class="dialog-footer">
                                            <el-button @click="registeraccount = false">取 消</el-button>
                                            <el-button type="primary" @click="registeraccount2(registeraccount = false)">确 定</el-button>
                                        </div>
                                    </el-dialog>

                                    <div slot="footer" class="dialog-footer">
                                        <el-button type="primary" @click="forgetpassword = true">忘记密码</el-button>
                                        <el-button type="primary" @click="registeraccount = true">注册账号</el-button>
                                        <el-button @click="login = false" id="cansoul">取 消</el-button>
                                        <el-button type="primary" @click="login2(login = false)">确 定</el-button>

                                    </div>

                                </el-dialog>
                                </div>
                            </div>
                    </div>
                </div>
            </el-menu>
        </div>
        <div>
            <BookCarousel></BookCarousel>
        <div  class="body">
             <div>
                <el-container>
                        <el-header><span @click="$router.push('/classification/1')">出版图书</span></el-header>
                    <el-header>
                        <span v-for="c in class1" :key="c.classificationNo" class="c">
                            <span @click="$router.push('/classification2/' + c.classificationNo + '/' + c.name)">{{c.name}}</span>
                        </span>
                    </el-header>
                        <el-container>
                            <el-aside width="500px" v-for="commodity in commodities" :key="commodity.productNo">
                                <p>图书名称：{{commodity.bookName}}</p>
                                <p>作者：{{commodity.author}}</p>
                                <p>封面图：</p><img :src="'/api/' + commodity.cover" class="cimgs" @click="$router.push('/shop/' + commodity.productNo)">
                                <p>图书简介：{{commodity.content}}</p>
                            </el-aside>
                            <el-container>
                                <div class="bestseller">
                                    <span class="banyan">榜单</span>
                                    <ul v-for="(bs,index) in bestseller" :key="bs.productNo" >
                                        <li @click="$router.push('/shop/' + bs.productNo)"><span>{{index+1}}</span>{{bs.bookName}}</li>
                                    </ul>
                                </div>
                            </el-container>
                        </el-container>
                    </el-container>


                 <el-container>
                     <el-header><span @click="$router.push('/classification/2')">男生频道</span></el-header>
                     <el-header>
                            <span v-for="ctwo in class2" :key="ctwo.name" class="c">
                            <span @click="$router.push('/classification2/' + ctwo.classificationNo + '/' + ctwo.name)">{{ctwo.name}}</span>
                        </span>
                     </el-header>
                     <el-container>
                         <el-aside width="500px" v-for="commodity in boycommodities" :key="commodity.productNo">
                             <p>图书名称：{{commodity.bookName}}</p>
                             <p>作者：{{commodity.author}}</p>
                             <p>封面图：</p><img :src="'/api/' + commodity.cover" class="cimgs" @click="$router.push('/shop/' + commodity.productNo)">
                             <p>图书简介：{{commodity.content}}</p>
                         </el-aside>
                         <el-container>
                             <div class="bestseller">
                                 <span class="banyan">榜单</span>
                                 <ul v-for="(btwo,index) in bestseller2" :key="btwo.productNo">
                                     <li @click="$router.push('/shop/' + btwo.productNo)"><span>{{index+1}}</span>{{btwo.bookName}}</li>
                                 </ul>
                             </div>
                         </el-container>

                     </el-container>
                 </el-container>


                 <el-container>
                     <el-header><span @click="$router.push('/classification/3')">女生频道</span></el-header>
                     <el-header>
                         <span v-for="cthree in class3" :key="cthree.classificationNo" class="c">
                              <span @click="$router.push('/classification2/' + cthree.classificationNo + '/' + cthree.name)">{{cthree.name}}</span>
                         </span>
                     </el-header>
                     <el-container>
                         <el-aside width="500px" v-for="girlcommodity in girlcommodities" :key="girlcommodity.productNo">
                             <p>图书名称：{{girlcommodity.bookName}}</p>
                             <p>作者：{{girlcommodity.author}}</p>
                             <p>封面图：</p><img :src="'/api/' + girlcommodity.cover" class="cimgs" @click="$router.push('/shop/' + girlcommodity.productNo)">
                             <p>图书简介：{{girlcommodity.content}}</p>
                         </el-aside>
                         <el-container>
                             <div class="bestseller">
                                 <span class="banyan">榜单</span>
                                 <ul v-for="(bstwo,index) in bestseller3" :key="bstwo.productNo">
                                     <li @click="$router.push('/shop/' + bstwo.productNo)"><span>{{index+1}}</span>{{bstwo.bookName}}</li>
                                 </ul>
                             </div>
                         </el-container>
                     </el-container>
                 </el-container>
                </div>
            </div>
        </div>
            <copyright></copyright>
    </div>
</template>

<script>
    import copyright from './Copyright'
    import axios from "axios";
    import BookCarousel from "../components/BookCarousel"
    export default {
        name: 'main',
        components:{
            copyright,BookCarousel
        },
        data() {
            return {
                input: "",
                restaurants: [],
                formLabelWidth: '100px',
                dialogTableVisible: false,
                login: false,
                forgetpassword: false,
                registeraccount: false,
                user: [],
                user2:[],
                phone: "",
                commodities:[],
                girlcommodities:[],
                boycommodities:[],
                bestseller:[],
                bestseller2:[],
                bestseller3:[],
                name:[],
                form: {
                    phone: "",
                    userpass: "",
                },
                form2:{
                    phone: "",
                    userpass: "",
                    newpassone: "",
                    newpasstwo: "",
                },
                form3:{
                    username: "",
                    userpass: "",
                    phone: ""
                },
                class3:
                    [
                    {
                        name: '现代言情',
                        classificationNo: 3
                    },
                    {
                         name: '古代言情',
                         classificationNo: 3
                    },
                    {
                         name: '幻想言情',
                         classificationNo: 3
                    },
                    {
                         name:'青春校园',
                         classificationNo: 3
                    }
                    ],
                class2:[
                    {
                        name:'玄幻',
                        classificationNo: 2
                    },
                    {
                        name:'奇幻',
                        classificationNo: 2
                    },
                    {
                        name:'武侠',
                        classificationNo: 2
                    },
                ],
                class1: [
                    {
                        name:'励志',
                        classificationNo: 1
                    },
                    {
                        name:'文学',
                        classificationNo: 1
                    },
                ],
            };
        },
        mounted(){
            axios.get("/api/SelectRandomCommoditieServlet").then(e =>{
                 this.commodities = e.data;
            });
            axios.get("/api/SelectGirlCommoditieServlet").then(e =>{
                 this.girlcommodities = e.data;
            });
            axios.get("/api/SelectBoyCommoditieServlet").then(e =>{
                this.boycommodities = e.data;
            });
            axios.get("/api/SelectBestsellerCommoditieServlet").then(e =>{
                this.bestseller = e.data;
            });
            axios.get("/api/SelectBestsellerCommoditie2Servlet").then(e =>{
                this.bestseller2 = e.data;
            });
            axios.get("/api/SelectBestsellerCommoditie3Servlet").then(e =>{
                this.bestseller3 = e.data;
            });
            if (this.user){
                document.getElementById("login").style.visibility="hidden";
            }
            this.user = JSON.parse(window.sessionStorage.getItem("user"));
            if (this.user){
                document.getElementById("login").style.visibility="hidden";
            }
        },
        created() {
            this.user = JSON.parse(window.sessionStorage.getItem("user"));
            this.user3 = JSON.parse(window.sessionStorage.getItem("user"));
            this.form4.userNo = this.user3.userno;
        },
        methods:{
            login2(login = false){
                axios.get("/api/SelectByPhoneUserServlet?phone=" + this.form.phone + "&userpass=" + this.form.userpass).then(e =>{
                     this.user = e.data;
                     if (this.user===null){
                         alert("账号或者密码错误");
                     }
                     else {
                         document.getElementById("login").style.visibility="hidden";
                         window.sessionStorage.setItem("user",JSON.stringify(this.user));
                     }
                });
            },
            registeraccount2(registeraccount = false){
                    axios.post("/api/AddUserServlet?username=" + this.form3.username + "&userpass=" + this.form3.userpass + "&phone=" +this.form3.phone)
            },
            forgetpassword2(forgetpassword = false){
                axios.get("/api/SelectByPhoneUserServlet?phone=" + this.form2.phone + "&userpass=" + this.form2.userpass).then(e =>{
                    this.user2 = e.data;
                    if (this.user2!==null){
                        axios.post("/api/UpdateUserpassServlet?userpass=" + this.form2.newpassone + "&phone=" + this.form2.phone)
                    }
                    else {
                        alert("错误");
                    }
                });
            },
        },
    }
</script>
<style>
    .main2 > .el-input{
        margin-left: 400px;
    }

    .el-menu{
        padding-bottom: 10px;
    }


    .el-header, .el-footer {
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        font-size: 10px;
        padding-left: 60px;
        padding-top: 0px;
        padding-right: 50px;
        /*text-align: center;*/
        /*line-height: 200px;*/
    }

    .el-main {
        background-color: #ffffff;
        color: #333;
        text-align: center;
        line-height: 160px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }

    .el-container{
        padding-left: 50px;
    }


    .cimgs{
        width: 170px;
        height: 200px;
        padding-left: 70px;
    }

    .img{
        height: 200px;
        width: 180px;
        padding-top: 70px;
    }

    a {
        text-decoration: none
    }

    .bestseller{
        width: 330px;
        height: 650px;
        background-color: #ffffff;
        margin-left: 0px;
        font-size: 20px;
    }

    .el-input{
        width: 200px;
    }

    ul{
        padding-left: 0px;

    }

    li{
        list-style-type: none;
    }

    li span{
        margin-right: 20px;
    }

    .bestseller .banyan{
        font-size: 30px;
        margin-left: 100px;
    }

    p span ,p{
        font-size: 20px;
    }

    .login{
        float: right;
    }

    .main2{
        padding-top: 10px;
    }

    .main3{
        padding-left: 150px;
    }

    .phone{
        padding: 0;
        margin: 0;
        font-family: "Helvetica Neue";
        font-size: 25px;
    }

    .body{
        background-color: #cccccc;
    }

    .c{
        padding-left: 20px;
    }
</style>
