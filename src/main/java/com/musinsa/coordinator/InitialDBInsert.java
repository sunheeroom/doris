package com.musinsa.coordinator;

import com.musinsa.coordinator.entity.Item;
import com.musinsa.coordinator.repository.ItemRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialDBInsert implements CommandLineRunner {
    private final ItemRepository itemRepository;

    public InitialDBInsert(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Item> items = List.of(
            new Item("A", "top", 11200, false),
            new Item("A", "outer", 5500, false),
            new Item("A", "bottom", 4200, false),
            new Item("A", "shoes", 9000, false),
            new Item("A", "bag", 2000, false),
            new Item("A", "hat", 1700, false),
            new Item("A", "socks", 1800, false),
            new Item("A", "accessory", 2300, false),
            new Item("B", "top", 10500, false),
            new Item("B", "outer", 5900, false),
            new Item("B", "bottom", 3800, false),
            new Item("B", "shoes", 9100, false),
            new Item("B", "bag", 2100, false),
            new Item("B", "hat", 2000, false),
            new Item("B", "socks", 2000, false),
            new Item("B", "accessory", 2200, false),
            new Item("C", "top", 10000, false),
            new Item("C", "outer", 6200, false),
            new Item("C", "bottom", 3300, false),
            new Item("C", "shoes", 9200, false),
            new Item("C", "bag", 2200, false),
            new Item("C", "hat", 1900, false),
            new Item("C", "socks", 2200, false),
            new Item("C", "accessory", 2100, false),
            new Item("D", "top", 10100, false),
            new Item("D", "outer", 5100, false),
            new Item("D", "bottom", 3000, false),
            new Item("D", "shoes", 9500, false),
            new Item("D", "bag", 2500, false),
            new Item("D", "hat", 1500, false),
            new Item("D", "socks", 2400, false),
            new Item("D", "accessory", 2000, false),
            new Item("E", "top", 10700, false),
            new Item("E", "outer", 5000, false),
            new Item("E", "bottom", 3800, false),
            new Item("E", "shoes", 9900, false),
            new Item("E", "bag", 2300, false),
            new Item("E", "hat", 1800, false),
            new Item("E", "socks", 2100, false),
            new Item("E", "accessory", 2100, false),
            new Item("F", "top", 11200, false),
            new Item("F", "outer", 7200, false),
            new Item("F", "bottom", 4000, false),
            new Item("F", "shoes", 9300, false),
            new Item("F", "bag", 2100, false),
            new Item("F", "hat", 1600, false),
            new Item("F", "socks", 2300, false),
            new Item("F", "accessory", 1900, false),
            new Item("G", "top", 10500, false),
            new Item("G", "outer", 5800, false),
            new Item("G", "bottom", 3900, false),
            new Item("G", "shoes", 9000, false),
            new Item("G", "bag", 2200, false),
            new Item("G", "hat", 1700, false),
            new Item("G", "socks", 2100, false),
            new Item("G", "accessory", 2000, false),
            new Item("H", "top", 10800, false),
            new Item("H", "outer", 6300, false),
            new Item("H", "bottom", 3100, false),
            new Item("H", "shoes", 9700, false),
            new Item("H", "bag", 2100, false),
            new Item("H", "hat", 1600, false),
            new Item("H", "socks", 2000, false),
            new Item("H", "accessory", 2000, false),
            new Item("I", "top", 11400, false),
            new Item("I", "outer", 6700, false),
            new Item("I", "bottom", 3200, false),
            new Item("I", "shoes", 9500, false),
            new Item("I", "bag", 2400, false),
            new Item("I", "hat", 1700, false),
            new Item("I", "socks", 1700, false),
            new Item("I", "accessory", 2400, false)
        );

        this.itemRepository.saveAll(items);
    }
}
