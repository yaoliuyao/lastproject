<template>
    <div>

        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>订单管理</el-breadcrumb-item>
            <el-breadcrumb-item>订单列表</el-breadcrumb-item>
            <el-breadcrumb-item>订单详情</el-breadcrumb-item>
        </el-breadcrumb>
        <!--卡片-->
        <el-card>
            <el-alert
                    :closable="false"
                    title="订单详情"
                    type="info"
                    center
                    show-icon>
            </el-alert>

            <table class="address" width="100%">
                <tr height="50px">
                    <td>收货人：<span>{{orderInfo.consignee}}</span></td>
                    <td>联系电话：<span>{{orderInfo.tel}}</span></td>
                    <td>收货地址：<span>{{orderInfo.detail_address}}</span></td>
                    <td>订单时间：<span>{{orderInfo.createTime|fmdate}}</span></td>
                </tr>
                <tr height="40px">
                    <td class="status">
                        订单状态：
                        <span v-if="orderInfo.order_status===1">已付款，待发货</span>
                        <span v-else-if="orderInfo.order_status===2">已发货，待收货</span>
                        <span v-else-if="orderInfo.order_status===3">订单已完成</span>
                        <span v-else-if="orderInfo.order_status===0">订单已取消</span>
                    </td>
                    <td class="remarks" colspan="3">订单备注：<span>{{orderInfo.remarks===0?"NULL":orderInfo.remarks}}</span>
                    </td>
                </tr>
            </table>
            <!--书籍信息-->
            <table class="book" width="100%">
                <tr>
                    <td align="center" class="cover"><img :src="'/image'+orderInfo.cover"></td>
                    <td>名称：<span>{{orderInfo.bookName}}</span></td>
                    <td>编号：<span>{{orderInfo.orderNo}}</span></td>
                    <td class="amount">价格：<span>￥{{orderInfo.amount}}</span></td>
                </tr>
            </table>
            <div class="aoperation">
                <el-row class="operation" :gutter="2">
                    <el-col :span="2">
                        <span>管理员操作：</span>
                    </el-col>
                    <el-col :span="7">
                        <el-input @keyup.enter.native="xxx" v-model="form.xxx" placeholder="备注"></el-input>
                    </el-col>
                    <el-col :span="12">
                        <div>
                            <el-button size="small " type="primary" @click="printBtn">打印</el-button>
                            <el-button size="small" type="primary" @click="dialogFormVisible=true">发货</el-button>
                            <el-button size="small" type="primary">确认收货</el-button>
                        </div>
                    </el-col>
                </el-row>
            </div>
        </el-card>
        <el-dialog width="30%" title="编辑" :visible.sync="dialogFormVisible">
            <el-form :model="form" label-width="80px">
                <el-form-item size="mini" label="订单编号">
                    <el-input v-model="orderInfo.orderNo" disabled></el-input>
                </el-form-item>
                <el-form-item label="订单状态">
                    <el-select v-model="form.region" placeholder="请选择">
                        <el-option label="待发货" value="shanghai"></el-option>
                        <el-option label="已发货" value="beijing"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
            </div>
        </el-dialog>

    </div>
</template>


<script>
    export default {
        data() {
            return {

                tableData: [],
                orderInfo: {},
                dialogFormVisible: false,
                form: {},
            }
        },
        methods: {

            loadOrderInfo(id) {
                this.$axios({
                    url: '/api/order/info',
                    params: {orderNo: id}
                }).then(resp => {
                    if (resp.data.code === 200) {
                        this.orderInfo = resp.data.data;
                        this.tableData.push(resp.data.data)

                    }

                    console.log(resp)
                    console.log(this.orderInfo)
                })
            },
            xxx() {
                alert(1)
            },
            printBtn() {
                window.print();
                return
            }
        },
        created() {
            const id = this.$route.query["id"];
            this.loadOrderInfo(id)
        }
    }
</script>

<style scoped>

    .el-card {
        margin-top: 10px;
    }

    table {
        margin-top: 10px;
        font-size: 14px;
        border-collapse: collapse;
    }

    tr, td {

        padding: 10px;
    }

    .address td {
        /*box-shadow: 0 0 1px #888888;*/
        border: solid 1px #e6e6e6;
        width: 350px;
    }

    table .status span {
        color: #55a532;
    }

    table .remarks span {
        padding: 0px 5px;
        background-color: #FFFF00;
        color: red;
    }

    .book td {
        border: solid 1px #e6e6e6;
        /*box-shadow: 0 0 1px #888888;*/
    }

    .book .cover {
        width: 180px;
    }

    .cover img {
        width: 50px;
    }

    .book .amount span {
        color: red;
    }

    .operation {
        margin-top: 5px;
        display: flex;
        align-items: center;
    }

    .operation span {
        font-size: 14px;
    }

</style>