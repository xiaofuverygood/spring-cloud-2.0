package com.my.springcloud.controller;

import com.my.springcloud.pojo.dto.PayDTO;
import com.my.springcloud.result.ResponseResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
      public static final String PAYMENT_URL = "http://cloud-payment-service";

      private final RestTemplate restTemplate;

      @GetMapping(value = "/pay/get/port")
      private ResponseResult getPort() {
            return restTemplate.getForObject(PAYMENT_URL + "/pay/get/port", ResponseResult.class);
      }

      @GetMapping("/pay/get/{id}")
      public ResponseResult getPayInfo(@PathVariable("id") Integer id) {
            return restTemplate.getForObject(PAYMENT_URL + "/pay/get/" + id, ResponseResult.class, id);
      }

      /**
       * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
       * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
       * 参数可以不添加@RequestBody
       */
      @GetMapping("/pay/add")
      public ResponseResult addOrder(PayDTO payDTO) {
            log.info("request payment dto: {}", payDTO);
            return restTemplate.postForObject(PAYMENT_URL + "/pay/add", payDTO, ResponseResult.class);
      }
}
