<template>

	<div class="container">
		<SalesHeader></SalesHeader>

		<h1 class="text-center">{{ action }} Product</h1>

        <br />
        <br />

        <form @submit.prevent="submit">
			<div class="mb-3">
				<label for="title" class="form-label">Title</label>
				<input v-model="product.title" type="text" class="form-control" id="title" min="10" max="50">
			</div>
			<div class="mb-3">
				<label for="description" class="form-label">Description</label>
				<input v-model="product.description" type="text" class="form-control" id="description" min="10" max="100">
			</div>
			<div class="mb-3">
				<label for="price" class="form-label">Price</label>
				<input v-model="product.price" type="number" class="form-control" id="price">
			</div>
			<div class="mb-3">
				<label for="quantity" class="form-label">Quantity</label>
				<input v-model="product.quantity" type="number" class="form-control" id="quantity">
			</div>
			<div class="mb-3">
				<label for="disabledSelect" class="form-label">Type</label>
				<select v-model="product.type" id="disabledSelect" class="form-select">
					<option>GAME</option>
					<option>BOOK</option>
      			</select>
    		</div>
			<div v-if="product.type === 'BOOK'" class="mb-3">
				<label for="author-name" class="form-label">Author Name</label>
				<input v-model="book.authorName" type="text" class="form-control" id="author-name">
			</div>
			<div v-if="product.type === 'BOOK'" class="mb-3">
				<label for="publisher-name" class="form-label">Publisher Name</label>
				<input v-model="book.publisherName" type="text" class="form-control" id="publisher-name">
			</div>
			<div v-if="product.type === 'BOOK'" class="mb-3">
				<label for="publisher-name" class="form-label">Number of Pages</label>
				<input v-model="book.numberOfPages" type="number" class="form-control" id="publisher-name">
			</div>
			<div v-if="product.type === 'GAME'" class="mb-3">
				<label for="studio-name" class="form-label">Studio Name</label>
				<input v-model="game.studioName" type="text" class="form-control" id="studio-name">
			</div>
			<div v-if="product.type === 'GAME'" class="mb-3">
				<label for="platform-name" class="form-label">Platform Name</label>
				<input v-model="game.platformName" type="text" class="form-control" id="platform-name">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
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
				product: {
					title: '',
					description: '',
					price: 0.0,
					quantity: 0,
					type: 'GAME',
				},
				game: {
					studioName: '',
					platformName: ''
				},
				book: {
					authorName: '',
					publisherName: '',
					numberOfPages: 0,
				},
				action: 'Create',
				id: this.$route.params.id,
				sellerId: this.$route.params.sellerId,
			}
		},
		methods: {
			async requestProductInfo(){
				let url = import.meta.env.VITE_SALES_API + '/api/product/' + this.id

				let response = await fetch(url, {
					method: 'GET'
				})

				if (response.status !== 200){
					alert('Could not get product info on backend')
					return
				}

				this.product = await response.json()
				
				if (this.product.type === 'GAME'){
					this.game.studioName = this.product.studioName
					this.game.platformName = this.product.platformName
				}
				if (this.product.type === 'Book'){
					this.book.authorName = this.product.authorName
					this.book.publisherName = this.product.publisherName
					this.book.numberOfPages = this.product.numberOfPages
				}

				this.sellerId = this.product.sellerId
			},
			async createProduct(){
				let url = import.meta.env.VITE_SALES_API + '/api/seller/' + this.sellerId + '/product'

				let productData = {...this.product}

				if (this.product.type === 'GAME'){
					productData = {...productData, ...this.game}
				}
				if (this.product.type === 'BOOK'){
					productData = {...productData, ...this.book}
				}


				let response = await fetch(url, {
					method: 'POST',
					headers: {
						"Content-Type": "application/json"
					},
					body: JSON.stringify(productData)
				})

				if (response.status !== 200){
					alert('Could not create product')
				}
				else {
					alert('Product was created')
				}

				this.$router.push({name: 'product'})
			},
			async updateProduct(){
				let url = import.meta.env.VITE_SALES_API + '/api/seller/' + this.sellerId + '/product/' + this.id

				let productData = {...this.product}

				if (this.product.type === 'GAME'){
					productData = {...productData, ...this.game}
				}
				if (this.product.type === 'BOOK'){
					productData = {...productData, ...this.book}
				}

				let response = await fetch(url, {
					method: 'PUT',
					headers: {
						"Content-Type": "application/json"
					},
					body: JSON.stringify(productData)
				})

				if (response.status !== 200){
					alert('Could not update product')
				}
				else {
					alert('Product was updated')
					this.$router.push({name: 'product'})
				}
			},
			async submit(){
				if (this.id){
					await this.updateProduct()
				}
				else {
					await this.createProduct()
				}
			},
		},
		async beforeMount(){
			if (this.id){
				this.action = 'Update'
				await this.requestProductInfo()
			}
		}
	}
</script>

<style scoped>

</style>
