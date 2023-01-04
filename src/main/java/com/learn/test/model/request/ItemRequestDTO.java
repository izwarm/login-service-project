package com.learn.test.model.request;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ItemRequestDTO {

    private long itemId;

    private String itemName;

    private String itemCode;

    private Integer quantity;

    private BigDecimal price;

    private LocalDate createAt;

    private Integer deleted;

    private Long deletedBy;

    private Long usersId;

    private LocalDate updateAt;

}
