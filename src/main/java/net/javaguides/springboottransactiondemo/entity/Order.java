package net.javaguides.springboottransactiondemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String orderTrackingNumber;
    private Integer totalQuantity;
    private BigDecimal totalPrice;
    private String status;

    //We'll use Hibernate provided annotations to automatically populate the dateCreated and lastUpdated values.
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;
    //Shopping cart basically holds items.
    private Long shoppingCartId;

}
