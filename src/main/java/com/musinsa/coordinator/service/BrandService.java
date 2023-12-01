package com.musinsa.coordinator.service;

import com.musinsa.coordinator.dto.BrandDTO;
import com.musinsa.coordinator.entity.Brand;
import com.musinsa.coordinator.exception.ResourceNotFoundException;
import com.musinsa.coordinator.repository.BrandRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public BrandDTO insertBrand(BrandDTO brandDTO) {
        Brand brand = brandDTO.convertToBrand();

        return BrandDTO.from(this.brandRepository.save(brand));
    }

    public BrandDTO update(BrandDTO brandDTO) {
        Optional<Brand> brand = this.brandRepository.findById(brandDTO.getId());

        if (brand.isPresent()) {
            Brand saved = this.brandRepository.save(brand.get());
            return BrandDTO.from(saved);
        } else {
            throw new ResourceNotFoundException(String.format("ID: %d 인 아이템은 존재하지  않습니다. ", brandDTO.getId()));
        }
    }

    public BrandDTO delete(Long id) {
        Optional<Brand> brand = this.brandRepository.findById(id);
        if (brand.isPresent()) {
            Brand deleted = brand.get();
            deleted.setDeleted(true);

            this.brandRepository.save(deleted);
            return BrandDTO.from(deleted);
        } else {
            throw new ResourceNotFoundException(String.format("ID: %d 인 아이템은 존재하지  않습니다. ", id));
        }
    }
}
