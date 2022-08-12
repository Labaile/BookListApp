package com.example.booklistapp;

import com.example.booklistapp.model.Author;
import com.example.booklistapp.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
public class BookListAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookListAppApplication.class, args);
    }

    @Component
    public class StartUpRunner implements CommandLineRunner {
        @Autowired
        private AuthorRepository authorRepository;
        @Override
        public void run(String... args) throws Exception {
            authorRepository.saveAll(Arrays.asList(
                    Author.builder().name("Oprah Winfrey").build(),
                    Author.builder().name("RL Stine").build(),
                    Author.builder().name("Whoopi Goldberg").build()
            ));
            System.out.println(authorRepository.count());
        }
        @Bean
        public ModelMapper modelMapper(){
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return modelMapper;
        }
    }





}
