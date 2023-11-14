package com.musinsa.coordinator.service;

import com.musinsa.coordinator.dto.BrandItemsSummaryDTO;
import com.musinsa.coordinator.dto.BrandPriceDTO;
import com.musinsa.coordinator.dto.CategoryItemsSummaryDTO;
import com.musinsa.coordinator.entity.Item;
import com.musinsa.coordinator.repository.ItemRepository;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CoordinatorService {

    ItemRepository itemRepository;

    public CoordinatorService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getLowestCategoryItems() {
        List<Item> minPricedItemInEachCategory = this.itemRepository.findItemsWithMinPriceByCategory();

        if (minPricedItemInEachCategory == null || minPricedItemInEachCategory.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        return minPricedItemInEachCategory;
    }

    public BrandItemsSummaryDTO getLowestBrandItems() {
        List<Item> items = this.itemRepository.findItemsWithMinTotalPriceByBrand();
        BrandItemsSummaryDTO summary = new BrandItemsSummaryDTO();
        items.forEach(summary::addItems);
        return summary;
    }

    public CategoryItemsSummaryDTO getMinMaxCategoryItems(String category) {
        CategoryItemsSummaryDTO summary = new CategoryItemsSummaryDTO();
        List<Item> maxPricedItems = this.itemRepository.findItemsWithMaxPriceByCategory(category);
        List<Item> minPricedItems = this.itemRepository.findItemsWithMinPriceByCategory(category);

        summary.setCategory(category);
        summary.setMaxPricedItems(maxPricedItems.stream().map(BrandPriceDTO::new).collect(Collectors.toList()));
        summary.setMinPricedItems(minPricedItems.stream().map(BrandPriceDTO::new).collect(Collectors.toList()));
        return summary;
    }
}
