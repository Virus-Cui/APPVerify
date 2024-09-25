import {createRouter, createWebHashHistory, createWebHistory} from 'vue-router'

const router = createRouter({
  history: createWebHashHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/home',
    },
    {
      path: '/login',
      name: 'login',
      component: ()=>import("@/layout/login.vue")
    },
    {
      path: '/',
      name: 'layout',
      component: () => import('../layout/main.vue'),
      children: [
        {
          path: '/home',
          name: 'home',
          component: ()=>import("../views/index.vue")
        },
        {
          path: '/user',
          name: 'user',
          component: ()=>import("../views/user/index.vue")
        },
        {
          path: '/setting',
          name: 'settings',
          component: ()=>import("../views/settings/index.vue")
        },
        {
          path: '/app',
          name: 'app',
          component: ()=>import("../views/app/index.vue")
        }
      ]
    }
  ]
})

export default router
