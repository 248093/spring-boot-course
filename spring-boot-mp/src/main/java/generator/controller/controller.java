package generator.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import generator.pojo.UserAccount;
import generator.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Wrapper;

@RestController
@RequestMapping("/mp")
public class controller {
    @Resource
    private UserAccountService userAccountService;
    @GetMapping("/path/{id}")
    public UserAccount getUserAccount(@PathVariable Long id){
        return userAccountService.getById(id);
    }
    @GetMapping("/param")
    public UserAccount getUserAccount(@RequestParam String nickName){
        QueryWrapper<UserAccount> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("nickName",nickName);
        return userAccountService.getOne(queryWrapper);
    }
    @PostMapping("/post")
    public String postUserAccount(@RequestBody UserAccount userAccount){
        return userAccountService.save(userAccount)?"保存成功":"保存失败";
    }
}
