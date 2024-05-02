package com.study.cloud.service.impl;

import com.study.cloud.entities.Pay;
import com.study.cloud.mapper.PayMapper;
import com.study.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李京霖
 * @version 2024/5/2 2:11 1.0
 */

@Service
public class PayServiceImpl implements PayService {


    @Resource
    private PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKeySelective(pay);
    }

    @Override
    public Pay getById(Integer id) {
        Pay pay = payMapper.selectByPrimaryKey(id);
        if (pay == null) {
            throw new RuntimeException("查询失败");
        }
        return pay;
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
