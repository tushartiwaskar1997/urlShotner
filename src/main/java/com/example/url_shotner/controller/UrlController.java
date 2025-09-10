package com.example.url_shotner.controller;


import com.example.url_shotner.dto.LongUrlDetails;
import com.example.url_shotner.model.ShortUrlData;
import com.example.url_shotner.service.urlShorterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("")
public class UrlController {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private urlShorterService urlShorterService;

    @GetMapping("/getShortUrlFromLongUrl/{longUrl}")
    public ResponseEntity<ShortUrlData> getTheShortUrlFromLongUlr(@PathVariable String longUrl) {

        return null;

    }



    @GetMapping("/tushar.com/{shortUrl}")
    public ResponseEntity<String> getTheShortUrlDetails(@PathVariable String shortUrl) throws Exception {
        //return ResponseEntity.ok(urlShorterService.getUrl(shortUrl.trim()));
        String redirectUrl =  urlShorterService.getUrl("http://tushar.com/"+shortUrl.trim());
        System.out.println(redirectUrl);
        return ResponseEntity.status(HttpStatus.FOUND).header("location",redirectUrl).build();
        //return ResponseEntity.ok(redirectUrl);
    }

    ;


    @PostMapping("/createShortUrl")
    public ResponseEntity<ShortUrlData> createTheShortUrl(@RequestBody LongUrlDetails longUrlDetails) throws JsonProcessingException {
        // LongUrlDetails  longUrlInfo =  objectMapper.readValue(longUrlDetails, LongUrlDetails.class);
        System.out.println(longUrlDetails.getLongUrlDetails());
        System.out.println(longUrlDetails.getExpiryDate());
        return ResponseEntity.ok(urlShorterService.registerNewUrl(longUrlDetails));
    }
}
