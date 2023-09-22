package com.unifacisa.tap.usuarioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UsuarioserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioserviceApplication.class, args);
	}

}
