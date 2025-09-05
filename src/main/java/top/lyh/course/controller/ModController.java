package top.lyh.course.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModController {
    @Value("${my.mod}")
    private String mod;
    @Value("${my.content}")
    private String content;
    @Value("${my.today}")
    private String today;
    @Value("${my.author}")
    private String author;
    @GetMapping("/mod")
    public String index() {
        return "mod: " + mod + " content: " + content + " today: " + today + " author: " + author;
    }
}
