<template>
    <div id="adverts" :for="item in list">
        <advert :get="item"/>
    </div>
</template>
<script lang="js">
    import Vue from "vue"
    import Advert from "views/Advert.vue"


    Vue.component('advert-list', {
        props: ['list'],
    })
    export default {
        methods: {
            onToOrder() {
            }
        }
    }
</script>
<style>
</style>