package com.example.url_shotner.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class ShortUrlData {
    private String  shortUlr;
    private Long  visitCount;
    private LocalDate expiryDate;
    private String longUrl;

    @Override
    public String toString() {
        return "ShortUrlData{" +
                "shortUlr='" + shortUlr + '\'' +
                ", visitCount=" + visitCount +
                ", expiryDate=" + expiryDate +
                ", longUrl='" + longUrl + '\'' +
                '}';
    }

    public String getShortUlr() {
        return shortUlr;
    }

    public void setShortUlr(String shortUlr) {
        this.shortUlr = shortUlr;
    }

    public Long getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Long visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
