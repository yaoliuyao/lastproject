<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>订单管理</el-breadcrumb-item>
            <el-breadcrumb-item>订单列表</el-breadcrumb-item>
        </el-breadcrumb>

        <el-card>
            <!--搜索区-->
            <el-row>
                <el-col :span="10">
                    <el-input clearable @clear="loadOrderList" placeholder="请输入内容" v-model="queryParams.query"
                              size="200"
                              class="input-with-select">
                        <template slot="prepend">
                            <el-select clearable @clear="loadOrderList" @change="orderStatusChang"
                                       v-model="queryParams.status"
                                       placeholder="订单状态">
                                <el-option label="已取消" value="0"></el-option>
                                <el-option label="待发货" value="1"></el-option>
                                <el-option label="待收货" value="2"></el-option>
                                <el-option label="已完成" value="3"></el-option>

                            </el-select>
                        </template>
                        <el-button @click="loadOrderList" slot="append" icon="el-icon-search"></el-button>
                    </el-input>
                </el-col>
            </el-row>
            <el-table :data="orderList" border>
                <el-table-column type="index" label="#"></el-table-column>
                <el-table-column prop="orderNo" label="订单编号" width="100"></el-table-column>
                <el-table-column prop="consignee" label="收货人"></el-table-column>
                <el-table-column prop="tel" label="联系电话"></el-table-column>
                <el-table-column prop="detail_address" label="收货地址"></el-table-column>
                <el-table-column label="订单状态">
                    <template v-slot="order">
                        <el-tag type="info" v-if="order.row.order_status===0">取消付款</el-tag>
                        <el-tag v-else-if="order.row.order_status===1">待发货</el-tag>
                        <el-tag type="warning" v-else-if="order.row.order_status===2">待收货</el-tag>
                        <el-tag type="success" v-else-if="order.row.order_status===3">已完成</el-tag>
                    </template>
                </el-table-column>
                <el-table-column class-name="amount" prop="amount" label="订单金额">
                    <template v-slot="order">
                        <span>￥{{order.row.amount}}</span>
                    </template>
                </el-table-column>
                <el-table-column label="操作">
                    <template v-slot="order">
                        <div class="operation">
                            <el-button type="primary" @click="orderInfo(order.row.orderNo)" title="查看详情"
                                       icon="iconfont icon-ordersearch" circle></el-button>
                            <el-button type="danger" title="删除" icon="iconfont icon-Delete" circle></el-button>
                        </div>
                    </template>
                </el-table-column>
            </el-table>
            <!--分页-->
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="5"
                    :page-sizes="[5, 7, 10, ]"
                    :page-size="100"
                    layout="total, sizes, prev, pager, next"
                    :total="total">
            </el-pagination>
        </el-card>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                queryParams: {
                    query: '',
                    status: '',
                    pagenum: 1,
                    pagesize: 5,
                },
                orderList: [],
                total: 0,
            }
        },
        methods: {
            //加载订单列表
            loadOrderList() {
                this.$axios({
                    url: '/api/order/list',
                    params: this.queryParams,
                }).then(resp => {

                    console.log("1", resp.data.data.concat());
                    this.orderList = resp.data.data;
                    console.log("2", this.orderList)
                    this.total = resp.data.page.totalpage;
                });
            },
            //查看订单详情
            orderInfo(id) {
                console.log(id)
                this.$router.push("/home/order/info?id=" + id)
            },
            //订单状态改变时
            orderStatusChang(status) {
                this.queryParams.status = status;
                this.loadOrderList();
            },
            //每页显示多少条
            handleSizeChange(pagesize) {
                console.log(pagesize)
            },
            //页码改变时
            handleCurrentChange(pagenum) {
                console.log(pagenum)
            }

        },
        created() {
            this.loadOrderList();
        }
    }
</script>

<style scoped>
    .el-card {
        margin-top: 10px;
    }

    .el-table {
        margin-top: 10px;
    }

    .el-select {
        width: 100px;
    }

    .el-pagination {
        margin-top: 10px;
    }

    .amount span {
        color: red;
    }

</style>