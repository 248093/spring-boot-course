package top.lyh.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.lyh.enumm.DrinkType;

@RestController
public class DrinkController {
    @GetMapping("/drink/{type}")
    public ResponseEntity<String> getDrink(@PathVariable("type") DrinkType type) {
        return ResponseEntity.ok("您选择的是：" + type.getDescription());
    }
}
