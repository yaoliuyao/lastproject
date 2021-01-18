<template>
    <div>
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>书籍管理</el-breadcrumb-item>
            <el-breadcrumb-item>书籍分类</el-breadcrumb-item>
        </el-breadcrumb>
        <el-card>
            <!-- 搜索框 -->
            <el-row :gutter="20">
                <el-col :span="8">
                    <el-input placeholder="地区/类型" clearable v-model="queryParams.query" @clear="loadClassify">
                        <el-button slot="append" icon="el-icon-search" @click="loadClassify"></el-button>
                    </el-input>
                </el-col>
                <el-col :span="4">
                    <el-button type="primary" @click="dialogVisible=true">添加分类</el-button>
                </el-col>
            </el-row>
            <el-table :data="classifyList" border>
                <el-table-column type="index" label="#"></el-table-column>
                <el-table-column prop="region" label="地区"></el-table-column>
                <el-table-column prop="name" label="类型"></el-table-column>
                <el-table-column label="操作">
                    <template>
                        <el-button type="primary" icon="el-icon-edit">编辑</el-button>
                        <el-button type="danger" icon="el-icon-delete">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <!--分页-->
            <el-pagination
                    background
                    layout="prev, pager, next"
                    :total="totalpage" @current-change="changePagenum">
            </el-pagination>
        </el-card>


        <!--分类对话框-->
        <el-dialog title="添加书籍类型" :visible.sync="dialogVisible" width="40%" @close="classifyDialogClose">
            <el-form :model="addClassifyForm" :rules="classifyRules" ref="classifyRef" label-width="100px"
                     class="demo-ruleForm">
                <el-form-item label="书籍地区" prop="region">
                    <el-input v-model="addClassifyForm.region"></el-input>
                </el-form-item>

                <el-form-item label="书籍类型" prop="name">
                    <el-input v-model="addClassifyForm.name" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {},
                //查询参数
                queryParams: {
                    query: "",
                    pagenum: 1,
                    pagesize: 5,
                },
                //总条数
                totalpage: 0,
                classifyList: [],
                //是否显示添加对话
                dialogVisible: false,
                //表单
                addClassifyForm: {},
                //校验ClassifyRules
                classifyRules: {
                    region: [
                        {required: true, message: '请输入书籍地区', trigger: 'blur'},
                    ],
                    name: [{required: true, message: "请输入书籍类型", trigger: 'blur'}]
                }

            }
        },
        methods: {
            //加载书籍类型
            loadClassify() {
                this.$axios({
                    url: "/api/book/classify/list",
                    params: this.queryParams
                }).then(resp => {
                    if (resp.data.code == 200) {
                        this.classifyList = resp.data.data;
                        this.totalpage = resp.data.page.totalpage;
                    }
                    console.log(resp)
                })
            },
            //页码发生变化时
            changePagenum(num) {
                this.queryParams.pagenum = num;
                console.log(num)
                this.loadClassify();
            },
            //添加对话框关闭时重置表单
            classifyDialogClose() {
                this.$refs.classifyRef.resetFields();
            }
        },
        created() {
            this.loadClassify();
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
</style>