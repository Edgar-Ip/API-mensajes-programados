package com.generadormensajes.generadorMensajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GeneradorMensajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneradorMensajesApplication.class, args);
	}

}
