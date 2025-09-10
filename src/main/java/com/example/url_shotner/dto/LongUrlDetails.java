package com.example.url_shotner.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Data
@Setter
public class LongUrlDetails {
    private String longUrlDetails;
    private LocalDate expiryDate;

    public void setLongUrlDetails(String longUrlDetails) {
        this.longUrlDetails = longUrlDetails;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getLongUrlDetails() {
        return longUrlDetails;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "LongUrlDetails{" +
                "longUrlDetails='" + longUrlDetails + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}

