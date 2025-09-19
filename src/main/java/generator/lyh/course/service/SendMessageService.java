package generator.lyh.course.service;

import org.springframework.stereotype.Service;

@Service
public interface SendMessageService {
    public String sendMessage(String phone);
}
