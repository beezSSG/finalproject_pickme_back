package com.pickme.beeze.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;

@RestController
public class S3FileUploadController {

    @Autowired
    private S3Service s3Service;

    @PostMapping("/api/v1/s3upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            // 버킷 이름과 파일 이름 지정
            String fileUrl = s3Service.uploadFile("mypickmebuket", file.getOriginalFilename(), file);
            return ResponseEntity.ok(fileUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("File upload failed");
        }
    }
}
	
