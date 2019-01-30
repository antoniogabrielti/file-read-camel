package com.projeto.teste.neogridfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(value={"com.projeto.teste.neogridfile"})
public class App {


	public static void main(String[] args) {

		SpringApplication.run(App.class, args);

	}

}

