import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import CommunityView from '../components/Community/CommunityView.vue'
import DetailView from '../components/Community/DetailView.vue'
import BoardCreate from '../components/Community/BoardCreate.vue'
import BoardUpdate from '../components/Community/BoardUpdate.vue'
import BoardList from '../components/Community/BoardList.vue'
import GroupList from '@/components/Group/GroupList.vue'
import GroupCreate from '../components/Group/GroupCreate.vue'
import GroupDetail from '../components/Group/GroupDetail.vue'
import LoginView from '../views/Login/LoginView.vue'
import SignUpView from '../views/Login/SignUpView.vue'
import Map from '@/components/Map/Map.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/board/:category',
      name: 'board',
      component: CommunityView,
    }
    ,
    {
      path: "/board/:category",
      name: "boardCreate",
      component: BoardCreate
    },
    {
      path: "/board",
      name: "boardUpdate",
      component: BoardUpdate
    },
    {
      path: '/:category/detail/:id',
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
    },
    {
      path: '/map',
      name: 'map',
      component: Map
    },
    {
      path: '/group/:category',
      name: 'groupList',
      component: GroupList,
    },
    {
      path: '/group/:category',
      name: 'groupCreate',
      component: GroupCreate,
    },
    {
      path: '/group/detail/:id',
      name: 'groupDetail',
      component: GroupDetail,
    },
    {
      path: '/board/boardlist',
      name: 'boardList',
      component: BoardList,
    }
  ]
})

export default router
