package com.lock101.api;


import com.lock101.model.Customer;
import com.lock101.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    List<Customer> getCustomers() {
        return this.customerService.getCustomers();
    }

    @GetMapping("/inc")
    void increment() {
       this.customerService.increment();
    }
}
