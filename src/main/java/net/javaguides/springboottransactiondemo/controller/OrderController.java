package net.javaguides.springboottransactiondemo.controller;

import net.javaguides.springboottransactiondemo.dto.OrderRequest;
import net.javaguides.springboottransactiondemo.dto.OrderResponse;
import net.javaguides.springboottransactiondemo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController
{
    private OrderService orderService;

    //Constructor based dependency injection.
    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    //Let's define the REST API.

    @PostMapping
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest)
    {
        //@RequestBody annotation is used to directly map the JSON object with order request object.
        return ResponseEntity.ok(orderService.placeOrder(orderRequest));
    }
}
