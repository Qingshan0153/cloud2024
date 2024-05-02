package com.study.cloud.contorller;

import com.study.cloud.common.ResultData;
import com.study.cloud.entities.dto.PayDTO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 李京霖
 * @version 2024/5/2 18:00 1.0
 */
@RestController
public class OrderController {
    /**
     * 先写死，硬编码
     */
    public static final String PaymentSrv_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     *
     * @param payDTO payDTO
     * @return ResultData 返回一个包含支付信息的结果对象。
     */
    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    /**
     * 通过指定的支付ID获取支付信息。
     *
     * @param id 支付的唯一标识符，从URL路径变量中获取。
     * @return ResultData 返回一个包含支付信息的结果对象。
     */
    @GetMapping("/consumer/pay/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        // 通过REST模板向支付服务查询支付信息
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/" + id, ResultData.class, id);
    }


}
