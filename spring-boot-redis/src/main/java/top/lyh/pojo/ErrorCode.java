package top.lyh.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    SMS_SEND_FAILED("短信发送失败", "1001"),
    SMS_TEMPLATE_NOT_FOUND("短信模板不存在", "1002"),
    SMS_PROVIDER_ERROR("短信服务商异常", "1003"),
    SMS_PHONE_ERROR("手机校验失败", "1004"),
    SYSTEM_SERVICE_FAILED("系统服务失败", "2001"),
    SYSTEM_TIMEOUT("系统超时", "2002"),
    SYSTEM_BUSY("系统繁忙", "2003");
    private final String msg;
    private final String code;
}
