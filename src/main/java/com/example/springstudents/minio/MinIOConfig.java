package com.example.springstudents.minio;

import io.minio.MinioClient;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinIOConfig {
    @Bean
   public MinioClient minioClient(){
       return MinioClient.builder()
               .endpoint("http://localhost:9000")
               .credentials("minioadmin","minioadmin")
               .build();
   }

}
