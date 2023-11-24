import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

import CommunityView from '../components/Community/CommunityView.vue'
import BoardCategoryView from '../components/Community/BoardCategoryView.vue'
import GroupCategoryView from '../components/group/GroupCategoryView.vue'
import TradeCategoryView from '../components/Trade/TradeCategoryView.vue'


import TypeHumor from '../components/Community/TypeHumor.vue'
import TypeInfo from '../components/Community/TypeInfo.vue'
import TypeFree from '../components/Community/TypeFree.vue'
import TypeQuestion from '../components/Community/TypeQuestion.vue'
import TypePop from '../components/Community/TypePop.vue'

import GroupList from '../components/Group/GroupList.vue'
import GroupCreate from '../components/Group/GroupCreate.vue'
import GroupDetail from '../components/Group/GroupDetail.vue'
import GroupUpdate from '../components/Group/GroupUpdate.vue'
import newMap from '@/components/Map/newMap.vue'
import MapComponent from '@/components/Map/MapComponent.vue'

import LoginView from '../components/Login/LoginView.vue'
import SignUpView from '../components/Login/SignUpView.vue'

import TradeCreate from '../components/Trade/TradeCreate.vue'
import TradeList from '../components/Trade/TradeList.vue'
import TradeDetail from '../components/Trade/TradeDetail.vue'
import TradeUpdate from '../components/Trade/TradeUpdate.vue'

import YoutubeTest from '../components/youtube/YoutubeTest.vue'

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
        },
        {
          path: "pop",
          name: "pop",
          component: TypePop
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
      path: '/group/:category',
      name: 'groupCreate',
      component: GroupCreate,
    },
    {
      path: '/group/detail/:id',
      name: 'groupDetail',
      component: GroupDetail,
    },{
      path: '/group/:id',
      name: 'groupUpdate',
      component: GroupUpdate,
    },
    {
      path: '/trade/:category',
      name: 'tradeList',
      component: TradeList,
    },
    {
      path: '/trade/:category',
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
    },{
      path: '/select',
      name: 'mapComponent',
      component: MapComponent,
    },{
      path: '/youtube',
      name: 'youtube',
      component: YoutubeTest,
    },
    {
      path: '/tradecategory',
      name: 'tradecategory',
      component: TradeCategoryView,
    },
    {
      path: '/groupcategory',
      name: 'groupcategory',
      component: GroupCategoryView,
    }
    
  ]
})

export default router
