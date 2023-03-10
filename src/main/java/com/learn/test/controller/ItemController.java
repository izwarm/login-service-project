package com.learn.test.controller;

import com.learn.test.model.item.Item;
import com.learn.test.model.request.ItemRequestDTO;
import com.learn.test.model.response.APIResponse;
import com.learn.test.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {


    private final ItemService itemService;

    @PostMapping("/add-item")
    public String addItem(@RequestBody ItemRequestDTO itemRequestDTO) throws Exception {
        Item item = itemService.addItem(itemRequestDTO);
        String result = "";
        if (item == null) {
            throw new Exception("Item Tidak Berhasil di tambahkan");
        } else if (item != null){
            result = "Item berhasil ditambahkan";
            return result;
        }
        return result;
    }

    @GetMapping("/list-item")
    public List<Item> listItem() {
        List<Item> list = itemService.findAllItem();
        return list;
    }

    @PutMapping("/edit/{itemCode}&={createBy}")
    public ResponseEntity<APIResponse> editItem(@PathVariable("itemCode") String itemCode,
                                                @PathVariable("createBy") Long createBy,
                                                @RequestBody ItemRequestDTO itemRequestDTO) {
        Item item = itemService.getItemById(itemCode, createBy);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        APIResponse itemResponse = itemService.editItem(item, itemRequestDTO);
        return ResponseEntity
                .status((HttpStatus) itemResponse.getStatus())
                .body(itemResponse);
    }


    @DeleteMapping("/delete/{itemCode}&={deletedBy")
    public ResponseEntity<APIResponse> deletedItem(@PathVariable("itemCode") String itemCode,
                                                   @PathVariable("deletedBy") Long deletedBy) {
        APIResponse item = itemService.deleteItemByItemCode(itemCode, deletedBy);
        return ResponseEntity
                .status((HttpStatus) item.getStatus())
                .body(item);
    }


}
