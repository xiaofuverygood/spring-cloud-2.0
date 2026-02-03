package com.my.springcloud.controller;

import com.my.springcloud.apis.RemotePayApi;
import com.my.springcloud.result.ResponseResult;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2025/3/22 13:27
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/circuit")
public class OrderCircuitController {

      private final RemotePayApi remotePayApi;

      @GetMapping(value = "/{id}")
      @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "circuitFallback")
      public ResponseResult circuitBreaker(@PathVariable("id") Integer id) {
            return remotePayApi.circuit(id);
      }

      // 服务降级处理方法
      public ResponseResult circuitFallback(Integer id, Throwable t) {
            System.out.println(t.getMessage());
            return ResponseResult.fail("系统繁忙, 请稍后再试");
      }
}
