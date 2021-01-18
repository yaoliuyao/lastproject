"use strict";

import Vue from 'vue';
import axios from "axios";
import {Message, Loading} from "element-ui";

// Full config:  https://github.com/axios/axios#request-config
// axios.defaults.baseURL = process.env.baseURL || process.env.apiUrl || '';
// axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

let config = {
    // baseURL: process.env.baseURL || process.env.apiUrl || ""
    // timeout: 60 * 1000, // Timeout
    // withCredentials: true, // Check cross-site Access-Control
};

const _axios = axios.create(config);
// axios 拦截器
let loading;
_axios.interceptors.request.use(
    function (config) {
        // Do something before request is sent
        //在发送请求前 调用 loading
        loading = Loading.service({
            lock: true,
            text: 'Loading',    //	显示在加载图标下方的加载文案
            spinner: 'el-icon-loading', //自定义加载图标类名
            background: 'rgba(0, 0, 0, 0.7)'    //遮罩背景色
        })
        return config;
    },
    function (error) {
        // Do something with request error
        //处理请求出错
        // 关闭 loading
        loading.close();
        Message.error(error)    //提示出错
        return Promise.reject(error);  // 如果 axios 的调用处存在 .catch，那么就去调用它
    }
);

// Add a response interceptor
_axios.interceptors.response.use(
    function (response) {
        // Do something with response data
        // 请求成功后 关闭 loading
        loading.close();
        return response;
    },
    function (error) {
        // Do something with response error
        loading.close();
        return Promise.reject(error);
    }
);

Plugin.install = function (Vue, options) {
    Vue.axios = _axios;
    window.axios = _axios;
    Object.defineProperties(Vue.prototype, {
        axios: {
            get() {
                return _axios;
            }
        },
        $axios: {
            get() {
                return _axios;
            }
        },
    });
};

Vue.use(Plugin)

export default Plugin;
