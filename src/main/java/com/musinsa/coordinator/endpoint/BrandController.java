package com.musinsa.coordinator.endpoint;

import com.musinsa.coordinator.dto.BrandDTO;
import com.musinsa.coordinator.endpoint.request.BrandRequest;
import com.musinsa.coordinator.endpoint.response.ErrorResponse;
import com.musinsa.coordinator.service.BrandService;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController {
    BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping("/brand/insert")
    public ResponseEntity<?> insert(BrandRequest brandRequest) {
        try {
            BrandDTO brand = this.brandService.insertBrand(BrandDTO.from(brandRequest));
            return ResponseEntity.ok(brand);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("DB_INSERT_FAIL", String.format("%s 생성에 실패했습니다.", brandRequest.toString()), LocalDateTime.now()));
        }
    }

    @PutMapping("/brand/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BrandRequest updateRequest) {
        try {
            BrandDTO updated = this.brandService.update(BrandDTO.from(id, updateRequest));
            return ResponseEntity.ok().body(String.format("Brand updated successfully. '%s'", updated));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("NOT_FOUND_RESOURCE", e.getMessage(), LocalDateTime.now()));
        }
    }

    @GetMapping("/brand/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            BrandDTO brand = this.brandService.delete(id);
            return ResponseEntity.ok(brand);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("DB_INSERT_FAIL", e.getMessage(), LocalDateTime.now()));
        }
    }
}
