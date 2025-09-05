package top.lyh.course.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloseAndOpenController {
    @Value("${CloseAndOpen.isClose}")
    private boolean isClose;
    @Value("${CloseAndOpen.CloseMessage}")
    private String CloseMessage;
    @GetMapping("/closeAndOpen")
    public String index() {
        if (isClose) {
            return CloseMessage;
        }
        return "success";
    }
}
