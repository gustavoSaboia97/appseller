<template>

	<div class="container">
		<SalesHeader></SalesHeader>

		<h1 class="text-center">Sellers</h1>

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
						<button v-on:click="deleteSeller(seller.id)">
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
				sellers: [],
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
			}
		},
		async beforeMount(){
			await this.requestSellersInfo()
		}
	}
</script>

<style scoped>

</style>
