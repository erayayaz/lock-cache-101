package com.lock101;

import com.lock101.model.Customer;
import com.lock101.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@Slf4j
public class Lock101Application {

    public static void main(String[] args) {
        SpringApplication.run(Lock101Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(final CustomerRepository customerRepository) {
        return args-> {
            Customer customer = new Customer();
            customer.setName("Eray");
            customer.setBalance(BigDecimal.ZERO);

            customerRepository.save(customer);
        };
    }

}
