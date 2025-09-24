package top.lyh.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.lyh.pojo.Result;
import top.lyh.service.SendMessageService;
import top.lyh.validatio.PhoneNumber;

import javax.annotation.Resource;

@RestController
@Validated
public class SendMessageController {
    @Resource
    private SendMessageService sendMessageService;
    @PutMapping("/sendMessage")
    public Result<String> sendMessage(@PhoneNumber @RequestParam String phone)
    {
        return sendMessageService.sendMessage(phone);
    }
}
