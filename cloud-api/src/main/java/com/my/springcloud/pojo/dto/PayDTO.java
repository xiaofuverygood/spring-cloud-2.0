package com.my.springcloud.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author fsy
 * @Date 2025/3/19 14:11
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayDTO implements Serializable {

      private Integer id;

      /** 支付流水号 */
      private String payNo;

      /** 订单流水号 */
      private String orderNo;

      /** 用户账号ID */
      private Integer userId;

      /** 交易金额 */
      private BigDecimal amount;
}
