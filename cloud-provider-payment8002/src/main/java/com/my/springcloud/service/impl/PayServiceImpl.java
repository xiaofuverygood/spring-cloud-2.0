package com.my.springcloud.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.springcloud.dao.PayMapper;
import com.my.springcloud.pojo.entity.Pay;
import com.my.springcloud.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2025/3/4 16:45
 */
@Service
@RequiredArgsConstructor
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay> implements PayService {

      private final PayMapper payMapper;

      @Override
      public int add(Pay pay) {
            return payMapper.insert(pay);
      }

      @Override
      public int delete(Integer id) {
            return payMapper.delete(Wrappers.<Pay>lambdaQuery().eq(Pay::getId, id));
      }

      @Override
      public int update(Pay pay) {
            return payMapper.update(pay, Wrappers.<Pay>lambdaQuery().eq(Pay::getId, pay.getId()));
      }

      @Override
      public Pay getById(Integer id) {
            return  payMapper.selectById(id);
      }

      @Override
      public List<Pay> getAll() {
            return payMapper.selectList(null);
      }
}
