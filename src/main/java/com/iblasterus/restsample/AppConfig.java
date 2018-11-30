package com.iblasterus.restsample;

import com.iblasterus.restsample.logging.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class AppConfig {
    @Bean
    public FilterRegistrationBean logFilterRegistration() {
        var registration = new FilterRegistrationBean();
        registration.setFilter(logFilter());
        registration.addUrlPatterns("/*");
        registration.setName("logFilter");
        registration.setOrder(1);
        return registration;
    }

    public Filter logFilter() {
        return new LogFilter();
    }
}
