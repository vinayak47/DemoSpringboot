package com.example.demo.s3;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class S3Service {
	
	
	 @Autowired
	    private AmazonS3 amazonS3;

	    @Value("${aws.s3.bucketName}")
	    private String bucketName;
	
	public String uploadFile(MultipartFile file) throws IOException {
        String key = file.getOriginalFilename();
        amazonS3.putObject(new PutObjectRequest(bucketName, key, file.getInputStream(), null));
        return amazonS3.getUrl(bucketName, key).toString();
    }

}
