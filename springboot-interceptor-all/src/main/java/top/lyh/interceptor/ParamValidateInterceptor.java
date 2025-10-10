package top.lyh.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import top.lyh.dto.LoginRequest;
import top.lyh.entity.Result;

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author moqi
 */
@Component
@Slf4j
public class ParamValidateInterceptor implements HandlerInterceptor {
    // 校验器（单例）
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("进入 ParamValidateInterceptor，URL: {}, Method: {}, ContentType: {}",
                request.getRequestURL(), request.getMethod(), request.getContentType());

        try {
            // 1. 获取请求参数（仅处理POST JSON）
            if ("POST".equalsIgnoreCase(request.getMethod()) && request.getContentType() != null
                    && request.getContentType().contains("application/json")) {
                log.info("开始处理POST JSON请求");

                // 读取请求体
                CachedBodyHttpServletRequest cachedRequest = new CachedBodyHttpServletRequest(request);
                String body = cachedRequest.getBody();
                log.info("读取到请求体: {}", body);

                if (StringUtils.hasText(body)) {
                    try {
                        // 2. 转换为实体类
                        LoginRequest loginRequest = objectMapper.readValue(body, LoginRequest.class);
                        log.info("JSON解析成功: username={}, password={}",
                                loginRequest.getUsername(), loginRequest.getPassword() != null ? "***" : "null");

                        // 3. 执行校验
                        Set<ConstraintViolation<LoginRequest>> violations = VALIDATOR.validate(loginRequest);
                        log.info("校验完成，违反约束数量: {}", violations.size());

                        if (!violations.isEmpty()) {
                            // 4. 校验失败处理
                            String errorMsg = violations.stream()
                                    .map(ConstraintViolation::getMessage)
                                    .collect(Collectors.joining("; "));
                            log.info("校验失败: {}", errorMsg);
                            response.setContentType("application/json;charset=UTF-8");
                            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                            response.getWriter().write(objectMapper.writeValueAsString(Result.error(errorMsg)));
                            return false;
                        }
                    } catch (Exception e) {
                        log.error("JSON解析或校验异常", e);
                        response.setContentType("application/json;charset=UTF-8");
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                        response.getWriter().write(objectMapper.writeValueAsString(Result.error("请求数据格式错误: " + e.getMessage())));
                        return false;
                    }
                } else {
                    log.warn("请求体为空");
                }
            } else {
                log.info("非POST JSON请求，跳过校验");
            }
        } catch (Exception e) {
            log.error("ParamValidateInterceptor 处理异常", e);
            // 不应该因为拦截器异常阻止请求
        }

        log.info("ParamValidateInterceptor 处理完成，放行请求");
        return true;
    }



    // 缓存请求体的包装类
    // 缓存请求体的包装类
    // 缓存请求体的包装类
    @Getter
    static class CachedBodyHttpServletRequest extends HttpServletRequestWrapper {
        private final String body;
        private final byte[] cachedBody;

        public CachedBodyHttpServletRequest(HttpServletRequest request) throws IOException {
            super(request);
            this.cachedBody = request.getInputStream().readAllBytes();
            this.body = new String(cachedBody);
            log.info("CachedBodyHttpServletRequest 初始化完成，缓存数据长度: {}", cachedBody.length);
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            log.info("getInputStream() 被调用");
            return new DelegatingServletInputStream(new ByteArrayInputStream(cachedBody));
        }

        @Override
        public BufferedReader getReader() throws IOException {
            log.info("getReader() 被调用");
            return new BufferedReader(new InputStreamReader(getInputStream(), getCharacterEncoding()));
        }

        // 内部类实现 ServletInputStream
        private static class DelegatingServletInputStream extends ServletInputStream {
            private final InputStream delegate;
            private boolean finished = false;

            public DelegatingServletInputStream(InputStream delegate) {
                this.delegate = delegate;
            }

            @Override
            public boolean isFinished() {
                return finished;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
                // 不实现
            }

            @Override
            public int read() throws IOException {
                int data = delegate.read();
                if (data == -1) {
                    finished = true;
                }
                return data;
            }
        }
    }


}