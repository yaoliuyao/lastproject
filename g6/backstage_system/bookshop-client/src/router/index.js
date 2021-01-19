import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from '../components/login/Login'
import Index from '../components/Index'
import IndexHome from '../components/main/Home'
import Admin from '../components/admin'
import Classify from '../components/main/Classify'
import BookInfo from '../components/main/BookInfo'
import Home from '../components/Home'
import Welcome from '../components/Welcome'
import Users from '../components/user/Users'
import Member from '../components/user/Member'
import BookClassify from '../components/bookgoods/BookClassifys'
import BookList from '../components/bookgoods/BookList'
import BookAdd from '../components/bookgoods/BookAdd'
import BookEdit from '../components/bookgoods/BookEdit'
import OrderList from '../components/order/OrderList'
import OrderInfo from '../components/order/OrderInfo'
import OrderTotal from '../components/order/OrderTotal'
import Test from '../components/Test'

Vue.use(VueRouter)

const routes = [
    {
        path: '/login',
        component: Login
    },
    {
        path: '/index',
        component: Index,
        redirect: '/index',
        children: [
            {path: '/index', component: IndexHome},
            {path: '/classify', component: Classify},
            {path: '/bookinfo', component: BookInfo}
        ]
    },
    {
        path: '/home',
        component: Home,
        redirect: '/welcome',
        children: [
            {
                path: '/welcome',
                component: Welcome
            },
            {
                path: '/home/adminSet',
                component: Admin
            },
            {
                path: '/users',
                component: Users
            },
            {
                path: '/member',
                component: Member
            },
            {
                path: '/bookclassify',
                component: BookClassify
            },
            {
                path: '/booklist',
                component: BookList
            },
            {
                path: '/book/edit',
                component: BookEdit
            },
            {
                path: '/home/add',
                component: BookAdd
            },

            {
                path: '/home/order/list',
                component: OrderList
            },
            {
                path: '/home/order/info',
                component: OrderInfo
            },
            {
                path: '/home/order/total',
                component: OrderTotal,
                children: [
                    {path: '/xxx', component: Test}
                ]
            }
        ],
    },


]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
