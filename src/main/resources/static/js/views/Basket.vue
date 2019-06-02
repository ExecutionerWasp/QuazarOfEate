<template>
    <v-container>
        <v-layout justify-space-around>
            <v-flex xs5>
                <div class="title mt-5 mb-3">Basket</div>
                <v-layout row justify-space-between v-for="item in basket.values()">
                    <v-flex>
                        <b>{{item.name}}</b>
                    </v-flex>
                    <v-flex xs1>
                        <b>{{item.price}}&nbsp$</b>
                    </v-flex>
                </v-layout>
                <v-layout class="mt-3">
                    <v-flex><h3>Total cost:</h3></v-flex>
                    <v-flex xs1><h3>{{cost}}&nbsp$</h3></v-flex>
                </v-layout>
                <v-layout row>
                    <v-flex>
                        <v-btn large right color="primary" class="mt-5" @click="onToOrder">
                            To order
                        </v-btn>
                    </v-flex>
                </v-layout>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    export default {
        name: 'Profile',
        data() {
            return {
                basket: [],
                cost: null
            }
        },

        created() {
            this.$resource('/basket/list').get().then(result => result.json().then(data => this.basket = data))
            this.$resource('/basket/totalCost').get().then(result => result.json().then(data => this.cost = data))
        },

        methods: {
            onToOrder(){
                alert('We will call to you by a little time')
                this.$router.push('/')
            }
        }
    }
</script>

<style>

</style>