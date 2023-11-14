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
            new Item("A", "top", 11200),
            new Item("A", "outer", 5500),
            new Item("A", "bottom", 4200),
            new Item("A", "shoes", 9000),
            new Item("A", "bag", 2000),
            new Item("A", "hat", 1700),
            new Item("A", "socks", 1800),
            new Item("A", "accessory", 2300),
            new Item("B", "top", 10500),
            new Item("B", "outer", 5900),
            new Item("B", "bottom", 3800),
            new Item("B", "shoes", 9100),
            new Item("B", "bag", 2100),
            new Item("B", "hat", 2000),
            new Item("B", "socks", 2000),
            new Item("B", "accessory", 2200),
            new Item("C", "top", 10000),
            new Item("C", "outer", 6200),
            new Item("C", "bottom", 3300),
            new Item("C", "shoes", 9200),
            new Item("C", "bag", 2200),
            new Item("C", "hat", 1900),
            new Item("C", "socks", 2200),
            new Item("C", "accessory", 2100),
            new Item("D", "top", 10100),
            new Item("D", "outer", 5100),
            new Item("D", "bottom", 3000),
            new Item("D", "shoes", 9500),
            new Item("D", "bag", 2500),
            new Item("D", "hat", 1500),
            new Item("D", "socks", 2400),
            new Item("D", "accessory", 2000),
            new Item("E", "top", 10700),
            new Item("E", "outer", 5000),
            new Item("E", "bottom", 3800),
            new Item("E", "shoes", 9900),
            new Item("E", "bag", 2300),
            new Item("E", "hat", 1800),
            new Item("E", "socks", 2100),
            new Item("E", "accessory", 2100),
            new Item("F", "top", 11200),
            new Item("F", "outer", 7200),
            new Item("F", "bottom", 4000),
            new Item("F", "shoes", 9300),
            new Item("F", "bag", 2100),
            new Item("F", "hat", 1600),
            new Item("F", "socks", 2300),
            new Item("F", "accessory", 1900),
            new Item("G", "top", 10500),
            new Item("G", "outer", 5800),
            new Item("G", "bottom", 3900),
            new Item("G", "shoes", 9000),
            new Item("G", "bag", 2200),
            new Item("G", "hat", 1700),
            new Item("G", "socks", 2100),
            new Item("G", "accessory", 2000),
            new Item("H", "top", 10800),
            new Item("H", "outer", 6300),
            new Item("H", "bottom", 3100),
            new Item("H", "shoes", 9700),
            new Item("H", "bag", 2100),
            new Item("H", "hat", 1600),
            new Item("H", "socks", 2000),
            new Item("H", "accessory", 2000),
            new Item("I", "top", 11400),
            new Item("I", "outer", 6700),
            new Item("I", "bottom", 3200),
            new Item("I", "shoes", 9500),
            new Item("I", "bag", 2400),
            new Item("I", "hat", 1700),
            new Item("I", "socks", 1700),
            new Item("I", "accessory", 2400)
        );

        this.itemRepository.saveAll(items);
    }
}
