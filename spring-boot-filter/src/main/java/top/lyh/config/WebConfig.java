package top.lyh.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.lyh.interceptor.LogInterceptor;
import top.lyh.interceptor.NewLogInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/hello","/hello/*");
        registry.addInterceptor(new NewLogInterceptor()).addPathPatterns("/hello","/test/*");
    }
}