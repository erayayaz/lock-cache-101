package com.lock101;

import com.lock101.model.Customer;
import com.lock101.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.math.BigDecimal;
import java.time.Duration;

@SpringBootApplication
@Slf4j
@EnableCaching
public class Lock101Application {

    public static void main(String[] args) {
        SpringApplication.run(Lock101Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(final CustomerRepository customerRepository) {
        return args -> {
            Customer customer = new Customer();
            customer.setName("Eray");
            customer.setBalance(BigDecimal.ZERO);

            customerRepository.save(customer);
        };
    }

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig() //
                .prefixCacheNameWith(this.getClass().getPackageName() + ".") //
                .entryTtl(Duration.ofHours(1)) //
                .disableCachingNullValues();

        return RedisCacheManager.builder(connectionFactory) //
                .cacheDefaults(config) //
                .build();
    }
}
