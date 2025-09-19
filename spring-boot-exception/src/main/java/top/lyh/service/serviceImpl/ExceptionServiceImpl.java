package top.lyh.service.serviceImpl;

import org.springframework.stereotype.Service;
import top.lyh.handlerExcepion.BusinessException;
import top.lyh.meEnum.ResultEnum;
import top.lyh.pojo.Result;
import top.lyh.service.ExceptionService;

@Service
public class ExceptionServiceImpl implements ExceptionService {
    @Override
    public Result<String> systemException() {
        throw new BusinessException(ResultEnum.SYSTEM_ERROR);
    }

    @Override
    public Result<String> unAuthorizedException() {
        throw new BusinessException(ResultEnum.PERMISSION_UNAUTHENTICATED);
    }
}
