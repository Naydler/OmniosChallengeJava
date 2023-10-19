package com.naydler.omnioschallenge.core;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;
import org.springframework.stereotype.Component;

@Component
public class CurrencyConverter {
    //get price
    public String getConversion(String price) {
        String priceContainer = price.replace("£", "").trim();
    
    MonetaryAmount value = Monetary.getDefaultAmountFactory().setCurrency("GBP")
        .setNumber(Double.parseDouble(priceContainer)).create();

    CurrencyConversion conversionEUR = MonetaryConversions.getConversion("EUR");

    MonetaryAmount convertedAmountUSDtoEUR = value.with(conversionEUR);

    return convertedAmountUSDtoEUR.toString();

    }
    //remove the currency symbol
    
    
}
