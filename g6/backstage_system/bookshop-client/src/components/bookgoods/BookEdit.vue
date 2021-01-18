<template>
    <div>
        <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
            <el-breadcrumb-item>书籍管理</el-breadcrumb-item>
            <el-breadcrumb-item>编辑书籍</el-breadcrumb-item>
        </el-breadcrumb>
        <el-card>
            <el-alert
                    :closable="false"
                    title="编辑书籍"
                    type="info"
                    center
                    show-icon>
            </el-alert>
            <el-form ref="editBookRef" :model="editBookForm" :rules="editBookRules" label-width="80px">
                <el-form-item label="书籍编号">
                    <el-input disabled v-model="editBookForm.productNo" placeholder=""></el-input>
                </el-form-item>
                <el-form-item label="书籍名称" prop="bookName">
                    <el-input v-model="editBookForm.bookName" placeholder="请输入书籍名称"></el-input>
                </el-form-item>
                <el-form-item label="书籍地区" prop="rid">
                    <el-select v-model="editBookForm.rid" placeholder="请选择书籍地区">
                        <el-option v-for="r in bookRegion" :label="r.region" :value="r.rid" :key="r.rid"></el-option>
                    </el-select>
                    <el-button @click="regionDialogVisible=true" size="mini" icon="el-icon-plus"></el-button>
                </el-form-item>
                <el-form-item label="书籍类型" prop="typeNo">
                    <el-select v-model="editBookForm.typeNo" placeholder="请选择书籍类型">
                        <el-option v-for="d in bookType" :label="d.name" :value="d.typeNo" :key="d.typeNo"></el-option>
                    </el-select>
                    <el-button size="mini" @click="bookTypeDialog=true" icon="el-icon-plus"></el-button>
                </el-form-item>
                <el-form-item label="书籍作者" prop="author">
                    <el-input v-model="editBookForm.author"></el-input>
                </el-form-item>
                <el-form-item label="书籍价格" prop="price">
                    <el-input-number v-model="editBookForm.price" :precision="2" :step="1" :max="999"></el-input-number>
                </el-form-item>
                <el-form-item label="销售数量" prop="buyCount">
                    <el-input type="number" v-model="editBookForm.buyCount"></el-input>
                </el-form-item>
                <el-form-item label="库存" prop="stock">
                    <el-input type="number" v-model="editBookForm.stock"></el-input>
                </el-form-item>
                <el-form-item label="封面">
                    <div class="upload" @click="$refs.uploadRef.click()">
                        <img v-if="imageUrl!=''" :src="imageUrl" class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        <input type="file" ref="uploadRef" style="display: none" @change="inputFileChange">
                    </div>
                </el-form-item>
                <el-form-item label="书籍简介">
                    <el-input
                            type="textarea"
                            :rows="3"
                            placeholder="请输入内容"
                            v-model="editBookForm.content">
                    </el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit">编辑</el-button>
                    <el-button @click="$router.push('/booklist')">取消</el-button>
                </el-form-item>
            </el-form>
            <!--地区-->
            <el-dialog @close="addRegionDialogClose" title="添加书籍地区" :visible.sync="regionDialogVisible" width="30%">
                <el-input v-model="addRegion" placeholder="请输入书籍地区"></el-input>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="regionDialogVisible = false">取 消</el-button>
                     <el-button type="primary" @click="addRegionInfo">确 定</el-button>
                </span>
            </el-dialog>
            <!--类型-->
            <el-dialog @close="addBookTypeDialogClose" title="添加书籍类型" :visible.sync="bookTypeDialog" width="30%">
                <el-input v-model="addBookType" placeholder="请输入书籍类型"></el-input>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="bookTypeDialog = false">取 消</el-button>
                    <el-button type="primary" @click="addBookTypeInfo">确 定</el-button>
                 </span>
            </el-dialog>
        </el-card>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                imageUrl: '', //require("../../assets/plus.jpg"),
                bookRegion: [],
                bookType: [],
                editBookForm: {
                    buyCount: 0,
                    price: 0,
                    stock: 0,
                    cover: null,

                },
                bookTypeDialog: false,
                regionDialogVisible: false,
                addRegion: '',
                addBookType: '',
                editBookRules: {
                    bookName: [
                        {required: true, message: '必填项', trigger: 'blur'},
                    ],
                    rid: [
                        {required: true, message: '必选项', trigger: 'blur'},
                    ],
                    typeNo: [
                        {required: true, message: '必选项', trigger: 'blur'},
                    ],
                    author: [
                        {required: true, message: '必填项', trigger: 'blur'},
                    ],
                    buyCount: [
                        {required: true, message: '必填项', trigger: 'blur'},
                    ],
                    stock: [
                        {required: true, message: "必填项", trigger: "blue"}
                    ],
                    price: [
                        {required: true, message: "价格不能为空", trigger: 'blue'}
                    ]
                },
            }
        },
        methods: {
            onSubmit() {
                let formData = new FormData()
                formData.append("id", this.editBookForm.productNo)
                formData.append("typeNo", this.editBookForm.typeNo)
                formData.append("rid", this.editBookForm.rid)
                formData.append("bookName", this.editBookForm.bookName)
                formData.append("author", this.editBookForm.author)
                formData.append("price", this.editBookForm.price)
                formData.append("buyCount", this.editBookForm.buyCount)
                formData.append("stock", this.editBookForm.stock)
                formData.append("content", this.editBookForm.content)
                formData.append("cover", this.editBookForm.cover)

                //对表单进行校验
                console.log(this.editBookForm.typeNo)
                this.$refs.editBookRef.validate(v => {
                    if (!v) {
                        return this.$message.warning("必填项不能为空");
                    }
                    console.log(this.editBookForm.typeNo)
                    this.$axios({
                        method: "post",
                        url: '/api/book/edit',
                        data: formData,
                    }).then(resp => {
                        console.log(resp)
                        if (resp.data.code === 200) {
                            this.$message.success(resp.data.message);
                            this.$router.push('/booklist')
                        } else {
                            this.$message.error(resp.data.message);
                        }

                        // this.editBookForm = {}

                    })
                })
            },
            //获取 某本书籍编号的信息
            getBookinfo(id) {
                this.$axios({
                    url: "/api/book/info",
                    params: {id: id}
                }).then(resp => {
                    console.log(resp)
                    if (resp.data.code === 200) {
                        this.editBookForm = resp.data.data
                        this.imageUrl = "/image" + resp.data.data.cover

                    }
                })
            },
            //加载书籍地区
            loadBookRegion() {
                this.$axios({
                    url: '/api/book/region',
                }).then(resp => {
                    if (resp.data.code === 200) {
                        this.bookRegion = resp.data.data;
                    } else {
                        this.$message.warning(resp.data.message)
                    }

                })
            },
            //加载书籍类型
            loadBookType() {
                this.$axios("/api/book/type").then(resp => {
                    this.bookType = resp.data.data;
                })
            },
            //封面图发生改变时，
            inputFileChange() {
                console.log(this.$refs.uploadRef.files[0])
                this.imageUrl = URL.createObjectURL(this.$refs.uploadRef.files[0])  //创建一个虚拟路径
                this.editBookForm.cover = this.$refs.uploadRef.files[0];
            },
            //关闭添加地区对话框时
            addRegionDialogClose() {
                this.addRegion = "";
            },
            //关闭添加书籍类型对谁框时
            addBookTypeDialogClose() {
                this.addBookType = '';
            },
            //添加地区信息
            addRegionInfo() {
                if (this.addRegion === "") {
                    return this.$message.warning("书籍地区不能为空")
                }
                this.$axios({
                    method: 'post',
                    url: '/api/add/region',
                    params: {region: this.addRegion}
                }).then(resp => {
                    this.$message.success(resp.data.message);
                    this.loadBookRegion();
                    this.regionDialogVisible = false;


                })
            },
            //添加书籍类型
            addBookTypeInfo() {
                if (this.addBookType === "") {
                    return this.$message.warning("书籍类型不能为空");
                }
                this.$axios({
                    method: 'post',
                    url: '/api/add/booktype',
                    params: {name: this.addBookType}
                }).then(resp => {
                    this.loadBookType();
                    this.bookTypeDialog = false;
                    this.$message.success(resp.data.message);
                })
            }
        },

        created() {
            this.loadBookRegion();
            this.loadBookType()
            const id = this.$route.query["id"];
            this.getBookinfo(id)

        }
    }
</script>


<style scoped>
    .el-card {
        margin-top: 10px;
    }

    .el-form {
        margin-top: 10px;
        width: 500px;
    }


    .upload {
        padding: 1px;
        border: 1px dashed #d9d9d9;
        width: 180px;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }

    .upload:hover {
        border-color: #409EFF;
    }

    /*.upload img {*/
    /*    width: 100%;*/
    /*}*/


    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
    }

    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }

</style>