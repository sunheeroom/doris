package com.musinsa.coordinator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotNull
    String brand;
    @NotNull
    String category;
    @NotNull
    int price;

    public Item(String brand, String category, Integer price, boolean deleted) {
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.deleted = deleted;
    }

    @NotNull
    boolean deleted;
}