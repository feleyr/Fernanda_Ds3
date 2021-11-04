package com.alessiojr.demojpa;

import com.alessiojr.demojpa.domain.Pessoa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaApplication.class, args);

        Pessoa p = new Pessoa();
        p.setNome("alessio");


        System.out.println("Minha Primeira Aplicação");
    }

}
