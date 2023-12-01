package com.musinsa.coordinator.endpoint.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequest implements DefaultRequest {

    Long id;
    String category;

    String brandName;

    // Item name은 요구사항에 없어서 제외
    int price;

    @Override
    public boolean validate() {
        // TBD
        return true;
    }
}
