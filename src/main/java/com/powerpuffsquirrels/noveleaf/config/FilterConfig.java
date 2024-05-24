package com.powerpuffsquirrels.noveleaf.config;

import com.powerpuffsquirrels.noveleaf.Filters.LoginConditionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<LoginConditionFilter> loginFilter(){
        FilterRegistrationBean<LoginConditionFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoginConditionFilter());
        registrationBean.addUrlPatterns("*");
        return registrationBean;
    }

}
