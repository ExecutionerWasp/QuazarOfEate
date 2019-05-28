import Vue from 'vue'
import VueRouter from 'vue-router'
import App from 'App.vue'
import Basket from 'views/Basket.vue'

Vue.use(VueRouter)

const routes = [
    { path: '/', component: App },
    { path: '/basket', component: Basket }
];

export default new VueRouter({
    mode: 'history',
    routes
})