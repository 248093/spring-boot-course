//package top.lyh.filter;
//
//import jakarta.servlet.*;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//
//@Slf4j
//public class WebVisitFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info("初始化过滤器");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        // 业务处理
//        log.info("进入处理器");
//        log.info("开始处理请求");
//        chain.doFilter(request, response);
//        log.info("处理请求结束");
//        log.info("请求处理完毕");
//    }
//
//    @Override
//    public void destroy() {
//        log.info("销毁过滤器");
//    }
//}