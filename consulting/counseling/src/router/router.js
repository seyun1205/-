import {createRouter, createWebHashHistory} from "vue-router"

const routes = [
    {
        path: '/',
        component: () => import('@/components/login')
    },
    {
        path: '/home',
        name: "首页",
        component: () => import('@/components/home'),
        children: [
            {
                path: '/chitchat',
                name: '聊天框',
                component: () => import('@/components/counseling/chitchat')
            },
            {
                path: '/admin',
                name: '后台管理',
                component: () => import('@/components/admin/admin')
            }
        ]
    }
]
export const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
})

export default router
