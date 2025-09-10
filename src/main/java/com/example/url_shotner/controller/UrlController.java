package com.example.url_shotner.controller;


import com.example.url_shotner.dto.LongUrlDetails;
import com.example.url_shotner.model.ShortUrlData;
import com.example.url_shotner.service.urlShorterService;
import com.example.url_shotner.utils.AppConstants;
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
    private ResponseEntity<ShortUrlData> getTheShortUrlFromLongUlr(@PathVariable String longUrl) {
        return null;
    }

    @GetMapping("/" + AppConstants.freeDomainName + "{shortUrl}")
    private ResponseEntity<Object> getTheShortUrlDetails(@PathVariable String shortUrl) throws Exception {
       String redirectUrl = urlShorterService.getUrl(AppConstants.freeDomainName + shortUrl.trim());
        return ResponseEntity.status(HttpStatus.FOUND).header(AppConstants.headerLocation, redirectUrl).build();
    }

    @PostMapping("/createShortUrl")
    private ResponseEntity<Object> createTheShortUrl(@RequestBody LongUrlDetails longUrlDetails) throws JsonProcessingException {
        return ResponseEntity.ok(urlShorterService.registerNewUrl(longUrlDetails));
    }
}
