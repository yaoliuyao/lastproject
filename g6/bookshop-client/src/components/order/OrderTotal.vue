<template>
    <div>
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>订单管理</el-breadcrumb-item>
            <el-breadcrumb-item>订单汇总</el-breadcrumb-item>
        </el-breadcrumb>


        <el-card>

            <div class="card">

                <el-card shadow="never">
                    总销售额
                    <div><span>100</span>￥</div>
                </el-card>
                <el-card shadow="never">
                    支付笔数
                    <div><span>100</span>笔</div>
                </el-card>
            </div>
            <h3>订单分析</h3>
            <el-menu router default-active="1" mode="horizontal">
                <el-menu-item index="/xxx?day=0">今日</el-menu-item>
                <el-menu-item index="/xxx?day=7">最近七天</el-menu-item>
                <el-menu-item index="/xxx?day=30">最近30天</el-menu-item>
                <el-menu-item>
                    <el-date-picker
                            @change="pickerChange"
                            v-model="picker"
                            type="month"
                            placeholder="选择月">
                    </el-date-picker>
                </el-menu-item>


            </el-menu>
            <div>
                <router-view></router-view>
            </div>

        </el-card>

    </div>
</template>

<script>
    export default {
        data() {
            return {
                menuActive: '1',
                picker: ''
            }
        },
        methods: {
            pickerChange(picker) {
                console.log(Number.parseInt(picker.getMonth()) + 1)
                this.$router.push("/xxx?m=" + (Number.parseInt(picker.getMonth()) + 1))
            }
        }

    }
</script>

<style scoped>
    .el-menu {
        border: 0px;
    }

    .el-card {
        margin-top: 10px;
    }

    .card {
        display: flex;
    }

    .card .el-card {
        margin-left: 15px;
        width: 300px;
    }

    .card .el-card span {
        font-size: 24px;
        font-weight: bold;
    }
</style>