package top.lyh.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.lyh.interceptor.BusinessLogInterceptor;
import top.lyh.interceptor.RoleAuthInterceptor;
import top.lyh.interceptor.TimeStatInterceptor;

@Configuration
@AllArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
    private final TimeStatInterceptor timeStatInterceptor;
    private final BusinessLogInterceptor businessLogInterceptor;
    private final RoleAuthInterceptor roleAuthInterceptor;

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("http://localhost:5173");
        config.addAllowedHeader("*");          // 允许所有请求头
        config.addAllowedMethod("*");          // 允许所有方法
        config.addExposedHeader("token");      // 暴露 token 给前端
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册耗时统计拦截器，此处省略
        // 注册业务日志拦截器，此处省略
        // 注册权限拦截器
        registry.addInterceptor(roleAuthInterceptor)
                .addPathPatterns("/api/**")
                // 注册登录接口不拦截
                .excludePathPatterns("/user/login", "/user/register")
                // 晚于 TimeStatInterceptor 执行
                .order(3);
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders(
                        "Content-Type",
                        "Authorization",
                        "X-Requested-With",
                        "Accept",
                        "Origin",
                        "token"
                )
                .exposedHeaders("token")
                .allowCredentials(true)
                .maxAge(3600);
    }



}