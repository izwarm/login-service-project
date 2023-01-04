package com.learn.test.service;

import com.learn.test.model.cart.Cart;
import com.learn.test.model.item.Item;
import com.learn.test.model.request.ItemRequestDTO;

public interface CartService {
    Cart addItemToCart(Item item, ItemRequestDTO itemRequestDTO);
}
