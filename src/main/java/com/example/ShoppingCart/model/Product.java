package com.example.ShoppingCart.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private double price;
    private int quantity;

    private static double unitPrice(double price, int quantity) {
        return price * quantity;
    }
    public static double totalPrice(double price, int quantity) {
        return price * quantity * unitPrice(price, quantity);
    }
}

