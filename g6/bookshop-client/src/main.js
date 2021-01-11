import Vue from 'vue'
import App from './App.vue'
import './plugins/element.js'
import './plugins/axios'
import router from './router'

import './assets/fonts/iconfont.css'
import './assets/css/global.css';
import moment from 'moment';

Vue.config.productionTip = false

Vue.filter("fmdate", v => {
    return moment(v).format("YYYY-MM-DD HH:mm:ss")
})

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')
