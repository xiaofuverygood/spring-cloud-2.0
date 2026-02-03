package com.my.springcloud.apis;

import com.my.springcloud.pojo.dto.PayDTO;
import com.my.springcloud.result.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2025/3/21 16:33
 */
@FeignClient(value = "cloud-payment-service")
public interface RemotePayApi {

      @GetMapping(value = "/pay/get/port")
      ResponseResult<String> getPort();

      @GetMapping("/pay/get/{id}")
      ResponseResult getPayInfo(@PathVariable("id") Integer id);

      @PostMapping("/pay/add")
      ResponseResult addPay(@RequestBody PayDTO payDTO);

      @GetMapping("/circuit/{id}")
      ResponseResult circuit(@PathVariable("id") Integer id);
}
