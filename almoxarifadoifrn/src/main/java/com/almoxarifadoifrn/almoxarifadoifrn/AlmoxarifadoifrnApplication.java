package com.almoxarifadoifrn.almoxarifadoifrn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class AlmoxarifadoifrnApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlmoxarifadoifrnApplication.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}  

}
