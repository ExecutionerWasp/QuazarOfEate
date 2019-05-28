import Vue from 'vue'
import App from './App.vue'
import router from './router'
import FlugIcon from 'vue-flag-icon'

Vue.use(FlugIcon)

Vue.config.productionTip = false

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')
