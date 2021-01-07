import axios from 'axios';
import {Message, Loading} from 'element-ui';

let options = {
        target: '.wrap',
        lock: true,
        text: 'Loading',
        spinner: 'el-icon-loading',
        background: 'rgba(0, 0, 0, 0.7)'
    },
    options2 = {
        target: '.wrap',
        lock: true,
        text: '正在加载',
        spinner: 'el-icon-loading'
    }

let load = {
        loadingInstance: null,
        open() {

            if (this.loadingInstance === null) {
                this.loadingInstance = Loading.service(options)
                //console.log(this.loadingInstance.visible)
            } else if (this.loadingInstance !== null) {
                this.loadingInstance.close()
                this.loadingInstance = null
                this.loadingInstance = Loading.service(options)
            }
        },
        close() {
            if (this.loadingInstance !== null) {
                this.loadingInstance.close()
            }
            this.loadingInstance = null
        }
    },
    load2 = {
        loadingInstance: null,
        open() {

            if (this.loadingInstance === null) {
                this.loadingInstance = Loading.service(options2)
                //console.log(this.loadingInstance.visible)
            } else if (this.loadingInstance !== null) {
                this.loadingInstance.close()
                this.loadingInstance = null
                this.loadingInstance = Loading.service(options2)
            }
        },
        close() {
            if (this.loadingInstance !== null) {
                this.loadingInstance.close()
            }
            this.loadingInstance = null
        }
    }
const req = axios.create({
    //baseURL: process.env.VUE_APP_BASE_API,
    timeout: 5000
})

// 添加请求拦截器
req.interceptors.request.use(function (config) {
    // console.log(config.url)
    if (config.url == '/api/login') { //访问登录页
        // Message('正在登录')
        load.open()
    } else if (config.url == '/api/search' || config.url == '/api/item') {
        load2.open()
    }
    // 在发送请求之前做些什么
    return config;
}, function (error) {
    // 对请求错误做些什么

    Message({
        type: 'error',
        message: error.message
    })
    return Promise.reject(error);
});

// 添加响应拦截器
req.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    console.log(response)
    load.close()
    load2.close()
    return response;
}, function (error) {
    // 对响应错误做点什么
    load.close()
    load2.close()
    Message({
        type: 'error',
        message: '服务器异常'
    })
    return Promise.reject(error);
});

export default req