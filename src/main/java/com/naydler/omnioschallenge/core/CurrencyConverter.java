package com.naydler.omnioschallenge.core;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

@Component  
public class CurrencyConverter {
    private static final BigDecimal POUND_RATE_TO_EURO = new BigDecimal(1.14);
    // get price
    public BigDecimal getConversion(String price) {
        String priceContainer = price.replace("£", "").trim();
        var value = new BigDecimal(priceContainer);
        return (value.multiply(POUND_RATE_TO_EURO).setScale(2, RoundingMode.HALF_DOWN));
    }
    // remove the currency symbol

}
