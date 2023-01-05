package com.learn.test.repo;

import com.learn.test.model.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByItemCodeAndCreateBy(String itemCode, Long createBy);

    Item findByItemCode(String itemCode);

    @Query("from Item i where i.createBy = :userId ")
    List<Item> getAllItemByUserId(@Param("userId") Long userId);
}
