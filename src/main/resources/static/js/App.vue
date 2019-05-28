<template>
    <div class="basket">
        <input type="button" name="basket" value="Basket" @onclick="" />
    </div>
    <AdvertList list="{{list}}"/>
</template>

<script>
    import axios from "axios";

    export default {
        data() {
            list: axios
                .get('/advert/list')
                .then(response => (this.basket = response))
        },

        methods: {
            onToBasket() {
                axios
                    .get('/basket');
            }
        }
    }

</script>


