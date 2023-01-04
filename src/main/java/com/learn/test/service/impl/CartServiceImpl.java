package com.learn.test.service.impl;

import com.learn.test.model.cart.Cart;
import com.learn.test.model.item.Item;
import com.learn.test.model.request.ItemRequestDTO;
import com.learn.test.repo.CartRepository;
import com.learn.test.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;


    @Override
    public Cart addItemToCart(Item item, ItemRequestDTO itemRequestDTO) {
        Cart cart = new Cart();
        if (itemRequestDTO.getItemName() != null) {
            cart.setItemName(item.getItemName());
        }
        if (itemRequestDTO.getItemCode() != null) {
            cart.setItemCode(item.getItemCode());
        }
        if (itemRequestDTO.getQuantity() != 0) {
            cart.setQuantity(item.getQuantity());
        }
        if (itemRequestDTO.getPrice() != null) {
            cart.setPrice(item.getPrice());
        }

        cart = cartRepository.save(cart);
        return cart;
    }
}
