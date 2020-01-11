package com.revaso.revaso.controllers.s3controllers;

import com.amazonaws.HttpMethod;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Date;

@Component
@PropertySource("classpath:application.yml")
public class S3Util implements InitializingBean {

    @Value("${aws.sdk.bucketName}")
    private String bucketName;

    @Value("${aws.sdk.accessKey}")
    private String accessKey;

    @Value("${aws.sdk.secretAccessKey}")
    private String secretAccessKey;

    @Value("${aws.sdk.region}")
    private String region;

    private BasicAWSCredentials awsCredentials;
    private AmazonS3 amazonS3;


    public String createSignedUrl(String fileName, HttpMethod method) {

        Date expiration = new Date();

        long expirationTimeMillis = expiration.getTime();
        expirationTimeMillis += (1000 * 60);
        expiration.setTime(expirationTimeMillis);

        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, fileName)
                .withMethod(method).withExpiration(expiration);
        URL url = amazonS3.generatePresignedUrl((generatePresignedUrlRequest));

        return url.toString();
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        awsCredentials = new BasicAWSCredentials(accessKey, secretAccessKey);
        amazonS3 = AmazonS3ClientBuilder.standard().withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
    }
}
