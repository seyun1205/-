import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
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
    path: '/',
    name: 'index',
    component: () => import('../views/from/index.vue'),
     }, 
      {
        path: '/test',
        name: 'test',
        component: () => import('../views/from/main/test.vue')
      },
      {
        path: '/test2',
        name: 'test2',
        component: () => import('../views/from/main/test2.vue')
      },
      {
        path: '/judge/:grade',
        name: 'judge',
        component: () => import('../views/from/main/judge.vue')
      },
      {
        path:'*',  //URL输入错误或者是URL匹配不到静态资源，会自动跳转到主页
        redirect:'/'
      }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
