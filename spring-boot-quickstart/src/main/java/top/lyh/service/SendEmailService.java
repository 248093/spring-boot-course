package top.lyh.service;

import top.lyh.poji.Mail;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface SendEmailService {
    public void sendEmail(Mail mail) throws MessagingException, UnsupportedEncodingException;
}
