package com.lock101.service;

import com.lock101.model.Customer;
import com.lock101.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    @Cacheable(value = "customer")
    public List<Customer> getCustomers() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }

        return new ArrayList<>(this.customerRepository.findAll());
    }

    // @Transactional(isolation = Isolation.SERIALIZABLE) We can get a deadlock also with this isolation type.
    @Transactional
    public void increment() {
        Customer c = this.customerRepository.findByName("Eray");
        c.setBalance(c.getBalance().add(BigDecimal.ONE));
        this.customerRepository.save(c);
    }

    @Transactional
    public Customer getCustomer(Long id) {
        return this.customerRepository.findById(id).get();
    }
}
