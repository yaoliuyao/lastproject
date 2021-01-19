<template>
    <div>
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>订单管理</el-breadcrumb-item>
            <el-breadcrumb-item>订单汇总</el-breadcrumb-item>
        </el-breadcrumb>

        <div class="total-card">
            <el-card>

                <div class="card">
                    <div class="total">总数据：</div>
                    <el-card shadow="never">
                        总销售额
                        <div><span>100</span>￥</div>
                    </el-card>
                    <el-card shadow="never">
                        支付笔数
                        <div><span>100</span>笔</div>
                    </el-card>
                </div>
                <h3>运营分析</h3>
                <el-menu router :default-active="menuActive" mode="horizontal">
                    <el-menu-item index="/xxx?day=0">今日</el-menu-item>
                    <el-menu-item index="/xxx?day=7">最近七天</el-menu-item>
                    <el-menu-item index="/xxx?day=30">最近30天</el-menu-item>
                    <el-menu-item>
                        <el-date-picker
                                @change="pickerChange"
                                v-model="picker"
                                type="month"
                                placeholder="选择月"
                                value-format="timestamp">
                        </el-date-picker>
                    </el-menu-item>


                </el-menu>
                <div>
                    <router-view></router-view>
                </div>

            </el-card>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                menuActive: '/xxx?day=0',
                picker: ''
            }
        },
        methods: {
            pickerChange(picker) {
                if (picker != null) {
                    this.$router.push("/xxx?m=" + picker)
                } else {
                    this.$router.push("/xxx?day=0")
                }
            },
        },
        created() {
            this.$router.push(this.menuActive)
        }
    }
</script>

<style scoped>
    .el-menu {
        border: 0px;
    }

    .total-card {
        height: 500px;
    }
    .total-card>.el-card{
        height: 100%;
    }

    .el-card {
        margin-top: 10px;

    }

    .total {
        display: flex;
        align-items: center;
        background-color: #20A0FF;
        font-weight: bolder;
        color: #FFFFFF;
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