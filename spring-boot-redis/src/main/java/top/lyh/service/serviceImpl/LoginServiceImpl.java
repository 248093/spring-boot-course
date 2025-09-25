package top.lyh.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lyh.pojo.LoginRequest;
import top.lyh.pojo.LoginResponse;
import top.lyh.service.LoginService;
import top.lyh.utils.RedisUtil;
import top.lyh.validatio.PhoneNumberValidator;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.rmi.ServerException;
import java.util.UUID;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private RedisUtil redisUtil;


    @Override
    public LoginResponse login(@Valid LoginRequest loginRequest) throws ServerException {
        String phone = loginRequest.getPhone();
        String code = loginRequest.getCode();
        if (code == null || code.trim().isEmpty()){
            throw new ServerException("验证码不能为空");
        }
        String redisKey="phone:"+phone;
        String redisCode = redisUtil.get(redisKey).toString();
        if (redisCode == null)
            throw new ServerException("验证码已过期");
        if (!redisCode.equals(code))
            throw new ServerException("验证码错误");
        String token = generateToken(phone);
        log.info("用户{}登录成功", phone);
        return new LoginResponse(token, phone, "登录成功");
    }
    private String generateToken(String phone) {
        return UUID.randomUUID().toString().replace("-", "") + phone.hashCode();
    }
}
