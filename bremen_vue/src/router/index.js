import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CommunityView from '../views/Community/CommunityView.vue'
import CategoryView from '../views/Community/CategoryView.vue'
import DetailView from '../views/Community/DetailView.vue'
import LoginView from '../views/Login/LoginView.vue'
import SignUpView from '../views/Login/SignUpView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/board',
      name: 'board',
      component: CommunityView,
      children: [
        {
          path: ':category',
          name: 'category',
          component: CategoryView
        }
      ]
    }
    ,
        {
          path: '/detail/:id',
          name: 'detail',
          component: DetailView
        },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/signup',
      name: 'signup',
      component: SignUpView
    }
  ]
})

export default router
