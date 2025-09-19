package generator.lyh.course.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import generator.lyh.course.service.SendMessageService;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    private SendMessageService sendMessageService;
    @PutMapping("/sendMessage")
    public String sendMessage(String phone)
    {
        return sendMessageService.sendMessage("19350827764");
    }
}
