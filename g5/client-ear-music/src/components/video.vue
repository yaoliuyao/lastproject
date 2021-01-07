<template>
    <section class="mv">
        <div class="mv">
            <h2 style="text-align: center;">MV精选</h2>
         <el-row >
            <el-col :span="10"  class="mv1"><div class="grid-content bg-purple">
            <!-- <img :src="imgsrc1"  alt="" width="100%" height="220px" > -->
            <video  width="100%" height="220px" controls>
                <source src="" type="video/mp4">
            </video>
            </div></el-col>
            <el-col :span="10" style="margin-left:50px;"><div class="grid-content bg-purple">
             <img :src="imgsrc2" alt="" width="100%" height="220px">    
            </div></el-col>
            </el-row>

        </div>
           
    </section>
</template>
<script>

export default {
//   props: ["imgsrc1,imgsrc2"],

    data(){
        return{
        }
    },
    methods:{

    }   ,
}
</script>
<style scoped>
    .mv{
        width: 100%;
        height: 300px;
        border: solid darkcyan 1px;
    }
    .mv1{
        margin-left:50px;
       
    }
    .mv1 :hover{
         opacity:0.9;

    }
</style>