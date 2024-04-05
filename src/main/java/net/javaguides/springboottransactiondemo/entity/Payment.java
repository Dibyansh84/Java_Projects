package net.javaguides.springboottransactiondemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //'type' represents card type.
    private String type;
    private String cardName;
    private String cardNumber;
    private Integer expiryYear;
    private Integer expiryMonth;

    //cvc is your card cvv code.
    private Integer cvc;

    //We need to map the order and payment with the help of orderID.
    private Long orderId;

}
