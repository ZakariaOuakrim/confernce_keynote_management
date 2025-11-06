package com.zakaria.keynote_service;

import com.zakaria.keynote_service.entities.Keynote;
import com.zakaria.keynote_service.repositories.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KeynoteRepository keynoteRepository){
        return args -> {
             keynoteRepository.save(Keynote.builder()
                     .firstName("zakaria")
                     .function("student")
                     .lastName("ouakrim")
                     .email("zakaria@gmail.com")
                     .build());
            keynoteRepository.save(Keynote.builder()
                    .firstName("omar")
                    .function("professor")
                    .lastName("sakhi")
                    .email("omar@gmail.com")
                    .build());
            keynoteRepository.save(Keynote.builder()
                    .firstName("said")
                    .function("phd student")
                    .lastName("sajji")
                    .email("said@gmail.com")
                    .build());
        };
    }
}
