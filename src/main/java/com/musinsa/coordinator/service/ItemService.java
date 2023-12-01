package com.musinsa.coordinator.service;

import com.musinsa.coordinator.dto.ItemDTO;
import com.musinsa.coordinator.entity.Item;
import com.musinsa.coordinator.exception.ResourceNotFoundException;
import com.musinsa.coordinator.repository.ItemRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemDTO insertItem(ItemDTO itemDTO) {
        Item item = itemDTO.convertToItem();

        return ItemDTO.from(this.itemRepository.save(item));
    }

    public ItemDTO update(ItemDTO itemDTO) {
        Optional<Item> item = this.itemRepository.findById(itemDTO.getId());

        if (item.isPresent()) {
            Item saved = this.itemRepository.save(item.get());
            return ItemDTO.from(saved);
        } else {
            throw new ResourceNotFoundException(String.format("ID: %d 인 아이템은 존재하지  않습니다. ", itemDTO.getId()));
        }
    }

    public ItemDTO delete(Long id) {
        Optional<Item> item = this.itemRepository.findById(id);
        if (item.isPresent()) {
            Item deleted = item.get();
            deleted.setDeleted(true);

            this.itemRepository.save(deleted);
            return ItemDTO.from(deleted);
        } else {
            throw new ResourceNotFoundException(String.format("ID: %d 인 아이템은 존재하지  않습니다. ", id));
        }
    }
}
