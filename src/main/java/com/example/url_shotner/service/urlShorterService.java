package com.example.url_shotner.service;

import com.example.url_shotner.dto.LongUrlDetails;
import com.example.url_shotner.model.ShortUrlData;
import com.example.url_shotner.utils.AppConstants;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class urlShorterService implements ulrShorterInterface {

    ConcurrentHashMap<String, ShortUrlData> urlData = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, String> longUrlToShortUlrMap = new ConcurrentHashMap<>();

    @Override
    public ShortUrlData registerNewUrl(LongUrlDetails longUrlDetails) {
        ShortUrlData newShotUrl = new ShortUrlData();
        newShotUrl.setShortUlr(generateTheShortUrl(longUrlDetails.getLongUrlDetails()));
        newShotUrl.setExpiryDate(longUrlDetails.getExpiryDate());
        newShotUrl.setLongUrl(longUrlDetails.getLongUrlDetails());
        newShotUrl.setVisitCount(0L);
        urlData.put(newShotUrl.getShortUlr(), newShotUrl);
        longUrlToShortUlrMap.put(longUrlDetails.getLongUrlDetails(), newShotUrl.getShortUlr());
        return newShotUrl;
    }

    @Override
    public String registerNewUrl(String longUrl, String shortUrl) {
        return "";
    }

    @Override
    public boolean checkIfCurrentShortUrlPresentOrNotForGivenLongUlr(String longUrl) {
        if (longUrlToShortUlrMap.containsKey(longUrl)) {
            return true;
        }
        return false;
    }

    @Override
    public String getUrl(String shortUrl) throws Exception {
        if (urlData.containsKey(shortUrl.trim())) {
            ShortUrlData shortUrlData = urlData.get(shortUrl.trim());
            shortUrlData.setVisitCount(urlData.get(shortUrl.trim()).getVisitCount() + 1L);
            urlData.put(shortUrl.trim(), shortUrlData);
            return AppConstants.http + shortUrlData.getLongUrl();
        } else {
            throw new Exception("the record not found");
        }
    }

    @Override
    public Integer getHitCount(String shortUrl) {
        return 0;
    }

    @Override
    public String delete(String shortUrl) {
        return "";
    }

    public String generateTheShortUrl(String longUrl) {
        String stringForEncoding = AppConstants.helperStringForEncoding;
        StringBuilder newUrl = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i <= 7; i++) {
            int charPosition = random.nextInt(stringForEncoding.length());
            newUrl.append(stringForEncoding.charAt(charPosition));
        }
        return AppConstants.freeDomainName + newUrl;
    }
}
