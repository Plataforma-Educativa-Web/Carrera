package pe.cibertec.ProyectoFinal.ApiCarrera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class ApiCarreraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCarreraApplication.class, args);
	}

}
