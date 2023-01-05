package com.learn.test.controller;

import com.learn.test.model.item.Item;
import com.learn.test.model.request.ItemRequestDTO;
import com.learn.test.model.response.APIResponse;
import com.learn.test.service.CartService;
import com.learn.test.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cart")
public class CartController {

    private final CartService cartService;

    private final ItemService itemService;

    @PostMapping("/add-cart")
    public ResponseEntity<APIResponse> addItemToCart(@RequestBody ItemRequestDTO itemRequestDTO) {

        Item item = itemService.getItemByItemCode(itemRequestDTO.getItemCode());

        APIResponse apiResponse = cartService.addItemToCart(item);
        return ResponseEntity
                .status((int) apiResponse.getStatus())
                .body(apiResponse);
    }

    @PostMapping("/checkout")
    public ResponseEntity<APIResponse> checkout(@RequestParam("userId") Long userId) {
        APIResponse apiResponse = cartService.checkout(userId);
        return ResponseEntity
                .status((int) apiResponse.getStatus())
                .body(apiResponse);
    }

}
