package com.ratana.jfx;

import com.ratana.jfx.model.Account;
import com.ratana.jfx.model.Category;
import com.ratana.jfx.repository.AccountRepository;
import com.ratana.jfx.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final CategoryRepository categoryRepository;
    private final AccountRepository accountRepository;

    @Bean
    public CommandLineRunner getCommandLineRunner(){
        return (args) -> {
            categoryRepository.saveAll(Arrays.asList(
                    new Category("Drink"),
                    new Category("Rice"),
                    new Category("Ingredient"),
                    new Category("Snack")
            ));
            Account admin = new Account();
            admin.setUsername("admin");
            admin.setName("Ratana CHHORM");
            admin.setRole(Account.Role.Admin);
            admin.setPassword("1234");

            Account user = new Account();
            user.setUsername("user");
            user.setName("User Test");
            user.setRole(Account.Role.Sale);
            user.setPassword("4321");
            accountRepository.saveAll(Arrays.asList(admin, user));
        };
    }
}
