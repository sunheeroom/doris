package com.musinsa.coordinator.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.musinsa.coordinator.dto.ItemDTO;
import com.musinsa.coordinator.entity.Item;
import com.musinsa.coordinator.repository.ItemRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemServiceTest {
    @Mock
    private ItemRepository itemRepository;
    @InjectMocks
    private ItemService itemService;

    @Test
    void testInsertItem() {
        // given
        ItemDTO itemDTO = new ItemDTO();
        Item item = itemDTO.convertToItem();

        when(this.itemRepository.save(any(Item.class))).thenReturn(item);

        // when
        ItemDTO result = this.itemService.insertItem(itemDTO);

        // then
        assertNotNull(result);
    }

    @Test
    void testUpdate() {
        // given
        Long itemId = 1L;
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(itemId);
        Item existingItem = new Item();
        existingItem.setId(itemId);

        when(this.itemRepository.findById(itemId)).thenReturn(Optional.of(existingItem));
        when(this.itemRepository.save(any(Item.class))).thenReturn(existingItem);

        // when
        ItemDTO result = this.itemService.update(itemDTO);

        // then
        assertNotNull(result);
    }

    @Test
    void testDelete() {
        // given
        Long itemId = 1L;
        Item existingItem = new Item();
        existingItem.setId(itemId);

        when(this.itemRepository.findById(itemId)).thenReturn(Optional.of(existingItem));
        when(this.itemRepository.save(any(Item.class))).thenReturn(existingItem);

        // when
        ItemDTO result = this.itemService.delete(itemId);

        // then
        assertNotNull(result);
        assertTrue(existingItem.isDeleted());
    }
}
