package com.study.cloud.controller;

import com.study.cloud.api.PayFeignApi;
import com.study.cloud.common.ResultData;
import com.study.cloud.entities.dto.PayDTO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author 李京霖
 * @version 2024/5/3 2:05 1.0
 */

@RestController
@RequestMapping("/feign/pay")
public class OrderController {


    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/add")
    public ResultData<String> add(@RequestBody PayDTO payDTO){
        return payFeignApi.add(payDTO);
    }
    @GetMapping("/{id}")
    public ResultData<PayDTO> getById(@PathVariable("id") Integer id){
        return payFeignApi.getById(id);
    }

    @GetMapping("/lb")
    public ResultData<String> loadBalance(){
        return ResultData.success(payFeignApi.loadBalance());
    }
}
