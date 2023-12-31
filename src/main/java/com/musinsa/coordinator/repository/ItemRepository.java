package com.musinsa.coordinator.repository;

import com.musinsa.coordinator.entity.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT item "
        + "FROM Item item "
        + "WHERE (item.category, item.price) IN ("
        + "     SELECT i.category, min(i.price) "
        + "     FROM Item i"
        + "     GROUP BY i.category)")
    List<Item> findItemsWithMinPriceByCategory();

    @Query("SELECT i "
        + "FROM Item i "
        + "WHERE (i.brand, i.category, i.price) IN ("
        + "     SELECT i2.brand, i2.category, MIN(i2.price) "
        + "     FROM Item i2 "
        + "     GROUP BY i2.brand, i2.category) "
        + "AND i.brand IN ("
        + "     SELECT i3.brand "
        + "     FROM Item i3 "
        + "     GROUP BY i3.brand "
        + "     ORDER BY SUM(i3.price) ASC "
        + "     LIMIT 1)")
    List<Item> findItemsWithMinTotalPriceByBrand();

    @Query("SELECT i FROM Item i WHERE i.category = :category AND i.price = (SELECT MIN(i2.price) FROM Item i2 WHERE i2.category = :category)")
    List<Item> findItemsWithMinPriceByCategory(@Param("category") String category);

    @Query("SELECT i FROM Item i WHERE i.category = :category AND i.price = (SELECT MAX(i2.price) FROM Item i2 WHERE i2.category = :category)")
    List<Item> findItemsWithMaxPriceByCategory(@Param("category") String category);
}

