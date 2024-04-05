package net.javaguides.springboottransactiondemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse
{
    //Once the user places the order, user should have to get some acknowledgement from the application.
    //So for that we've created OrderResponse class.

    private String orderTrackingNumber;
    private String status;
    private String message;
   //message ----> whether the order is successful or not.
}
