package com.musinsa.coordinator.dto;

import com.musinsa.coordinator.endpoint.request.ItemRequest;
import com.musinsa.coordinator.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    Long id;
    String category;
    String brand;
    int price;

    public static ItemDTO from(ItemRequest itemRequest) {
        return ItemDTO.builder()
            .id(itemRequest.getId())
            .category(itemRequest.getCategory())
            .brand(itemRequest.getBrandName())
            .price(itemRequest.getPrice())
            .build();
    }

    public static ItemDTO from(Item item) {
        return ItemDTO.builder()
            .category(item.getCategory())
            .brand(item.getBrand())
            .price(item.getPrice())
            .build();
    }

    public static ItemDTO from(Long id, ItemRequest updateRequest) {
        return ItemDTO.builder()
            .id(id)
            .category(updateRequest.getCategory())
            .brand(updateRequest.getBrandName())
            .price(updateRequest.getPrice())
            .build();
    }

    public Item convertToItem() {
        return Item.builder()
            .category(this.category)
            .brand(this.brand)
            .price(this.price)
            .build();
    }
}

