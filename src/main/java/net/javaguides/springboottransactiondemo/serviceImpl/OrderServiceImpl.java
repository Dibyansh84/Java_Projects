package net.javaguides.springboottransactiondemo.serviceImpl;


import net.javaguides.springboottransactiondemo.dto.OrderRequest;
import net.javaguides.springboottransactiondemo.dto.OrderResponse;
import net.javaguides.springboottransactiondemo.entity.Order;
import net.javaguides.springboottransactiondemo.entity.Payment;
import net.javaguides.springboottransactiondemo.exception.PaymentException;
import net.javaguides.springboottransactiondemo.repository.OrderRepository;
import net.javaguides.springboottransactiondemo.repository.PaymentRepository;
import net.javaguides.springboottransactiondemo.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService
{
    private OrderRepository orderRepository;

    private PaymentRepository paymentRepository;

    //Constructor based dependency injection.
    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository)
    {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional(rollbackFor = PaymentException.class)
    public OrderResponse placeOrder(OrderRequest orderRequest)
    {
        Order order = orderRequest.getOrder();
        order.setStatus("IN PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        //We'll write some logics to fill the payment for this order.
        //If the user enters payment card type as credit card then the below mention condition will throw the exception.
        //And the payment details won't store in the database.
        if(!payment.getType().equals("DEBIT"))
        {
            throw new PaymentException("Payment card type doesn't support");
        }

        payment.setOrderId(order.getId());
        //save() method will save the payment details into the database.
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
