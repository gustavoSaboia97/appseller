<template>

	<div class="container">
		<SalesHeader></SalesHeader>

		<h1 class="text-center">Products</h1>

        <br />
        <br />

        <h3 class="text-center">GAMES</h3>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">TITLE</th>
                <th scope="col">DESCRIPTION</th>
                <th scope="col">PRICE</th>
                <th scope="col">QUANTITY</th>
                <th scope="col">PLATFORM NAME</th>
                <th scope="col">STUDIO NAME</th>
                <th scope="col">SELLER</th>
                <th scope="col">EDIT</th>
                <th scope="col">DELETE</th>
            </tr>
            </thead>
            <tbody>
                <tr v-for="game in games" :key="game.id">
                    <th scope="row">{{ game.id }}</th>
                    <td>{{ game.title }}</td>
                    <td>{{ game.description }}</td>
                    <td>{{ game.price }}</td>
                    <td>{{ game.quantity }}</td>
                    <td>{{ game.platformName }}</td>
                    <td>{{ game.studioName }}</td>
                    <td>{{ game.sellerId }}</td>
                    <td>
						<button class="btn btn-light" v-on:click="editProduct(game.sellerId, game.id)">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
								<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
								<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
							</svg>
						</button>
					</td>
                    <td>
                        <button class="btn btn-light" v-on:click="deleteProduct(game.id)">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
                            </svg>
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>

        <br />
        <br />

        <h3 class="text-center">BOOKS</h3>

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">TITLE</th>
                <th scope="col">DESCRIPTION</th>
                <th scope="col">PRICE</th>
                <th scope="col">QUANTITY</th>
                <th scope="col">AUTHOR NAME</th>
                <th scope="col">PUBLISHER NAME</th>
                <th scope="col">NUMBER OF PAGES</th>
                <th scope="col">SELLER</th>
                <th scope="col">EDIT</th>
                <th scope="col">DELETE</th>
            </tr>
            </thead>
            <tbody class="table-striped">
                <tr v-for="book in books" :key="book.id">
                    <th scope="row">{{ book.id }}</th>
                    <td>{{ book.title }}</td>
                    <td>{{ book.description }}</td>
                    <td>{{ book.price }}</td>
                    <td>{{ book.quantity }}</td>
                    <td>{{ book.authorName }}</td>
                    <td>{{ book.publisherName }}</td>
                    <td>{{ book.numberOfPages }}</td>
                    <td>{{ book.sellerId }}</td>
                    <td>
						<button class="btn btn-light" v-on:click="editProduct(book.sellerId, book.id)">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
								<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
								<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
							</svg>
						</button>
					</td>
                    <td>
                        <button class="btn btn-light" v-on:click="deleteProduct(game.id)">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
                                <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
                            </svg>
                        </button>
                    </td>
                </tr>
            </tbody>
        </table>
  	</div>
</template>

<script>
	import SalesHeader from '../components/SalesHeader.vue'

	export default {
		components: {
			SalesHeader,
		},
		data() {
			return {
				games: [],
				books: [],
                sellerId: this.$route.params.sellerId,
			}
		},
		methods: {
			async requestProductsInfo(){
				let url = import.meta.env.VITE_SALES_API + '/api/product'

                if (this.sellerId){
                    url = url + '?sellerId=' + this.sellerId
                }

				let response = await fetch(url, {
					method: 'GET'
				})

				if (response.status !== 200){
					alert('Could not get product info on backend')
					return
				}

				let products = await response.json()

				this.games = []
				this.books = []

				products.forEach(product => {
					if (product.type === 'GAME'){
						this.games.push(product)
					}
					else {
						this.books.push(product)
					}
				})
			},
            editProduct(sellerId, id){
				this.$router.push({name: 'seller-product-edit', params: { sellerId: sellerId, id: id }})
			},
			async deleteProduct(productId){
				console.log('ta aqui')
				
				let url = import.meta.env.VITE_SALES_API + '/api/product/' + productId

				let response = await fetch(url, {
					method: 'DELETE'
				})

				if (response.status !== 200){
					alert('Could delete product')
				}
				else {
					alert('Product was deleted')
				}

				await this.requestProductsInfo()
			}
		},
		async beforeMount(){
			await this.requestProductsInfo()
		}
	}
</script>

<style scoped>

</style>
