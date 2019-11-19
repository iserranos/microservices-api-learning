package com.ey.learning.microservices_api.config;

import com.ey.learning.microservices_api.filter.AuthFilter;
import com.ey.learning.microservices_api.service.impl.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    private final AuthServiceImpl authService;

    @Autowired
    public BeanConfig(AuthServiceImpl authService) {
        this.authService = authService;
    }

    @Bean
    public FilterRegistrationBean<AuthFilter> authFilterFilter(){
        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthFilter(authService));
        registrationBean.addUrlPatterns("/api/v0/customers/*");

        return registrationBean;
    }
}
