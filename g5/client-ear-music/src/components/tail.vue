<template>
<div id="tail">
    <section class="tail">
        <div class="bott">
          <el-divider >遇见耳朵</el-divider>
        </div>
        <ear-nav></ear-nav>
    </section>
</div>
</template>
<script>
import nav from './nav'
export default {
name:"tail",
  data() {
    return {};
  },
    components: {
      "ear-nav": nav,
  },
};
</script>
<style  scoped>
    .bott{
        width: 1340px;
        height: 200px;
        margin-top:50px ;
        background: #333;
    }
</style>