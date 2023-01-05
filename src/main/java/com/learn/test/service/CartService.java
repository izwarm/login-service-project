package com.learn.test.service;

import com.learn.test.model.item.Item;
import com.learn.test.model.response.APIResponse;

public interface CartService {
    APIResponse addItemToCart(Item item);

    APIResponse checkout(Long userId);
}
