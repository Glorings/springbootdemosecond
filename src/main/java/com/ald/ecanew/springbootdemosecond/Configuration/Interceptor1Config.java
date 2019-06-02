package com.ald.ecanew.springbootdemosecond.Configuration;

import com.ald.ecanew.springbootdemosecond.interceptor.Interceptor1;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Interceptor1Config implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration i = registry.addInterceptor(new Interceptor1());
        i.addPathPatterns("/**").excludePathPatterns("/hello2");
    }
}