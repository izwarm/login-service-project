package com.learn.test.service.impl;

import com.learn.test.model.cart.Cart;
import com.learn.test.model.item.Item;
import com.learn.test.model.response.APIResponse;
import com.learn.test.model.response.ResponseStatus;
import com.learn.test.model.transaction.Transaction;
import com.learn.test.repo.CartRepository;
import com.learn.test.repo.TransactionRepository;
import com.learn.test.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final TransactionRepository transactionRepository;


    @Override
    public APIResponse addItemToCart(Item item) {
        APIResponse apiResponse = new APIResponse();
        Cart cart = new Cart();
        cart.setItemName(item.getItemName());
        cart.setItemCode(item.getItemCode());
        cart.setQuantity(item.getQuantity());
        cart.setCreateAt(LocalDate.now());
        BigDecimal totalPrice = BigDecimal.valueOf(cart.getQuantity()).multiply(item.getPrice());
        cart.setPrice(totalPrice);
        cart.setCreateBy(item.getCreateBy());
        cart.setIsActive(Boolean.TRUE);
        cart = cartRepository.save(cart);

        apiResponse.setStatus(ResponseStatus.HTTP_STATUS_OK.getStatusCode());
        apiResponse.setResponseData(cart);
        return apiResponse;
    }

    @Override
    public APIResponse checkout(Long userId) {
        APIResponse apiResponse = new APIResponse();

        Cart cart = cartRepository.findByCreateBy(userId);

        Transaction tr = new Transaction();
        tr.setUserId(userId);
        tr.setTotalQuantity(cart.getQuantity());
        tr.setTotalPrice(cart.getPrice());

        tr = transactionRepository.save(tr);

        apiResponse.setStatus(ResponseStatus.HTTP_STATUS_OK.getStatusCode());
        apiResponse.setResponseData(tr);

        return apiResponse;
    }

}
