<template>

    <el-row :gutter="20">
        <img src="../img/222.jpg">
            <el-col :span="8">
                <div class="demo-image__preview">
                <el-image
                        style="width: 200px; height: 200px"
                        :src="url"
                        :preview-src-list="srcList">
                </el-image>

            </div>

        <el-col :span="16"><div class="grid-content bg-purple"></div></el-col>
            </el-col>
    </el-row>


</template>

<script>
    export default {
        name: "Content",
        data(){
            return{
                url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
            }

        },
        methods:{

        }
    }
</script>

<style scoped>

</style>