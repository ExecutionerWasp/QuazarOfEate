<template>
    <div class="container">
        <h1>You Are Welcome</h1>
        <h3>Quasar Of Eating</h3>
        <input type="button" name="basket" value="Basket" @onclick="onToBasket" />
        <advert-list :list="this.list"/>
    </div>
</template>

<script>
    import axios from "axios"
    import Adverts from "views/Adverts.vue"
    export default {
        name: 'app',
        data() {
            return {
                list: frontendData
            }
        },

        methods: {
            onToBasket() {
                axios
                    .post('/basket')
            }
        }
    }
</script>
<style>

</style>


