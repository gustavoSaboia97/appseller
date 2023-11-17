<script setup>
	import { RouterLink } from 'vue-router'
</script>

<template>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <RouterLink class="nav-link active" to="/">Home</RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink class="nav-link active" to="/seller">Sellers</RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink class="nav-link active" to="/product">Products</RouterLink>
                </li>
            </ul>
        </div>
    </nav>

    <span class="badge rounded-pill bg-primary">Seller: {{ salesInfo.totalOfSellers }}</span>
    <span class="badge rounded-pill bg-secondary">Product: {{ salesInfo.totalOfProducts }}</span>
    <span class="badge rounded-pill bg-success">Book: {{ salesInfo.totalOfBooks }}</span>
    <span class="badge rounded-pill bg-danger">Game: {{ salesInfo.totalOfGames }}</span>
</template>

<script>

	export default {
		data() {
			return {
				salesInfo: {
					totalOfSellers: 0,
					totalOfProducts: 0,
					totalOfBooks: 0,
					totalOfGames: 0,
				}
			}
		},
		methods: {
			async requestSalesInfo(){
				let url = import.meta.env.VITE_SALES_API + '/api/sales-info'

				let response = await fetch(url, {
					method: 'GET'
				})

				if (response.status !== 200){
					alert('Could not get info on backend')
					return
				}

				this.salesInfo = await response.json()
			}	
		},
		async beforeMount(){
			await this.requestSalesInfo()
		}
	}
</script>
