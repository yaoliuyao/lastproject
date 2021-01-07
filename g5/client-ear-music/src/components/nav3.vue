<template>
    <section class="ear-nav">
        <div class="zc">
            <el-row style="height:55px;">
                <el-col :span="4">
                    <div class="grid-content bg-purple">
                        <div><img src="../img/757997_multimedia_512x512(2).png" alt="" style="width:200px;height:55px;padding-left:60px;"></div>
                    </div>
                </el-col>
                <el-col :span="2">
                    <div class="grid-content bg-purple-light">
                        <div class="zz">
                            <span style="">发现</span>
                        </div>
                    </div>
                </el-col>
                <el-col :span="2"><div class="grid-content bg-purple-light">
                    <div class="zz">我的音乐</div>
                </div></el-col>
                <el-col :span="2"><div class="grid-content bg-purple-light">
                    <div class="zz">音乐人</div>
                </div></el-col>
                <el-col :span="2"><div class="grid-content bg-purple-light">
                    <div class="zz">客户端下载</div>
                </div></el-col>
                <el-col :span="2"><div class="grid-content bg-purple-light">
                    <div class="zz">关于我们</div>
                </div></el-col>
                <el-col :span="6" :offset="2">
                    <div class="grid-content bg-purple-light">
                        <el-input
                                placeholder="请输入内容"
                                v-model="input"
                                clearable class="nav-input">
                        </el-input>
                        <el-button icon="el-icon-search" circle style="margin-left: 20px;"></el-button>
                    </div>
                </el-col>
                <el-col :span="2"><div class="grid-content bg-purple-light" style="">
                    <div class="nav-login">
                        <el-button round @click="dialogFormVisible = true">登录</el-button>
                        <el-button round @click="logon = true">注册</el-button>
                    </div>
                </div></el-col>
            </el-row>
            <hr>
        </div>
        <el-dialog title="登录" :visible.sync="dialogFormVisible" center>
            <el-form :model="ruleForm" label-width="100px" class="demo-ruleForm">
                <el-form-item label="账号：">
                    <el-input v-model="ruleForm.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="密码：">
                    <el-input type="password" v-model="ruleForm.region" auto-complete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <le-button @click="dialogFormVisible = false">取 消</le-button>
                <el-button type="primary" @click="dialogFormVisible = false">登 录</el-button>
            </div>
        </el-dialog>
        <el-dialog title="注册" :visible.sync="logon">
            <el-form :model="main" label-width="100px" class="demo-ruleForm">
                <el-form-item label="账号：">
                    <el-input v-model="main.names" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="密码：">
                    <el-input type="password" v-model="main.regions" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="重复密码：">
                    <el-input type="password" v-model="main.regionss" auto-complete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <le-button @click="logon = false">取 消</le-button>
                <el-button type="primary" @click="logon = false">登 录</el-button>
            </div>
        </el-dialog>
    </section>
</template>

<script>
    export default {
        name: "nav",
        data() {
            return {
                dialogFormVisible: false,
                logon:false,
                ruleForm:{
                    name:'',
                    region:''
                },
                main:{
                    names:'',
                    regions:'',
                    regionss:'',
                }
            }
        }
    }
</script>

<style scoped>
    .zz{
        height:40px;
        text-align: center;
        display: block;
        padding-top:20px;
        font-size:15px;
        font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
        font-weight: bold;

    }
    .zc{
        left: 0;  position: fixed;  top: 0;  width: 100%;  z-index: 1000;
        background: #F2F6FC;
    }
    .zz:hover{
        background:#D9ECFF;
        font-size: 17px;
    }
    .textlogin{
        font-size: 22px;
        font-weight: bold;
        /* margin-left: 280px; */
        margin-left: 45%;
        line-height: 0px;
    }
    .but{
        margin-left: 42%;
        margin-top: 40px;
    }

    .nav-input{
        width: 200px;
        padding-top: 10px;
    }
    .nav-login{
        padding-top:20px;
    }
</style>