function getIndex(list, id) {
    for (var i = 0; i < list.length; i++) {
        if (list[i].id === id) {
            return 1;
        }
    }
    return -1;
}


var productApi = Vue.resource('/product{/id}');

Vue.component('product-form', {
    props: ['products', 'productAttr'],
    data: function () {
        return {
            id: '',
            name: '',
            description: '',
            price: ''
        }
        },
    watch: {
        productAttr: function(newVal, oldVal){
            this.name = newVal.name;
            this.description = newVal.description;
            this.price = newVal.price;
            this.id = newVal.id;
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="Name" v-model="name" />' +
        '<input type="text" placeholder="Description" v-model="description" />' +
        '<input type="number" placeholder="Price" v-model="price" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function () {
            var product = {
                name: this.name,
                description: this.description,
                price: this.price
            };

            if(this.id) {
                productApi.update({id: this.id}, product).then(result =>
                result.json().then(data => {
                    var index = getIndex(this.products, data.id);
                    this.products.splice(index, 1, data);
                this.id = '';
                this.name = '';
                this.description = '';
                this.price = '';
                })
            )
            }

            productApi.save({}, product).then(result =>
                result.json().then(data => {
                    this.products.push(data);
            this.name = '';
            this.description = '';
            this.price = '';
            }))
        }
    }
});

Vue.component('product-row', {
    props: ['product', 'editMethod', 'products'],
    template: '<div>' +
        '<i>({{ product.id }})</i>' +
        ' {{product.name}}' +
        ' {{product.description}}' +
        ' {{product.price}}' +
        '<span style="position: absolute; right: 0">' +
        '<input type="button" value="Edit" @click="edit" />'+
        '<input type="button" value="Delete" @click="del" />'+
        '</span>'+
        ' </div>',
    methods: {
        edit: function (product) {
            this.editMethod(this.product);
        },

        del: function (product) {
            productApi.remove({id: this.product.id}).then(result => {
                if(result.ok) {
                    this.products.splice(this.products.indexOf(this.product), 1)
            }
            })
        }
    }
});

Vue.component('product-list', {
    props: ['products'],
    data: function(){
        return {
            product: null
        }
    },

    template: '<div style="position: relative; width: 500px;">' +
        '<product-form :products="products" :productAttr="product"/>'+
        '<product-row v-for="product in products" :key="product.id" ' +
        ':product="product" :editMethod="editMethod" :products="products"/>' +
        '</div>',
    created: function () {
        productApi.get().then(result =>
        result.json().then(data =>
        data.forEach(product => this.products.push(product))))
    },

    methods: {
        editMethod: function (product) {
            this.product = product;
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<product-list :products="products"/>',
    data: {
        products: []
    }
});