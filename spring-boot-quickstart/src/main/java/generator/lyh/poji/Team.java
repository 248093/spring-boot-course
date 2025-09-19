package generator.lyh.poji;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Data
@Component
public class Team {
    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 3,max = 5)
    @Value("${team.name}")
    private String name;
    @Value("${team.age}")
    @Pattern(regexp = "^[1-19]\\d*$", message = "年龄格式有误")
    private String age;
    @Value("${team.leader}")
    private String leader;
    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    @Value("${team.phone}")
    private String phone;

}
