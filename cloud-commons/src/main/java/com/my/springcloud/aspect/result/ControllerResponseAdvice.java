package com.my.springcloud.aspect.result;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.springcloud.annotations.NotControllerResponseAdvice;
import com.my.springcloud.result.ResponseResult;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description 统一响应
 * @Author fsy
 * @Date 2024/1/4 09:15
 */
@RestControllerAdvice(basePackages = {"com"})
public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {
      @Override
      public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return !(methodParameter.getParameterType().isAssignableFrom(ResponseResult.class)
                    || methodParameter.hasMethodAnnotation(NotControllerResponseAdvice.class));
      }

      @Override
      @SneakyThrows
      public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType,
                                    Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
            // String类型不能直接包装
            if (returnType.getGenericParameterType().equals(String.class)) {
                  response.getHeaders().setContentType(MediaType.APPLICATION_JSON); // 设置 Content-Type
                  return new ObjectMapper().writeValueAsString(ResponseResult.success(data)); // 将数据包装在ResponseResult里后转换为json串进行返回

            }
            return ResponseResult.success(data);
      }
}