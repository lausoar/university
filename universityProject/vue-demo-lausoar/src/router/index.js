import Vue from 'vue'
import VueRouter from 'vue-router'

// import myMaps from '../components/myMaps'
import myHome from '../components/myHome'
import myAnalysis from '../components/myAnalysis'
import myCenter from '../components/myCenter'

import myTest from '../views/centerChildren/myTest'
import myChat from '../views/centerChildren/myChat'
import myPicture from '../views/centerChildren/myPicture'
import myLast from '../views/centerChildren/myLast'
import myOption from '../views/centerChildren/myOption'

import myLogin from '../components/myLogin'
import myRegister from '../components/myRegister'


Vue.use(VueRouter)

const routes = [
  {
    path:'/',
    redirect:'/myHome'  
  },
  {
      path:'/myHome',
      component: myHome,
      children:[
        // {
          // path:'myMaps',
          // component: myMaps
          // },
          {
          path:'myAnalysis',
          component: myAnalysis
          }
      ]
  },
  {
    path: '/china',
    name: 'china',
    component: () => import(/* webpackChunkName: "china" */ '../views/Map/china.vue')
  },{
    path: '/province',
    name: 'province',
    component: () => import(/* webpackChunkName: "province" */ '../views/Map/province.vue')
  },
  {
    path: '/city',
    name: 'city',
    component: () => import(/* webpackChunkName: "city" */ '../views/Map/city.vue')
  },
  {
      path:'/myAnalysis',
      component: myAnalysis
  },
  {
      path:'/myCenter',
      component: myCenter,
      children:[{
              path:'myTest',
              component: myTest
          },
          {
              path:'myChat',
              component: myChat
          },
          {
          path:'myPicture',
          component: myPicture
          },
          {
          path:'myLast',
          component: myLast
          },
          {
          path:'myOption',
          component: myOption
          }
      ]
  },
  {
      path:'/myLogin',
      component: myLogin
  },
  {
      path:'/myRegister',
      component: myRegister
  }
  
]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
})

export default router
