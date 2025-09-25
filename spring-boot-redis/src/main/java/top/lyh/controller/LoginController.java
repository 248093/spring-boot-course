package top.lyh.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.lyh.pojo.LoginRequest;
import top.lyh.pojo.LoginResponse;
import top.lyh.pojo.Result;
import top.lyh.service.LoginService;

import javax.annotation.Resource;
import java.rmi.ServerException;

@RestController
public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    // 接收请求体中的JSON数据并绑定到LoginRequest对象，返回Result包装的LoginResponse结果
    public Result<LoginResponse> login(@RequestBody LoginRequest loginRequest) throws ServerException {
        // 调用loginService的login方法处理登录请求，获取登录响应结果
        LoginResponse loginResponse = loginService.login(loginRequest);
        // 将登录响应结果包装成成功的Result并返回
        return Result.success(loginResponse);
    }
}
