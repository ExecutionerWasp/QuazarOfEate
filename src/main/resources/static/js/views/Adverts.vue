<template>
    <div id="adverts" v-for="advert in adverts">
        <Advert get-advert="{{advert}}"/>
    </div>
</template>
<script lang="js">
    import axios from 'axios';

    Vue.component('Advert-list', {
        props: ['list'],
        data() {
            return {
                adverts: this.list
            }
        }
    })

    export default {
        methods: {
            onToOrder() {
                axios
                    .post('/basket/add', advert)
                    .then(response => (this.basket = response))
            }
        }
    }

</script>
<style>
</style>