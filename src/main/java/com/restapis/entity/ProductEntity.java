package com.restapis.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Table(name = "products")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer productId;

    String productName;
    String category;
    Float price;
    Integer qty;
}
