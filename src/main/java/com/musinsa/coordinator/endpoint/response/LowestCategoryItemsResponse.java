package com.musinsa.coordinator.endpoint.response;

import com.musinsa.coordinator.entity.Item;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LowestCategoryItemsResponse {

    String brand;

    List<Item> categoryItems;

    Integer totalAmount;
}
