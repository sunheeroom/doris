package com.musinsa.coordinator.endpoint;

import com.musinsa.coordinator.entity.Item;
import com.musinsa.coordinator.service.CoordinatorService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoordinatorController {
    CoordinatorService coordinatorService;

    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @GetMapping("/coordinate/lowest")
    public ResponseEntity<List<Item>> getLowestCoordination() {
        List<Item> lowestCategoryItems = this.coordinatorService.getLowestCategoryItems();
        return ResponseEntity.ok(lowestCategoryItems);
    }
}
