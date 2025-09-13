package com.example.businesshelper.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;

    private String imageUrl;

    private String productUrl;

    private double purchasePrice;

    private double sellingPrice;

    @Enumerated(EnumType.STRING)
    private Category category;

    @CreationTimestamp
    private LocalDateTime createdTime;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private boolean active;
}
