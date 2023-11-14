package com.musinsa.coordinator.repository;

import com.musinsa.coordinator.entity.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT item "
        + "FROM Item item "
        + "WHERE (item.category, item.price) IN ("
        + "     SELECT i.category, min(i.price) "
        + "     FROM Item i"
        + "     GROUP BY i.category)")

    public List<Item> findMinPricedItemInEachCategory();
}
