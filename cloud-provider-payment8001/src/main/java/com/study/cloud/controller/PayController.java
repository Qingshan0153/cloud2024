package com.study.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.study.cloud.common.ResultData;
import com.study.cloud.entities.Pay;
import com.study.cloud.entities.dto.PayDTO;
import com.study.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 李京霖
 * @version 2024/5/2 2:15 1.0
 */


@Slf4j
@RestController
@RequestMapping("/pay")
@Tag(name = "支付接口", description = "支付接口")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/add")
    @Operation(summary = "添加支付信息", description = "添加支付信息")
    public ResultData<String> add(@RequestBody Pay pay) {
        int add = payService.add(pay);
        return ResultData.success(add + "");
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "删除支付信息", description = "删除支付信息")
    public ResultData<String> delete(@PathVariable("id") Integer id) {

        int delete = payService.delete(id);
        return ResultData.success(delete + "");
    }

    @PutMapping("/update")
    @Operation(summary = "更新支付信息", description = "更新支付信息")
    public ResultData<String> update(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO, pay);
        int update = payService.update(pay);
        return ResultData.success(update + "");
    }

    @GetMapping("/{id}")
    @Operation(summary = "根据id查询支付信息", description = "根据id查询支付信息")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }


    @GetMapping("/list")
    @Operation(summary = "查询所有支付信息", description = "查询所有支付信息")
    public ResultData<List<Pay>> getAll() {
        List<Pay> list = payService.getAll();
        return ResultData.success(list);
    }


    @Value("${server.port}")
    private String port;

    @GetMapping("/lb")
    @Operation(summary = "负载均衡测试", description = "负载均衡测试")
    public String loadBalance(@Value("${spring.application.name}") String info) {
        log.info("info:" + info + "port:" + port);
        return "info:" + info + "\tport:" + port;
    }
}
