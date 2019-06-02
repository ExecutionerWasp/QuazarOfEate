<template>
    <v-app>
        <v-toolbar app>
            <v-toolbar-title>Quasar Of Eating</v-toolbar-title>
            <v-spacer></v-spacer>
            <v-btn :disabled="$route.path === '/'" @click="openShop">
                Shop
            </v-btn>
            <v-btn @click="clearBasket">
                Clear basket
            </v-btn>
            <v-btn icon :disabled="$route.path === '/basket'" @click="openBasket">
                <v-icon>shopping_cart</v-icon>
            </v-btn>
        </v-toolbar>
        <router-view></router-view>
    </v-app>
</template>

<script>
    import Shop from "views/Shop.vue";
    import Basket from "views/Basket.vue";

    export default {
        components: {Basket, Shop},
        comments: {
          Shop
        },
        data() {
            return {
                list: [],
                basket: []
            }
        },

        created() {
            return this.$resource('/advert/list').get().then(result => result.json().then(data => this.list = data))
        },

        methods: {
            addToBasket(id){
                this.basket.push(id)
            },

            openBasket(){
                this.$router.push('/basket')
            },

            openShop(){
                this.$router.push('/')
            },
            clearBasket(){
                this.$resource('/basket/clear').save()
                this.$router.push('/')
            }
        }
    }
</script>
<style>

</style>