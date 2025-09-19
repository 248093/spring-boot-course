package top.lyh.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lyh.anno.Phone;
import top.lyh.pojo.PhoneNumber;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class PhoneController {
    /**
     * 测试参数校验
     */
    @PostMapping("/phone")
    public Map<String, Object> checkPhone(@Valid @RequestBody PhoneNumber phone) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "手机号格式正确");
        result.put("phone", phone);
        return result;
    }
}
