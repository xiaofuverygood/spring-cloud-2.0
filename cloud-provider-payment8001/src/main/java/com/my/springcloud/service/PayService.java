package com.my.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.my.springcloud.pojo.entity.Pay;

import java.util.List;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2025/3/4 16:45
 */
public interface PayService extends IService<Pay> {
      int add(Pay pay);

      int delete(Integer id);

      int update(Pay pay);

      Pay getById(Integer id);

      List<Pay> getAll();
}
