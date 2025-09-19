package top.lyh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.lyh.anno.Phone;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber {


    // 使用自定义的Phone注解进行手机号校验
    @Phone(message = "手机号格式不正确，请输入11位有效手机号")
    private String phone;
}

