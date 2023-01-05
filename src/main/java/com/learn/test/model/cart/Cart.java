package com.learn.test.model.cart;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;

    private String itemCode;

    private String itemName;

    private Integer quantity;

    private BigDecimal price;

    private LocalDate createAt;

    private Long createBy;

    private Integer deleted;

    private Boolean isActive;

}
