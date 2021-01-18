<template>
    <section>
        <div class="card">
            <el-card shadow="never">
                总销售额
                <div><span>{{total}}</span>￥</div>
            </el-card>
            <el-card shadow="never">
                支付笔数
                <div><span>{{count}}</span>笔</div>
            </el-card>

            <div class="income-type">
                <span v-if="type==null">暂无收入</span>
                <span v-else>收入最高书籍类型是 {{type.name}} 共收入<i>{{type.income}}</i> 元，共有 {{type.count}} 笔交易</span>
            </div>
        </div>

    </section>
</template>

<script>
    export default {
        data() {
            return {
                type: null,
                total: 0,
                count: 0,
                day: 0,
                m: ''
            }
        },
        methods: {
            getOrderTotalSales() {
                // 参数 day 不为 undefined
                this.day = this.$route.query.day
                if (this.day != undefined) {
                    this.axios({
                        url: '/api/order/daily',
                        params: {day: this.day}
                    }).then(resp => {
                        if (resp.data.code === 200) {
                            this.total = resp.data.data.total
                            this.count = resp.data.data.count
                            //查询收入金额最高的书籍类型
                            this.axios({
                                url: '/api/order/income?day=' + this.day
                            }).then(resp => {
                                if (resp.data.code === 200) {
                                    this.type = resp.data.data
                                } else {
                                    console.log(resp.data.data)
                                }
                            })
                        }

                    })
                }
                // month 不为 undefined
                this.m = this.$route.query.m
                if (this.m != undefined) {
                    this.type = null
                    this.axios({
                        url: '/api/order/month',
                        params: {m: this.m}
                    }).then(resp => {
                        if (resp.data.code === 200) {
                            this.total = resp.data.data.total
                            this.count = resp.data.data.count
                            //查询收入金额最高的书籍类型
                            this.axios({
                                url: '/api/order/income?m=' + this.m
                            }).then(resp => {
                                if (resp.data.code === 200) {
                                    this.type = resp.data.data
                                } else {
                                    console.log(resp.data.message)
                                }
                            })
                        }
                    })
                }

            }
        },

        // 这个方法不用调用this,因为此时机组件还没生成,所以无this
        // 要调用刷新数据方法时,需要写在next回调里,
        // next是在组件生成后会调用
        beforeRouteEnter(to, from, next) {
            next(vm => vm.getOrderTotalSales())
        },
        // 这个方法是路由不变,只变参数时执行
        beforeRouteUpdate(to, from, next) {
            next();
            this.getOrderTotalSales();
        }
    }
</script>

<style scoped>
    .card {
        display: flex;
        margin-top: 10px;

    }

    .card .el-card {
        width: 280px;
        margin-left: 10px;
    }

    .calendar {
        height: 100px;
    }

    .card .income-type {
        margin-left: 50px;
        display: flex;
        align-items: center;
    }

    .income-type span {
        font-size: 14px;
    }

    .income-type i {
        color: red;
        font-size: 14px;
    }
</style>