package com.ratana.jfx;

import com.ratana.jfx.model.Category;
import com.ratana.jfx.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class DataInitializer {

    private final CategoryRepository categoryRepository;

    @Bean
    public CommandLineRunner getCommandLineRunner(){
        return (args) -> {
            categoryRepository.saveAll(Arrays.asList(
                    new Category("Drink"),
                    new Category("Rice"),
                    new Category("Ingredient"),
                    new Category("Snack")
            ));
        };
    }
}
