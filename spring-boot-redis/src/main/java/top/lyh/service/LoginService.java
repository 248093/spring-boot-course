package top.lyh.service;

import org.springframework.stereotype.Service;
import top.lyh.pojo.LoginRequest;
import top.lyh.pojo.LoginResponse;

import java.rmi.ServerException;

@Service
public interface LoginService {
    LoginResponse login(LoginRequest loginRequest) throws ServerException;
}
