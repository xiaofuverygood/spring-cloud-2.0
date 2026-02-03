package com.my.springcloud.controller;

import com.my.springcloud.result.ResponseResult;
import com.my.springcloud.apis.RemotePayApi;
import com.my.springcloud.pojo.dto.PayDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2025/3/19 14:19
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

      private final RemotePayApi remotePayApi;

      @GetMapping(value = "/pay/get/port")
      private Object getPort() {
            return remotePayApi.getPort();
      }

      @GetMapping("/pay/get/{id}")
      public ResponseResult getPayInfo(@PathVariable("id") Integer id) {
            return remotePayApi.getPayInfo(id);
      }

      /**
       * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
       * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
       * 参数可以不添加@RequestBody
       */
      @GetMapping("/pay/add")
      public ResponseResult addOrder(@RequestBody PayDTO payDTO) {
            return remotePayApi.addPay(payDTO);
      }
}
