package com.my.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2025/3/22 13:09
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/circuit")
public class PayCircuitController {
      @GetMapping("/{id}")
      public String circuit(@PathVariable("id") Integer id) {
            if (id == -1) throw new RuntimeException("circuit id 不能负数");

            if (id == 999) {
                  try {
                        TimeUnit.SECONDS.sleep(5);
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
            }

            return String.format("Hello, circuit! ID: %s-%s", id, IdUtil.simpleUUID());
      }
}
