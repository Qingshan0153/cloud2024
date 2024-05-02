package com.study.cloud.service;

import com.study.cloud.entities.Pay;

import java.util.List;

/**
 * @author 李京霖
 * @version 2024/5/2 2:09 1.0
 */
public interface PayService {
    int add(Pay pay);

    int delete(Integer id);

    int update(Pay pay);

    Pay getById(Integer id);

    List<Pay> getAll();
}
