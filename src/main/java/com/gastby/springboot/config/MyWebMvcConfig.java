package com.gastby.springboot.config;

import com.gastby.springboot.interceptors.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer getWebMvcConfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login", "/", "/user/login", "/webjars/**", "/success", "/hello", "/files/**");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/main").setViewName("main");
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/bars").setViewName("common/bars");
            }
        };
        return configurer;
    }

}
