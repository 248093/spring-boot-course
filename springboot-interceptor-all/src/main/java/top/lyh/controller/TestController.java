package top.lyh.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lyh.entity.Result;

@RestController
@Slf4j
public class TestController{
    @GetMapping("/pay/{id}")  // 路径改为 /api/pay/{id}
    public Result<String> pay(@PathVariable long id) {
        log.info("开始支付");
        return Result.success("支付成功，订单号：" + id);
    }
}
