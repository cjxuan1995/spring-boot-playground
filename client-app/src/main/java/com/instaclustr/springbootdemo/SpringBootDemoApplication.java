package com.instaclustr.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
public class SpringBootDemoApplication extends SpringBootServletInitializer{
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
