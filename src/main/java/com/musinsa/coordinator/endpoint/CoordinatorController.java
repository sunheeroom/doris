package com.musinsa.coordinator.endpoint;

import com.musinsa.coordinator.dto.BrandItemsSummaryDTO;
import com.musinsa.coordinator.dto.CategoryItemsSummaryDTO;
import com.musinsa.coordinator.entity.Item;
import com.musinsa.coordinator.service.CoordinatorService;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoordinatorController {
    CoordinatorService coordinatorService;

    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @GetMapping("/coordinate/lowest/price")
    public ResponseEntity<List<Item>> getLowestCoordination() {
        List<Item> lowestCategoryItems = this.coordinatorService.getLowestCategoryItems();
        if (lowestCategoryItems.isEmpty()) {
            ResponseEntity.noContent(); // TODO ERROR CODE 정의
        }
        return ResponseEntity.ok(lowestCategoryItems);
    }

    @GetMapping("/coordinate/lowest/brand/")
    public ResponseEntity<BrandItemsSummaryDTO> getLowestCoordinationBrand() {
        BrandItemsSummaryDTO lowestBrandItems = this.coordinatorService.getLowestBrandItems();
        return ResponseEntity.ok(lowestBrandItems);
    }

    @GetMapping("/coordinate/category/items")
    public ResponseEntity<CategoryItemsSummaryDTO> getCategoryItemsSummary(@Param("category") String category
    ) {
        CategoryItemsSummaryDTO summary = this.coordinatorService.getMinMaxCategoryItems(category);
        return ResponseEntity.ok(summary);
    }
}
