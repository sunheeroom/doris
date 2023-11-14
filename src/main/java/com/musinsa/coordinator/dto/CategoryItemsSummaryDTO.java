package com.musinsa.coordinator.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryItemsSummaryDTO {

    String category;

    List<BrandPriceDTO> minPricedItems;

    List<BrandPriceDTO> maxPricedItems;
}
