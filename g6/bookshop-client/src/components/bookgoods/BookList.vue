<template>
    <div>
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>书籍管理</el-breadcrumb-item>
            <el-breadcrumb-item>书籍列表</el-breadcrumb-item>
        </el-breadcrumb>
        <el-card>
            <!-- 搜索框 -->
            <el-row :gutter="20">
                <el-col :span="8">
                    <el-input placeholder="名称/类型" clearable v-model="queryParams.query" @clear="loadBookList">
                        <el-button slot="append" icon="el-icon-search" @click="loadBookList"></el-button>
                    </el-input>
                </el-col>
                <el-col :span="4">
                    <el-button type="primary" @click="$router.push('/home/add')">添加书籍</el-button>
                </el-col>
            </el-row>
            <!--书籍列表-->
            <el-table :data="bookList" border>
                <el-table-column type="index" label="#"></el-table-column>
                <el-table-column label="缩略图">
                    <template v-slot="list">
                        <img :src="'/image'+list.row.cover">
                    </template>
                </el-table-column>
                <el-table-column label="书籍名称" prop="bookName">
                </el-table-column>
                <el-table-column label="类型" prop="name">
                </el-table-column>
                <el-table-column label="单价">
                    <template v-slot="list">
                        <span>￥{{showPrice(list.row.price)}}</span>
                    </template>
                </el-table-column>
                <el-table-column label="销售数量" prop="buyCount">
                </el-table-column>
                <!--                <el-table-column label="时间" >-->
                <!--                    <template v-slot="book">-->
                <!--                        {{book.row.createTime|fmdate}}-->
                <!--                    </template>-->
                <!--                </el-table-column>-->
                <el-table-column label="库存" prop="stock">
                </el-table-column>
                <el-table-column label="是否上架">
                    <template v-slot="book">
                        <el-switch
                                :value="book.row.state===1?true:false"
                                active-color="#13ce66"
                                inactive-color="#ff4949" @change="bookStateChang(book.row)">
                        </el-switch>
                    </template>
                </el-table-column>
                <el-table-column label="操作">
                    <template v-slot="book">
                        <el-button type="primary" @click="$router.push('/book/edit?id='+book.row.productNo)"
                                   size="small" title="编辑" icon="el-icon-edit"></el-button>
                        <el-button type="danger" size="small" title="删除" icon="el-icon-delete"></el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :page-sizes="[5, 7,10]"
                    :page-size="5"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="100">
            </el-pagination>
        </el-card>


    </div>
</template>


<script>
    export default {
        data() {
            return {
                bookList: [{image: require("../../assets/logo.png")}],
                queryParams: {
                    query: '',
                    pagenum: 1,
                    pagesize: 5
                },

            }
        },
        methods: {
            //加载书籍列表
            loadBookList() {
                this.$axios({
                    url: "/api/book/list",
                    params: this.queryParams
                }).then(resp => {
                    this.bookList = resp.data.data;
                    console.log(resp)
                })
            },
            //上架书籍或下架书籍
            bookStateChang(book) {
                this.$axios({
                    url: '/api/book/state',
                    params: {
                        id: book.productNo,
                        state: book.state,
                    }
                }).then(() => {
                    this.$message.info("状态更新完成")
                    this.loadBookList();
                })
            },
            showPrice(money) {
                if (!money) {//在这里进行一次传递数据判断.如果传递进来的为空值,返回其空字符串.解决其问题
                    return '';
                }
                return money.toFixed(2);
            },
            //	pageSize（每页条数） 改变时会触发
            handleSizeChange(pagesize) {
                this.queryParams.pagesize = pagesize;
                this.loadBookList();
            },
            //	currentPage(当前页) 改变时会触发
            handleCurrentChange(pagenum) {
                this.queryParams.pagenum = pagenum;
                this.loadBookList();
            },
        },
        created() {
            this.loadBookList();
        }
    }
</script>

<style scoped>
    .el-card {
        margin-top: 10px;
    }

    .el-table img {
        width: 50px;
    }

    .el-table {
        margin-top: 10px;
    }

    .el-table span {
        color: red;
    }
</style>