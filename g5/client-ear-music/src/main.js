import Vue from 'vue'
import App from './App.vue'
import './plugins/element.js'
import './plugins/vue-router'
import router from './router'
Vue.config.productionTip = false


new Vue({
    router, // 等同于 router: router
    render: h => h(App),
}).$mount('#app')