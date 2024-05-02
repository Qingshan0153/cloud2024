package com.study.cloud.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
 * 表名：t_pay
 * 表注释：支付交易表
 * @author mendax
 */
@Table(name = "t_pay")
@Data
@Schema(description = "支付交易表")
public class Pay {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 支付流水号
     */
    @Column(name = "pay_no")
    @Schema(description = "支付流水号")
    private String payNo;

    /**
     * 订单流水号
     */
    @Column(name = "order_no")
    private String orderNo;

    /**
     * 用户账号ID
     */
    @Column(name = "user_id")
    @Schema(description = "用户账号ID")
    private Integer userId;

    /**
     * 交易金额
     */
    @Schema(description = "交易金额")
    private BigDecimal amount;

    /**
     * 删除标志，默认0不删除，1删除
     */
    private Byte deleted;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}