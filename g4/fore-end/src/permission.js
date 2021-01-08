/*
权限校验
beforeEach(to,from,next)
*/

import router from "./router";
import loginApi from './api/login'
//import { getUserInfo } from "@/api/login.js";
import store from '@/store'
import { setUser } from '@/utils/local'

router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title
  }
  
  if(to.path=="/test"||to.path=='/test1'){
    return
  }

  //1.获取token
  const token = store.state.user.token
  if (!token) {
    //如果没有获取到token

    //要访问非登录页面
    if (to.path === "/login") {
      next()

    } else if (to.path === "/regedit") {
      next()
    } else {
      //请求登录页面
      next({
        path: "/login"
      });
    }
  } else {
    // console.log(token)
    //获取到token
    if (to.path === "/login") {
      next();
    } else if (to.path === "/regedit") {
      next()
    } else {

      const userInfo = store.state.user.userinfo;
      if (userInfo) {
        //如果获取到用户信息，则跳转到目标路由
        // console.log('有获取到')
        next();
      } else {
        loginApi.getUserInfo(token).then(res => {
          const resp = res.data
          // console.log(resp)
          if (resp.flag) {
            let obj = { //重构用户信息对象，不将用户密码保存至浏览器
              user: resp.data.username
            }
            setUser(obj)
            next()
          } else {
            next({
              path: "/login"
            })
          }
        })

      }
    }
  }
});
