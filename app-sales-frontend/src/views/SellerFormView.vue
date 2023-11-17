<template>

	<div class="container">
		<SalesHeader></SalesHeader>

		<h1 class="text-center">{{ action }} Seller</h1>

        <br />
        <br />

        <form @submit.prevent="submit">
			<div class="mb-3">
				<label for="cpf" class="form-label">CPF</label>
				<input v-model="seller.cpf" type="text" placeholder="999.999.999-99" class="form-control" id="cpf" data-inputmask-alias="cpf" data-inputmask-inputformat="999.999.999-99">
				<small class="text-muted">e.g "999.999.999-99"</small>
			</div>
			<div class="mb-3">
				<label for="name" class="form-label">Name</label>
				<input v-model="seller.name" type="text" class="form-control" id="name">
			</div>
			<div class="mb-3">
				<label for="nickname" class="form-label">Nickname</label>
				<input v-model="seller.nickname" type="text" class="form-control" id="nickname">
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email address</label>
				<input v-model="seller.email" type="email" class="form-control" id="email">
			</div>
			<div class="mb-3">
				<label for="cep" class="form-label">CEP</label>
				<input v-model="seller.address.cep" type="text" class="form-control" id="cep">
			</div>
			<div class="mb-3 form-check">
				<input v-model="seller.active" type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Is Active</label>
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
				seller: {
					cpf: "",
					name: "",
					nickname: "",
					email: "",
					address: {
						cep: ""
					},
					active: false
				},
				action: 'Create',
				id: this.$route.params.id,
			}
		},
		methods: {
			async requestSellerInfo(){
				let url = import.meta.env.VITE_SALES_API + '/api/seller/' + this.id

				let response = await fetch(url, {
					method: 'GET'
				})

				if (response.status !== 200){
					alert('Could not get seller info on backend')
					return
				}

				this.seller = await response.json()
			},
			async createSeller(){
				let url = import.meta.env.VITE_SALES_API + '/api/seller'

				let response = await fetch(url, {
					method: 'POST',
					headers: {
						"Content-Type": "application/json"
					},
					body: JSON.stringify(this.seller)
				})

				if (response.status !== 200){
					if (response.status === 409){
						alert('Seller already exists')
					}
					else {
						alert('Could not create seller')
					}
				}
				else {
					alert('Seller was created')
				}

				this.$router.push({name: 'seller'})
			},
			async updateSeller(){
				let url = import.meta.env.VITE_SALES_API + '/api/seller/' + this.id

				console.log(this.seller)

				let response = await fetch(url, {
					method: 'PUT',
					headers: {
						"Content-Type": "application/json"
					},
					body: JSON.stringify(this.seller)
				})

				if (response.status !== 200){
					alert('Could not update seller')
				}
				else {
					alert('Seller was updated')
					this.$router.push({name: 'seller'})
				}
			},
			async submit(){
				if (this.id){
					await this.updateSeller()
				}
				else {
					await this.createSeller()
				}
			},
		},
		async beforeMount(){
			if (this.id){
				this.action = 'Update'
				await this.requestSellerInfo()
			}
		}
	}
</script>

<style scoped>

</style>
