package com.musinsa.coordinator.endpoint.request;

import com.musinsa.coordinator.dto.BrandDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BrandRequest implements DefaultRequest {
    String name;

    @Override
    public boolean validate() {
        // TBD
        return true;
    }

    public BrandDTO convertoToBrand() {
        return BrandDTO.builder()
            .name(this.name)
            .build();
    }
}
