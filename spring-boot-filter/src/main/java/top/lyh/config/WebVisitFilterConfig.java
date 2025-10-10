//package top.lyh.config;
//
//
//import jakarta.servlet.DispatcherType;
//import jakarta.servlet.Filter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.StringUtils;
//import top.lyh.filter.WebVisitFilter;
//
//@Configuration
//public class WebVisitFilterConfig {
//
//    /**
//     * 注册 过滤器 Filter
//     */
//    @Bean
//    public FilterRegistrationBean<Filter> webVisitFilterConfigRegistration() {
//        //匹配拦截 URL
//        String urlPatterns = "/test/*";
//        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
//        registration.setDispatcherTypes(DispatcherType.REQUEST);
//        registration.setFilter(new WebVisitFilter());
//        // 安全地处理 URL 模式（删除重复调用的那一行）
//        String[] patterns = StringUtils.split(urlPatterns, ",");
//        if (patterns != null && patterns.length > 0) {
//            registration.addUrlPatterns(patterns);
//        } else {
//            registration.addUrlPatterns("/test/*"); // 提供默认值
//        }
//
//        //设置名称
//        registration.setName("webVisitFilter");
//        //设置过滤器链执行顺序
//        registration.setOrder(1);
//        //启动标识
//        registration.setEnabled(true);
//        //添加初始化参数
//        registration.addInitParameter("enabel", "true");
//        return registration;
//    }
//}