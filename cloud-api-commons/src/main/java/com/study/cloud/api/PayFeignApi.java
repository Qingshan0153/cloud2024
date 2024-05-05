package com.study.cloud.api;

import com.study.cloud.common.ResultData;
import com.study.cloud.entities.dto.PayDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 李京霖
 * @version 2024/5/3 1:44 1.0
 */

@FeignClient(value = "cloud-payment-service")
public interface PayFeignApi {

    @PostMapping("/pay/add")
    ResultData<String> add(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/{id}")
    ResultData<PayDTO> getById(@PathVariable("id") Integer id);

    @GetMapping("/pay/lb")
    String loadBalance();
}
