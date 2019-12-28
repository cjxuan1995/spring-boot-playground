package com.instaclustr.springbootdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("instaclustr")
public class InstaclustrConfig {
    private String customConfig = "default config";

    public String getCustomConfig() {
        return customConfig;
    }

    public void setCustomConfig(final String customConfig) {
        this.customConfig = customConfig;
    }
}
