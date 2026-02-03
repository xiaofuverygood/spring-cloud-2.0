package com.my.springcloud.aspect.exception;

import com.my.springcloud.enums.HttpStatusEnum;
import com.my.springcloud.result.ResponseResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

/**
 * @Description 全局异常
 * @Author fsy
 * @Date 2023/12/29 15:46
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {

      /**
       * 权限校验异常
       */
      @ExceptionHandler(MissingServletRequestParameterException.class)
      public ResponseResult handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
            String requestURI = request.getRequestURI();
            log.error("请求地址'{}',请求参数错误'{}'", requestURI, e.getMessage());
            return ResponseResult.fail(HttpStatusEnum.BAD_REQUEST.getCode(), HttpStatusEnum.BAD_REQUEST.getMessage());
      }

      /**
       * 请求方式不支持
       */
      @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
      public ResponseResult handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                                HttpServletRequest request) {
            String requestURI = request.getRequestURI();
            log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
            return ResponseResult.fail(e.getMessage());
      }

      /**
       * 数据绑定异常
       */
      @ExceptionHandler(BindException.class)
      public ResponseResult handleBindException(BindException e) {
            log.error(e.getMessage(), e);
            String message = e.getAllErrors().get(0).getDefaultMessage();
            return ResponseResult.fail(message);
      }

      /**
       * 拦截未知的运行时异常
       */
      @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
      @ExceptionHandler(RuntimeException.class)
      public ResponseResult handleRuntimeException(RuntimeException e, HttpServletRequest request) {
            String requestURI = request.getRequestURI();
            log.error("请求地址'{}',发生未知异常.", requestURI, e);
            return ResponseResult.fail(e.getMessage());
      }

      /**
       * 系统异常
       */
      @ExceptionHandler(Exception.class)
      public ResponseResult handleException(Exception e, HttpServletRequest request) {
            String requestURI = request.getRequestURI();
            log.error("请求地址'{}',发生系统异常.", requestURI, e);
            return ResponseResult.fail();
      }
}