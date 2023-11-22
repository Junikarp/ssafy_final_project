import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

import CommunityView from '../components/Community/CommunityView.vue'
import BoardCategoryView from '../components/Community/BoardCategoryView.vue'
import GroupCategoryView from '../components/Community/GroupCategoryView.vue'
import DetailView from '../components/Community/DetailView.vue'
import BoardCreate from '../components/Community/BoardCreate.vue'
import BoardUpdate from '../components/Community/BoardUpdate.vue'

import TypeHumor from '../components/Community/TypeHumor.vue'
import TypeInfo from '../components/Community/TypeInfo.vue'
import TypeFree from '../components/Community/TypeFree.vue'
import TypeQuestion from '../components/Community/TypeQuestion.vue'

import GroupList from '../components/Group/GroupList.vue'
import GroupCreate from '../components/Group/GroupCreate.vue'
import GroupDetail from '../components/Group/GroupDetail.vue'
import newMap from '@/components/Map/newMap.vue'

import LoginView from '../views/Login/LoginView.vue'
import SignUpView from '../views/Login/SignUpView.vue'
import KakaoLogin from '../views/Login/KakaoLogin.vue'

import TradeCreate from '../components/Trade/TradeCreate.vue'
import TradeList from '../components/Trade/TradeList.vue'
import TradeDetail from '../components/Trade/TradeDetail.vue'
import TradeUpdate from '../components/Trade/TradeUpdate.vue'

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
      children: [
        {
          path: "info",
          name: "info",
          component: TypeInfo
        },
        {
          path: "humor",
          name: "humor",
          component: TypeHumor
        },
        {
          path: "question",
          name: "question",
          component: TypeQuestion
        },
        {
          path: "free",
          name: "free",
          component: TypeFree
        }
      ]
    }
    ,
    {
      path: '/boardcategory',
      name: 'category',
      component: BoardCategoryView,
    },
    {
      path: '/groupcategory',
      name: 'groupcategory',
      component: GroupCategoryView,
    }
    ,
    {
      path: "/board/:category",
      name: "boardCreate",
      component: BoardCreate,
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
      name: 'newMap',
      component: newMap,
    },
    {
      path: '/group/:category',
      name: 'groupList',
      component: GroupList,
    },
    {
      path: '/group',
      name: 'groupCreate',
      component: GroupCreate,
    },
    {
      path: '/group/detail/:id',
      name: 'groupDetail',
      component: GroupDetail,
    },
    {
      path: '/trade/:category',
      name: 'tradeList',
      component: TradeList,
    },
    {
      path: '/trade',
      name: 'tradeCreate',
      component: TradeCreate,
    },
    {
      path: '/trade/detail/:id',
      name: 'tradeDetail',
      component: TradeDetail,
    },{
      path: '/trade/:id',
      name: 'tradeUpdate',
      component: TradeUpdate,
    }
  ]
})

export default router
