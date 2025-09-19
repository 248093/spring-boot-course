package generator.lyh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import generator.lyh.service.serviceImpl.QrCodeServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

@RestController("/generate")
public class QRController {
    @Autowired
    private QrCodeServiceImpl qrCodeService;

    //生成二维码并将其返回给前端调用者_hutool
    @PostMapping("/v3")
    public ResponseEntity<byte[]> generateV3(String content, HttpServletResponse servletResponse){
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        qrCodeService.createCodeToStream(content,servletResponse);
        byte[] bytes=bos.toByteArray();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(bytes,headers, HttpStatus.OK);
    }
}
