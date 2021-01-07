import Vue from "vue";
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from "./App.vue";
import router from "./router";
import store from "./store";
import animated from 'animate.css'
import "./permission";
import { typefilter } from './filter'



Vue.config.productionTip = false;
Vue.use(ElementUI);
Vue.use(animated)
/*过滤器 转换动态类型代词转换为中文 */
Vue.filter('typefilter', typefilter)
new Vue({
  data() {
    return {
      wrapWidth: window.innerWidth - 240,//界面宽度
      allWidth: window.innerWidth - 180,
    }
  },
  router,
  store,
  render: h => h(App)
}).$mount("#app");
