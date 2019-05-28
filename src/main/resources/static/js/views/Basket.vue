<template>
    <div class="basket">
        <div class="ordered">
            <div class="row" v-for="advert in adverts">
                <i>{{advert.id}}</i>
                <h3>{{advert.title}}</h3>
            </div>
        </div>
        <input type="button" value="Clear" name="clear" @onclick="onClear">
        <input type="button" value="To order" name="toOrder" @onclick="onToOrder">
    </div>
</template>

<script>
    import axios from 'axios';

    Vue.component('Basket', {
        data() {
            return{
                adverts:[]
            }
        }
    });

    export default {
        el: '#basket',
        methods: {
            onToOrder() {
                axios
                    .get('/basket/list')
                    .then(response => (this.basket = response));
            },
            onClear() {
                axios
                    .get('/basket/clear')
                    .then(response => (this.basket = response));
            }
        }
    }
</script>

<style scoped>

</style>