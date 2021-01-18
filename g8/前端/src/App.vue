<template>
  <div id="app" class="clear">
    <NavHeader/>
    <section class="clear">
      <div class="container">
        <router-view/>
      </div>
    </section>
  </div>
</template>

<script>
  import NavHeader from "./components/Nav";
  export default {
    name: 'app',
    components: {
      NavHeader
    },
    mounted () {
      let apploading = document.getElementById('AppLoading');
      if (apploading != null) {
        document.body.removeChild(apploading);
      }
    }
  }
</script>

<style lang="scss">

</style>
