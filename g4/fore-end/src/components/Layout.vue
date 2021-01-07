<template>
  <div class="layout" ref="layout">
    <app-top></app-top>
    <app-main></app-main>
    <app-bottom></app-bottom>
  </div>
</template>

<script>
import AppTop from "./AppTop";
import AppMain from "./AppMain";
import AppBottom from "./AppBottom";
export default {
  data() {
    return {
      leftWidth: ""
    };
  },
  components: {
    AppTop,
    AppMain,
    AppBottom
  },
  created() {
    // console.log(this.$root.allWidth);
    this.leftWidth = (window.innerWidth - this.$root.allWidth) / 2;
  },
  mounted() {
    this.$refs.layout.style.width = this.$root.wrapWidth + "px";
    this.$refs.layout.style.marginLeft = this.leftWidth + "px";
  }
};
</script>

<style scoped>
.layout {
  background-color: white;
  position: absolute;
  top: 0;
  bottom: 0;
  padding: 30px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.04), 0 0 6px rgba(0, 0, 0, 0.04);
}
</style>