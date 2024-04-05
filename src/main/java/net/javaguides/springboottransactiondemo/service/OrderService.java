package net.javaguides.springboottransactiondemo.service;

import net.javaguides.springboottransactiondemo.dto.OrderRequest;
import net.javaguides.springboottransactiondemo.dto.OrderResponse;

public interface OrderService
{
    //placeOrder() method to place the order.
    OrderResponse placeOrder(OrderRequest orderRequest);
}
