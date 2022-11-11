import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
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
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
