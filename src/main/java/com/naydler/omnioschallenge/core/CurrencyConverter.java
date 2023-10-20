package com.naydler.omnioschallenge.core;

import org.springframework.stereotype.Component;

@Component  
public class CurrencyConverter {
    private static final Double POUND_RATE_TO_EURO = 1.14D;
    // get price
    public String getConversion(String price) {
        String priceContainer = price.replace("£", "").trim();
        var value = Double.parseDouble(priceContainer);
        return String.format("%.2f", value * POUND_RATE_TO_EURO);
    }
    // remove the currency symbol

}
