<template>
    <div class="container">
        <h1>You Are Welcome</h1>
        <h3>Quasar Of Eating</h3>
        <input type="button" name="basket" value="Basket" @onclick="onToBasket" />
        <div id="adverts" :for="advert in this.list">
            <div class="basket">
                <input type="button" value="Clear" name="Clear" @onclick="onClear">
                <input type="button" value="To order" name="toOrder" @onclick="onOrder">
            </div>
            <button name="advert-action" onclick="">
                <h3>{{advert.title}}</h3>
                <input type="button" name="ordering" value="To Order" @onclick="onToBasket"/>
            </button>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                list: frontendData
            }
        },

        methods: {
            onToBasket() {
            }
        }
    }
</script>
<style>

</style>


