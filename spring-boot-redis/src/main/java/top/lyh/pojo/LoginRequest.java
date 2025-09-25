package top.lyh.pojo;

import lombok.Data;
import top.lyh.validatio.PhoneNumber;

@Data
public class LoginRequest {
    @PhoneNumber
    private String phone;
    private String code;
}
