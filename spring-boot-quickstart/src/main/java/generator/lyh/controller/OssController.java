package generator.lyh.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import generator.lyh.service.OssService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/oss")
public class OssController {
    @Resource
    private OssService ossService;
    @PostMapping("/upload")
    public String upload(MultipartFile  file){
        return ossService.uploadFile(file);
    }
}
