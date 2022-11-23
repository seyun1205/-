import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)
const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('../views/from/home.vue'),
    redirect: '/login',
    children: [
      {
        path: 'index',
        name: 'index',
        component: () => import('../views/from/Index.vue')
      },
      {
        path: 'test',
        name: 'test',
        component: () => import('../views/from/main/test.vue')
      },
      {
        path: 'test2',
        name: 'test2',
        component: () => import('../views/from/main/test2.vue')
      },
      {
        path: 'judge/:sum',
        name: 'judge',
        component: () => import('../views/from/main/judge.vue')
      },
      {
        path: 'comment',
        name: 'comment',
        component: () => import('../views/from/main/comment.vue')
      },
      {
        path: 'knowledge',
        name: 'knowledge',
        component: () => import('../views/from/main/knowledge.vue')
      },
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/from/login.vue')
  },
  {
    path: '/register',
    name: 'register',
    component: () => import('../views/from/register.vue')
  },
  {
    path: '/manage',
    name: 'manage',
    component: () => import('../views/behind/manage.vue')
  },
  {
    path: '/test_manage',
    name: 'test_manage',
    component: () => import('../views/behind/test_manage.vue'),
    children: [
      {
        path:'ttable',
        name: 'test_table',
        component: () => import('../views/behind/alltable/test_table.vue')
      }
    ]
  },
  {
    path: '/knowledge_manage',
    name: 'knowledge_manage',
    component: () => import('../views/behind/knowledge_manage.vue'),
    children: [
      {
        path:'ktable',
        name: 'knowledge_table',
        component: () => import('../views/behind/alltable/knowledge_table.vue')
      }
    ]
  },
  {
    path: '/comment_manage',
    name: 'comment_manage',
    component: () => import('../views/behind/comment_manage.vue'),
    children: [
      {
        path:'ctable',
        name: 'comment_table',
        component: () => import('../views/behind/alltable/comment_table.vue')
      }
    ]
  },
  {
    path: '/help_manage',
    name: 'help_manage',
    component: () => import('../views/behind/help_manage.vue'),
    children: [
      {
        path:'htable',
        name: 'help_table',
        component: () => import('../views/behind/alltable/help_table.vue')
      }
    ]
  },
  {
    path: '/record_manage',
    name: 'record_manage',
    component: () => import('../views/behind/record_manage.vue'),
    children: [
      {
        path:'rtable',
        name: 'record_table',
        component: () => import('../views/behind/alltable/record_table.vue')
      }
    ]
  },
  {
    path:'*',  //URL输入错误或者是URL匹配不到静态资源，会自动跳转到主页
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})



export default router
