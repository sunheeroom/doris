package com.musinsa.coordinator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoryPriceDTO {
    String category;
    Integer price;
}
