import Vue from 'vue'
import VueRouter from 'vue-router'
import Shop from 'views/Shop.vue'
import Basket from 'views/Basket.vue'
import Admin from 'views/Admin.vue'

Vue.use(VueRouter)

const routes = [
    {path: '/', component: Shop},
    {path: '/basket', component: Basket},
    {path: '/admin', component: Admin},
    {path: '*', component: Shop}
]

export default new VueRouter({
    mode: 'history',
    routes
})