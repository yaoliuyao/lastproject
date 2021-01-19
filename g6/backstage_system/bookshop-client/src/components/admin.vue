<template>
    <div>
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>设置</el-breadcrumb-item>
            <el-breadcrumb-item>管理员设置</el-breadcrumb-item>
        </el-breadcrumb>
        <el-card>
            <el-alert
                    title="管理员信息"
                    type="info"
                    :closable="false"
                    center>
            </el-alert>
            <div class="card">
                <table>
                    <tr>
                        <td align="right">管理员ID：</td>
                        <td>{{admin.uid}}</td>
                    </tr>
                    <tr>
                        <td align="right">管理员帐号：</td>
                        <td>{{admin.user}}</td>
                    </tr>
                    <tr>
                        <td align="right">注册时间：</td>
                        <td>{{admin.createTime|fmdate}}</td>
                    </tr>
                </table>
            </div>
        </el-card>
    </div>

</template>

<script>
    export default {
        data() {
            return {
                admin: JSON.parse(window.sessionStorage.getItem("user"))

            }
        }
    }
</script>

<style scoped>
    .el-card {
        margin-top: 10px;
        height: 500px;
    }


    .card {
        margin: 0 auto;
        margin-top: 100px;
        width: 320px;
    }
    table tr td{
        font-size: 18px;
        color: #999999;
    }

</style>