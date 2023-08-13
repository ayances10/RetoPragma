package com.serviceplazoleta.infrastructure.configuration;

import com.serviceplazoleta.infrastructure.configurationfeign.SecurityFeingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final SecurityFeingRequest securityFeingRequest;

    @Autowired
    public WebMvcConfig(SecurityFeingRequest securityFeingRequest) {
        this.securityFeingRequest = securityFeingRequest;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityFeingRequest);
    }
}
