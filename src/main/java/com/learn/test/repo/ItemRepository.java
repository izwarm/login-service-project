package com.learn.test.repo;

import com.learn.test.model.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByItemCodeAndCreateBy(String itemCode, Long createBy);

    Item findByItemCode(String itemCode);

}
