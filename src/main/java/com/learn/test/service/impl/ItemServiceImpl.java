package com.learn.test.service.impl;

import com.learn.test.model.item.Item;
import com.learn.test.model.request.ItemRequestDTO;
import com.learn.test.model.response.APIResponse;
import com.learn.test.repo.ItemRepository;
import com.learn.test.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Item addItem(ItemRequestDTO itemRequestDTO) {
        Item entity = new Item();
        entity.setItemName(itemRequestDTO.getItemName());
        entity.setItemCode(itemRequestDTO.getItemCode());
        entity.setQuantity(itemRequestDTO.getQuantity());
        entity.setPrice(itemRequestDTO.getPrice());
        entity.setCreateAt(LocalDate.now());
        entity.setCreateBy(itemRequestDTO.getUsersId());
        entity.setDeleted(0);
        return itemRepository.save(entity);
    }

    @Override
    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(String itemCode, Long createBy) {
        return itemRepository.findByItemCodeAndCreateBy(itemCode, createBy);
    }

    @Override
    public APIResponse editItem(Item item, ItemRequestDTO itemRequestDTO) {

        if (itemRequestDTO.getItemName() != null) {
            item.setItemName(itemRequestDTO.getItemName());
        }
        if (itemRequestDTO.getItemCode() != null) {
            item.setItemCode(item.getItemCode());
        }
        if (itemRequestDTO.getQuantity() != 0) {
            item.setQuantity(itemRequestDTO.getQuantity());
        }
        if (itemRequestDTO.getPrice() != BigDecimal.ZERO) {
            item.setPrice(itemRequestDTO.getPrice());
        }
        if (itemRequestDTO.getCreateAt() != null) {
            item.setUpdateAT(itemRequestDTO.getUpdateAt());
        }
        item = itemRepository.save(item);

        APIResponse add = new APIResponse();

        add.setStatus(HttpStatus.OK.value());
        add.setResponseData(item);

        return add;
    }

    @Override
    public APIResponse deleteItemByItemCode(String itemCode, Long deletedBy) {
        Item item = new Item();
        item.setDeleted(1);
        item.setDeletedBy(deletedBy);

        item = itemRepository.save(item);

        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setResponseData(item);
        return apiResponse;
    }

    @Override
    public Item getItemByItemCode(String itemCode) {
        return itemRepository.findByItemCode(itemCode);
    }
}
