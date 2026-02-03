package com.my.springcloud.controller;

import com.my.springcloud.pojo.entity.Pay;
import com.my.springcloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2025/3/4 17:08
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "支付微服务模块",description = "支付CRUD")
@RequestMapping("/pay")
public class PayController {

      @Value("${server.port}")
      private String port;

      private final PayService payService;

      @GetMapping(value = "/get/port")
      private String getPort() {
            try {
                  TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                  e.printStackTrace();
            }
            return "port: " + port;
      }
      @PostMapping("/add")
      @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
      public String addPay(@RequestBody Pay pay) {
            int i = payService.add(pay);
            return "成功插入记录，返回值：" + i;
      }

      @DeleteMapping("/del/{id}")
      @Operation(summary = "删除",description = "删除支付流水方法")
      public Integer deletePay(@PathVariable("id") Integer id) {
            return payService.delete(id);
      }

      @PutMapping("/update")
      @Operation(summary = "修改",description = "修改支付流水方法")
      public String updatePay(@RequestBody Pay pay) {
            int i = payService.update(pay);
            return "成功修改记录，返回值：" + i;
      }

      @GetMapping("/get/{id}")
      @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
      public Pay getById(@PathVariable("id") Integer id) {
            Pay pay = payService.getById(id);
            log.info("pay: {}", pay);
            if (id == -4) throw new RuntimeException("id 不能是负数");
            return pay;
      }

      @GetMapping("/get-all")
      @Operation(summary = "查询全部流水",description = "查询支付流水方法")
      public List<Pay> getAll() {
            return payService.getAll();
      }

}
