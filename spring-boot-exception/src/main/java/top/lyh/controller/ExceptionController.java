package top.lyh.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.lyh.handlerExcepion.BusinessException;
import top.lyh.meEnum.ResultEnum;
import top.lyh.pojo.Result;
import top.lyh.service.ExceptionService;

import javax.annotation.Resource;

@RestController
public class ExceptionController {
    @Resource
    private ExceptionService exceptionService;
    @PostMapping("/exception")
    public Result<String> exception(@RequestParam Integer id) {
        if (id==0){
           return exceptionService.unAuthorizedException();
        } else if (id==1) {
            return exceptionService.systemException();
        }
        int i = 1 / 0;
        return Result.success("操作成功");
    }
}
