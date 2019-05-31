<template>
    <div class="advert">
        <div class="basket">
            <input type="button" value="Clear" name="Clear" @onclick="onClear">
            <input type="button" value="To order" name="toOrder" @onclick="onOrder">
        </div>
        <button name="advert-action" onclick="">
            <h3>{{advert.title}}</h3>
            <input type="button" name="ordering" value="To Order" @onclick="onToBasket"/>
        </button>
    </div>
</template>

<script>
    import Vue from "vue";

    Vue.component('advert', {
        props: ['get'],
        data() {
            return {
                advert: get
            }
        }
    });

    export default {
        methods: {
            onToBasket() {
            }
        }
    }
</script>

<style>

</style>