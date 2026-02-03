package com.my.springcloud.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * Http状态返回枚举
 *
 * @author javadog
 **/

@Getter
public enum HttpStatusEnum {

      /** 操作成功 */
      SUCCESS(200, "操作成功"),

      /** 对象创建成功 */
      CREATED(201, "对象创建成功"),

      /** 请求已经被接受 */
      ACCEPTED(202, "请求已经被接受"),

      /** 操作已经执行成功，但是没有返回数据 */
      NO_CONTENT(204, "操作已经执行成功，但是没有返回数据"),

      /** 资源已被移除 */
      MOVED_PERM(301, "资源已被移除"),

      /** 重定向 */
      SEE_OTHER(303, "重定向"),

      /** 资源没有被修改 */
      NOT_MODIFIED(304, "资源没有被修改"),

      /** 参数列表错误（缺少，格式不匹配） */
      BAD_REQUEST(400, "参数列表错误（缺少，格式不匹配）"),

      /** 未授权 */
      UNAUTHORIZED(401, "未授权"),

      /** 访问受限，授权过期 */
      FORBIDDEN(403, "访问受限，授权过期"),

      /** 资源，服务未找到 */
      NOT_FOUND(404, "资源，服务未找！"),

      /** 不允许的http方法 */
      BAD_METHOD(405, "不允许的http方法"),

      /** 资源冲突，或者资源被锁 */
      CONFLICT(409, "资源冲突，或者资源被锁"),

      /** 不支持的数据，媒体类型 */
      UNSUPPORTED_TYPE(415, "不支持的数据，媒体类型"),

      /** 系统内部错误 */
      ERROR(500, "系统内部错误"),

      /** 接口未实现 */
      NOT_IMPLEMENTED(501, "接口未实现"),

      /** 系统警告消息 */
      WARN(601, "系统警告消息"),

      RC999(999, "操作XXX失败"),

      RC200(200, "success"),

      RC201(201, "服务开启降级保护,请稍后再试!"),

      RC202(202, "热点参数限流,请稍后再试!"),

      RC203(203, "系统规则不满足要求,请稍后再试!"),

      RC204(204, "授权规则不通过,请稍后再试!"),

      RC403(403, "无访问权限,请联系管理员授予权限"),

      RC401(401, "匿名用户访问无权限资源时的异常"),

      RC404(404, "404页面找不到的异常"),

      RC500(500, "系统异常，请稍后重试"),

      RC375(375, "数学运算异常，请稍后重试"),

      INVALID_TOKEN(2001, "访问令牌不合法"),

      ACCESS_DENIED(2003, "没有权限访问该资源"),

      CLIENT_AUTHENTICATION_FAILED(1001, "客户端认证失败"),

      USERNAME_OR_PASSWORD_ERROR(1002, "用户名或密码错误"),

      BUSINESS_ERROR(1004, "业务逻辑异常"),

      UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式");


      private final Integer code;

      private final String message;

      HttpStatusEnum(Integer code, String message) {
            this.code = code;
            this.message = message;
      }

      //3.遍历
      public static HttpStatusEnum getHttpStatusEnum(Integer code) {
            return Arrays.stream(HttpStatusEnum.values())
                    .filter(s -> s.getCode().equals(code))
                    .findFirst().orElse(null);
      }


}
