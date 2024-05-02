package com.study.cloud.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 李京霖
 * @version 2024/5/2 2:06 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO implements Serializable {
    private Integer id;
    /**
     * 支付流水号
     */
    private String payNo;
    /**
     * 订单流水号
     */
    private String orderNo;
    /**
     * 用户账号ID
     */
    private Integer userId;
    /**
     * 交易金额
     */
    private BigDecimal amount;
}

