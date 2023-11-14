package com.musinsa.coordinator.dto;

import com.musinsa.coordinator.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BrandPriceDTO {
    String brand;
    Integer price;

    public BrandPriceDTO(Item item) {
        this.brand = item.getBrand();
        this.price = item.getPrice();
    }
}
