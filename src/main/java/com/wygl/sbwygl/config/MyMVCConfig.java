package com.wygl.sbwygl.config;

import com.wygl.sbwygl.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class  MyMVCConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/images/**","/css/**","/login");
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/carImage/**").addResourceLocations("file:D:/Open4java/OpenSources/wygl/源代码/sbwygl/src/main/resources/static/upload/carImage/");
    }
}
