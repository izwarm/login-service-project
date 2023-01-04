package com.learn.test.model.item;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long itemId;

    private String itemName;

    private String itemCode;

    private Integer quantity;

    private BigDecimal price;

    private LocalDate createAt;

    private LocalDate updateAT;

    private Long createBy;

    private Integer deleted;

    private Long deletedBy;
}
