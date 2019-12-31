package com.instaclustr.springbootdemo.interceptor;

import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class LogInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        UUID requestId = UUID.randomUUID();
        MDC.clear();
        MDC.put("requestId", String.valueOf(requestId));
        return true;
    }
}
