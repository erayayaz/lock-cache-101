package com.lock101.repository;

import com.lock101.model.Customer;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //@Lock(LockModeType.OPTIMISTIC)
    //@Lock(LockModeType.PESSIMISTIC_READ) // we locked when we read
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    // we locked when we write --the best solution in our case
    Customer findByName(String name);
}