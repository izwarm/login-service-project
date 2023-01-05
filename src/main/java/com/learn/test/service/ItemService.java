package com.learn.test.service;

import com.learn.test.model.item.Item;
import com.learn.test.model.request.ItemRequestDTO;
import com.learn.test.model.response.APIResponse;

import java.util.List;

public interface ItemService {


    Item addItem(ItemRequestDTO itemRequestDTO);

    List<Item> findAllItem();

    Item getItemById(String itemCode, Long createBy);

    APIResponse editItem(Item item, ItemRequestDTO itemRequestDTO);

    APIResponse deleteItemByItemCode(String itemCode, Long deletedBy);

    Item getItemByItemCode(String itemCode);

    List<Item> findAllItemByUser(Long userId);
}
