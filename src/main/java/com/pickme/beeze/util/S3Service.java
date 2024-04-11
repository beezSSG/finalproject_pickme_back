package com.pickme.beeze.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@PropertySource("classpath:key.properties")
public class S3Service {

    private AmazonS3 s3Client;

    @Value("${cloud.aws.credentials.access-key}")
    private String accessKeyId;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;
    
    @PostConstruct
    private void InitAws() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretKey);
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }
    
//    public S3Service() {
//        BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKeyId, secretKey);
//        this.s3Client = AmazonS3ClientBuilder.standard()
//                .withRegion(region)
//                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//                .build();
//    }

    public String uploadFile(String bucketName, String keyName, MultipartFile file) throws IOException {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = "upload/" + fileObj.getName(); // 파일 저장 경로 및 이름 지정
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        fileObj.delete(); // 임시 파일 삭제
        return s3Client.getUrl(bucketName, fileName).toString(); // 업로드된 파일의 URL 반환
    }

    private File convertMultiPartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(System.getProperty("java.io.tmpdir")+"/"+file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        }
        return convertedFile;
    }
}