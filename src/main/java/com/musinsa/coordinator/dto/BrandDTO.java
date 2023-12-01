package com.musinsa.coordinator.dto;

import com.musinsa.coordinator.endpoint.request.BrandRequest;
import com.musinsa.coordinator.entity.Brand;
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
public class BrandDTO {
    Long id;
    String name;
    boolean deleted;

    public static BrandDTO from(BrandRequest brandRequest) {
        return BrandDTO.builder()
            .name(brandRequest.getName())
            .deleted(false)
            .build();
    }

    public static BrandDTO from(Brand brand) {
        return BrandDTO.builder()
            .id(brand.getId())
            .name(brand.getName())
            .deleted(brand.isDeleted())
            .build();
    }

    public static BrandDTO from(Long id, BrandRequest updateRequest) {
        return BrandDTO.builder()
            .id(id)
            .name(updateRequest.getName())
            .deleted(false)
            .build();
    }

    public Brand convertToBrand() {
        return Brand.builder()
            .id(this.id)
            .name(this.name)
            .deleted(this.deleted)
            .build();
    }
}