package com.musinsa.coordinator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.musinsa.coordinator.dto.BrandItemsSummaryDTO;
import com.musinsa.coordinator.dto.CategoryItemsSummaryDTO;
import com.musinsa.coordinator.entity.Item;
import com.musinsa.coordinator.repository.ItemRepository;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CoordinatorServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private CoordinatorService coordinatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetLowestCategoryItems() {
        // Mock data
        List<Item> mockItems = Collections.singletonList(new Item(/*...*/));
        when(this.itemRepository.findItemsWithMinPriceByCategory()).thenReturn(mockItems);

        // Test
        List<Item> result = this.coordinatorService.getLowestCategoryItems();

        // Verify
        assertEquals(mockItems, result);
        verify(this.itemRepository, times(1)).findItemsWithMinPriceByCategory();
    }

    @Test
    void testGetLowestBrandItems() {
        // Mock data
        List<Item> mockItems = Collections.singletonList(new Item(/*...*/));
        when(this.itemRepository.findItemsWithMinTotalPriceByBrand()).thenReturn(mockItems);

        // Test
        BrandItemsSummaryDTO result = this.coordinatorService.getLowestBrandItems();

        // Verify
        assertEquals(mockItems.size(), result.getItems().size());
        verify(this.itemRepository, times(1)).findItemsWithMinTotalPriceByBrand();
    }

    @Test
    void testGetMinMaxCategoryItems() {
        // Mock data
        String category = "someCategory";
        List<Item> mockMaxPricedItems = Collections.singletonList(new Item(/*...*/));
        List<Item> mockMinPricedItems = Collections.singletonList(new Item(/*...*/));
        when(this.itemRepository.findItemsWithMaxPriceByCategory(category)).thenReturn(mockMaxPricedItems);
        when(this.itemRepository.findItemsWithMinPriceByCategory(category)).thenReturn(mockMinPricedItems);

        // Test
        CategoryItemsSummaryDTO result = this.coordinatorService.getMinMaxCategoryItems(category);

        // Verify
        assertEquals(category, result.getCategory());
        assertEquals(mockMaxPricedItems.size(), result.getMaxPricedItems().size());
        assertEquals(mockMinPricedItems.size(), result.getMinPricedItems().size());
        verify(this.itemRepository, times(1)).findItemsWithMaxPriceByCategory(category);
        verify(this.itemRepository, times(1)).findItemsWithMinPriceByCategory(category);
    }
}
