<template>
    <v-container>
        <v-layout row>
            <v-flex xs12 sm6 md3 class="mt-5">
                <v-text-field placeholder="Title" counter="25" v-model="name"></v-text-field>
                <v-text-field placeholder="Description" counter="25" v-model="description"></v-text-field>
                <v-text-field placeholder="Cost" counter="5"  prefix="$" type="number" v-model="price"></v-text-field>
                <v-text-field placeholder="Image URL" v-model="imgUrl"></v-text-field>
                <v-btn @click="onSave">
                    Add advert
                </v-btn>
                <v-btn @click="onClear">
                    Clear All Adverts
                </v-btn>
            </v-flex>
            <v-flex>
                <shop />
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import Shop from './Shop.vue'
    export default {
        components: {
            Shop
        },
        name: "Admin",
        data(){
            return {
                name: '',
                description: '',
                price: '',
                imgUrl: ''
            }
        },

        methods: {
            onSave(){
                this.$resource('/advert/save').save(
                    {
                        name: this.name,
                        description: this.description,
                        price: this.price,
                        imgUrl: this.imgUrl
                    })
                location.reload(true)
            },

            onClear(){
                this.$resource('/advert/clear').save()
                location.reload(true)
            }
        }
    }
</script>

<style scoped>
    .inputPrice input[type='number'] {
        -moz-appearance:textfield;
    }
    .inputPrice input::-webkit-outer-spin-button,
    .inputPrice input::-webkit-inner-spin-button {
        -webkit-appearance: none;
    }
</style>