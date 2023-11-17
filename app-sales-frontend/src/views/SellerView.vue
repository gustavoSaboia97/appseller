<template>

	<div class="container">
		<SalesHeader></SalesHeader>

		<h1 class="text-center">Sellers</h1>

        <br />
        <br />

		<div class="container">
			<label for="search" class="form-label">Search</label>
			<input v-model="searchCpf" type="text" placeholder="999.999.999-99" class="form-control" id="search">
			<br />
			<button type="button" class="search btn btn-secondary" v-on:click="requestSellerInfo()"> Find Seller </button>
			<button type="button" class="search btn btn-light" v-on:click="requestSellersInfo()"> Clear Selection </button>
		</div>

		<br />
        <br />

        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">CPF</th>
                <th scope="col">NAME</th>
                <th scope="col">EMAIL</th>
                <th scope="col">NICKNAME</th>
                <th scope="col">IS ACTIVE</th>
                <th scope="col">EDIT</th>
                <th scope="col">DELETE</th>
            </tr>
            </thead>
            <tbody>
				<tr v-for="seller in sellers" :key="seller.id">
					<th scope="row">{{ seller.id }}</th>
					<td>{{ seller.cpf }}</td>
					<td>{{ seller.name }}</td>
					<td>{{ seller.email }}</td>
					<td>{{ seller.nickname }}</td>
					<td>{{ seller.active }}</td>
					<td>
						<button class="btn btn-light" v-on:click="editSeller(seller.id)">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
								<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
								<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
							</svg>
						</button>
					</td>
					<td>
						<button class="btn btn-light" v-on:click="deleteSeller(seller.id)">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
								<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5Zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6Z"/>
								<path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1ZM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118ZM2.5 3h11V2h-11v1Z"/>
							</svg>
						</button>
					</td>
				</tr>
            </tbody>
        </table>
		<button class="btn btn-primary" v-on:click="createSeller()"> Add Seller </button>
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
				sellers: [],
				searchCpf: '',
			}
		},
		methods: {
			async requestSellersInfo(){
				let url = import.meta.env.VITE_SALES_API + '/api/seller'

				let response = await fetch(url, {
					method: 'GET'
				})

				if (response.status !== 200){
					alert('Could not get seller info on backend')
					return
				}

				this.sellers = await response.json()
			},
			async requestSellerInfo(){
				if (!this.searchCpf){
					await this.requestSellersInfo()
					return
				}

				let url = import.meta.env.VITE_SALES_API + '/api/seller/cpf?cpf=' + this.searchCpf

				let response = await fetch(url, {
					method: 'GET'
				})

				if (response.status !== 200){
					alert('Could not get seller info on backend')
					await this.requestSellersInfo()
					return
				}

				this.sellers = [await response.json()]
			},
			async deleteSeller(sellerId){
				let url = import.meta.env.VITE_SALES_API + '/api/seller/' + sellerId

				let response = await fetch(url, {
					method: 'DELETE'
				})

				if (response.status !== 200){
					if (response.status === 409){
						alert('Seller cannot be deleted because of his products')
					}
					else {
						alert('Could delete seller')
					}
				}
				else {
					alert('Seller was deleted')
				}

				await this.requestSellersInfo()
			},
			
			editSeller(sellerId){
				this.$router.push({name: 'seller-edit', params: { id: sellerId }})
			},
			createSeller(){
				this.$router.push({name: 'seller-add'})
			}
		},
		async beforeMount(){
			await this.requestSellersInfo()
		}
	}
</script>

<style scoped>
	.search {
		margin-right: 5px;
	}
</style>
