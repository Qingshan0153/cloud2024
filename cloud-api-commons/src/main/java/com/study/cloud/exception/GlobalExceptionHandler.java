package com.study.cloud.exception;

import com.study.cloud.common.ResultData;
import com.study.cloud.common.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 李京霖
 * @version 2024/5/2 17:39 1.0
 */


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理运行时异常的全局异常处理器。
     * 使用@ExceptionHandler注解指定处理所有运行时异常（RuntimeException.class）。
     * ResponseStatus注解指定了返回的HTTP状态码为500（INTERNAL_SERVER_ERROR）。
     *
     * @param e 发生的异常对象
     * @return 返回一个包含异常信息的结果对象ResultData<String>。其中，结果状态为失败，
     * 错误代码为RC500，错误信息为异常对象的getMessage()返回值。
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> exception(Exception e) {
        // 打印进入全局异常处理器的信息
        System.out.println("----come in GlobalExceptionHandler");
        // 记录异常信息到日志
        log.error("全局异常信息exception:{}", e.getMessage(), e);
        // 返回一个表示异常结果的数据对象
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}
