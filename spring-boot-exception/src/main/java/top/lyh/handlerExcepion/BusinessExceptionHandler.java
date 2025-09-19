package top.lyh.handlerExcepion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.lyh.meEnum.ResultEnum;
import top.lyh.pojo.Result;

/**
 * @Author: mqxu
 * @Date: 2025/9/19
 * @Description: 业务异常处理器
 * AOP 切面处理
 */
@RestControllerAdvice
@Slf4j
public class BusinessExceptionHandler {

    /**
     * 处理业务异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public Result<String> handleBusinessException(BusinessException e) {
        return Result.fail(e.getResultEnum().getCode(), e.getResultEnum().getMessage());
    }

    /**
     * 处理其他异常
     *
     * @param e
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.fail(500, e.getMessage());
    }

}
