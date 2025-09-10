package com.example.url_shotner.service;

import com.example.url_shotner.dto.LongUrlDetails;
import com.example.url_shotner.model.ShortUrlData;

public interface ulrShorterInterface {

    ShortUrlData registerNewUrl(LongUrlDetails longUrlDetails);
    String registerNewUrl(String longUrl, String shortUrl);

    boolean checkIfCurrentShortUrlPresentOrNotForGivenLongUlr(String shortUrl);
    
    String getUrl(String shortUrl) throws Exception;
    Integer getHitCount(String longUrl);
    String delete(String longUrl);


}
