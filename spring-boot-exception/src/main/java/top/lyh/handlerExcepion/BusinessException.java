package top.lyh.handlerExcepion;

import lombok.Getter;
import top.lyh.meEnum.ResultEnum;

@Getter
public class BusinessException extends RuntimeException{
    private final ResultEnum resultEnum;

    public BusinessException(ResultEnum resultEnum) {
        this.resultEnum = resultEnum;
    }
}
