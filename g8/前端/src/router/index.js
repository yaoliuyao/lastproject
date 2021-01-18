import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/index'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/index'
  },
  /* 首页 */
  {
    path: '/index',
    component: Index,
    redirect: '/index/main',
    children: [
      {
        path: 'main',
        name: 'index-main',
        component: () => import('../components/index/index-main')
      },
	
      {
        path: 'follow',
        name: 'index-follow',
        component: () => import('../components/index/index-follow')
      },
      {
        path: 'hot',
        name: 'index-hot',
        component: () => import('../components/index/index-hot')
      },
	 
    ]
  },
  {
	 /* 个人主页链接 */
    path: '/personal',
    name: 'personal',
    component: () => import('../views/personal'),
	children: [
		
	  {
	    path: 'dynamic',
	    name: 'personal-dynamic',
	    component: () => import('../components/personal/dynamic')
	  },
	  {
	    path: 'reply',
	    name: 'personalr-reply',
	    component: () => import('../components/personal/reply')
	  },
	  {
	    path: 'questions',
	    name: 'personal-questions',
	    component: () => import('../components/personal/questions')
	  },
	  {
	    path: 'article',
	    name: 'personal-article',
	    component: () => import('../components/personal/article')
	  },
	  {
	    path: 'column',
	    name: 'personal-column',
	    component: () => import('../components/personal/column')
	  },
	  {
	    path: 'collection',
	    name: 'personal-collection',
	    component: () => import('../components/personal/collection')
	  },
	  {
	    path: 'concern',
	    name: 'personal-concern',
	    component: () => import('../components/personal/concern')
	  },
	]
  },
  /* 设置 */
  {
    path: '/setup',
    name: 'setup',
    component: () => import('../views/setup'),
		children: [
			{
			  path: 'account',
			  name: 'setup-account',
			  component: () => import('../components/setup/account')
			},
			{
			  path: 'news',
			  name: 'setup-news',
			  component: () => import('../components/setup/news')
			},
			{
			  path: 'shielding',
			  name: 'setup-shielding',
			  component: () => import('../components/setup/shielding')
			},
			{
			  path: 'privacy',
			  name: 'setup-privacy',
			  component: () => import('../components/setup/privacy')
			},
			{
			  path: 'preference',
			  name: 'setup-preference',
			  component: () => import('../components/setup/preference')
			},
			{
			  path: 'things',
			  name: 'setup-things',
			  component: () => import('../components/setup/things')
			},
		]
  },
  /* 编辑个人资料 */
  {
    path: '/modify',
    name: 'modify',
    component: () => import('../views/modify')
  },
  /* 发现 */
  {
    path: '/found',
    name: 'Found',
    component: () => import('../views/found')
  },
  /* 等你来答 */
  {
    path: '/answer',
    redirect: '/answer/recommend',
    component: () => import('../views/answer'),
    children: [
      {
        path: 'recommend',
        component: () => import('../components/answer/recommend')
      },
      {
        path: 'hot',
        component: () => import('../components/answer/hot')
      },
      {
        path: 'new',
        component: () => import('../components/answer/new')
      },
      {
        path: 'invite',
        component: () => import('../components/answer/invite')
      }
    ]
  }
]

const router = new VueRouter({
  // mode: 'history',
  // base: process.env.BASE_URL,
  routes
})

export default router