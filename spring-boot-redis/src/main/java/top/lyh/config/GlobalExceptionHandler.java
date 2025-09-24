package top.lyh.config;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.lyh.pojo.ErrorCode;
import top.lyh.pojo.Result;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理请求参数校验异常（@Validated 作用于对象时）
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new Result<>(1, ErrorCode.SYSTEM_SERVICE_FAILED.getMsg(), errors);
    }

    /**
     * 处理请求参数校验异常（@Valid 作用于对象时）
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Map<String, String>> handleBindException(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new Result<>(1, ErrorCode.SYSTEM_SERVICE_FAILED.getMsg(), errors);
    }

    /**
     * 处理请求参数校验异常（@Validated 作用于方法参数时）
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        Map<String, Object> result = new HashMap<>();

        for (ConstraintViolation<?> violation : violations) {
            // 检查是否是手机号验证失败
            if (violation.getMessage().contains("手机号")) {
                result.put("code", ErrorCode.SMS_PHONE_ERROR.getCode());
                result.put("msg", ErrorCode.SMS_PHONE_ERROR.getMsg());
                result.put("detail", violation.getMessage());
                return new Result<>(1, ErrorCode.SMS_PHONE_ERROR.getMsg(), result);
            }
        }

        // 如果不是手机号验证失败，则使用通用处理
        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : violations) {
            String fieldName = violation.getPropertyPath().toString();
            String errorMessage = violation.getMessage();
            errors.put(fieldName, errorMessage);
        }
        result.put("errors", errors);
        return new Result<>(1, ErrorCode.SYSTEM_SERVICE_FAILED.getMsg(), result);
    }

    /**
     * 处理其他未捕获的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> handleException(Exception e) {
        return new Result<>(1, ErrorCode.SYSTEM_SERVICE_FAILED.getMsg() + ": " + e.getMessage(), null);
    }
}
