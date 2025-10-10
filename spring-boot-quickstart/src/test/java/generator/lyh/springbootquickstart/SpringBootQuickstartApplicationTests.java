//package generator.lyh.springbootquickstart;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import generator.lyh.poji.Mail;
//import generator.lyh.service.SendEmailService;
//
//import javax.annotation.Resource;
//import javax.mail.MessagingException;
//import java.io.UnsupportedEncodingException;
//
//@SpringBootTest
//class SpringBootQuickstartApplicationTests {
//    @Resource
//    private SendEmailService sendEmailService;
//
//    @Test
//    void contextLoads() {
//    }
//
//    @Test
//    void sendEmail() throws MessagingException, UnsupportedEncodingException {
//        Mail mail = new Mail();
//        mail.setTo("2482093410@qq.com");
//        mail.setSubject("测试邮件");
//        mail.setContent("测试邮件内容");
//        sendEmailService.sendEmail(mail);
//    }
//}
