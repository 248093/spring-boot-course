package top.lyh.service;

import top.lyh.pojo.Result;

public interface ExceptionService {
    Result<String> systemException();
    Result<String> unAuthorizedException();
}
