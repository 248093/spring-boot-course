//package generator.lyh.service.serviceImpl;
//
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import generator.lyh.poji.Mail;
//import generator.lyh.service.SendEmailService;
//
//import javax.annotation.Resource;
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.UnsupportedEncodingException;
//
//@Service
//public class SendEmailServiceImpl implements SendEmailService {
//    @Resource
//    private JavaMailSender javaMailSender;;
//    @Override
//    public void sendEmail(Mail mail) throws MessagingException, UnsupportedEncodingException {
//        MimeMessage message = javaMailSender.createMimeMessage();
//        // 创建 MimeMessageHelper
//        MimeMessageHelper helper = new MimeMessageHelper(message, false);
//        // 发件人邮箱和名称
//        helper.setFrom("2482093410@qq.com", "happiness");
//        // 收件人邮箱
//        helper.setTo(mail.getTo());
//        // 邮件标题
//        helper.setSubject(mail.getSubject());
//        // 邮件正文，第二个参数表示是否是HTML正文
//        helper.setText(mail.getContent(), true);
//
//        // 发送
//        javaMailSender.send(message);
//
//    }
//}
