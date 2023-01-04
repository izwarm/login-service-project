package com.learn.test.controller;

import com.learn.test.model.cart.Cart;
import com.learn.test.model.item.Item;
import com.learn.test.model.request.ItemRequestDTO;
import com.learn.test.service.CartService;
import com.learn.test.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    private final ItemService itemService;

    @PostMapping
    public Cart addItemToCart(@RequestBody ItemRequestDTO itemRequestDTO) {

        Item item = itemService.getItemByItemCode(itemRequestDTO.getItemCode());

        Cart cart = cartService.addItemToCart(item, itemRequestDTO);

        return cart;
    }
}
