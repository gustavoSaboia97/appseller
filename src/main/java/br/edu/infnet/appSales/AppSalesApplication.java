package br.edu.infnet.appSales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSalesApplication.class, args);
	}
}
