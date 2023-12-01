package com.musinsa.coordinator.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.musinsa.coordinator.dto.BrandDTO;
import com.musinsa.coordinator.entity.Brand;
import com.musinsa.coordinator.repository.BrandRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandService brandService;

    @Test
    void testInsertBrand() {
        // given
        BrandDTO brandDTO = new BrandDTO();
        Brand brand = brandDTO.convertToBrand();

        when(this.brandRepository.save(any(Brand.class))).thenReturn(brand);

        // when
        BrandDTO result = this.brandService.insertBrand(brandDTO);

        // then
        assertNotNull(result);
    }

    @Test
    void testUpdate() {
        // given
        Long brandId = 1L;
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setId(brandId);
        Brand existingBrand = new Brand();
        existingBrand.setId(brandId);

        when(this.brandRepository.findById(brandId)).thenReturn(Optional.of(existingBrand));
        when(this.brandRepository.save(any(Brand.class))).thenReturn(existingBrand);

        // when
        BrandDTO result = this.brandService.update(brandDTO);

        // then
        assertNotNull(result);
    }

    @Test
    void testDelete() {
        // given
        Long brandId = 1L;
        Brand existingBrand = new Brand();
        existingBrand.setId(brandId);

        when(this.brandRepository.findById(brandId)).thenReturn(Optional.of(existingBrand));
        when(this.brandRepository.save(any(Brand.class))).thenReturn(existingBrand);

        // when
        BrandDTO result = this.brandService.delete(brandId);

        // then
        assertNotNull(result);
        assertTrue(existingBrand.isDeleted());
    }
}
