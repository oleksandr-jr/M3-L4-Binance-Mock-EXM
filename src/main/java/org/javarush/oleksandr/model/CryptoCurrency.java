package org.javarush.oleksandr.model;

import java.math.BigDecimal;

public class CryptoCurrency {

    private String currencyName;
    private String pair;
    private BigDecimal price;

    public CryptoCurrency(String currencyName, String pair, BigDecimal price) {
        this.currencyName = currencyName;
        this.pair = pair;
        this.price = price;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CryptoCurrency{" +
                "currencyName='" + currencyName + '\'' +
                ", pair='" + pair + '\'' +
                ", price=" + price +
                '}';
    }
}
