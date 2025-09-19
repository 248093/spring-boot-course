package top.lyh.validator;

import top.lyh.anno.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    
    // 国内手机号正则表达式：1开头，第二位3-9，后面9位数字
    private static final String PHONE_REGEX = "^1[3-9]\\d{9}$";
    
    @Override
    public void initialize(Phone constraintAnnotation) {
        // 初始化方法，可获取注解的属性值
    }
    
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        // 如果手机号为null，视为无效
        if (phoneNumber == null) {
            return false;
        }
        
        // 校验手机号格式
        return phoneNumber.matches(PHONE_REGEX);
    }
}
