package com.my.springcloud.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 表名：tb_pay
 * 表注释：支付交易表
 */
@Data
@TableName(value = "tb_pay")
@Schema(title = "支付交易表实体类")
public class Pay implements Serializable {

      @TableId(type = IdType.AUTO)
      @Schema(title = "主键")
      private Integer id;

      /**
       * 支付流水号
       */
      @TableField(value = "pay_no")
      @Schema(title = "支付流水号")
      private String payNo;

      /**
       * 订单流水号
       */
      @TableField(value = "order_no")
      @Schema(title = "订单流水号")
      private String orderNo;

      /**
       * 用户账号ID
       */
      @TableField(value = "user_id")
      @Schema(title = "用户账号ID")
      private Integer userId;

      /**
       * 交易金额
       */
      @TableField(value = "amount")
      @Schema(title = "交易金额")
      private BigDecimal amount;

      /**
       * 删除标志，默认0不删除，1删除
       */
      private Byte deleted;

      /**
       * 创建时间
       */
      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GMT+8")
      @TableField(value = "create_time")
      @Schema(title = "创建时间")
      private Date createTime;

      /**
       * 更新时间
       */
      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH-mm-ss", timezone = "GMT+8")
      @TableField(value = "update_time")
      @Schema(title = "更新时间")
      private Date updateTime;
}