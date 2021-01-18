import VueRouter from "vue-router";
import shop from "./components/Shop"
import main from "./components/Main"
import search from "./components/Search"
import classification from "./components/Classification"
import user from "./components/User"
// 路由规则，返回路由对象
export default new VueRouter({
    routes: [
        {
            path: '/shop/:productNo', component: shop
        },
        {
            path: '/main', component: main
        },
        {
            path: '/', redirect: '/main'
        },
        {
            path: '/search/:params', component: search
        },
        {
            path: '/classification/:params', component: classification
        },
        {
            path: '/classification2/:params/:params2', component: classification
        },
        {
            path: '/user/:phone', component: user
        },
    ],
    mode: 'hash'
});