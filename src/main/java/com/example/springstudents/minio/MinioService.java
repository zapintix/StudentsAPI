package com.example.springstudents.minio;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@AllArgsConstructor
public class MinioService {

    private final MinioClient minioClient;

    public String uploadFile(MultipartFile file) throws Exception{
        String filename = UUID.randomUUID()+ "_" +file.getOriginalFilename();

        minioClient.putObject(
                PutObjectArgs.builder()
                        .bucket("photo")
                        .object(filename)
                        .stream(file.getInputStream(), file.getSize(), -1)
                        .contentType(file.getContentType()).build()
        );

        return filename;
    }

}
