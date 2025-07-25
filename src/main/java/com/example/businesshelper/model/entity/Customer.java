package com.example.businesshelper.model.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String instagramName;

    private String phoneNumber;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    @OneToMany
    @Cascade(CascadeType.PERSIST)
    private List<Product> products;

    private String description;
}
