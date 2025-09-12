package top.lyh.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lyh.poji.Mail;
import top.lyh.service.SendEmailService;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Resource
    private SendEmailService sendEmailService;
    @PostMapping("/send")
    public String sendEmail(@RequestBody Mail mail) throws MessagingException, UnsupportedEncodingException {
        sendEmailService.sendEmail(mail);
        return "发送成功";
    }
}
