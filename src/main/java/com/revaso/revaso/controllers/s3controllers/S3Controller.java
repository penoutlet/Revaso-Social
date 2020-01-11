package com.revaso.revaso.controllers.s3controllers;

import com.amazonaws.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@CrossOrigin
@RestController
public class S3Controller {
    private S3Util s3Util;
    public S3Controller(S3Util s3Util) {
        this.s3Util = s3Util;
    }

    @PutMapping("s3/{fileName}")
    public String createSignedPutUrl(@PathVariable String fileName) {
        System.out.println("Inside of S3Util, PutMapping");
        return s3Util.createSignedUrl(fileName, HttpMethod.PUT);
    }

    @GetMapping("s3/{fileName}")
    public String createSignedGetUrl(@PathVariable String fileName) {

        return s3Util.createSignedUrl(fileName, HttpMethod.GET);
    }
}
