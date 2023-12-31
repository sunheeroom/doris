package com.musinsa.coordinator.dto;

import com.musinsa.coordinator.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryPriceDTO {
    String category;
    Integer price;

    public CategoryPriceDTO(Item item) {
        this.category = item.getCategory();
        this.price = item.getPrice();
    }
}
