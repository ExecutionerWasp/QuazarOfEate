<template>
    <div class="advert">
        <div class="basket">
            <input type="button" value="Clear" name="Clear" @onclick="onClear">
            <input type="button" value="To order" name="toOrder" @onclick="onOrder">
        </div>
        <button name="advert-action" onclick="">
            <img name="face" src="{{advert.imgUrl}}"/>
            <h3>{{advert.title}}</h3>
            <input type="button" name="ordering" value="To Order" @onclick="onToBasket"/>
        </button>
    </div>
</template>

<script>
    import axios from 'axios';

    Vue.component('Advert', {
        props: ['getAdvert'],
        data() {
            return {
                advert: this.getAdvert
            }
        }
    });

    export default {
        methods: {
            onToBasket() {
                axios
                    .post('/basket/add', this.advert)
            }
        }
    }
</script>

<style scoped>

</style>