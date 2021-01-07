<template>
  <div class="wrap">
    <keep-alive>
      <transition enter-active-class="animated bounce" leave-active-class="animated hinge">
        <router-view v-if="$route.meta.keepAlive"></router-view>
      </transition>
    </keep-alive>
    <router-view v-if="!$route.meta.keepAlive"></router-view>
    <el-backtop target=".wrap"></el-backtop>
  </div>
</template>

<style scoped>
.wrap {
  padding: 45px;
  position: absolute;
  top: 100px;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: white;
  overflow-y: scroll;
}
/* 隐藏滚动条 */
.wrap::-webkit-scrollbar {
  display: none;
}
</style>