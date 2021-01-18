<template>
  <div id="app">
   <Home></Home>
  </div>
</template>
<script>

    import Home from "./components/Home";
  export default {
    name:"app",
    components:{Home}
  }
</script>


<style>
  #app {
  }
  body {
    margin: 0;
    padding: 0;
  }
  .el-backtop {
    background: darkgreen;
  }
  .el-icon-top:before {
    color: white;
    font-weight: bolder;
  }
</style>