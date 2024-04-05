package net.javaguides.springboottransactiondemo.repository;

import net.javaguides.springboottransactiondemo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>
{
    //JpaRepository interface will provide CRUD methods to Payment JPA entity.
}
