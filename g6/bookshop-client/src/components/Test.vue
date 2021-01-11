<template>
    <section>
        <div class="card">
            <el-card shadow="never">
                总销售额
                <div><span>{{total}}</span>￥</div>
            </el-card>
            <el-card shadow="never">
                支付笔数
                <div><span>100</span>笔</div>
            </el-card>
        </div>

    </section>
</template>

<script>
    export default {
        data() {
            return {
                total: 0,
                count: 0,
                day: ''
            }
        },
        methods: {
            getOrderDaily() {
                this.day = this.$route.query.day
                this.axios({
                    url: '/api/order/daily',
                    params: {day: this.day}
                }).then(resp => {
                    console.log(resp)
                    this.total = resp.data.data.total
                    this.count = resp.data.data.count
                })
            }
        },
        created() {
            // this.day = this.$route.query["day"];
            // if (this.day != "") {
            //     this.getOrderDaily();
            // }

        },
        // 这个方法不用调用this,因为此时机组件还没生成,所以无this
        // 要调用刷新数据方法时,需要写在next回调里,
        // next是在组件生成后会调用
        beforeRouteEnter(to, from, next) {

            next(vm => vm.getOrderDaily())
        },
        // 这个方法是路由不变,只变参数时执行
        beforeRouteUpdate(to, from, next) {
            this.day = this.$route.query["day"];
            console.log("前面 " + this.day)
            next();
            this.getOrderDaily();
            console.log("后面 ", this.day)
        }
    }
</script>

<style scoped>
    .card {
        display: flex;

    }

    .card .el-card {
        width: 280px;
        margin-left: 10px;
    }

    .calendar {
        height: 100px;
    }
</style>