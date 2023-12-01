package com.musinsa.coordinator.dto;

import com.musinsa.coordinator.entity.Item;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BrandItemsSummaryDTO {
    String brand;

    List<CategoryPriceDTO> categoryPriceList;

    Integer totalprice;

    public BrandItemsSummaryDTO() {
        this.brand = null;
        this.categoryPriceList = new ArrayList<>();
        this.totalprice = 0;
    }

    public BrandItemsSummaryDTO(Item item) {

    }

    public void addItems(Item item) {
        if (this.brand == null) {
            this.brand = item.getBrand();
        } else {
            if (!this.brand.equals(item.getBrand())) {
                throw new RuntimeException(String.format("BrandItemsSummary's brand name is different- dto.brand: %s, item.brand: %s", this.brand, item.getBrand()));
            }
        }
        this.categoryPriceList.add(new CategoryPriceDTO(item.getCategory(), item.getPrice()));
        this.totalprice += item.getPrice();
    }

    public List<CategoryPriceDTO> getItems() {
        return this.categoryPriceList;
    }
}


