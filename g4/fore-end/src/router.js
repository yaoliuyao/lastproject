import Vue from "vue";
import Router from "vue-router";
import Layout from './components/Layout';
import Login from './views/Login';
import Regedit from './views/Regedit';
// import Home from './views/Home'
// import Contribute from './views/Contribute';
// import Lost from './views/Lost';
// import Talk from './views/Talk';
// import New from './views/New'
// import SearchResult from './views/SearchResult'
// import Personal from './views/Personal'
// import Conversation from './views/Conversation'
// import Systemmsg from './views/Systemmsg'
Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    /* 默认打开主页 */
    {
      path: '/',
      redirect: '/blog'
    },
  //
  //   /* 首页路由 */
  //   {
  //     path: '/blog',
  //     component: Layout,
  //     children: [
  //       {
  //         path: '/',
  //         component: Home,
  //         meta: {
  //           title: '首页',
  //           keepAlive: false
  //         }
  //       }
  //     ]
  //   },
  //
  //   /* 学上投稿路由 */
  //   {
  //     path: '/contribute',
  //     component: Layout,
  //     children: [
  //       {
  //         path: '/',
  //         component: Contribute,
  //         meta: {
  //           title: '学生投稿',
  //           keepAlive: false
  //         }
  //       }
  //     ]
  //   },
  //
  //   /* 搜索 */
  //   {
  //
  //     path: '/searchresult',
  //     component: Layout,
  //     children: [
  //       {
  //         path: '/',
  //         component: SearchResult,
  //         name: "SearchResult",
  //         meta: {
  //           title: '搜索结果',
  //           keepAlive: true
  //         }
  //       }
  //     ]
  //   },
  //
  //   /* 发表动态 */
  //   {
  //     path: '/new',
  //     component: Layout,
  //     children: [
  //       {
  //         path: '/',
  //         component: New,
  //         meta: {
  //           title: '发布动态',
  //           keepAlive: true
  //         }
  //       }
  //
  //     ]
  //   },
  //
  //   /* 话题 */
  //   {
  //     path: '/talk',
  //     component: Layout,
  //     children: [
  //       {
  //         path: '/',
  //         component: Talk,
  //         meta: {
  //           title: '话题',
  //           keepAlive: false
  //         }
  //       }
  //     ]
  //   },
  //
  //   /* 系统消息 */
  //   {
  //     path: '/sysmsg',
  //     component: Layout,
  //     children: [
  //       {
  //         path: '/',
  //         component: Systemmsg,
  //         meta: {
  //           title: '系统消息',
  //           keepAlive: false
  //         }
  //       }
  //     ]
  //   },
  //
  //
  //   /* 失物招领 */
  //   {
  //     path: '/lost',
  //     component: Layout,
  //     children: [
  //       {
  //         path: '/',
  //         component: Lost,
  //         meta: {
  //           title: '失物招领',
  //           keepAlive: false
  //         }
  //       }
  //     ]
  //   },
  //
  //   /* 个人资料 */
  //   {
  //     path: '/personal',
  //     component: Layout,
  //     children: [
  //       {
  //         path: '/',
  //         component: Personal,
  //         meta: {
  //           title: '个人资料',
  //           keepAlive: true
  //         }
  //       }
  //     ]
  //   },
  //
  //   /* 话题详情页 */
  //   {
  //     path: '/conversation',
  //     component: Layout,
  //     children: [
  //       {
  //         path: '/',
  //         component: Conversation,
  //         meta: {
  //           title: '话题详情',
  //           keepAlive: false
  //         }
  //       }
  //     ]
  //   },
  //
    /* 登录页路由 */
    {
      path: '/login',
      component: Login,
      meta: {
        title: '登录',
        keepAlive: false
      }
    },

    /* 注册页路由 */
    {
      path: '/regedit',
      component: Regedit,
      meta: {
        title: '注册',
        keepAlive: false
      }
    }

  ]
});
