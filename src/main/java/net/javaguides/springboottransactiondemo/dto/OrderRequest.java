package net.javaguides.springboottransactiondemo.dto;

import lombok.Getter;
import lombok.Setter;
import net.javaguides.springboottransactiondemo.entity.Order;
import net.javaguides.springboottransactiondemo.entity.Payment;

@Getter
@Setter
public class OrderRequest
{
    //We'll use this OrderRequest DTO class to send a data(i.e order and payment details) from the client to server.
    //Client sends order and payment details.
    private Order order;
    private Payment payment;

}
