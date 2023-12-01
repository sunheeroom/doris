package com.musinsa.coordinator.endpoint;

import com.musinsa.coordinator.dto.ItemDTO;
import com.musinsa.coordinator.endpoint.request.ItemRequest;
import com.musinsa.coordinator.endpoint.response.ErrorResponse;
import com.musinsa.coordinator.service.ItemService;
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
public class ItemController {
    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/item/insert")
    public ResponseEntity<?> insert(ItemRequest itemRequest) {
        itemRequest.validate();

        try {
            ItemDTO item = this.itemService.insertItem(ItemDTO.from(itemRequest));
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("DB_INSERT_FAIL", String.format("%s 생성에 실패했습니다.", itemRequest.toString()), LocalDateTime.now()));
        }
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ItemRequest updateRequest) {
        try {
            ItemDTO updated = this.itemService.update(ItemDTO.from(id, updateRequest));
            return ResponseEntity.ok().body(String.format("Item updated successfully. '%s'", updated));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse("NOT_FOUND_RESOURCE", e.getMessage(), LocalDateTime.now()));
        }
    }

    @GetMapping("/item/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            ItemDTO item = this.itemService.delete(id);
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("DB_INSERT_FAIL", e.getMessage(), LocalDateTime.now()));
        }
    }
}
