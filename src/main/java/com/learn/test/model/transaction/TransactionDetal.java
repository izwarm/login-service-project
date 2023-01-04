package com.learn.test.model.transaction;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "transaction_detail")
public class TransactionDetal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionDetailId;

    private Long transactionId;

    private String itemCode;

    private String itemName;

    private Integer quantity;

    private BigDecimal price;

}
