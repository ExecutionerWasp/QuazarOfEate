<template>
    <v-app>
        <v-layout row>
            <v-flex xs6 sm10 offset-sm2>
                <v-card width="900px">
                    <v-toolbar flat>
                        <v-btn icon>
                            <v-icon>arrow_back</v-icon>
                        </v-btn>
                    </v-toolbar>
                    <v-container fluid grid-list-sm>
                        <v-layout row wrap>
                            <v-flex id="adverts" v-for="advert in this.list">
                                <v-hover>
                                    <v-card
                                            slot-scope="{ hover }"
                                            class="mx-auto"
                                            color="grey lighten-4"
                                            width="200"
                                    >
                                        <v-img
                                                :aspect-ratio="16/9"
                                                :src="advert.imgUrl"
                                        >
                                            <v-expand-transition>
                                                <div
                                                        v-if="hover"
                                                        class="d-flex transition-fast-in-fast-out orange darken-2 v-card--reveal display-3 white--text"
                                                        style="height: 100%;"
                                                >
                                                    {{advert.price}}&nbsp$
                                                </div>
                                            </v-expand-transition>
                                        </v-img>
                                        <v-card-text
                                                class="pt-4"
                                                style="position: relative;"
                                        >
                                            <v-btn
                                                    absolute
                                                    color="orange"
                                                    class="white--text"
                                                    fab
                                                    small
                                                    right
                                                    top
                                                    @click="addToBasket(advert)"
                                            >
                                                <v-icon>add</v-icon>
                                            </v-btn>
                                            <h3 class="display-1 font-weight-light orange--text mb-2">
                                                {{advert.name}}</h3>
                                            <div class="font-weight-light title mb-2">
                                                {{advert.description}}
                                            </div>
                                        </v-card-text>
                                    </v-card>
                                </v-hover>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-card>
            </v-flex>
        </v-layout>
    </v-app>
</template>

<script>
    export default {
        data() {
            return {
                list: ''
            }
        },

        created() {
            return this.$resource('/advert/list').get().then(result => result.json().then(data => this.list = data))
        },

        methods: {
            addToBasket(advert) {
                this.$resource('/basket/add').save(advert)
            }
        }
    }
</script>
<style>
    .v-card--reveal {
        align-items: center;
        bottom: 0;
        justify-content: center;
        opacity: .5;
        position: absolute;
        width: 100%;
    }
</style>