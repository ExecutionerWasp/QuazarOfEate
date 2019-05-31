<template>
    <div id="basket">
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
    import Vue from "vue";

    Vue.component('basket', {
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
            },
            onClear() {
            }
        }
    }
</script>

<style>

</style>