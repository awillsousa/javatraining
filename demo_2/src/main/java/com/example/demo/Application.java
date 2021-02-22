package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        Funcionario funcionario = applicationContext.getBean(Funcionario.class);
        funcionario.show();

    }

    @Bean
     CommandLineRunner commandLineRunner(ApplicationContext ctx)
     {
        return args -> {
            System.out.println("Vamos inspecionar os beans providos pelo spring boot: ");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }

}
