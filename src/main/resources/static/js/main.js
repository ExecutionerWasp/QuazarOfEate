import Vue from 'vue'
import VueResource from 'vue-resource'
import App from './App.vue'

Vue.use(VueResource)

Vue.config.productionTip = false

new Vue({
    el: "#app",
    render: a => a(App)
})