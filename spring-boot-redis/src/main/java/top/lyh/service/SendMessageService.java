package top.lyh.service;

import org.springframework.stereotype.Service;
import top.lyh.pojo.Result;
import top.lyh.validatio.PhoneNumber;

@Service
public interface SendMessageService {
    public Result<String> sendMessage(@PhoneNumber String phone);
}
