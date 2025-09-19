package top.lyh.anno;

import top.lyh.validator.PhoneValidator;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;

// 注解可以应用的位置：类、方法、字段、参数等
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
// 注解在运行时可见
@Retention(RetentionPolicy.RUNTIME)
// 指定校验器
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {
    // 校验失败时的提示信息
    String message() default "手机号格式不正确";
    
    // 校验结果状态码，0表示成功，1表示失败
    int status() default 1;
    
    // 分组校验
    Class<?>[] groups() default {};
    
    // 负载信息
    Class<? extends Payload>[] payload() default {};
}
