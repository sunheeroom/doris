package com.musinsa.coordinator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String category;

    String brand;

    Integer price;

    public Item(String category, String brand, Integer price) {
        this.category = category;
        this.brand = brand;
        this.price = price;
    }
}