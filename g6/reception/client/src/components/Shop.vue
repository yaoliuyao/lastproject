<template>
        <div>
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
                            <el-button type="primary" @click="$router.push('/search/' + input)">搜索</el-button>
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
                <el-container>
                    <img :src="imgurl" class="cimg" >
                    <div class="commoditie">
                        <el-header>{{commoditie.bookName}}</el-header>
                        <el-header>作者：{{commoditie.author}}</el-header>
                        <p class="price">价格：{{commoditie.price}}</p>
                        <div>
                            <el-button type="button" @click="cart = true">加入购物车</el-button>

                            <el-dialog title="外层 Dialog" :visible.sync="cart">

                                <el-form :model="form4">
                                    <el-form-item label="商品名称" :label-width="formLabelWidth">
                                        <el-input v-model="form4.bookName" autocomplete="off"></el-input>
                                    </el-form-item>
                                    <el-form-item label="用户名称" :label-width="formLabelWidth">
                                        <el-input v-model="form4.name" autocomplete="off"></el-input>
                                    </el-form-item>
                                    <el-form-item label="购买数量" :label-width="formLabelWidth">
                                        <el-input v-model="form4.booknum" autocomplete="off"></el-input>
                                    </el-form-item>
                                    <el-form-item label="价格" :label-width="formLabelWidth">
                                        {{form4.cprice}}
                                    </el-form-item>
                                    <el-form-item label="总价格" :label-width="formLabelWidth">
                                       {{sumprice}}
                                    </el-form-item>
                                </el-form>
                                <div slot="footer" class="dialog-footer">
                                    <el-button @click="cart = false">取 消</el-button>
                                    <el-button type="primary" @click="cart2(cart = false)">确 定</el-button>
                                </div>

                            </el-dialog>
                        </div>
                        <div>
                            <el-button type="text" @click="shop = true">购买</el-button>
                            <el-dialog title="购买" :visible.sync="shop">
                                <el-form :model="form5">
                                    <el-form-item label="收货人" :label-width="formLabelWidth">
                                        <el-input v-model="form5.consignee" autocomplete="off"></el-input>
                                    </el-form-item>
                                    <el-form-item label="收货详细地址" :label-width="formLabelWidth">
                                        <el-input v-model="form5.detail_address" autocomplete="off"></el-input>
                                    </el-form-item>
                                    <el-form-item label="手机号" :label-width="formLabelWidth">
                                        <el-input v-model="form5.tel" autocomplete="off"></el-input>
                                    </el-form-item>
                                </el-form>
                                <el-dialog
                                        width="35%"
                                        title="内层 Dialog"
                                        :visible.sync="payment"
                                        append-to-body>
                                    <el-form :model="form6">
                                        <el-form-item label="用户名" :label-width="formLabelWidth">
                                            <el-input v-model="form6.name" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="书名" :label-width="formLabelWidth">
                                            <el-input v-model="form6.bookName" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="收货地址" :label-width="formLabelWidth">
                                            <el-input v-model="form5.detail_address" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="数量" :label-width="formLabelWidth">
                                            <el-input v-model="form6.productnum" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="单价" :label-width="formLabelWidth">
                                            {{form6.amount}}
                                        </el-form-item>
                                        <el-form-item label="总价" :label-width="formLabelWidth">
                                            {{sumprice2}}
                                        </el-form-item>
                                        <el-form-item label="备注" :label-width="formLabelWidth">
                                            <el-input v-model="form6.remarks" autocomplete="off"></el-input>
                                        </el-form-item>
                                    </el-form>
                                    <div slot="footer" class="dialog-footer">
                                        <el-button @click="payment = false">取 消</el-button>
                                        <el-button type="primary" @click="payment2(payment = false)">确 定</el-button>
                                    </div>
                                </el-dialog>
                                <div slot="footer" class="dialog-footer">
                                    <el-button @click="shop = false">取 消</el-button>
                                    <el-button type="primary" @click="shop2(shop = false , payment = true)">确 定</el-button>
                                </div>

                            </el-dialog>
                        </div>
                        <p class="content">{{commoditie.content}}</p>
                    </div>
                </el-container>
            </div>
        <div>
            <el-container>
                 <el-main>书圈</el-main>
             </el-container>
        </div>
            <div class="block">
                <el-pagination
                        layout="prev, pager, next"
                        :total="1000">
                </el-pagination>
            </div>
    </div>
</template>

<script>
    import axios from "axios";
    export default {
        name: "shop",
        data() {
            return {
                user:[],
                user2:[],
                order:[],
                order2:[],
                address:[],
                user3:{
                    userno: 0,
                    username: "",
                    userpass: "",
                    phone: "",
                    state: 0,
                    createtime: ""
                },
                cart: false,
                payment: false,
                input: "",
                commoditie:[],
                imgurl: "",
                formLabelWidth: '150px',
                dialogTableVisible: false,
                login: false,
                shop: false,
                forgetpassword: false,
                registeraccount: false,
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
                form4: {
                    name: "",
                    productNo: 0,
                    userNo: 0,
                    booknum: 1,
                    cprice: 0,
                    bookName: "",
                    sumprice: 0
                },
                form5:{
                    consignee: '',
                    detail_address: '',
                    tel: ''
                },
                form6:{
                    userNo: 0,
                    bookName: '',
                    name: '',
                    productNo: 0,
                    addressNo: 0,
                    payment_number: 0,
                    productnum: 0,
                    amount: 0,
                    remarks: " ",
                    wechat: 0,
                    alipay: 1
                },
            }
        },
        mounted() {
            axios.get("/api/SelectByProductNoCommoditieServlet?productNo=" + this.$route.params.productNo).then(e =>{
                this.commoditie = e.data;
                this.imgurl = "/api/" + e.data.cover;
                this.form6.amount = e.data.price
                this.form6.productnum = this.form4.booknum
                this.form6.bookName = e.data.bookName;
                this.form6.productNo = this.$route.params.productNo;
                this.form4.cprice = e.data.price;
                this.form4.sumprice = this.form4.cprice;
                this.form4.productNo = e.data.productNo;
                this.form4.bookName = e.data.bookName;

            });
            if (this.user){
                document.getElementById("login").style.visibility="hidden";
            }
        },
        methods:{
            cart2(cart = false){
                axios.post("/api/AddCartServlet?productNo=" + this.form4.productNo + "&userNo=" + this.form4.userNo + "&booknum=" + this.form4.booknum + "&cprice=" + this.sumprice).then(e =>{
                    alert("添加成功");
              });
            },
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
            shop2(){
                axios.post("/api/AddAddressServlet?userno=" + this.form4.userNo + "&consignee=" + this.form5.consignee+"&detail_address=" + this.form5.detail_address + "&tel=" + this.form5.tel)
            },
            payment2(){
                axios.post("/api/AddOrderServlet?userNo=" + this.form6.userNo + "&productNo=" + this.form6.productNo + "&addressNo=" + this.form6.addressNo + "&payment_number=" + this.form6.payment_number + "&productnum=" + this.form6.productnum + "&amount=" + this.sumprice2 + "&remarks=" + this.form6.remarks)
            },
        },
        created() {
            this.user = JSON.parse(window.sessionStorage.getItem("user"));
            this.user3 = JSON.parse(window.sessionStorage.getItem("user"));
            this.form4.name = this.user.username;
            this.form4.userNo = this.user3.userno;
            this.form5.consignee = this.user.username;
            this.form5.tel = this.user.phone;
            this.form6.userNo = this.user3.userno;
            this.form6.name = this.user.username;
            axios.get("/api/SelectByUserNoAddressServlet?userNo=" + this.user.userno).then(e =>{
                this.order = e.data;

            });
            axios.get("/api/SelectByUserNoorderServlet?userNo=" + this.user.userno).then(e =>{
                this.address = e.data;
            });
            axios.get("/api/SelectByUserNoAddressServlet?userNo=" + this.user.userno).then(e =>{

                this.order2 = e.data;
                console.log(this.order2)
                this.form5.detail_address = this.order2[0].detail_address;
                this.form6.addressNo = this.order2[0].addressNo
            });
        },
        computed:{
            sumprice(){
                return this.form4.booknum * this.form4.cprice
            },
            sumprice2(){
                return this.form6.productnum * this.form6.amount
            }
        }
    };
</script>
<style>
    .cimg{
        width: 250px;
        padding-top: 18px;
        padding-left: 7px;
        padding-right: 40px;
        padding-bottom: 70px;
    }
    .content{
        text-indent: 45px
    }

    .price{
        padding-left: 580px;
        padding-top: 0px;
        padding-bottom: 0px;
        font-size: 20px;
    }

    .price + .el-button{
        margin-left: 590px;
    }

    .el-input{
        width: 200px;
    }

</style>