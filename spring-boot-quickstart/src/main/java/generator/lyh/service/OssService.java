package generator.lyh.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    public String uploadFile(MultipartFile  file);
}
