<template>
    <div>
        <!--  面包屑导航-->
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/welcome' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>用户管理</el-breadcrumb-item>
            <el-breadcrumb-item>用户列表</el-breadcrumb-item>
        </el-breadcrumb>
        <!--  卡片-->
        <el-card class="box-card">
            <el-row>
                <!--  搜索框-->
                <el-col :span="10">
                    <el-input @clear="loadUsers" v-model="queryUserParams.userInput" placeholder="搜索用户"
                              class="input-with-select"
                              clearable>
                        <el-button slot="append" icon="el-icon-search" @click="loadUsers"></el-button>
                    </el-input>
                </el-col>
            </el-row>

            <el-table border :data="users">
                <el-table-column type="index" label="#"></el-table-column>
                <el-table-column
                        prop="userNo"
                        label="编号"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="userName"
                        label="用户名"
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="phone"
                        label="手机号">
                </el-table-column>
                <el-table-column label="操作">
                    <template v-slot:default="user">
                        <el-button type="primary" icon="el-icon-edit" @click="editUserDialogShow(user)">编辑</el-button>
                        <el-button type="danger" icon="el-icon-delete" @click="delUserInfo(user.row.userNo)">删除
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <!--分页-->
            <el-pagination @current-change="pageNumChange"
                           background
                           :page-size="queryUserParams.pagesize"
                           layout="total,prev, pager, next"
                           :total="total">
            </el-pagination>
        </el-card>
        <!--        更新用户信息的对话框-->
        <el-dialog title="编辑用户信息" :visible.sync="editUserDialog" @close="editUserDialogClose">
            <el-form :model="editUserForm" :rules="editUserRules" ref="editUserRef" label-width="100px"
                     class="demo-ruleForm">
                <el-form-item label="用户编号">
                    <el-input disabled v-model="editUserForm.userNo"></el-input>
                </el-form-item>
                <el-form-item label="用户名" prop="userName">
                    <el-input v-model="editUserForm.userName"></el-input>
                </el-form-item>
                <el-form-item label="手机号" prop="phone">
                    <el-input v-model="editUserForm.phone"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="userName">
                    <el-input show-password v-model="editUserForm.userPass"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="editUserDialog = false">取 消</el-button>
                <el-button type="primary" @click="editUserInfo">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        data() {
            //自定义 校验表单 rule:规则，	value:待校验的值，callback:回调
            const checkPhone = (rule, value, callback) => {
                //验证手机号的表达式
                const regPhone = /^1[0-9]{10}$/;
                if (regPhone.test(value)) {
                    //合法的手机号
                    return callback();

                } else {
                    //不合法时提示错误信息
                    callback(new Error("请输入合法的手机号"));
                }
            }
            return {

                //是否显示编辑对话框
                editUserDialog: false,

                editUserForm: {},
                //用户更新校验
                editUserRules: {
                    userName: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                        {min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur'}
                    ],
                    phone: [{
                        required: true, message: "请输入手机号", trigger: 'blur'
                    }, {
                        validator: checkPhone,
                        trigger: 'blur',
                    },
                    ]
                },

                //查询参数
                queryUserParams: {
                    userInput: '',
                    pagenum: 1,
                    pagesize: 5,
                },
                //用户列表
                users: [],
                total: 1,
            }
        },
        methods: {

            //加载用户信息
            loadUsers() {
                this.$axios({
                    url: '/api/user/list',
                    params: this.queryUserParams,
                }).then(resp => {
                    if (resp.data.code == 200) {
                        this.users = resp.data.data;
                        this.total = resp.data.page.totalpage;
                    }
                }).catch(resp => {
                    console.log(resp)
                });
            },

            // 页码值改变时触发
            pageNumChange(number) {
                this.queryUserParams.pagenum = number;
                this.loadUsers();
            },
            //打开编辑用户对话框时，显示用户信息
            editUserDialogShow(resp) {
                this.$axios({
                    url: '/api/user/info',
                    params: {id: resp.row.userNo}
                }).then(data => {
                    if (data.data.code == 200) {
                        this.editUserForm = data.data.data;
                    }
                })
                this.editUserDialog = true;


            },
            //编辑用户信息
            editUserInfo() {
                //对整个表单进行校验
                this.$refs.editUserRef.validate(valid => {
                    if (!valid) return;

                    //校验通过
                    this.$axios({
                        method: 'post',
                        url: '/api/user/edit',
                        params: this.editUserForm
                    }).then(resp => {
                        if (resp.data.code == 200) {
                            this.loadUsers();   //刷新
                            //关闭对话框，并提示修改完成
                            this.editUserDialog = false;
                            this.$message.success(resp.data.message);
                        } else {
                            return this.$message.error("修改出错")
                        }

                    })
                })
            },
            //根据 id 删除某个用户
            async delUserInfo(id) {
                console.log(id)
                //如果用户点击确认，则返回字符串 confirm;
                //如果用户点击取消，则返回字符串 cancel
                const isConfirm = await this.$confirm("确认删除该用户？", "提示", {
                    type: "warning",
                }).then(confirm => {
                    return confirm;
                }).catch(cancel => {
                    return cancel;
                });


                if (isConfirm !== "confirm") {
                    return this.$message("已取消删除操作");
                } else {
                    //点击确认时
                    this.$axios({
                        url: '/api/user/del',
                        params: {id: id}
                    }).then((resp) => {
                        if (resp.data.code == 200) {
                            this.loadUsers();
                            this.$message.success(resp.data.message);

                        }
                    })
                }
            },
            //对话框关闭时，重置表单
            editUserDialogClose() {
                this.$refs.editUserRef.resetFields();
            }
        },
        created() {
            this.loadUsers();
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