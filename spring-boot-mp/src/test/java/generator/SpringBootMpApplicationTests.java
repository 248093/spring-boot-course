package generator;

import generator.pojo.UserAccount;
import generator.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
class SpringBootMpApplicationTests {
    @Resource
    private UserAccountService userAccountService;

    @Test
    void contextLoads() {
    }
    @Test
    void test() {
        UserAccount byId = userAccountService.getById(1L);
        System.out.println(byId);
    }
    @Test
    void test2() {
//     插入数据测试
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("lyh");
        userAccount.setNickname("lyh");
        userAccount.setEmail("<EMAIL>");
        userAccount.setPhone("12345678901");
        userAccount.setStatus(1);
        userAccount.setDeleted(0);
        userAccountService.save(userAccount);
        log.info("插入数据成功：{}", userAccount);
    }

}
