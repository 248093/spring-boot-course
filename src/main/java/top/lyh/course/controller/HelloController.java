package top.lyh.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String index() {
        return "hello";
    }
    @GetMapping("/stringList")
    public List index1() {
        return List.of("1","hello");
    }
}
